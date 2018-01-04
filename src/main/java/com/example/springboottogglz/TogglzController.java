package com.example.springboottogglz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
@RequestMapping("togglztest")
public class TogglzController {

	@Autowired
	private FeatureManager featureManager;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("@@@@@@@@@@@@  TogglzController.index()  @@@@@@@@@@@@@");
	    if (featureManager.isActive(MyFeatures.FEATURE_ONE)) {
	         System.out.println("@@@@@@@@@   FEATURE_ONE Enable");
	    } else {
	    	System.out.println("@@@@@@@@@   FEATURE_ONE Disable");
	    }
	    if (featureManager.isActive(MyFeatures.FEATURE_TWO)) {
	    	System.out.println("@@@@@@@@@   FEATURE_TWO Enable");
	    } else {
	    	System.out.println("@@@@@@@@@   FEATURE_TWO Disable");	    	
	    }
	    return "index";
	}
	
}
