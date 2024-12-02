package com.boot.novel.controllers;

import com.boot.novel.models.Author;
import com.boot.novel.models.Novel;
import com.boot.novel.models.Chapter;
import com.boot.novel.services.AuthorService;
import com.boot.novel.services.NovelService;
import com.boot.novel.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/novels")
public class NovelController {

    @Autowired
    private NovelService novelService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ChapterService chapterService;

    // Hiển thị danh sách các tiểu thuyết và tác giả
    @GetMapping
    public String getAllNovels(Model model) {
        List<Novel> novels = novelService.getAllNovels();
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("novels", novels);
        model.addAttribute("authors", authors);
        return "form"; // Trả về trang danh sách
    }

    @GetMapping("/{id}")
    public String getNovelById(@PathVariable Long id, Model model) {
        Novel novel = novelService.getNovelById(id); // Lấy thông tin truyện theo ID
        model.addAttribute("novel", novel);         // Thêm thông tin vào model

        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
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

    // Lọc theo thể loại
    @GetMapping("/filter/{genre}")
    public String filter(@PathVariable String genre, Model model) {
        List<Novel> novels = novelService.getNovelsByGenre(genre);
        model.addAttribute("novels", novels);
        return "form"; // Trả về trang form
    }

    // Hiển thị chương của tiểu thuyết
    @GetMapping("/{novelId}/chapter/{chapterNumber}")
    public String getChapter(@PathVariable Long novelId, @PathVariable int chapterNumber, Model model) {
        // Tìm tiểu thuyết theo ID
        Novel novel = novelService.getNovelById(novelId);
        if (novel == null) {
            model.addAttribute("error", "Tiểu thuyết không tồn tại.");
            return "error"; // Nếu tiểu thuyết không tồn tại, trả về trang lỗi
        }
        model.addAttribute("novel", novel);

        // Tìm chương theo số chương và tiểu thuyết
        Chapter chapter = chapterService.getChapterByNovelAndNumber(novelId, chapterNumber);
        if (chapter != null) {
            model.addAttribute("chapter", chapter);  // Thêm thông tin chương vào model
        } else {
            model.addAttribute("error", "Chương không tồn tại.");
        }

        return "chapter"; // Trả về trang chapter.html
    }
}
