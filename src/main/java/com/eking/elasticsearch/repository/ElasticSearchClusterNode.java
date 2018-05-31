
package com.eking.elasticsearch.repository;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eking.elasticsearch.baseEntity.HostEntity;
import com.eking.elasticsearch.baseEntity.YamlHostEntity;

/**
 * ElasticSearch 链接类
 * TODO javadoc for com.eking.transform.repository.ClusterNode
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月26日
 */
@Component
public class ElasticSearchClusterNode {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/** RestClient链接对象 */
	private RestClient restClient;

	/** 字符串list配置链接节点，格式ip:port形式 */
	private List<HostEntity> hosts;

	/** httpHosts链接节点数组 */
	private HttpHost[] httpHosts;

	/** 连接超时，默认：5000ms */
	private final static int DEF_CONNECT_TIME_OUT = 5000;

	/** 接口超时，默认：6000ms */
	private final static int DEF_SOCKET_TIME_OUT = 60000;

	/** 连接最大重试时间，默认：60000ms */
	private final static int DEF_MAX_RETRY_TIME_OUT_MILLIS = 60000;

	/** 连接超时，默认：5000ms */
	private int connectTimeout = 0;

	/** 接口超时，默认：6000ms */
	private int socketTimeout = 0;

	/** 连接最大重试时间，默认：60000ms */
	private int maxRetryTimeoutMillis = 0;

	/** 登录用户名 */
	private String username = "";

	/** 登录用户密码 */
	private String password = "";

	public ElasticSearchClusterNode() {
		super();
	}

	@Autowired
	public ElasticSearchClusterNode(YamlHostEntity entity) {
		this(entity.getHosts(), DEF_CONNECT_TIME_OUT, DEF_SOCKET_TIME_OUT, DEF_MAX_RETRY_TIME_OUT_MILLIS);
	}

	public ElasticSearchClusterNode(List<HostEntity> hosts, int connectTimeout, int socketTimeout, int maxRetryTimeoutMillis) {
		this.hosts = hosts;
		this.connectTimeout = connectTimeout;
		this.socketTimeout = socketTimeout;
		this.maxRetryTimeoutMillis = maxRetryTimeoutMillis;
		this.restClient = simpleConnect();
		logger.debug(restClient.toString());
	}

	public ElasticSearchClusterNode(YamlHostEntity entity, String username, String password) {
		this.hosts = entity.getHosts();
		this.username = username;
		this.password = password;
		this.restClient = secureConnect();
		logger.debug(restClient.toString());
	}

	/**
	 * 简单配置
	 * @return RestClient链接对象
	 */
	public RestClient simpleConnect() {
		restClient = RestClient.builder(setHttpHosts()).setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {

			public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
				return requestConfigBuilder.setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout);
			}
		}).setMaxRetryTimeoutMillis(maxRetryTimeoutMillis).build();
		return restClient;
	}

	/**
	 * 安全配置
	 * @return RestClient链接对象
	 */
	public RestClient secureConnect() {
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, credentials);
		restClient = RestClient.builder(setHttpHosts()).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {

			public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
				return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
			}
		}).build();
		return restClient;
	}

	/**
	 * 根据初始化hosts列表，配置httpHosts数组
	 * @return
	 */
	private HttpHost[] setHttpHosts() {
		if (hosts != null && hosts.size() > 0) {
			int size = hosts.size();
			httpHosts = new HttpHost[size];
			for (int i = 0; i < hosts.size(); i++) {
				HostEntity entity = hosts.get(i);
				HttpHost newHttpHost = new HttpHost(entity.getHost(),entity.getPort(), "http");
				httpHosts[i] = newHttpHost;
			}
		}
		return httpHosts;
	}

	/**
	 * 根据初始化hosts，配置单节点的
	 * @return
	 */
	@SuppressWarnings("unused")
	private HttpHost setHttpHost(String host, int port) {
		HttpHost newHttpHost = new HttpHost(host, port, "http");
		return newHttpHost;
	}

	// ***** setter and getter methods ***** //
	public RestClient getRestClient() {
		return restClient;
	}

	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public int getMaxRetryTimeoutMillis() {
		return maxRetryTimeoutMillis;
	}

	public void setMaxRetryTimeoutMillis(int maxRetryTimeoutMillis) {
		this.maxRetryTimeoutMillis = maxRetryTimeoutMillis;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<HostEntity> getHosts() {
		return hosts;
	}

	
	public void setHosts(List<HostEntity> hosts) {
		this.hosts = hosts;
	}

	public HttpHost[] getHttpHosts() {
		return httpHosts;
	}

	public void setHttpHosts(HttpHost[] httpHosts) {
		this.httpHosts = httpHosts;
	}
}
