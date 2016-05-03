import java.util.ArrayList;

public class AdditiveChecker {
	    
	public static void main (String[] args) 
	{
		
                int input = Integer.parseInt(args[0]);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Boolean isAdditive;
		
                //Check to make sure input is appropriate.
                if (input < 1)
                {
                    System.out.println("Inappropriate input. Please input a positive integer.");
                    System.exit(0);
                }
                else if (input == 1)
                {
                    System.out.println("No prime numbers in list.");
                    System.exit(0);
                }
                
		for (int i = 2; i < input; i++)
		{
			/*
			 * All non-prime numbers are made up of factors of 2, 3, 5, and 7. 
			 * Therefore, any numbers that are not divisible by these 
			 * values (or are these values) are prime.
			 */
				if((i%2 == 0) && (i != 2)){}
				else if((i%3 == 0) && (i != 3)){}
				else if((i%5 == 0) && (i != 5)){}
				else if((i%7 == 0) && (i != 7)){}
				else 
				{
					primes.add(i);
				}
		}

		isAdditive = additiveCheck(primes);
                if (isAdditive == true)
                    System.out.println("secret() function is additive.");
                else
                    System.out.println("secret() function is not additive.");
	}

	/*
	 * This method loops through all combinations of the primes
	 * in the list without repeating any combinations. 
	 * The values for secret(x+y) and secret(x)+secret(y) are
	 * both compared, and the function immediately stops if
	 * a false is detected. If a false is not detected, then the 
	 * function is considered to additive for the list of primes.
	 */
	private static Boolean additiveCheck(ArrayList<Integer> primes)
	{
		for (int i = 0; i < primes.size(); i++)
		{
			for (int j = i; j < primes.size(); j++)
			{
				int secret1 = secret(primes.get(i) + primes.get(j));
				int secret2 = secret(primes.get(i)) + secret(primes.get(j));
				if (secret1 == secret2){}
				else
					return false;
			}
		}
		return true;
	}
	
	private static int secret(int value)
	{
            return value;
	}
}
