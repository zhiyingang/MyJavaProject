
package com.eking.framework.starter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.cloud.client.SpringCloudApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


//微服务标准启动-包含服务发现注册和熔断机制
@SpringBootApplication
//扫描spring组件
@ComponentScan("com.eking")
//使用EurekaClient
//@EnableEurekaClient
public class AppStarter { 
	
	
	public static void main(String[] args) throws Exception {
		//使用建造器启动app //可使用SpringApplication.run(AppStarter.class,args)简单启动
		new SpringApplicationBuilder(AppStarter.class).web(true).run(args);
		//System.out.println(EsRestClient.getInstance().getApi());

	}

}
