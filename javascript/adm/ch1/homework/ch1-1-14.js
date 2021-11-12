function checkForN(n, a) {
    bruteVal = 0;
    for (let i = 0; i <= n; i++) {
        bruteVal += a ** i;
    }

    const testVal = (a ** (n + 1) - 1) / (a - 1)
    console.log(`\nn: ${n}\na: ${a}\nvalue from function: ${bruteVal}\n value to test: ${testVal}\n`);
}

console.log(checkForN(5, 2));
console.log(checkForN(16, 2));
console.log(checkForN(24, 2));
console.log(checkForN(5, -3));
console.log(checkForN(16, -3));
console.log(checkForN(24, -3));
console.log(checkForN(5, 71));
console.log(checkForN(16, 9));
console.log(checkForN(24, 4));
console.log(checkForN(54, 2))
