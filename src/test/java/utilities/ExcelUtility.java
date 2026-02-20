package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    public static Object[][] getTestData(String sheetName) throws Exception {
    	
    	
    	
    	//String path = ".\\testData\\data.xlsx";

        FileInputStream fis = new FileInputStream("src/test/resources/data.xlsx");
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        
        

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] =
                        sheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        return data;
    }
}
