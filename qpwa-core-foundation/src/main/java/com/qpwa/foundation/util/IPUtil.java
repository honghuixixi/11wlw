package com.qpwa.foundation.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpRequest;

/**
 * IP工具类，提供一些处理IP的方法。
 * 
 */
@SuppressWarnings("rawtypes")
public class IPUtil {
	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * 
	 * 
	 * @param b
	 *            字节数组
	 * @param offset
	 *            要转换的起始位置
	 * @param len
	 *            要转换的长度
	 * @param encoding
	 *            编码方式
	 * @return 如果encoding不支持，返回一个缺省编码的字符串
	 */
	public static String getString(byte[] b, int offset, int len, String encoding) {
		try {
			return new String(b, offset, len, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b, offset, len);
		}
	}

	/**
	 * @param ip
	 *            ip的字节数组形式
	 * 
	 * @return 字符串形式的ip
	 */
	public static String getIpStringFromBytes(byte[] ip) {
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(ip[0] & 0xFF);
		sb.append('.');
		sb.append(ip[1] & 0xFF);
		sb.append('.');
		sb.append(ip[2] & 0xFF);
		sb.append('.');
		sb.append(ip[3] & 0xFF);
		return sb.toString();
	}

	/**
	 * 从ip的字符串形式得到字节数组形式
	 * 
	 * @param ip
	 *            字符串形式的ip
	 * @return 字节数组形式的ip
	 */
	public static byte[] getIpByteArrayFromString(String ip) {
		byte[] ret = new byte[4];
		StringTokenizer st = new StringTokenizer(ip, ".");
		try {
			ret[0] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[1] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[2] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[3] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 利用百度服务通过ip获取地址
	 * （本机访问本机可用）
	 * @return
	 */
	public static JSONObject getAdressByIp() {
		HttpClient client = new HttpClient();
		// 申请密钥（ak） 才可使用。每个key支持100万次/天，超过限制不返回数据
		// 可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
		// 可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
		String url = "http://api.map.baidu.com/location/ip?ak=AC1581bdb40b2c9f13d85be31fa7da97&coor=bd09ll";
		// 设置代理服务器地址和端口
		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod method = new GetMethod(url);
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		//设置policy避免Cookie rejected问题
		method.getParams().setParameter("http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
		method.getParams().setParameter("http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
		try {
			client.executeMethod(method);
			String str = method.getResponseBodyAsString();
			return JSONObject.fromObject(str);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			// 释放连接
			method.releaseConnection();
		}
		// 打印服务器返回的状态
		// System.out.println(method.getStatusLine());
		return null;
	}
	
	/**
	 * 利用百度服务通过ip获取地址
	 * （外网访问服务器）
	 * @param 客户端IP字符串
	 * @return
	 */
	public static JSONObject getAdressByIp(String IPString) {
		HttpClient client = new HttpClient();
		// 申请密钥（ak） 才可使用。每个key支持100万次/天，超过限制不返回数据
		// 可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
		// 可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
		String url = "http://api.map.baidu.com/location/ip?ak=AC1581bdb40b2c9f13d85be31fa7da97&coor=bd09ll&ip="+IPString;
		// 设置代理服务器地址和端口
		// client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
		// 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
		HttpMethod method = new GetMethod(url);
		// 使用POST方法
		// HttpMethod method = new PostMethod("http://java.sun.com");
		//设置policy避免Cookie rejected问题
		method.getParams().setParameter("http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
//		method.getParams().setParameter("http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
		try {
			client.executeMethod(method);
			String str = method.getResponseBodyAsString();
			return JSONObject.fromObject(str);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			// 释放连接
			method.releaseConnection();
		}
		// 打印服务器返回的状态
		// System.out.println(method.getStatusLine());
		return null;
	}
	
	/**
	 * 获取ip地址的省级名称
	 * 
	 * @return 省级名称
	 */
	public static String getIpProvince(JSONObject jobj) {
		String provinceName = null;
		if (jobj != null && jobj.get("content") != null ) {
			jobj = JSONObject.fromObject(jobj.get("content"));
			jobj = JSONObject.fromObject(jobj.get("address_detail"));
			provinceName = jobj.getString("province");
		}
		return provinceName;
	}

	/**
	 * 转码 (如:\u5409\u6797\u7701\u957f\u6625\u5e02转完后为“吉林省长春市”)
	 * 
	 * @param utfString
	 * @return
	 */
	public static String convert(String utfString) {
		StringBuilder sb = new StringBuilder();
		int i = -1;
		int pos = 0;
		while ((i = utfString.indexOf("\\u", pos)) != -1) {
			sb.append(utfString.substring(pos, i));
			if (i + 5 < utfString.length()) {
				pos = i + 6;
				sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
			}
		}
		return sb.toString();
	}

	/**
	 * 取本机ip地址
	 * 
	 * @return
	 */
	public static String getLocalhostIp() {
		Enumeration allNetInterfaces = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			Enumeration addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = (InetAddress) addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address) {
					System.out.println("本机的IP = " + ip.getHostAddress());
					if (!"127.0.0.1".equals(ip.getHostAddress())) {
						return ip.getHostAddress();
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] agrs) {
		System.out.println(getAdressByIp());
		System.out.println(getIpByteArrayFromString("192.168.1.1"));
		System.out.println(getIpStringFromBytes(getIpByteArrayFromString("192.168.1.1")));
	}
	
	public static String getIp() {
		InetAddress ia=null;
		try {
			ia=ia.getLocalHost();
			
			String localname=ia.getHostName();
			String localip=ia.getHostAddress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ia.toString();
	}
	
}
