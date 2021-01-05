package Tree;

public class BinTree<T> {
    private T data;
    private BinTree<T> parentNode;
    private BinTree<T> leftNode;
    private BinTree<T> rightNode;

    public BinTree(T data) {
        this.data = data;
    }

    public T visit(BinTree<T> node){
        return node.data;
    }

    public void inOrderTraversal(BinTree node){
        if(node != null){
            inOrderTraversal(node.leftNode);
            visit(node);
            inOrderTraversal(node.rightNode);
        }
    }

    public void preOrderTraversal(BinTree node){
        if(node != null){
            visit(node);
            preOrderTraversal(node.leftNode);
            preOrderTraversal(node.rightNode);
        }
    }

    public void postOrderTraversal(BinTree node){
        if(node != null){
            postOrderTraversal(node.leftNode);
            postOrderTraversal(node.rightNode);
            visit(node);
        }
    }

    public BinTree<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinTree<T> parentNode) {
        this.parentNode = parentNode;
    }

    public BinTree<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinTree<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinTree<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinTree<T> rightNode) {
        this.rightNode = rightNode;
    }
}
