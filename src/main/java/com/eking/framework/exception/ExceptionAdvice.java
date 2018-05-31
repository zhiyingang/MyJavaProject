package com.eking.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.eking.framework.common.ResultInfo;

/**错误处理<br/>
 * 200 成功<br/>
 * 403 没有权限<br/>
 * 404 没有资源<br/>
 * 500 错误<br/>
 * <br/>
 * 1000 单元化配置错误<br/>
 * 	1100 数据库配置错误<br/>
 * 		1110 主结构数据库配置错误<br/>
 * 		1120 Mongo数据库配置错误<br/>
 * 		1130 Neo4j数据库配置错误<br/>
 * 		1140 Redis数据库配置错误<br/>
 * 	1200 安全配置错误<br/>
 * 	1300 Quartz配置错误<br/>
 * 	1400 swagger-ui配置错误<br/>
 * 2000 微服务化配置错误<br/>
 * 	2100 服务注册发现配置错误<br/>
 * 	2200 服务消费配置错误<br/>
 * 	2300 服务网关配置错误<br/>
 * 	2400 服务可用性配置错误<br/>
 * 3000 ADMIN级别操作业务错误<br/>
 * 	3100 用户操作业务错误<br/>
 * 	3200 角色操作业务错误<br/>
 * 	3300 权限操作业务错误<br/>
 * 	3400 日志操作业务错误<br/>
 * 	3500 平台级操作业务错误<br/>
 * 4000 USER级别操作业务错误<br/>
 * 	4100 项目业务错误<br/>
 * 	4200 任务业务错误<br/>
 * 	4300 本体业务错误<br/>
 * 		4310 本体业务错误<br/>
 * 		4320 本体概念业务错误<br/>
 * 		4330 本体属性业务错误<br/>
 * 		4340 本体关系业务错误<br/>
 * 	4400 本体映射业务错误<br/>
 * 		4410 本体映射业务错误<br/>
 * 		4420 本体概念映射业务错误<br/>
 * 		4430 本体属性映射业务错误<br/>
 * 		4440 本体关系映射业务错误<br/>
 * 	4500 数据源业务错误<br/>
 * 	4600 图操作业务错误<br/>
 * @author jiminghu
 * @see com.eking.framework.mvc.MyException
 */
@ControllerAdvice(basePackages= {"com.eking"})
public class ExceptionAdvice {
	@ExceptionHandler(MyException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultInfo<?> handleMyException(WebRequest request, Throwable ex) {
		MyException myEx = (MyException)ex;
		return new ResultInfo<>(myEx.getCode(), myEx.getMessage(),request.getParameterMap());
	}
}
