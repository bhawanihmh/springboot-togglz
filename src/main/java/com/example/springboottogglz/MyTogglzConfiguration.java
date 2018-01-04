package com.example.springboottogglz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;

@Component

//@PropertySource("file:togglz.properties")

//@PropertySource(name"classpath:togglz.properties")

//@PropertySource(name="features", value="classpath:iptv/channel/togglz/togglz.properties")
public class MyTogglzConfiguration implements TogglzConfig {

	
	/** togglzProperties */
	//private static final String togglzProperties = "/standalone/configuration/togglz.properties";

	/**
	 * Constructor
	 */
	public MyTogglzConfiguration() {
		System.out.println("###############    Load MyTogglzConfiguration   #############");
	}

	public Class<? extends Feature> getFeatureClass() {
		return MyFeatures.class;
	}

	public StateRepository getStateRepository() {
		File loadTogglzFile = null;
		Properties values = new Properties();
		try {
			//loadTogglzFile = new File(System.getenv("JBOSS_HOME") + togglzProperties);
			//loadTogglzFile = new ClassPathResource("togglz.properties").getFile();
			
			
			/*loadTogglzFile = new File(
					MyTogglzConfiguration.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String propertiesPath = loadTogglzFile.getParentFile().getAbsolutePath() + "/togglz.properties";

			System.out.println("propertiesPath  = " + propertiesPath);			
			
			loadTogglzFile = new File(propertiesPath);		
			
			
			System.out.println("Get Absolute Path of togglz.properties  = " + loadTogglzFile.getAbsolutePath());*/
			
			
			
			
			
			//loadTogglzFile = new ClassPathResource("/togglz.properties").getFile();
			
			loadTogglzFile = new File("D://opt/local/java/config/togglz.properties");
			
			
			System.out.println("Get Absolute Path of togglz.properties  = " + loadTogglzFile.getAbsolutePath());
			

			values.load(new FileInputStream(loadTogglzFile));
			System.out.println("============   FEATURE_ONE = " + values.getProperty("FEATURE_ONE"));
			System.out.println("============   FEATURE_TWO = " + values.getProperty("FEATURE_TWO"));			
		} catch (Exception ioException) {
			System.out.println("Togglz properties file Not Found at specified location:" + ioException);
			try {
				loadTogglzFile = new ClassPathResource("/be/belgacom/tv/common/togglz/togglz.properties").getFile();
				System.out.println("Get Absolute Path of togglz.properties  = " + loadTogglzFile.getAbsolutePath());
				// values.load(loadLocalTogglzFile);

				/// System.out.println("MyTogglzConfiguration.getStateRepository()" +
				/// values.getProperty("FEATURE_ONE"));
			} catch (IOException exception) {
				System.out.println("Local Togglz properties file Not Found at specified location:" + exception);
			}
		}

		FileBasedStateRepository st = null;
		try {
			System.out.println("Create file based state repository.");
			st = new FileBasedStateRepository(loadTogglzFile);			
		} catch (Exception exception) {
			System.out.println(exception);
		}
		
		System.out.println("######### Configured and return file based state repository.  #########");
		return st;
	}

	@Override
	public UserProvider getUserProvider() {
		System.out.println("MyTogglzConfiguration.getUserProvider()");
		return new NoOpUserProvider();
	}

}