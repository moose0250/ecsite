package com.example.ecsite.model.form;

import java.io.Serializable;

import lombok.Data;

// 画面からJavaプログラムに送るデータを管理するクラス
@Data
public class LoginForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
}
