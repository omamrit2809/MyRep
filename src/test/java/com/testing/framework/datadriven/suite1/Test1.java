package com.testing.framework.datadriven.suite1;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.framework.datadriven.TestBase;
import com.testing.framework.datadriven.util.Utility;
import com.testing.framework.datadriven.util.Xls_Reader;

public class Test1 extends TestBase {
	
	@Test(dataProvider="getData")
	public void test1(Hashtable<String,String> table){
		/*Xls_Reader xls= new Xls_Reader("C:\\Users\\om\\Documents\\test documents\\Suite.xlsx");
		System.out.println(Utility.isSuiteRunnable("Suite1", xls));
		System.out.println(Utility.isSuiteRunnable("Suite2", xls));
		System.out.println(Utility.isSuiteRunnable("Suite3", xls));
		
		Xls_Reader xls1= new Xls_Reader("C:\\Users\\om\\Documents\\test documents\\Suite1.xlsx");
		System.out.println(Utility.isTestRunnable("Test1", xls1));
		System.out.println(Utility.isTestRunnable("Test2", xls1));
		System.out.println(Utility.isTestRunnable("Test3", xls1));
		System.out.println(Utility.isTestRunnable("Test4", xls1));
		System.out.println(Utility.isTestRunnable("Test5", xls1));
		*/
		validateRunMode("Test1","Suite1",table.get("Runmode"));
		//table.get("Runmode");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Xls_Reader xls1= new Xls_Reader("C://Users//om//Documents//test documents//Suite1.xlsx");
		return Utility.getData("test1", xls1);
	}

}
