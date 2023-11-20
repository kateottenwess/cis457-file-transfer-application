/**
 * Kate Ottenwess & Sarah Wight
 * CIS 457-02
 * Term Project
 * Due Date: 12/4/2023
 */

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client Class
 */
public class client {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        // takes user input for port number
        System.out.println("Enter port number: ");
        int portNum = s.nextInt();

        // creates socket with server's IP address and port number
        Socket socket = new Socket("localhost", portNum); 

        // get input stream from socket
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        // read file size from server
        int fileSize = dataInputStream.readInt();

        // read file data from server
        byte[] fileBytes = new byte[fileSize];
        dataInputStream.readFully(fileBytes, 0, fileSize);

        // specify location to save received file
        System.out.println("Enter destination path for received file: ");
        String outputfile = s.next();

        // create output stream from file
        FileOutputStream fileOutputStream = new FileOutputStream(outputfile);

        // write file data to output file
        fileOutputStream.write(fileBytes, 0, fileSize);

        System.out.println("File received from server.");

        // close streams and socket
        fileOutputStream.close();
        dataInputStream.close();
        socket.close();
        s.close();
    }
}
