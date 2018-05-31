package com.eking.framework.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("html5")
@Api(tags= "thymeleaf模板示例")
public class ExHtml5TemplateController {
	@GetMapping("basic")
	@ApiOperation("简单跳转")
	public String basic() {
		return "basic";
	}
	
	@GetMapping("model")
	@ApiOperation("带参跳转")
	public ModelAndView thymeleafView() {
		ModelMap model = new ModelMap();
		model.put("test", "使用数据");
		return new ModelAndView("basic").addAllObjects(model);
	}
	
	@GetMapping("zuul")
	@ApiIgnore
	public ModelAndView toZuul() {
		return new ModelAndView("zuul");
	}
}
