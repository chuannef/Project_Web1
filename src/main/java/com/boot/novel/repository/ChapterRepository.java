package com.boot.novel.repository;

import com.boot.novel.models.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    // Tìm chương theo tiểu thuyết và số chương
    Chapter findByNovelIdAndChapterNumber(Long novelId, int chapterNumber);
}
