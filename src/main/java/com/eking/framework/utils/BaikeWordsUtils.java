/*
 * RegexUtils.java created on 2014年11月21日 上午11:11:51 by 谢清
 */

package com.eking.framework.utils;

import java.util.List;

/**
 * 百科数据字符串处理工具
 * 
 * @author 鲍立飞
 *
 */
public class BaikeWordsUtils {

	
	public static String geteLabel(String str) {

		// Script here
		String lable = null;
		// 影视
		List<String> tv = null;

		List<String> Movie = null;
		// 戏曲戏剧
		List<String> Drama = null;
		List<String> Opera = null;
		// 音乐
		List<String> Music = null;
		// 相声
		List<String> Crosstalk = null;
		// 综艺
		List<String> Variety = null;
		// 动漫
		List<String> Comic = null;
		// 小品
		List<String> Sketch = null;
		// 小说
		List<String> Novel = null;

		tv = RegexUtils.match(str, "(剧)|(戏剧)|(剧情片)|(主题曲)|(戏曲名剧)|(京剧)");
		
		// 影视
		if (tv != null) {

			if (tv.indexOf("剧") != -1 && tv.indexOf("主题曲") != -1 && tv.indexOf("戏剧") == -1 && tv.indexOf("剧情片") == -1
					&& tv.indexOf("戏曲名剧") == -1 && tv.indexOf("京剧") == -1) {
				lable = "Music";
			}

			if (tv.indexOf("剧") != -1 && tv.indexOf("主题曲") == -1 && tv.indexOf("戏剧") == -1 && tv.indexOf("剧情片") == -1
					&& tv.indexOf("戏曲名剧") == -1 && tv.indexOf("京剧") == -1) {
				lable = "TV";
			}

			if (tv.indexOf("剧") == -1 && tv.indexOf("主题曲") != -1 && tv.indexOf("戏剧") == -1 && tv.indexOf("剧情片") == -1
					&& tv.indexOf("戏曲名剧") == -1 && tv.indexOf("京剧") == -1) {
				lable = "Music";
			}

		}

		Movie = RegexUtils.match(str, "(电影)|(戏曲)|(曲)|(片)|(制片)|(电视剧)");

		if (Movie != null) {
			if (Movie.indexOf("电影") != -1 && Movie.indexOf("曲") != -1 && Movie.indexOf("戏曲") == -1) {
				lable = "Music";
			}
			if (Movie.indexOf("电影") != -1 && Movie.indexOf("曲") == -1 && Movie.indexOf("戏曲") == -1) {
				lable = "Movie";
			}
			if (Movie.indexOf("电影") == -1 && Movie.indexOf("曲") != -1 && Movie.indexOf("戏曲") == -1) {
				lable = "Music";
			}
			if (Movie.indexOf("曲") == -1 && Movie.indexOf("戏曲") == -1 && Movie.indexOf("片") != -1
					&& Movie.indexOf("制片") == -1 && Movie.indexOf("电视剧") == -1) {
				lable = "Movie";
			}
		}
		
		// 音乐
		Music = RegexUtils.match(str, "(演唱)|(音乐)|(专辑)|(主打歌)|(EP)|(民歌)");

		if (Music != null) {

			if (Music.indexOf("演唱") != -1 || Music.indexOf("音乐") != -1 || Music.indexOf("专辑") != -1
					|| Music.indexOf("主打歌") != -1 || Music.indexOf("EP") != -1 || Music.indexOf("民歌") != -1) {
				lable = "Music";
			}
		}
		
		// 相声
		Crosstalk = RegexUtils.match(str, "(相声)");

		if (Crosstalk != null) {
			if (Crosstalk.indexOf("相声") != -1) {
				lable = "Crosstalk";
			}
		}
		
		// 综艺
		Variety = RegexUtils.match(str, "(真人秀)|(脱口秀)|(话题秀)|(综艺)|(娱乐节目)");

		if (Variety != null) {

			if (Variety.indexOf("真人秀") != -1 || Variety.indexOf("脱口秀") != -1 || Variety.indexOf("话题秀") != -1
					|| Variety.indexOf("综艺") != -1 || Variety.indexOf("娱乐节目") != -1) {
				lable = "Variety";
			}
		}
		
		// 动漫
		Comic = RegexUtils.match(str, "(动画)|(漫画)|(动漫)");
		if (Comic != null) {

			if (Comic.indexOf("动画") != -1 || Comic.indexOf("漫画") != -1 || Comic.indexOf("动漫") != -1) {
				lable = "Comic";
			}
		}
		
		// 戏曲戏剧
		Opera = RegexUtils.match(str, "(戏曲)|(京剧)");
		if (Opera != null) {

			if (Opera.indexOf("京剧") != -1 || Opera.indexOf("戏曲") != -1) {
				lable = "Opera";
			}
		}

		Drama = RegexUtils.match(str, "(戏剧)");
		if (Drama != null) {

			if (Drama.indexOf("戏剧") != -1) {
				lable = "Drama";
			}
		}
		// 小品
		Sketch = RegexUtils.match(str, "(小品)");
		if (Sketch != null) {

			if (Sketch.indexOf("小品") != -1) {
				lable = "Sketch";
			}
		}
		
		// 小说
		Novel = RegexUtils.match(str, "(小说)");
		if (Novel != null) {
			if (Novel.indexOf("小说") != -1) {
				lable = "Novel";
			}
		}
		return lable;
	}

	public static void main(String[] args) {

		// List<String> strArr = RegexUtils.match("2016年-02-14至2016-02-21",
		// "[0-9]+[年月日]*");
		//
		// for(String str:strArr){
		// System.out.println(str);
		// }
		System.out.print(BaikeWordsUtils.geteLabel("主题曲"));
	}
}
