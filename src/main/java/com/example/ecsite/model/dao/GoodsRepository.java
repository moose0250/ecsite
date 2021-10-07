package com.example.ecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecsite.model.entity.Goods;

// 全商品をgoodsテーブルから検索するためのDAO
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
