import java.util.Scanner;
import java.io.IOException;
import java.net.ServerSocket;

public class client {

    void error(String message) {
        //TODO
    }


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        
        int sockfd, portno, n;

        portno = s.nextInt();

        //create socket
        ServerSocket serverSocket = new ServerSocket(portno);
    
        //connect to server
        serverSocket.accept();

        //close socket
        serverSocket.close();
    }
}