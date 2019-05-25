// write a function to check if a string has all unique characters.  What if you cannot use additional data structures?

// Using a hashing function
const stringHash = require('string-hash');
let stringArr = [];

function stringDupCheck2(str) {
  console.log("String Dup Check with hashing function -----------");
  stringArr = [];
  for (let x of str) {
    // assign hash code for character
    let hash = stringHash(x);
    // checking to see if stringArr index at the hash code for x is already occupied, and if so, if the character in that
    if (stringArr[hash] && stringArr[hash][0] === x) {
      console.log(`The character ${x} occurs at least twice in the string "${str}"`);
      return false;
    }
    else if (stringArr[hash]) {
      stringArr[hash].push(x);
    }
    else {
      stringArr[hash] = [x];
      console.log("SA at hash: " + stringArr[hash]);
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
// -----------


// easiest I can think of, not using any data structures
function stringDupCheck(str) {
  console.log("String Dup Check without hashing function -----------");
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
