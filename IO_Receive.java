package day0918_网络编程;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class IO_Receive {
	public static void main(String[] args) throws Exception {
		// 客户端套接字
		ServerSocket serverSocket = new ServerSocket(20000);
		// 监听服务端
		Socket socket = serverSocket.accept();
		// 管道读取流
		InputStream stream = socket.getInputStream();
		// 读取文件名称
		byte[] bs = new byte[200];
		stream.read(bs);
		String fileName = new String(bs).trim();	// 文件名称
		//写数据到硬盘文件的流
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("/Users/Cookie/Desktop/"+fileName)), true );
		
		//读取客户单文件内容
		byte[] y = new byte[1024];
		int len = 0;
		while ( (len=stream.read(y)) != -1 ) {
			//将文件内容写到硬盘上
			printWriter.println(new String(y, 0, len));
		}
	}
}
