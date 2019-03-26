import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> nums = new MyDeque<>();
      // create a new MyDeque, nums
      String[] tokens = s.split(" ");
      // split the string based on spaces
      for (String token: tokens){
        // for every token in the String array
        try{
          nums.addLast(Double.parseDouble(token));
          // try to parse the token and add it to nums
        }catch (NumberFormatException e){
          // if it's not a double
          double second = nums.removeLast();
          // remove last element of nums (the second number of the operation, hence second)
          double first = nums.removeLast();
          // remove last element again (the first number of the operation, hence first)

          // perform the proper operations to first and second based on the operator
          // and add it back to nums
          if (token.equals("+")){
            nums.addLast(first + second);
          }
          else if (token.equals("-")){
            nums.addLast(first - second);
          }
          else if (token.equals("*")){
            nums.addLast(first * second);
          }
          else if (token.equals("/")){
            nums.addLast(first / second);
          }
          else{
            nums.addLast(first % second);
          }
          //
        }
        //System.out.println(nums);
      }
      return nums.getFirst();
      // return the first (and only) element in nums
    }

    public static void main(String[] args) {
      String[] expressions = new String[] {"2 4 71 8.5 + - * 5 +",
                                           "1 2 /", "10 2.0 +",
                                           "11 3 - 4 + 2.5 *",
                                           "8 2 + 99 9 - * 2 + 9 -",
                                           "1 2 3 4 5 + * - -"};
      for (String exp: expressions){
        System.out.println(exp + " = " + eval(exp));
      }
    }
}
