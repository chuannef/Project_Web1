package com.boot.novel.services;

import com.boot.novel.models.Novel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService {

    private final List<Long> likedItems = new ArrayList<>();

    public void addLike(Long id) {
        if (!likedItems.contains(id)) {
            likedItems.add(id); // Thêm ID vào danh sách nếu chưa tồn tại
        }
    }

    public List<Long> getAllLikedItems() {
        return likedItems; // Trả về danh sách các sản phẩm đã "like"
    }
}
