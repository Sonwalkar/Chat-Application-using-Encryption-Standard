import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.sql.*;

import Decryption.*;
import Encryption.*;

public class Server {
    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(5015);
        System.out.println("Waiting for client");
        Socket s = ss.accept();
        Scanner sc = new Scanner(System.in);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		System.out.println("Enter your name:");
		String username=sc.nextLine();
		dos.writeUTF(username);
		String receieveusername=dis.readUTF();
		
         while (true) {
            String input = dis.readUTF();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("bye bye ");
                System.exit(0);
            } else {
                //decryption
                String decode = String.valueOf(CeaserCypher.decrypt(input));
                System.out.println(receieveusername+": " + decode);
               // System.out.println("Enter reply");
                String reply = sc.nextLine();
                String encryptMsg = String.valueOf(CaesarCipher.encrypt(reply));
                dos.writeUTF(encryptMsg);
            }
        }
    }
}

