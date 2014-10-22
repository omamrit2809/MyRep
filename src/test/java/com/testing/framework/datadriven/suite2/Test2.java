package com.testing.framework.datadriven.suite2;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.testing.framework.datadriven.TestBase;
import com.testing.framework.datadriven.util.Constants;

public class Test2 extends TestBase{


		@Test(dataProvider="getData")
		public void test2(Hashtable<String,String> table){
			validateRunMode("Test1","Suite2",table.get(Constants.RUNMODE_COL));
			
		
	}
}
