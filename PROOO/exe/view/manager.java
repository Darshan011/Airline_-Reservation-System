package exe.view;

import java.util.Scanner;
import java.util.ArrayList;
import exe.model.flight_detail;
import exe.model.flight_travel;

public class manager {
    static Scanner sc = new Scanner(System.in);

    public static void viewtheflight(String mail) {
        System.out.println("Display the flight details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = flight_detail.singledetail(mail);
        for (Object e : result)
            System.out.println(e);
        menu.managermenu(mail);
    }

    public static void changeseatno(String mail) {
        System.out.println("Enter the name of flight ");
        String f_name = sc.nextLine();
        System.out.println("Enter the update seat number ");
        String updateseat = sc.nextLine();
        if (flight_detail.editseat(f_name, updateseat, mail)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Updated failed");
            changeseatno(mail);
        }
        menu.managermenu(mail);

    }

    public static void updateprice(String mail) {
        System.out.println("Update price ");
        System.out.println("Enter the flight name");
        String f_name = sc.nextLine();
        System.out.println("Enter the update price ");
        String price = sc.nextLine();
        if (flight_travel.changeprice(f_name, price, mail)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Updated failed");
            changeseatno(mail);
        }
        menu.managermenu(mail);
    }

    public static void renameflight(String mail) {
        System.out.println("Rename flight ");
        System.out.println("Enter the flight name");
        String f_name = sc.nextLine();
        System.out.println("Enter the new flight name ");
        String newname = sc.nextLine();
        if (flight_detail.editf_name(f_name, newname, mail)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Updated failed");
            renameflight(mail);
        }
        menu.managermenu(mail);
    }

    public static void exit(String mail) {
        Main.Index();

    }
    // public static void dataticket(String mail, String name) {
    // System.out.println("Enter the date for travel like(yyyy-mm-dd)");
    // String date = sc.nextLine();
    // his.singleticketdetail(date, mail, name);
    // }
}
