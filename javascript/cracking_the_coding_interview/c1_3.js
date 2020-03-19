//URLify: write a method to replace all spaces in a string with '%20'  You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the true length of the string

// the easy way
function URLify(str) {
  return str.trim().replace(/ /g, "%20");
}

// without using replace, splitting into char array first, then mapping and joining back
function URLify2(str) {
  const strArr = [...str.trim()];
  return strArr.map(ch => ch === " " ? "%20" : ch).join("");
}


// to test:
const str1 = "Testing testing testing         ";
const str2 = "Testingtestingtesting";
const str3 = "This is a longer string with a bunch of spaces                           ";
const str4 = "This is a string with more spaces than needed appended to the end                                          ";
console.log("easy way");
console.log(URLify(str1) + "\n" +
            URLify(str2) + "\n" +
            URLify(str3) + "\n" +
            URLify(str4));

console.log("\nwithout split(),");
console.log(URLify2(str1) + "\n" +
            URLify2(str2) + "\n" +
            URLify2(str3) + "\n" +
            URLify2(str4));