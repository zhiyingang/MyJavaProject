
package com.eking.baiduAI.demo;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.eking.baiduAI.BaiduClient;
import com.eking.baiduAI.BaiduClientFactory;

public class IdCardOcr {

	private static final Log logger = LogFactory.getLog(BaiduClientFactory.class);

	/**
	 * 身份证识别测试
	 * @throws InterruptedException 
	 * @throws JSONException 
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月22日 
	 * @modifier:
	 * @modifiedDate:
	 */
	public void idRecognition() throws Exception {

		try {
			BaiduClient client = BaiduClientFactory.getBaiduClientFactory().getBaiduClient();

			HashMap<String, String> options = new HashMap<String, String>();
			options.put("detect_direction", "true");
			options.put("detect_risk", "false");

			String idCardSide = "back";

			// 参数为本地图片路径
			String image = "d:\\id_back.jpg";
			long startTime = System.currentTimeMillis();
			logger.info("idcard method ............start time...........");

			JSONObject res = client.idcard(image, idCardSide, options).getJSONObject("words_result").getJSONObject("签发机关");

			long endTime = System.currentTimeMillis();
			System.out.println(res.get("words"));

			logger.info("idcard method ............end time，耗时： " + (float) (endTime - startTime) / 1000 + " 秒...........");

		} finally {
			
			BaiduClientFactory.getBaiduClientFactory().freeClient();
			
		}

	}

}
