package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p></p>
     */
    public static Object defaultWaitTime
     
    /**
     * <p></p>
     */
    public static Object screenshorts
     
    /**
     * <p></p>
     */
    public static Object patientCallerId
     
    /**
     * <p></p>
     */
    public static Object patientCalledTo
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            baseUrl = selectedVariables['baseUrl']
            defaultWaitTime = selectedVariables['defaultWaitTime']
            screenshorts = selectedVariables['screenshorts']
            patientCallerId = selectedVariables['patientCallerId']
            patientCalledTo = selectedVariables['patientCalledTo']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
