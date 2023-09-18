package kr.co.sinbuya.common;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class XPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return parseMySQLPassword(rawPassword.toString()).toUpperCase();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		List<String> passwords = new ArrayList<String>();
		passwords.add(parseMySQLPassword(rawPassword.toString()).toUpperCase());
		return passwords.contains(encodedPassword);
	}

	private static String parseMySQLPassword(String message)
	{
		return "*" + parseSHA(parseSHA(message));
	}

	private static String parseSHA(String message)
	{
		try
		{
			MessageDigest mda = MessageDigest.getInstance("SHA-1");
			byte [] b = mda.digest(message.getBytes());
	
			String result = "";
			for (int i=0; i < b.length; i++) result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
			
			return result;
		}
		catch(Exception ex) {
			return message;
		}
	}
}
