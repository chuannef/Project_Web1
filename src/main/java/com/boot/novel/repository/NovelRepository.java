package com.boot.novel.repository;

import com.boot.novel.models.Novel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NovelRepository extends JpaRepository<Novel, Long> {
//    @Query("SELECT * FROM novel WHERE genre LIKE %:genre%")
    List<Novel> findNovelsByGenre(String genre) ;
}
