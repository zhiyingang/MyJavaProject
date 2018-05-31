
package com.eking.elasticsearch.trans.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eking.elasticsearch.trans.service.TransService;
import com.eking.framework.base.BaseController;
import com.eking.framework.common.ResultInfo;

@RestController
@RequestMapping("trans")
public class TransController extends BaseController {

	@Autowired
	private TransService transService;
	
	@GetMapping("/post")
	public ResultInfo<String> index() throws Exception {
		
		return new ResultInfo<>(transService.getApi());
		
	}

}
