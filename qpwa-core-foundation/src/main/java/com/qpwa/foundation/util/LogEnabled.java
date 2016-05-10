package com.qpwa.foundation.util;

import org.apache.log4j.Logger;

/**
 * 统一日志接口
 *
 */
public abstract interface LogEnabled {
	public static final Logger log = Logger.getLogger(LogEnabled.class);
}