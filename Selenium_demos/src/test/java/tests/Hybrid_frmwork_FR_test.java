package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.Hybrid_frmwork_FR_page;

public class Hybrid_frmwork_FR_test extends Hybrid_frmwork_FR_page
{
	public static void main(String args[]) throws InterruptedException, IOException
	{	
		String[][] steps ;
		String[][] data ;
		
		//steps = excelread(System.getProperty("user.dir") +"\\src\\test\\java\\Excelfiles\\test_keyword.xlsx");
		steps = excelread("D:\\excelConfig\\test_keyword.xlsx");
		data = excelread(System.getProperty("user.dir") +"\\src\\test\\java\\Excelfiles\\test_data.xlsx");
		
		WebDriver driver = null; 
		double price ;
		String itin ;
		
		for (int k = 1; k < data.length; k++) 
		{
			for (int i = 1; i < steps.length; i++)
			{
				String para = null;
				if(steps[i][0].equalsIgnoreCase("Y"))
				{
					switch (steps[i][4])
					{
						case	"open_browser":
							driver = open_browser(steps[i][7]);
							break;
						
						case	"navigate_to":
							navigate_to(driver, steps[i][7]);
							break;
							
						case	"click_element":
							click_element(driver, steps[i][5],steps[i][6]);
							break;
							
						case	"send_keys":
							if(steps[i][3].contains("From"))
								para = data[k][0];
							
							if(steps[i][3].contains("To"))
								para = data[k][1];
							
							if(steps[i][3].contains("Leave"))
								para = data[k][2];
							
							if(steps[i][3].contains("Return"))
								para = data[k][3];
							
							send_keys(driver,steps[i][5],steps[i][6] , para);
							break;
						/*	
						case	"verify_element":
							verify_element(driver, steps[i][5], steps[i][6]);
							break;
						
						case	"store_text":
							String sprice = store_text(driver, steps[i][5], steps[i][6]);
							price = Double.parseDouble(sprice.replaceAll("total", "").replaceAll("\\n", "").replace("per person", "").replace("$", "").replace("," ,  "")) ;
							itin = "Using " + steps[i][1] + " From " + data[k][0] + " To " + data[k][1] + " Leave Date " + data[k][2] + " Return Date " + data[k][3] ;
					 		System.out.println ("For " + itin + " The Price is " +   price) ;
					 		
							break;
							*/
							
						case	"close_browser":
							close_browser(driver);
							break;
					} 	// end of switch 
				}	// end of if
			}	//end of step for loop 
		}
	}
}
		
		
		/*
		for (int k = 1 ; k < data.length ; k++)
		{ 
			  for ( int i = 1 ; i < steps.length ; i++)
			  {
				 String param = null ;
				 if (steps[i][0].equalsIgnoreCase("Y")) 
				 {
					 switch (steps[i][4]) 
					 {
					    case "open_browser" :				       
					    	wd = open_browser(steps[i][7]) ;
					    	break ;
					 	case "navigate_to" :
					 		navigate_to(wd,steps[i][7]) ;
					 		break ;
					 	case "click_element" :					
					 		click_element(wd,steps[i][5], steps[i][6]) ; 
					 		break ;
					 	case "send_keys" : 				 		
					 		if (steps[i][3].contains("From"))
								param = data[k][0] ;
					 		if (steps[i][3].contains("To")) param = data[k][1] ;
					 		if (steps[i][3].contains("Leave")) param = data[k][2] ;
					 		if (steps[i][3].contains("Return")) param = data[k][3] ;				 		
					 		send_keys(wd,steps[i][5], steps[i][6],param) ; 
						    break ;
					 	case "verify_element" : 
					 		verify_element(wd,steps[i][5],steps[i][6]) ;
					 		break ;
					 	case "store_text" :				
					 			String sprice = store_text(wd,steps[i][5], steps[i][6]) ;
					 			price = Double.parseDouble(sprice.replaceAll("total", "").replaceAll("\\n", "").replace("per person", "").replace("$", "").replace("," ,  "")) ;
					 			itin = "Using " + steps[i][1] + " From " + data[k][0] + " To " + data[k][1] + " Leave Date " + data[k][2] + " Return Date " + data[k][3] ;
					 			System.out.println ("For " + itin + " The Price is " +   price) ;	
					 			break ;
					 	case "close_browser" : 
					 			
					 			close_browser(wd) ;
					 			break ;
					 }
				 } 		 
			  } 
			}	
		}
	}*/