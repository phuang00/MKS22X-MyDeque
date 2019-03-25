public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> nums = new MyDeque<>();
      String[] tokens = s.split(" ");
      for (String token: tokens){
        if (token.equals("+")){
          double second = nums.removeLast();
          nums.addLast(nums.removeLast() + second);
        }
        else if (token.equals("-")){

        }
        else if (token.equals("*")){

        }
        else if (token.equals("/")){

        }
        else if (token.equals("%")){

        }
        else{
          nums.addLast(Double.parseDouble(token));
        }
        System.out.println(nums);
      }
      return -1;
    }

    public static void main(String[] args) {
      eval("2 4 71 8.5 + - * 5 +");
    }
}
