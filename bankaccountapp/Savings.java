package bankaccountapp;

public class Savings extends Account
{
	//list properties specific to saving acct
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	
	//constructor to initialize settings for saving properties
	public Savings(String name, String SSN, double initDeposit)
	{
		super (name, SSN, initDeposit);
		acctNumber = "1" + acctNumber;
		setSafetyDepositBoxID();
	}
	

	@Override
	public void setRate()
	{
		// .25 less than base rate
		//System.out.println("Implement rate for Savings");
		rate = getBaseRate() - .25;
	}

	
	//list methods specific to saving acct
	private void setSafetyDepositBoxID()
	{
		// 3 digit ID
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		// 4 digit Key
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
		
	}	
	
	public void showInfo()
	{
		//System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println(
				" Your Savings Account Features:" +
				"\n Safety Deposit Box ID: " + safetyDepositBoxID +
				"\n Safety Deposit Box Key: " + safetyDepositBoxKey
				);
		
	}
	
	
}