const checkForN = (n) => {
    const val = n ** 3 + 2 * n;
    const isDivisibleBy3 = val % 3 === 0;
    console.log(`\nn: ${n}\nvalue from function: ${val}\ndivided by 3: ${val / 3}\n is divisible by 3?: ${isDivisibleBy3}\n`);
}

console.log(checkForN(5));
console.log(checkForN(16));
console.log(checkForN(54));
console.log(checkForN(978));
console.log(checkForN(12983));
console.log(checkForN(108000));