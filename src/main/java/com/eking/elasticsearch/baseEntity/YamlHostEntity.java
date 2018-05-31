
package com.eking.elasticsearch.baseEntity;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import lombok.Data;
//import lombok.extern.slf4j.Slf4j;

/**
 * RistCient链接 Host实体类
 * TODO javadoc for com.eking.transform.entity.HostEntity
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月26日
 */
@ConfigurationProperties(prefix = "es")
@Configuration
@Data
public class YamlHostEntity implements Serializable {
	
/*	@Bean
	public EsRestRepository bean(YamlHostEntity config){
		log.info("config:{}",config);
		return new EsRestRepository(config);
	}*/
	
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2873172140010032209L;
	
	private List<HostEntity> hosts;

	public YamlHostEntity() {
		super();
	}
	
	public List<HostEntity> getHosts() {
		return hosts;
	}

	
	public void setHosts(List<HostEntity> hosts) {
		this.hosts = hosts;
	}

}
