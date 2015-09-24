package encdec;

public class Encrypt {
	
	public String encrypt(String name)
	{
		int length = name.length(); //stores the length of the input
		int splitIndex;
		String[] tokens = new String[2];
		
		if((length%2) == 0) //checks whether the length is even or not.. IF YES
		{
			splitIndex = length / 2; 
			
			tokens[0] = name.substring(0,splitIndex);// each part is stored in the token array
			tokens[1] = name.substring(splitIndex);
			
			String enc_str = tokens[1].concat(tokens[0]); //concatenates the string by reversing the parts
			return enc_str; //returns the encrypted string
		} 
		
		else //if the length is odd then...
		{
			String name1 = name.concat("#"); // adds # to make the length even 
			int modifiedStringLength = name1.length();//stores the length of the modified string
			splitIndex =  modifiedStringLength/ 2;//gives the substring length
			
			tokens[0] = name1.substring(0,splitIndex);// each part is stored in the token array
			tokens[1]= name1.substring(splitIndex); 
			
			String enc_str = tokens[1].concat(tokens[0]); //concatenates the string by reversing the parts
			return enc_str;//returns the encrypted string
		}
	}
}
