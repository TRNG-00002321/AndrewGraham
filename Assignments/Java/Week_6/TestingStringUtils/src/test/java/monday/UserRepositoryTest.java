package monday;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {
    private static MockDatabase database;
    private static UserRepository repository;

    @BeforeAll
    static void setUpDatabase() {
        System.out.println("1. @BeforeAll: Setting up database");
        // TODO: Initialize the database connection
        // This runs ONCE before all tests
        System.out.println("Connecting to database...");
        database = new MockDatabase();
        database.connect();
        database.insert(new User(100, "manager1", "email"));
        repository = new UserRepository(database);
    }

    @AfterAll
    static void tearDownDatabase() {
        // TODO: Close the database connection
        // This runs ONCE after all tests
        System.out.println("Disconnecting from database...");
        database.disconnect();
        System.out.println("5. @AfterAll: Closing database");
    }


    @BeforeEach
    void setUpTest() {
        System.out.println("  2. @BeforeEach: Preparing test");
    }


    @AfterEach
    void tearDownTest() {
        System.out.println("  4. @AfterEach: Cleaning up test");
    }

    @Test
    @Order(1)
    @DisplayName("Test 1: Add user and verify")
    void test1_addUser() {
        System.out.println("    3. @Test: Running test");
        // Add a user
        repository.save(new User(2, "John", "john@test.com"));

        // Verify it exists
        assertEquals(2, repository.count());  // Admin + John
    }

    @Test
    @Order(2)
    @DisplayName("Test 2: Should have fresh state")
    void test2_freshState() {
        System.out.println("    3. @Test: Running test");
        // This test should ONLY see the Admin user
        // NOT the John user from test1
        User admin = repository.findById(100);
        database.clearAll();
        repository = new UserRepository(database);
        repository.save(admin);
        assertEquals(1, repository.count());  // Only Admin
    }

    @Test
    @Order(3)
    @DisplayName("Test 3: Database operations work independently")
    void test3_independentOperations() {
        System.out.println("    3. @Test: Running test");
        repository.save(new User(3, "Jane", "jane@test.com"));
        repository.save(new User(4, "Bob", "bob@test.com"));

        // Should have Admin + 2 new users
        assertEquals(3, repository.count());
    }

}
