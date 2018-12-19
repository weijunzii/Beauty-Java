package cn.xsshome.taip.http;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.xsshome.taip.util.Util;

public class TAipRequest {
    private HashMap<String, String> headers;
    private HashMap<String, String> params;
    private HashMap<String, String> body;
    private URI uri;
    private TAipHttpMethodName httpMethod;
    private TAipEBodyFormat bodyFormat;
    private String contentEncoding;
    private TAipClientConfiguration config;


    public TAipRequest() {
        headers = new HashMap<String, String>();
        params = new HashMap<String, String>();
        body = new HashMap<String, String>();
        httpMethod = TAipHttpMethodName.POST;
        bodyFormat = TAipEBodyFormat.FORM_KV;
        contentEncoding = TAipHttpCharacterEncoding.DEFAULT_ENCODING;
        config = null;
    }

    public TAipRequest(HashMap<String, String> header, HashMap<String, String> bodyParams) {
        headers = header;
        params = bodyParams;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public TAipEBodyFormat getBodyFormat() {
        return bodyFormat;
    }

    public void setBodyFormat(TAipEBodyFormat bodyFormat) {
        this.bodyFormat = bodyFormat;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
        if (key.equals(TAipHeaders.CONTENT_ENCODING)) {
            this.contentEncoding = value;
        }
    }

    public void addParam(String key, String value) {
        params.put(key, value);
    }

    public void addBody(String key, String value) {
        body.put(key, value);
    }

    public void addBody(HashMap other) {
        if (other != null) {
            body.putAll(other);
        }
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    /**
     * get body content depending on bodyFormat
     * @return body content as String
     */
    public String getBodyStr() {
        ArrayList<String> arr = new ArrayList<String>();
        if (bodyFormat.equals(TAipEBodyFormat.FORM_KV)) {
            for (Map.Entry<String, String> entry : body.entrySet()) {
                if (entry.getValue() == null || entry.getValue().equals("")) {
                    arr.add(Util.uriEncode(entry.getKey(), true));
                } else {
                    arr.add(String.format("%s=%s", Util.uriEncode(entry.getKey(), true),
                            Util.uriEncode(entry.getValue().toString(), true)));
                }
            }
            return Util.mkString(arr.iterator(), '&');
        }  else if (bodyFormat.equals(TAipEBodyFormat.RAW_JSON_ARRAY)) {
            return (String) body.get("body");
        }
        return "";
    }
    /**
     * get body content depending on bodyFormat
     * @return body content as String
     */
    public String getBodyStrForNLP() {
        ArrayList<String> arr = new ArrayList<String>();
        if (bodyFormat.equals(TAipEBodyFormat.FORM_KV)) {
            for (Map.Entry<String, String> entry : body.entrySet()) {
                if (entry.getValue() == null || entry.getValue().equals("")) {
                    arr.add(Util.uriEncode(entry.getKey(), true));
                } else {
                	if(entry.getKey().equals("text")){
                        arr.add(String.format("%s=%s", Util.uriEncodeGBK(entry.getKey(), false),
                                Util.uriEncodeGBK(entry.getValue().toString(), false)));
                	}else{
                        arr.add(String.format("%s=%s", Util.uriEncode(entry.getKey(), true),
                                Util.uriEncode(entry.getValue().toString(), true)));
                	}
                }
            }
            return Util.mkString(arr.iterator(), '&');
        }  else if (bodyFormat.equals(TAipEBodyFormat.RAW_JSON_ARRAY)) {
            return (String) body.get("body");
        }
        return "";
    }
    public String getParamStr() {
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            buffer.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
        }
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer.toString();
    }

    public HashMap<String, String> getBody() {
        return body;
    }

    public void setBody(HashMap<String, String> body) {
        this.body = body;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public void setUri(String url) {
        try {
            this.uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public TAipHttpMethodName getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(TAipHttpMethodName httpMethod) {
        this.httpMethod = httpMethod;
    }

    public TAipClientConfiguration getConfig() {
        return config;
    }

    public void setConfig(TAipClientConfiguration config) {
        this.config = config;
    }
}
