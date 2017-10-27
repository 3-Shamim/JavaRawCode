/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufferreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author MD SHAMIM
 */
public class BufferReader {

    private static void BufferReader() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            double y = Double.parseDouble(br.readLine());
            System.out.println(s);
            System.out.println(x);
            System.out.println(y);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void WriteToFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile("input.txt", "rw");
            String s = "Shamim";
            String p = "2015000000003";
            String a = "SEU";
            raf.writeBytes(s + "\r\n");
            raf.writeBytes(p + "\r\n");
            raf.writeBytes(a + "\r\n");
            System.out.println("Successfully Write.");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void ReadToFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
            while (true) {
                String s = raf.readLine();
                if (s == null) {
                    break;
                }
                System.out.println(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void task1() {
        try {
            RandomAccessFile inputFile = new RandomAccessFile("numbers.txt", "r");

//            int n = Integer.parseInt(inputFile.readLine());

            ArrayList<Integer> numbersList = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                numbersList.add(Integer.parseInt(inputFile.readLine()));
            }

            int sum = 0;
            for (Integer num : numbersList) {
                sum = sum + num;
            }

            System.out.println("Sum is " + sum);

            // home work: do the min, max and average calculations
            // challenge: try to compute the standard deviation
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found!");
        } catch (IOException ioe) {
            System.err.println("IOException");
        }
    }

    public static void main(String[] args) {
//        BufferReader();
//        WriteToFile();
        ReadToFile();
//        task1();
    }

}
