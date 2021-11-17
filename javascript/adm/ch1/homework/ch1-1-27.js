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
    const candidateRangeLength = n;
    const slotsPerTicket = arrayOfTickets[0].length;
    const promisedCorrectNumbersInRange = 4;
    const matchingNumbersNecessaryToWin = 3;
    const setOfCombinations = getCombinations(promisedCorrectNumbersInRange, candidateRangeLength, new Set(), []);
    // TODO: check off combinations for every ticket in arrayOfTickets, make sure all are gone after running through them
}

const getCombinations = (j, n, combinationsSet, comboArr) => {
    if(comboArr.length >= j) {
        combinationsSet.add(comboArr);
        return combinationsSet;
    }
    
    if(n < 1) return combinationsSet;

    const comboArrCopyWith = [];
    for (combo of comboArr) comboArrCopyWith.push(combo);
    comboArrCopyWith.push(n);
    getCombinations(j, n - 1, combinationsSet, comboArrCopyWith);
    
    const comboArrCopyWithout = [];
    for (combo of comboArr) comboArrCopyWithout.push(combo);
    getCombinations(j, n - 1, combinationsSet, comboArrCopyWithout);
    
    return combinationsSet;
}

// testing getCombinations method
// console.log(getCombinations(4, 15, new Set(), []).size);