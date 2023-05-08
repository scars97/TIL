package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.entity.Product;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMember() {
		//given
		Member member = new Member();
		member.setUserName("practice");
		Long memberId = memberRepository.save(member);
		
		//when
		Member findMember = memberRepository.findOne(memberId);
		
		//then
		assertThat(findMember.getId()).isEqualTo(member.getId());
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testProduct() {
		//given
		Product product = new Product();
		product.setName("item");
		Long productId = productRepository.save(product);
		
		//when
		Product findProduct = productRepository.findOne(productId);
		
		//then
		assertThat(findProduct.getId()).isEqualTo(product.getId());
		
	}
}
