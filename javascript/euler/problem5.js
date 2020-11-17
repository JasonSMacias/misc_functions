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
    const freqMap = new Map();
    
    for (let i = 2; i <= 20; i++) {
        let count2s = 0;
        let n = i;
        while (n % 2 == 0) {
            count2s++;
            n /= 2;
        }
        if (!freqMap.has(2) || freqMap.get(2) < count2s) {
            freqMap.set(2, count2s);
        }
        for (let x = 3; x <= Math.sqrt(n); x += 2) {
          let countXs = 0;
          while (n % x == 0) {
            countXs++;
            n /= x;        
          }
          if (!freqMap.has(x) == true || freqMap.get(x) < countXs) {
            freqMap.set(x, countXs);
          }
        }
        if(n > 1) {
          freqMap.set(n, freqMap.has(n) ? freqMap.get(n) : 1);
        }
    }
    let retVal = 1;
    for(let x of freqMap) {
      retVal *= Math.pow(x[0], x[1])
    }
    return retVal;
}

console.log(getSmallestDivisibleBy1to20UsingPrimeFactors());
// console.log(getSmallestDivisibleBy1to20());