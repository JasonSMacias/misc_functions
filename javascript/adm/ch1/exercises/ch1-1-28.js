const divide = (a, b) => {
    let count = 0;
    // let remainder;
    while(a >= b) {
        a = a - b;
        count++;
    }
    // remainder = a;
    // return `${count} remainder ${remainder}`;
    return count;
}

console.log(`10 / 3 (should be ${Math.floor(10 / 3)}): 
     ${divide(10, 3)}`);
console.log(`75,953,651 / 211 (should be ${Math.floor(75_953_651 / 211)});
     ${divide(75_953_651, 211)}`);

