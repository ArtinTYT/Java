package day0918_网络编程;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Receive {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(10000);
		Socket socket = serverSocket.accept();
		InputStream stream = socket.getInputStream();
		byte[] bs = new byte[1024];
		int len = 0;
		while ( (len=stream.read(bs)) != -1 ) {
			System.out.println( new String(bs, 0, len));
		}
		
	}
}
