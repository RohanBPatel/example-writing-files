import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WritingFiles {
    public static void main(String[] args) {

        ArrayList<String> nums = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> mix = new ArrayList<>();

        //if a file is located in the root
        //we can read it using FileReader and BufferedReader
        //FileReader gets name of file or path to the file
        //BufferedReader gets/uses FileReader object

        //try with resources, autocloses stuff placed in parentheses

        try (FileReader file = new FileReader("somenums.txt"); BufferedReader reader = new BufferedReader(file)) {

            String line;
            while ((line = reader.readLine()) != null) {
                //add the line we just read to the ArrayList
                nums.add(line);
            }//while

            FileReader file2 = new FileReader("somewords.txt");
            BufferedReader reader2 = new BufferedReader(file2);

            String wordLine = reader2.readLine();
            //System.out.println(wordLine);

            String[] wordsAll = wordLine.split("--");

            for (String s : wordsAll) {
                words.add(s);
            }

            //CLOSE STREAM

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = 0;

        //bad way to do this that wioll append the end of the list at the end
        while (index < nums.size() && index < words.size()) {
            mix.add(nums.get(index));
            mix.add(words.get(index));
            index++;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("What file would you like to create?");
        String fileName = scan.nextLine();
        fileName = fileName.trim();
        fileName += ".txt";

        //writers are similar to the reader setup
        //fileWriter gets file name and location
        //BufferedWriter gets FileWriter object
        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {//try with resources

            for (int i = 0; i < mix.size(); i++) {
                bw.write(mix.get(i) + "\n");
            }//for

            //without using a try with resources, we would have to flush() or close() the writers

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("What new file would you like to create?");
        //fileName = scan.nextLine();
    }
}
