package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class NoteController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/note")
    public String noteMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "note-main";
    }

    @GetMapping("/note/add")
    public String noteAdd(Model model){
        return "note-add";
    }
    @PostMapping("/note/add")
    public String notePostAdd(
            @RequestParam String title,
            @RequestParam String theme,@RequestParam String text, Model model){
        Post post = new Post(title,theme,text);
        postRepository.save(post);
        return "redirect:/note";
    }

    @GetMapping("/note/{id}")
    public String noteDetails(@PathVariable(value = "id") long id, Model model) {

        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()) {
            model.addAttribute("post", post.get());
        } else {
            return "Жок эшктеке";
        }

        return "note-details";
    }

    @GetMapping("/note/{id}/edit")
    public String noteEdit(@PathVariable(value = "id") long id, Model model) {

        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()) {
            model.addAttribute("post", post.get());
        } else {
            return "Жок эшктеке";
        }

        return "note-edit";
    }

    @PostMapping("/note/{id}/edit")
    public String noteUpdate(@PathVariable(value = "id") long id,
            @RequestParam String title,
            @RequestParam String theme,@RequestParam String text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setTheme(theme);
        post.setText(text);
        postRepository.save(post);
        return "redirect:/note";
    }
    @PostMapping("/note/{id}/remove")
    public String noteDelete(@PathVariable(value = "id") long id,
                              Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/note";
    }




}
