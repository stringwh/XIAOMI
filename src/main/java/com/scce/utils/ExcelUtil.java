package com.scce.utils;


import com.scce.pojo.Customer;
import com.scce.pojo.Goods;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public class ExcelUtil {
	/**
	 * 封装Excel的集合
	 * @param list
	 * @param wb
	 * @param headers
	 * @throws Exception
	 */
	public static void fillExcelData(List list, Workbook wb, String[] headers)throws Exception{
		int rowIndex=0;
		Sheet sheet=wb.createSheet();
		Row row=sheet.createRow(rowIndex++);
		for(int i=0;i<headers.length;i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			//Room room= (Room) list.get(i);
			Customer customer= (Customer) list.get(i);
			row=sheet.createRow(rowIndex++);
				row.createCell(0).setCellValue(customer.getCustomerName());
				row.createCell(1).setCellValue(customer.getCustomerPWD());
			//设置日期格式
				/*cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy/mm/dd hh:mm:ss"));
				row.createCell(2).setCellValue(customer.getCustomerBirthday());
				cell.setCellValue(new Date());  //第二个单元格*/
				row.createCell(3).setCellValue(customer.getCustomerPhone());
				row.createCell(4).setCellValue(customer.getCustomerRegDate());

		}
	}

	/**
	 * 读取模板，将数据一个一个的放在模板中
	 * @param list
	 * @param templateFileName
	 * @return
	 * @throws Exception
	 */
	public static Workbook fillExcelDataWithTemplate(List list, String templateFileName)throws Exception{
		InputStream inp= ExcelUtil.class.getResourceAsStream("/com/java/template/"+templateFileName);
		POIFSFileSystem fs=new POIFSFileSystem(inp);
		Workbook wb=new HSSFWorkbook(fs);
		Sheet sheet=wb.getSheetAt(0);
		// 获取列数
		int cellNums=sheet.getRow(0).getLastCellNum();
		int rowIndex=1;
		/*while(rs.next()){
			Row row=sheet.createRow(rowIndex++);
			for(int i=0;i<cellNums;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}*/
		for (int i = 0; i < list.size(); i++) {
			Row row=sheet.createRow(rowIndex++);
			for(int j=0;j<cellNums;j++){
				row.createCell(i).setCellValue(list.get(j).toString());
			}

		}
		return wb;
	}

	/**
	 *
	 * @param hssfCell
	 * @return
	 */
	public static String formatCell(HSSFCell hssfCell){
		if(hssfCell==null){
			return "";
		}else{
			if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
				return String.valueOf(hssfCell.getBooleanCellValue());
			}else if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
				return String.valueOf(hssfCell.getNumericCellValue());
			}else{
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}

}
