package com.qpwa.mongo.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品分类  
 * 
 * @author sunyang
 */
public class StkCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 331659511995104510L;
	// Fields

	/** 商品类别ID */
	private BigDecimal catId;
	/** 组织代码 */
	private BigDecimal orgNo;
	/** 创建日期 */
	private Date createDate;
	/** 修改日期 */
	private Date modifyDate;
	/** 排序*/
	private BigDecimal sortNo;
	/** 商品类别级别 */
	private BigDecimal grade;
	/** 商品类别名称*/
	private String catName;
	private String seoDescription;
	private String seoKeywords;
	private String seoTitle;
	/** 商品类别树路径 */
	private String treePath;
	/** 商品类别对应图片链接 */
	private String href;
	/** 商品类别父类ID */
	private BigDecimal parentId;
	/** 树路径分隔符 */
	public static final String TREE_PATH_SEPARATOR = ",";
	/** 访问路径前缀 */
	private static final String PATH_PREFIX = "/product/list";
	/** 访问路径后缀 */
	private static final String PATH_SUFFIX = ".jhtml";

	// Constructors

	/** default constructor */
	public StkCategory() {
	}

	/** minimal constructor */
	public StkCategory(BigDecimal catId, Date createDate, Date modifyDate,
			BigDecimal grade, String catName, String treePath) {
		this.catId = catId;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.grade = grade;
		this.catName = catName;
		this.treePath = treePath;
	}

	/** full constructor */
	public StkCategory(BigDecimal catId, BigDecimal orgNo, Date createDate,
			Date modifyDate, BigDecimal sortNo, BigDecimal grade,
			String catName, String seoDescription, String seoKeywords,
			String seoTitle, String treePath, String href, BigDecimal parentId) {
		this.catId = catId;
		this.orgNo = orgNo;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.sortNo = sortNo;
		this.grade = grade;
		this.catName = catName;
		this.seoDescription = seoDescription;
		this.seoKeywords = seoKeywords;
		this.seoTitle = seoTitle;
		this.treePath = treePath;
		this.href = href;
		this.parentId = parentId;
	}

	public BigDecimal getCatId() {
		return catId;
	}

	public void setCatId(BigDecimal catId) {
		this.catId = catId;
	}

	public BigDecimal getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(BigDecimal orgNo) {
		this.orgNo = orgNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public BigDecimal getSortNo() {
		return sortNo;
	}

	public void setSortNo(BigDecimal sortNo) {
		this.sortNo = sortNo;
	}

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public BigDecimal getParentId() {
		return parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}
 

}