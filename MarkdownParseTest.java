import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class MarkdownParseTest {

    @Before
    public void init() {

    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void firstTest() {
        String markdown = "# Title\n\n[link1](https://something.com)\n[link2](some-thing.html)";
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");
        assertEquals(MarkdownParse.getLinks(markdown), expectedLinks);
    }

    @Test
    public void secondTest() {
        String markdown = "# Title\n\n[link1](https://something.com)\n[link2](some-thing.html)";
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");
        assertEquals(MarkdownParse.getLinks(markdown), expectedLinks);
    }
    
}