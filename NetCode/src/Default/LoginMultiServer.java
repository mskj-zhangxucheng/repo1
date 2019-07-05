package Default;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ˫��
 * ����������
 * 1��ָ���˿� ʹ��ServerSocket����������
 * 2������ʽ�ȴ����� accept
 * 3������: �������������
 * 4���ͷ���Դ 
 *
 */
public class LoginMultiServer {

	public static void main(String[] args) throws IOException {
		System.out.println("------------Server------------");
		
		ServerSocket server=new ServerSocket(8888);
		while(true) {
			Socket client=server.accept();
			System.out.println("һ���ͻ��˽�������");
			new Thread(new Channel(client)).start();
		}
		
		
		
	}
	
	static class Channel implements Runnable{
		private Socket client;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		public Channel(Socket client) {
			this.client=client;
			try {
				dis=new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return msg;
		}
		
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void release(){
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String username="";
			String userpwd="";
			String[] infos=receive().split("&");
			for(String info:infos) {
				String[] userinfo=info.split("=");
				if(userinfo[0].equals("username")) {
					System.out.println("����û���Ϊ��"+userinfo[1]);
					username=userinfo[1];
					
				}else if(userinfo[0].equals("userpwd")) {
					System.out.println("�������Ϊ��"+userinfo[1]);
					userpwd=userinfo[1];
				}
			}
			if(username.equals("zhangxucheng")&&userpwd.equals("02270835")) {
				send("��½�ɹ�");
			}else {
				send("��½ʧ��");
			}
			
			release();
		}
		
	}
}
