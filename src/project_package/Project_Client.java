package project_package;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Project_Client {
	
	private static Socket socket;	
	static FileOutputStream fos;
	static BufferedOutputStream bos;

	public static void main(String[] args)
	{
		InputStream is;
		try 
		{
			
			socket=new Socket("localhost",5000);
			
			DataInputStream input=new DataInputStream(socket.getInputStream());
			DataOutputStream output=new DataOutputStream(socket.getOutputStream());
			
			Scanner uesr_enter=new Scanner(System.in);
			
			String username=null;
			String pass=null,user=null;
			boolean namechecker=false,passchecker=false;
			System.out.println("Enter Username: ");
			username=uesr_enter.nextLine();
			output.writeUTF(username);
			namechecker=input.readBoolean();
			
			if(namechecker)
			{
				System.out.println("Enter Password: ");
				pass=uesr_enter.nextLine();
				output.writeUTF(pass);
				passchecker=input.readBoolean();
			}
		
			if(passchecker)
			{
				Socket socket2=new Socket("localhost",4000);
				DataInputStream input2=new DataInputStream(socket2.getInputStream());
				DataOutputStream output2=new DataOutputStream(socket2.getOutputStream());
				System.out.println("Enter the command: ");
				user=uesr_enter.nextLine();
				output2.writeUTF(user);
			    for(int i=0;i<4;i++)
				{
					System.out.println(input2.readUTF());
				}
			
				System.out.println(input2.readUTF());
				String choice;
				choice=uesr_enter.nextLine();
				output2.writeUTF(choice);
				System.out.println(input2.readUTF());
				choice=uesr_enter.nextLine();
				output2.writeUTF(choice);
				System.out.println(input2.readUTF());
				String filename=input2.readUTF();
				FileOutputStream reciv_files=new FileOutputStream("E:\\PROJECTS\\Project Network V1\\src\\project_package\\Client\\"+filename);
				int reciv_bytes;
				boolean condition=true;
				byte b[]=new byte[100000];
				InputStream ist=socket2.getInputStream();
			//	ist.read(b,0,b.length);
			//	reciv_files.write(b,0,b.length);
				
				while(condition)
				{
					condition=input2.readBoolean();
					if(!condition)
						break;
					reciv_bytes=ist.read();
					reciv_files.write(reciv_bytes);
					
				}
				reciv_files.close();
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
