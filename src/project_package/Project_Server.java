package project_package;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Project_Server {
	
	private static ServerSocket serversocket;
	private static Socket socket;
	
	public static void main(String[] args)
	{
		try {
			System.out.println("Satarting To create serversocket...");
			serversocket=new ServerSocket(5000);
			System.out.println("Serversocket created successfully Waiting for Connection with Client...");
			while (true) {
			socket=serversocket.accept();
			System.out.println("Socket Successfully connected");
			
			Thread client = new MultipleClients(socket);

			client.start();}
			
		} catch (IOException e) {
			System.out.println("Failed To connect");
		}
		
		
	}

}
