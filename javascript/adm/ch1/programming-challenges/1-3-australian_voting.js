const fs = require('fs');
const readline = require('readline');
const { getSystemErrorMap } = require('util');

const vote = (election) => {
    election.isTied = false;
    for(let i = 0; i < election.candidates.length; i++) {
        election.currentCandidates.set(i, election.candidates[i]);
    }
    return voteHelper(election);
}
const voteHelper = (election) => {
    if(election.currentCandidates.size <= 1 || election.isTied) {
        let returnString = "";
        for(candidateObject of election.currentCandidates.values()) {
            returnString += candidateObject.name + "\n";
        } 
        returnString = returnString.trim();
        return returnString;
    }
    for(let candidateObject of election.currentCandidates.values()) {
        candidateObject.votes = 0;
    }
    for(let ballot of election.ballots){
        // loop through individual ballot(split string and parseint) and add votes to each candidate still in it
        for(let i = 0; i < 5; i += 2){
            const candidate = election.currentCandidates.get(parseInt(ballot[i] - 1));
            if (candidate == null) continue;
            candidate.votes++;
            break;
        }
    }
    // loop through current candidates and find those with least.  Remove lowest if not all tied.
    let lowestVotes = Infinity;
    let highestVotes = -1;
    const candidatesWithLowest = [];
    for(let cand of election.currentCandidates.values()) {
        if(cand.votes < lowestVotes) lowestVotes = cand.votes;
        if(cand.votes > highestVotes) highestVotes = cand.votes;
    }
    
    for(let entry of election.currentCandidates.entries()) {
        if(entry[1].votes <= lowestVotes) {
            candidatesWithLowest.push(entry[1]);
            election.currentCandidates.delete(entry[0]);
            // console.log(entry[1]);
        }
     }

    // If all tied, toggle tied value and recursively call.  Either way, then call recursvively
    if(election.currentCandidates.size < 1) {
        election.isTied = true;
        let i = 0;
        for(let cand of candidatesWithLowest){
            election.currentCandidates.set(i, cand);
            i++;
        }
    }
    // Check if 50% threshhold has been met, if so, remove non-winners
    if(highestVotes > election.ballots.length /2 && election.currentCandidates.size > 1) {
        for(let entry of election.currentCandidates.entries()) {
            if(entry[1].votes != highestVotes) {
                election.currentCandidates.delete(entry[0]);
            }
         }
        //  console.log("\n******SPECIAL CASE*******");
        //  console.log(election.currentCandidates);
        //  console.log("******\n");
    }
    return voteHelper(election);
}

const getReadlineInterface = (filePath) => {
    return readline.createInterface({
        input: fs.createReadStream(filePath),
        crlfDelay: Infinity});
}

function getInputs(readLineInterface) {
    return new Promise ((resolve, reject) => {
        const elections = [];
        let numberOfElections;
        let isBeginning = true;
        let isNewElection = true;
        let election;
        let readyForCandidates = false;
        let candidatesLength = null;
        let readyForVoters = false;
        readLineInterface.on('line', (line) => {
            // console.log("processing line: " + line);
            if (isBeginning && line.length > 0) {
              numberOfElections = parseInt(line);
            } else if(isBeginning) {
              isBeginning = false;
              isNewElection = true;
            } else if (isNewElection&& line.length < 1){

            } else if(isNewElection && line.length > 0) {
                election = {};
                election.candidates = [];
                election.currentCandidates = new Map();
                election.ballots = [];
                candidatesLength = parseInt(line);
                isNewElection = false;
                readyForCandidates = true;
            } else if(readyForCandidates) {
                if (candidatesLength === null) {
                    election = {
                      candidates: [],
                      voters: [],
                      winner: null
                    }
                } else {
                    election.candidates.push({
                      name: line,
                      votes: 0,
                      isInTheRunning: true
                    });
                    if(election.candidates.length === candidatesLength) {
                      readyForCandidates = false;
                      readyForVoters = true;
                    }
                }
            } else if(readyForVoters && line.length > 0) {;
                election.ballots.push(line);
            } else if(readyForVoters && line.length < 1) {
                elections.push(election);
                isNewElection = true;
                readyForCandidates = false;
                candidatesLength = null;
                readyForVoters = false;
            }
        });
        readLineInterface.on('close', () => {
            console.log("file read\n");
            elections.push(election);
            resolve(elections);
        });
    });
}

const inputFilePath = process.argv[2];
console.log("inputFilePath : " + inputFilePath);

const rlInterface = getReadlineInterface(inputFilePath);
const inputSetsPromise = getInputs(rlInterface);
let elections = null;
inputSetsPromise.then(response => {
    // console.log("Elections ---v");
    // console.log(response);
    elections = response;
    for (election of elections) {
        // console.log(election);
        // console.log(election.candidates)
        console.log(vote(election));
        console.log();
    }
})

