const getCycleLength = (n) => {
    let numberOfCycles = 0;
    while(true) {
        numberOfCycles++;
        if (n === 1) break;
        if (n % 2 === 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
    }
    return numberOfCycles;
}

const getMaximumCycleLength = (beginIndex, endIndex) => {
    let maximum = 0;
    for (i = beginIndex; i <= endIndex; i++) {
        maximum = Math.max(maximum, getCycleLength(i));
    }
    console.log(beginIndex + ' ' + endIndex + ' ' + maximum);
}

console.log("input: 1 10 - output should be 1 10 20")
getMaximumCycleLength(1, 10);

console.log("input: 100 200 - output should be 100 200 125")
getMaximumCycleLength(100, 200);

console.log("input: 201 210 - output should be 201 210 89")
getMaximumCycleLength(201, 210);

console.log("input: 900 1000 - output should be 900 1000 174")
getMaximumCycleLength(900, 1000);

console.log("input: 605293 606510- output should be 605293 606510 341")
getMaximumCycleLength(605293, 606510);