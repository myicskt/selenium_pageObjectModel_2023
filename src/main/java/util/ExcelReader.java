package util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	String filePath;

	public ExcelReader(String filePath) {
		this.filePath = filePath;
	}

	public String readeExcelcell(String sheetName, String columnName, int rowNum) {
		FileInputStream file = null;
		XSSFWorkbook worbook = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		String CellValue = null;
		int cellNum = 0;
		try {
			file = new FileInputStream(filePath);
			worbook = new XSSFWorkbook(file);
			sheet = worbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(columnName)) {
					cellNum = i;
				}
			}
			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(cellNum);

		} catch (Exception e) {
			e.printStackTrace();
		}

		DataFormatter df = new DataFormatter();
		CellValue = df.formatCellValue(cell);
		return CellValue;

	}
}
