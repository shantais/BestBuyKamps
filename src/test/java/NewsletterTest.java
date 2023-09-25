import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.*;

public class NewsletterTest {
    private static final String TEST_FILE = "test_subscribers.txt";

    @BeforeEach
    public void setUp() {
        createTestFile();
    }

    @AfterEach
    public void tearDown() {
        deleteTestFile();
    }

    @Test
    public void testEmailExistWhenEmailExists() {
        assertTrue(Newsletter.emailExist("new@example.com"));
    }

    @Test
    public void testEmailExistWhenEmailDoesNotExist() {
        assertFalse(Newsletter.emailExist("nonnew@example.com"));
    }

    @Test
    public void testAddEmail() {
        String newEmail = "new@example.com";
        Newsletter.addEmail(newEmail);
        assertTrue(Newsletter.emailExist(newEmail));
    }

    private void createTestFile() {
        try {
            Files.write(Paths.get(TEST_FILE), "new@example.com\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFile() {
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
