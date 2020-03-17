import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilePartReaderTest {

    FilePartReader filePartReader = new FilePartReader();

    @Test
    void setup() {
        filePartReader.setup("file.txt", 1, 1);
        assertEquals(0, 0);
    }

    @Test
    void read() throws IOException {
        filePartReader.setup("file.txt", 1, 1);
        assertEquals("Test file123 this is a test file\n" +
                "a\ta\ta\n" +
                "file\n" +
                "test\n" +
                "this\n" +
                "is\n" +
                "THIS\n" +
                "IS\n" +
                "ATESTFILE\n" +
                "THISIS ATESTFILE\n" +
                "THISISATESTFILE\n", filePartReader.read());
    }

    @Test
    void readLinesOneLine() throws IOException {
        filePartReader.setup("file.txt", 1, 1);
        assertEquals("Test file123 this is a test file\n", filePartReader.readLines());

    }

    @Test
    void readDifferentLines() throws IOException {
        filePartReader.setup("file.txt", 2, 4);
        assertEquals("a\ta\ta\nfile\ntest\n", filePartReader.readLines());
    }

    @Test
    void readLinesFromLineToEnd() throws IOException {
        filePartReader.setup("file.txt", 2, 0);
        assertEquals("a\ta\ta\n" +
                "file\n" +
                "test\n" +
                "this\n" +
                "is\n" +
                "THIS\n" +
                "IS\n" +
                "ATESTFILE\n" +
                "THISIS ATESTFILE\n" +
                "THISISATESTFILE\n", filePartReader.readLines());
    }


}