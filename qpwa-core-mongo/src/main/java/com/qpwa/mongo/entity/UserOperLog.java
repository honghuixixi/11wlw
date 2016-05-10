package com.qpwa.mongo.entity;

import java.util.Date;

import net.sf.json.JSONObject;
/**
 * 用户行为日志
 * @author majunjie
 *
 */
public class UserOperLog implements java.io.Serializable{
	
	private static final long serialVersionUID = 7648200111510945440L;
	/**主键ID**/
	private String id;
	/**用户ID**/
	private String userId;
	/**商品ID**/
	private String productId;
	/**创建时间**/
	private Date createDate = new Date();
	/**调用service**/
	private String type;
	/**调用方法**/
	private String oper;
	/**来源
	 * 
	 * B2B,B2BWAP,B2BAPP 
	 * **/
	private String source;
	/**备注**/
	private String memo;
	/**设备**/
	private JSONObject device;
	/**接受参数**/
	private JSONObject params;
	
	public UserOperLog() {
		super();
	}
	public UserOperLog(String id, String userId, String productId, String type, String oper, String source,
			String memo, JSONObject device, JSONObject params) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.type = type;
		this.oper = oper;
		this.source = source;
		this.memo = memo;
		this.device = device;
		this.params = params;
	}
	public UserOperLog( String userId, String productId, String type, String oper, String source,
			String memo, JSONObject device, JSONObject params) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.type = type;
		this.oper = oper;
		this.source = source;
		this.memo = memo;
		this.device = device;
		this.params = params;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
 
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public JSONObject getDevice() {
		return device;
	}
	public void setDevice(JSONObject device) {
		this.device = device;
	}
	public JSONObject getParams() {
		return params;
	}
	public void setParams(JSONObject params) {
		this.params = params;
	}


}
