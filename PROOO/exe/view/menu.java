package exe.view;

import java.util.Scanner;

import exe.model.flight_detail;
import exe.view.passenger;

public class menu {
    static Scanner sc = new Scanner(System.in);

    public static void passenger(String mail, String name) {
        System.out.println();
        System.out.println("---------Menu---------");
        System.out.println("1. Ticket Booking");
        System.out.println("2. View History ");
        System.out.println("3.Cancellation ");
        System.out.println("4. passenger detail ");

        System.out.println();
        System.out.println(" Enter the option");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                passenger.dataticket(mail, name);

                break;

            case 2:
                passenger.passhis(mail, name);
                break;

            case 3:
                passenger.Cancel(mail, name);
                break;
            case 4:
                passenger.passdeta(mail, name);
                break;

            default:
                System.out.println("Enter the Valid Input ");
                passenger(mail, name);
                break;
        }

    }

    public static void managermenu(String mail) {
        System.out.println();
        System.out.println("---------Menu---------");
        System.out.println("1. View the flight");
        // System.out.println("2.Ticket Booked View");
        // System.out.println("3. Update price ");
        System.out.println("2. Update seat numbers ");
        System.out.println("3. Rename flight name ");
        System.out.println("4. Signout ");

        System.out.println();
        System.out.println(" Enter the option");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                manager.viewtheflight(mail);
                ;
                break;

            // case 2:

            // break;
            // case :
            // manager.updateprice(mail);
            // break;
            case 2:
                manager.changeseatno(mail);
                break;
            case 3:
                manager.renameflight(mail);
                break;
            case 4:
                manager.exit(mail);
                break;

            default:
                System.out.println("Enter the Valid Input ");
                managermenu(mail);
                break;
        }
    }

    public static void admin(String mail) {
        System.out.println();
        System.out.println("---------Menu---------");
        System.out.println("1.Ticket Booked View");
        System.out.println("2. View manager detail ");
        System.out.println("3. Add manager ");
        System.out.println("4. Remove the manager ");
        System.out.println("5.View Flight detail ");
        System.out.println("6. Add Flight ");
        System.out.println("7. Remove the flight ");
        System.out.println("8.View Passenger detail ");
        System.out.println("9. Signout ");

        System.out.println();
        System.out.println(" Enter the option");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                his.View(mail);
                break;

            case 2:
                admin.viewmanagerdetial(mail);
                break;

            case 3:
                admin.addingmanager(mail);
                break;
            case 4:
                admin.removemanager(mail);
                break;
            case 5:
                admin.viewflightdetail(mail);
                break;
            case 6:
                admin.addingflight(mail);
                break;
            case 7:
                admin.removeflight(mail);
                break;
            case 8:
                admin.viewpassengerdetail(mail);
                break;
            // case 9:
            // admin.removepassenger(mail);
            // break;
            case 9:
                admin.exit(mail);
                break;

            default:
                System.out.println("Enter the Valid Input ");
                admin(mail);
                break;
        }
    }

}
