package com.kashu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

		@RequestMapping(value="/cart/add")
		public String addToCart(@RequestParam(value="productId",required = false) Long id,
				@RequestParam(value="amount",required=false) Integer amount,Model model){
			model.addAttribute("productId", id);
			model.addAttribute("amount", amount);
			return "cart/add_success";
		}
}
