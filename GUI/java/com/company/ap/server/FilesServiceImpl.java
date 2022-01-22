package com.company.ap.server;
import com.company.ap.server.services.FileService;

import java.io.*;
import java.util.ArrayList;

/**
 * this is a class which is used for making files ,writing to file and reading from file
 * @author pouri
 * @version 1
 * @since today
 */
public class FilesServiceImpl implements FileService ,Serializable{

    /**
     * this is a method for creating file
     * @param nameFile created
     * @return file
     */
    public File createFile(String nameFile){
        return new File(nameFile);
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

    /**
     * this is a method for saving servers object
     * @param written1 data of server
     * @param written2 data of server
     * @param written3 data of server
     * @param written4 data of server
     */
    public void writeObjectServer(Object written1,Object written2,Object written3,Object written4) {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(("server.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(written1);
            o.writeObject(written2);
            o.writeObject(written3);
            o.writeObject(written4);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readObjectServer(){

    }
}
