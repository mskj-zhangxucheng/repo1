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
public class LoginServer {

	public static void main(String[] args) throws IOException {
System.out.println("------------Server------------");
		
		ServerSocket server=new ServerSocket(8888);
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽�������");
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String info=dis.readUTF();
		
		String[] infos=info.split("&");
		String username="";
		String userpwd="";
		for(String str:infos) {
			String[] userInfo=str.split("=");
			if(userInfo[0].equals("username")) {
				System.out.println("����û���Ϊ��"+userInfo[1]);
				username=userInfo[1];
				
			}else if(userInfo[0].equals("userpwd")) {
				System.out.println("�������Ϊ��"+userInfo[1]);
				userpwd=userInfo[1];
			}
		}
		
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(username.equals("zhangxucheng")&&userpwd.equals("02270835")) {
			dos.writeUTF("��½�ɹ�");
		}else {
			dos.writeUTF("��½ʧ��");
		}
	}

}
