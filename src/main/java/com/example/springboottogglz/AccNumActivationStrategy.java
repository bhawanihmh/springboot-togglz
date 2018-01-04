package com.example.springboottogglz;

import java.util.List;
import org.togglz.core.activation.Parameter;
import org.togglz.core.activation.ParameterBuilder;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.util.Strings;

/**
 * account number activation strategy
 * 
 * @author Bhawani Singh
 * @date Nov, 2017
 *
 */
public class AccNumActivationStrategy  implements ActivationStrategy {


	/** ID  **/
	public static final String ID = "accNum";
	
	/** ACC_NUMS  **/
	public static final String ACC_NUMS = "accNums";
	    
    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "Account Number";
    }

    @Override
    public Parameter[] getParameters() {
        return new Parameter[] {
                ParameterBuilder.create(ACC_NUMS).label("Account Number").largeText()
                    .description("A list of account numbers for which the feature is active.")
        };
    }

    @Override
    public boolean isActive(FeatureState featureState, FeatureUser accUser) {

    	String accNumsAsString = featureState.getParameter(ACC_NUMS);

        if (Strings.isNotBlank(accNumsAsString)) {

            List<String> accNums = Strings.splitAndTrim(accNumsAsString, ",");

            if (accUser != null && Strings.isNotBlank(accUser.getName())) {
                for (String accNum : accNums) {
                    if (accNum.equals(accUser.getName())) {
                    	System.out.println(accUser.getName() +  " is valid account number");
                        return true;
                    }
                }
            }

        }
        return false;

    }

}