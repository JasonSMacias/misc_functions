const horner = (a, x) => {
    const n = a.length - 1;
    let p = a[n];
    for(let i = n - 1; i >= 0; i--) {
        p = p * x + a[i];
    }
    return p
}

const a = [-1, 2, -6, 2];
const x = 3;
const result = horner(a, x);
console.log(`Result (shold be 5):
    ${result}`);