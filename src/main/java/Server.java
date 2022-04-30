import MyHttp.HttpRequest;
import MyHttp.HttpRequestManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Simea");
        connectToServer();
    }

    public static void connectToServer() {
        try {
            ServerSocket socket = new ServerSocket(8080);
            Socket connectionSocket = socket.accept();
            InputStream socketInputStream = connectionSocket.getInputStream();
            OutputStream socketOutputStream = connectionSocket.getOutputStream();
            Scanner scanner = new Scanner(socketInputStream);
            PrintWriter serverPrintOut = new PrintWriter(
                    new OutputStreamWriter(socketOutputStream, StandardCharsets.UTF_8), true
            );
            //String request = scanner.useDelimiter("\0").next();
            //System.out.println(request);
            //HttpRequest httpRequest = new HttpRequest(request);
            //HttpRequestManager requestManager = new HttpRequestManager(httpRequest);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            connectionSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
