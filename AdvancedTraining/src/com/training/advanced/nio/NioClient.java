package com.training.advanced.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class NioClient {
	public static void main(final String[] args) throws Exception {
		Path path = Paths.get(".");
		Path resolve = path.resolve("my.txt");
		Path copyTo = path.resolve("my_copy.txt");

		System.out.println(resolve.toAbsolutePath());
		List<String> readAllLines = Files.readAllLines(resolve,
		                                               Charset.forName("UTF-8"));

		Files.copy(resolve,
		           copyTo,
		           StandardCopyOption.REPLACE_EXISTING);

		ByteBuffer pByteBuffer = ByteBuffer.allocate(2048);

		SocketChannel openedSocket = SocketChannel.open();
		openedSocket.connect(new InetSocketAddress("localhost",
		                                           8090));

		for (int i = 0; i < 1_000; i++) {
			String string = "Test String " + i;
			byte[] bytes = string.getBytes(Charset.forName("UTF-8"));
			pByteBuffer.position(0);
			pByteBuffer.putInt(bytes.length);
			pByteBuffer.put(bytes);
			pByteBuffer.flip();
			openedSocket.write(pByteBuffer);
		}

	}
}
