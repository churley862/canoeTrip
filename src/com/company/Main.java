package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String file = args[0]; // String that holds the file name passed through command line arguments
        int numVertices = 0;

        Graph graph = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
            String firstLine = reader.readLine();

            numVertices = Integer.valueOf(firstLine);
            Graph graph1 = new Graph(numVertices);
            int count = 1;
            String line; // String that holds the line that is read in
            // Reads in all of the lines and prints node1 new line break for each new graph
            int row = 0;
            int col = 0;
            while ((line = reader.readLine()) != null) {
                Scanner strParse = new Scanner(line);
                while(strParse.hasNextInt()) {
                    col++;
                    int temp = strParse.nextInt();
                    System.out.println("edge added at " + row + "," + col);
                    graph1.addEdge(row, col, temp);
                }
                col = row+1;
                row++;
            }
            graph1.dijkstra_GetMinCost(0,numVertices);

            System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + file);
        } catch (IOException e) {
            System.out.println("Error reading " + file + ": " + e);

            graph = new Graph(numVertices);
        }
    }
}

