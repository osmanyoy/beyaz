package com.training.advanced.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ReadThread extends Thread {

	private SocketChannel sc;

	public ReadThread(final SocketChannel sc) {
		super();
		this.sc = sc;
	}

	@Override
	public void run() {
		ByteBuffer pByteBuffer = ByteBuffer.allocate(2048);
		while (true) {
			try {
				int readCount = 0;
				pByteBuffer.clear();
				pByteBuffer.limit(4);
				do {
					readCount = this.sc.read(pByteBuffer);
					if (readCount == -1) {
						System.out.println("Connection closed.");
						return;
					}
				} while (pByteBuffer.position() != 4);
				pByteBuffer.position(0);
				final int pduSize = pByteBuffer.getInt();
				pByteBuffer.limit(pduSize + 4);
				do {
					readCount = this.sc.read(pByteBuffer);
					if (readCount == -1) {
						System.out.println("Connection closed.");
						return;
					}
				} while (pByteBuffer.position() != (pduSize + 4));
				byte[] by = new byte[pduSize + 4];
				pByteBuffer.position(0);
				pByteBuffer.get(by);
				String string = new String(by,
				                           Charset.forName("UTF-8"));
				System.out.println("Result : " + string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
