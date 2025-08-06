package com.mysite.hjs_sbb_250806.coment;


import com.mysite.hjs_sbb_250806.article.Article;
import com.mysite.hjs_sbb_250806.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/coment")
@RequiredArgsConstructor
@Controller
public class ComentController {

    private final ArticleService articleService;
    private final ComentService comentService;

    @PostMapping("/create/{id}")
    public String createComent(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        Article article = this.articleService.getArticle(id);
        this.comentService.create(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }
}
