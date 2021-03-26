package lc43;

public class Multiply {
    public static void main(String[] args) {
        Multiply m = new Multiply();
        String a  = m.multiply("123456789", "987654321");
        System.out.println(a);
    }

    public String multiply(String num1, String num2) {
        String ans = "";

        if(num1 != null && num2 != null){
            char[] c1 = num1.toCharArray();
            char[] c2 = num2.toCharArray();
            long num1_int = 0;
            long num2_int = 0;
            for (int i = 0; i < c1.length; i++){
                num1_int += (Long.parseLong(c1[i]+"")) * Math.pow (10, c1.length - i -1);
            }
            System.out.println(num1_int);

//            for (int i = 0; i < c2.length; i++){
//                num2_int += (Long.parseLong(c1[i]+"")) * Math.pow (10, c2.length - i -1) * num1_int;
//            }

            for (int i = 0; i < c2.length; i++){
                num2_int += (Long.parseLong(c2[i]+"")) * Math.pow (10, c2.length - i -1);
            }
            System.out.println(num2_int);
            System.out.println(num1_int*num2_int);
            ans  = (num1_int * num2_int) + " " ;
        }

        return ans;
    }
}
