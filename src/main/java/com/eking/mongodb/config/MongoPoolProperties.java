package com.eking.mongodb.config;

import lombok.Data;

/**
 * MongoPool配置类
 * TODO javadoc for com.eking.mongodb.config.MongoPoolProperties
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年5月2日
 */
@Data
public class MongoPoolProperties {
	
	private String mongoTemplateName = "mongoTemplate";
	
	private String gridFsTemplateName = "gridFsTemplate";
	
	/**
	 * 存储时是否保存_class
	 */
	private boolean showClass = true;
	private String host;
	private Integer port = 27017;
	private String database;
	private String authenticationDatabase;
	private String gridFsDatabase;
	private String username;
	private char[] password;

    private int minConnectionsPerHost;
    private int maxConnectionsPerHost = 100;
    private int threadsAllowedToBlockForConnectionMultiplier = 5;
    private int serverSelectionTimeout = 1000 * 30;
    private int maxWaitTime = 1000 * 60 * 2;
    private int maxConnectionIdleTime;
    private int maxConnectionLifeTime;
    private int connectTimeout = 1000 * 10;
    private int socketTimeout = 0;
    private boolean socketKeepAlive = false;
    private boolean sslEnabled = false;
    private boolean sslInvalidHostNameAllowed = false;
    private boolean alwaysUseMBeans = false;

    private int heartbeatFrequency = 10000;
    private int minHeartbeatFrequency = 500;
    private int heartbeatConnectTimeout = 20000;
    private int heartbeatSocketTimeout = 20000;
    private int localThreshold = 15;
}
