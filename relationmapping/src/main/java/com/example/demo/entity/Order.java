package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orders_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY) // 즉시로딩은 에측의 어려움, 어떤 SQL이 실행될지 추적하기 어려움. 
	@JoinColumn(name = "member_id")
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private List<Product> products = new ArrayList<>();
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)//ORDINAL로하면 Integer타입으로 나타남.
	private OrderStatus status;
}
