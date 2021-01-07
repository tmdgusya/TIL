package Graph;

public class AdjacencyGraph {
/* @RequirMent
* Connect Info : Array[NodeA][NodeB]
*   If connected 1
*   else 0
* */
    private int [][] matrix;

    public AdjacencyGraph(int matrixSize){
        this.matrix = new int[matrixSize][matrixSize];
    }

    public int[][] getGraph(){
        return this.matrix;
    }
    /* A <=> B */
    public void put(int nodeA, int nodeB){
        matrix[nodeA][nodeB] = 1;
        matrix[nodeB][nodeA] = 1;
    }

    /*Must be Input A => B (flows go to right)*/
    public void putSingle(int nodeA, int nodeB){
        matrix[nodeA][nodeB] = 1;
    }

    public void findConnectedInfo(int nodeA, int nodeB){ // O(1)
        System.out.println("nodeA => node B : " + matrix[nodeA][nodeB]);
        System.out.println("nodeB => node A : " + matrix[nodeB][nodeA]);
    }

    public void printMatrix(){
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
