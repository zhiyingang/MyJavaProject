
package com.eking.baiduAI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;

import com.baidu.aip.client.BaseClient;
import com.baidu.aip.ocr.AipOcr;
import com.mysql.jdbc.StringUtils;

/**
 * 创建BaiduClient工厂类
 * TODO javadoc for com.eking.baiduAI.BaiduClientFactory
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年5月7日
 */
public class BaiduClientFactory {

	private volatile static BaiduClientFactory baiduClientFactory = null;

	private static final Log logger = LogFactory.getLog(BaiduClientFactory.class);

	//百度账号队列【当前可以使用的】
	private BlockingQueue<String> clientStrings = new LinkedBlockingQueue<String>();

	//百度账号失效的队列【已经用过的】
	private BlockingQueue<String> clientStringFailures = new LinkedBlockingQueue<String>();

	private BaiduClientFactory() throws InterruptedException {

		for (HashMap.Entry<String, String> entry : BaiduKeys.getKeys().entrySet()) {
			String appId = entry.getKey();
			if (!StringUtils.isNullOrEmpty(entry.getValue())) {
				//构建字符串，形式如下：appId,apiKey,secretKey
				String tempString = appId + "," + entry.getValue();

				if (tempString.split(",").length > 2) {
					logger.info("Initialization insert into clientStrings...." + tempString);
					clientStrings.put(tempString);
				}
			}
		}

	}

	/**
	 * 获取百度的客户端
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月22日
	 * @modifier:
	 * @modifiedDate:
	 * @return
	 * @throws InterruptedException
	 */
	public BaiduClient getBaiduClient() throws InterruptedException {

		//由于BlockingQueue的take方法可能会出现阻塞，因此记录一下消耗的时间
		long startTime = System.currentTimeMillis();

		//从可用队列中取出链接字符串，可能会有阻塞
		String tempString = clientStrings.take();
		String[] arrayString = tempString.split(",");
		BaiduClient client = new BaiduClient(arrayString[0], arrayString[1], arrayString[2]);
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		//将链接字符串放入失效队列，准备回收
		clientStringFailures.put(tempString);

		long endTime = System.currentTimeMillis();
		logger.info("GetBaiduClient Api............耗时： " + (float) (endTime - startTime) / 1000 + " 秒...........");
		return client;

	}

	/**
	 * 获取AipOcr的客户端
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月28日
	 * @modifier:
	 * @modifiedDate:
	 * @return
	 * @throws Exception
	 */
	public AipOcr getAipOcr() throws Exception {

		//由于BlockingQueue的take方法可能会出现阻塞，因此记录一下消耗的时间
		long startTime = System.currentTimeMillis();
		//从可用队列中取出链接字符串，可能会有阻塞
		String tempString = clientStrings.take();
		String[] arrayString = tempString.split(",");

		AipOcr aipocr = new AipOcr(arrayString[0], arrayString[1], arrayString[2]);
		aipocr.setConnectionTimeoutInMillis(2000);
		aipocr.setSocketTimeoutInMillis(60000);
		//将链接字符串放入失效队列，准备回收
		clientStringFailures.put(tempString);

		long endTime = System.currentTimeMillis();
		logger.info("getAipOcr Api............耗时： " + (float) (endTime - startTime) / 1000 + " 秒...........");
		return aipocr;
	}

	/**
	 * 获取Auth tocken值
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月28日
	 * @modifier:
	 * @modifiedDate:
	 * @param apiKey
	 * @param secretKey
	 * @return
	 * @throws InterruptedException
	 */
	public String getAuthToken() throws InterruptedException {

		//由于BlockingQueue的take方法可能会出现阻塞，因此记录一下消耗的时间
		long startTime = System.currentTimeMillis();
		//从可用队列中取出链接字符串，可能会有阻塞
		String tempString = clientStrings.take();
		String[] arrayString = tempString.split(",");

		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
				// 1. grant_type为固定参数
				+ "grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + arrayString[1]
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + arrayString[2];
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.err.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			/**
			 * 返回结果示例
			 */
			System.err.println("result:" + result);
			JSONObject jsonObject = new JSONObject(result);
			String access_token = jsonObject.getString("access_token");
			//将链接字符串放入失效队列，准备回收
			clientStringFailures.put(tempString);

			long endTime = System.currentTimeMillis();
			logger.info("GetAuthToken Api............耗时： " + (float) (endTime - startTime) / 1000 + " 秒...........");

			return access_token;
		} catch (Exception e) {
			System.err.printf("获取token失败！");
			e.printStackTrace(System.err);
		}
		return null;
	}

	/**
	 * 从失效队列中释放资源至可用队列中
	 * @throws InterruptedException
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月22日
	 * @modifier:
	 * @modifiedDate:
	 */
	public void freeClient() throws InterruptedException {

		String tempString = clientStringFailures.take();
		clientStrings.put(tempString);

		logger.info("释放百度KEY进入队列............" + tempString);
	}

	/**
	 * 采取单例的模式保证Baidu Client重复加载
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月7日
	 * @modifier:
	 * @modifiedDate:
	 * @return
	 * @throws InterruptedException
	 */
	public static BaiduClientFactory getBaiduClientFactory() throws InterruptedException {
		if (baiduClientFactory == null) {
			synchronized (BaiduClientFactory.class) {
				if (baiduClientFactory == null) {
					baiduClientFactory = new BaiduClientFactory();
				}
			}
		}
		return baiduClientFactory;
	}

}
