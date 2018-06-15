package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.UserInfoForm;
import jp.co.axiz.web.service.UsersService;

@Controller
public class InsertController {

	@Autowired
	private UsersService us;
	@Autowired
	HttpSession session;

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String select(@ModelAttribute("command") UserInfoForm form, BindingResult bindingResult, Model model){
		return "insert";
	}


	@RequestMapping(value="/insertConfirm",method = RequestMethod.POST)
	public String insert(@ModelAttribute("command") UserInfoForm form,Model model) {

			// ログインID、パスワードを取得
		session.setAttribute("insertname", form.getName());
		session.setAttribute("inserttel", form.getTel());
		session.setAttribute("insertpass", form.getPass());		//確認画面で使うからセッションいれるよ
		return "insertConfirm";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("command") UserInfoForm form,Model model) {
			// 入力値のチェック
			if ((pass == null || name == null || tel == null) || ("".equals(pass) || "".equals(name)|| "".equals(tel))) {
				return "insert";


			}else {

				model.addAttribute("tourokuname", name);
				model.addAttribute("tourokutel", tel);
				model.addAttribute("tourokupass", pass);


				// 次画面指定
				return "insertConfirm";
			}
		}
}
