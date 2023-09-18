package kr.co.sinbuya.common;

import org.springframework.stereotype.Service;

@Service
public class SinbuyaHelper {
	
	public String replaceCrLf(String str) {
		if (str == null) return "";
		String regex1 = "\\<.*?\\>";
		String regex2 = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
		str = str.replaceAll(regex1, "");
		str = str.replaceAll(regex2, "");
		return str.replaceAll("\\n", "<br />");
	}
	
}
