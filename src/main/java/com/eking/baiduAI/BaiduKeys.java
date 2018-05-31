
package com.eking.baiduAI;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造百度的账号表（后面可以根据需要改成配置文件）
 * TODO javadoc for com.eking.baiduAI.BaiduKeys
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年5月7日
 */
public class BaiduKeys {
	
	/**
	 * 百度账号Map 格式："11191078", "b3pnGdKe7z7pgfb2sCMlDtXG,PsXImXiWkN4cBbNRd6sgqZsxcERKeWwV"
	 * 11191078 : APP_ID
	 * b3pnGdKe7z7pgfb2sCMlDtXG : API_KEY
	 * PsXImXiWkN4cBbNRd6sgqZsxcERKeWwV : cTQBfKcNEuZg9o9ukuMoVjo7hwTjFEgc
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年5月7日 
	 * @modifier:
	 * @modifiedDate:
	 * @return
	 */
	public static final HashMap<String,String> getKeys() {
		
		HashMap<String,String> keyArray = new HashMap<String,String>();
	
		
		keyArray.put("11191152", "TSOAvbGTc7wfLIgenNURHccQ,fG2EOXKHyo70eGsUfk5vUdBhGFQW0Li5");
		
		keyArray.put("11191078", "b3pnGdKe7z7pgfb2sCMlDtXG,PsXImXiWkN4cBbNRd6sgqZsxcERKeWwV");
		keyArray.put("11191287", "K5CwjCSOPXaf2GQABLPNupkX,jHMCG7PV690S9LBErSyGqfu9DzMomoIK");
		keyArray.put("11146540", "GxDKkbdTZ4lQtP2AiQ7DBy7k,B8zHC3s83BhvZGDHKWGXXIyG20l99NyG");
		keyArray.put("11191296", "jkMGZvt3RHGBiUbag6NOKm1u,HfuoMGRGpOpxWYTG827yYfHU8uVMV4xA");
		keyArray.put("11191299", "6iiwlHTaGGKhWsN7NzlW5aRG,8cXDsUszpPba0g1iAY0kYIw3dEAy3At7");
		keyArray.put("11191314", "j9xScUnsRyOW5gzKjQDl1e0X,lv65gpCyBHUNRPGuxQFIV593C59hs0tS");
		keyArray.put("11191318", "V0pNdkQ90RGBp2pMXkBBDsjn,hns67nHgLILpE1Mq2v4PDuBrAGoUICVP");
		
		keyArray.put("11191375", "oHh2SXMXimUgzsk1iTuDlOnW,fYWYvIwMFi1tKy6GcKFHrev2ashB078x");
		keyArray.put("11191182", "V0pNdkQ90RGBp2pMXkBBDsjn,hns67nHgLILpE1Mq2v4PDuBrAGoUICVP");
		keyArray.put("11191369", "j8lEkkrmQmjAOHgUEckYdDxq,e7o076cd6wVBHcEwso5vGFdzbuAN9Xnv");
		keyArray.put("11191472", "0AnKYgoOtYGXGGAAufYKakC6,Zi81WGePwLGXN6iFGQqkyImnHpXXhWlI");
		keyArray.put("11191530", "n8VSMknfjU0ACjGLmVAe1qlG,ImUC05SePD3tG2ESBLV2vswm9ssnCt6a");
		
		return keyArray;
	}

}

