package com.bezkoder.spring.datajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation. annotation. Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bezkoder.spring.datajpa.model.Comment;
import com.bezkoder.spring.datajpa.repository.CommentRepository;

@Controller
public class CommentController {

    private final CommentRepository repository;

    //@Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getAllComments(@ModelAttribute Comment comment, Model model) {
        // COMMENTテーブル：レコード全件取得
        model.addAttribute("comments", repository.findAll());
        return "list.html";
    }

    @PostMapping("/add")
    public String addComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {
        model.addAttribute("comments", repository.findAll());
        if (result.hasErrors()) {
            return "list";
        }
        // COMMENTテーブル：コメント登録
        repository.save(comment);
        // ルートパス("/") にリダイレクトします
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {
        model.addAttribute("comments", repository.findAll());
        // COMMENTテーブル：レコード削除
        repository.deleteById(comment.getId());
        // ルートパス("/") にリダイレクトします
        return "redirect:/";
    }

}