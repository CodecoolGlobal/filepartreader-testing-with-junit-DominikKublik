import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

public class FileWordAnalyzer {
    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }
    private FilePartReader reader;

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String lines = reader.readLines();
        String[] unsortedArray = lines.split("[ \n\t]");
        Arrays.sort(unsortedArray);
        return Arrays.asList(unsortedArray);
    };

    public List<String> getWordsContainingSubstring(String substring) throws IOException {
        String lines = reader.readLines();
        String[] splitWords = lines.split("[ \n\t]");
        List<String> words = new LinkedList<>();
        for (String s : splitWords) {
           if(s.contains(substring)){
               words.add(s);
           }
        }
        return words;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String lines = reader.readLines();
        String[] splitWords = lines.split("[ \n\t]");
        List<String> words = new LinkedList<>();
        for (String s : splitWords) {
            StringBuilder reverse = new StringBuilder();
            for (int i = s.length()-1; i >= 0; i--){
                reverse.append(s.charAt(i));
            }
            if(s.equals(reverse.toString())){
                words.add(s);
            }
        }
        return words;
    }
}
