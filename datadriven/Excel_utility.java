package excel_utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_utility {
	public static String getReaddata(String path, int rowno, int colm)

	{

		String value = "";
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheetno = wb.getSheetAt(0);
			value = sheetno.getRow(rowno).getCell(colm).getStringCellValue();
		}

		catch (Exception e)

		{
			System.out.println("issue in getreaddata" + e);
		}

		return value;
	}

}
