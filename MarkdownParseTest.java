import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public void firstTest() throws IOException {
        Path fileName = Path.of("test-file.md");
        String markdown = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");
        ArrayList<String> output = MarkdownParse.getLinks(markdown);
        assertEquals(expectedLinks, output);
    }

    @Test
    public void secondTest() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String markdown = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://referencelink.php");
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");
        expectedLinks.add("dog.png");
        ArrayList<String> output = MarkdownParse.getLinks(markdown);
        assertEquals(expectedLinks, output);
    }
    
    @Test
    public void thirdTest() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String markdown = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("pooper.com");
        ArrayList<String> output = MarkdownParse.getLinks(markdown);
        assertEquals(expectedLinks, output);
    }
    
    @Test
    public void fourthTest() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String markdown = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        ArrayList<String> output = MarkdownParse.getLinks(markdown);
        assertEquals(expectedLinks, output);
    }

}