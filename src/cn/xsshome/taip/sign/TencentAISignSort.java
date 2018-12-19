package cn.xsshome.taip.sign;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import cn.xsshome.taip.error.ErrorTAip;
import cn.xsshome.taip.util.TransConstant;
/**
 * 签名生成算法方法类
 * 更新时间:2018年4月11日
 * 不再需要自己排序了。直接使用TreeMap进行参数排序
 * @author 小帅丶
 * @version 0.0.1
 */
public class TencentAISignSort {
	/**
	 * SIGN签名生成算法-JAVA版本
	 * @param  params 请求参数集，所有参数必须已转换为字符串类型
	 * @param app_key 
	 * @return String
	 * @throws IOException
	 */
	public static String getSignature(HashMap<String,String> params, String app_key) throws IOException {
	        // 先将参数以其参数名的字典序升序进行排序
	        Map<String, String> sortedParams = new TreeMap<>(params);
	        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
	        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
	        StringBuilder baseString = new StringBuilder();
	        for (Map.Entry<String, String> param : entrys) {
	            //sign参数 和 空值参数 不加入算法
	            if(param.getValue()!=null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim()) && !"".equals(param.getValue().trim())) {
	                baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"UTF-8")).append("&");
	            }
	        }
	        if(baseString.length() > 0 ) {
	            baseString.deleteCharAt(baseString.length()-1).append("&app_key="+app_key);
	        }
	        // 使用MD5对待签名串求签
	        try {
	        	String sign = MD5.getMD5(baseString.toString());
	        	return sign;
	        } catch (Exception ex) {
	            throw new IOException(ex);
	        }
	    }
	/**
	 * SIGN签名生成算法针对文本进行翻译的处理-JAVA版本 针对于输入的源语言和目标语言进行了判断
	 * @param  params 请求参数集，所有参数必须已转换为字符串类型
	 * @return 签名
	 * @throws Exception 
	 */
	public static String getSignature4TransText(HashMap<String,String> params,String app_key) throws Exception {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
        String source = params.get("source");
        String target = params.get("target");
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder baseString = new StringBuilder();
        String sign ="";
		if (source.equals("en")&& !Arrays.asList(TransConstant.EN_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("en")&& !Arrays.asList(TransConstant.EN_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("zh")&& !Arrays.asList(TransConstant.ZH_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("fr")&& !Arrays.asList(TransConstant.FR_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("es")&& !Arrays.asList(TransConstant.ES_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("it")&& !Arrays.asList(TransConstant.IT_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("de")&& !Arrays.asList(TransConstant.DE_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("tr")&& !Arrays.asList(TransConstant.TR_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("ru")&& !Arrays.asList(TransConstant.RU_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("pt")&& !Arrays.asList(TransConstant.PT_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("vi")&& !Arrays.asList(TransConstant.VI_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("id")&& !Arrays.asList(TransConstant.ID_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("ms")&& !Arrays.asList(TransConstant.MS_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("th")&& !Arrays.asList(TransConstant.TH_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("jp")&& !Arrays.asList(TransConstant.JP_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("kr")&& !Arrays.asList(TransConstant.KR_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else if (source.equals("auto")&& !Arrays.asList(TransConstant.AUTO_TARGET).contains(target)) {
			return ErrorTAip.SOURCE_TARGET_ERROR.toJsonResult(source+ "源语言不支持目标语言:" + target);
		}else{
		for (Map.Entry<String, String> param : entrys) {
			// sign参数 和 空值参数 不加入算法
			if (param.getValue() != null && !"".equals(param.getKey().trim())&& !"sign".equals(param.getKey().trim())&& !"".equals(param.getValue().trim())) {
				baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"UTF-8")).append("&");
			}
		}
		if (baseString.length() > 0) {
			baseString.deleteCharAt(baseString.length() - 1).append("&app_key=" + app_key);
		}
		// 使用MD5对待签名串求签
		try {
			sign = MD5.getMD5(baseString.toString());
			return sign;
		} catch (Exception ex) {
			throw new IOException(ex);
		}
		}
	}
	/**
	 * SIGN签名生成算法-JAVA版本
	 * @param  params 请求参数集，所有参数必须已转换为字符串类型
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignatureforNLP(HashMap<String,String> params,String app_key) throws IOException {
	        // 先将参数以其参数名的字典序升序进行排序
	        Map<String, String> sortedParams = new TreeMap<>(params);
	        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
	        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
	        StringBuilder baseString = new StringBuilder();
	        for (Map.Entry<String, String> param : entrys) {
	        	
	            //sign参数 和 空值参数 不加入算法
	            if(param.getValue()!=null && !"".equals(param.getKey().trim()) && !"sign".equals(param.getKey().trim()) && !"".equals(param.getValue().trim())) {
	            	if(param.getKey().equals("text")){
	            		baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"GBK")).append("&");
	            	}else{
	            		baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"UTF-8")).append("&");
	            	}
	            }
	        }
	        if(baseString.length() > 0 ) {
	            baseString.deleteCharAt(baseString.length()-1).append("&app_key="+app_key);
	        }
	        // 使用MD5对待签名串求签
	        try {
	        	String sign = MD5.getMD5(baseString.toString());
	        	return sign;
	        } catch (Exception ex) {
	            throw new IOException(ex);
	        }
	    }
	/**
	 * 获取拼接的参数
	 * @param params
	 * @return String
	 * @throws IOException
	 */
	public static String getParams(HashMap<String,String> params) throws IOException {
		//  先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            //sign参数 和 空值参数 不加入算法
           baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"UTF-8")).append("&");
        }
       return baseString.toString();
    }
	/**
	 * 获取拼接的参数forNLP
	 * @param params
	 * @return String
	 * @throws IOException
	 */
	public static String getParamsforNLP(HashMap<String,String> params) throws IOException {
		//  先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            //sign参数 和 空值参数 不加入算法
        	if(param.getKey().equals("text")){
        		baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"GBK")).append("&");
        	}else{
        		baseString.append(param.getKey().trim()).append("=").append(URLEncoder.encode(param.getValue().trim(),"UTF-8")).append("&");
        	}
        }
       return baseString.toString();
    }
}
