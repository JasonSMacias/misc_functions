const checkForN = (n) => {
    let val1 = 0;
    for (let i = 1; i <= n; i++) {
        val1 += i ** 3;
    }
    let val2 = 0;
    for(let i =1; i <= n; i++) {
        val2 += i;
    }
    val2 = val2 ** 2;
    console.log(`\nn: ${n}\nsum of cubes: ${val1}\n sum squared: ${val2}\n`);
}

console.log(checkForN(5));
console.log(checkForN(16));
console.log(checkForN(54));
console.log(checkForN(978));
console.log(checkForN(12983));