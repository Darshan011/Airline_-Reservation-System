package exe.view;

import java.util.*;
import exe.model.flight_detail;
import exe.model.flight_travel;
import exe.model.hismodel;

public class passenger {
    static Scanner sc = new Scanner(System.in);

    public static void dataticket(String mail, String name) {

        display.displayfligthtravel(mail);
        System.out.println("Enter the  date for travel like(yyyy-mm-dd)");
        String date = sc.nextLine();
        his.singleticketdetail(date, mail, name);
    }

    public static void BookTicket(String mail, String name, String date) {
        System.out.print("Enter Flight Name:");
        String fname = sc.nextLine();
        System.out.print("Enter No. Of Seat :");
        String seat = sc.nextLine();
        if (hismodel.histroy(mail, name, seat, fname) && flight_travel.change(fname, date, seat)) {
            int orid = seatdet.toaddpassdet1(mail, seat);
            if (orid != 0) {
                System.out.println("Ticket booked");
                System.out.println("Your Order id " + orid);
            } else {
                System.out.println("booked failed");
            }
        } else {
            System.out.println("booked failed");
        }
        menu.passenger(mail, name);
    }

    public static void passhis(String mail, String name) {
        his.singlepassdetail(mail, name);
        menu.passenger(mail, name);
    }

    public static void passdeta(String mail, String name) {
        seatdet.displaydeta(mail);
        menu.passenger(mail, name);
    }

    public static void passhis1(String mail, String name) {
        his.singlepassdetail(mail, name);
    }

    public static void Cancel(String mail, String name) {
        passhis1(mail, name);
        System.out.println();
        sc.nextLine();
        System.out.print("Enter Flight Name:");
        String fname = sc.nextLine();
        System.out.print("Enter Date(yyyy-mm-dd):");
        String date = sc.nextLine();
        System.out.print("Enter Booking ID:");
        String seat = sc.nextLine();
        if (flight_travel.Cancell(fname, date, seat)) {
            System.out.println();
            System.out.println("1");
            if (hismodel.cancellhis(mail, fname, seat))
                System.out.println("Cancellation Succesful");
        } else {
            System.out.println();
            System.out.println("Try Again");
            Cancel(mail, name);
        }
        menu.passenger(mail, fname);
    }
}
