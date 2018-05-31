
package com.eking.baiduAI.demo;

import java.net.URLEncoder;
import java.util.HashMap;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Base64Util;
import com.eking.baiduAI.BaiduClient;
import com.eking.baiduAI.BaiduClientFactory;
import com.eking.baiduAI.core.FileUtil;
import com.eking.baiduAI.core.HttpUtil;

public class FaceMatch {

	public void testFaceMeth() throws Exception {

		String accessToken = BaiduClientFactory.getBaiduClientFactory().getAuthToken();

		System.out.println("============accessToken : " + accessToken);
		
		try {
			HashMap<String, String> options = new HashMap<String, String>();
			options.put("detect_direction", "true");
			options.put("detect_risk", "false");

			// 请求url
			String url = "https://aip.baidubce.com/rest/2.0/face/v2/match";

			// 本地文件路径
			String filePath = "d:\\id_frong_2.jpg";
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String imgParam = URLEncoder.encode(imgStr, "UTF-8");

			String filePath2 = "d:\\headimage_2.jpg";
			byte[] imgData2 = FileUtil.readFileByBytes(filePath2);
			String imgStr2 = Base64Util.encode(imgData2);
			String imgParam2 = URLEncoder.encode(imgStr2, "UTF-8");

			String param = "images=" + imgParam + "," + imgParam2;

			String result = HttpUtil.post(url, accessToken, param);

			System.out.println("============FaceMatch : " + result);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			BaiduClientFactory.getBaiduClientFactory().freeClient();

		}

	}

}
