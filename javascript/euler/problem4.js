// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.

const findLargestPalindrome = range => range.map(
  (num, index) => 
    range
    .slice(index + 1)
    .map((num2, index2) => num * num2)
    .filter(prod => isPalindrome(prod))
    .reduce((acc, curVal) => Math.max(acc, curVal), 0)
).reduce((acc, curVal) => Math.max(acc, curVal), 0);

const rangeArr = [];
for (let i = 100; i < 1000; i++) {
  rangeArr.push(i);
}

const isPalindrome = num => {
  return num.toString().split("").reverse().join("") === num.toString();
}


console.log(findLargestPalindrome(rangeArr));