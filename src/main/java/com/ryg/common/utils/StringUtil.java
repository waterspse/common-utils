package com.ryg.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.zhanggm.common.utils.RandomUtil;

/**
 * ×Ö·û´®¹¤¾ßÀà
 * @author lenovo
 *
 */
public class StringUtil {

	public static boolean isNull(String str) {
		if(str==null){
			return true;
		}
		return false;
		/**
		 * È¥¿Õ¸ñºó£¬Èç¹ûÎª"",·µ»Øtrue
		 */
		 str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	
	public static boolean isPhoneNum(String str) {
		String regex  ="1[3578]\\d{9}";
		return str.matches(regex);
	}
	
	public static boolean isEmail(String str) {
		String regex = "\\w+@\\w+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	
	public static boolean isLetter(String str) {
		if(isNull(str)) {
			return false;
		}
		str = str.toLowerCase();
		String regex = "[a-z]+";
		return str.matches(regex);
	}
	
	public static char getRandomChar() {
		Random random = new Random();
		char c = (char)('a'+random.nextInt(26));
		return c;
	}
	
	public static String getRandomChar(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			char c = getRandomChar();
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static char getRandomNumber() {
		Random random = new Random();
		char c = (char)('0'+random.nextInt(10));
		return c;
	}
	
	public static String getRandomCharAndNumber(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			int randomNum = random.nextInt(36);
			if(randomNum>10) {
				char c  = getRandomChar();
				sb.append(c);
			}else {
				char c = getRandomNumber();
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	public static String randomChineseString() {
		Strin str =null;
		int highPos,lowPos;
		Random random = new Random();
		highPos = (176+Math.abs(random.nextInt()));
		random =new Random();
		lowPos = 161+Math.abs(random.nextInt(94));
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		
		try {
			str = new String(bArr,"GB2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public static String randomChineseString(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			String randomChineseString = randomChineseString();
			sb.append(randomChineseString);
		}
		
		return sb.toString();
	}
	
	public static String randomChineseName() {
		String[] surname = { "ÕÔ", "Ç®", "Ëï", "Àî", "ÖÜ", "Îâ", "Ö£", "Íõ", "·ë", "³Â", "ñÒ", "ÎÀ", "½¯", "Éò", "º«", "Ñî", "Öì", "ÇØ",
				"ÓÈ", "Ðí", "ºÎ", "ÂÀ", "Ê©", "ÕÅ", "¿×", "²Ü", "ÑÏ", "»ª", "½ð", "Îº", "ÌÕ", "½ª", "ÆÝ", "Ð»", "×Þ", "Ó÷", "°Ø", "Ë®", "ñ¼",
				"ÕÂ", "ÔÆ", "ËÕ", "ÅË", "¸ð", "ÞÉ", "·¶", "Åí", "ÀÉ", "Â³", "Î¤", "²ý", "Âí", "Ãç", "·ï", "»¨", "·½", "Óá", "ÈÎ", "Ô¬", "Áø",
				"Ûº", "±«", "Ê·", "ÌÆ", "·Ñ", "Á®", "á¯", "Ñ¦", "À×", "ºØ", "Äß", "ÌÀ", "ëø", "Òó", "ÂÞ", "±Ï", "ºÂ", "Úù", "°²", "³£", "ÀÖ",
				"ÓÚ", "Ê±", "¸µ", "Æ¤", "±å", "Æë", "¿µ", "Îé", "Óà", "Ôª", "²·", "¹Ë", "ÃÏ", "Æ½", "»Æ", "ºÍ", "ÄÂ", "Ïô", "Òü", "Ò¦", "ÉÛ",
				"Õ¿", "Íô", "Æî", "Ã«", "Óí", "µÒ", "Ã×", "±´", "Ã÷", "ê°", "¼Æ", "·ü", "³É", "´÷", "Ì¸", "ËÎ", "Ã©", "ÅÓ", "ÐÜ", "¼Í", "Êæ",
				"Çü", "Ïî", "×£", "¶­", "Áº", "¶Å", "Èî", "À¶", "ãÉ", "Ï¯", "¼¾", "Âé", "Ç¿", "¼Ö", "Â·", "Â¦", "Î£", "½­", "Í¯", "ÑÕ", "¹ù",
				"Ã·", "Ê¢", "ÁÖ", "µó", "ÖÓ", "Ðì", "Çñ", "Âæ", "¸ß", "ÏÄ", "²Ì", "Ìï", "·®", "ºú", "Áè", "»ô", "ÓÝ", "Íò", "Ö§", "¿Â", "êÃ",
				"¹Ü", "Â¬", "Äª", "¾­", "·¿", "ôÃ", "çÑ", "¸É", "½â", "Ó¦", "×Ú", "¶¡", "Ðû", "êÚ", "µË", "Óô", "µ¥", "º¼", "ºé", "°ü", "Öî",
				"×ó", "Ê¯", "´Þ", "¼ª", "Å¥", "¹¨", "³Ì", "ïú", "ÐÏ", "»¬", "Åá", "Â½", "ÈÙ", "ÎÌ", "Ü÷", "Ñò", "ÓÚ", "»Ý", "Õç", "Çú", "¼Ò",
				"·â", "ÜÇ", "ôà", "´¢", "½ù", "¼³", "Úû", "ÃÓ", "ËÉ", "¾®", "¶Î", "¸»", "Î×", "ÎÚ", "½¹", "°Í", "¹­", "ÄÁ", "Úó", "É½", "¹È",
				"³µ", "ºî", "åµ", "Åî", "È«", "Û­", "°à", "Ñö", "Çï", "ÖÙ", "ÒÁ", "¹¬", "Äþ", "³ð", "èï", "±©", "¸Ê", "î×", "À÷", "ÈÖ", "×æ",
				"Îä", "·û", "Áõ", "¾°", "Õ²", "Êø", "Áú", "Ò¶", "ÐÒ", "Ë¾", "ÉØ", "Û¬", "Àè", "¼»", "äß", "Ó¡", "ËÞ", "°×", "»³", "ÆÑ", "Û¢",
				"´Ó", "¶õ", "Ë÷", "ÏÌ", "¼®", "Àµ", "×¿", "Ýþ", "ÍÀ", "ÃÉ", "³Ø", "ÇÇ", "Òõ", "Óô", "ñã", "ÄÜ", "²Ô", "Ë«", "ÎÅ", "Ý·", "µ³",
				"µÔ", "Ì·", "¹±", "ÀÍ", "åÌ", "¼§", "Éê", "·ö", "¶Â", "È½", "Ô×", "Ûª", "Óº", "È´", "è³", "É£", "¹ð", "å§", "Å£", "ÊÙ", "Í¨",
				"±ß", "ìè", "Ñà", "¼½", "ÆÖ", "ÉÐ", "Å©", "ÎÂ", "±ð", "×¯", "êÌ", "²ñ", "öÄ", "ÑÖ", "³ä", "Ä½", "Á¬", "Èã", "Ï°", "»Â", "°¬",
				"Óã", "ÈÝ", "Ïò", "¹Å", "Ò×", "É÷", "¸ê", "ÁÎ", "â×", "ÖÕ", "ôß", "¾Ó", "ºâ", "²½", "¶¼", "¹¢", "Âú", "ºë", "¿ï", "¹ú", "ÎÄ",
				"¿Ü", "¹ã", "Â»", "ãÚ", "¶«", "Å·", "ì¯", "ÎÖ", "Àû", "Îµ", "Ô½", "Ùç", "Â¡", "Ê¦", "¹®", "ØÇ", "Äô", "êË", "¹´", "°½", "ÈÚ",
				"Àä", "ö¤", "ÐÁ", "ãÛ", "ÄÇ", "¼ò", "ÈÄ", "¿Õ", "Ôø", "Îã", "É³", "Ø¿", "Ñø", "¾Ï", "Ðë", "·á", "³²", "¹Ø", "Øá", "Ïà", "²é",
				"ºó", "¾£", "ºì", "ÓÎ", "Û£", "óÃ", "È¨", "åÖ", "¸Ç", "Òæ", "»¸", "¹«", "Øë", "¶½", "ÔÀ", "Ë§", "çÃ", "¿º", "¿ö", "àC", "ÓÐ",
				"ÇÙ", "¹é", "º£", "½ú", "³þ", "ãÆ", "·¨", "Èê", "Û³", "Í¿", "ÇÕ", "ÉÌ", "Ä²", "ÙÜ", "Ù¦", "²®", "ÉÍ", "Ä«", "¹þ", "ÚÛ", "óò",
				"Äê", "°®", "Ñô", "Ù¡", "ÑÔ", "¸£", "ÄÏ", "»ð", "Ìú", "³Ù", "Æá", "¹Ù", "Ùþ", "Õæ", "Õ¹", "·±", "Ì´", "¼À", "ÃÜ", "¾´", "½Ò",
				"Ë´", "Â¥", "Êè", "Ã°", "»ë", "Ö¿", "½º", "Ëæ", "¸ß", "¸Þ", "Ô­", "ÖÖ", "Á·", "ÃÖ", "²Ö", "íõ", "å¿", "ñû", "°¢", "ÃÅ", "ã¢",
				"À´", "ôë", "ÕÙ", "ÒÇ", "·ç", "½é", "¾Þ", "Ä¾", "¾©", "ºü", "Û¨", "»¢", "Ã¶", "¿¹", "´ï", "è½", "ÜÉ", "ÕÛ", "Âó", "Çì", "¹ý",
				"Öñ", "¶Ë", "ÏÊ", "»Ê", "ØÁ", "ÀÏ", "ÊÇ", "ÃØ", "³©", "Ú÷", "»¹", "±ö", "ãÌ", "¹¼", "×Ý", "‚G", "ÍòÙ¹", "Ë¾Âí", "ÉÏ¹Ù", "Å·Ñô",
				"ÏÄºî", "Öî¸ð", "ÎÅÈË", "¶«·½", "ºÕÁ¬", "»Ê¸¦", "ÑòÉà", "Î¾³Ù", "¹«Ñò", "å£Ì¨", "¹«Ò±", "×ÚÕý", "å§Ñô", "´¾ÓÚ", "µ¥ÓÚ", "Ì«Êå", "ÉêÍÀ",
				"¹«Ëï", "ÖÙËï", "ÐùÔ¯", "Áîºü", "ÖÓÀë", "ÓîÎÄ", "³¤Ëï", "Ä½ÈÝ", "ÏÊÓÚ", "ãÌÇð", "Ë¾Í½", "Ë¾¿Õ", "Ø£¹Ù", "Ë¾¿Ü", "ÄÏÃÅ", "ºôÑÓ", "×Ó³µ",
				"ò§Ëï", "¶ËÄ¾", "Î×Âí", "¹«Î÷", "Æáµñ", "³µÕý", "ÈÀæá", "¹«Á¼", "ÍØ°Ï", "¼Ð¹È", "Ô×¸¸", "¹ÈÁº", "¶Î¸É", "°ÙÀï", "¶«¹ù", "Î¢Éú", "ÁºÇð",
				"×óÇð", "¶«ÃÅ", "Î÷ÃÅ", "ÄÏ¹¬", "µÚÎå", "¹«ÒÇ", "¹«³Ë", "Ì«Ê·", "ÖÙ³¤", "ÊåËï", "ÇüÍ»", "¶ûÖì", "¶«Ïç", "ÏàÀï", "ºúÄ¸", "Ë¾³Ç", "ÕÅÁÎ",
				"ÓºÃÅ", "ÎãÇð", "ºØÀ¼", "ôëÎã", "ÎÝÂ®", "¶À¹Â", "ÄÏ¹ù", "±±¹¬", "ÍõËï" };
		// Ëæ»ú»ñÈ¡ÐÕÊÏ
		String name1 = surname[RandomUtil.random(0, surname.length - 1)];
		// Ëæ»ú»ñÈ¡1-2¸öÖÐÎÄ
		String name2 = randomChineseString(RandomUtil.random(1, 3));
		return name1 + name2;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(randomChineseName());
		}
	}
}
