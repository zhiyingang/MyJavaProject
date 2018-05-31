
package com.eking.framework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.*;

//@RestController
@Controller
@Api(tags = "首页和登陆")
public class WebController {

	@GetMapping("")
	@ApiOperation("默认首页")
	public String defaultIndex() {
		return index();
	}

	@ApiOperation("首页跳转")
	@GetMapping("index")
	public String index() {
		return "index";
	}

	@ApiOperation("登陆跳转")
	@GetMapping("login")
	public String login() {
		return "login";
	}

	@ApiOperation("oauth登陆跳转")
	@GetMapping("oauth2login")
	public String oauth2login() {
		return "login";
	}
}
