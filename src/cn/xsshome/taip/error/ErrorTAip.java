package cn.xsshome.taip.error;
/**
 * 错误信息
 * @author 小帅丶
 * @version 4.3.5
 */
public enum ErrorTAip {
	SOURCE_TARGET_ERROR("SDK100","源语言与目标语言匹配错误,此错误信息是SDK判断发出并非腾讯AI接口返回"),
	APISERVICE_ERROR("SDK504","接口服务异常");
	private final String errorCode;
    private final String errorMsg;
	ErrorTAip(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public String toJsonResult(){
		String json = "{\"errorCode\":\""+errorCode+"\",\"errorMsg\":\""+errorMsg+"\"}";
		return json;
	}
	public String toJsonResult(String msg){
		String json = "{\"errorCode\":\""+errorCode+"\",\"errorMsg\":\""+msg+"\"}";
		return json;
	}
    @Override
    public String toString() {
    	return super.toString();
    }
}
