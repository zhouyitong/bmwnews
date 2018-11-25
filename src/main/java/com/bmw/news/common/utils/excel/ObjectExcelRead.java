package com.bmw.news.common.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bmw.news.common.utils.PageData;


/**
 * 从EXCEL导入到数据库
 * 创建人：syaq Q313596790
 * 创建时间：2014年12月23日
 * @version
 */
public class ObjectExcelRead {

	/**
	 * @param filepath //文件路径
	 * @param filename //文件名
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();

		try {
			File target = new File(filepath, filename);
			FileInputStream fi = new FileInputStream(target);

			Workbook wb = null;
			try {
				wb = new XSSFWorkbook(fi);
			} catch (Exception ex) {
				wb = new HSSFWorkbook(fi);
			}

//			HSSFWorkbook wb = new HSSFWorkbook(fi);
//			HSSFSheet sheet = wb.getSheetAt(sheetnum); 					//sheet 从0开始
			Sheet sheetAt = wb.getSheetAt(sheetnum);
			int rowNum = sheetAt.getLastRowNum() + 1; 					//取得最后一行的行号

			for (int i = startrow; i < rowNum; i++) {					//行循环开始
				
				PageData varpd = new PageData();
//				HSSFRow row = sheetAt.getRow(i); 							//行
				Row row = sheetAt.getRow(i);
				int cellNum = row.getLastCellNum(); 					//每行的最后一个单元格位置

				for (int j = startcol; j < cellNum; j++) {				//列循环开始
					
//					HSSFCell cell = row.getCell(Short.parseShort(j + ""));
					Cell cell = row.getCell(Short.parseShort(j + ""));
					String value = null;
					if (null != cell) {
						switch (cell.getCellType()) {
							//数值型
							case Cell.CELL_TYPE_NUMERIC:
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									//如果是date类型则 ，获取该cell的date值
									Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
									value = format.format(date);
								}else {// 纯数字
									BigDecimal big=new BigDecimal(cell.getNumericCellValue());
									value = big.toString();
									//解决1234.0  去掉后面的.0
									if(null!=value&&!"".equals(value.trim())){
										String[] item = value.split("[.]");
										if(1<item.length&&"0".equals(item[1])){
											value=item[0];
										}
									}
								}
								break;
							//字符串类型
							case Cell.CELL_TYPE_STRING:
								value = cell.getStringCellValue().toString();
								break;
							// 公式类型
							case Cell.CELL_TYPE_FORMULA:
								//读公式计算值
								value = String.valueOf(cell.getNumericCellValue());
								if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
									value = cell.getStringCellValue().toString();
								}
								break;
							// 布尔类型
							case Cell.CELL_TYPE_BOOLEAN:
								value = " "+ cell.getBooleanCellValue();
								break;
							// 空值
							case Cell.CELL_TYPE_BLANK:
								value = "";
//								LogUtil.getLogger().error("excel出现空值");
								break;
							// 故障
							case Cell.CELL_TYPE_ERROR:
								value = "";
//								LogUtil.getLogger().error("excel出现故障");
								break;
							default:
								value = cell.getStringCellValue().toString();
						}
					} else {
						value = "";
					}
					
					varpd.put("var"+j, value);
					
				}
				varList.add(varpd);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return varList;
	}
}
