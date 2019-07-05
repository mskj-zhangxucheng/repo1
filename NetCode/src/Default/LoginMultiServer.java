package Default;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 双向
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 *
 */
public class LoginMultiServer {

	public static void main(String[] args) throws IOException {
		System.out.println("------------Server------------");
		
		ServerSocket server=new ServerSocket(8888);
		while(true) {
			Socket client=server.accept();
			System.out.println("一个客户端建立连接");
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
					System.out.println("你的用户名为："+userinfo[1]);
					username=userinfo[1];
					
				}else if(userinfo[0].equals("userpwd")) {
					System.out.println("你的密码为："+userinfo[1]);
					userpwd=userinfo[1];
				}
			}
			if(username.equals("zhangxucheng")&&userpwd.equals("02270835")) {
				send("登陆成功");
			}else {
				send("登陆失败");
			}
			
			release();
		}
		
	}
}
