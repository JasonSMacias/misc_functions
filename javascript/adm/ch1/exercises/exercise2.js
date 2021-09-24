// Movie scheduling problem

const scheduleMovies = (movieList) => {
    const returnArr = [];
    while(movieList.length > 0) {
        let lowestEnd = Number.POSITIVE_INFINITY;
        let lowestIndex = -1;
        for (let i = 0; i < movieList.length; i++) {
            if (movieList[i].end < lowestEnd) {
                lowestEnd = movieList[i].end;
                lowestIndex = i;
            }
        }
        const selectedMovie = movieList[lowestIndex];
        returnArr.push(selectedMovie);
        console.log(selectedMovie);
        for (let i = movieList.length -1; i > -1; i--) {
            const currentMovie = movieList[i];
            if (selectedMovie.start < currentMovie.end && selectedMovie.end > currentMovie.start) {
                movieList.splice(i, 1);
            }
        }
    }

    return returnArr;
}

const movies = [{start: 1, end: 10}, {start: 2, end: 3}, {start: 5, end: 7}, {start: 9, end: 15}, {start: 4, end: 15}];

console.log(`movies to choose from:\n ${movies}movies chosen:\n ${scheduleMovies(movies)}`);