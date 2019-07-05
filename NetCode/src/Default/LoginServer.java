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
public class LoginServer {

	public static void main(String[] args) throws IOException {
System.out.println("------------Server------------");
		
		ServerSocket server=new ServerSocket(8888);
		Socket client=server.accept();
		System.out.println("一个客户端建立连接");
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String info=dis.readUTF();
		
		String[] infos=info.split("&");
		String username="";
		String userpwd="";
		for(String str:infos) {
			String[] userInfo=str.split("=");
			if(userInfo[0].equals("username")) {
				System.out.println("你的用户名为："+userInfo[1]);
				username=userInfo[1];
				
			}else if(userInfo[0].equals("userpwd")) {
				System.out.println("你的密码为："+userInfo[1]);
				userpwd=userInfo[1];
			}
		}
		
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(username.equals("zhangxucheng")&&userpwd.equals("02270835")) {
			dos.writeUTF("登陆成功");
		}else {
			dos.writeUTF("登陆失败");
		}
	}

}
