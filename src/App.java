import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        File data = new File("portfolio.txt");
        Driver mains = new Driver();
mains.protocol(1, null, 0);
        ArrayList<File> log = Startup(mains);
        Portfolio portfolio = new Portfolio(log);

    }

    private static ArrayList<File> Startup(Driver mains) throws IOException, InterruptedException {
        File f = new File("stocks/");
        ArrayList<File> log = new ArrayList<File>();
if (f.exists() && f.isDirectory()) {
    
    
   for (File stock : f.listFiles()) {
log.add(stock);
}
int numFile = log.size();
if (numFile > 0) {

} else {
    mains.protocol(2, null, 0);
    
}
}
else{
    f.mkdir();

    mains.protocol(2, null, 0);
}

        return log;
    }
}
