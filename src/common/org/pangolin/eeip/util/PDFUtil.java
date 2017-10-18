package org.pangolin.eeip.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

/**
 * PDF工具类
 * @author Oscar Mok
 * */
public class PDFUtil {
	
	/**
	 * 根据PDF文件生成图片
	 * @author Oscar Mok
	 * @param path PDF文件物理路径
	 * @param exportDirPath 输出图片根目录
	 * @return 图片路径集合
	 * */
	public static String[] generateImages(String pdfFilePath, String exportDirPath) {
		String[] images = {  };
		try {
			if ( pdfFilePath != null && !pdfFilePath.trim().equals("") 
					&& exportDirPath != null && !exportDirPath.trim().equals("") ) {
				File directory = new File(exportDirPath);
				if ( !directory.exists() ) directory.mkdirs();
				
				File pdfFile = new File(pdfFilePath);
				if ( pdfFile.canRead() ) {
					Document document = new Document();
					document.setFile(pdfFilePath);
			 
			        // save page caputres to file.
			        float scale = 2f;
			        float rotation = 0f;
			 
			        // Paint each pages content to an image and write the image to file
			        System.out.println("Capturing");
			        images = new String[document.getNumberOfPages()];
			        for ( int i = 0; i < document.getNumberOfPages(); i++ ) {
			            BufferedImage image = (BufferedImage)
			            document.getPageImage(i, GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX, rotation, scale);
			            RenderedImage rendImage = image;
			            // capture the page image to file
			            try {
			            	String fileName = exportDirPath + "/pdf-img-capture-" + i + ".jpg";
			                File file = new File(fileName);
			                ImageIO.write(rendImage, "jpg", file);
			                images[i] = new String(fileName);
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            }
			            image.flush();
			        }
			        // clean up resources
			        document.dispose();
			        System.out.println("Capturing was completed.");
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return images;
	}
}