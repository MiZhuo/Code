package site.mizhuo.code;

/**
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
 *
 * If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 *
 * Example 1:
 *
 * Input: 48
 * Output: 68
 * Example 2:
 *
 * Input: 15
 * Output: 35
 */
public class SmallestFactorization {
    public int smallestFactorization(int a) {
        // Write your code here
        if(a < 10)
            return a;
        int merchant = 0,Remainder = 0,result = 0,temp = 0,iLoop = 0;
        for(int i = 2; i < 10;i++){
            merchant = a / i;
            Remainder = a % i;
            if(Remainder == 0) {
                if(merchant < 10){
                    result =  i * 10 + merchant;
                    if(result < temp || temp == 0)
                        temp = result;
                }else{
                    String str = String.valueOf(i);
                    str += String.valueOf(smallestFactorization(merchant));
                    try {
                        result = Integer.valueOf(str);
                    }catch (Exception e){
                        result = Integer.MAX_VALUE;
                    }
                    if(result < temp || temp == 0) {
                        temp = result;
                    }
                }
            }
        }
        return temp;
    }
}
