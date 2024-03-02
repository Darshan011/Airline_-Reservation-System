package exe.view;

import java.util.ArrayList;
import java.util.Scanner;

import exe.model.passdet;

public class seatdet {
    static Scanner sc = new Scanner(System.in);

    public static int toaddpassdet1(String mail, String n) {
        int c = 0, orid = 0;
        int nn = Integer.parseInt(n);
        for (int i = 0; i < nn; i++) {
            sc.nextLine();
            System.out.println("Enter the name");
            String name = sc.nextLine();
            System.out.println("Enter the Age");
            int age = sc.nextInt();
            System.out.println("Enter the PassBook");
            int passbook = sc.nextInt();
            orid = passdet.addpassdet(mail, name, age, passbook);
            if (orid != 0) {

                c++;
            }

        }
        if (c == nn) {
            return orid;
        }
        return 0;
    }

    public static void displaydeta(String mail) {
        System.out.println("Display the passenger details ");
        System.out.println("Enter the Order Id :");
        // System.out.println("DT_ID start point end point aviable seatS price");
        int orderid = sc.nextInt();
        ArrayList<Object> result = new ArrayList<>();
        result = passdet.dispassdet(mail, orderid);
        for (Object e : result)
            System.out.println(e);
    }
}
