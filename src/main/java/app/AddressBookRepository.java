package app;

import app.model.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "addressBook")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(long id);
}