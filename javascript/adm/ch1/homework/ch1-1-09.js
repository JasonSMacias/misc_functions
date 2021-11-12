const bubblesort = (arr) => {
    let i, j;
    for (i = arr.length - 1; i > 0; i--) {
        for(j = 0; j <= i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                const oldj = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = oldj;
            }
            // console.log(arr);
        }
    }
}

// unsorted = [6, 3, 19, 77, 14, -7, 1, 3];
// console.log(`unsorted array: ${unsorted}`);
// bubblesort(unsorted);
// console.log(`sorted array: ${unsorted}`);

unsorted2 = [-1, -99, -5, -1, -99, -9876, -4, 5, -88];
console.log(`unsorted 2: ${unsorted2}`);
bubblesort(unsorted2);
console.log(`sorted2: ${unsorted2}`);