package com.gluttonApp;

import com.datastax.driver.dse.DseCluster;
import com.datastax.driver.dse.DseSession;
import com.datastax.driver.dse.graph.GraphOptions;
import com.datastax.dse.graph.api.DseGraph;
import java.util.Scanner;



public class App {

    public static void main( String[] args )
    {
        DseSession session = connectToDatabase();
        DseCustomTraversalSource g = getGraphTraversalSource(session);

        displayMenu(g);

        session.close();
        System.exit(0);
    }

    public static void displayMenu(DseCustomTraversalSource g){
        int option = -1;
        while (option != 0)
        {
            option = showMenu();
            switch (option) {
                case 1:
                    //Get Gods Count
                    System.out.println(gods(g));
                    break;
                  default:
                    System.out.println("Sorry, please enter valid Option");
            }
        }

        System.out.println("Exiting GluttonApp, Bye!");
    }

    private static String godsTest(DseCustomTraversalSource g) {
        return g.V().actors().count().next();
    }

    public static int showMenu() {

        int option = -1;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Main Menu:");
        System.out.println("--------------");
        System.out.println("1) Get Count of gods");
        System.out.println("0) Quit");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        option = keyboard.nextInt();

        return option;
    }

    public static DseSession connectToDatabase(){
        DseCluster dseCluster = DseCluster.builder()
                .addContactPoint("127.0.0.1")
                .build();
        return dseCluster.connect();
    }

    public static DseCustomTraversalSource getGraphTraversalSource(DseSession session) {
        return DseGraph.traversal(session,
                new GraphOptions().setGraphName("STUDIO_TUTORIAL_GRAPH"), DseCustomTraversalSource.class);
    }


}
