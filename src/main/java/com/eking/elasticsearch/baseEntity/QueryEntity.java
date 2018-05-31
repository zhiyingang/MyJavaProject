
package com.eking.elasticsearch.baseEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Elasticsearch查询 search 返回查询结果对象
 * TODO javadoc for com.eking.transform.entity.QueryEntity
 * @Copyright: 2018海南易建科技股份有限公司
 * @author: 李景帆(jingf_li@haihangyun.com)
 * @since: 2018年3月26日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryEntity<T> {

	@JsonProperty("_scroll_id")
	private String scrollId;

	@JsonProperty("took")
	private int took;

	@JsonProperty("timed_out")
	private boolean timedOut;

	@JsonProperty("_shards")
	private ShareEntity shards;

	@JsonProperty("hits")
	private HitsEntity<T> hits;

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("_scroll_id", scrollId).append("took", took).append("timed_out", timedOut).append("_shards",
				shards).append("hits", hits).toString();
	}

	public int getTook() {
		return took;
	}

	public void setTook(int took) {
		this.took = took;
	}

	public HitsEntity<T> getHits() {
		return hits;
	}

	public void setHits(HitsEntity<T> hits) {
		this.hits = hits;
	}

	public boolean isTimedOut() {
		return timedOut;
	}

	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}

	public ShareEntity getShards() {
		return shards;
	}

	public void setShards(ShareEntity shards) {
		this.shards = shards;
	}

	public String getScrollId() {
		return scrollId;
	}

	public void setScrollId(String scrollId) {
		this.scrollId = scrollId;
	}
}
