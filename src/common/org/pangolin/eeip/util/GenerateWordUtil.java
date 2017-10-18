package org.pangolin.eeip.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.pangolin.eeip.poi.CustomXWPFDocument;

/**
 * Poi manipulate the word template to populate the data tool class
 * @author Xiaolin Yin
 *
 */
public class GenerateWordUtil {

	/**
	 * Directly replace the word template content
	 * @param templatePath 模板路径
	 * @param outPath 生成文件保存路径
	 * @param param 模板数据源
	 * @throws Exception 异常抛出
	 */
	public static boolean replaceWord(String templatePath, String outPath, Map<String, Object> param) throws Exception {
		    File saveDirectory = new File(templatePath); 
			 
		    InputStream is = new FileInputStream(templatePath);
			HWPFDocument doc = new HWPFDocument(is);
			Range range = doc.getRange();
			for (Map.Entry<String, Object> entry : param.entrySet()) {
 				range.replaceText(entry.getKey(), entry.getValue().toString());
			}
			OutputStream os = new FileOutputStream(outPath);
			doc.write(os);
			os.close();
			is.close();
			return true;
	}

	/**
	 * Increase the word table line 
	 * @param templatePath 模板路径
	 * @param outPath 生成文件保存路径
	 * @param tableSn 需要修改的表格数
	 * @param tableRow 增加行 依据 （标准行行数）
	 * @param paramList 模板数据源
	 * @throws Exception 抛出异常
	 */
	public static Boolean writeExcelInWord(String templatePath, String outPath, int tableSn, int tableRow,
			List<Map<Integer, Object>> paramList) throws Exception {
		try {
			// 读取word源文件
			FileInputStream fileInputStream = new FileInputStream(templatePath);
	 		CustomXWPFDocument document = new CustomXWPFDocument(fileInputStream);
			// 获取所有表格
			List<XWPFTable> tables = document.getTables();
			// 这里简单取第tableSn个表格
			XWPFTable table = tables.get(tableSn);
	 		if (paramList.size() > 0) {
				for (int i = 0; i < paramList.size(); i++) {
					table.createRow(tableRow);
					XWPFTableRow row = table.getRow(tableRow + i + 1);
					for (Map.Entry<Integer, Object> entry : paramList.get(i).entrySet()) {
						row.getCell(entry.getKey()).setText(entry.getValue().toString());
					}
				}
			}
			fileInputStream.close();
			// 写到目标文件
			OutputStream output = new FileOutputStream(outPath);
			document.write(output);
			output.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * Add pictures and replace template data demo
	 */
	public void createImageData() {
		try {
			// 读取word源文件
			FileInputStream fileInputStream = new FileInputStream("d:\\appraisal_pic_record.docx");
			// POIFSFileSystem pfs = new POIFSFileSystem(fileInputStream);
			CustomXWPFDocument document = new CustomXWPFDocument(fileInputStream);
			// 获取所有表格
			List<XWPFTable> tables = document.getTables();
			// 这里简单取第一个表格
			XWPFTable table = tables.get(0);
			// 获取表头，这里没什么用，只是打印验证下
			XWPFTableRow header = table.getRow(0);
			// 表格的插入行有两种方式，这里使用addNewRowBetween，因为这样会保留表格的样式，就像我们在word文档的表格中插入行一样。注意这里不要使用insertNewTableRow方法插入新行，这样插入的新行没有样式，很难看
			XWPFTableRow row0 = table.getRow(0);
			row0.getCell(1).setText("编号");
			XWPFTableRow row1 = table.getRow(1);
			row1.getCell(1).setText("备注");
			XWPFTableRow row2 = table.getRow(2);

			// First column
			XWPFTableCell cell = row2.getCell(0);
			XWPFParagraph paragraph = cell.addParagraph();
			XWPFRun run = paragraph.createRun();
			// InputStream pictureData, int pictureType, String filename, int
			// width, int height

			String id = document.addPictureData(new FileInputStream(new File("D:\\baidu.jpg")),
					Document.PICTURE_TYPE_JPEG);
			document.createPicture(run, id, document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 300, 300);
			run.addBreak();
			run.addBreak();
			String id2 = document.addPictureData(new FileInputStream(new File("D:\\qq.png")),
					Document.PICTURE_TYPE_PNG);
			document.createPicture(run, id2, document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 300, 300);
			run.addBreak();
			run.addBreak();
			// 写到目标文件
			OutputStream output = new FileOutputStream("d:\\xxx_new.docx");
			document.write(output);
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 关闭输入流
	 * 
	 * @param is
	 */
	private void closeStream(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭输出流
	 * 
	 * @param os
	 */
	private void closeStream(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Increase the word table line 
	 * @param templatePath 模板路径
	 * @param outPath 生成文件保存路径
	 * @param tableSn 需要修改的表格数
	 * @param tableRow 增加行 依据 （标准行行数）
	 * @param paramList 模板数据源
	 * @throws Exception 抛出异常
	 */
	public static Boolean replaceWordAndWriteExcelInWord(String templatePath, String outPath, int tableSn, int tableRow,
			List<Map<Integer, Object>> paramList,List<String> list) throws Exception {
		try {
			
			// 读取word源文件
			FileInputStream fileInputStream = new FileInputStream(templatePath);
	 		CustomXWPFDocument document = new CustomXWPFDocument(fileInputStream);
	 		// 获取所有表格
	 		List<XWPFTable> tables = document.getTables();
	 		// 这里简单取第一个表格
	 		XWPFTable table = tables.get(0);
	 		// 获取表头，这里没什么用，只是打印验证下
//	 		XWPFTableRow header = table.getRow(0);
	 		// 表格的插入行有两种方式，这里使用addNewRowBetween，因为这样会保留表格的样式，就像我们在word文档的表格中插入行一样。注意这里不要使用insertNewTableRow方法插入新行，这样插入的新行没有样式，很难看
	 		XWPFTableRow row0 = table.getRow(0);
	 		row0.getCell(1).setText(list.get(0));
	 		XWPFTableRow row1 = table.getRow(1);
	 		row1.getCell(1).setText(list.get(1));
//			// 获取所有表格
//			List<XWPFTable> tables = document.getTables();
//			// 这里简单取第tableSn个表格
			table = tables.get(tableSn);
	 		if (paramList.size() > 0) {
				for (int i = 0; i < paramList.size(); i++) {
					table.createRow(tableRow);
					XWPFTableRow row = table.getRow(tableRow + i + 1);
					for (Map.Entry<Integer, Object> entry : paramList.get(i).entrySet()) {
						row.getCell(entry.getKey()).setText(entry.getValue().toString());
					}
				}
			}
			fileInputStream.close();
			// 写到目标文件
			OutputStream output = new FileOutputStream(outPath);
			document.write(output);
			output.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	/** 
     * 根据图片类型，取得对应的图片类型代码 
     * @param picType 
     * @return int 
     */  
    public static int getPictureType(String picType){  
        int res = CustomXWPFDocument.PICTURE_TYPE_PICT;  
        if(picType != null){  
            if(picType.equalsIgnoreCase("png")){  
                res = CustomXWPFDocument.PICTURE_TYPE_PNG;  
            }else if(picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")){  
                res = CustomXWPFDocument.PICTURE_TYPE_JPEG;  
            }else if(picType.equalsIgnoreCase("bmp") ){  
                res = CustomXWPFDocument.PICTURE_TYPE_BMP;  
            }   
        }  
        return res;  
    }  
	
	public static Boolean replaceAllWordAndWriteExcelInWord(String templatePath, String outPath, int tableSn, int tableRow,
			List<Map<Integer, Object>> paramList,Map<String,String> param) throws Exception {
		try {
			String keyValue = "";
			XWPFParagraph newPara = null;
			XWPFRun run = null;
			FileInputStream fileInputStream = new FileInputStream(templatePath);
	 		CustomXWPFDocument document = new CustomXWPFDocument(fileInputStream);
	 		List<XWPFTable> tables = document.getTables();
	 		for (XWPFTable xwpfTable : tables) {
	 			List<XWPFTableRow> rows = xwpfTable.getRows();
	 			for (XWPFTableRow xwpfTableRow : rows) {
	 				List<XWPFTableCell> tableCells = xwpfTableRow.getTableCells();
	 				for (XWPFTableCell xwpfTableCell : tableCells) {
						if (xwpfTableCell.getText().contains("$")) { // 需要进行替换
							keyValue = param.get(xwpfTableCell.getText().trim());
							//System.out.println("替换前的值: "+xwpfTableCell.getText()+"  将要替换成的值: "+keyValue);
							xwpfTableCell.removeParagraph(0); // 删除掉原有内容
							String[] valueSplit = null;
							if(keyValue != null){
								valueSplit = keyValue.split("@<br>@");
								for (int j = 0; j < valueSplit.length; j++) {
									newPara = new XWPFParagraph(xwpfTableCell.getCTTc()
											.addNewP(), xwpfTableCell);// 新建段落
									run = newPara.createRun();
									run.setText(valueSplit[j]);
								}
							}
						}
//						System.out.println("替换之后: " + xwpfTableCell.getText());
					}
				}
			}
	 		
	 		XWPFTable table = tables.get(tableSn);
	 		if (paramList.size() > 0) {
				for (int i = 0; i < paramList.size(); i++) {
					table.createRow(tableRow);
					XWPFTableRow row = table.getRow(tableRow + i + 1);
					for (Map.Entry<Integer, Object> entry : paramList.get(i).entrySet()) {
						row.getCell(entry.getKey()).setText(entry.getValue().toString());
					}
				}
			}
			fileInputStream.close();
			// 写到目标文件
			OutputStream output = new FileOutputStream(outPath);
			document.write(output);
			output.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
