/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part I
 */
package phoneNetworkApp;

import GraphFramework.KruskalAlg;
import GraphFramework.MHPrimAlg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public class PhoneNWDesignApp {
    
    public BluePrintsGraph PhLNetwork;

    public static void main(String[] args) throws FileNotFoundException {

        // Create a file object for the graph file
        File graphFile = new File("GraphFromFile.txt");

        // Check if the file exists
        if (!graphFile.exists()) {
            System.out.println("Graph file does not exists!");
            System.exit(0);
        }

        // Create a new BluePrintGraph object
        BluePrintsGraph PhLNetwork= new BluePrintsGraph();

        // Create a Scanner  to read user input 
        Scanner input = new Scanner(System.in);

        //  size of the graph
        int[] graphSize;

        // Enter a loop that runs until the program is terminated by the user
        while (true) {

            // Display a menu of options to the user and read their choice
            int choice = menu(input);
            // create object KruskalAlg and MHPrimAlg
            KruskalAlg ka;
            MHPrimAlg prim;
           
            switch (choice) {
                case 1:
                    // If the user chooses  read the graph from the file
                    PhLNetwork.readGraphFromFile(graphFile);
                    System.out.println("========================================================");
                    System.out.println("           Run the graph from file");
                    
                     // Generate an MST using Prim's algorithm and display the result
                   System.out.println("========================================================");
                   prim = new MHPrimAlg(PhLNetwork);
                   prim.displayResultingMST();
                    // Generate an MST using Kruskal's algorithm and display the result
                    System.out.println("========================================================");
                    ka = new KruskalAlg(PhLNetwork);
                    ka.displayResultingMST();
                    
                   
                    break;
                case 2:
                    // If the user chooses Make random graph., prompt them for the size of the graph
                    graphSize = menu2(input);
                    if (graphSize[0] == -1) {
                        /////////////////////////
                    } else {
                        // Otherwise, create a new graph using the specified size
                        PhLNetwork.makeGraph(graphSize[0], graphSize[1]);
                        
                        // Generate an MST using Kruskal's algorithm and display the result
                    System.out.println("========================================================");
                     ka = new KruskalAlg(PhLNetwork);
                    ka.displayResultingMST();
                    
                    // Generate an MST using Prim's algorithm and display the result
                   System.out.println("========================================================");
                    prim = new MHPrimAlg(PhLNetwork);
                   prim.displayResultingMST();
                    }
                    break;
                default:
                    // If the user chooses any other option, exit the program
                    System.out.println("========================================================");
                    System.out.println("Thank you for using Phone Network Design App.");
                    System.exit(0);
            }


        }

    }

    /**
     * This method displays a menu for the Phone Network Design App and prompts the user for their choice.
     *
     * @param input A Scanner object for reading user input
     * @return The user's choice as an integer
     */
    public static int menu(Scanner input){

        int choice = -1;

        // Display the app's name and a welcome message
        System.out.println("--------------------------------------------------------");
        System.out.println("--------- Welcome to Phone Network Design App ----------");
        System.out.println("--------------------------------------------------------");

        // Display the menu and prompt the user for their choice
        System.out.println("\nChoose one of these choices:");
        System.out.println("1:\t\tRun the graph from file.");
        System.out.println("2:\t\tMake random graph.");
        System.out.println("any:\tExit.");
        System.out.print("\nEnter your choice: ");

        try {
            // Read the user's input and store it as the choice variable
            choice = input.nextInt();
        } catch (Exception e) {
            // If an exception occurs while reading the user's input, print a message and exit gracefully
            System.out.println("========================================================");
            System.out.println("Thank you for using Phone Network Design App.");
            System.exit(0);
        }

        // Return the user's choice
        return choice;
    }

    /**
     * This method is used to generate a random graph based on the user's choice of the number of vertices and edges.
     * @param input A Scanner object used to read user input from the console.
     * @return An array of two integers representing the number of vertices and edges respectively, based on the user's choice.
     * If the user chooses to exit, an array of [-1,-1] is returned.
     */
    public static int[] menu2(Scanner input){
        int choice = -1;
        // Display the available choices to the user
        System.out.println("========================================================");
        System.out.println("Make random graph.");
        System.out.println("\nChoose the Number of Vertices and the number of Edges:");
        System.out.println("1:\t\t1,000 V , 10,000 E");
        System.out.println("2:\t\t1,000 V , 15,000 E");
        System.out.println("3:\t\t1,000 V , 25,000 E");
        System.out.println("4:\t\t5,000 V , 15,000 E");
        System.out.println("5:\t\t5,000 V , 25,000 E");
        System.out.println("6:\t\t10,000 V , 15,000 E");
        System.out.println("7:\t\t10,000 V , 25,000 E");
        System.out.println("any:\tExit.");
        System.out.print("\nEnter your choice: ");

        try {
            // Read the user's choice
            choice = input.nextInt();
        } catch (Exception e) {
            // If an exception occurs while reading user input, exit the program
            System.out.println("========================================================");
            System.out.println("Thank you for using Phone Network Design App.");
            System.exit(0);
        }

        // Based on the user's choice, return an array of the corresponding number of vertices and edges
        switch (choice) {
            case 1:
                return new int[]{1000,10000};
            case 2:
                return new int[]{1000,15000};
            case 3:
                return new int[]{1000,25000};
            case 4:
                return new int[]{5000,15000};
            case 5:
                return new int[]{5000,25000};
            case 6:
                return new int[]{10000,15000};
            case 7:
                return new int[]{10000,25000};
            default:
                // If the user chooses to exit, display a message and exit the program
                System.out.println("========================================================");
                System.out.println("Thank you for using Phone Network Design App.");
                System.exit(0);
        }
        // Return [-1,-1] if the user's choice is not recognized (should not happen)
        return new int[]{-1,-1};
    } 
}
