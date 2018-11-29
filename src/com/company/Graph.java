package com.company;

import java.util.LinkedList;

public class Graph {
    int vertices;
    int currentPos =0;
    static int matrix[][];

    public void addEdge(int source, int destination, int weight) {
        //add edge
        if (source < destination) {
            matrix[source][destination] = weight;
        }
    }


    public Graph(int vertex) {
        this.vertices = vertex;
        matrix = new int[vertex][vertex];
    }

    public void print(int source, int [] key){
        System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
        for (int i = 0; i <vertices ; i++) {
            System.out.println("Source Post: " + source + " to result post " +   + i +
                    " Cost: " + key[i]);
        }
    }
    int getMinimumVertex(boolean [] mst, int [] key){
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i <vertices ; i++) {
            if(mst[i]==false && minKey>key[i]){
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }
    public void dijkstra_GetMinCost(int source, int numVerticies){
        boolean[] spt = new boolean[numVerticies];
        int [] cost = new int[numVerticies];
        int MAX_INT = Integer.MAX_VALUE;

        //Set the init cost to maximum integer value
        for (int i = 0; i <numVerticies ; i++) {
            cost[i] = MAX_INT;
        }

        //start from the vertex 0
        cost[source] = 0;

        //create SPT
        for (int i = 0; i <numVerticies ; i++) {

            //get the vertex with the minimum cost
            int vertex_U = getMinimumVertex(spt, cost);

            //include this vertex in SPT
            spt[vertex_U] = true;

            //iterate through all the adjacent vertices of above vertex and update the keys
            for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
                //check of the edge between vertex_U and vertex_V
                if(matrix[vertex_U][vertex_V]>0){
                    //check if this vertex 'vertex_V' already in spt and
                    // if cost[vertex_V]!=Infinity

                    if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=MAX_INT){
                        //check if cost needs an update or not
                        //means check total weight from source to vertex_V is less than
                        //the current cost value, if yes then update the cost

                        int newKey =  matrix[vertex_U][vertex_V] + cost[vertex_U];
                        if(newKey<cost[vertex_V])
                            cost[vertex_V] = newKey;
                    }
                }
            }
        }
        //print shortest path tree
        print(source, cost);
        System.out.println("hello");
    }


}