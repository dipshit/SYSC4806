package app;

import app.model.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController{
    private AddressBookRepository repo;

    public AddressBookController(AddressBookRepository models) {
        repo = models;
    }

    @GetMapping("addressBook")
    @ResponseBody
    public AddressBook addressBook(@RequestParam(name = "id") int id) {
        return repo.findById(id);
    }

    @GetMapping(value = "/new")
    public String newAddressBook(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        return "newAddressBook";
    }

    @ResponseBody
    @PostMapping(value = "/new", produces = "application/json")
    public AddressBook newAddressBook(@ModelAttribute AddressBook a) {
        System.out.println("addressBook id is " + a.getId());
        repo.save(a);
        return a;
    }

}