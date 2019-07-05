package Default;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetAddressTest01 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr =InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		InetAddress addr1=InetAddress.getByName("www.sxt.cn");
		System.out.println(addr1.getHostAddress());
		System.out.println(addr1.getHostName());
		
		InetAddress addr2=InetAddress.getByName("59.110.14.7");
		System.out.println(addr1.getHostAddress());
		System.out.println(addr1.getHostName());
		
		InetSocketAddress socketAddress1=new InetSocketAddress("localhost",8080);
		InetSocketAddress socketAddress2=new InetSocketAddress("127.0.0.1",9000);
		System.out.println(socketAddress1.getPort());
		System.out.println(socketAddress1.getHostName());
		System.out.println(socketAddress1.getAddress());
		System.out.println(socketAddress2.getPort());
		System.out.println(socketAddress2.getHostName());
		System.out.println(socketAddress2.getAddress());

	}
}
