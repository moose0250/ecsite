package com.example.ecsite.model.form;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

// カート情報は、カートに入れた商品のリストとしてわたってくるため、
// Cartのリストを保持する役目をもつクラス
@Data
public class CartForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private List<Cart> cartList;
	
}
