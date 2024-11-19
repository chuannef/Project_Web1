package com.boot.novel.controllers;

import com.boot.novel.models.Novel;
import com.boot.novel.services.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/novels")
public class NovelController {

    @Autowired
    private NovelService novelService;

    // Hiển thị danh sách các tiểu thuyết
    @GetMapping
    public String getAllNovels(Model model) {
        List<Novel> novels = novelService.getAllNovels();
        model.addAttribute("novels", novels);
        return "form"; // Trả về trang danh sách
    }

    @GetMapping("/{id}")
    public String getNovelById(@PathVariable Long id, Model model) {
        Novel novel = novelService.getNovelById(id); // Lấy thông tin truyện theo ID
        model.addAttribute("novel", novel);         // Thêm thông tin vào model
        return "detail"; // Trả về trang detail.html
    }



    // Hiển thị form tạo mới tiểu thuyết
    @GetMapping("/new")
    public String createNovelForm(Model model) {
        model.addAttribute("novel", new Novel()); // Thêm một đối tượng mới vào form
        return "form"; // Trả về trang form tạo tiểu thuyết
    }


    // Xóa tiểu thuyết
    @GetMapping("/delete/{id}")
    public String deleteNovel(@PathVariable Long id) {
        novelService.deleteNovel(id); // Xóa tiểu thuyết theo id
        return "redirect:/novels"; // Điều hướng về trang danh sách sau khi xóa
    }

    @GetMapping("/filter/{genre}")
    public String filter(@PathVariable String genre, Model model) {
        List<Novel> novels = novelService.getNovelsByGenre(genre);
        model.addAttribute("novels", novels);
        return "form";
    }
}
