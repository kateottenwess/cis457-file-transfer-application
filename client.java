import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9876); // Server's IP address and port number

        // Get input stream from the socket
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        // Read file size from the server
        int fileSize = dataInputStream.readInt();

        // Read file data from the server
        byte[] fileBytes = new byte[fileSize];
        dataInputStream.readFully(fileBytes, 0, fileSize);

        // Specify the location to save the received file
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\sarah\\OneDrive\\Documents\\GVSU\\Year5\\CIS-457\\project\\cis457-file-transfer-application\\file.txt");

        // Write the file data to the output file
        fileOutputStream.write(fileBytes, 0, fileSize);

        System.out.println("File received from server.");

        // Close streams and socket
        fileOutputStream.close();
        dataInputStream.close();
        socket.close();
    }
}
