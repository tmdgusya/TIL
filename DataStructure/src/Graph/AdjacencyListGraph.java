package Graph;

import java.util.ArrayList;

public class AdjacencyListGraph {

    private ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();;

    public AdjacencyListGraph(int nodeCount){
        for(int i = 0; i<nodeCount; i++){
            adjList.add(new<Integer> ArrayList());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph(){
        return adjList;
    }

    public ArrayList<Integer> getNode(int index){
        return adjList.get(index);
    }

    public void insertBidirectional(int nodeA, int nodeB){
        adjList.get(nodeA).add(nodeB);
        adjList.get(nodeB).add(nodeA);
    }

    public void insertSingle(int nodeA, int nodeB){
        adjList.get(nodeA).add(nodeB);
    }

    public void printGraph(){
        for(int i = 0; i < adjList.size(); i++){
            System.out.print("리스트 " + i);
            for(int j = 0; j <adjList.get(i).size(); j++){
                System.out.print(" ➡️ " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
