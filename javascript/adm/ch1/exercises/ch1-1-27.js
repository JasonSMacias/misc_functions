// 15 numbers from within a range of 1-44.  It is ensured that
// at least 4 of the fifteen will be among six numbers selected
// from the 1-44 range.  A prize is given for selecting at least
// three correct numbers on a six-number ticket.
// An algorithm created to construct the smallest set of 6-number
// tickets needed to win at least one prize.
// Exercise is to implement a method to check whether the algorithm
// output satisfies the conditions

// candidateRange of size n (15 here)
// k slotsPerTicket (6 here)
// promisedCorrectNumbers j in candidateSet (4 here)
// matchingNumbersNecessaryToWin l (3 here)

const checkCoverage = (arrayOfTickets) => {
    const candidateRangeLength = 15;
    const slotsPerTicket = arrayOfTickets[0].length;
    const promisedCorrectNumbersInRange = 4;
    const matchingNumbersNecessaryToWin = 3;
    const setOfCombinations = getCombinations(promisedCorrectNumbersInRange, candidateRangeLength, new Set(), []);
    // TODO: check off combinations for every ticket in arrayOfTickets, make sure all are gone after running through them
    for (let ticket of arrayOfTickets) {
        removeCoveredCombinations(ticket, setOfCombinations);
    }
    console.log(`Uncovered combinations: ${setOfCombinations.size}`);
    return setOfCombinations.size < 1;
}

const getCombinations = (j, n, combinationsSet, comboArr) => {
    if(comboArr.length >= j) {
        combinationsSet.add(comboArr);
        return combinationsSet;
    }
    
    if(n < 1) return combinationsSet;

    const comboArrCopyWith = [];
    for (let combo of comboArr) comboArrCopyWith.push(combo);
    comboArrCopyWith.push(n);
    getCombinations(j, n - 1, combinationsSet, comboArrCopyWith);
    
    const comboArrCopyWithout = [];
    for (let combo of comboArr) comboArrCopyWithout.push(combo);
    getCombinations(j, n - 1, combinationsSet, comboArrCopyWithout);
    
    return combinationsSet;
}

const removeCoveredCombinations = (ticket, setOfCombinations) => {
    for (let combination of setOfCombinations) {
        let count = 0;
        for (let number of ticket) {
            // TODO: fix this to check each combo, not the set
            if (setOfCombinations.has(number)) count++;
            if (count > 2) break;
        }
        if (count > 2) {
            // remove combination and related combination
            const numbersUsed = new Set();
            for (number of combination) {
                numbersUsed.add(number);
            }
            setOfCombinations.delete(combination);
            for (let combo of setOfCombinations) {
                let noIntersect = true;
                for(number of combo) {
                    if (numbersUsed.has(number)) noIntersect = false;
                }
                if(noIntersect) {
                    for (number of combo) {
                        numbersUsed.add(number);
                    }
                    setOfCombinations.delete(combo);
                }
            }
        }
    }
}   

// testing getCombinations method
// console.log(getCombinations(4, 15, new Set(), []).size);

const passingArray = [[2, 4, 8, 10, 13, 14], [4, 5, 7, 8, 12, 15], [1, 2, 3, 6, 11, 13], [3, 5, 6, 9, 10, 15], [1, 7, 9, 11, 12, 14]];
// check passingArray
console.log(`First array (should pass):  ${checkCoverage(passingArray)}`);

passingArray.pop();
passingArray.pop();
// check again with presumably failing array
console.log(`First array with last two of five arrays removed (should not pass):  ${checkCoverage(passingArray)}`);
