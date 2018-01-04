package com.example.springboottogglz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;

@Configuration
public class ToggleConfiguration {
 
   /* @Bean
    public FeatureProvider featureProvider() {
    	System.out.println("@@@@@@@@@@@    ToggleConfiguration.featureProvider()");
        return new EnumBasedFeatureProvider(MyFeatures.class);
    }
    
    @Bean
    public UserProvider getUserProvider() {
    	System.out.println("@@@@@@@@@@@@   ToggleConfiguration.getUserProvider()");
        //return new ServletUserProvider("ROLE_ADMIN");
    	
    	return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin", true);
            }
        };
    	
    }*/
    
    
	@Bean
	public FeatureManager featureManager() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@  ChannelApplication.featureManager()");
		
		
		FeatureManagerBuilder featureManagerBuilder = new FeatureManagerBuilder().togglzConfig(new MyTogglzConfiguration());
		featureManagerBuilder.activationStrategy( new WeekdayActivationStrategy());
		FeatureManager featureManager = featureManagerBuilder.build();
		return featureManager;
	}
	 
    
    
}