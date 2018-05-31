
package com.eking.elasticsearch.baseEntity;

import java.io.Serializable;

/**
 * RistCient链接 Host实体类
 * TODO javadoc for com.eking.transform.entity.HostEntity
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月26日
 */
public class HostEntity implements Serializable {

	private static final long serialVersionUID = 3494524362451384269L;

	private String host;

	private int port;
	

	public HostEntity() {
		super();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


}
