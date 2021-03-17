/**
 *@project: ucenter
 *@author: OP36964
 *@date: 2017年5月8日
 *@copyright: 2017 www.oppein.com Inc. All rights reserved.
 */
package com.oppein.mtds.customerabutment.domain.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Title:IdWorker 
 * Description: 
	* Twitter_Snowflake<br>
	* SnowFlake的结构如下(每部分用-分开):<br>
	* 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 -
	* 000000000000 <br>
	* 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
	* 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
	* 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间
	* ，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) /
	* (1000L * 60 * 60 * 24 * 365) = 69<br>
	* 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
	* 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
	* 加起来刚好64位，为一个Long型。<br>
	* SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，
	* SnowFlake每秒能够产生26万ID左右。
    */
public class IdWorker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4552234297005862159L;

	protected static final Logger LOG = LoggerFactory.getLogger(IdWorker.class);

	private long workerId;
	private long datacenterId;

	/** 毫秒内序列(0~4095) */
	private long sequence = 0L;

	/** 上次生成ID的时间截 */
	private long lastTimestamp = -1L;

	/** 开始时间截 
	 * 1288834974657 是 (Thu, 04 Nov 2010 01:42:54 GMT) 这一时刻到1970-01-01 00:00:00时刻所经过的毫秒数。
	 * 当前时刻减去1288834974657 的值刚好在2^41 里，因此占41位。 所以这个数是为了让时间戳占41位才特地算出来的。
	 *  */
	private final long twepoch = 1288834974657L;

	/** 机器id所占的位数 */
	private final long workerIdBits = 5L;

	/** 数据标识id所占的位数 */
	private final long datacenterIdBits = 5L;

	/** 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数) */
	private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

	/** 支持的最大数据标识id，结果是31 */
	private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

	/** 序列在id中占的位数 */
	private final long sequenceBits = 12L;

	/** 机器ID向左移12位 */
	private final long workerIdShift = sequenceBits;

	/** 数据标识id向左移17位(12+5) */
	private final long datacenterIdShift = sequenceBits + workerIdBits;

	/** 时间截向左移22位(5+5+12) */
	private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

	/** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
	private final long sequenceMask = -1L ^ (-1L << sequenceBits);

	/**
	 *  Constructor
	 * @param workerId the current worker id 工作ID (0~31).
	 * @param datacenterId the current data center id  数据中心ID (0~31).
	 */
	public IdWorker(long workerId, long datacenterId) {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",
					maxWorkerId));
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",
					maxDatacenterId));
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
		LOG.info(String
				.format("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
						timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId));
	}

	/**
	 * 产生18位唯一性数字ID串
	 * @return 18位数字ID串
	 */
	public synchronized long nextId() {
		long timestamp = timeGen();

		if (timestamp < lastTimestamp) {
			LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp));
			throw new BusinessException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;

		return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
				| (workerId << workerIdShift) | sequence;
	}

	private long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}

}
