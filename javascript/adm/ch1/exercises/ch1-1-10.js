
function checkForN(n) {
    let bruteVal = 0;
    for (let i = 1; i <= n; i++) {
        bruteVal = bruteVal + i;
    }
    let testVal = n * (n + 1) / 2;
    console.log(`\nn: ${n}\nvalue from summing: ${bruteVal}\n value to test: ${testVal}\n`);
} 

console.log(checkForN(5));
console.log(checkForN(16));
console.log(checkForN(54));
console.log(checkForN(978));
console.log(checkForN(12983));
console.log(checkForN(158000));
console.log(checkForN(45682820));