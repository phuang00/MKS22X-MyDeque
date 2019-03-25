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
          double second = nums.removeLast();
          nums.addLast(nums.removeLast() - second);
        }
        else if (token.equals("*")){
          double second = nums.removeLast();
          nums.addLast(nums.removeLast() * second);
        }
        else if (token.equals("/")){
          double second = nums.removeLast();
          nums.addLast(nums.removeLast() / second);
        }
        else if (token.equals("%")){
          double second = nums.removeLast();
          nums.addLast(nums.removeLast() % second);
        }
        else{
          nums.addLast(Double.parseDouble(token));
        }
        //System.out.println(nums);
      }
      return nums.getFirst();
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
