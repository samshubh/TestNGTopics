package testutil;

import java.util.ArrayList;

import test.util.Xls_Reader;

public class TestUtil {
	
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
	public static Xls_Reader reader;
	
	 
	public static ArrayList <Object[]> getDataFromExcelSheet()
	{
		// First we have to create the array list object 
		
		 ArrayList <Object[]> data = new ArrayList<Object[]>();
		 
		 
		 try {
			 
			reader = new Xls_Reader("C:\\Users\\subham\\eclipse-workspace\\NuqiQATesting\\src\\testdata\\ExcelSheet.xlsx");
			 
		 }catch(Exception e)
		 {
			e.printStackTrace(); 
		 }
	    
		 
		 // Now get the row count 
		 
		   int rowCount = reader.getRowCount("TestData1");
		   
		   for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			   
			       String fname = reader.getCellData("TestData1", "Firstname", rowNum);
				
				   System.out.println(fname);
				  
				   String lname =  reader.getCellData("TestData1", "Lastname",rowNum);
				  
				   System.out.println(lname);
				   
				   String address =  reader.getCellData("TestData1", "Address",rowNum);
					  
				   System.out.println(address);
				   
				   String city =  reader.getCellData("TestData1", "City",rowNum);
					  
				   System.out.println(city);
				   
				   String state =  reader.getCellData("TestData1", "StateT", rowNum);
					  
				   System.out.println(state);
				   
				   String pincode =  reader.getCellData("TestData1", "Pincode", rowNum);
				  
				   System.out.println(pincode);
		 
		   Object obj[] = {fname,lname,address,city,state,pincode};
		   
		   data.add(obj);
		}
	
	      return data;
		}
}