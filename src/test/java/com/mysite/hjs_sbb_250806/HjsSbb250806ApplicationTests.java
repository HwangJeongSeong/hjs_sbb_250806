package com.mysite.hjs_sbb_250806;

import com.mysite.hjs_sbb_250806.article.Article;
import com.mysite.hjs_sbb_250806.article.ArticleRepository;
import com.mysite.hjs_sbb_250806.coment.Coment;
import com.mysite.hjs_sbb_250806.coment.ComentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HjsSbb250806ApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ComentRepository comentRepository;

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

	@Test
	void testJpa2() {
		List<Article> all = this.articleRepository.findAll();
		assertEquals(2, all.size());

		Article a = all.get(0);
		assertEquals("what is sbb?", a.getSubject());
	}
	@Test
	void testJpa3() {
		Optional<Article> oa = this.articleRepository.findById(1);
		if(oa.isPresent()) {
			Article a = oa.get();
			assertEquals("what is sbb?", a.getSubject());
		}
	}

	@Test
	void testJpa4() {
		Article a = this.articleRepository.findBySubject("what is sbb?");
		assertEquals(1, a.getId());
	}

	@Test
	void testJpa5() {
		Article a = this.articleRepository.findBySubjectAndContent(
				"what is sbb?", "I wanna know sbb");
		assertEquals(1, a.getId());
	}

	@Test
	void testJpa6() {
		List<Article> aList = this.articleRepository.findBySubjectLike("sbb%");
		Article a = aList.get(0);
		assertEquals("what is sbb?", a.getSubject());
	}

	@Test
	void testJpa7() {
		Optional<Article> oa = this.articleRepository.findById(1);
		assertTrue(oa.isPresent());
		Article a = oa.get();
		a.setSubject("수정된 제목");
		this.articleRepository.save(a);
	}
	@Test
	void testJpa8() {
		assertEquals(2, this.articleRepository.count());
		Optional<Article> oa = this.articleRepository.findById(1);
		assertTrue(oa.isPresent());
		Article a = oa.get();
		this.articleRepository.delete(a);
		assertEquals(1, this.articleRepository.count());
	}

	@Test
	void testJpa9() {
		Optional<Article> oa = this.articleRepository.findById(2);
		assertTrue(oa.isPresent());
		Article q = oa.get();

		Coment a = new Coment();
		a.setContent("yes, It is produced automatically");
		a.setArticle(q);  // 어떤 질문의 답변인지 알기위해서 Article 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.comentRepository.save(a);
	}

	@Test
	void testJpa10() {
		Optional<Coment> oa = this.comentRepository.findById(1);
		assertTrue(oa.isPresent());
		Coment a = oa.get();
		assertEquals(2, a.getArticle().getId());
	}

	@Transactional
	@Test
	void testJpa11() {
		Optional<Article> oq = this.articleRepository.findById(2);
		assertTrue(oq.isPresent());
		Article q = oq.get();

		List<Coment> comentList = q.getComentList();

		assertEquals(1, comentList.size());
		assertEquals("yes, It is produced automatically", comentList.get(0).getContent());
	}
}


