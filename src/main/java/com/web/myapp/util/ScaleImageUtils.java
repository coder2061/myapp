package com.web.myapp.util;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 功能描述: 图像处理工具
 * 作者: LDL
 * 创建时间: 2014/7/25 10:40
 */
public class ScaleImageUtils {

    private static final float DEFAULT_SCALE_QUALITY = 1f;
    private static final String DEFAULT_IMAGE_FORMAT = ".jpg"; // 图像文件的格式
    private static final String DEFAULT_FILE_PATH = "C:/temp-";

    /**
     * 设置图片压缩质量枚举类；
     * Some guidelines: 
     * 0.75 high quality、
     * 0.5  medium quality、
     * 0.25 low quality
     */
    public enum ImageQuality {
        max(1.0f), high(0.75f), medium(0.5f), low(0.25f);

        private Float quality;

        public Float getQuality() {
            return this.quality;
        }

        ImageQuality(Float quality) {
            this.quality = quality;
        }
    }

    private static Image image;

    /**
     * 通过目标对象的大小和标准（指定）大小计算出图片缩小的比例
     *
     * @param targetWidth    目标的宽度
     * @param targetHeight   目标的高度
     * @param standardWidth  标准（指定）宽度
     * @param standardHeight 标准（指定）高度
     * @return 最小的合适比例
     */
    public static double getScaling(double targetWidth, double targetHeight, 
    		double standardWidth, double standardHeight) {
        double widthScaling = 0d;
        double heightScaling = 0d;
        if (targetWidth > standardWidth) {
            widthScaling = standardWidth / (targetWidth * 1.00d);
        } else {
            widthScaling = 1d;
        }
        if (targetHeight > standardHeight) {
            heightScaling = standardHeight / (targetHeight * 1.00d);
        } else {
            heightScaling = 1d;
        }
        return Math.min(widthScaling, heightScaling);
    }

    /**
     * 将Image的宽度、高度缩放到指定width、height，并保存在savePath目录
     *
     * @param width       缩放的宽度
     * @param height      缩放的高度
     * @param savePath    保存目录
     * @param targetImage 即将缩放的目标图片
     * @return 图片保存路径、名称
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(int width, int height, String savePath, 
			Image targetImage) throws ImageFormatException, IOException {
        width = Math.max(width, 1);
        height = Math.max(height, 1);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(targetImage, 0, 0, width, height, null);

        if (savePath == null || "".equals(savePath)) {
            savePath = DEFAULT_FILE_PATH + System.currentTimeMillis() + DEFAULT_IMAGE_FORMAT;
        }

        FileOutputStream fos = new FileOutputStream(new File(savePath));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
        encoder.encode(image);

        image.flush();
        fos.flush();
        fos.close();

        return savePath;
    }

    /**
     * 可以设置图片缩放质量，并且可以根据指定的宽高缩放图片
     *
     * @param width       缩放的宽度
     * @param height      缩放的高度
     * @param quality     图片压缩质量，最大值是1； 使用枚举值：{@link ImageQuality}
     *                    Some guidelines: 0.75 high quality、0.5  medium quality、0.25 low quality
     * @param savePath    保存目录
     * @param targetImage 即将缩放的目标图片
     * @return 图片保存路径、名称
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(int width, int height, Float quality, String savePath, 
			Image targetImage) throws ImageFormatException, IOException {
        width = Math.max(width, 1);
        height = Math.max(height, 1);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(targetImage, 0, 0, width, height, null);

        if (savePath == null || "".equals(savePath)) {
            savePath = DEFAULT_FILE_PATH + System.currentTimeMillis() + DEFAULT_IMAGE_FORMAT;
        }

        FileOutputStream fos = new FileOutputStream(new File(savePath));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);

        JPEGEncodeParam encodeParam = JPEGCodec.getDefaultJPEGEncodeParam(image);
        if (quality == null || quality <= 0) {
            quality = DEFAULT_SCALE_QUALITY;
        }
        /** 设置图片压缩质量 */
        encodeParam.setQuality(quality, true);
        encoder.encode(image, encodeParam);

        image.flush();
        fos.flush();
        fos.close();

        return savePath;
    }

    /**
     * 通过指定大小和图片的大小，计算出图片缩小的合适大小
     *
     * @param width  指定的宽度
     * @param height 指定的高度
     * @param image  图片文件
     * @return 返回宽度、高度的int数组
     */
    public static int[] getSize(int width, int height, Image image) {
        int targetWidth = image.getWidth(null);
        int targetHeight = image.getHeight(null);
        double scaling = getScaling(targetWidth, targetHeight, width, height);
        long standardWidth = Math.round(targetWidth * scaling);
        long standardHeight = Math.round(targetHeight * scaling);
        return new int[]{Integer.parseInt(Long.toString(standardWidth)), 
        		Integer.parseInt(String.valueOf(standardHeight))};
    }

    /**
     * 通过指定的比例和图片对象，返回一个放大或缩小的宽度、高度
     *
     * @param scale 缩放比例
     * @param image 图片对象
     * @return 返回宽度、高度
     */
    public static int[] getSize(float scale, Image image) {
        int targetWidth = image.getWidth(null);
        int targetHeight = image.getHeight(null);
        long standardWidth = Math.round(targetWidth * scale);
        long standardHeight = Math.round(targetHeight * scale);
        return new int[]{Integer.parseInt(Long.toString(standardWidth)), 
        		Integer.parseInt(String.valueOf(standardHeight))};
    }

    public static int[] getSize(int width, Image image) {
        int targetWidth = image.getWidth(null);
        int targetHeight = image.getHeight(null);
        long height = Math.round((targetHeight * width) / (targetWidth * 1.00f));
        return new int[]{width, Integer.parseInt(String.valueOf(height))};
    }

    public static int[] getSizeByHeight(int height, Image image) {
        int targetWidth = image.getWidth(null);
        int targetHeight = image.getHeight(null);
        long width = Math.round((targetWidth * height) / (targetHeight * 1.00f));
        return new int[]{Integer.parseInt(String.valueOf(width)), height};
    }

    /**
     * 将指定的targetFile图片文件的宽度、高度大于指定width、height的图片缩小，并保存在savePath目录
     *
     * @param width       缩小的宽度
     * @param height      缩小的高度
     * @param savePath    保存目录
     * @param targetFile 改变的目标图片
     * @return 图片保存路径、名称
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(int width, int height, String savePath, 
			File targetFile) throws ImageFormatException, IOException {
        image = ImageIO.read(targetFile);
        int[] size = getSize(width, height, image);
        return resize(size[0], size[1], savePath, image);
    }

	public static String resize(int width, int height, String savePath, 
			InputStream inputStream) throws ImageFormatException, IOException {
        image = ImageIO.read(inputStream);
        int[] size = getSize(width, height, image);
        return resize(size[0], size[1], savePath, image);
    }
    /**
     * 将指定的targetURL网络图片文件的宽度、高度大于指定width、height的图片缩小，并保存在savePath目录
     *
     * @param width       缩小的宽度
     * @param height      缩小的高度
     * @param savePath    保存目录
     * @param targetURL 改变的目标图片
     * @return 图片保存路径、名称
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(int width, int height, String savePath, 
			URL targetURL) throws ImageFormatException, IOException {
        image = ImageIO.read(targetURL);
        int[] size = getSize(width, height, image);
        return resize(size[0], size[1], savePath, image);
    }

    /**
     * 将一个本地的图片文件按照指定的比例进行缩放
     *
     * @param scale      缩放比例
     * @param savePath   保存文件路径、名称
     * @param targetFile 本地图片文件
     * @return 新的文件名称
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(float scale, String savePath, File targetFile) 
			throws ImageFormatException, IOException {
        image = ImageIO.read(targetFile);
        int[] size = getSize(scale, image);
        return resize(size[0], size[1], savePath, image);
    }

    /**
     * 将一个网络图片文件按照指定的比例进行缩放
     *
     * @param scale      缩放比例
     * @param savePath   保存文件路径、名称
     * @param targetURL 本地图片文件
     * @return 新的文件名称
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(float scale, String savePath, URL targetURL) 
			throws ImageFormatException, IOException {
        image = ImageIO.read(targetURL);
        int[] size = getSize(scale, image);
        return resize(size[0], size[1], savePath, image);
    }


    /**
     * 按照固定宽度进行等比缩放本地图片
     *
     * @param width      固定宽度
     * @param savePath   保存路径、名称
     * @param targetFile 本地目标文件
     * @return 返回保存路径
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(int width, String savePath, File targetFile) 
			throws ImageFormatException, IOException {
        image = ImageIO.read(targetFile);
        int[] size = getSize(width, image);
        return resize(size[0], size[1], savePath, image);
    }

    /**
     * 按照固定宽度进行等比缩放网络图片
     *
     * @param width      固定宽度
     * @param savePath   保存路径、名称
     * @param targetURL 本地目标文件
     * @return 返回保存路径
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resize(int width, String savePath, URL targetURL) 
			throws ImageFormatException, IOException {
        image = ImageIO.read(targetURL);
        int[] size = getSize(width, image);
        return resize(size[0], size[1], savePath, image);
    }

    /**
     * 按照固定高度进行等比缩放本地图片
     *
     * @param height     固定高度
     * @param savePath   保存路径、名称
     * @param targetFile 本地目标文件
     * @return 返回保存路径
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resizeByHeight(int height, String savePath, File targetFile) 
			throws ImageFormatException, IOException {
        image = ImageIO.read(targetFile);
        int[] size = getSizeByHeight(height, image);
        return resize(size[0], size[1], savePath, image);
    }

    /**
     * 按照固定高度进行等比缩放网络图片
     *
     * @param height     固定高度
     * @param savePath   保存路径、名称
     * @param targetURL 本地目标文件
     * @return 返回保存路径
     * @throws ImageFormatException
     * @throws IOException
     */
	public static String resizeByHeight(int height, String savePath, URL targetURL) 
			throws ImageFormatException, IOException {
        image = ImageIO.read(targetURL);
        int[] size = getSizeByHeight(height, image);
        return resize(size[0], size[1], savePath, image);
    }
}
