package com.mysite.hjs_sbb_250806.article;


import com.mysite.hjs_sbb_250806.coment.Coment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime crateDate;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Coment> comentList;

}
