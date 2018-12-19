package cn.xsshome.taip.ocr;


import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.TAipEBodyFormat;
import cn.xsshome.taip.http.TAipRequest;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;
/**
 * 计算机视觉OCR识别
 * @author 小帅丶
 * @version 0.0.1
 */
public class TAipOcr extends BaseClient{

	public  TAipOcr(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 通用文字识别接口   
     * 用户向服务请求识别某张图中的所有文字
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String generalOcr(byte[] image) throws Exception{
    	String result ="";
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(OcrConsts.OCR_GENERAL);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
        return result;
    }
    /**
     * 通用文字识别接口   
     * 用户向服务请求识别某张图中的所有文字
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String generalOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return generalOcr(image);
    }
	 /**
     * 身份证识别接口   
     * 识别身份证图像上面的详细身份信息	
     * @param image - 二进制图像数据
     * @param card_type 身份证图片类型，0-正面，1-反面
     * @return String
	 * @throws Exception 
     */
    public String idcardOcr(byte[] image,int card_type) throws Exception{
    	String result ="";
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
		request.addBody("card_type",Integer.toString(card_type));
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(OcrConsts.OCR_IDCARD);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
        return result;
    }
    /**
     * 身份证识别接口   
     * 识别身份证图像上面的详细身份信息	
     * @param filePath - 本地路径图像文件
     * @param card_type 身份证图片类型，0-正面，1-反面
     * @return String
	 * @throws Exception 
     */
    public String idcardOcr(String filePath,int card_type) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return idcardOcr(image,card_type);
    }
	 /**
     * 名片识别接口   
     * 识别名片图像上面的字段信息
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String bcOcr(byte[] image) throws Exception{
    	String result ="";
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(OcrConsts.OCR_BCOCR);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
        return result;
    }
    /**
     * 名片识别接口   
     * 识别名片图像上面的字段信息
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String bcOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return bcOcr(image);
    }
	 /**
     * 行驶证驾驶证OCR识别
     * 识别行驶证或驾驶证图像上面的字段信息
     * @param image - 二进制图像数据
     * @param type 识别类型，0-行驶证识别，1-驾驶证识别
     * @return String
	 * @throws Exception 
     */
    public String driverlicenseOcr(byte[] image,int type) throws Exception{
    	String result ="";
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        request.addBody("type", String.valueOf(type));
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(OcrConsts.OCR_DRIVERLICENSEOCR);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
        return result;
    }
    /**
     * 行驶证驾驶证OCR识别
     * 识别行驶证或驾驶证图像上面的字段信息
     * @param filePath - 本地路径图像文件
     * @param type 识别类型，0-行驶证识别，1-驾驶证识别
     * @return String
	 * @throws Exception 
     */
    public String driverlicenseOcr(String filePath,int type) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return driverlicenseOcr(image,type);
    }
   	 /**
     * 营业执照OCR识别
     * 识别营业执照上面的字段信息	
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String bizlicenseOcr(byte[] image) throws Exception{
    	String result ="";
        TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis()/1000+"";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        String sign = TencentAISignSort.getSignature(request.getBody(),app_key);
		request.addBody("sign",sign);
        request.setUri(OcrConsts.OCR_BIZLICENSE);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
        return result;
    }
    /**
     * 营业执照OCR识别
     * 识别营业执照上面的字段信息	
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String bizlicenseOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return bizlicenseOcr(image);
    }  
  	 /**
    * 银行卡OCR识别	
    * 识别银行卡上面的字段信息	
    * @param image - 二进制图像数据
    * @return String
	* @throws Exception 
    */
	public String creditcardOcr(byte[] image) throws Exception {
		String result = "";
		TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis() / 1000 + "";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
		String base64Content = Base64Util.encode(image);
		request.addBody("image", base64Content);
		String sign = TencentAISignSort.getSignature(request.getBody(), app_key);
		request.addBody("sign", sign);
        request.setUri(OcrConsts.OCR_BANK);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
		return result;
	}
   /**
    * 银行卡OCR识别	
    * 识别银行卡上面的字段信息	
    * @param filePath - 本地路径图像文件
    * @return String
	* @throws Exception 
    */
   public String creditcardOcr(String filePath) throws Exception{
		byte[] image = FileUtil.readFileByBytes(filePath);
		return creditcardOcr(image);
	}  
   /**
    * 手写体OCROCR识别	
    * 检测和识别图像上面手写体的字段信息
    * @param image - 二进制图像数据
    * @return String
	* @throws Exception 
    */
	public String handWritingOcrByImage(byte[] image) throws Exception {
		String result = "";
		TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis() / 1000 + "";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
		String base64Content = Base64Util.encode(image);
		request.addBody("image", base64Content);
		String sign = TencentAISignSort.getSignature(request.getBody(), app_key);
		request.addBody("sign", sign);
        request.setUri(OcrConsts.OCR_HANDWRITINGOCR);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
		return result;
	}
   /**
    * 手写体OCROCR识别	
    * 检测和识别图像上面手写体的字段信息	
    * @param filePath - 本地路径图像文件
    * @return String
	* @throws Exception 
    */
   public String handWritingOcrByImage(String filePath) throws Exception{
		byte[] image = FileUtil.readFileByBytes(filePath);
		return handWritingOcrByImage(image);
	}   
   /**
    * 手写体OCROCR识别	
    * 检测和识别图像上面手写体的字段信息
    * use handWritingOcrByImage
    * @param image_url - 图片URL地址
    * @return String
	* @throws Exception 
    */
	public String handWritingOcrByUrl(String image_url) throws Exception {
		String result = "";
		TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis() / 1000 + "";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
		request.addBody("image_url", image_url);
		String sign = TencentAISignSort.getSignature(request.getBody(), app_key);
		request.addBody("sign", sign);
        request.setUri(OcrConsts.OCR_HANDWRITINGOCR);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
		return result;
	}

	/**
	 * 车牌OCR 	
	 * 识别车牌上面的字段信息
	 * @param image  - 二进制图像数据
	 * @return String
	 * @throws Exception
	 */
	public String plateOcrByImage(byte[] image) throws Exception {
		String result = "";
		TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis() / 1000 + "";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
		String base64Content = Base64Util.encode(image);
		request.addBody("image", base64Content);
		String sign = TencentAISignSort.getSignature(request.getBody(), app_key);
		request.addBody("sign", sign);
        request.setUri(OcrConsts.OCR_PLATEOCR);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
		return result;
	}

	/**
	 * 车牌OCR 	
	 * 识别车牌上面的字段信息
	 * @param filePath    - 本地路径图像文件
	 * @return String
	 * @throws Exception
	 */
	public String plateOcrByImage(String filePath) throws Exception {
		byte[] image = FileUtil.readFileByBytes(filePath);
		return plateOcrByImage(image);
	}

	/**
	 * 车牌OCR 	
	 * 识别车牌上面的字段信息
	 * @param image_url - 图片URL地址
	 * @return String
	 * @throws Exception
	 */
	public String plateOcrByUrl(String image_url) throws Exception {
		String result = "";
		TAipRequest request = new TAipRequest();
		String time_stamp = System.currentTimeMillis() / 1000 + "";
		request.addBody("app_id", app_id);
		request.addBody("time_stamp", time_stamp);
		request.addBody("nonce_str", RandomNonceStrUtil.getRandomString());
		request.addBody("image_url", image_url);
		String sign = TencentAISignSort.getSignature(request.getBody(), app_key);
		request.addBody("sign", sign);
        request.setUri(OcrConsts.OCR_PLATEOCR);
        request.setBodyFormat(TAipEBodyFormat.FORM_KV);
        result = requestServer(request);
		return result;
	}
}
