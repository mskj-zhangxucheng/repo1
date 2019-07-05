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
public class LoginClient {

	public static void main(String[] args) throws Exception {
		System.out.println("-------------Client--------------");
		
		Socket client=new Socket("localhost",8888);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String username=br.readLine();
		System.out.println("���������룺");
		String userpwd=br.readLine();
		
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("username="+username+"&userpwd="+userpwd);
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String msg=dis.readUTF();
		System.out.println(msg);
	}

}
