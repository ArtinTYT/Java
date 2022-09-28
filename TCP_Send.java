package day0918_网络编程;

import java.io.OutputStream;
import java.net.Socket;

public class TCP_Send {
	public static void main(String[] args) throws Exception {
		 Socket socket = new Socket("127.0.0.1", 10000);
		 OutputStream stream = socket.getOutputStream();
		 stream.write("hello socket....".getBytes());
		 socket.close();
	}
}
