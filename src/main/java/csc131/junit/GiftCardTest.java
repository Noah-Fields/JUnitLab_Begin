package csc131.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class GiftCardTest
{
	@Test
	public void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;

		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",
				issuingStore, card.getIssuingStore());
	}
	
	@Test
	public void getBalance()
	{
		double balance;
		double tolerance;
		GiftCard card;
		int issuingStore;

		issuingStore = 1337;
		balance = 100.00;
		tolerance = 0.001;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), tolerance);
	}
	
	@Test
	public void deduct()
	{
		double balance;
		double amount;
		GiftCard card;
		int issuingStore;

		issuingStore = 1337;
		balance = 100.00;
		amount = 30.00;
		card = new GiftCard(issuingStore, balance);
		
		String      result;
        
        if (amount < 0.0)
        {
            result = "Invalid Transaction";
        }
        else
        {
            balance -= amount;
            
            if (balance < 0.0)
            {
                result = "Amount Due: " + String.format("%6.2f",
                                                        Math.abs(balance));
                balance = 0.0;
            }
            else
            {
                result = "Remaining Balance: " + String.format("%6.2f",
                                                         Math.abs(balance));
            }
        }
		
		assertEquals("deduct()", result, card.deduct(amount));
	}
}