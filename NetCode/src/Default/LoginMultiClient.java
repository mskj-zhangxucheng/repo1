package Default;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ˫��
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 *
 */
public class LoginMultiClient {

	public static void main(String[] args) throws Exception {
		System.out.println("-------------Client--------------");
		
		Socket client=new Socket("localhost",8888);
		
		new Send(client).send();
		new Receive(client).receive();
	}
	
	static class Send {
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader console;
		private String msg;
		private String username,userpwd;
		
		public Send(Socket client) {
			this.client=client;
			
			console=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("�������û���");
			
			try {
				username=console.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("����������");;
			try {
				userpwd=console.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			msg="";
			msg="username="+username+"&userpwd="+userpwd;
			
		}
		
		public void send() {
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Receive {
		private Socket client;
		private DataInputStream dis;
		private String msg;
		
		public Receive(Socket client) {
			this.client=client;
			try {
				dis=new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void receive() {
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(msg);
		}
		
	}

}
