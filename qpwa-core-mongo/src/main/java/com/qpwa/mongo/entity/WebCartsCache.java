package com.qpwa.mongo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.sf.json.JSONArray;

/**
 * 购物车
 */
 
public class WebCartsCache  {

	private String id;
	
    /**STK_LIST**/
    private BigDecimal uomQty;
    private String stkC;
    private BigDecimal subtotal;
    private String stkName;
    private BigDecimal atpQty;
    private String uom;
	private String productThumbnail;
    private String pkNo;
    private String epFlg;
    private BigDecimal netPrice;
 
    /**PROM_MAP**/
    private String refNo;
    private Date endDate;
    private Date beginDate;
    private String  masCode;
    private BigDecimal singleCustQty ;
    private BigDecimal baseQty;
    private BigDecimal leftMaxQty;
    private String masPkNo;
    private BigDecimal kitListPrice;
    private BigDecimal kitPrice;
    private String spNote;
    private String itemPkNo;
    private JSONArray freeList;
    
    /**VENDOR_MAP**/
    private String vendorUserNo;
    private String vendorUserName;
    private String vendorName;
    
    
    
	public WebCartsCache(String refNo, Date endDate, Date beginDate, String masCode, BigDecimal singleCustQty,
			BigDecimal baseQty, BigDecimal leftMaxQty, String masPkNo, BigDecimal kitListPrice, BigDecimal kitPrice,
			String spNote, String itemPkNo, BigDecimal uomQty, String stkC, BigDecimal subtotal, String stkName,
			BigDecimal atpQty, String uom, String productThumbnail, String pkNo, String epFlg, BigDecimal netPrice,
			String vendorUserNo, String vendorUserName, String vendorName, JSONArray freeList) {
		super();
		this.refNo = refNo;
		this.endDate = endDate;
		this.beginDate = beginDate;
		this.masCode = masCode;
		this.singleCustQty = singleCustQty;
		this.baseQty = baseQty;
		this.leftMaxQty = leftMaxQty;
		this.masPkNo = masPkNo;
		this.kitListPrice = kitListPrice;
		this.kitPrice = kitPrice;
		this.spNote = spNote;
		this.itemPkNo = itemPkNo;
		this.uomQty = uomQty;
		this.stkC = stkC;
		this.subtotal = subtotal;
		this.stkName = stkName;
		this.atpQty = atpQty;
		this.uom = uom;
		this.productThumbnail = productThumbnail;
		this.pkNo = pkNo;
		this.epFlg = epFlg;
		this.netPrice = netPrice;
		this.vendorUserNo = vendorUserNo;
		this.vendorUserName = vendorUserName;
		this.vendorName = vendorName;
		this.freeList = freeList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public String getMasCode() {
		return masCode;
	}
	public void setMasCode(String masCode) {
		this.masCode = masCode;
	}
	public BigDecimal getSingleCustQty() {
		return singleCustQty;
	}
	public void setSingleCustQty(BigDecimal singleCustQty) {
		this.singleCustQty = singleCustQty;
	}
	public BigDecimal getBaseQty() {
		return baseQty;
	}
	public void setBaseQty(BigDecimal baseQty) {
		this.baseQty = baseQty;
	}
	public BigDecimal getLeftMaxQty() {
		return leftMaxQty;
	}
	public void setLeftMaxQty(BigDecimal leftMaxQty) {
		this.leftMaxQty = leftMaxQty;
	}
	public String getMasPkNo() {
		return masPkNo;
	}
	public void setMasPkNo(String masPkNo) {
		this.masPkNo = masPkNo;
	}
	public BigDecimal getKitListPrice() {
		return kitListPrice;
	}
	public void setKitListPrice(BigDecimal kitListPrice) {
		this.kitListPrice = kitListPrice;
	}
	public BigDecimal getKitPrice() {
		return kitPrice;
	}
	public void setKitPrice(BigDecimal kitPrice) {
		this.kitPrice = kitPrice;
	}
	public String getSpNote() {
		return spNote;
	}
	public void setSpNote(String spNote) {
		this.spNote = spNote;
	}
	public String getItemPkNo() {
		return itemPkNo;
	}
	public void setItemPkNo(String itemPkNo) {
		this.itemPkNo = itemPkNo;
	}
	public BigDecimal getUomQty() {
		return uomQty;
	}
	public void setUomQty(BigDecimal uomQty) {
		this.uomQty = uomQty;
	}
	public String getStkC() {
		return stkC;
	}
	public void setStkC(String stkC) {
		this.stkC = stkC;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public String getStkName() {
		return stkName;
	}
	public void setStkName(String stkName) {
		this.stkName = stkName;
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
	public String getProductThumbnail() {
		return productThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}
	public String getPkNo() {
		return pkNo;
	}
	public void setPkNo(String pkNo) {
		this.pkNo = pkNo;
	}
	public String getEpFlg() {
		return epFlg;
	}
	public void setEpFlg(String epFlg) {
		this.epFlg = epFlg;
	}
	public BigDecimal getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}
	public String getVendorUserNo() {
		return vendorUserNo;
	}
	public void setVendorUserNo(String vendorUserNo) {
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
	public JSONArray getFreeList() {
		return freeList;
	}
	public void setFreeList(JSONArray freeList) {
		this.freeList = freeList;
	}
 	
}