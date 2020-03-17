import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FilePartReader filePartReader = new FilePartReader();
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Test
    void getWordsOrderedAlphabetically() throws IOException {
        filePartReader.setup("file2.txt", 1,0);
        List<String> expected = Arrays.asList("!", "!1", "!b", "1", "1!", "123", "1b", "a", "a", "ab", "b", "b!", "b1", "b2", "bb", "c", "cd", "d", "g", "s", "z", "z");
        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void getWordsContainingSubstring() throws IOException {
        filePartReader.setup("file2.txt", 1,0);
        List<String> expected = Arrays.asList("b", "bb", "ab", "1b", "b1", "b2", "b!", "!b");
        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("b"));
    }

    @Test
    void getStringsWhichPalindromes() throws IOException {
        filePartReader.setup("file2.txt", 1,0);
        List<String> expected = Arrays.asList("b", "a", "c", "d", "g", "z", "a", "z", "s", "bb", "1", "!");
        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}