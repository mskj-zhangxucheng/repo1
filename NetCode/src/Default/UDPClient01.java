package Default;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient01 {

	public static void main(String[] args) throws Exception {
		byte[] flush="This is the test code".getBytes();
		DatagramPacket packet=new DatagramPacket(flush,flush.length,new InetSocketAddress("localhost",8999));
		DatagramSocket ds=new DatagramSocket(9000);
		ds.send(packet);
		ds.close();
	}

}
