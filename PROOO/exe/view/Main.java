package exe.view;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void Index() {
        System.out.println("-----Airline Reservation-----");
        System.out.println("-------Login-------");
        System.out.println("1. Signin");
        System.out.println("2 . Signup");
        System.out.println("");
        boolean aa = true;
        do {
            System.out.println("Enter the Option 1 or 2 :");
            int Option = sc.nextInt();
            if (Option == 1) {
                sign.In();
                aa = false;
            } else if (Option == 2) {
                sign.Up();
                aa = false;
            } else {
                System.out.println("Invalid Input");

            }

        } while (aa);

    }

    public static void main(String[] args) {
        Index();
    }
}