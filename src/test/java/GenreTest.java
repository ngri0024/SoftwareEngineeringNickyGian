import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nicky on 4/16/2016.
 */
public class GenreTest {
    private Genre fiction;
    private Genre romance;

    @Before
    public void setUp() throws Exception {
        fiction = new Genre("Fiction", "This is test1");
        romance = new Genre("Romance", "This is love test");

    }

    @After
    public void tearDown() throws Exception {
        fiction = null;
    }

    @Test
    public void setNameTest() throws Exception {
        assertEquals("Genre name could not be empty", false, fiction.setName(""));
    }

    @Test
    public void setDescriptionTest() throws Exception {
        assertEquals("Genre name changed", false, fiction.setDescription(""));
    }

    @Test
    public void compareTestP() throws Exception {
        assertEquals("Genres are the same instance (false-negative)", true, fiction.compare(fiction));

    }

    @Test
    public void compareTestN() throws Exception {
    assertEquals("The comparing of different genres didn't work", false, fiction.compare(romance));

    }
}