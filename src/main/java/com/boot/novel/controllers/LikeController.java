package com.boot.novel.controllers;

import com.boot.novel.models.Novel;
import com.boot.novel.services.LikeService;
import com.boot.novel.services.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;
    @Autowired
    private NovelService novelService;

    @GetMapping("/like")
    public String formlike(Model model) {
        model.addAttribute("likedNovels", likeService.getLikedNovels());
        return "like";
    }

    @PostMapping("/like/add")
    public String addLike(@RequestParam("novelId") Long novelId) {
        Novel novel = novelService.getNovelById(novelId); // Tìm kiếm tác phẩm theo ID
        if (novel != null) {
            likeService.addToLikedNovels(novel); // Thêm vào danh sách yêu thích
        }
        return "redirect:/like"; // Điều hướng về trang yêu thích sau khi thêm
    }

    @PostMapping("/like/remove")
    public String removeLike(@RequestParam("novelId") Long novelId) {
        likeService.removeFromLikedNovels(novelId); // Xóa khỏi danh sách yêu thích
        return "redirect:/like"; // Điều hướng về trang yêu thích sau khi xóa
    }

    @PostMapping("/like/update")
    public String updateLike(@RequestParam("novelId") Long novelId, @ModelAttribute Novel updatedNovel) {
        likeService.updateLikedNovel(novelId, updatedNovel); // Cập nhật tác phẩm yêu thích
        return "redirect:/like"; // Điều hướng về trang yêu thích sau khi cập nhật
    }
}
