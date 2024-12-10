package com.boot.novel.services;

import com.boot.novel.models.Novel;
import com.boot.novel.repository.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private List<Novel> likedNovels = new ArrayList<>();

    // Thêm tiểu thuyết vào danh sách yêu thích
    public void addToLikedNovels(Novel novel) {
        likedNovels.add(novel);
    }

    // Xóa tiểu thuyết khỏi danh sách yêu thích
    public void removeFromLikedNovels(Long novelId) {
        likedNovels.removeIf(novel -> novel.getId().equals(novelId));
    }

    // Cập nhật thông tin tiểu thuyết yêu thích
    public void updateLikedNovel(Long novelId, Novel updatedNovel) {
        for (int i = 0; i < likedNovels.size(); i++) {
            if (likedNovels.get(i).getId().equals(novelId)) {
                likedNovels.set(i, updatedNovel); // Thay thế tiểu thuyết cũ bằng tiểu thuyết mới
                break;
            }
        }
    }

    public List<Novel> getLikedNovels() {
        return likedNovels;
    }
}
