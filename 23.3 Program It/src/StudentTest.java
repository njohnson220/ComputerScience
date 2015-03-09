import static org.junit.Assert.*;

public class StudentTest {

    @org.junit.Test
    public void testGetAverage() throws Exception {
        Student s = new Student();
        assertNotNull(s.getAverage());
    }
}