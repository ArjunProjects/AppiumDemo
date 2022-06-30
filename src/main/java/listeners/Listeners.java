package listeners;

import java.io.IOException;
import practise.AppiumFramework.Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	 @Override		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub	
	    	
	    	
	        		String s=result.getName();
//	        		try {
//					Base.getScreen(s);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub
	    	System.out.println("I successfully executed listeners ");
	        		
	    }		
	}		
	


