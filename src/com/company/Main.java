package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {
        String file = args[0]; // String that holds the file name passed through command line arguments
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
            int maxCount = Integer.valueOf(reader.readLine());
            int count = 1;
            String line; // String that holds the line that is read in
            // Reads in all of the lines and prints node1 new line break for each new graph
            while ((line = reader.readLine()) != null) {
                if (count > 1) {
                    System.out.println();
                }
                System.out.println("com.company.Graph" + count + ":");
                count += 1;


            }

            System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + file);
        } catch (IOException e) {
            System.out.println("Error reading " + file + ": " + e);
        }

    }
}
