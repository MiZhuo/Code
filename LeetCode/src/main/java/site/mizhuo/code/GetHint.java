package site.mizhuo.code;

public class GetHint {
    public String getHint(String secret, String guess) {
        char[] bytes = secret.toCharArray();
        char[] bytes2 = guess.toCharArray();
        int len1 = 0,len2 = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < bytes2.length; j++) {
                if(bytes2[j] == bytes[i]){
                    if(i == j){
                        len2 ++;
                    }else{
                        len1 ++;
                    }
                }
            }
        }
        return len2 + "A" + len1 + "B";
    }
}
