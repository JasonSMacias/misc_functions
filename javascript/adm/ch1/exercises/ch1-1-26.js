// c = sqrt(a ** 2 + b ** 2)

const nearestNeighbor = (setOfPoints) => {
    // where each point is a map with x and y values
    let sets = {originalSet: setOfPoints,
                newSet: []}
    const startingPointIndex = Math.floor(Math.random() * setOfPoints.length);
    sets.newSet[0] = sets.originalSet[startingPointIndex];
    sets.originalSet.splice(startingPointIndex, 1);
    while(sets.originalSet.length > 0) {
        getNext(sets);
    }
    return sets.newSet;
}

const getNext = (sets) => {
    const currentPoint = sets.newSet[sets.newSet.length - 1];
    const closestIndex = findClosest(currentPoint, sets.originalSet);
    sets.newSet.push(sets.originalSet[closestIndex]);
    sets.originalSet.splice(closestIndex, 1);
    return;
}

const findClosest = (currentPoint, set) => {
    x = currentPoint.get('x');
    y = currentPoint.get('y');
    let lowest = Infinity;
    let lowestIndex = -1;
    for (let i = 0; i < set.length; i++) {
        xdist = x - set[i].get('x');
        ydist = y - set[i].get('y');
        const distance = Math.sqrt(xdist * xdist + ydist * ydist);
        lowest = Math.min(lowest, distance);
        if (lowest === distance) lowestIndex = i;
    }
    return lowestIndex;
}

const getDistance = (point1, point2) => {
    xDist = point1.get("x") - point2.get("x");
    yDist = point1.get("y") - point2.get("y");
    const distance = Math.sqrt(xDist * xDist + yDist * yDist);
    return distance;
}

const closestPair = (setOfPoints) => {
    const nodes = [];
    for (let point of setOfPoints) {
        nodes.push(new Node(point));
    }
    totalDistance = 0;
        for (let ii = 1; ii < nodes.length; ii++) {
        let d = Infinity;
        let currentI = -1;
        let currentJ = -1;
        for (let i = 0; i < nodes.length; i++) {
            if(nodes[i].edges.length > 1) continue;
            for (let j = i + 1; j < nodes.length; j++) {

                if(nodes[j].edges.length > 1) continue;
                if(nodes[i].edges[0] && nodes[j].edges[0] && nodes[i].point === nodes[j].edges[0].point) continue;
                if(nodes[j].edges.length > 0 && nodes[i].edges.length > 0) {
                    const jEnd = nodes[j].getAnEnd();
                    const jOtherEnd = jEnd.getOtherEnd();
                    if(nodes[i] === jEnd || nodes[i] === jOtherEnd) continue;
                }
                const distance = getDistance(nodes[i].point, nodes[j].point);
                if (distance < d) {
 
                    d = distance;
                    currentI = i;
                    currentJ = j;
                }
            }
        }
        // console.log(`nodes[${currentI}] to nodes[${currentJ}]`);
        nodes[currentI].connect(nodes[currentJ]);
        nodes[currentJ].connect(nodes[currentI]);
        totalDistance += d;
    }

    const end1 = nodes[0].getAnEnd();
    const end2 = end1.getOtherEnd();
    totalDistance += getDistance(end1.point, end2.point);
    end1.connect(end2);
    end2.connect(end1);
    console.log(end1.printNodes());
}

function Node(point) {
    this.point = point;
    this.edges = [];
}
Node.prototype.getAnEnd = function(visited = new Set()) {
    const stack = [this];
    while(stack.length > 0) {
        const current = stack.pop();
        if (current.edges.length < 2 && !visited.has(current.point)) return current;
        if (!visited.has(current.point)) {
            visited.add(current.point);
            for(edge of current.edges) stack.push(edge);
        }
    }
}
// To be called on a node that has been confirmed to be an end
Node.prototype.getOtherEnd = function() {
    return this.edges[0].getAnEnd(new Set([this.point]));
}
// Both need to connect
Node.prototype.connect = function(otherNode) {
    this.edges.push(otherNode);
}
// For printing nodes after a ring of nodes made
Node.prototype.printNodes = function(set = new Set()) {
    set.add(this);
    if(set.has(this.edges[0]) && set.has(this.edges[1])) return [this.point];
    const recursiveResult = set.has(this.edges[0]) ? this.edges[1].printNodes(set) : this.edges[0].printNodes(set);
    // recursiveResult.push(" <- ");
    recursiveResult.push(this.point);
    return recursiveResult;
}

// roughly circular set of points, all should perform okay
let point1 = new Map();
point1.set("x", 0);
point1.set("y", 3);
let point2 = new Map();
point2.set("x", 2);
point2.set("y", 2);
let point3 = new Map();
point3.set("x", 4);
point3.set("y", 0);
let point4 = new Map();
point4.set("x", 3);
point4.set("y", -2);
let point5 = new Map();
point5.set("x", 0);
point5.set("y", -3);
let point6 = new Map();
point6.set("x", -3);
point6.set("y", -2);
let point7 = new Map();
point7.set("x", -2);
point7.set("y", 0);

// points on a single line, should confound nearest neighbor, not closest pairs
let point8 = new Map();
point8.set("x", 0);
point8.set("y", 0);
let point9 = new Map();
point9.set("x", 0);
point9.set("y", 1);
let point10 = new Map();
point10.set("x", 0);
point10.set("y", -1);
let point11 = new Map();
point11.set("x", 0);
point11.set("y", 3);
let point12 = new Map();
point12.set("x", 0);
point12.set("y", -5);
let point13 = new Map();
point13.set("x", 0);
point13.set("y", 11);
let point14 = new Map();
point14.set("x", 0);
point14.set("y", -21);

let setOfPoints = [point1, point2, point3, point4, point5, point6, point7];
let setOfPoints2 = [point8, point9, point10, point11, point12, point13, point14];

console.log("     Nearest Neighbor:  ");
console.log("Circular placement set: ");
console.log(nearestNeighbor(setOfPoints));
console.log("Linear placement set: ");
console.log(nearestNeighbor(setOfPoints2));
setOfPoints = [point1, point2, point3, point4, point5, point6, point7];
setOfPoints2 = [point8, point9, point10, point11, point12, point13, point14];
console.log("     Closest Pair: ");
console.log("Circular placement set: ");
closestPair(setOfPoints);
console.log("Linear placement set: ");
closestPair(setOfPoints2);
