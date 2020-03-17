import java.io.*;

public class FilePartReader {
    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 1;
        this.toLine = 1;
    }
    
    private String filePath;
    private int fromLine;
    private int toLine;
    
    
    public void setup(String filePath, int fromLine, int toLine){
        if (toLine < fromLine || fromLine<1){
            if (toLine != 0){
                throw new IllegalArgumentException("Wrong method parameters");
            }
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            text.append(line).append("\n");
        }
        return text.toString();
    }

    public String readLines() throws IOException {
        String text = read();
        String[] splitText = text.split("\n");
        StringBuilder textToReturn = new StringBuilder();
        if (toLine == 0){
            toLine = splitText.length;
        }
        for (int i = fromLine; i <= toLine; i++) {
            textToReturn.append(splitText[i-1]);
            textToReturn.append("\n");
        }
        return textToReturn.toString();
    }
}
