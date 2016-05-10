//package com.qpwa.foundation.util.push;
//
//import com.baidu.yun.push.client.BaiduPushClient;
//import com.baidu.yun.push.constants.BaiduPushConstants;
//import com.baidu.yun.push.exception.PushClientException;
//import com.baidu.yun.push.exception.PushServerException;
//import com.baidu.yun.push.model.PushBatchUniMsgRequest;
//import com.baidu.yun.push.model.PushBatchUniMsgResponse;
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
// * @Description: TODO 安卓手机百度推送工具类
// * @author: RogerFan
// * @date: 2016年5月7日 下午5:19:18
// */
//public class AndroidPushUtil extends BasePushUtil {
//	// 访问令牌，可通过该值获得开发者app的信息
//	private static String apiKey = "Tq1WydP5AYeFbImX6pBGdwF4";
//	// 与apiKey成对出现，用于app的合法身份验证
//	private static String secretKey = "QMu0GWw0nXcqkvOUEPjTq4PYsFqXuxRI";
//
//	/**
//	 * 
//	 * @Title: AndroidPushMsgToSingleDevice 
//	 * @Description: TODO 【向单个设备推送消息】
//	 * @param title          通知标题，可以为空；如果为空则设为appid对应的应用名;
//	 * @param description    通知文本内容，不能为空;
//	 * @param open_type      点击通知后的行为(1：打开Url; 2：自定义行为；);
//	 * @param url            需要打开的Url地址，open_type为1时才有效;
//	 * @param pkg_content    需要打开对应的app组件，open_type为2时才有效;
//	 * @param channelId      设备ID
//	 * @param messageType    1：通知,0:透传消息. 默认为0 注：IOS只有通知.
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void AndroidPushMsgToSingleDevice(String title, String description, String open_type, String url,
//			String pkg_content, String channelId, Integer messageType) throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		// 如果消息类型为空则默认通知类型
//		if(messageType == null || messageType.equals("") ){
//			messageType = 1;
//		}
//		try {
//			// 4. specify request arguments
//			// 创建 Android的通知
//			JSONObject notification = new JSONObject();
//			notification.put("title", title);// 通知标题，可以为空；如果为空则设为appid对应的应用名;
//			notification.put("description", description);// 通知文本内容，不能为空;
//			notification.put("notification_builder_id", 0);// android客户端自定义通知样式，如果没有设置默认为0;
//			notification.put("notification_basic_style", 4);// 只有notification_builder_id为0时有效，可以设置通知的基本样式包括(响铃：0x04;振动：0x02;可清除：0x01;),这是一个flag整形，每一位代表一种样式,如果想选择任意两种或三种通知样式，notification_basic_style的值即为对应样式数值相加后的值。
//			notification.put("open_type", 1);// 点击通知后的行为(1：打开Url; 2：自定义行为；);
//			notification.put("url", url);// 需要打开的Url地址，open_type为1时才有效;
//			// open_type为2时才有效，Android端SDK会把pkg_content字符串转换成Android
//			// Intent,通过该Intent打开对应app组件，所以pkg_content字符串格式必须遵循Intent
//			// uri格式，最简单的方法可以通过Intent方法toURI()获取
//			notification.put("pkg_content", pkg_content);
//			JSONObject jsonCustormCont = new JSONObject();
//			jsonCustormCont.put("key", "value"); // 自定义内容，key-value
//			notification.put("custom_content", jsonCustormCont);// 自定义内容，键值对，Json对象形式(可选)；在android客户端，这些键值对将以Intent中的extra进行传递。
//			
//			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
//					.addChannelId(channelId)// 客户端ID
//					.addMsgExpires(new Integer(86400 * 7))// message有效时间，秒
//					.addMessageType(messageType)// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
//					.addMessage(notification.toString())// 消息内容
//					.addDeviceType(3);//设置设备类型，deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.
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
//	 * @Title: AndroidPushBatchUniMsg 
//	 * @Description: TODO  【推送消息给批量设备（批量单播）】
//	 * @param title          通知标题，可以为空；如果为空则设为appid对应的应用名;
//	 * @param description    通知文本内容，不能为空;
//	 * @param open_type      点击通知后的行为(1：打开Url; 2：自定义行为；);
//	 * @param url            需要打开的Url地址，open_type为1时才有效;
//	 * @param pkg_content    需要打开对应的app组件，open_type为2时才有效;
//	 * @param channelIds     设备ID
//	 * @param messageType    1：通知,0:透传消息. 默认为0 注：IOS只有通知.
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void AndroidPushBatchUniMsg(String title, String description, String open_type, String url,
//			String pkg_content, String[] channelIds, Integer messageType) throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		// 如果消息类型为空则默认通知类型
//		if(messageType == null || messageType.equals("") ){
//			messageType = 1;
//		}
//		try {
//			// 4. specify request arguments
//			// 创建Android通知
//			JSONObject notification = new JSONObject();
//			notification.put("title", title);
//			notification.put("description", description);
//			notification.put("notification_builder_id", 0);
//			notification.put("notification_basic_style", 4);
//			notification.put("open_type", open_type);
//			notification.put("url", url);
//			JSONObject jsonCustormCont = new JSONObject();
//			jsonCustormCont.put("key", "value"); // 自定义内容，key-value
//			notification.put("custom_content", jsonCustormCont);
//			notification.put("pkg_content", pkg_content);
//
//			PushBatchUniMsgRequest request = new PushBatchUniMsgRequest()
//					.addChannelIds(channelIds)
//					.addMsgExpires(new Integer(3600))
//					.addMessageType(messageType)
//					.addMessage(notification.toString())
//					.addDeviceType(3)
//					.addTopicId("BaiduPush");// 设置类别主题
//			// 5. http request
//			PushBatchUniMsgResponse response = pushClient.pushBatchUniMsg(request);
//			// Http请求结果解析打印
//			System.out.println(String.format("msgId: %s, sendTime: %d", response.getMsgId(), response.getSendTime()));
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
//	 * @Title: AndroidPushMsgToTag 
//	 * @Description: TODO   【向绑定到tag中的用户推送消息，即普通组播。】
//	 * @param description         廣播內容
//	 * @param tagName             組名
//	 * @param sendTime            發送時間
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void AndroidPushMsgToTag(String description, String tagName, long sendTime)
//			throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		try {
//			// 4. specify request arguments
//			// pushTagTpye = 1 for common tag pushing
//			PushMsgToTagRequest request = new PushMsgToTagRequest().addTagName(tagName).addMsgExpires(new Integer(3600))
//					.addMessageType(0) // 添加透传消息
//					.addSendTime(sendTime) // 设置定时任务
//					.addMessage(description)
//					.addDeviceType(3);
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
//	 * @Title: AndroidPushMsgToAll 
//	 * @Description: TODO 【推送消息给所有设备，即广播推送】
//	 * @param description      广播内容
//	 * @param sendTime         发送时间（定时，多少秒后发送）
//	 * @throws PushClientException
//	 * @throws PushServerException
//	 * @return: void
//	 */
//	public static void AndroidPushMsgToAll(String description, long sendTime) throws PushClientException, PushServerException {
//		BaiduPushClient pushClient = createPushObject(apiKey, secretKey);
//		try {
//			// 4. specify request arguments
//			PushMsgToAllRequest request = new PushMsgToAllRequest()
//					.addMsgExpires(new Integer(86400 * 7))// message有效时间，秒
//					.addMessageType(0)// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
//					.addMessage(description) // 消息内容
//					.addSendTime(sendTime) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
//					.addDeviceType(3);
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
