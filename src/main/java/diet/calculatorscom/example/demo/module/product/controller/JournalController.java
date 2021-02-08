package diet.calculatorscom.example.demo.module.product.controller;


import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalDto;
import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalForm;
import diet.calculator.com.example.diet_calculator.module.product.service.JournalService;
import diet.calculator.com.example.diet_calculator.module.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {

    private final JournalService journalService;
    private final ProductService productService;

    @GetMapping("/list")
    public String list(Model model) {
        List<JournalDto> list = journalService.getJournal();
        model.addAttribute("journalList", list);
        model.addAttribute("journal_form", new JournalForm());
        model.addAttribute("availableProducts", productService.getProducts());
        return "journal_list";
    }

    @PostMapping("/add")
    public String addNewJournalEntry(JournalForm journalForm) {
        journalService.addProductToJournal(journalForm);
        return "redirect:/journal/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "productId") Long productId) {
        journalService.delete(productId);
        return "journal_list";
    }


}
