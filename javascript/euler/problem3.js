/*
* The prime factors of 13195 are 5, 7, 13 and 29.
* What is the largest prime factor of the number 600851475143 ?
 */

const getLPF = (n) => {
  // use Euler supplied param if parm not good
  if (n < 2) {
    n = 600851475143;
  }
  let retVal = 1;
  while (n % 2 === 0) {
    retVal = 2;
    n /= 2;
  }
  for (let i = 3; i < Math.sqrt(n); i++) {
    while (n % i === 0) {
      retVal = i;
      n /= i;
    }
  }
  if (n > 2) {
    retVal = n;
  }
  return retVal;
}

// console.log(getLPF(13195)); // 29
console.log(getLPF(-1)); // 6857 
