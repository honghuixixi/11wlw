//package com.qpwa.foundation.util.push;
//
//import com.baidu.yun.push.client.BaiduPushClient;
//import com.baidu.yun.push.constants.BaiduPushConstants;
//import com.baidu.yun.push.exception.PushClientException;
//import com.baidu.yun.push.exception.PushServerException;
//import com.baidu.yun.push.model.PushMsgToAllRequest;
//import com.baidu.yun.push.model.PushMsgToAllResponse;
//import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
//import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
//import com.baidu.yun.push.model.PushMsgToTagRequest;
//import com.baidu.yun.push.model.PushMsgToTagResponse;
//
//import net.sf.json.JSONObject;
//
///**
// * @ClassName: AndroidPushUtil
// * @Description: TODO  IOS手机百度推送工具类
// * @author: RogerFan
// * @date: 2016年5月7日 下午5:19:18
// */
//public class IOSPushUtil extends BasePushUtil{
//	// 访问令牌，可通过该值获得开发者app的信息
//	private static String apiKey = "";
//	// 与apiKey成对出现，用于app的合法身份验证
//	private static String secretKey = "";
//
//	/**
//	 * @Title: IOSPushNotificationToSingleDevice 
//	 * @Description: TODO 【向单个设备推送消息】
//	 * @param description    通知文本内容，不能为空;
//	 * @param channelId      设备ID
//	 * @param messageType    1：通知,0:透传消息. 默认为0 注：IOS只有通知.
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void IOSPushNotificationToSingleDevice(String description, String channelId, Integer messageType) throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		try {
//			// 4. specify request arguments
//			// 创建 Android的通知
//			JSONObject notification = new JSONObject();
//			JSONObject jsonAPS = new JSONObject();
//			jsonAPS.put("alert", description);// 其内容可以为字符串或者字典，如果是字符串，那么将会在通知中显示这条内容;
//			jsonAPS.put("sound", "default"); // 设置通知铃声样式，例如"ttt"，用户自定义。
////			jsonAPS.put("badge", 1);// 其值为数字，表示当通知到达设备时，应用的角标变为多少。如果没有使用这个字段，那么应用的角标将不会改变。设置为 0 时，会清除应用的角标;
//			notification.put("aps", jsonAPS);
//			notification.put("key1", "value1");
//			notification.put("key2", "value2");
//			
//			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
//					.addChannelId(channelId)// 客户端ID
//					.addMsgExpires(new Integer(86400 * 7))// message有效时间，秒
//					.addMessageType(messageType)// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
//					.addMessage(notification.toString())
//					.addDeployStatus(2)
//					.addDeviceType(4);//设置设备类型，deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
//			// 5. http request
//			PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
//			// Http请求结果解析打印
//			System.out.println("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime());
//		} catch (PushClientException e) {
//			/*
//			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
//			 */
//			if (BaiduPushConstants.ERROROPTTYPE) {
//				throw e;
//			} else {
//				e.printStackTrace();
//			}
//		} catch (PushServerException e) {
//			if (BaiduPushConstants.ERROROPTTYPE) {
//				throw e;
//			} else {
//				System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(),
//						e.getErrorCode(), e.getErrorMsg()));
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @Title: IOSPushNotificationToTag 
//	 * @Description: TODO   【向绑定到tag中的用户推送消息，即普通组播。】
//	 * @param description         广播内容
//	 * @param tagName             組名
//	 * @param sendTime            发送时间（定时，多少秒后发送）
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void IOSPushNotificationToTag(String description, String tagName, long sendTime)
//			throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		try {
//			// 4. specify request arguments
//			// make IOS Notification
//			JSONObject notification = new JSONObject();
//			JSONObject jsonAPS = new JSONObject();
//			jsonAPS.put("alert", description);
//			jsonAPS.put("sound", "default"); // 设置通知铃声样式，例如"ttt"，用户自定义。
//			notification.put("aps", jsonAPS);
//			notification.put("key1", "value1");
//			notification.put("key2", "value2");
//			// pushTagTpye = 1 for common tag pushing
//			PushMsgToTagRequest request = new PushMsgToTagRequest()
//					.addTagName(tagName) // 设置tag组
//					.addMsgExpires(new Integer(86400 * 7))// message有效时间，秒
//					.addMessageType(1) // 1：通知,0:透传消息.默认为0// 注：IOS只有通知.
//					.addSendTime(sendTime) //设置定时推送时间
//					.addMessage(notification.toString())
//					.addDeployStatus(2)// IOS,DeployStatus => 1:// Developer, 2:// Production.
//					.addDeviceType(4); // deviceType => 3:android, 4:ios
//			// 5. http request
//			PushMsgToTagResponse response = pushClient.pushMsgToTag(request);
//			// Http请求结果解析打印
//			System.out.println("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime() + ",timerId: "
//					+ response.getTimerId());
//		} catch (PushClientException e) {
//			/*
//			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
//			 */
//			if (BaiduPushConstants.ERROROPTTYPE) {
//				throw e;
//			} else {
//				e.printStackTrace();
//			}
//		} catch (PushServerException e) {
//			if (BaiduPushConstants.ERROROPTTYPE) {
//				throw e;
//			} else {
//				System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(),
//						e.getErrorCode(), e.getErrorMsg()));
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @Title: IOSPushNotificationToAll 
//	 * @Description: TODO 【推送消息给所有设备，即广播推送】
//	 * @param description      广播内容
//	 * @param sendTime         发送时间（定时，多少秒后发送）
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void IOSPushNotificationToAll(String description, long sendTime) throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		try {
//			// 4. specify request arguments
//			// 创建IOS通知
//			JSONObject notification = new JSONObject();
//			JSONObject jsonAPS = new JSONObject();
//			jsonAPS.put("alert", description);
//			jsonAPS.put("sound", "default"); // 设置通知铃声样式,例如"ttt"，用户自定义。
//			notification.put("aps", jsonAPS);
//			notification.put("key1", "value1");
//			notification.put("key2", "value2");
//			
//			PushMsgToAllRequest request = new PushMsgToAllRequest()
//					.addMsgExpires(new Integer(3600))
//					.addMessageType(1)
//					.addMessage(notification.toString())
//					.addSendTime(sendTime) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
//					.addDepolyStatus(2)
//					.addDeviceType(4);
//			// 5. http request
//			PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
//			// Http请求结果解析打印
//			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
//					+ response.getSendTime() + ",timerId: "
//					+ response.getTimerId());
//		} catch (PushClientException e) {
//			/*
//			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
//			 */
//			if (BaiduPushConstants.ERROROPTTYPE) {
//				throw e;
//			} else {
//				e.printStackTrace();
//			}
//		} catch (PushServerException e) {
//			if (BaiduPushConstants.ERROROPTTYPE) {
//				throw e;
//			} else {
//				System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(),
//						e.getErrorCode(), e.getErrorMsg()));
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * @Title: main 
//	 * @Description: TODO
//	 * @param args
//	 * @return: void
//	 */
//	public static void main(String[] args) {
//		
//	}
//}
