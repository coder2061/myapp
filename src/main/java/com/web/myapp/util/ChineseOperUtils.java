package com.web.myapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**   
 * @Title: ConvertChineseUtils.java 
 * @Package com.myzone.tool 
 * @Description: 中文汉字操作
 * @author jiangyf   
 * @date 2016年1月8日 下午4:07:52 
 * @version V1.0   
 */
public class ChineseOperUtils {
	
	/** 
    * 汉字转换位汉语拼音首字母，英文字符不变 
    * @param chines 汉字 
    * @return 拼音 
    */  
    public static String converterToFirstSpell(String chinese){         
        String pinyinName = "";  
        char[] nameChar = chinese.toCharArray();  
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        for (int i = 0; i < nameChar.length; i++) {  
            if (nameChar[i] > 128) {  
                try {  
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);  
                } catch (BadHanyuPinyinOutputFormatCombination e) {  
                    e.printStackTrace();  
                }  
            }else{  
                pinyinName += nameChar[i];  
            }  
        }  
        return pinyinName;  
    }  
   
    /** 
    * 汉字转换位汉语拼音，英文字符不变 
    * @param chinese 汉字 
    * @return 拼音 
    */  
    public static String converterToSpell(String chinese){          
        String pinyinName = "";  
        char[] nameChar = chinese.toCharArray();  
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        for (int i = 0; i < nameChar.length; i++) { 
        	Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		    Matcher m = p.matcher(nameChar[i]+"");
        	if (nameChar[i] > 128 && m.find()) {
                try {  
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];  
                } catch (BadHanyuPinyinOutputFormatCombination e) {  
                    e.printStackTrace();  
                }  
            }else{  
                pinyinName += nameChar[i];  
            }  
        }  
        return pinyinName;  
    }
    
    @SuppressWarnings("deprecation")
	public static String hanziToPinyin(String hanzi,String separator){  
        // 创建汉语拼音处理类  
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        // 输出设置，大小写，音标方式  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
          
        String pinyingStr="";  
        try {  
            pinyingStr=PinyinHelper.toHanyuPinyinString(hanzi, defaultFormat, separator);  
        } catch (BadHanyuPinyinOutputFormatCombination e) {  
            e.printStackTrace();  
        }     
        return pinyingStr;  
	} 
    public static char[]  getHeadByChar(char src,boolean isCapital){  
        //如果不是汉字直接返回 
    	 Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
         Matcher m = p.matcher(src+"");
         
         while (!m.find()) {
        	 return new char[]{src};
         }
         
        /*if (src <= 128 || "《》ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪⅫ`~!@#$^&＆*()=_—-|{}':;',\\[\\].<>/?~！@#￥……&*（）&;|{}【】‘；：”“'。，、？°%".contains(src+"")) {  
            return new char[]{src};  
        }*/  
        //获取所有的拼音  
        String [] pinyingStr=PinyinHelper.toHanyuPinyinStringArray(src);  
          
        //创建返回对象  
        int polyphoneSize=pinyingStr.length;  
        char [] headChars=new char[polyphoneSize];  
        int i=0;  
        //截取首字符  
        for(String s:pinyingStr){  
            char headChar=s.charAt(0);  
            //首字母是否大写，默认是小写  
            if(isCapital){  
                headChars[i]=Character.toUpperCase(headChar);  
             }else{  
                headChars[i]=headChar;  
             }  
            i++;  
        }  
          
        return headChars;  
    }  
    /**  
     * 取汉字的首字母(默认是大写)  
     * @param src  
     * @return  
     */  
    public static char[]  getHeadByChar(char src){  
        return getHeadByChar(src,true);  
    }  
    /**  
     * 查找字符串首字母  
     * @param src   
     * @return  
     */  
    public  static String getHeadByString(String src){  
        return getHeadByString( src, true);  
    }  
    /**  
     * 查找字符串首字母  
     * @param src   
     * @param isCapital 是否大写  
     * @return  
     */  
    public  static String getHeadByString(String src,boolean isCapital){  
        return getHeadByString( src, isCapital,null);  
    }  
    /**  
     * 查找字符串首字母  
     * @param src   
     * @param isCapital 是否大写  
     * @param separator 分隔符  
     * @return  
     */  
    public  static String getHeadByString(String src,boolean isCapital,String separator){  
    	 char[]chars=src.toCharArray();  
         String[] headString=new String[chars.length];  
    	String str ="";
       
        int i=0;  
        for(char ch:chars){  
        	char[]chs=getHeadByChar(ch,isCapital);  
            StringBuffer sb=new StringBuffer();  
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	         Matcher m = p.matcher(src+"");
	         if (!m.find()) {
        	//if("ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪⅫ`~!@#$^&＆*()=_—-|{}':;',\\[\\].<>/?~！@#￥……&*（）&;|{}【】‘；：”“'。，、°？%".contains(ch+"")){
                    sb.append(chs[0]);  
                    str = str +sb.toString();
                headString[i]=sb.toString();
        	}else{
        		
                if(null!=separator){  
                    int j=1;  
                      
                    for(char ch1:chs){  
                        sb.append(ch1);  
                        if(j!=chs.length){  
                            sb.append(separator);  
                        }  
                        j++;  
                    }  
                }else{  
                    sb.append(chs[0]);  
                }  
                headString[i]=sb.toString();
                str = str +sb.toString();
        	}  
              
            i++;  
        }  
        return str;  
    }  

	/**
	 * 检测是否有emoji字符
	 * 
	 * @param source
	 * @return 一旦含有就抛出
	 */
	public static boolean containsEmoji(String source) {
		if (StringUtils.isBlank(source)) {
			return false;
		}

		int len = source.length();

		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);

			if (isEmojiCharacter(codePoint)) {
				// do nothing，判断到了这里表明，确认有表情字符
				return true;
			}
		}

		return false;
	}

	/** 
	* @Title: isEmojiCharacter 
	* @Description: 判断是否emoji字符
	* @param codePoint
	* @return boolean
	*/
	private static boolean isEmojiCharacter(char codePoint) {
		  return (codePoint == 0x0) ||
		  (codePoint == 0x9) ||
		  (codePoint == 0xA) ||
		  (codePoint == 0xD) ||
		  ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
		  ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
		  ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	  }

	/**
	 * 过滤emoji 或者 其他非文字类型的字符
	 * 
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		if (!containsEmoji(source)) {
			return source;// 如果不包含，直接返回
		}
		// 到这里铁定包含
		StringBuilder buf = null;

		int len = source.length();

		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);

			if (isEmojiCharacter(codePoint)) {
				if (buf == null) {
					buf = new StringBuilder(source.length());
				}

				buf.append(codePoint);
			} else {
			}
		}

		if (buf == null) {
			return source;// 如果没有找到 emoji表情，则返回源字符串
		} else {
			if (buf.length() == len) {// 这里的意义在于尽可能少的toString，因为会重新生成字符串
				buf = null;
				return source;
			} else {
				return buf.toString();
			}
		}
	}

}
