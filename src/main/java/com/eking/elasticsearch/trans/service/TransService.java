
package com.eking.elasticsearch.trans.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eking.elasticsearch.repository.ElasticSearchRestRepository;

@Service("transService")
public class TransService {

	@Autowired
	private ElasticSearchRestRepository esRestClient;
	
	private String queryDSL = "";

	public String getApi() throws Exception {
		
		return esRestClient.getApi();
	}
	
	
	public String pageNum () {
/*		
		esRestClient.
		
	       SearchResponse searchResponse = esUtils.getClient()  
	                .prepareSearch("school").setSearchType(SearchType.SCAN)  
	                .setSize(10).setScroll(new TimeValue(20000)).execute()  
	                .actionGet();//注意:首次搜索并不包含数据  
	        //获取总数量  
	        long totalCount = searchResponse.getHits().getTotalHits();  
	        
	        */
		return "test"; 
	}
}
