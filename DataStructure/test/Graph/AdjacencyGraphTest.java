package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyGraphTest {
    /*
    * TEST Connected Info
    * 1 <=> 2 , 1 <=> 4 , 1 <=> 6
    * 2 <=> 5 , 2 <=> 1
    * 3 <=> 4 , 3 => 1
    * 4 <=> 1 . 4 <=> 3 , 4 <=> 5
    * 5 => 6 , 5 <=> 4
    * 6 <=> 1
    * */

    AdjacencyGraph adjacencyGraph = new AdjacencyGraph(7);

    int[][] ExpectedData = {
            {0,0,0,0,0,0,0},
            {0,0,1,0,1,0,1},
            {0,1,0,0,0,1,0},
            {0,1,0,0,1,0,0},
            {0,1,0,1,0,1,0},
            {0,0,1,0,1,0,1},
            {0,1,0,0,0,0,0}
    };

    @Test
    void graphTest(){

        putTestCase();

        int[][] resultGraph = adjacencyGraph.getGraph();

        for(int i = 0; i< resultGraph.length; i++){
            for(int j = 0; j< resultGraph.length; j++){
                Assertions.assertEquals(ExpectedData[i][j], resultGraph[i][j]);
            }
        }
    }

    private void putTestCase() {
        adjacencyGraph.put(1,2);
        adjacencyGraph.put(1,4);
        adjacencyGraph.put(1,6);
        adjacencyGraph.put(2,5);
        adjacencyGraph.put(2,1);
        adjacencyGraph.put(3,4);
        adjacencyGraph.putSingle(3,1);
        adjacencyGraph.put(4,1);
        adjacencyGraph.put(4,3);
        adjacencyGraph.put(4,5);
        adjacencyGraph.putSingle(5,6);
        adjacencyGraph.put(5,4);
        adjacencyGraph.put(6,1);
    }
}