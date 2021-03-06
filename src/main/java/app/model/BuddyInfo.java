package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String address = "";
    private String name = "", phone = "";
    private int bookId;

    @ManyToOne
    @JoinColumn(name = "ADDRESSBOOK_ID")
    @JsonBackReference
    private AddressBook addressBook;

    public BuddyInfo() {
    }

    public BuddyInfo(AddressBook ab, String n, String a, String p) {
        addressBook = ab;
        name = n;
        address = a;
        phone = p;
        id = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAddress(String a) {
        address = a;
    }

    public void setPhone(String p) {
        phone = p;
    }

    @Override
    public String toString() {
        return name + " " + address + " " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof BuddyInfo) {
            BuddyInfo b = (BuddyInfo) o;
            return (b.getPhone().equals(phone) && b.getAddress().equals(address) && b.getName().equals(name));
        }
        return false;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}