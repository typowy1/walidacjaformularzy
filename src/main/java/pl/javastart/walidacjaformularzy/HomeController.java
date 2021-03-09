package pl.javastart.walidacjaformularzy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    //Wyświetlanie strony formularza i stowrzenie obiektu pod formularz
    @GetMapping("/")
    public String showForm(Model model) { //do modelu dodajemy pust obiekt typyu ExpenseDto
        model.addAttribute("newExpense", new ExpenseDto());
        return "home";
    }

    @PostMapping("/addExpense")
    public String addExpenseDto(Model model, @Valid @ModelAttribute("newExpense") ExpenseDto expenseDto, BindingResult bindingResult) { // BindingResult bindingResul musi byc za @Valid ExpenseDto expenseDto, to przyjmuje obiekt expense dto, Valid włącza mechanizm walidacji,Bidingresult tu trafia informacje o tym czy się udało zwalidować

        //chcemy sprawdzic czy tu sa nie puste rzeczy
        //jezeli bindingResult ma błędy to zwracamy formularz
        if (bindingResult.hasErrors()) {
            model.addAttribute("newExpense", expenseDto); //zamiast tworzyc na nowo przekarzemy obiekt ktory juz zostal czesciowo utworzony
            return "home";
        }
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String successPage() { //tu nic nie przyjmujemy
        return "success";
    }

}
