import mvc.models.AddressBook;
import mvc.models.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

    private AddressBook a;
    @Before
    public void setUp() {
        a = new AddressBook();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addBuddy() {
        BuddyInfo b = new BuddyInfo();
        a.addBuddy(b);
        assert(a.containsBuddy(b));
    }

    @Test
    public void removeBuddy() {
        BuddyInfo b = new BuddyInfo();
        a.addBuddy(b);
        a.removeBuddy(b);
        assert(!a.containsBuddy(b));
    }

    /*
    @Test
    public void persistAddressBook() {
        a = new AddressBook();
        BuddyInfo b = new BuddyInfo(a, "snoop", "la", "420");
        a.addBuddy(b);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        tx.commit();


        Query q = em.createQuery("SELECT a FROM mvc.models.AddressBook a");
        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();
        assert(results.size()==1);
        em.close();
        emf.close();
    }
     */

}