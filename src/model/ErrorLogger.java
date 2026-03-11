package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ErrorLogger {
    public static void logError(String errorType, String errorData){
        try{
            String path = "C:\\Users\\DeLL\\Desktop\\bank\\error_log.txt";

            FileWriter fw = new FileWriter(path, true);

            fw.write(LocalDateTime.now() + " | "
                    + errorType + " | "
                    + errorData + "\n");

            fw.close();

        }catch(IOException e){
            System.out.println("Error writing log file");
        }
    }

    public static void readErrorLog(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DeLL\\Desktop\\bank\\error_log.txt"));

            String line;

            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            br.close();

        }catch(Exception e){
            System.out.println("Error reading log file");
        }
    }
}
