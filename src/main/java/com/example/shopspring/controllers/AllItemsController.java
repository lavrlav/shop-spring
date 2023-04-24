package com.example.shopspring.controllers;

import com.example.shopspring.utils.TimeFormatUtil;
import com.example.shopspring.models.ItemModel;
import com.example.shopspring.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/allItems")
public class AllItemsController {
    private final ItemRepository itemRepository;

    public AllItemsController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String getAllItemsPage(Model model) {
        List<ItemModel> list = itemRepository.findAll();
        list = TimeFormatUtil.getTime(list);
        model.addAttribute("items", list);

        return "allItems";
    }

}
