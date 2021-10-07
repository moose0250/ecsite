package com.example.ecsite.model.form;

import java.io.Serializable;

import lombok.Data;

// 履歴表示機能 フロントからデータを渡すためのクラス
@Data
public class HistoryForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
}
