package com.example.ecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ecsite.model.dao.GoodsRepository;
import com.example.ecsite.model.dao.UserRepository;
import com.example.ecsite.model.entity.Goods;
import com.example.ecsite.model.entity.User;
import com.example.ecsite.model.form.GoodsForm;
import com.example.ecsite.model.form.LoginForm;

@Controller
@RequestMapping("/ecsite/admin") // URLでアクセス
public class AdminController {
	
	// Repositoryを読み込む
	@Autowired
	private UserRepository userRepos;
	@Autowired
	private GoodsRepository goodsRepos;
	
	
	// トップページ(adminindex.html)に遷移するメソッド
	@RequestMapping("/")
	public String index() {
		return "adminindex";
	}
	
	
	// LoginFormを使ってユーザ情報を受け取るメソッド
	@PostMapping("/welcome")
	public String welcome(LoginForm form, Model m) {
		// ユーザ名とパスワードでユーザを詮索
		List<User> users = userRepos.findByUserNameAndPassword(form.getUserName(), form.getPassword());
		
		// 検索結果が存在していれば、isAdmin(管理者かどうか)を取得し、管理者だった場合のみ処理
		if (users != null && users.size() > 0) {
			boolean isAdmin = users.get(0).getIsAdmin() != 0;
			if (isAdmin) {
				List<Goods> goods = goodsRepos.findAll();
				m.addAttribute("userName", users.get(0).getUserName());
				m.addAttribute("password", users.get(0).getPassword());
				m.addAttribute("goods", goods);
			}
		}
		
		return "welcome";
	}

	
	// 新規商品の登録機能
	@RequestMapping("/goodsMst")
	public String goodsMst(LoginForm form, Model m) {
		m.addAttribute("userName", form.getUserName());
		m.addAttribute("password", form.getPassword());
		
		return "goodsmst";
	}
	
	@RequestMapping("/addGoods")
	public String addGoods(GoodsForm goodsForm, LoginForm loginForm, Model m) {
		m.addAttribute("userName", loginForm.getUserName());
		m.addAttribute("password", loginForm.getPassword());
		
		Goods goods = new Goods();
		goods.setGoodsName(goodsForm.getGoodsName());
		goods.setPrice(goodsForm.getPrice());
		goodsRepos.saveAndFlush(goods);
		
		return "forward:/ecsite/admin/welcome";
	}
	
	
	// 商品マスタから商品を削除する機能
	// ページ遷移による処理ではなく、ajaxを使用した方式(REST)
	@ResponseBody
	@PostMapping("/api/deleteGoods")
	public String deleteApi(@RequestBody GoodsForm f, Model m) {
		try {
			goodsRepos.deleteById(f.getId());
		} catch (IllegalArgumentException e) {
			return "-1";
		}
		
		return "1";
	}
	
}
