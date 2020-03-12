// write a function to check if a string has all unique characters.  What if you cannot use additional data structures?

// redoing, sorting then checking for dups, no data structures, O(n log n)
function stringDupCheck(str) {
  const strArr = str.split("").sort();
  for (let i = 1; i < strArr.length; i++) {
    if (strArr[i] === strArr[i - 1]) return false;
  }

  return true;
}

const testStr1 = "Jason Macias"; // has duplicate
const testStr2 = "qwertyuiopasdfghjklzxcvbnm1234567890\\-\"";  // No duplicate

let test1 = stringDupCheck(testStr1);
console.log({test1});
let test2 = stringDupCheck(testStr2);
console.log({test2});

// redoing O(n) solution using a Set

function stringDupCheck2(str) {
  const charSet = new Set();
  for (let x of str) {
    if(charSet.has(x)){
      return false;
    }
    charSet.add(x);
  }

  return true;
};

const testStr3 = "Howard the duck"; // has duplicate
const testStr4 = "qwertyuiopasdfghjklzxcvbnm1234567890\\-\"";  // No duplicate

let test3 = stringDupCheck2(testStr3);
console.log({test3});
let test4 = stringDupCheck2(testStr4);
console.log({test4});

