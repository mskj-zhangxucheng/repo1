package Default;

public class UDPTalkStudent {

	public static void main(String[] args) {
		new Thread(new UDPTalkSend(8888,"localhost",8889)).start();
		new Thread(new UDPTalkReceive(8890,"¿œ ¶")).start();
	}

}
