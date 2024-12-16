package com.boot.novel.services;

import com.boot.novel.models.Novel;
import com.boot.novel.repository.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovelService {

    @Autowired
    private NovelRepository novelRepository;

    @Autowired
    private LikeService likeService; // Inject LikeService

    // Lấy tất cả tiểu thuyết
    public List<Novel> getAllNovels() {
        return novelRepository.findAll();
    }

    // Lấy tiểu thuyết theo id
    public Novel getNovelById(Long id) {
        Optional<Novel> novel = novelRepository.findById(id);
        return novel.orElse(null); // Trả về tiểu thuyết nếu có, nếu không trả về null
    }

    // Lưu tiểu thuyết
    public void saveNovel(Novel novel) {
        novelRepository.save(novel);
    }

    // Xóa tiểu thuyết
    public void deleteNovel(Long id) {
        novelRepository.deleteById(id);
    }

    public List<Novel> getNovelsByGenre(String genre) {
        return novelRepository.findNovelsByGenre(genre);
    }




}
