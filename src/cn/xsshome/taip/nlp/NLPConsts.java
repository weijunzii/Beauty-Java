package cn.xsshome.taip.nlp;
/**
 * 自然语言处理 API地址
 * @author 小帅丶
 * @version 4.2.0
 */
public class NLPConsts {
	//分词 	GBK
	public static final String NLP_WORDSEG = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordseg";
	//词性标注 GBK
	public static final String NLP_WORDPOS = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordpos";
	//专有名词识别  GBK
	public static final String NLP_WORDNER = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordner";
	//同义词识别  GBK
	public static final String NLP_WORDSYN = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordsyn";
	//意图成分识别  UTF-8
	static final String NLP_WORDCOM = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_wordcom";
	//情感分析识别  UTF-8
	static final String NLP_TEXTPOLAR = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_textpolar";
	//基础闲聊  UTF-8		 
	static final String NLP_TEXTCHAT = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_textchat";
	//文本翻译（AI Lab） UTF-8
	static final String NLP_TEXTTRANS = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_texttrans";
	//文本翻译（翻译君） UTF-8
	static final String NLP_TEXTTRANSLATE = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_texttranslate";
	//图片翻译 UTF-8
	static final String NLP_IMAGETRANSLATE = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_imagetranslate";	
	//语音翻译 UTF-8
	static final String NLP_SPEECHTRANSLATE = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_speechtranslate";	
	//语种识别 UTF-8
	static final String NLP_TEXTDETECT = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_textdetect";
}
