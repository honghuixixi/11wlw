package com.qpwa.mongo;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.qpwa.mongo.entity.WebCartsCache;
import com.qpwa.mongo.util.Page;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
@Service("mongodbBaseDao")
public class MongodbBaseDao<T> extends MongoTemplate {

	public MongodbBaseDao(Mongo mongo, String databaseName) {
		super(mongo, databaseName);
	}

	public Page<T> queryForPage(int currentPage,int pageSize,Query query,Class<?> entityClass){
		if(currentPage==0||pageSize==0){
			currentPage=1;
			pageSize=10;
		}
			long totalCount = this.count(query, entityClass);
			int totalPage = (int) (totalCount/pageSize);
			if(totalCount/pageSize!=0){
				totalPage++;
			}
			int skip = (currentPage-1)*pageSize;
			Page<T> page = new Page<T>(pageSize, currentPage,totalCount,totalPage);
			query.skip(skip); 
			query.limit(pageSize); 
			List datas = this.find(query,entityClass);
			page.setItems(datas);
			return page;
		
	}
	public Page<T> queryForPage(Query query,Class<?> entityClass){
		int currentPage=1;
		int pageSize=10;
		long totalCount = this.count(query, entityClass);
		int totalPage = (int) (totalCount/pageSize);
		if(totalCount/pageSize!=0){
			totalPage++;
		}
		int skip = (currentPage-1)*pageSize;
		Page<T> page = new Page<T>(pageSize, currentPage,totalCount,totalPage);
		query.skip(skip); 
		query.limit(pageSize); 
		List datas = this.find(query,entityClass);
		page.setItems(datas);
		return page;
		
	}
	public T findUniqueBy(Query query,Class<?> entityClass){
		List l = find(query, entityClass);
		if(null!=l&&l.size()>0){
			return (T) l.get(0);
		}
		return null;
	}
private Update entityToUpdate(Object entityClass){
	try {
		Class<?> C = Class.forName(entityClass.getClass().getName());
		Field[] fs = C.getDeclaredFields();
		Update update = new Update();
		for(Field f : fs){
			String name = f.getName();
			if(!"id".equals(name)){
            String getMethodName = "get"+toFirstLetterUpperCase(name);  
               Object value = C.getMethod(getMethodName).invoke(entityClass);  
               update.set(name, value);
			}
		}
		return update;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public static String toFirstLetterUpperCase(String str) {  
    if(str == null || str.length() < 2){  
        return str;  
    }  
     String firstLetter = str.substring(0, 1).toUpperCase();  
     return firstLetter + str.substring(1, str.length());  
 } 

public WriteResult updateEntity(Query query,Object entityClass) {
	Update update = entityToUpdate(entityClass);
	return super.updateFirst(query, update, entityClass.getClass());
}

}
