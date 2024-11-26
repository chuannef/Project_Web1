package com.boot.novel.services;

import com.boot.novel.models.Author;
import com.boot.novel.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Lấy tất cả tác giả
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Lấy tác giả theo id
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null); // Trả về tác giả nếu có, nếu không trả về null
    }

    // Lưu tác giả
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    // Xóa tác giả
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    // Lấy các tác giả theo thể loại tiểu thuyết

}
