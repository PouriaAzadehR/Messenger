package com.company;

import java.io.*;

/**
 * this is a class which is used for making files ,writing to file and reading from file
 * @author pouri
 * @version 1
 * @since today
 */
public class FilesServiceImpl implements FileService{

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
    public void writeFile(String writedFile,String content){
        try {
            FileWriter writer = new FileWriter(writedFile,true);
            writer.write(content+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is a method for reading from file
     * @return content of file
     */
    public String readFile(String readfil){
        FileReader reader = null;
        String content="";
        try {
            reader = new FileReader(readfil);
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

            content+=(char)ch;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * this is a method for reading last line of file
     * @param readFil read file
     * @return last line
     */
    public String readLastLine(String readFil){
        String[] content=readFile(readFil).split("\n");
        return content[content.length-1];
    }
}
