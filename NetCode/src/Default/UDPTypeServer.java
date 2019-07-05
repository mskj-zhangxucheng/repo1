package Default;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPTypeServer {

	public static void main(String[] args) throws Exception {
		System.out.println("-------接收方启动中-----------");
		
		DatagramSocket server=new DatagramSocket(8888);
		byte[] container=new byte[1024*64];
		DatagramPacket packet=new DatagramPacket(container,0,container.length);
		server.receive(packet);
		
		byte[] datas=packet.getData();
		int len=packet.getLength();
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		
		String msg = dis.readUTF(); 
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(msg+"-->"+flag);
		server.close();
	}

}
