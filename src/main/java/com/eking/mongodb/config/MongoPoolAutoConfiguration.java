package com.eking.mongodb.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Mongodb数据库连接池信息自动配置
 * TODO javadoc for com.eking.mongodb.config.MongoPoolAutoConfiguration
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年5月2日
 */
@Configuration
@Component
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MongoPoolAutoConfiguration {
	
	@Bean
	public MongoPoolInit mongoPoolInit() {
		return new MongoPoolInit();
	}
	
}
