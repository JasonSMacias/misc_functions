const insertionSort = (arr) => {
    for (let i = 0; i < arr.length; i++) {
        let j = i;
        while(j > 0 && arr[j] < arr[j - 1]) {
            const jVal = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = jVal;
            j--;
        }
    }
    return arr;
}

const arr1 = [55, 2, 1, 3, 97, 7, 32, 99];

console.log(
    `original: ${arr1.toString()}\nsorted: ${insertionSort(arr1).toString()}`);