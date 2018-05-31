
package com.eking.framework.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * 规范
 * rest/web result数据类型
 * @author jiminghu
 * @param <DATA>
 */
@Data
public class ResultInfo<DATA> implements Serializable {

	private static final long serialVersionUID = 3091621266434772952L;

	private Integer code;

	private String message;

	private DATA data;

	public ResultInfo(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultInfo(String message) {
		this.code = 200;
		this.message = message;
	}

	public ResultInfo(String message, DATA data) {
		this.code = 200;
		this.message = message;
		this.data = data;
		checkData();
	}

	public ResultInfo(DATA data) {
		this.code = 200;
		this.message = "成功";
		this.data = data;
		checkData();
	}

	public ResultInfo(Integer code, String message, DATA data) {
		this.code = code;
		this.message = message;
		this.data = data;
		checkData();
	}

	private void checkData() {
		if (Objects.isNull(data)) {
			this.code = 404;
			this.message = "失败";
		} else if (data instanceof String) {
			if (StringUtils.isBlank(String.valueOf(data))) {
				this.code = 404;
				this.message = "失败";
			}
		} else if (data instanceof Collection) {
			if (CollectionUtils.isEmpty((Collection<?>) data)) {
				this.code = 404;
				this.message = "失败";
			}
		} else if (data.getClass().isArray()) {
			if (ArrayUtils.isEmpty((Object[]) data)) {
				this.code = 404;
				this.message = "失败";
			}
		}
	}
}
