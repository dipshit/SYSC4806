package app;

import app.model.AddressBook;
import app.model.BuddyInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyInfoController {
    private AddressBookRepository bookrepo;
    private BuddyRepository buddyrepo;

    public BuddyInfoController(AddressBookRepository bookrepo, BuddyRepository buddyrepo) {
        this.bookrepo=bookrepo;
        this.buddyrepo=buddyrepo;
    }

    @GetMapping(value = "/addBuddy")
    public String addBuddyForm(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "addBuddy";
    }

    @ResponseBody
    @PostMapping(value = "/addBuddy", produces = "application/json")
    public BuddyInfo addBuddy(@ModelAttribute BuddyInfo buddy) {
        System.out.println("buddy's bookId: " + buddy.getBookId());
        AddressBook a = bookrepo.findById(buddy.getBookId());
        a.addBuddy(buddy);
        buddyrepo.save(buddy);
        bookrepo.save(a);
        return buddy;
    }

    @GetMapping(value = "/removeBuddy")
    public String removeBuddyForm(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "removeBuddy";
    }

    @ResponseBody
    @PostMapping(value = "/removeBuddy", produces = "application/json")
    public AddressBook removeBuddy(@ModelAttribute BuddyInfo buddy) {
        BuddyInfo b = buddyrepo.findById(buddy.getId());
        AddressBook a = b.getAddressBook();
        a.removeBuddy(b);
        buddyrepo.delete(b);
        bookrepo.save(a);

        return a;
    }
}
