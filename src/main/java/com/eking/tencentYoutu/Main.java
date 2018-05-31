package com.eking.tencentYoutu;

import org.json.JSONObject;

import com.eking.tencentYoutu.youtuCore.Youtu;


public class Main {


	// appid, secretid secretkey请到http://open.youtu.qq.com/获取
	// 请正确填写把下面的APP_ID、SECRET_ID和SECRET_KEY
	public static final String APP_ID = "10126519";
	public static final String SECRET_ID = "AKIDDammbEKtBMNByZgYehZN5d5NTN6icRoS";
	public static final String SECRET_KEY = "gO6pKkT7e019sWzLbf2Li5KRccSBpHYd";
	public static final String USER_ID = "280155"; //qq号
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Youtu youtu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT,USER_ID);
			JSONObject response;
	
			response = youtu.IdCardOcr("d:\\id.jpg",1);
			
			System.out.println("发卡机关："+response.get("authority"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
