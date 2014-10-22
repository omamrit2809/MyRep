package com.testing.framework.datadriven.util;
import java.util.Hashtable;

public class Utility {
	
	private static final Object TestCases = null;
	public static boolean isSuiteRunnable(String suiteName, Xls_Reader xls){
		int rows = xls.getRowCount(Constants.SUITE_SHEET);
		
		for(int rNum=2;rNum<=rows;rNum++){
			String data = xls.getCellData(Constants.SUITE_SHEET,Constants.SUITENAME_COL, rNum);
			if(data.equals(suiteName)){
				String runmode = xls.getCellData(Constants.SUITE_SHEET,Constants.RUNMODE_COL, rNum);
				if(runmode.equals(Constants.RUNMODE_YES))
					return true;
				else
					return false;
			}
				
		}
		return false;
	}
	public static boolean isTestRunnable(String TestCase, Xls_Reader xls){
		int rows = xls.getRowCount(Constants.TESTCASES_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
		String testNameXls = xls.getCellData(Constants.TESTCASES_SHEET,Constants.TESTCASES_COL, rNum);
		if(testNameXls.equals(TestCase)){
			String Runmode = xls.getCellData(Constants.TESTCASES_SHEET,Constants.RUNMODE_COL, rNum);
			if(Runmode.equals(Constants.RUNMODE_YES))
				return true;
			else
					return false;
			}
		
	}
		
			return false;
	}
	
	public static Object[][] getData(String testName, Xls_Reader xls){
		int rows= xls.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total Rows are  "+rows);
		
		//row number for testcase
		
		int testCaseRowNumber=1;
		for(testCaseRowNumber=1;testCaseRowNumber<=rows;testCaseRowNumber++){
			String testNameXls=xls.getCellData(Constants.DATA_SHEET, 0, testCaseRowNumber);
			if(testNameXls.equalsIgnoreCase(testName))
				break;
		}
		
		System.out.println("Test starts from row number--"+testCaseRowNumber);
		int dataStartRowNum=testCaseRowNumber+2;
		int colStartRowNum=testCaseRowNumber+1;
		
		//rows of data
		int testRows=5;
		while(!xls.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Totalrows of data are --"+testRows);
		
		//cols of data
		int testCols=0;
		while(!xls.getCellData(Constants.DATA_SHEET, testCols, colStartRowNum).equals("")){
			testCols++;
		}
		Object[][] data=new Object[testRows][1];
		System.out.println("Total cols of data are --"+testCols);
		int r=0;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			Hashtable<String, String> table= new Hashtable<String, String>();
			for(int cNum=0;cNum<testCols;cNum++){
				//System.out.println(xls.getCellData(Constants.DATA_SHEET, cNum, rNum));
				//data[r][cNum]= xls.getCellData(Constants.DATA_SHEET, cNum, rNum);
				table.put(xls.getCellData(Constants.DATA_SHEET, cNum, colStartRowNum), xls.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
			data[r][0]=table;
			r++;
		}
		return data;
	}
}
