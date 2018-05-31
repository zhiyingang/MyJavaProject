/*
 * RegexUtils.java created on 2014年11月21日 上午11:11:51 by 谢清
 */

package com.eking.framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类 TODO javadoc for org.eking.framework.utils.RegexUtils
 * 
 * @Copyright: 2014海南易建科技股份有限公司
 * @author: 谢清
 * @since: 2014年11月21日
 */
public class RegexUtils {

	/**
	 * 身份证
	 * 
	 * @creator: xie-qing
	 * @createDate: 2014年11月21日
	 * @modifier:
	 * @modifiedDate:
	 * @param idCard
	 * @return
	 */
	public static boolean isIdCard(String idCard) {

		// 定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）
		Pattern idCardPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");

		// 通过Pattern获得Matcher
		Matcher idCardMatcher = idCardPattern.matcher(idCard);

		return idCardMatcher.matches();
	}

	/**
	 * 找出匹配正则表达式的字符串,并返回String[]
	 * 
	 * @param str
	 * @param regex
	 * @return
	 */
	public static List<String> match(String str, String regex) {
		
		List<String> list = new ArrayList<String>();
		String tempStr = "";
		int fIndex = 0;
		int lIndex = 0;
		int i = 0;
		Pattern p = Pattern.compile(regex);
		
		Matcher matcher = p.matcher(str);
		while (matcher.find(0)) {
			tempStr = matcher.group(0);
			fIndex = str.indexOf(tempStr);
			lIndex = fIndex + tempStr.length();
			str = str.substring(0, fIndex) + str.substring(lIndex,str.length());
			matcher = p.matcher(str);
			list.add(tempStr);
			i ++;
		}
		return list;
	}

	public static void main(String[] args) {
		
//		List<String> strArr = RegexUtils.match("2016年-02-14至2016-02-21", "[0-9]+[年月日]*");
//		
//		for(String str:strArr){
//			System.out.println(str);
//		}
		System.out.println("\n  佛教 \n".replaceAll("\\s*|\t|\r|\n", ""));
	}
}
