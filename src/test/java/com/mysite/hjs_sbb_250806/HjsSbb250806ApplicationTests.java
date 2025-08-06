package com.mysite.hjs_sbb_250806;

import com.mysite.hjs_sbb_250806.article.Article;
import com.mysite.hjs_sbb_250806.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class HjsSbb250806ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void testJpa() {
		Article a1 = new Article();
		a1.setSubject("what is sbb?");
		a1.setContent("I wanna know sbb");
		a1.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(a1);

		Article a2 = new Article();
		a2.setSubject("It is Question of Spring boot");
		a2.setContent("is made Id automatically?");
		a2.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(a2);
	}

}
