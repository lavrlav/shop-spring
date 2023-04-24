package com.example.shopspring.controllers;

import com.example.shopspring.models.ItemModel;
import com.example.shopspring.models.RequestModel;
import com.example.shopspring.repository.ItemRepository;
import com.example.shopspring.repository.RequestRepository;
import com.example.shopspring.utils.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    RequestRepository requestRepository;

    @GetMapping
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/edit")
    public String getAll(Model model){
        List<ItemModel> list = itemRepository.findAll();
        list = TimeFormatUtil.getTime(list);
        model.addAttribute("items", list);

        return "addItem";
    }
    @GetMapping("/req")
    public String getPage(Model model){
        List<RequestModel> list = requestRepository.findAll();
        model.addAttribute("req", list);
        return "requests";
    }

}
