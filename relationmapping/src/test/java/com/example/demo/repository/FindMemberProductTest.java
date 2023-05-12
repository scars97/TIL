package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.entity.Product;

@SpringBootTest
public class FindMemberProductTest {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void save() {
		Product productA = new Product();
	    productA.setName("상품A");
	    productRepository.save(productA);
	    Member member1 = new Member();
	    member1.setName("회원1");
	    member1.getProducts().add(productA); // 연관관계 설정
	    memberRepository.save(member1);
		

	    }
	}
	

