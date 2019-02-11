## secretAdditiveCheck

### Description
The description and requirements were given as follows:
```
You are given a function 'secret()' that accepts a single integer parameter and returns an integer. 
In your favorite programming language, write a command-line program that takes one command-line argument 
(a number) and determines if the secret() function is additive [secret(x+y) = secret(x) + secret(y)], 
for all combinations x and y, where x and y are all prime numbers less than the number passed via the 
command-line argument.  Describe how to run your examples. Please generate the list of primes without 
using built-in functionality.
```
### Solution
The solution for this problem was broken up into three main sections: finding primes, finding combinations, and determining if each combination is additive.

#### Finding Primes
In order to find prime numbers, a rule was used that all non-prime numbers are made up of factors of 2, 3, 5, and 7.
Any values that are not divisible by these value (and are not these values) is considered to be prime. 
The for loop:
```
for (int i = 2; i < input; i++)
	{
		if((i%2 == 0) && (i != 2)){}
		else if((i%3 == 0) && (i != 3)){}
		else if((i%5 == 0) && (i != 5)){}
		else if((i%7 == 0) && (i != 7)){}			
		else 
		{
		  primes.add(i);
		}
  }
```
Goes through each value up until the max value, and checks its remainder with values 2, 3, 5, and 7. When there is no remainder and the value does not equal the divisor, then that value is prime. The prime number is then added to the ArrayList of prime integers.

#### Finding Combinations and secret() Call
All combinations of the generated list of primes is then checked with the secret() function to check whether that combination is additive. The for loop below was written in such a way that avoids the inefficiency of rechecking already-checked combinations.
```
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
```
If a false is detected, then the function is not additive and the false is returned (exiting the loop).
If all combinations have been checked and are additive, then the function is considered as additive.

#### secret() Function
The secret() function is the undefined function that the program is checking in whether or not it is additive.
It accepts a single integer parameter and returns an integer. For this project, the default function returns
the same value that it was sent.
```
private static int secret(int value)
{
	return value;
}
```

### Examples
A number of functions were tested in order to assure the validity of the program. The following examples were tested
and their results given.
##### secret() Function 1
```
private static int secret(int value)
{
	return value;
}
```
This returns that the function **is** additive, and this is because this essentially performs a sum function. 
```
if x = 9 and y = 2 :

secret1 = secret(9+2) --> Returns 9+2 or 13
secret2 = secret(9) + secret(2) --> Returns 9+2 or 13
(9+2) = 9 + 2
```
##### secret() Function 2
```
private static int secret(int value)
{
	return 1;
}
```
This returns that the function **is not** additive, and this is because this essentially performs this operation for each combination:
```
(1) = (1) + (1)
```

### How to Run from Windows Command Line

```
Note: This program requires a Java JRE or JDK in order to run it from Windows command line.
```

1) Download the zip folder from the GitHub repository page.

2) Unzip the folder in desired directory.

3) Open Windows command prompt.

4) Navigate to the directory with unzipped folder in command prompt.

5) Type "dir" as command to ensure both AdditiveChecker.java and AdditiveChecker.class are in current directory.

6) Find and set path where Java JRE or JDK is located.
```
Example    C:\mywork> set path=%path%;C:\Program Files\Java\jdk1.5.0_09\bin
```
7) In the case that you need to recompile the class file, type:
```
javac AdditiveChecker.java
```
8) In order to run the program, type:
```
java AdditiveChecker int
```
**Note:** The **int** above is not the true input. An integer of the user's choice must be given, as this is the value where all prime numbers being used must be less than.


If the user does not have a Windows OS or would like to run it on an IDE, 
any IDE able to compile and run Java files can be used. 
However, the command-line (or "arguments") functionality of each IDE must be understood, as this
program needs an input from the command-line in order to work.
