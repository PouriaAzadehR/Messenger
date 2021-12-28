package com.company;

import java.io.*;

/**
 * this is a class which is used for making files ,writing to file and reading from file
 * @author pouri
 * @version 1
 * @since today
 */
public class FilesService {

    /**
     * this is a method for creating file
     * @param nameFile created
     * @return file
     */
    public File createFile(String nameFile){
        File txtFile = new File(nameFile);
        return txtFile;
    }

    /**
     * this is a method for writing to a file
     * @param writedFile outputFile
     * @param content which should be written
     */
    public void writeFile(File writedFile,String content){
        try {
            FileWriter writer = new FileWriter(writedFile.getName());
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is a method for reading from file
     * @param readFile which should be readed
     * @return content of file
     */
    public String readFile(File readFile){
        FileReader reader = null;
        String content="";
        try {
            reader = new FileReader(readFile.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // read every characer
        int ch = 0;
        while (true) {
            try {
                if ((ch = reader.read()) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            content+=ch;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
