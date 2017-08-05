package com.owen.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.owen.entity.Product;
import com.owen.util.ExcelManage;
import com.owen.util.FileUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * read json file and writ into the excel
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		String JsonContext = new FileUtil().ReadFile("product.json");
		//System.out.println(JsonContext);
		JSONArray jsonArray = JSONArray.fromObject(JsonContext);
		int size = jsonArray.size();
		///System.out.println("Size: " + size);
		for(int  i = 0; i < size; i++){
		JSONObject jsonObject = jsonArray.getJSONObject(i);
		JSONObject product_info=jsonObject.getJSONObject("product_info");
		JSONObject price=jsonObject.getJSONObject("price");
		/*遍历jsonObject*/
		/*Iterator iterator =product_info.keys();
		while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            System.out.println(key+""+value);
			}*/
		//System.out.println("[" + i + "]name=" + product_info.get("price"));
		System.out.println("商标=" + product_info.get("brand_name"));
		System.out.println("产品名称=" + product_info.get("name"));
		System.out.println("商品编码=" + product_info.get("bn"));
		System.out.println("规格=" + product_info.get("productSize"));
		System.out.println("现价=" + price.get("price"));
		System.out.println("建议价格=" + price.get("mktprice"));
		System.out.println("打折=" + price.get("saveprice"));
		System.out.println("产地=" + product_info.get("countryOfOrigin"));
		System.out.println("链接=" + product_info.get("url"));
		 
		 String filePath = "product.xls";
		    String sheetName = "莎莎中文商品数据";
		    //Excel文件易车sheet页的第一行 
		    String title[] = {"品牌", "产品名称","商品编码","规格","现价","建议价格","折扣","产地","链接"};
		    //Excel文件易车每一列对应的数据
		    String titleDate[] = {"brand_name", "name","bn","productSize","price","mktprice","saveprice","countryOfOrigin","url"};
		        
		    ExcelManage em = new ExcelManage();  
		    //判断该名称的文件是否存在  
		    boolean fileFlag = em.fileExist(filePath);        
		    if(!fileFlag){
		       em.createExcel(filePath,sheetName,title);
		    }  
		    //判断该名称的Sheet是否存在  
		    boolean sheetFlag = em.sheetExist(filePath,sheetName);
		    //如果该名称的Sheet不存在，则新建一个新的Sheet
		    if(!sheetFlag){
		       try {
		           em.createSheet(filePath,sheetName,title);
		       } catch (FileNotFoundException e) {
		           e.printStackTrace();
		       } catch (IOException e) {
		           e.printStackTrace();
		       }
		    }          
		    Product product = new Product();  
		    product.setBn(product_info.get("bn").toString());
		    product.setBrand_name(product_info.get("brand_name").toString());
		    product.setCountryOfOrigin(product_info.get("countryOfOrigin").toString());
		    product.setMktprice(price.get("mktprice").toString());
		    product.setName(product_info.get("name").toString());
		    product.setPrice(price.get("price").toString());
		    product.setUrl("http://www.sasa.com/"+product_info.get("url").toString());
		    product.setProductSize(product_info.get("productSize").toString());
		    product.setSaveprice(price.get("saveprice").toString());
		    //写入到excel 
		    em.writeToExcel(filePath,sheetName,product,titleDate);  
		}
	}
}
