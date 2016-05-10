//package com.qpwa.foundation.util.push;
//
//import com.baidu.yun.core.log.YunLogEvent;
//import com.baidu.yun.core.log.YunLogHandler;
//import com.baidu.yun.push.auth.PushKeyPair;
//import com.baidu.yun.push.client.BaiduPushClient;
//import com.baidu.yun.push.constants.BaiduPushConstants;
//
//public class BasePushUtil {
//	/*
//	 * @Title: createPushObject
//	 * @Description: 创建推送对象
//	 * @return
//	 * @return: BaiduPushClient
//	 */
//	protected static BaiduPushClient createPushObject(String apiKey, String secretKey) {
//		// 1. 创建PushKeyPair 用于app的合法身份认证 apikey和secretKey可在应用详情中获取
//		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
//		// 2. 创建BaiduPushClient，访问SDK接口
//		BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
//		// 3. 注册YunLogHandler，获取本次请求的交互信息
//		pushClient.setChannelLogHandler(new YunLogHandler() {
//			@Override
//			public void onHandle(YunLogEvent event) {
//				System.out.println(event.getMessage());
//			}
//		});
//		return pushClient;
//	}
//}
