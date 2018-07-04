package bankaccountapp;
import java.util.List;
import java.util.LinkedList;
public class BankAccountApp 
{
	public static void main(String[]args)
	{
		List<Account> accounts = new LinkedList<Account>();
		
		// read a CSV File then create new acct based on data
		String file = "C:\\Users\\Trixie\\Documents\\ClassFiles\\UdemyJavaProjects\\NewBankAccounts.csv";
		List<String[]> newAcctHolders = utilities.CSV.read(file);
		for (String[] acctHolder : newAcctHolders)
			{
				String name = acctHolder[0];
				String SSN = acctHolder[1];
				String acctType = acctHolder[2];
				double initDeposit = Double.parseDouble(acctHolder[3]);
				
				if (acctType.equals("Savings"))
				{
					//System.out.println("OPEN A SAVINGS ACCOUNT");
					accounts.add(new Savings(name, SSN, initDeposit));
				}
				else if (acctType.equals("Checking"))
				{
					//System.out.println("OPEN A CHECKING ACCOUNT");
					accounts.add(new Checking(name, SSN, initDeposit));
				}
				else 
				{
					System.out.println("ERROR READING ACCOUNT TYPE");
				}
				
			}
		
		//accounts.get(5).showInfo();
		
		for (Account acct : accounts)
		{
			System.out.println("\n***********************************");
			acct.showInfo();
		}
		//accounts.get((int) Math.random() * accounts.size()).deposit(1000);
		
	}
	
}
