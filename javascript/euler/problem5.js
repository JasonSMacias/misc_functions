 // 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20? (232792560)

// Brute force
const getSmallestDivisibleBy1to20 = () => {
    outerLoop:
    for (let i = 20; i < Number.MAX_VALUE; i += 20) {
        for (let j = 3; j <= 20; j++) {
            if (i % j != 0) {
                continue outerLoop;
            }
        }
        return i;
    }
}

const getSmallestDivisibleBy1to20UsingPrimeFactors = () => {
    const freqMap = {};
    
    for (let i = 2; i <= 20; i++) {
        let count2s = 0;
        while (!(i / 2)) {
            count2s++;
            i /= 2;
            console.log(i/2);
        }
        if (!freqMap["2"] || freqMap["2"] < count2s) {
            freqMap["2"] = count2s;
        }
        for (let j = 3; j <= Math.sqrt(i); j += 2) {
            countXs = 0
            while (!(i / j)) {
                countXs++;
                i /= j;
                
            }
            if (!freqMap[j.toString()] || freqMap[j.toString()] < countXs) {
                freqMap[j.toString()] = countXs;
            }
            if(i > 1) {
                freqMap[i.toString()] = !freqMap[i.toString()] ? freqMap[i.toString()] + 1 : 1;
            }
        }
    }
    let retVal = 1;
    for(let x in freqMap) {

    }
    return retVal;
}



console.log(getSmallestDivisibleBy1to20UsingPrimeFactors());