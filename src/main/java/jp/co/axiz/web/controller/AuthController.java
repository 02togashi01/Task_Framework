package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Form;
import jp.co.axiz.web.entity.Users;
import jp.co.axiz.web.service.UsersService;

@Controller
public class AuthController {

	@Autowired
	private UsersService us;
	@Autowired
	HttpSession hs;

	//TOP画面からログイン画面へ
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("command") Form form, BindingResult bindingResult, Model model){
		return "login";
	}

	//ログイン画面
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String postLogin(@ModelAttribute("command") Form form, BindingResult bindingResult, Model model) {

		String id = form.getId();
		String pass = form.getPass();

		// 入力値のチェック
		if ((id == null || pass == null) || ("".equals(id)) || ("".equals(pass))) {
			// メッセージ設定
			model.addAttribute("msg", "IDまたはPASSが間違っています。");

			// 次画面指定
			return "login";
		}

		// ログインチェック
		Users users = us.authentication(id, pass);
		boolean isSuccess = users != null;

		// 表示メッセージの受け渡し
		if (isSuccess) {
			model.addAttribute("Name", users.getUsersName());
			// 次画面指定
			return "menu";

		} else {
			// メッセージ設定
			model.addAttribute("msg", "IDまたはPASSが間違っています。");

			// 次画面指定
			return "login";
		}
	}

	//ログアウト
		@RequestMapping(value="/logout", method=RequestMethod.POST)
		public String logout(@ModelAttribute("command") Form form, BindingResult bindingResult, Model model) {

			return "logout";
		}
	}




