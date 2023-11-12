import java.util.Scanner;
import java.io.IOException;
import java.net.ServerSocket;

public class client {

    void error(String message) {
        //TODO
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int sockfd, portno, n;

        portno = s.nextInt();

        try {
            ServerSocket serverSocket = new ServerSocket(portno);
        }
        catch(IOException err) {
            System.out.println("Error creating socket");
        }
    }
}