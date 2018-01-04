package com.example.springboottogglz;

import java.util.UUID;

import org.togglz.core.activation.ActivationStrategyProvider;
import org.togglz.core.activation.DefaultActivationStrategyProvider;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.UserProvider;

/**
 * To create my custom togglz feature manager.
 * 
 * @author Bhawani Singh
 * @date Nov, 2017
 *
 */
public class MyTogglzFeatureManager {

	/** accountNumberActivationStrategy */
	private static final AccNumActivationStrategy accNumActivationStrategy = new AccNumActivationStrategy();
	
	/**
	 * Constructor 
	 */
	public MyTogglzFeatureManager(){}
	
	
	
	/** customFeatureManager **/
	private static MyCustomFeatureManager customFeatureManager;
	
	/**
	 * @return the customFeatureManager
	 */
	public MyCustomFeatureManager getFeatureManager() {		
		if(customFeatureManager == null){			
			customFeatureManager = createCustomFeatureManager(); 
		}
		return customFeatureManager;
	}
	
	/**
	 * @return the customFeatureManager
	 */
	public static MyCustomFeatureManager getCustomFeatureManager(String compType) {		
		if(customFeatureManager == null){
			customFeatureManager = createCustomFeatureManager(); 
		}
		return customFeatureManager;
	}

	/**
	 * Get Custom Feature Manager
	 * 
	 * @return
	 */
	private static MyCustomFeatureManager createCustomFeatureManager() {
		if(customFeatureManager != null){			
			return customFeatureManager; 
		}		
		MyTogglzConfiguration myTogglzConfiguration = new MyTogglzConfiguration();
		FeatureProvider featureProvider = new EnumBasedFeatureProvider(myTogglzConfiguration.getFeatureClass());
		StateRepository stateRepository = myTogglzConfiguration.getStateRepository();
		UserProvider userProvider = myTogglzConfiguration.getUserProvider();
		
		ActivationStrategyProvider activationStrategyProvider = new DefaultActivationStrategyProvider();		
		((DefaultActivationStrategyProvider) activationStrategyProvider).addActivationStrategy(accNumActivationStrategy);

		String name = UUID.randomUUID().toString();		
		customFeatureManager =  
				new MyCustomFeatureManager(name, featureProvider, stateRepository, 
					userProvider, activationStrategyProvider);
		
		System.out.println("Goting to return instance of feature manager");

		return customFeatureManager;
	}
	
	

}
