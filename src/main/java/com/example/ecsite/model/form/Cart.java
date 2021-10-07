package com.example.ecsite.model.form;

import java.io.Serializable;

import lombok.Data;

// 購入機能 購入情報をフロントからJava側に渡す
@Data
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String goodsName;
	private long price;
	private long count;
	
}
