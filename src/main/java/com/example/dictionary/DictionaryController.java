package com.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
private final Map<String,String>dictionary=new HashMap<>();
public DictionaryController(){
    dictionary.put("hello","Xin chao");
    dictionary.put("banana","Chuối");
    dictionary.put("hi","chao");
    dictionary.put("chicken","con ga");
    dictionary.put("girl","gái");
    dictionary.put("son","con trai");
}
@GetMapping("/home")
    public String home(){
    return "index";
}
    @GetMapping("/lookup")
    public ModelAndView lookup(@RequestParam("word") String word) {
        ModelAndView mv = new ModelAndView("result");
        String meaning = dictionary.getOrDefault(word.toLowerCase(), "Không tìm thấy từ");
        mv.addObject("meaning", meaning);
        return mv;
    }
}
