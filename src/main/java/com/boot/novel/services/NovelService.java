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

    public List<Novel> getLikedNovels() {
        return likeService.getLikedNovels(); // Sử dụng LikeService để lấy danh sách yêu thích
    }

    public void addToLikedNovels(Novel novel) {
        likeService.addToLikedNovels(novel); // Sử dụng LikeService để thêm vào danh sách yêu thích
    }

    public void removeFromLikedNovels(Long novelId) {
        likeService.removeFromLikedNovels(novelId); // Sử dụng LikeService để xóa khỏi danh sách yêu thích
    }

    public void updateLikedNovel(Long novelId, Novel updatedNovel) {
        likeService.updateLikedNovel(novelId, updatedNovel); // Sử dụng LikeService để cập nhật danh sách yêu thích
    }
}
