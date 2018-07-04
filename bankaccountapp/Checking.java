package bankaccountapp;

public class Checking extends Account
{
	//list properties specific to a checking acct
	//debit card, pin, 2 first char in acct
	private long debitCardNumber;
	private int debitCardPin;
	
	// constructor to initialize checking act properties
	public Checking(String name, String SSN, double initDeposit)
	{
		super (name, SSN, initDeposit);
		acctNumber = "2" + acctNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate()
	{
		//15% of base rate
		//System.out.println("Implement rate for Checking: ");
		rate = getBaseRate() * .15;
	}
	
	// list any methods specific to checking acct
	private void setDebitCard()
	{
		// 12 digit DebitCard Number
		debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
		// 4 digit Pin
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo()
	{
		super.showInfo();
		System.out.println(
				" Your Checking Account Features:" +
				"\n Debit Card Number: " + debitCardNumber +
				"\n Debit Card Pin: " + debitCardPin
				);
	}
}