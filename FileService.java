package com.company;

import java.io.File;

/**
 * this is an interface for working with file
 * @author pouri
 * @version 1
 * @since today
 */
public interface FileService {

    /**
     * this is a method for creating file
     * @param nameFile created
     * @return file
     */
     File createFile(String nameFile);

    /**
     * this is a method for writing to a file
     * @param writedFile outputFile
     * @param content which should be written
     */
     void writeFile(String writedFile,String content);

    /**
     * this is a method for reading from file
     * @return content of file
     */
     String readFile(String readfil);

    /**
     * this is a method for reading last line of file
     * @param readFil read file
     * @return last line
     */
     String readLastLine(String readFil);
}
