public class FilePartReader {
    public FilePartReader() {
    }

    public void setup(String filePath, int fromLine, int toLine){
        if (toLine < fromLine || fromLine<1){
            throw new IllegalArgumentException("Wrong method parameters");
        }
    }

    public String read(){
        return null;
    }

    public String readLines(){
        return null;
    }
}
