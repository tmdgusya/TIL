package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListGraphTest {

    AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(7);

    /*
     * TEST Connected Info
     * 1 <=> 2 , 1 <=> 4 , 1 <=> 6
     * 2 <=> 5 , 2 <=> 1
     * 3 <=> 4 , 3 => 1
     * 4 <=> 1 . 4 <=> 3 , 4 <=> 5
     * 5 => 6 , 5 <=> 4
     * 6 <=> 1
     * */

    @Test
    void listGraphTest(){
        putListGraph();

        ArrayList<ArrayList<Integer>> expectedList = adjacencyListGraph.getGraph();

        for(int i = 0; i < expectedList.size(); i++){
            for(int j = 0; j <expectedList.get(i).size(); j++){
                Integer expectedData = expectedList.get(i).get(j);
                Assertions.assertEquals(adjacencyListGraph.getNode(i).get(j), expectedList.get(i).get(j));
            }
        }

        adjacencyListGraph.printGraph();
    }

    private void putListGraph() {
        adjacencyListGraph.insertBidirectional(0,1);
        adjacencyListGraph.insertBidirectional(1,2);
        adjacencyListGraph.insertBidirectional(1,4);
        adjacencyListGraph.insertBidirectional(1,6);
        adjacencyListGraph.insertBidirectional(2,5);
        adjacencyListGraph.insertBidirectional(3,4);
        adjacencyListGraph.insertSingle(3,1);
        adjacencyListGraph.insertBidirectional(4,5);
        adjacencyListGraph.insertSingle(5,6);
    }
}