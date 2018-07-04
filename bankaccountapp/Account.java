package bankaccountapp;

public abstract class Account implements IBaseRate
{
	// list common properties for savings & checkings
	//name, SS, type, balance etc
	private String name;
	private String SSN;
	private double balance;
	
	private static int index = 10000;
	
	protected String acctNumber;
	protected double rate;
	
	// constructor to set base properties & initialize acct
	public Account(String name, String SSN, double initDeposit)
	{
		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;

		//set acct number
		index++;
		this.acctNumber = setAcctNumber();	
		
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAcctNumber()
	{
		String lastTwoSSN = SSN.substring(SSN.length()-2, SSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoSSN + uniqueID + randomNumber;
	}
	
	public void compound()
	{
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}

	
	//list common methods: transactions
	public void deposit(double amount)
	{
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	public void withdraw(double amount)
	{
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	public void transfer(String toWhere, double amount)
	{
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	public void printBalance()
	{
		System.out.println("Your balance is now: $" + balance);
	}
	public void showInfo()
	{
		System.out.println( 
				"NAME: " + name + 
				"\nACCOUNT NUMBER: " + acctNumber +
				"\nSSN: " + SSN + 
				"\nBALANCE: $" + balance +
				"\nRATE: " + rate + "%");
	}
}