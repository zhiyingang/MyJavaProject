
package com.eking.baiduAI;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.client.BaseClient;
import com.baidu.aip.error.AipError;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.ocr.OcrConsts;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;

/**
 * 创建百度客户端子类，主要用于后面的实例化用途
 * TODO javadoc for com.eking.baiduAI.BaiduClient
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年5月7日
 */
public class BaiduClient extends BaseClient {

	protected BaiduClient(String appId, String apiKey, String secretKey) {
		super(appId, apiKey, secretKey);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 身份证识别
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月22日 
	 * @modifier:
	 * @modifiedDate:
	 * @param image
	 * @param idCardSide
	 * @param options
	 * @return
	 */
    public JSONObject idcard(byte[] image, String idCardSide, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        
        request.addBody("id_card_side", idCardSide);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri("https://aip.baidubce.com/rest/2.0/ocr/v1/idcard");
        postOperation(request);
        return requestServer(request);
    }
    
    /**
     * 身份证识别
     * @description: TODO
     * @creator: 李景帆(jingf_li@haihangyun.com)
     * @createDate: 2018年5月22日 
     * @modifier:
     * @modifiedDate:
     * @param image
     * @param idCardSide
     * @param options
     * @return
     */
    public JSONObject idcard(String image, String idCardSide, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return idcard(data, idCardSide, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

	
}

