package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        String userHome=System.getProperty("user.home");
        String directoryPath=userHome+ File.separator+"Desktop"+File.separator+"bank";
        String fileName="error_log.txt";

        File sourceFile=new File(directoryPath+File.separator+fileName);

        FileWriter fileWriter=new FileWriter(sourceFile);
        fileWriter.close();

    }
}
