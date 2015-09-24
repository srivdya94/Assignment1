package encdec;

public class Decrypt {
	public String decrypt(String name)
	{
		int length = name.length(); //stores the length of the input
		int splitIndex;
		String[] tokens = new String[2];
		
		if((length%2) == 0) // if the length is even
		{
			splitIndex = length / 2; //gives the length of the substring
			
			tokens[0] = name.substring(0,splitIndex);
			tokens[1] = name.substring(splitIndex);
			
			String dec_str = tokens[1].concat(tokens[0]); //reverse the parts and concatenates the string
			if(dec_str.endsWith("#"))
			{
				dec_str = dec_str.substring(0,length-1);
			}
			return dec_str; //returns the decrypted string 
		} 
		else //if length is odd
		{
			String name1 = name.concat("#"); //concatenate # to the string
			int modifiedStringLength = name1.length(); //store the length 
			splitIndex = modifiedStringLength / 2;
			
			for(int i=0;i<2;i++) //splits the string into two equal parts
			{
				tokens[i] = name1.substring(0,splitIndex);
				//System.out.println(tokens[i]);
				if(tokens[i].endsWith("#")) // removes the # 
				{
					//System.out.println("into if");
					tokens[i] = tokens[i].substring(0,splitIndex-1);
				}
				name1 = name1.substring(splitIndex);
			}
			String dec_str = tokens[1].concat(tokens[0]); //concatenates the parts by reversing them 
			return dec_str;//returns the decrypted string
		}
	}
}
