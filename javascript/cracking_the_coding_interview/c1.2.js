// Given two strings, write a method to determine whether one is a permutation of another

// check if lengths are the same, if not return false.  Split each of them for O(2 log n) which is the same as O(log n) and run a loop that compares each index in the sorted arrays for O(n), for a total of O(n log n).
function permutationChecker(str, str2) {
  if (str.length !== str2.length) {
    console.log("Strings are not the same length");
    return false;
  }
  if (str.length === 0){
    console.log("Strings are empty");
    return false;
  }
  const strArr = str.split("").sort();
  const strArr2 = str2.split("").sort();
  for (let i = 0; i < str.length; i++) {
    if (strArr[i] !== strArr2[i]) {
      console.log("Strings are not permutations of one another");
      return false;
    }
  }
  console.log("Strings are permutations of one another");
  return true;
}

const string1a  = "This is a string";
const string1b = "This is a string that isn't even close to the other string";
const string2a = "ThisIsAString!";
const string2b = "DifStrSamlngth";
const string3a = "ada";
const string3b = "daa";
const string4a = "aeiouabcd";
const string4b = "cduoabiea";

let testA = permutationChecker(string1a, string1b);
let testB = permutationChecker(string2a, string2b);
let testC = permutationChecker(string3a, string3b);
let testD = permutationChecker(string4a, string4b);

console.log(testA + "\n" + testB + "\n" + testC + "\n" + testD);

// after hint in book suggested that this could also be done in O(n) time with added space, maybe with a hashing function, here's my attempt at that.  Completed without logic to handle collisions, because I'm not sure how to do that in this case, will have to come back to this after looking at solution.

const stringHash = require('string-hash');

function permutationCheckerHash(str1, str2) {
  if (str1.length !== str2.length) {
    console.log("Strings are not the same length");
    return false;
  }
  if (str1.length === 0){
    console.log("Strings are empty");
    return false;
  }
  let strArr = [];
  // count to keep track of how many pairs held in array i.e., how many matching characters in each string.  count should equal str1.length at end of loop, if not, not matching.
  let count = 0;
  for (let i = 0; i < str1.length; i++) {
    let hash1 = stringHash(str1[i]);
    let hash2 = stringHash(str2[i]);
    if (strArr[hash1]) {
      if (strArr[hash1].length % 2 !== 0) {
        // in the rare case of a collision, need to add more if statements that check, if odd, whether last number is equal to this number.  I'm not sure how to do this.
        count++;
        strArr[hash1].push(str1[i]);
      }
      else {
        strArr[hash1].push(str1[i]);
      }
    }
    else {
      strArr[hash1] = [str1[i]];
    }
    if (strArr[hash2]) {
      if (strArr[hash2].length % 2 !== 0) {
        count++;
        strArr[hash2].push(str2[i]);
      }
      else {
        strArr[hash2].push(str2[i]);
      }
    }
    else {
      strArr[hash2] = [str2[i]]
    }
  };
  if (count === str1.length) {
    console.log("Strings are permutations of one another");
    return true;
  }
  else {
    console.log("Strings are not permutations of one another");
    return false;
  }
};

let testE = permutationCheckerHash(string1a, string1b);
let testF = permutationCheckerHash(string2a, string2b);
let testG = permutationCheckerHash(string3a, string3b);
let testH = permutationCheckerHash(string4a, string4b);
console.log(testE + "\n" + testF + "\n" + testG + "\n" + testH);