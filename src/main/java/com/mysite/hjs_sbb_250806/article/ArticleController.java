package com.mysite.hjs_sbb_250806.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();

        model.addAttribute("articleList", articleList);
        return "article_list";

    }
    @GetMapping(value = "/detail/{id}")
    public String detail (Model model, @PathVariable("id") Integer id){
        return "article_detail";
    }
}


