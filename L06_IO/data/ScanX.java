//import java.io.*;
//import java.util.Scanner;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class ScanX {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
   double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                System.out.println(s.next());
            }
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }   

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}

