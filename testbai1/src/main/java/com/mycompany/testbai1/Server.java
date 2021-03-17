
package com.mycompany.testbai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author htuan
 */
public class Server {
     public static void main(String[] args) throws IOException {
         System.out.println("com.mycompany.testbai1.Server.main()");
        ServerSocket server = new ServerSocket(8000);
        System.out.println("server dang doi ket noi");
        Socket client = server.accept();
        DataInputStream d = new DataInputStream(client.getInputStream());
        DataOutputStream dout = new DataOutputStream(client.getOutputStream());
        System.out.println("Server da connect thanh cong");
        int a = d.readInt();
        int tong = 0;
        while(a > 0){
          System.out.println(a%10);
          tong = tong + a%10;
           a = a/10;
         System.out.println(a);
        }
        dout.writeInt(tong);
        server.close();
        client.close();
}
}
