package com.crm.Vtiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	/**
	 * this is a generic method which is used to read the data present in the properities file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperities(String key) throws IOException {
		FileInputStream fis=new FileInputStream(ipathconstants.propertiesPath);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}
	/**
	 * this is a generic method which is used to read string data present in the excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelString(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ipathconstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	/**
	 * this is a generic method which is used to read numeric data present in the excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readDataFromExcelNumeric(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ipathconstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		 double data = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return data;
	} 
}
