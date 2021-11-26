const checkTree = (tree) => {
    const edges = tree.getEdges();
    const vertices = tree.getVertices();

    console.log(`\nroot node: ${tree.root.value}\nedges: ${edges}\nvertices: ${vertices}\ndoes edges == vertices -1? ${vertices - edges === 1}`);
}

function TreeNode(value, children = []) {
    this.value = value;
    this.children = children;
}
TreeNode.prototype.isLeaf = function() {
    return this.children.length === 0;
}
TreeNode.prototype.hasChildren = function() {
    return !this.isLeaf();
}

function Tree(root) {
  this.root = root;
}
Tree.prototype.getEdges = function(node = this.root) {
    if (node.isLeaf()) return 0;
    let retVal = node.children.length;
    for(let childNode of node.children) {
        retVal += this.getEdges(childNode);
    }
    return retVal;
};
Tree.prototype.getVertices = function(node = this.root) {
    if (node.isLeaf()) return 1;
    let retVal = 1;
    for(let childNode of node.children) {
        retVal += this.getVertices(childNode);
    }
    return retVal;
}

greatgrandchild = new TreeNode("great grandchild");
grandchild = new TreeNode("grandchild", [greatgrandchild]);
child1 = new TreeNode("child1")
child2 = new TreeNode("child2", [grandchild])
node1 = new TreeNode("node1", [child1, child2]);

checkTree(new Tree(node1));
checkTree(new Tree(child1));
checkTree(new Tree(grandchild));