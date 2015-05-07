package bh.railcode.view;

import java.util.Scanner;

/**
 * Created by Barry Hollywood.
 * Main application interface.
 */
public class WelcomeView implements GenericView {
    public void display() {
        System.out.println("- - - Welcome to the Rail Service Information Application - - -");
        displayOptions();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        while(choice != 6){
            switch(choice){
                case 1:
                    new FindTheDistanceView().display();
                    scan.nextLine();
                    System.out.println("Press Enter to continue...");
                    scan.nextLine();
                    break;
                case 2:
                    new FindNumberOfTripsView().display();
                    scan.nextLine();
                    System.out.println("Press Enter to continue...");
                    scan.nextLine();
                    break;
                case 3:
                    new FindShortestRouteView().display();
                    scan.nextLine();
                    System.out.println("Press Enter to continue...");
                    scan.nextLine();
                    break;
                case 4:
                    new FindNumberOfRoutesView().display();
                    scan.nextLine();
                    System.out.println("Press Enter to continue...");
                    scan.nextLine();
                    break;
                case 5:
                    new FindTheDistanceView().display();
                    new FindNumberOfTripsView().display();
                    new FindShortestRouteView().display();
                    new FindNumberOfRoutesView().display();
                    scan.nextLine();
                    System.out.println("Press Enter to continue...");
                    scan.nextLine();
                    break;
                default:
                    System.out.println("Thank you for using the Rail Service Information Application.");
                    System.exit(0);
                    break;
            }
            displayOptions();
            choice = scan.nextInt();
        }
        scan.close();
    }

    private void displayOptions(){
        System.out.println("===================================================");
        System.out.println("|           Rail Service :: Options Menu          |");
        System.out.println("===================================================");
        System.out.println("|  Please choose from the following options:      |");
        System.out.println("|                                                 |");
        System.out.println("|     1. Find the Distance...                     |");
        System.out.println("|     2. Find the number of trips...              |");
        System.out.println("|     3. Find the length of the shortest route... |");
        System.out.println("|     4. Find the number of Routes...             |");
        System.out.println("|     5. Display all...                           |");
        System.out.println("|     6. Exit                                     |");
        System.out.println("===================================================");
        System.out.print("Enter choice: ");
        System.out.print("");
    }
}
