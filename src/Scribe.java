import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;   
public class Scribe {
    private File file;
    private Workbook wb;
    private InputStream iput;
    private OutputStream oput;
    public Scribe(File fi) {
        file = fi;
 }
public void create() throws IOException {
    Workbook wbt = new HSSFWorkbook();   
    Sheet sheet = wbt.createSheet("Stock");
    Row header = sheet.createRow(0);
    CellStyle headerStyle = wbt.createCellStyle();
    headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    System.out.println(sheet.getPhysicalNumberOfRows()+"Is Created");
    HSSFFont font = ((HSSFWorkbook) wbt).createFont();
    font.setFontName("Arial");
    font.setFontHeightInPoints((short) 16);
    font.setBold(true);
    headerStyle.setFont(font);
    
    Cell headerCell = header.createCell(0);
    headerCell.setCellValue("Actions");
    headerCell.setCellStyle(headerStyle);
    
    headerCell = header.createCell(1);
    headerCell.setCellValue("Ticker");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(2);
    headerCell.setCellValue("Shares");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(3);
    headerCell.setCellValue("Date");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(4);
    headerCell.setCellValue("Time");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(5);
    headerCell.setCellValue("Price");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(6);
    headerCell.setCellValue("Commission");
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(7);
    headerCell.setCellValue("NewPrice");
    headerCell.setCellStyle(headerStyle);

    
    OutputStream fileOut = new FileOutputStream(file);   
    oput = fileOut;
    wb = wbt;
    wb.write(fileOut);   
    fileOut.close();
    
}
public void settarget(File file) throws FileNotFoundException {
    HSSFWorkbook wbt = new HSSFWorkbook();   
    InputStream filein = new FileInputStream(file);
    OutputStream fileOut = new FileOutputStream(file);
    iput = filein;   
    oput = fileOut;
    wb = wbt;
}
 public void writeTo(Object[] data) throws IOException, InterruptedException {
    FileInputStream input = new FileInputStream(file);
    Workbook wbt = new HSSFWorkbook(input);
    Sheet firstSheet = wbt.getSheet("Stock");
    System.out.println(firstSheet.getSheetName());
    System.out.println(wbt.getNumberOfSheets());
    Iterator<Row> rowIterator = firstSheet.iterator();
    firstSheet.getLastRowNum();
    Row row= null;
    int o=0;
    for (int i = 0; i <= firstSheet.getPhysicalNumberOfRows(); i++) {
        System.out.println(i);
        
        System.out.println("good");
        o=i;
    }

    
    Row header = firstSheet.createRow(o);
    System.out.println(firstSheet.getPhysicalNumberOfRows());

System.out.println(firstSheet.getLastRowNum());
    CellStyle headerStyle = wbt.createCellStyle();
    headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    HSSFFont font = ((HSSFWorkbook) wbt).createFont();
    font.setFontName("Arial");
    font.setFontHeightInPoints((short) 16);
    font.setBold(true);
    headerStyle.setFont(font);
    
    Cell headerCell = header.createCell(0);
    headerCell.setCellValue(String.valueOf(data[0]));
    headerCell.setCellStyle(headerStyle);
    
    headerCell = header.createCell(1);
    String change3 = (String) data[1];

    headerCell.setCellValue((change3));
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(2);
    headerCell.setCellValue(String.valueOf(data[2]));
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(3);
    headerCell.setCellValue(String.valueOf(data[3]));
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(4);
    String cash = (String) data[4];
    headerCell.setCellValue(cash);
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(5);
    double change = Double.valueOf((((String)data[5]).replace("$", "")).replaceAll(",", "")); 

    headerCell.setCellValue(change);
    headerCell.setCellStyle(headerStyle);

    headerCell = header.createCell(6);
    int change2 = (int) data[6];

    headerCell.setCellValue(change2);
    headerCell.setCellStyle(headerStyle);
FileOutputStream fileOut = new FileOutputStream(file);

    wbt.write(fileOut);
    fileOut.close();
    wbt.close();
    
 }
}
