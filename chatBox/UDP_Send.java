package day0918_网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * 通过datagramSocke发送数据，接收数据
 *
 */
public class UDP_Send{
	public static void main(String[] args) throws Exception {
		
		InetAddress iAddress = InetAddress.getLocalHost();
		InetAddress otheraddress = InetAddress.getByName("www.baidu.com");
		System.out.println(iAddress);
		System.out.println(otheraddress.getHostAddress());
		
		// 发送数据
		byte[] buf = "hello DatagramSocket".getBytes();
		DatagramSocket ds = new DatagramSocket();
		DatagramPacket dP1 = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);
		ds.send( dP1);
		ds.close();
		
		
		
		
	}
}










