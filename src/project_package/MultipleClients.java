package project_package;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultipleClients extends Thread {
	
	
	final private Socket socket;
	
	public MultipleClients(Socket socket) 
	{
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			DataInputStream input = new DataInputStream(socket.getInputStream());
			
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			
			
			boolean condition=true;
			while(condition) {
				
				String username=input.readUTF();
				String pass=null;
				String n=null,p=null;
				boolean name_checking=true;
				
				File file=new File("E:\\PROJECTS\\Project Network V1\\src\\project_package\\a.txt");
				FileInputStream  fileinput=new FileInputStream (file);
				Scanner file_entery=new Scanner(fileinput);
				
				while(file_entery.hasNext())
				{
				
					n=file_entery.nextLine();
					p=file_entery.nextLine();
					if(username.equalsIgnoreCase(n))
					{
						name_checking=true;
						output.writeBoolean(name_checking);
						pass=input.readUTF();
		
						if(pass.equalsIgnoreCase(p))
						{
							System.out.println("Login Successfully");
							output.writeBoolean(true);
							
							ServerSocket serversocket2=new ServerSocket(4000);
							while(true) {
							Socket socket2=serversocket2.accept();
							Thread client2 = new MultipleClients2(socket2);

							client2.start();
							
							}
						}
						else 
							{
								System.out.println("You enterd wrong password, Closing Connection.. ");
								
								socket.close();
								
							}
					}
				
				}
			}
			
			
			
			
		} catch (IOException e) {
			
		}

		
		
		
			
	}
	

}

