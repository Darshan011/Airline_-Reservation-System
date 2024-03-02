package exe.view;

import java.util.*;

import exe.model.flight_detail;
import exe.model.flight_travel;
import exe.model.flight_detail;

public class display {
    static Scanner sc = new Scanner(System.in);

    public static void displaydetailshow(String mail) {
        System.out.println("Display the ticket details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = flight_detail.flightdetail(mail);
        for (Object e : result)
            System.out.println(e);
    }

    public static void displayfligthtravel(String mail) {
        System.out.println("Display the ticket details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = flight_travel.flighttravel(mail);
        for (Object e : result)
            System.out.println(e);
    }

    public static void singledetail(String mail) {
        System.out.println("Display the ticket details ");
        System.out.println();
        // System.out.println("DT_ID start point end point aviable seatS price");
        ArrayList<Object> result = new ArrayList<>();
        result = flight_travel.flighttravel(mail);
        for (Object e : result)
            System.out.println(e);
    }
}
