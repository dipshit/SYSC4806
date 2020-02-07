package app;

import app.model.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressBookController{
    private AddressBookRepository repo;

    public AddressBookController(AddressBookRepository models) {
        repo = models;
    }

    @GetMapping("addressBook")
    public String addressBook(@RequestParam(name = "id") long id, Model model) {
        AddressBook a = repo.findById(id);
        model.addAttribute("addressBook", a);
        return "addressBook";
    }

    @ResponseBody
    @PostMapping(value = "/new", produces = "application/json")
    public AddressBook newAddressBook() {
        AddressBook a = new AddressBook();
        repo.save(a);
        return a;
    }

}