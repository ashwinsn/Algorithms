package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 3/10/16.
 */
public class GraphTest {

    Graph G;
    GraphNode v1, v2, v3;

    @Before
    public void setUp() throws Exception {
        v1 = new GraphNode("v1", false);
        v2 = new GraphNode("v2", false);
        v3 = new GraphNode("v3", false);

        G = new Graph();
        G.addVertex(v1);
        G.addVertex(v2);
        G.addVertex(v3);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddVertex() throws Exception {

    }

    @Test
    public void testAddEdgesPutsTheVertexinAdjacencyList() throws Exception {
        G.addEdges(v1, v2);
        assertThat(G.getAdjacencyList().get(v1).contains(v2), is(equalTo(true)));
    }

    @Test
    public void testAddEdgesCreatesVerticesForNewVertices() throws Exception{
        Graph someGraph = new Graph();
        GraphNode someVertex = new GraphNode("blah", false);
        GraphNode someotherVertex = new GraphNode("blah blah", false);

        someGraph.addEdges(someVertex, someotherVertex);

        assertThat(someGraph.getVertices().contains(someotherVertex), is(equalTo(true)));
        assertThat(someGraph.getVertices().contains(someVertex), is(equalTo(true)));
    }

    @Test
    public void testAddCurrentNodeChildrenToReachableSetOfParent() throws Exception{
        Graph someGraph = new Graph();
        GraphNode someVertex = new GraphNode("blah", false);
        GraphNode someotherVertex = new GraphNode("blah blah", false);
        GraphNode childOfSomeOtherVertex = new GraphNode("child of blah blah", false);

        someGraph.addEdges(someVertex, someotherVertex);
        someGraph.addEdges(someotherVertex, childOfSomeOtherVertex);

        someGraph.addCurrentNodeChildrenToReachableSetOfParent(someVertex, someVertex, new LinkedList<GraphNode>());
        someGraph.addCurrentNodeChildrenToReachableSetOfParent(someVertex, someotherVertex, new LinkedList<GraphNode>());
        assertThat(someGraph.getPathList().get(someVertex).contains(someotherVertex), is(equalTo(true)));
        assertThat(someGraph.getPathList().get(someVertex).contains(childOfSomeOtherVertex), is(equalTo(true)));
    }

    @Test
    public void testBuildPathListFromASource() throws Exception {
       G.addEdges(v1,v2);
       G.addEdges(v2,v3);

       G.buildPathListFromASource(v1);
       assertThat(G.getPathList().get(v1).contains(v3), is(equalTo(true)));
    }
}