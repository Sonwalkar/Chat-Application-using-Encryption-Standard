import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import Decryption.CeaserCypher;
import Encryption.*;

public class Client
{
    public static void main(String[] args) throws IOException
    {

        InetAddress ip = InetAddress.getLocalHost();
        int port = 5015;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket(ip, port);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		System.out.println("Enter your name:");
        String username=sc.nextLine();
		String receivedusername=dis.readUTF();
		dos.writeUTF(username);
		
		
		System.out.println("Enter message say bye to exit");
        while (true)
        {
            String inp = sc.nextLine();
            if(inp.equalsIgnoreCase("bye"))
            {
            	System.out.println("Closing server you said bye");
            	dos.writeUTF(inp);
            	System.exit(0);
            }
            else
            {
	            dos.writeUTF(String.valueOf(CaesarCipher.encrypt(inp)));

	            String deCode = String.valueOf(CeaserCypher.decrypt(dis.readUTF()));

	            System.out.println(receivedusername+": "+deCode);
            }
        }
    }
}

