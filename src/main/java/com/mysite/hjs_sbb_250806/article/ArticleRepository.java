package com.mysite.hjs_sbb_250806.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findBySubject(String subject);
    Article findBysubjectAndContent(String subject, String content);
    List<Article> findBySubjectLike(String subject);
}
