package com.ryg.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.zhanggm.common.utils.RandomUtil;

/**
 * �ַ���������
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
		 * ȥ�ո�����Ϊ"",����true
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
		String[] surname = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��",
				"ۺ", "��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��",
				"տ", "��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��",
				"��", "��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��",
				"÷", "ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��",
				"��", "¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��",
				"��", "��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ",
				"��", "��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��",
				"��", "̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "ȴ", "�", "ɣ", "��", "�", "ţ", "��", "ͨ",
				"��", "��", "��", "��", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ۣ", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "˧", "��", "��", "��", "�C", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��",
				"��", "��", "��", "١", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "չ", "��", "̴", "��", "��", "��", "��",
				"˴", "¥", "��", "ð", "��", "ֿ", "��", "��", "��", "��", "ԭ", "��", "��", "��", "��", "��", "�", "��", "��", "��", "�",
				"��", "��", "��", "��", "��", "��", "��", "ľ", "��", "��", "ۨ", "��", "ö", "��", "��", "�", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "�G", "��ٹ", "˾��", "�Ϲ�", "ŷ��",
				"�ĺ�", "���", "����", "����", "����", "�ʸ�", "����", "ξ��", "����", "�̨", "��ұ", "����", "���", "����", "����", "̫��", "����",
				"����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "أ��", "˾��", "����", "����", "�ӳ�",
				"���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����", "����", "΢��", "����",
				"����", "����", "����", "�Ϲ�", "����", "����", "����", "̫ʷ", "�ٳ�", "����", "��ͻ", "����", "����", "����", "��ĸ", "˾��", "����",
				"Ӻ��", "����", "����", "����", "��®", "����", "�Ϲ�", "����", "����" };
		// �����ȡ����
		String name1 = surname[RandomUtil.random(0, surname.length - 1)];
		// �����ȡ1-2������
		String name2 = randomChineseString(RandomUtil.random(1, 3));
		return name1 + name2;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(randomChineseName());
		}
	}
}
