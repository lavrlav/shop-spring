package com.example.shopspring.controllers;

import com.example.shopspring.helpers.TimeHelper;
import com.example.shopspring.models.ItemModel;
import com.example.shopspring.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")

public class MainController {
    private final ItemRepository itemRepository;

    public MainController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String getMainPage(Model model) {
        List<ItemModel> list = itemRepository.findAll();
        list = list.stream().limit(5).collect(Collectors.toList());
        list = TimeHelper.getTime(list);
        model.addAttribute("items", list);
        return "index";
    }
}
