
package com.eking.elasticsearch.baseEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Elasticsearch查询 search 返回查询结果 share 实体类
 * TODO javadoc for com.eking.transform.entity.ShareEntity
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月26日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShareEntity implements Serializable {

	private static final long serialVersionUID = -5992054944008066880L;

	@JsonProperty("total")
	private int total;

	@JsonProperty("successful")
	private long successful;

	@JsonProperty("failed")
	private long failed;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("total", total).append("successful", successful).append("failed", failed).toString();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getSuccessful() {
		return successful;
	}

	public void setSuccessful(long successful) {
		this.successful = successful;
	}

	public long getFailed() {
		return failed;
	}

	public void setFailed(long failed) {
		this.failed = failed;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
