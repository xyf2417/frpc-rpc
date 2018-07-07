package xyf.frpc.rpc.util;

public class ByteUtil {
	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @return byte[].
	 */
	public static byte[] long2bytes(long v) {
		byte[] ret = { 0, 0, 0, 0, 0, 0, 0, 0 };
		long2bytes(v, ret);
		return ret;
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @param b
	 *            byte array.
	 */
	public static void long2bytes(long v, byte[] b) {
		long2bytes(v, b, 0);
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @param b
	 *            byte array.
	 * @param off
	 *            array offset.
	 */
	public static void long2bytes(long v, byte[] b, int off) {
		b[off + 7] = (byte) v;
		b[off + 6] = (byte) (v >>> 8);
		b[off + 5] = (byte) (v >>> 16);
		b[off + 4] = (byte) (v >>> 24);
		b[off + 3] = (byte) (v >>> 32);
		b[off + 2] = (byte) (v >>> 40);
		b[off + 1] = (byte) (v >>> 48);
		b[off + 0] = (byte) (v >>> 56);
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @return byte[].
	 */
	public static byte[] int2bytes(int v) {
		byte[] ret = { 0, 0, 0, 0 };
		int2bytes(v, ret);
		return ret;
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @param b
	 *            byte array.
	 */
	public static void int2bytes(int v, byte[] b) {
		int2bytes(v, b, 0);
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @param b
	 *            byte array.
	 * @param off
	 *            array offset.
	 */
	public static void int2bytes(int v, byte[] b, int off) {
		b[off + 3] = (byte) v;
		b[off + 2] = (byte) (v >>> 8);
		b[off + 1] = (byte) (v >>> 16);
		b[off + 0] = (byte) (v >>> 24);
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @return byte[].
	 */
	public static byte[] short2bytes(short v) {
		byte[] ret = { 0, 0 };
		short2bytes(v, ret);
		return ret;
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @param b
	 *            byte array.
	 */
	public static void short2bytes(short v, byte[] b) {
		short2bytes(v, b, 0);
	}

	/**
	 * to byte array.
	 * 
	 * @param v
	 *            value.
	 * @param b
	 *            byte array.
	 */
	public static void short2bytes(short v, byte[] b, int off) {
		b[off + 1] = (byte) v;
		b[off + 0] = (byte) (v >>> 8);
	}

	/**
	 * to int.
	 * 
	 * @param b
	 *            byte array.
	 * @return int.
	 */
	public static int bytes2int(byte[] b) {
		return bytes2int(b, 0);
	}

	/**
	 * to int.
	 * 
	 * @param b
	 *            byte array.
	 * @param off
	 *            offset.
	 * @return int.
	 */
	public static int bytes2int(byte[] b, int off) {
		return ((b[off + 3] & 0xFF) << 0) + ((b[off + 2] & 0xFF) << 8)
				+ ((b[off + 1] & 0xFF) << 16) + ((b[off + 0]) << 24);
	}

	/**
	 * to long.
	 * 
	 * @param b
	 *            byte array.
	 * @return long.
	 */
	public static long bytes2long(byte[] b) {
		return bytes2long(b, 0);
	}

	/**
	 * to long.
	 * 
	 * @param b
	 *            byte array.
	 * @param off
	 *            offset.
	 * @return long.
	 */
	public static long bytes2long(byte[] b, int off) {
		return ((b[off + 7] & 0xFFL) << 0) + ((b[off + 6] & 0xFFL) << 8)
				+ ((b[off + 5] & 0xFFL) << 16) + ((b[off + 4] & 0xFFL) << 24)
				+ ((b[off + 3] & 0xFFL) << 32) + ((b[off + 2] & 0xFFL) << 40)
				+ ((b[off + 1] & 0xFFL) << 48) + (((long) b[off + 0]) << 56);
	}

	/**
	 * to short.
	 * 
	 * @param b
	 *            byte array.
	 * @return short.
	 */
	public static short bytes2short(byte[] b) {
		return bytes2short(b, 0);
	}

	/**
	 * to short.
	 * 
	 * @param b
	 *            byte array.
	 * @param off
	 *            offset.
	 * @return short.
	 */
	public static short bytes2short(byte[] b, int off) {
		return (short) (((b[off + 1] & 0xFF) << 0) + ((b[off + 0]) << 8));
	}

}
