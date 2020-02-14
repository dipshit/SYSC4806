package app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    private int id;

    @OneToMany(
            mappedBy = "addressBook",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<BuddyInfo> buddies;

    public int getId(){
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
        buddy.setAddressBook(this);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public boolean containsBuddy(BuddyInfo buddy) {
        return buddies.contains(buddy);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(ArrayList<BuddyInfo> b) {
        buddies = b;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof AddressBook) {
            AddressBook a = (AddressBook) o;
            return (a.getBuddies().equals(buddies) && a.getId() == id);
        }
        return false;
    }

    @Override
    public String toString() {
        String ret = "";
        for (BuddyInfo b : buddies) {
            ret += b.toString();
        }
        return ret;
    }
}