package com.eking.framework.common;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * 规范
 * DAO数据类型
 * @author jiminghu
 *
 * @param <DATA>
 */
@SuppressWarnings("serial")
@Data
@ToString
public abstract class DefaultDataBean<DATA> implements Serializable{
}
