import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.activation.MailcapCommandMap;

public class App {
    public static void main(String[] args) throws Exception {
        File data = new File("portfolio.txt");
        ArrayList<File> log = Startup();
        Portfolio portfolio = new Portfolio(log);
Driver mains = new Driver();
mains.protocol(1, null, 0);
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
    Driver mains = new Driver();
    mains.protocol(1, null, 0);
    mains.protocol(2, null, 0);
}

        return log;
    }
}
