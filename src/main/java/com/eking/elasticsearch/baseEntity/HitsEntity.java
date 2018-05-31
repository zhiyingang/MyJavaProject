
package com.eking.elasticsearch.baseEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Elasticsearch查询 search 返回查询结果 Hits 实体类
 * TODO javadoc for com.eking.framework.entity.HitsEntity
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月26日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HitsEntity<T> implements Serializable {

	private static final long serialVersionUID = -2507683410346218002L;

	@JsonProperty("total")
	private long total;

	@JsonProperty("max_score")
	private double maxScore;

	@JsonProperty("hits")
	private List<HitEntity<T>> hits;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("total", total).append("max_score", maxScore).append("hits", hits).toString();
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setHits(List<HitEntity<T>> hits) {
		this.hits = hits;
	}

	public List<HitEntity<T>> getHits() {
		return hits;
	}

	public double getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
