package com.testing.framework.datadriven;

import org.testng.SkipException;

import com.testing.framework.datadriven.util.Constants;
import com.testing.framework.datadriven.util.Utility;
import com.testing.framework.datadriven.util.Xls_Reader;

public class TestBase {
	public static void validateRunMode(String TestName, String suiteName,String dataRunmode){
		
		//suite runmode
		boolean isuitRunmode=Utility.isSuiteRunnable(suiteName, new Xls_Reader("C:\\Users\\om\\Documents\\test documents\\Suite.xlsx"));
		boolean testRunmode=Utility.isTestRunnable(TestName,  new Xls_Reader("C:\\Users\\om\\Documents\\test documents\\"+suiteName+".xlsx"));
		boolean dataSetRunmode=false;
		if(dataRunmode.equals(Constants.RUNMODE_YES))
			dataSetRunmode=true;
		
		if(!(isuitRunmode && testRunmode && dataSetRunmode))
			throw new SkipException("Skipping the test "+TestName+" inside the suite "+ suiteName);
	
	}

}
