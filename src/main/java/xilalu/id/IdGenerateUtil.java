package com.oppein.mtds.customerabutment.domain.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * 生成ID工具类
 * @author op36964
 *
 */
public final class IdGenerateUtil {
	
	static IdWorker worker = new IdWorker(0,0);

	private IdGenerateUtil() {

	}

//	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


	/**
	 * 产生随机ID(可能会出现重复)
	 * @param count 位数
	 * @return
	 */
	public static String generateId(final int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	/**
	 * 返回固定18位唯一性ID
	 * 默认 worker id =0; data center id=0.
	 * @return 字符串数字ID
	 */
	public static String generateId(){
		 
		long  id = worker.nextId();
		return String.valueOf(id);
	}
	
	public static String generateId(int workerId,int dataCenterId){
		IdWorker worker = new IdWorker(workerId,dataCenterId);
		long  id = worker.nextId();
		return String.valueOf(id);
	}
	
	
	private static final String[] CHARS = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };

	/**
	 * 生成短的UUID (可能会出现重复)
	 * @return
	 */
	public static synchronized String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int temp = Integer.parseInt(str, 16);
			shortBuffer.append(CHARS[temp % 0x3E]);
		}
		return shortBuffer.toString();

	}

}
