package exe.view;

import java.util.*;
import exe.model.flight_travel;
import exe.model.hismodel;

public class his {
    public static void singleticketdetail(String date, String mail, String name) {
        System.out.println("Display the ticket details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = flight_travel.displayticket(mail, date);
        for (Object e : result)
            System.out.println(e);
        passenger.BookTicket(mail, name, date);
    }

    public static void singlepassdetail(String mail, String name) {
        System.out.println("Display the ticket details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = hismodel.singlepassdetail(mail, name);
        for (Object e : result)
            System.out.println(e);
        // BookTicket(mail, name);
    }

    public static void View(String mail) {
        System.out.println("Display the ticket details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = hismodel.View();
        for (Object e : result)
            System.out.println(e);
        // BookTicket(mail, name);
        menu.admin(mail);
    }
}
