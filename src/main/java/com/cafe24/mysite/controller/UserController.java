package com.cafe24.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.repository.dao.UserDao;
import com.cafe24.mysite.repository.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		userDao.insertUser(userVo);

		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess(@ModelAttribute UserVo userVo) {

		return "user/joinsuccess";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "password", required = true, defaultValue = "") String password, HttpSession session,
			Model model) {

		UserVo authUser = userDao.get(email, password);
		if (authUser == null) {
			model.addAttribute("result", "fail");
			return "user/login";
		}

		// session 처리
		session.setAttribute("authUser", authUser);

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("authUser");
		session.invalidate();

		return "redirect:/";

	}

}
