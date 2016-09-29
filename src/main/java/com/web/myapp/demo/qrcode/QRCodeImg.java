package com.web.myapp.demo.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;
 
public class QRCodeImg implements QRCodeImage  {
	BufferedImage bufImg;  
      
    public QRCodeImg(BufferedImage bufImg) {  
        this.bufImg = bufImg;  
    }  
       
    @Override 
    public int getHeight() {  
        return bufImg.getHeight();  
    }  
   
    @Override 
    public int getPixel(int x, int y) {  
        return bufImg.getRGB(x, y);  
    }  
   
    @Override 
    public int getWidth() {  
        return bufImg.getWidth();  
    }  
}