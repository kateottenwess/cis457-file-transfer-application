import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9876); // Port number

        System.out.println("Server waiting for client on port 9876...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getInetAddress());

            // Specify the file to be transferred
            File file = new File("C:\\Users\\sarah\\OneDrive\\Documents\\GVSU\\Year5\\CIS-457\\project\\sample.txt");

            // Create input stream from file
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] fileBytes = new byte[(int) file.length()];
            fileInputStream.read(fileBytes);

            // Get the output stream from the socket
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            // Send file size to the client
            dataOutputStream.writeInt(fileBytes.length);

            // Send file data to the client
            dataOutputStream.write(fileBytes, 0, fileBytes.length);

            System.out.println("File sent to client.");

            // Close streams and socket
            fileInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
        }
    }
}
