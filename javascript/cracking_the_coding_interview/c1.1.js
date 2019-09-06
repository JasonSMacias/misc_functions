// write a function to check if a string has all unique characters.  What if you cannot use additional data structures?

// easiest I can think of, not using any data structures
function stringDupCheck(str) {
  for (let i = 0; i < str.length; i++) {
    for (let j = 0; j < str.length; j++) {
      if (i === j) {
        continue;
      }
      if (str[i] === str[j]) {
        console.log(`The character ${str[i]} occurs at least twice in the string "${str}"`);
        return false;
      }
    }
  }
  console.log(`this string, "${str}", has no duplicate characters`);
  return true;
}

const testStr1 = "Jason Macias"; // has duplicate
const testStr2 = "qwertyuiopasdfghjklzxcvbnm1234567890\\-\"";  // No duplicate

let test1 = stringDupCheck(testStr1);
console.log({test1});
let test2 = stringDupCheck(testStr2);
console.log({test2});


// Using a hashing function
const stringHash = require('string-hash');
let stringArr = [];

function stringDupCheck2(str) {
  stringArr = [];
  for (let x of str) {
    let hash = stringHash(x);
    console.log("\nString Dup Check 2\nFor " + str + "and hash:\n" + hash);
    if (stringArr[hash] && stringArr[hash] === x) {
      console.log(`The character ${x} occurs at least twice in the string "${str}"`);
      return false;
    }
    else {
      stringArr[hash] = x;
      console.log("SA at hash\n" + stringArr[hash]);
    }
  }
  console.log(`this string, "${str}", has no duplicate characters`);
  return true;
};

const testStr3 = "Howard the duck"; // has duplicate
const testStr4 = "qwertyuiopasdfghjklzxcvbnm1234567890\\-\"";  // No duplicate

let test3 = stringDupCheck2(testStr3);
console.log({test3});
let test4 = stringDupCheck2(testStr4);
console.log({test4});

// Book and js solution give an answer that uses a "new Set", which holds an array of unique values, and iterates through the characters checking to see if it has been added already (NOte: the Set methods utilize some sort of hash table or performant algorithm that makes them O(1) to check if the set has a value)
//  For the non-data-structure variant, book sorts the arrary (log n) then checks through values for repeats (n), coming out as O(n log n), better than my O(n^2) nested loop solution.
