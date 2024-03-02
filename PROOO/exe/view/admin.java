package exe.view;

import java.util.ArrayList;
import java.util.Scanner;
import exe.model.managermodel;
import exe.model.passengermodel;
import exe.controller.menuvad;
import exe.model.flight_detail;

public class admin {
    static Scanner sc = new Scanner(System.in);

    public static void addingmanager(String mail) {
        System.out.println(" Adding new Manager ");
        System.out.println("Enter the new manager name");
        String m_name = sc.nextLine();
        System.out.println("Enter the new manager mail id");
        String m_mail = sc.nextLine();
        System.out.println("Enter the password");
        String pass = sc.nextLine();
        System.out.println("Enter the new flight name to be handled by this manager");

        String f_name = sc.nextLine();
        if (menuvad.addman(m_name, m_mail, pass, f_name)) {
            if (managermodel.addingmanager(m_name, m_mail, f_name, pass)) {
                System.out.println("Added Successfully");

            } else {
                System.out.println("Adding failed");
            }

        }

        else

        {
            System.out.println("Enter the valid input");

        }
        menu.admin(mail);
    }

    public static void addingflight(String mail) {
        System.out.println(" Adding new Flight ");
        System.out.println("Enter the new Flight");
        String f_name = sc.nextLine();
        System.out.println("Enter the  manager mail id");
        String m_mail = sc.nextLine();
        System.out.println("Enter the number of seat");
        String seat = sc.nextLine();
        if (menuvad.manid(m_mail)) {
            if (flight_detail.addingflight(f_name, seat, m_mail)) {
                System.out.println("Added Successfully");

            } else {
                System.out.println("Adding failed");

            }
        } else {
            System.out.println("Entere the valid mail id ");

        }
        menu.admin(mail);
    }

    public static void viewmanagerdetial(String mail) {
        System.out.println("View manager detail");

        ArrayList<Object> result = new ArrayList<>();
        result = managermodel.displaymanager(mail);
        ;
        for (Object e : result)
            System.out.println(e);
        menu.admin(mail);

    }

    public static void viewmanagerdetials(String mail) {
        System.out.println("View manager detail");

        ArrayList<Object> result = new ArrayList<>();
        result = managermodel.displaymanager(mail);
        ;
        for (Object e : result)
            System.out.println(e);

    }

    public static void viewflightdetail(String mail) {
        System.out.println("View Flight detail");

        ArrayList<Object> result = new ArrayList<>();
        result = flight_detail.flightdetail(mail);

        for (Object e : result)
            System.out.println(e);
        menu.admin(mail);
    }

    public static void viewflightdetails(String mail) {
        System.out.println("View Flight detail");

        ArrayList<Object> result = new ArrayList<>();
        result = flight_detail.flightdetail(mail);

        for (Object e : result)
            System.out.println(e);

    }

    public static void viewpassengerdetail(String mail) {
        System.out.println("View Passenger detail");
        System.out.println();
        ArrayList<Object> result = new ArrayList<>();
        result = passengermodel.passengerdetail(mail);

        for (Object e : result)
            System.out.println(e);
        menu.admin(mail);
    }

    public static void viewpassengerdetails(String mail) {
        System.out.println("View Passenger detail");
        System.out.println();
        ArrayList<Object> result = new ArrayList<>();
        result = passengermodel.passengerdetail(mail);

        for (Object e : result)
            System.out.println(e);

    }

    public static void removeflight(String mail) {
        admin.viewflightdetails(mail);
        System.out.println("Remove  Flight detail");
        System.out.println("Enter the Flight name :");
        String f_name = sc.nextLine();
        System.out.println("Enter the manager mail id :");
        String m_mail = sc.nextLine();
        if (menuvad.manid(m_mail)) {
            if (flight_detail.toremoveflight(f_name, m_mail)) {
                System.out.println("Remove Successfully");

            } else {
                System.out.println("Remove failed");

            }
        } else {
            System.out.println("Enter the valid mail id ");
        }
        menu.admin(mail);
    }

    public static void removemanager(String mail) {
        admin.viewmanagerdetials(mail);
        System.out.println("Remove  manager detail");
        System.out.println("Enter the Flight name :");
        String f_name = sc.nextLine();
        System.out.println("Enter the manager mail id :");
        String m_mail = sc.nextLine();
        if (managermodel.toremovemanager(f_name, m_mail)) {
            System.out.println("Remove Successfully");

        } else {
            System.out.println("Remove failed");

        }
        menu.admin(mail);

    }

    public static void removepassenger(String mail) {
        admin.viewpassengerdetails(mail);
        System.out.println("Remove  passenger detail");

        System.out.println("Enter the passenger name :");
        String p_name = sc.nextLine();
        System.out.println("Enter the passenger id :");
        String p_mail = sc.nextLine();
        if (flight_detail.toremoveflight(p_name, p_mail)) {
            System.out.println("Remove Successfully");

        } else {
            System.out.println("Remove failed");

        }
        menu.admin(mail);
    }

    public static void exit(String mail) {
        Main.Index();

    }

    // public static void addflight(String mail) {
    // System.out.println("Add Flight detail");
    // System.out.println("Enter the new flight name");
    // String m_name = sc.nextLine();
    // System.out.println("Enter the n manager handling flight name");
    // String f_name = sc.nextLine();
    // if (managermodel.addingmanager(m_name, m_mail, f_name, pass)) {
    // System.out.println("Added Successfully");

    // } else {
    // System.out.println("Adding failed");

    // }
    // menu.admin(mail);
    // }
}
