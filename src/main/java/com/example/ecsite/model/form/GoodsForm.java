package com.example.ecsite.model.form;

import java.io.Serializable;

import lombok.Data;

// 新規商品を登録する機能
@Data
public class GoodsForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String goodsName;
	private long price;
	
}
