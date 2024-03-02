package exe.view;

import java.util.Scanner;

import exe.controller.vad;

public class sign {
    static Scanner sc = new Scanner(System.in);

    public static void In() {
        System.out.println("---SignIn---");
        System.out.println("Enter the mail id :");
        String mail = sc.nextLine();
        System.out.println("Enter the Password :");
        String pass = sc.nextLine();
        String ret = vad.vadIn(mail, pass);
        if (ret != null) {
            String g[] = ret.split(",");
            if (g[1].equals("passenger")) {
                System.out.println("Welcome " + g[0]);
                menu.passenger(mail, g[0]);
            } else if (g[1].equals("manager")) {
                System.out.println("Welcome " + g[0]);
                menu.managermenu(mail);
            } else if (g[1].equals("admin")) {
                System.out.println("Welcome " + g[0]);
                menu.admin(mail);
            }
        } else {
            System.out.println(" Inalid input ");
            System.out.println();
            In();
        }
    }

    public static void Up() {

        System.out.println("-------SignUp-------");
        System.out.println();
        System.out.println("Enter the  Name  :");
        String name = sc.nextLine();
        System.out.println("Enter the  mail ID  :");
        String mail = sc.nextLine();
        System.out.println("Enter the  Password least 8 characters :");
        String pass = sc.nextLine();

        String rt = vad.vadUp(name, mail, pass);
        if (rt.contains("Added")) {
            System.out.println(rt);
            In();

        } else if (rt.contains("Mail")) {
            System.out.println(rt);
            Up();
        } else {
            System.out.println("Unsuccessfully signed");
            sign.Up();
        }
    }

}
