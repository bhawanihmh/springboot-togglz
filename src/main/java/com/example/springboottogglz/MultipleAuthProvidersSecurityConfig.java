package com.example.springboottogglz;

//@EnableWebSecurity
public class MultipleAuthProvidersSecurityConfig{// extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	CustomAuthenticationProvider customAuthProvider;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthProvider);
		auth.inMemoryAuthentication()
			.withUser("memuser")
			.password("pass")
			.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/api/**")
			.authenticated();
	}*/
}