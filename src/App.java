import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        File data = new File("portfolio.txt");
        ArrayList<File> log = Startup();
        Portfolio portfolio = new Portfolio(log);
Driver mains = new Driver(1);
    }

    private static ArrayList<File> Startup() {
        File f = new File("stocks/");
        ArrayList<File> log = new ArrayList<File>();
if (f.exists() && f.isDirectory()) {
   for (File stock : f.listFiles()) {
log.add(stock);
}
}
else{
    f.mkdir();
}

        return null;
    }
}
