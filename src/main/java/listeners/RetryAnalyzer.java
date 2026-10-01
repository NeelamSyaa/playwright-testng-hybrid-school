package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer {
	    private int count = 0;
	    private static final int MAX_RETRY_COUNT = 2; // Retries a failed test up to 2 times

	    @Override
	    public boolean retry(ITestResult result) {
	        if (!result.isSuccess()) {
	            if (count < MAX_RETRY_COUNT) {
	                count++;
	                System.out.println("🔄 Retrying test " + result.getName() + " | Attempt " + count + " of " + MAX_RETRY_COUNT);
	                return true;
	            }
	        }
	        return false;
	    }
	}

