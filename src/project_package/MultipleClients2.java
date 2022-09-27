package project_package;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;



public class MultipleClients2 extends Thread {
	
	
	final private Socket socket2;
	
	public MultipleClients2(Socket socket2) 
	{
		this.socket2 = socket2;
	}
	
	public void run() {
		try {
			System.out.println("Connected Succesfully with socket2..");
		DataInputStream input = new DataInputStream(socket2.getInputStream());
		
		DataOutputStream output = new DataOutputStream(socket2.getOutputStream());
		
		String user=input.readUTF();
		System.out.println(user);
		if(user.equalsIgnoreCase("s"));
		{
			File dirs=new File("E:\\PROJECTS\\Project Network V1\\src\\project_package\\dirs.txt");
			FileInputStream  fileinput2=new FileInputStream (dirs);
			Scanner file_entery2=new Scanner(fileinput2);
			while(file_entery2.hasNext())
			{
			    //n=file_entery2.nextLine();
				output.writeUTF(file_entery2.nextLine());
			}
			output.writeUTF("Your Choice: ");
			String choice;
			choice=input.readUTF();
			System.out.println(choice);
			
			FileInputStream sending_files;
			int sending_bytes;
			if(choice.equalsIgnoreCase("movies") || choice.equalsIgnoreCase("1"))
			{
				output.writeUTF("Your files are : \n\t[1]Joker\n\t[2]Free Fire\n\t[3]War\n Your choice:");
				choice=input.readUTF();
				if(choice.equalsIgnoreCase("Joker") || choice.equalsIgnoreCase("1")) {
					output.writeUTF("Joker.pdf");
					
					sending_files=new FileInputStream("E:\\PROJECTS\\Project Network V1\\src\\project_package\\Movies\\a.pdf");
					byte b[]=new byte[100000];
					//sending_files.read(b, 0, b.length);
					java.io.OutputStream os=socket2.getOutputStream();
					//os.write(b,0,b.length);
					while((sending_bytes=sending_files.read()) != -1)
					{
						output.writeBoolean(true);
						os.write(sending_bytes);
						
		            }
					if((sending_bytes=sending_files.read()) != -1)
						output.writeBoolean(true);
					
				}
				else if(choice.equalsIgnoreCase("Free Fire") || choice.equalsIgnoreCase("2"))
				{
					
				}
				else if(choice.equalsIgnoreCase("War") || choice.equalsIgnoreCase("3"))
				{
					
				}
			
			else if(choice.equalsIgnoreCase("music") || choice.equalsIgnoreCase("2"))
			{
				output.writeUTF("Your files are : \n\t[1]Hello\n\t[2]Beliver\n\t[3]Dynasty\nYour choice:");
				choice=input.readUTF();
				if(choice.equalsIgnoreCase("Hello") || choice.equalsIgnoreCase("1")) {
					
				}
				else if(choice.equalsIgnoreCase("Beliver") || choice.equalsIgnoreCase("2"))
				{
					
				}
				else if(choice.equalsIgnoreCase("Dynasty") || choice.equalsIgnoreCase("3"))
				{
					
				}
			}
			else if(choice.equalsIgnoreCase("docs") || choice.equalsIgnoreCase("3"))
			{
				output.writeUTF("Your files are : \n\t[1]Network\n\t[2]Math \n\t[3]Logic\nYour choice:");
				choice=input.readUTF();
				if(choice.equalsIgnoreCase("Network") || choice.equalsIgnoreCase("1")) {
					
				}
				else if(choice.equalsIgnoreCase("Math") || choice.equalsIgnoreCase("2"))
				{
					
				}
				else if(choice.equalsIgnoreCase("Logic") || choice.equalsIgnoreCase("3"))
				{
					
				}
			}
		}}}catch (IOException e) {
			
		}
		
		
	
	}}

