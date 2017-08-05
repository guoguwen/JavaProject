package com.owen.entity;
/**
 * create product is to Json infomation
 * @author Administrator
 *
 */
public class Product {
	/*商标*/
	private String brand_name;
	/*产品名称*/
	private String name;
	/*商品编码*/
	private String bn;
	/*规格*/
	private String productSize;
	/*现价*/
	private String price;
	/*建议价格*/
	private String mktprice;
	/*打折*/
	private String saveprice;
	/*产地*/
	private String countryOfOrigin;
	/*链接*/
	private String url;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String brand_name, String name, String bn, String productSize, String price, String mktprice,
			String saveprice, String countryOfOrigin, String url) {
		super();
		this.brand_name = brand_name;
		this.name = name;
		this.bn = bn;
		this.productSize = productSize;
		this.price = price;
		this.mktprice = mktprice;
		this.saveprice = saveprice;
		this.countryOfOrigin = countryOfOrigin;
		this.url = url;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBn() {
		return bn;
	}
	public void setBn(String bn) {
		this.bn = bn;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMktprice() {
		return mktprice;
	}
	public void setMktprice(String mktprice) {
		this.mktprice = mktprice;
	}
	public String getSaveprice() {
		return saveprice;
	}
	public void setSaveprice(String saveprice) {
		this.saveprice = saveprice;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
