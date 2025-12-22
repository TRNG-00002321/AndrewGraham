package monday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.mockito.internal.util.StringUtil;

public class StringTest {

    @Test
    public void reverse_positive_test(){

        String input_str = "abc";
        String expected_str = "cba";

        String actual_str = StringUtils.reverse(input_str);

        Assertions.assertEquals(expected_str,actual_str);

    }
    @Test
    public void reverse_negative_test(){

        String input_str = "abc";
        String expected_str = "abc";

        String actual_str = StringUtils.reverse(input_str);

        Assertions.assertNotEquals(expected_str,actual_str);

    }

    @Test
    public void isEmpty_test_positive(){
        String input_str = null;
        Assertions.assertTrue(StringUtils.isEmpty(input_str));
    }
    @Test
    public void isEmpty_test_positive1(){
        Assertions.assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void isEmpty_test_negative(){
        Assertions.assertFalse(StringUtils.isEmpty("input_str"));
    }

    public void isBlank_test_positive(){
        String input_str = "";
        boolean expected_str = true;

        boolean actual_str = StringUtils.isBlank(input_str);

        Assertions.assertEquals(expected_str,actual_str);
    }

    @Test
    public void isBlank_test_negative(){
        String input_str = "asdf";
        boolean expected_str = false;

        boolean actual_str = StringUtils.isBlank(input_str);

        Assertions.assertEquals(expected_str,actual_str);
    }

    @Test
    public void findFirst_test_positive(){
        String[] input_str_arr = {"abc", "def", "ghi", "jkl", "mno", "pqr", "tuv", "wxyz"};
        String input_str = "j";

        Assertions.assertNotNull(StringUtils.findFirst(input_str_arr, input_str));
    }

    @Test
    public void findFirst_test_negative1(){
        String[] input_str_arr = {"abc", "def", "ghi", "jkl", "mno", "pqr", "tuv", "wxyz"};
        String input_str = "b";
        //String expected_str = null;

        String actual_str = StringUtils.findFirst(input_str_arr, input_str);
        Assertions.assertNull(actual_str);
    }

    @Test
    public void findFirst_test_negative2(){
        String[] input_str_arr = {};
        String input_str = "b";
        //String expected_str = null;

        String actual_str = StringUtils.findFirst(input_str_arr, input_str);
        Assertions.assertNull(actual_str);
    }

    @Test
    public void split_test_positive(){
        String input_str = "this is a sentence";
        String input_delim = " ";

        String[] expected_str = {"this", "is","a", "sentence"};

        Assertions.assertArrayEquals(expected_str,StringUtils.split(input_str,input_delim));

    }

    @Test
    public void split_test_negative1(){
        String input_str = null;
        String input_delim = "d";

        String[] expected_str = new String[0];

        Assertions.assertArrayEquals(expected_str,StringUtils.split(input_str,input_delim));
    }

    @Test
    public void split_test_negative2(){
        String input_str = "test input";
        String input_delim = "d";

        String[] expected_str = {"test input"};

        Assertions.assertArrayEquals(expected_str,StringUtils.split(input_str,input_delim));
    }

    @Test
    public void split_test_negative3(){
        String input_str = "";
        String input_delim = "";

        String[] expected_str = {""};

        Assertions.assertArrayEquals(expected_str,StringUtils.split(input_str,input_delim));
    }

    @Test
    public void capitalize_test_positive(){
        String input_str = "string";
        String expected_str = "String";
        Assertions.assertEquals(expected_str, StringUtils.capitalize(input_str));
    }

    @Test
    public void capitalize_test_positive1(){
        String input_str = "4tring";
        String expected_str = "4tring";
        Assertions.assertEquals(expected_str,StringUtils.capitalize(input_str));
    }



}
