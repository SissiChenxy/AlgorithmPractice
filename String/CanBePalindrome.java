package String;

public class CanBePalindrome {
        public boolean canBe(String s){
            if(s == null || s.length() == 0){
                return false;
            }

            int[] count = new int[26];
            char[] array = s.toCharArray();
            for(char c: array){
                count[c - 'a']++;
            }

            int odd = 0;
            for(int i : count){
                if(i % 2 == 1){
                    odd++;
                }
            }

            if((s.length() % 2 == 1 && odd == 1) || (s.length() % 2 == 0 && odd == 0)){
                return true;
            }
            return false;
        }

        public void test(){
            System.out.println(canBe("abcd"));
            System.out.println(canBe("aab"));
        }
}
