package com.qpwa.foundation.aspects;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.qpwa.foundation.annotations.LogToMongoDB;
import com.qpwa.mongo.MongodbBaseDao;
import com.qpwa.mongo.entity.UserOperLog;


@Aspect
@SuppressWarnings("unused")
public class RetrieveObjectsAspect {

	private static Logger logger = LoggerFactory.getLogger(RetrieveObjectsAspect.class);
	@Autowired
	MongodbBaseDao mongodb;
	Map<String,Integer> paramSelectMap = new HashMap<String, Integer>();

	@Pointcut("execution(@com.qpwa.foundation.annotations.LogToMongoDB * *(..))")
	public void logAnnotatedMethods() {
		// Extract from
		// https://eclipse.org/aspectj/doc/next/adk15notebook/ataspectj-pcadvice.html
		// As a general rule, the @Pointcut annotated method must have an empty
		// method body and must not have any throws clause. If formal are bound
		// (using args(), target(), this(), @args(), @target(), @this(),
		// @annotation()) in the pointcut, then they must appear in the method
		// signature.
	}

	@Around("logAnnotatedMethods()")
	public Object executeAround(ProceedingJoinPoint joinpoint) {
		Object result=null;//返回参数
		try {
		result = joinpoint.proceed();
		
		ResourceBundle rbint = ResourceBundle.getBundle("mongolog");//日志开关
		rbint.clearCache();
		String flag = rbint.getString("mongo.log.flag");
		System.out.println("mongo.log.flag=============="+flag);
		
		if("1".equals(flag)){
		
		System.out.println("log start--------------");
		
		Class target = joinpoint.getTarget().getClass();
		Method methods = ((MethodSignature) joinpoint.getSignature()).getMethod();
		LogToMongoDB logoMongo = methods.getAnnotation(LogToMongoDB.class);
		
		String userId=null;
		String productId=null;
		String source="B2B";
		String type = target.getName();
		String oper = methods.getName();
		JSONObject paramsJson = new JSONObject();
		JSONObject device = new JSONObject();
		
		HttpServletRequest request = null;
		Object[] params = joinpoint.getArgs();
		for(Object param : params) {
			if(param != null && param instanceof HttpServletRequest ) {
				request = (HttpServletRequest) param;
			}
		}
		
		Object obj = request.getSession().getAttribute("user");
		JSONObject userObj = JSONObject.fromObject(obj);
		if(!JSONUtils.isNull(userObj)) {
			userId = userObj.getString("userNo");
		} 
		
		device.put("data", request.getHeader("User-Agent"));//设备参数
		
		switch (logoMongo.type()) {//判断调用日志的类和方法
		case "product.prodDetails":
			productId=params[0].toString();
			paramsJson.put("productId", productId);
			break;
		case "product.search":
			paramsJson.put("keyword", request.getParameter("keyword"));
			break;
		case "cart.add":
			productId= request.getParameter("stkC");
			paramsJson.put("stkC", productId);
			break;
		case "productCategory.Children":
			paramsJson.put("id", params[0].toString());
			break;
		case "productCategory.Childrenson":
			paramsJson.put("id", params[0].toString());
			break;
		case "main.index":
			break;
		}
		
			UserOperLog u = new UserOperLog(
					userId,
					productId,
					type,
					oper,
					source,//B2B,B2BWAP,B2BAPP 
					logoMongo.memo(),
					device,//IE
					paramsJson);//request params
			System.out.println("mongo data =========================="+JSONObject.fromObject(u).toString());
			mongodb.insert(u);
			System.out.println("log end--------------");
		}else{
			System.out.println("log stop--------------");
		}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return result;
	}
//	
//	/**
//	 * 获取客户端的真实ip，解决因反向代理而获取不到真实ip的情况
//	 * @param request
//	 * @return
//	 */
//	public static String getIpAddr(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }
}
