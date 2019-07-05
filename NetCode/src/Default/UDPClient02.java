package Default;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
public class UDPClient02 {

	public static void main(String[] args) throws IOException {
		Person person=new Person("snow",18);
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(baos);
		oos.writeObject(person);
		
		byte[] flush=baos.toByteArray();
		
		DatagramSocket ds=new DatagramSocket(9000);
		DatagramPacket packet=new DatagramPacket(flush,flush.length,new InetSocketAddress("localhost",8999));
		
		ds.send(packet);
		ds.close();
		
		
	}

}
