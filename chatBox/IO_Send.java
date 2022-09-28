package day0918_网络编程;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.net.Socket;
import java.util.Arrays;

public class IO_Send {
	public static void main(String[] args) throws Exception {
		// 客户端套接字
		Socket socket =  new Socket("127.0.0.1", 20000);
		
		// 文件
		File file = new File("/Users/Cookie/Desktop/compileTest/a.txt");

		byte[] bs = file.getName().getBytes();	 // 文件名称
		byte[] buf = Arrays.copyOf(bs, 200);	//  文件名占200
		
		ByteArrayInputStream byteStream = new ByteArrayInputStream(buf);	// 读取文件名的流
		FileInputStream fileStream = new FileInputStream(file);				// 读取文件内容的流
		
		// 合并流
		SequenceInputStream sequenceStream = new SequenceInputStream(byteStream, fileStream);
		
		// 管道输出流
		BufferedOutputStream buffStream = new BufferedOutputStream(socket.getOutputStream());
		
		// 读取文件数据
		byte[] bs2 = new byte[1024];
		int len = 0;
		while ( (len=sequenceStream.read(bs2)) != -1 ) {
			// 发送数据到服务端
			buffStream.write(bs2, 0, len);
		}
		
		// 关闭
		buffStream.flush();
		sequenceStream.close();
		socket.close();
		
	}
}
