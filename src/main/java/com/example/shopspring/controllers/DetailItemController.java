package com.example.shopspring.controllers;

import com.example.shopspring.helpers.ItemModelWithCurrency;
import com.example.shopspring.models.ItemModel;
import com.example.shopspring.repository.ItemRepository;
import com.example.shopspring.secvices.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class  DetailItemController {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CurrencyService currencyService;
    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id,
        Model model){
            ItemModel itemModel = itemRepository.findById(id);
        ItemModelWithCurrency itemModelWithCurrency = new ItemModelWithCurrency(itemModel);
        itemModelWithCurrency.setEurPrice(currencyService.getEurPrice(itemModel.getPrice()));
        itemModelWithCurrency.setUsdPrice(currencyService.getEurPrice(itemModel.getPrice()));
            model.addAttribute("item", itemModelWithCurrency);
            return "detailItem";
    }
}
