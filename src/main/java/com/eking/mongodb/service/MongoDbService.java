
package com.eking.mongodb.service;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

@Component("mongoDbService")
/**
 * MongoDB Service
 * TODO javadoc for org.eking.client.common.MongoDbService
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月13日
 */
public class MongoDbService {

	@Autowired
	@Qualifier(value = "primaryMongoTemplate")
	protected MongoTemplate primaryMongoTemplate;

	// Using mongoTemplate for secondary database
	@Autowired
	@Qualifier(value = "secondaryMongoTemplate")
	protected MongoTemplate secondaryMongoTemplate;

	@Autowired
	@Qualifier("gridFsTemplate")
	private GridFsTemplate gridFsTemplate;
	
	@Autowired
	@Qualifier("logsGridFsTemplate")
	private GridFsTemplate logsGridFsTemplate;
	
	
	@Autowired
	MongoTemplate mongo;

	public DBCollection getCollection(String collectionName) {
		return mongo.getCollection(collectionName);
	}

	public Object get() throws Exception {
		gridFsTemplate.store(new FileInputStream(new File("D:\\course\\mongodb\\po\\Advertisement.java")), new BasicDBObject("name", "yinjihuan"));
		return "success";
	}
	
	public String covertMsg(String msg) {
		String info = msg;
		if (info == null || "".equalsIgnoreCase(info)) {
			info = "***";
		} else {
			if (info.length() <= 2) {
				info = info.substring(0, 1) + "*";
			} else {
				String covertStr = "";
				for (int i = 1; i < (info.length() - 1); i++) {
					covertStr = covertStr + "*";
				}
				info = info.charAt(0) + covertStr + info.charAt(info.length() - 1);
			}
		}
		return info;
	}
}
