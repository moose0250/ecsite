package com.example.ecsite.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Getter/Setterを省略
import lombok.Data;


//クラス宣言部を追加
@Entity
@Data // Getter/Setterを省略
@Table(name="user")
public class User {
	
//	DBテーブル(user)にある各カラムを、フィールドとして宣言
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="is_admin")
	private int isAdmin;
	
}
