import java.io.*;
import java.util.Scanner;

public class WritingFiles {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("What file would you like to create?");
        String fileName = scan.nextLine();
        fileName = fileName.trim();



        System.out.println("What new file would you like to create?");
        fileName = scan.nextLine();



    }
}
