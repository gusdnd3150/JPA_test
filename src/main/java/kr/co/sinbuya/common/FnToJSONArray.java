package kr.co.sinbuya.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.Function;

import net.sf.json.JSONArray;

public class FnToJSONArray implements Function {

	@Override
	public List<String> getArgumentNames() {
		List<String> names = new ArrayList<String>();
		names.add("var");
		return names;
	}

	@Override
	public Object execute(Map<String, Object> args) {
		String value = "[]";
		if(args.get("var") != null) {
			 value = args.get("var").toString();
		}
		
		
		return JSONArray.fromObject(value);
	}

}
