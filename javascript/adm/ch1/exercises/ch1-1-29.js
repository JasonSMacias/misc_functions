const findFastest = (horseSet) => {
     let winners = null;
    while(horseSet.size > 3) {
        let racingHorses = [];
        if (winners != null) {winners.forEach(winner => racingHorses.push(winner))}
        for (let horse of horseSet) {
            if (winners != null && winners.includes(horse)) continue;
            racingHorses.push(horse);
            if (racingHorses.length > 5) {
                break;
            }
        }
        winners = race(racingHorses, horseSet);
    }
    return Array.from(horseSet).sort((horse1, horse2) => {
        return horse2.speed - horse1.speed;
    });
}

const findFastestOptimized = (horseSet) => {
    let overallWinners = [];

    let firstFiveResults = new Map();

    // run first 5 exclusive races
    for(let i = 0; i < 5; i++) {
        const racers = [];
        for (horse of horseSet) {
            racers.push(horse);
            horseSet.delete(horse);
            if(racers.length === 5) break;
        }
        race(racers, new Set());
        firstFiveResults.set(racers[0].number, racers);
    }

    // run 6th race with winners of each previous
    const winnerRacers = [];
    
    for (horseWinners of firstFiveResults.values()) {
        winnerRacers.push(horseWinners[0]);
    }
    race(winnerRacers, new Set());

    //add winner of winnerRacers to overall winners, then run final race with horses that are logically able to make the top 3 and add top 2 to overall winners
    const tier1 = firstFiveResults.get(winnerRacers[0].number);
    const tier2 = firstFiveResults.get(winnerRacers[1].number);
    const tier3 = firstFiveResults.get(winnerRacers[2].number);
    overallWinners.push(tier1[0]); // proven to be fastest, doesn't need to race
    
    const finalRacers = [];
    finalRacers.push(tier1[1]);
    finalRacers.push(tier1[2]);
    finalRacers.push(tier2[0]);
    finalRacers.push(tier2[1]);
    finalRacers.push(tier3[0]);

    race(finalRacers, new Set());
    overallWinners.push(finalRacers[0]);
    overallWinners.push(finalRacers[1]);

    return overallWinners;
}

const race = (racingHorses, allHorses) => {
    racingHorses.sort((horse1, horse2) => {
        return horse2.speed - horse1.speed;
    });
    if (allHorses.size > 4) allHorses.delete( racingHorses[4]);
    if (allHorses.size > 3) allHorses.delete(racingHorses[3]);
    if (racingHorses.length > 3) racingHorses.pop();
    if (racingHorses.length > 3) racingHorses.pop();
    return racingHorses;
}

function Horse(number) {
    this.number = number;
    this.speed = Math.floor(Math.random() * 100);
    this.hasWon = false;
}

const horseSet = new Set();
for (let i = 1; i < 26; i++ ) {
    horseSet.add(new Horse(i));
}

console.log("Fastest five of original set of horses: ");
Array.from(horseSet).sort((horse1, horse2) => {
    return horse2.speed - horse1.speed;
}).slice(0, 6).forEach(horse => console.log(horse));

console.log("Fastest 3 of horses: ");
// findFastest(horseSet).forEach(horse => console.log(horse));
findFastestOptimized(horseSet).forEach(horse => console.log(horse));
