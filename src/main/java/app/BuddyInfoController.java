package app;

import app.model.AddressBook;
import app.model.BuddyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuddyInfoController {
    private AddressBookRepository bookrepo;
    private BuddyRepository buddyrepo;

    public BuddyInfoController(AddressBookRepository bookrepo, BuddyRepository buddyrepo) {
        this.bookrepo=bookrepo;
        this.buddyrepo=buddyrepo;
    }

    @ResponseBody
    @PostMapping(value = "/addBuddy", produces = "application/json")
    public BuddyInfo addBuddy(@RequestParam(name = "bookId") long bookId, @RequestParam(name = "name") String name, @RequestParam(name = "phone") String phone) {
        AddressBook a = bookrepo.findById(bookId);
        BuddyInfo b = new BuddyInfo();
        b.setName(name);
        b.setPhone(phone);
        a.addBuddy(b);
        buddyrepo.save(b);
        bookrepo.save(a);
        return b;
    }

    @ResponseBody
    @PostMapping(value = "/removeBuddy", produces = "application/json")
    public AddressBook removeBuddy(@RequestParam(name = "id") long id) {
        BuddyInfo b = buddyrepo.findById(id);
        AddressBook a = b.getAddressBook();
        a.removeBuddy(b);
        buddyrepo.delete(b);
        bookrepo.save(a);

        return a;
    }
}
