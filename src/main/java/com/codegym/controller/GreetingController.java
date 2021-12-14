package com.codegym.controller;
import com.codegym.model.Dictionary;
import com.codegym.service.DictionaryServiceImpl;
import com.codegym.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
@Controller
public class GreetingController {
    @Autowired
    DictionaryServiceImpl dictionaryService ;

    @GetMapping("")
    public ModelAndView greeting() {
        return new ModelAndView("/input");
    }
    @PostMapping("")
    public ModelAndView find(Model model,@RequestParam String english) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("/input");
        Dictionary dictionary = dictionaryService.findByName(english);
        model.addAttribute("result", dictionary.getViet());
        return modelAndView;
    }
}