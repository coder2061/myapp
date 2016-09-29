package com.web.myapp.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

/** 
 * 二维码工具
 * @author jiangyf   
 * @since 2016年8月12日 下午12:05:21 
 * @version V1.0   
 */
public class QRCodeUtil {
	//二维码存放路径
	public static final String PATH = "D:/temp/";
	//二维码宽度
	public static final int WIDTH = 200;
	//二维码长度
	public static final int HEIGHT = 200;

    /** 
    * 生成二维码
    * @param url 二维码中的链接信息
    * @throws IOException
    * @return ByteArrayOutputStream
    * @author jiangyf 
    * @since 2016年8月12日 下午2:42:54
    */
    public static ByteArrayOutputStream createQRCode(String url) throws IOException {
        //如果有中文，可使用withCharset("UTF-8")方法

        //设置二维码url链接，图片长、宽度，JPG类型
        return QRCode.from(url).withSize(WIDTH, HEIGHT).to(ImageType.JPG).stream();
    }
    
    /** 
    * 生成二维码
    * @param url
    * @param fileName
    * @param width
    * @param height
    * @throws IOException
    * @return void
    * @author jiangyf 
    * @since 2016年8月12日 下午5:06:13
    */
    public static void createQRCode(String url, int width, int height, 
    		String fileName, String filePath) throws IOException {
    	ByteArrayOutputStream qrOut = QRCode.from(url).withSize(width, height)
    			.to(ImageType.JPG).stream();
 	    OutputStream os = new FileOutputStream(new File(filePath, fileName));
 	    os.write(qrOut.toByteArray());
 	    os.flush();
 	    os.close();
	}
    
}
