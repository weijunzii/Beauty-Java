package cn.xsshome.taip.base;

import cn.xsshome.taip.error.ErrorTAip;
import cn.xsshome.taip.http.TAipClientConfiguration;
import cn.xsshome.taip.http.TAipHttpClient;
import cn.xsshome.taip.http.TAipRequest;
import cn.xsshome.taip.http.TAipResponse;

import java.net.Proxy;

/**
 * 基础抽象类
 * @author 小帅丶
 * @version 4.3.5
 */
public abstract  class BaseClient {
	protected String app_id;//控制台查看应用对应的AppID
    protected String app_key;//控制台查看应用对应的AppKey
    protected TAipClientConfiguration config;//设置超时 代理等
    
    protected BaseClient(String app_id, String app_key) {
		super();
		this.app_id = app_id;
		this.app_key = app_key;
	}
    /**
     * send request to server
     * @param request TAipRequest object
     * @return String of server response
     */
    protected String requestServer(TAipRequest request) {
        // 请求API
		request.setConfig(config);
		long startTime = System.currentTimeMillis();
		TAipResponse response = TAipHttpClient.post(request);
		long endTime = System.currentTimeMillis();
		long timeStamp = endTime - startTime;
		int resStatus = response.getStatus();
		if (resStatus != 200) {
			return ErrorTAip.APISERVICE_ERROR.toJsonResult("接口服务异常  耗时(毫秒):"+timeStamp+" HTTP STATUS:"+resStatus +" 请联系腾讯AI的官方人员");
		} else {
			String resData = response.getBodyStr();
			return resData;
		}
    }
    /**
    *
    * @param timeout 服务器建立连接的超时时间（单位：毫秒）
    */
   public void setConnectionTimeoutInMillis(int timeout) {
       if (config == null) {
           config = new TAipClientConfiguration();
       }
       this.config.setConnectionTimeoutMillis(timeout);
   }

   /**
    *
    * @param timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
    */
   public void setSocketTimeoutInMillis(int timeout) {
       if (config == null) {
           config = new TAipClientConfiguration();
       }
       this.config.setSocketTimeoutMillis(timeout);
   }

   /**
    * 设置访问网络需要的http代理
    * @param host 代理服务器地址
    * @param port 代理服务器端口
    */
   public void setHttpProxy(String host, int port) {
       if (config == null) {
           config = new TAipClientConfiguration();
       }
       this.config.setProxy(host, port, Proxy.Type.HTTP);
   }

   /**
    * 设置访问网络需要的socket代理
    * @param host 代理服务器地址
    * @param port 代理服务器端口
    */
   public void setSocketProxy(String host, int port) {
       if (config == null) {
           config = new TAipClientConfiguration();
       }
       this.config.setProxy(host, port, Proxy.Type.SOCKS);
   }

}
