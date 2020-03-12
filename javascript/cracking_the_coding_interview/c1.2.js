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

// coming back to this after quite a while of working only with Java, redoing O(n) implementation using Map data structure.
function isPermutation(string1, string2) {
  if (string1.length !== string2.length) {
    console.log("Strings are not the same length");
    return false;
  }
  if (string1.length === 0){
    console.log("Strings are empty");
    return false;
  }
  const frequencies = new Map();
  for(let i = 0; i < string1.length; i++) {
    if(frequencies.has(string1[i])) {
      let freq = frequencies.get(string1[i]);
      frequencies.set(string1[i], freq + 1);
    }
    else frequencies.set(string1[i], 1);

    if(frequencies.has(string2[i])) {
      let freq = frequencies.get(string2[i]);
      frequencies.set(string2[i], freq - 1);
    }
    else frequencies.set(string2[i], -1);
  }
  
  for(const val of frequencies.values()) {
    if(val !== 0) return false;
  }
  return true;
}

let testE = isPermutation(string1a, string1b);
let testF = isPermutation(string2a, string2b);
let testG = isPermutation(string3a, string3b);
let testH = isPermutation(string4a, string4b);
console.log(testE + "\n" + testF + "\n" + testG + "\n" + testH);