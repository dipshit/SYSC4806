package mvc;

import mvc.models.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "buddyInfo")
public interface BuddyRepository extends CrudRepository<BuddyInfo, Long> {
    BuddyInfo findById(long id);
}