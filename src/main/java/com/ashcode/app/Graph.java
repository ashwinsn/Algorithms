package com.ashcode.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by anatarajan on 3/9/16.
 */

class GraphNode{
    String data;
    boolean visited;

    public GraphNode(String data, boolean visited){
        this.data = data;
        this.visited = visited;
    }
}

public class Graph {

    HashSet<GraphNode> vertices; //To add vertices if not present to find if a vertex exists faster.
    HashMap<GraphNode, HashSet<GraphNode>> adjacencyList; //To prevent adding duplicate edges and to find them faster.
    HashMap<GraphNode, HashSet<GraphNode>> pathList;


    public Graph(){
        vertices = new HashSet<GraphNode>();
        adjacencyList = new HashMap<GraphNode, HashSet<GraphNode>>();
        pathList = new HashMap<GraphNode, HashSet<GraphNode>>();
    }

    public void addVertex(GraphNode vertex){
        vertices.add(vertex);
    }

    public void addEdges(GraphNode vertex1, GraphNode vertex2){
        if(!vertices.contains(vertex1)) {
            vertices.add(vertex1);
        }

        if(!vertices.contains(vertex2)) {
            vertices.add(vertex2);
        }

        HashSet<GraphNode> edgeSet = adjacencyList.get(vertex1);
        edgeSet = (edgeSet == null) ? new HashSet<GraphNode>() : edgeSet;
        edgeSet.add(vertex2);
        adjacencyList.put(vertex1, edgeSet);
    }

    public void buildPathListFromASource(GraphNode v){
        LinkedList<GraphNode> BFTQueue = new LinkedList<GraphNode>();

        BFTQueue.add(v);
        v.visited = true;

        while(!BFTQueue.isEmpty()){
            GraphNode currentNode = BFTQueue.remove();
            addCurrentNodeChildrenToReachableSetOfParent(v, currentNode, BFTQueue);
        }
    }

    public void addCurrentNodeChildrenToReachableSetOfParent(GraphNode parent, GraphNode currentNode, LinkedList<GraphNode> BFTQueue) {
        if(adjacencyList.get(currentNode) != null) {
            for (GraphNode child : adjacencyList.get(currentNode)) {
                if (!child.visited) {
                    BFTQueue.add(child);
                    addToReachableSetofParent(parent, child);
                    child.visited = true;
                }
            }
        }
    }

    private void addToReachableSetofParent(GraphNode parent, GraphNode child) {
        HashSet<GraphNode> reachableSet = pathList.get(parent);
        reachableSet = (reachableSet == null) ? new HashSet<GraphNode>() : reachableSet;
        reachableSet.add(child);
        if(pathList.get(parent) == null){
            pathList.put(parent, reachableSet);
        }
    }

    public HashMap<GraphNode, HashSet<GraphNode>> getAdjacencyList() {
        return adjacencyList;
    }

    public HashMap<GraphNode, HashSet<GraphNode>> getPathList() {
        return pathList;
    }

    public HashSet<GraphNode> getVertices() {
        return vertices;
    }

    public static void main(String args[]){
        GraphNode v1 = new GraphNode("v1", false);
        GraphNode v2 = new GraphNode("v2", false);
        GraphNode v3 = new GraphNode("v3", false);

        Graph G = new Graph();
        G.addVertex(v1);
        G.addVertex(v2);
        G.addVertex(v3);

        G.addEdges(v1, v2);
        G.addEdges(v2, v3);

        G.buildPathListFromASource(v1);
        for(GraphNode g : G.pathList.get(v1)){
            System.out.print(g.data);
        }
    }
}
