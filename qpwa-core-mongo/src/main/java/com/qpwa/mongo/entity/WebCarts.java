package com.qpwa.mongo.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车
 */
public class WebCarts {
	private String id;
	private BigDecimal pkNo;
	private BigDecimal refPkNo;
	private BigDecimal orgNo;
	private String stkC;
	private String stkFlg;
	private String stkName;
	private BigDecimal uomQty;
	private BigDecimal atpQty;
	private String uom;
	private BigDecimal uomRatio;
	private BigDecimal stkQty;
	private BigDecimal listPrice;
	private BigDecimal discNum;
	private BigDecimal netPrice;
	private BigDecimal vendorUserNo;
	private String vendorUserName;
	private String vendorName;
	private BigDecimal userNo;
	private Date createDate;
	private String productThumbnail;
//	private String cartChecked;
	private String cartKey;
	private BigDecimal promPkNo;
	
	private BigDecimal promItemPkNo;
	/**
	 * 商品是否上架（Y：上架；N：下架）,不用维护此字段,仅在关联查询中使用
	 */
	private String epFlg;

	public WebCarts() {
	}

	public WebCarts(BigDecimal pkNo) {
		this.pkNo = pkNo;
	}

	/** full constructor */
	public WebCarts(BigDecimal refPkNo, BigDecimal orgNo, String stkC, String stkFlg, String stkName, String productThumbnail, BigDecimal uomQty, String uom, BigDecimal uomRatio, BigDecimal stkQty, BigDecimal listPrice, BigDecimal discNum, BigDecimal netPrice, BigDecimal atpQty, BigDecimal userNo, BigDecimal vendorUserNo, String vendorUserName, String vendorName, Date createDate, String cartKey, BigDecimal promPkNo, BigDecimal promItemPkNo) {
		this.refPkNo = refPkNo;
		this.orgNo = orgNo;
		this.stkC = stkC;
		this.stkFlg = stkFlg;
		this.stkName = stkName;
		this.productThumbnail = productThumbnail;
		this.uomQty = uomQty;
		this.uom = uom;
		this.uomRatio = uomRatio;
		this.stkQty = stkQty;
		this.listPrice = listPrice;
		this.discNum = discNum;
		this.netPrice = netPrice;
		this.atpQty = atpQty;
		this.userNo = userNo;
		this.vendorUserNo = vendorUserNo;
		this.vendorUserName = vendorUserName;
		this.vendorName = vendorName;
		this.createDate = createDate;
		this.cartKey = cartKey;
		this.promPkNo = promPkNo;
		this.promItemPkNo = promItemPkNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getPkNo() {
		return pkNo;
	}

	public void setPkNo(BigDecimal pkNo) {
		this.pkNo = pkNo;
	}

	public BigDecimal getRefPkNo() {
		return refPkNo;
	}

	public void setRefPkNo(BigDecimal refPkNo) {
		this.refPkNo = refPkNo;
	}

	public BigDecimal getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(BigDecimal orgNo) {
		this.orgNo = orgNo;
	}

	public String getStkC() {
		return stkC;
	}

	public void setStkC(String stkC) {
		this.stkC = stkC;
	}

	public String getStkFlg() {
		return stkFlg;
	}

	public void setStkFlg(String stkFlg) {
		this.stkFlg = stkFlg;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public BigDecimal getUomQty() {
		return uomQty;
	}

	public void setUomQty(BigDecimal uomQty) {
		this.uomQty = uomQty;
	}

	public BigDecimal getAtpQty() {
		return atpQty;
	}

	public void setAtpQty(BigDecimal atpQty) {
		this.atpQty = atpQty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getUomRatio() {
		return uomRatio;
	}

	public void setUomRatio(BigDecimal uomRatio) {
		this.uomRatio = uomRatio;
	}

	public BigDecimal getStkQty() {
		return stkQty;
	}

	public void setStkQty(BigDecimal stkQty) {
		this.stkQty = stkQty;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getDiscNum() {
		return discNum;
	}

	public void setDiscNum(BigDecimal discNum) {
		this.discNum = discNum;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public BigDecimal getVendorUserNo() {
		return vendorUserNo;
	}

	public void setVendorUserNo(BigDecimal vendorUserNo) {
		this.vendorUserNo = vendorUserNo;
	}

	public String getVendorUserName() {
		return vendorUserName;
	}

	public void setVendorUserName(String vendorUserName) {
		this.vendorUserName = vendorUserName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public BigDecimal getUserNo() {
		return userNo;
	}

	public void setUserNo(BigDecimal userNo) {
		this.userNo = userNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getProductThumbnail() {
		return productThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	public String getCartKey() {
		return cartKey;
	}

	public void setCartKey(String cartKey) {
		this.cartKey = cartKey;
	}

	public BigDecimal getPromPkNo() {
		return promPkNo;
	}

	public void setPromPkNo(BigDecimal promPkNo) {
		this.promPkNo = promPkNo;
	}

	public BigDecimal getPromItemPkNo() {
		return promItemPkNo;
	}

	public void setPromItemPkNo(BigDecimal promItemPkNo) {
		this.promItemPkNo = promItemPkNo;
	}

	public String getEpFlg() {
		return epFlg;
	}

	public void setEpFlg(String epFlg) {
		this.epFlg = epFlg;
	}
	 	
}