package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.entity.Product;

@SpringBootTest
public class MappingTest {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	void mappingTest() {
		//given
		Member member = setMember();
		Product product = setProduct();
		Product findProduct = productRepository.findOne(product.getId());
		//중간테이블에 데이터 넣어주는 코드
		member.getProducts().add(findProduct);
		
		//when
		System.out.println("중간 테이블 데이터 넣은 쿼리문");
		Long memberId = memberRepository.save(member);
		Member findMember = memberRepository.findOne(memberId);
		
		//then
		assertThat(findMember.getProducts().get(0)).isNotNull();
		
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
