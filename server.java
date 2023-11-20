/**
 * Kate Ottenwess & Sarah Wight
 * CIS 457-02
 * Term Project
 * Due Date: 12/4/2023
 */

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Server Class
 */
public class server {
    public static void main(String[] args) throws Exception {
        
        Scanner s = new Scanner(System.in);

        // takes user input for port number
        System.out.println("Enter port number: ");
        int portNum = s.nextInt();

        // creates new server socket with the passed in port number
        ServerSocket serverSocket = new ServerSocket(portNum); 

        System.out.println("Server waiting for client on port " + portNum + "...");

        while (true) {

            // listening for a connection to be made to the server socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getInetAddress());

            // specify the path of the file to be transferred
            System.out.println("Enter path of the file to transfer: ");
            String path = s.next();
            File file = new File(path);

            // create input stream from file
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] fileBytes = new byte[(int) file.length()];
            fileInputStream.read(fileBytes);

            // get output stream from socket
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            // send file size to client
            dataOutputStream.writeInt(fileBytes.length);

            // send file data to client
            dataOutputStream.write(fileBytes, 0, fileBytes.length);

            System.out.println("File sent to client.");

            // close streams and sockets
            fileInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
            serverSocket.close();
            s.close();
            break;
        }
    }
}
