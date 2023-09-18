package kr.co.sinbuya.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.hectorlopezfernandez.pebble.springsecurity.SpringSecurityExtension;
import com.mitchellbosecke.pebble.extension.Extension;

import kr.co.sinbuya.common.XPasswordEncoder;
import kr.co.sinbuya.www.service.UserDetailService;





@Component
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired private XPasswordEncoder passwordEncoder;
	@Autowired private UserDetailService userDetailService;	


	
	public SecurityConfig() {
		System.out.println("Security Config..");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/static-bundle/**", "/assets/**", "/fonts/**", "/img/**", "/favicon.ico", "/webfonts", "/error");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.failureUrl("/login?error=password")
			.successHandler(new AuthSuccessHandler());
			
		http.authorizeRequests()
			.antMatchers("/mypage").authenticated()
			.antMatchers("/mypage/**").authenticated()
			.antMatchers("/budget/hall").authenticated()
			.antMatchers("/budget/wedding").authenticated()
			.antMatchers("/budget/product").authenticated()
			.antMatchers("/budget/home").authenticated()
			.antMatchers("/voucher/submit").authenticated()
			.antMatchers("/pointmall/order").authenticated();
		

//		access.put("^(/mypage).*$", new String[]{ "ROLE_USER" });
//		access.put("^(/budget/hall).*$", new String[]{ "ROLE_USER" });
//		access.put("^(/budget/wedding).*$", new String[]{ "ROLE_USER" });
//		access.put("^(/budget/product).*$", new String[]{ "ROLE_USER" });
//		access.put("^(/budget/home).*$", new String[]{ "ROLE_USER" });
//		access.put("^(/voucher/submit).*$", new String[]{ "ROLE_USER" });
//		access.put("^(/pointmall/order).*$", new String[]{ "ROLE_USER" });

		http.logout().invalidateHttpSession(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/");
		
		http.rememberMe()
			.key("sinbuya")
			.rememberMeParameter("remember")
			.tokenValiditySeconds(86400);

		http.csrf().disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailService;
	}

	@Bean
	public Extension securityExtension() {
		return new SpringSecurityExtension();
	}
	
	public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
		
		public AuthSuccessHandler() {
		}

	}

}