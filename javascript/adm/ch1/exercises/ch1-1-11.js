function checkForN(n) {
    let bruteVal = 0;
    for (let i = 1; i <= n; i++) {
        bruteVal = bruteVal + i ** 2;
    }
    let testVal = n * (n + 1) * (2 * n + 1) / 6;
    console.log(`\nn: ${n}\nvalue from summing: ${bruteVal}\n value to test: ${testVal}\n`);
} 

console.log(checkForN(5));
console.log(checkForN(16));
console.log(checkForN(54));
console.log(checkForN(978));
console.log(checkForN(12983));
console.log(checkForN(158000));
