package day0918_网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Receive {

	
	public static void main(String[] args) throws Exception {
		// 接收数据
			DatagramSocket ds2 = new DatagramSocket( 8888 );
			
			byte[] buf2 = new byte[1024];
			DatagramPacket dP2 = new DatagramPacket(buf2, buf2.length);
			
			ds2.receive(dP2);
			
			InetAddress inet = dP2.getAddress();
			System.out.println("sendHostName:  "+inet.getHostName());
			
			byte[] bs = dP2.getData();
			String aString = new String(bs, 0, dP2.getLength());
			System.out.println(aString);
			
			ds2.close();
	}
}
