package Default;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer01 {

	public static void main(String[] args) throws Exception{
		byte[] flush=new byte[1024*64];
		DatagramSocket ds=new DatagramSocket(8999);
		DatagramPacket packet=new DatagramPacket(flush,flush.length);
		ds.receive(packet);
		String str=new String(packet.getData(),0,packet.getLength());
		System.out.println(str);
	}

}
