package Default;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��Ϥ����
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 *
 */
public class FirstClient {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Client-----------");
		
		//1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
		Socket client=new Socket("localhost",8888);
		
		//2������: �������������
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		
		//3���ͷ���Դ 
		dos.writeUTF("This is one test code");
		dos.close();
		client.close();
		
	}

}
