package encdec;
import java.util.*;

public class source
{
	static TreeMap<String, String> m1 = new TreeMap<String, String>();
	static String input="";
	
	public static void main(String args[])
	{
		Scanner obj = new Scanner(System.in);
		int operationToBeDone;
		String modifiedData="";
		
		while(true) //loop forever waiting for a user input
		{
			System.out.println("Select 1 for encryption and 2 for decryption");		
			operationToBeDone = selectOperation();
			if(operationToBeDone>=3 || operationToBeDone <= 0)
			{
				System.out.println("Incorrect Input Please check your input");
				continue;
			}
	
			System.out.println("Enter your input");
			input  = obj.nextLine(); // takes the input to be encrypted or decrypted
			
			if(operationToBeDone == 1)
			{
				System.out.println("encrypting " + input);
				int flag = cacheProcess();
				if(flag == 1)
				{
					continue;
				}
				else
				{
					System.out.println("adding to cache");
					modifiedData = encryptProcess();
					System.out.println("result = " + modifiedData);
				}
				
			}
			 
			else if(operationToBeDone == 2)
			{
				System.out.println("decrypting " + input );
				int flag = cacheProcess();
				if(flag == 1)
				{
					continue;
				}
				else
				{
					System.out.println("adding to cache");
					modifiedData = decryptProcess();
					System.out.println("result = " + modifiedData);
				}
			}
			//System.out.println(m1);
			m1.put(input,modifiedData);
		}
	}
	
	public static int selectOperation()
	{
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		return option;
	}
	
	public static int cacheProcess()
	{
		int flag = 0;
		if(m1.containsKey(input))
		{
			flag++;
			System.out.println(input + " found in cache");
			System.out.println("result = " + m1.get(input));
		}
		Set set = m1.entrySet();
		Iterator i = set.iterator();
		if(m1.containsValue(input))
		{
			flag++;
			while(i.hasNext())
			{
				Map.Entry me = (Map.Entry)i.next();
				if(input.equals(me.getValue()))
				{
					System.out.println(input + " found in cache");
					System.out.println("result = " + me.getKey());
				}
			}
		}
		return flag;
	}
	
	public static String encryptProcess()
	{
		Encrypt encryptObj = new Encrypt();
		String result = encryptObj.encrypt(input);
		return result;
	}
	public static String decryptProcess()
	{
		Decrypt decryptObj = new Decrypt();
		String result = decryptObj.decrypt(input);
		return result;
	}
}
