import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Portfolio {
int value;
int cash;
    public Portfolio(ArrayList<File> log) {
        if (log.size()>0) {
            for (File file : log) {
                try {
                    value = read(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
    private int read(File file) throws IOException {
        // Our example data
List<List<String>> rows = Arrays.asList(
    Arrays.asList("Jean", "author", "Java"),
    Arrays.asList("David", "editor", "Python"),
    Arrays.asList("Scott", "editor", "Node.js")
);

FileWriter csvWriter = new FileWriter("new.csv");
csvWriter.append("Name");
csvWriter.append(",");
csvWriter.append("Role");
csvWriter.append(",");
csvWriter.append("Topic");
csvWriter.append("\n");

for (List<String> rowData : rows) {
    csvWriter.append(String.join(",", rowData));
    csvWriter.append("\n");
}

csvWriter.flush();
csvWriter.close();
        return 0;
    }
    
}
