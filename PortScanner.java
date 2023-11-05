import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PortScanner {

    public static void main(String[] args) {
        System.out.println("PORT SCANNER");

        if (args.length == 1) {
            String target = args[0];
            scanPorts(target);
        } else {
            System.out.println("Invalid amount of Argument");
        }
    }

    public static void scanPorts(String target) {
        System.out.println("-".repeat(50));
        System.out.println("Scanning Target: " + target);
        System.out.println("Scanning started at: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("-".repeat(50));

        try {
            for (int port = 1; port <= 65535; port++) {
                Socket socket = new Socket();
                socket.setSoTimeout(1000);

                try {
                    socket.connect(new InetSocketAddress(target, port));
                    System.out.println("Port " + port + " is open");
                } catch (IOException e) {
                    // Port is closed or unreachable
                } finally {
                    socket.close();
                }
            }
        } catch (Exception e) {
            System.out.println("\nExiting Program !!!!"); // Handle exceptions properly in a real application
            e.printStackTrace();
            System.exit(1);
        }
    }
}