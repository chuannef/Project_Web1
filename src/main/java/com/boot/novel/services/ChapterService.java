package com.boot.novel.services;

import com.boot.novel.models.Chapter;
import com.boot.novel.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    // Lấy chương theo tiểu thuyết và số chương
    public Chapter getChapterByNovelAndNumber(Long novelId, int chapterNumber) {
        return chapterRepository.findByNovelIdAndChapterNumber(novelId, chapterNumber);
    }

    // Lưu chương mới
    public Chapter saveChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    // Xóa chương
    public void deleteChapter(Long chapterId) {
        chapterRepository.deleteById(chapterId);
    }


}
