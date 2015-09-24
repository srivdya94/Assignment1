package assignmentTests;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import encdec.Decrypt;

@RunWith(Parameterized.class)
public class decryptTestClass 
{
   private String inputString;
   private String outputString;
   private Boolean expectedResult;
   private Decrypt decrypt;

   @Before
   public void initialize() 
   {
	   decrypt = new Decrypt();
   }
   
   public decryptTestClass(String inputString,String outputString,Boolean expectedResult) 
   {
      this.inputString = inputString;
      this.outputString = outputString;
      this.expectedResult = expectedResult;
   }
   
   @Parameterized.Parameters
   public static Collection decryptParameters() 
   {
      return Arrays.asList(new Object[][] {
         {"har#srid","sridhar",true },
         { "ilan","anil",true },
         { "an#pav","pavan",true }
      });
   }
   
   @Test
   public void testDecrypt() 
   {
      System.out.println("Input String :" + inputString);
      assertEquals(outputString, decrypt.decrypt(inputString));
   }
}
