package com.boot.novel.controllers;

import com.boot.novel.models.Novel;
import com.boot.novel.services.LikeService;
import com.boot.novel.services.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/add/{id}")
    public String addLike(@PathVariable Long id, Model model) {
        // Thêm sản phẩm đã "like" vào cơ sở dữ liệu hoặc danh sách
        likeService.addLike(id);

        // Lấy danh sách sản phẩm đã "like" để hiển thị trong like.html
        model.addAttribute("likedItems", likeService.getAllLikedItems());

        // Chuyển hướng sang trang like.html
        return "like";
    }
}
