package Default;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 双向
 * 创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 *
 */
public class LoginClient {

	public static void main(String[] args) throws Exception {
		System.out.println("-------------Client--------------");
		
		Socket client=new Socket("localhost",8888);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String username=br.readLine();
		System.out.println("请输入密码：");
		String userpwd=br.readLine();
		
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("username="+username+"&userpwd="+userpwd);
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String msg=dis.readUTF();
		System.out.println(msg);
	}

}
