package Default;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL u=new URL("http://www.google.cn:80/webhp#aa?canhu=33");
		System.out.println(u.toString());
		System.out.println("��ȡ���URL������Ĭ�Ͻӿڣ�"+u.getDefaultPort());
		System.out.println("�ļ�����"+u.getFile());
		System.out.println("��������"+u.getHost());
		System.out.println("·����"+u.getPath());
		System.out.println("�˿ڣ�"+u.getPort());
		System.out.println("Э�飺"+u.getProtocol());
		System.out.println("������"+u.getQuery());
		System.out.println("ê�㣺"+u.getRef());
		
		URL u1=new URL("http://abc/aa/");
		URL u2=new URL(u1,"2.html");
		System.out.println(u2.toString());
	}

}
