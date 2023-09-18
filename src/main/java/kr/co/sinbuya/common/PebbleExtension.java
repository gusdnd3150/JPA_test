package kr.co.sinbuya.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Filter;
import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.tokenParser.TokenParser;

@Component
public class PebbleExtension extends AbstractExtension {

    @Override
    public Map<String, Filter> getFilters() {
        return Collections.emptyMap();
    }
    
    @Override
    public Map<String, Function> getFunctions() {
    	Map<String, Function> functions = new HashMap<>(2);
    	functions.put("toJSONArray", new FnToJSONArray());
        return functions;
    }

    @Override
    public List<TokenParser> getTokenParsers() {
        List<TokenParser> parsers = new ArrayList<>();
        return parsers;
    }
}
