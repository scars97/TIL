package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.entity.Product;

@SpringBootTest
public class SelectTest {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	void selectMemberProduct() {
		//given
		Member member = setMember();
		Product product = setProduct();
		Product product2 = setProduct(); //product 하나 더 생성.
		
		//when
		member.getProducts().add(product); // 중간테이블 데이터 넣기. 준영속 상태.
		Long memberId = memberRepository.save(member); // 영속 상태 만듦.
		member = memberRepository.findOne(memberId);
		member.getProducts().add(product2); // 생성되었던 중간 테이블 데이터의 product_id 변경
		memberId = memberRepository.save(member); // 변경된 데이터 저장.
		Member findMember2 = memberRepository.findOne(memberId);
		
		//then
		assertThat(member.getProducts()).isEqualTo(findMember2.getProducts());
	}
	
	private Member setMember() {
		Member member = new Member();
		member.setUserName("practice");
		memberRepository.save(member);
		return member;
	}
	
	private Product setProduct() {
		Product product = new Product();
		product.setName("item");
		productRepository.save(product);
		return product;
	}
}