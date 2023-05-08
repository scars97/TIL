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
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void mappingTest() {
		//given
		Member member = setMember();
		Product product = setProduct();
		Long productId = productRepository.save(product);
		Product findProduct = productRepository.findOne(productId);
		member.getProducts().add(findProduct);
		
		//when
		Long memberId = memberRepository.save(member);
		Member findMember = memberRepository.findOne(memberId);
		
		//then
		assertThat(findMember.getProducts().get(0)).isNotNull();
		
	}
	
	private Member setMember() {
		Member member = new Member();
		member.setUserName("practice");
		return member;
	}
	
	private Product setProduct() {
		Product product = new Product();
		product.setName("item");
		return product;
	}
}
