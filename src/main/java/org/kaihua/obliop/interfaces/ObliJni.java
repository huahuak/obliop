package org.kaihua.obliop.interfaces;

import java.nio.ByteBuffer;

import sun.nio.ch.DirectBuffer;

public class ObliJni {

	static {
		// System.load("/home/huahua/Projects/obliop/obliclient/target/debug/libobliclient.so");
		System.load("/root/lkh/java/libobliclient.so");
	}

	private static native String hello(String input);

	private static native void doObliDataSend(ByteBuffer buf, long ptr, int len);

	public static void ObliDataSend(ByteBuffer buf, Object ptr, Object len) {
		doObliDataSend(buf, ((DirectBuffer) buf).address(), (Integer) buf.capacity() - buf.position());
	}

	public static String doHello(String input) {
		return hello(input);
	}
}
