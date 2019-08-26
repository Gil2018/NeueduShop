package util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共类
 * @author yinb
 *
 */
public class Common {
	/**
	 * double类型格式化
	 * @param data
	 * @return
	 */
	public static String dataFormat(double data) {
		DecimalFormat formatData = new DecimalFormat("#.0");
		return formatData.format(data);
	}
	
	/**
	 * double两数相减
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double sub(double num1,double num2){
		return (num1*10-num2*10)/10;
	}
}
