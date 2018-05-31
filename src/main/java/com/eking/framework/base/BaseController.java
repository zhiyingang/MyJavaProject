/*
 * BaseController.java created on 2013-08-16 下午 16:20:12 by 谢清
 */

package com.eking.framework.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Controller 基类
 * TODO javadoc for com.eking.framework.base.BaseController
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月22日
 */
public abstract class BaseController {

	/** 日志类*/
	protected Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	/**
	 * 客户端返回JSON字符串
	 * @param response
	 * @param object
	 * @return
	 */
	protected String renderJson(HttpServletResponse response, Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error(e.toString());
		}
		return renderString(response, json, "application/json");
	}
	
	/**
	 * 客户端返回字符串
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
	        response.setContentType(type);
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * to JSON 应用
	 * @description: TODO
	 * @creator: 李景帆(jingf_li@haihangyun.com)
	 * @createDate: 2018年3月27日 
	 * @modifier:
	 * @modifiedDate:
	 * @param obj
	 */
    public void toJson(Object obj){
        // write your code here
        ObjectMapper mapper = new ObjectMapper();
        try {
			String jsonInString = mapper.writeValueAsString(obj);
			logger.info(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
