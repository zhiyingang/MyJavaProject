package com.eking.mongodb.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;


/**
 * 启用Mongodb数据库连接池信息自动配置
 * TODO javadoc for com.eking.mongodb.config.EnableMongoPool
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年5月2日
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({MongoPoolAutoConfiguration.class})
public @interface EnableMongoPool {

}
