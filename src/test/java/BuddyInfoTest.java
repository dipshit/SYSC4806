import mvc.models.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {

    private BuddyInfo b;
    @Before
    public void setUp() {
        b = new BuddyInfo();
        b.setName("name");
        b.setAddress("house");
        b.setPhone("911");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getName() {
        assert(b.getName().equals("name"));
    }

    @Test
    public void getAddress() {
        assert(b.getAddress().equals("house"));
    }

    @Test
    public void getPhone() {
        assert(b.getPhone().equals("911"));
    }

    @Test
    public void setName() {
        b.setName("name2");
        assert(b.getName().equals("name2"));
    }

    @Test
    public void setAddress() {
        b.setAddress("home");
        assert(b.getAddress().equals("home"));
    }

    @Test
    public void setPhone() {
        b.setPhone("411");
        assert(b.getPhone().equals("411"));
    }

    /*
    @Test
    public void persistBuddyInfo() {
        b.setPhone("613-555-1234");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(b);
        tx.commit();


        Query q = em.createQuery("SELECT b FROM mvc.models.BuddyInfo b");
        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        assert(results.size() == 1);
        BuddyInfo retrieved = results.get(0);
        assert(retrieved.equals(b));
        em.close();
        emf.close();
    }

     */
}