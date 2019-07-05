package Default;

public class UDPTalkTeacher {

	public static void main(String[] args) {
		new Thread(new UDPTalkReceive(8889,"Ñ§Éú")).start();
		new Thread(new UDPTalkSend(8891,"localhost",8890)).start();
	}

}
