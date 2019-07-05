package Default;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPTalkReceive implements Runnable{
	private DatagramSocket socket;
	private String from;
	private byte[] container;
	
	public UDPTalkReceive(int port,String from) {
		container=new byte[1024*64];
		this.from=from;
		try {
			socket=new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		DatagramPacket packet=new DatagramPacket(container,0,container.length);
		while(true) {
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] datas=packet.getData();
			String msg=new String(datas,0,datas.length);
			System.out.println(from+"หตฃบ"+msg);
			if(msg.equals("bye")) {
				break;
			}
		}
		socket.close();
	}
	
}
