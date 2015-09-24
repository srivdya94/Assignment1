package assignmentTests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import encdec.Encrypt;

@RunWith(Parameterized.class)
public class TestClass 
{
   private String inputString;
   private String outputString;
   private Boolean expectedResult;
   private Encrypt encrypt;

   @Before
   public void initialize() 
   {
      encrypt = new Encrypt();
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
   public TestClass(String inputString,String outputString,Boolean expectedResult) 
   {
      this.inputString = inputString;
      this.outputString = outputString;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection encryptParameters() 
   {
      return Arrays.asList(new Object[][] {
         { "sridhar","har#srid",true },
         { "anil","ilan",true },
         { "pavan","an#pav",true }
      });
   }

   @Test
   public void testEncrypt() 
   {
      System.out.println("Input String :" + inputString);
      assertEquals(outputString, encrypt.encrypt(inputString));
   }
   
   
  
}
