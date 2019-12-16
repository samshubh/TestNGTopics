package testutil;

import java.util.ArrayList;

import test.util.Xls_Reader;

public class TestUtil1 {
	
	 
	 public static Xls_Reader reader;
	 
	public static ArrayList<Object[]> getLoginDetailsFromExcel()
	{
		// First we have to create the Array list object which stores the excel values
		
		 ArrayList <Object[]> data = new ArrayList<Object[]>();
		 
		 // Now we have to read the excel sheet from Xls_Reader file
		 
		  try {
			  
	           reader = new Xls_Reader("C:\\Users\\subham\\eclipse-workspace\\NuqiQATesting\\src\\testdata\\Login.xlsx");
		  } catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  int rowCount = reader.getRowCount("TestData1");
		  
		   for(int rowNum=2;rowNum<=rowCount;rowNum++)
		   {
			 String email=   reader.getCellData("TestData1", "Email", rowNum);
			    
			 System.out.println(email);
			  
			 String password=   reader.getCellData("TestData1", "Password", rowNum);
			    
			 System.out.println(password);
			 
			 
			 Object ob[]= {email,password};
			  
			 data.add(ob);
			 
		   }
		   System.out.println(data);
		return data;
	}

}
