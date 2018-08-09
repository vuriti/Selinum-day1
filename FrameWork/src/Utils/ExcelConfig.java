package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	
	public ExcelConfig(String path) {
				
			try {
				
				File scr = new File(path);
				FileInputStream fis = new FileInputStream(scr);
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
				
	}
	
	public String getdata(int sheetno,int row, int column) {
		sh =wb.getSheetAt(sheetno);
		
		DataFormatter formatter = new DataFormatter();

		
		String data = formatter.formatCellValue(sh.getRow(row).getCell(column));
		
		return data;
		
	}
	
	public int getrow(int sheetindex) {
		
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		
		row = row+1;
		
		return row;
						
	}

}
