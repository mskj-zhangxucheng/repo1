package Default;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		URL u=new URL("http://www.google.cn:80/webhp#aa?canhu=33");
		System.out.println(u.toString());
		System.out.println("获取与此URL关联的默认接口："+u.getDefaultPort());
		System.out.println("文件名："+u.getFile());
		System.out.println("主机名："+u.getHost());
		System.out.println("路径："+u.getPath());
		System.out.println("端口："+u.getPort());
		System.out.println("协议："+u.getProtocol());
		System.out.println("参数："+u.getQuery());
		System.out.println("锚点："+u.getRef());
		
		URL u1=new URL("http://abc/aa/");
		URL u2=new URL(u1,"2.html");
		System.out.println(u2.toString());
	}

}
