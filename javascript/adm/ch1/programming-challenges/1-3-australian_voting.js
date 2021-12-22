const fs = require('fs');
const readline = require('readline');


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
            console.log("processing line: " + line);
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
            console.log("file read");
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
    console.log("Elections ---v");
    console.log(response);
    inputSets = response;
})
// const vote = (voters) => {
//
// }
