package com.training.advanced.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioMain {
	public static void main(final String[] args) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.limit(512);
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress("localhost",
		                                               8090));
		SocketChannel scoketChannel = serverSocketChannel.accept();

		ReadThread readThread = new ReadThread(scoketChannel);
		readThread.start();
		Thread.sleep(Long.MAX_VALUE);
	}
}
