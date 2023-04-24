package com.example.shopspring.controllers;

import com.example.shopspring.models.RequestModel;
import com.example.shopspring.repository.RequestRepository;
import com.example.shopspring.utils.ItemModelWithCurrency;
import com.example.shopspring.models.ItemModel;
import com.example.shopspring.repository.ItemRepository;
import com.example.shopspring.secvices.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/item")
public class DetailItemController {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id,
                                Model model) {
        ItemModel itemModel = itemRepository.findById(id);
        ItemModelWithCurrency itemModelWithCurrency = new ItemModelWithCurrency(itemModel);
        itemModelWithCurrency.setEurPrice(currencyService.getEurPrice(itemModel.getPrice()));
        itemModelWithCurrency.setUsdPrice(currencyService.getUsdPrice(itemModel.getPrice()));
        model.addAttribute("item", itemModelWithCurrency);
        return "detailItem";
    }
    @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable long id,
                                 @RequestParam String name, @RequestParam String phoneNumber){
        RequestModel requestModel = new RequestModel();
        requestModel.setName(name);
        requestModel.setItemId(id);
        requestModel.setPhoneNumber(phoneNumber);
        requestRepository.save(requestModel);
        return new RedirectView("/allItems");

    }
}
