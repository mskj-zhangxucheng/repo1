package Default;

import java.net.*;
import java.io.*;

public class UDPServer02 {

	public static void main(String[] args) throws Exception {
		byte[] flush=new byte[1024*64];
		
		DatagramSocket ds=new DatagramSocket(8999);
		DatagramPacket packet=new DatagramPacket(flush,flush.length);
		
		ds.receive(packet);
		
		ByteArrayInputStream bais=new ByteArrayInputStream(packet.getData());
		ObjectInputStream ois=new ObjectInputStream(bais);
		System.out.println(ois.readObject());
		
		ois.close();
		bais.close();
		ds.close();
		
	}

}
