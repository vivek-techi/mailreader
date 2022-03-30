package ExcelUtilities;

import common.Constants;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;


public class ExcelUtilities {

    public static void writetocsvfile(String data, int row, int cell) throws IOException {
        File file = new File(Constants.XLS_FILEPATH);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheet("Sheet1");

        HSSFRow row1;

        if(sheet.getRow(row)==null) {
            row1 = sheet.createRow(row);
        }else {
            row1= sheet.getRow(row);
        }

        row1.createCell(cell).setCellValue(data);
        FileOutputStream outputStream = new FileOutputStream(Constants.XLS_FILEPATH);
        wb.write(outputStream);
        wb.close();

        }
    }
