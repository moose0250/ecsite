package com.example.ecsite.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecsite.model.entity.User;

// LoginFormから渡されるユーザ情報(ユーザ名、パスワード)を条件にDB検索するためのDAO
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserNameAndPassword(String userName, String password);
	
}
