import java.io.File;
import java.util.ArrayList;

public class Portfolio {
int value;
int cash;
    public Portfolio(ArrayList<File> log) {
        if (log.size()>0) {
            for (File file : log) {
                value = read(file);
            }
        }
        
    }
    private int read(File file) {
        return 0;sd
    }
   
    
}
