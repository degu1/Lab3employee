package UIMaker;

import java.util.InputMismatchException;
import  java.util.Scanner;

public class UIMaker {

    static Scanner  sc = new Scanner(System.in);

    public static int menu(String[] input, String zeroChoice) {

        for (int i = 0; i < input.length; i++) {
            System.out.println(i + 1 + ". " + input[i]);
        }
        System.out.println("0. " + zeroChoice);
        
        while (true) {
            int choice = enterInt("Make your choice: ");
            System.out.println("");
            if (0 <= choice && choice <= input.length) {
                return choice;
            } else {
                System.out.println("Bad entery");
                System.out.println("");
            }
        }
    }

    public static int menu(String title, String[] input, String zeroChoice) {
        System.out.println("--- " + title + " ---");
        return menu(input, zeroChoice);
    }

    public static String enterString(String question) {
        System.out.print(question);
        String str = sc.nextLine();
        System.out.println("");
        return str;
    }

    public static int enterInt(String question) {

        while (true) {
            try {
                System.out.print(question);
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Bad entery");
                System.out.println("");
            }
        }
    }
}
