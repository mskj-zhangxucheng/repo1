package Default;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPTypeClient {

	public static void main(String[] args) throws IOException {
		System.out.println("----------∑¢ÀÕ∑Ω∆Ù∂Ø÷–-----------");
		
		DatagramSocket client=new DatagramSocket(9999);

		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		
		dos.writeUTF("±‡¬Î–¡À·¿·");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		
		byte[] datas=baos.toByteArray();
		
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8888));
		client.send(packet);
		
		client.close();
	}

}
