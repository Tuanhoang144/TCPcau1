
package com.mycompany.testbai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author htuan
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8000);
        DataInputStream d = new DataInputStream(client.getInputStream());
        DataOutputStream dout = new DataOutputStream(client.getOutputStream());
        Scanner nhap = new Scanner(System.in);
        Boolean check = false;
        while (!check) 
        {            
            try
            {
                System.out.println("Nhap so nguyen a: ");
                int a = nhap.nextInt();
                check = true;
                dout.writeInt(a);
            }
            catch(Exception e)
            {
                System.out.println("Vui long nhap so ");
                nhap.nextLine();
            }
        }
        int tong = d.readInt();
        System.out.println("tong so nguyen a la: " + tong);
        client.close();
}
}
