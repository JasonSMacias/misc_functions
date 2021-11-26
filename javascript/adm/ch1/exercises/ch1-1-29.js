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

console.log("Original set of horses: ");
Array.from(horseSet).sort((horse1, horse2) => {
    return horse2.speed - horse1.speed;
}).slice(0, 6).forEach(horse => console.log(horse));

console.log("Fastest 3 of horses: ");
findFastest(horseSet).forEach(horse => console.log(horse));
