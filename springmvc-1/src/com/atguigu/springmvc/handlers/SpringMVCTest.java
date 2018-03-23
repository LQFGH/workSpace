package com.atguigu.springmvc.handlers;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.entitys.Address;
import com.atguigu.springmvc.entitys.User;

//@SessionAttributes(value= {"user"},types= {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/excelView")
	public String excelView() {
		System.out.println("excelView");
		return "excelView";
	}
	
	@RequestMapping(value="/testView", method = RequestMethod.GET)
	public String testView() {
		System.out.println("testView");
		return "testView";
	}
	
	@RequestMapping(value="/testViewAndViewReslver",method=RequestMethod.GET)
	public String testViewAndViewReslver() {
		System.out.println("testViewAndViewReslver");
		return SUCCESS;
	}
	
	
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		System.out.println("ModelAttributeMethod...");
		if (id != null) {
			System.out.println("执行修改操作");
			User user = new User();
			user.setId(1);
			user.setUsername("GuanXiaotong");
			user.setEmail("GuanXiaotong@...com");
			user.setPassword("123");
			System.out.println("从数据库获取对象" + user);
			map.put("user", user);
		}
	}

	@RequestMapping(value = "/testModelAttribute", method = RequestMethod.POST)
	public String testModelAttribute(Map<String, Object> map, User user) {
		System.out.println("修改：" + user);
		return SUCCESS;
	}

	@RequestMapping(value = "/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map) {
		User user = new User();
		user.setUsername("luhan");
		user.setPassword("guanxiaotong");
		user.setEmail("luhan@...com");
		user.setAddress(new Address("上海", "淞虹路"));
		map.put("user", user);
		map.put("school", "NXMU");
		return SUCCESS;
	}

	@RequestMapping(value = "/testMap", method = RequestMethod.GET)
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("zhangsan,lisi,wangmazi"));
		return SUCCESS;
	}

	@RequestMapping(value = "/testModelAndView", method = RequestMethod.GET)
	public ModelAndView testModelAndView() {
		ModelAndView mad = new ModelAndView(SUCCESS);
		mad.addObject("time", new Date());
		return mad;
	}

	@RequestMapping(value = "/testServletApi", method = RequestMethod.GET)
	public String testServletApi(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("testRequest", "requestValue");
		System.out.println("Request:" + request);
		System.out.println("Response:" + response);
		return SUCCESS;
	}

	@RequestMapping(value = "/testPOJO", method = RequestMethod.POST)
	public String testPOJO(User user) {
		System.out.println(user);
		return SUCCESS;
	}

	@RequestMapping(value = "/testCookieValue", method = RequestMethod.GET)
	public String testCookieValue(@CookieValue(value = "JSESSIONID") String JSESSIONID) {
		System.out.println("JSESSIONID : " + JSESSIONID);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRequestHeader", method = RequestMethod.GET)
	public String testRequestHeader(@RequestHeader(value = "Accept-Language") String AcceptLanguage) {
		System.out.println("testRequestHeader Date: " + AcceptLanguage);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRequestParam", method = RequestMethod.GET)
	public String testRequestParam(@RequestParam(value = "username") String username,
			@RequestParam(value = "age", required = false) Integer age) {
		System.out.println("testRequestParam : " + username + "-->" + age);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testPut(@PathVariable Integer id) {
		System.out.println("testPut: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testDelete(@PathVariable Integer id) {
		System.out.println("testDelete: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testPost() {
		System.out.println("testPost");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testGet(@PathVariable("id") int id) {
		System.out.println("testGet: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testPathVariable/{id}", method = RequestMethod.GET)
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("PathVariable = " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}

	@RequestMapping(value = "/testParams", method = RequestMethod.GET, params = { "username", "age!=10" })
	public String testParams() {
		System.out.println("testParams");
		return SUCCESS;
	}

	@RequestMapping(value = "/testMethod", method = RequestMethod.GET)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}

	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}

}
