package bankaccountapp;


public interface IBaseRate 
{
	// write a method returning base rate
	default double getBaseRate()
	{
		return 2.5;
	}
}
