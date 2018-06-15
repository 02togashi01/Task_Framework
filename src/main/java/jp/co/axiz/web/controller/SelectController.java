package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.entity.Userinfo;
import jp.co.axiz.web.service.UsersService;

@Controller
public class SelectController {

	@Autowired
	private UsersService us;
	@Autowired
	HttpSession hs;

	@RequestMapping("/select")
	public String select (@ModelAttribute("command") SelectForm form, BindingResult bindingResult, Model model) {
		return "select";
	}

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String login(@ModelAttribute("command") SelectForm form,BindingResult bindingResult, Model model){

		// ログインID、パスワードを取得
		String id = form.getId();
		String name = form.getName();
		String tel = form.getTel();

		// 入力値のチェック
		if ((id == null && name == null && tel == null) || ("".equals(id) && "".equals(name)&& "".equals(tel))) {

						UsersService userService = new UsersService();

							List<Userinfo> list = userService.find();
							model.addAttribute("UserinfoList", list);

							// 次画面指定
							return "selectResult";

		}else if ((id != null && name == null && tel == null) || (!("".equals(id)) && "".equals(name)&& "".equals(tel))) {
			//IDだけ


			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationID(iId);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";

		}else if((id == null && name != null && tel == null) || ("".equals(id) && !("".equals(name))&& "".equals(tel))) {
			//nameだけ空

			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationname(name);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";

		}else if((id == null && name == null && tel != null) || ("".equals(id) && "".equals(name)&& !("".equals(tel)))) {
			//telだけ空

			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationtel(tel);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";

		}else if((id == null && name != null && tel != null) || ("".equals(id)) && !("".equals(name))&& !("".equals(tel))) {
			//nameだけ空


			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationnameANDtel(name,tel);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";

		}else if((id != null && name == null && tel != null) || (!("".equals(id))) && "".equals(name)&& !("".equals(tel))) {
			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationidANDtel(iId,tel);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";

		}else if((id != null && name != null && tel == null) || (!("".equals(id))) && !("".equals(name))&& "".equals(tel)) {
			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationidANDname(iId,name);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";
		}else if((id != null && name != null && tel != null) || (!("".equals(id))) && !("".equals(name))&& !("".equals(tel))) {
			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationidANDnameANDtel(iId,name,tel);

			if (list ==null) {
				model.addAttribute("msg", "入力されたデータはありませんでした。");
				return "select";
			}

			//List<Userinfo> list = userService.find();
			model.addAttribute("UserinfoList", list);

			// 次画面指定
			return "selectResult";
		}
		//request.setAttribute("msg", "入力されたデータはありませんでした。");

		return "select";
	}

}
