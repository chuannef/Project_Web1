package com.boot.novel.controllers;

import com.boot.novel.models.Author;
import com.boot.novel.models.Novel;
import com.boot.novel.models.Chapter;
import com.boot.novel.models.UserDto;
import com.boot.novel.services.AuthorService;
import com.boot.novel.services.NovelService;
import com.boot.novel.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LikeController {

    @Autowired
    private NovelService novelService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ChapterService chapterService;


    @GetMapping("/like")
    public String formlike(Model model){

        return "like";
    }
}
