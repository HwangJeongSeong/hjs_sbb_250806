package com.mysite.hjs_sbb_250806.coment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentRepository extends JpaRepository<Coment, Integer> {

}