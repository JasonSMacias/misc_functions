const fs = require('fs');
const readline = require('readline');


const getReadlineInterface = (filePath) => {
    return readline.createInterface({
        input: fs.createReadStream(filePath),
        crlfDelay: Infinity});
}

function getInputSets(readLineInterface) {
    return new Promise ((resolve, reject) => {
        const inputSets = [];
        let setToAdd = null;
        readLineInterface.on('line', (line) => {
            // console.log("processing line: " + line);
            if(!line.includes(".")) {
                if(setToAdd != null) {
                    inputSets.push(setToAdd);
                    setToAdd = [];
                } else {
                    setToAdd = [];
                }
            } else {
                // Values to be calculated in pennies
                setToAdd.push(parseInt(line.replace(".", "")));
            }
        });
        readLineInterface.on('close', () => {
            console.log("file read");
            resolve(inputSets);
        });
    });
}

// Still a little off, right more often than not, 
// and within .01 or, less often, .02 of actual result when wrong
const getTotalMoneyToExchange = (inputSet) => {
    console.log("Working on " + inputSet);
    let totalMoneyExchanged = 0;
    if (inputSet === null || inputSet.length < 2) {
        console.log("Total Money Exchanged: 0");
        return totalMoneyExchanged;
    }
    inputSet.sort((a, b) => a - b);
    if (inputSet[0] === inputSet[inputSet.length -1]) {
        console.log("Total Money Exchanged: 0");
        return totalMoneyExchanged;
    }
    const bottoms = {value: 0, count: 1};
    const tops = {value: 0, count: 1};
    let mids;
    tops.value = inputSet.pop();
    bottoms.value += inputSet.shift();
    while(inputSet.length > 0 && tops.value === inputSet[inputSet.length - 1]) {
        tops.count++;
        inputSet.pop();
    }
    while (bottoms.value === inputSet[0]) {
        bottoms.count++;
        inputSet.shift();
    }
    mids = inputSet.length > 0 ? inputSet : null; 
    
    OUTER: while(tops.value - bottoms.value > 1) {
        const topDiff = tops.value - (mids != null ? mids[mids.length - 1] : bottoms.value);
        const bottomDiff = (mids != null ? mids[0] : tops.value) - bottoms.value;
 
        const topDiffTimesCount = topDiff * tops.count;
        const bottomDiffTimesCount = bottomDiff * bottoms.count;
        let isTop = topDiffTimesCount <= bottomDiffTimesCount;
        let gapToFill = Math.min(topDiffTimesCount, bottomDiffTimesCount);
        if (mids === null || mids.length === 0) {

            // subtract from tops, add to bottoms 1 at a time, adding to count
            // break loop when within 1
            const topsIsSmaller = tops.count <= bottoms.count;
            let smallerCount = topsIsSmaller ? tops.count : bottoms.count;
            let largerCount = topsIsSmaller ? bottoms.count : tops.count;
            let largerToFill = 0;
            while (true) {
                for (let i = 0; i < smallerCount; i++) {
                    largerToFill++;
                    totalMoneyExchanged++;
                    if (largerToFill === largerCount) {
                        largerToFill = 0;
                        if (topsIsSmaller) {
                            bottoms.value++;
                        } else {
                            tops.value--;
                        }
                    }
                    if (tops.value - bottoms.value <= 1) break OUTER;
                    if (largerToFill != 0 && tops.value - bottoms.value <= 2) break OUTER;
                }
                if (topsIsSmaller) {
                    tops.value--;
                } else {
                    bottoms.value++;
                }
            }
        }

        // exchange money between tops and bottoms and shift remainders into mids if necessary
        // 1) increment/decrement lower count of either bottom or top to match higher/lower value
        if(isTop){
            tops.value -= topDiff;
            if(mids != null) {
                while (mids.length > 0 && mids[mids.length - 1] === tops.value) {
                    tops.count++;
                    mids.pop();
                }
            }
        } else {
            bottoms.value += bottomDiff;
            if (mids != null) {
                while(mids.length > 0 && mids[0] === bottoms.value) {
                    bottoms.count++;
                    mids.shift();
                }
            }
        }
        // 2) reduce opposite end by relevant value
        // 3) subtract remainder from count to get extra decrements, if not 0 decrement count by that much and shift/pop 
        //    that many instances of the tops/bottoms value -/+ 1 to end of mids (may have to create mids if null)
        const amountToChange = Math.floor(gapToFill / (isTop ? bottoms.count : tops.count));
        const remainder = gapToFill % (isTop ? bottoms.count : tops.count);
        if(isTop){
            bottoms.value += amountToChange;
            bottoms.count -= remainder;
            for(let i = 0; i < remainder; i++) {
                if (mids === null) mids = [];
                mids.unshift(bottoms.value + 1);
            }
        }else {
            tops.value -= amountToChange;
            tops.count -= remainder;
            for (let i = 0; i < remainder; i++) {
                if(mids === null) mids = [];
                mids.push(tops.value - 1);
            }
        }
        // 4) increment totalMoneyExchanged by gapToFill
        // console.log(`money exchanged: ${gapToFill} / ${isTop ? bottoms.count : tops.count}`);
        totalMoneyExchanged += gapToFill;
        
        if(mids != null) {
            while(mids.length > 0 && mids[mids.length - 1] === tops.value) {
                tops.count++;
                mids.pop();
            }
            while(mids.length > 0 && mids[0] === bottoms.value) {
                bottoms.count++;
                mids.shift();
            }
        }
        if(mids != null && mids.length === 0) mids = null;
        // console.log("gap to fill: " + gapToFill);
    }
    // Convert back into dollars and return
    console.log(`value exchanged: ${totalMoneyExchanged / 100}`);
}

const inputFilePath = process.argv[2];
console.log("inputFilePath : " + inputFilePath);

const rlInterface = getReadlineInterface(inputFilePath);
const inputSetsPromise = getInputSets(rlInterface);
let inputSets = null;
inputSetsPromise.then(response => {
    console.log("Input Sets ---v");
    console.log(response);
    inputSets = response;
}).then(response => {
    for(inputSet of inputSets) {
        getTotalMoneyToExchange(inputSet);
    }
});