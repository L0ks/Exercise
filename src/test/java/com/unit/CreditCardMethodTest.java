package com.unit;
import com.component.CardValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CreditCardMethodTest {
    CardValidator CardValidator;
    String validCard    = "4485745763750235";
    String invalidCard  = "1111111111111111";
    int[] arrayResult =         {4, 4, 8, 5, 7, 4, 5, 7, 6, 3, 7, 5, 0, 2, 3, 5};
    int[] arrayDoubleResult =   {8, 4, 16, 5, 14, 4, 10, 7, 12, 3, 14, 5, 0, 2, 6, 5};
    int[] arraySumResult =      {8, 4, 7, 5, 5, 4, 1, 7, 3, 3, 5, 5, 0, 2, 6, 5};

    @Before
    public void setup(){
        CardValidator = new CardValidator();
    }

    @Test
    public void stringConversionCheck(){
        Assert.assertArrayEquals("Credit card string has not been correctly converted to array", arrayResult, CardValidator.convertArray(validCard));
    }

    @Test
    public void arrayDoubleCheck(){
        Assert.assertArrayEquals(
                "Integer array values have not been multiplied by 2, as was expected",
                arrayDoubleResult,
                CardValidator.arrayDigitDouble(arrayResult)
        );
    }

    @Test
    public void arraySumCheck(){
        Assert.assertArrayEquals("Integer array values have not been summed in each position, as was expected",
                arraySumResult,
                CardValidator.arrayDigitSum(arrayDoubleResult)
        );
    }

    @Test
    public void LuhnAlgorithmCheck(){
        Assert.assertTrue("Valid credit card has not passed Luhn algorithm check, as was expected",
                CardValidator.verifyByLuhn(validCard)
        );
    }

    @Test
    public void LuhnAlgorithmNegativeCheck(){
        Assert.assertFalse("Invalid credit card has passed Luhn algorithm check, as was not expected",
                CardValidator.verifyByLuhn(invalidCard)
        );
    }

}
