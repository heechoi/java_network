package java_network;

import java.net.MalformedURLException;
import java.net.URL;

public class ParseURL {
	public static void main(String[] args) {
		URL opinion = null;
		URL homePage = null;
		
		//http://www.dgit.or.kr/SUB/?ctId=2
		
		try {
			homePage = new URL("http://www.dgit.or.kr:80"); //:80은 생략 가능
			opinion =  new URL(homePage,"SUB/?ctId=15");
			System.out.printf("protocal : %s%n",opinion.getProtocol());
			System.out.printf("host : %s%n",opinion.getHost());
			System.out.printf("port : %s%n",opinion.getPort());
			System.out.printf("path : %s%n",opinion.getPath());
			System.out.printf("filename : %s",opinion.getFile());
		} catch (MalformedURLException e) {
			System.err.println("잘못된 URL 주소");
			e.printStackTrace();
		}
	}
}
