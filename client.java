import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        int portno = s.nextInt();

        Socket socket = new Socket("localhost", portno); // Server's IP address and port number

        // Get input stream from the socket
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        // Read file size from the server
        int fileSize = dataInputStream.readInt();

        // Read file data from the server
        byte[] fileBytes = new byte[fileSize];
        dataInputStream.readFully(fileBytes, 0, fileSize);

        // Specify the location to save the received file
        //./file.txt
        String outputfile = s.next();

        FileOutputStream fileOutputStream = new FileOutputStream(outputfile);

        // Write the file data to the output file
        fileOutputStream.write(fileBytes, 0, fileSize);

        System.out.println("File received from server.");

        // Close streams and socket
        fileOutputStream.close();
        dataInputStream.close();
        socket.close();
        s.close();
    }
}
