package file;

import java.io.File;

public class CreateDirectory {

    public static void main(String[] args) {
        String userHome=System.getProperty("user.home");
        String directoryPath=userHome+ File.separator+"Desktop"+File.separator+"bank";
        File directoryFile=new File(directoryPath);
        if(!directoryFile.exists()){
            directoryFile.mkdirs();
        }
        else{
            System.out.println("Directory already exists !");
        }
    }
}
