package DFS.Permutations;

public class ChainedStrings {
    public boolean chained(String[] strings){
        if(strings == null || strings.length == 0){
            return false;
        }
        if(strings.length == 1 && canChain2(strings)){
            return true;
        }

        boolean[] result = new boolean[1];
        helper(strings, 0, result);
        return result[0];
    }

    private void helper(String[] strings, int index, boolean[] result){
        if(index == strings.length && canChain2(strings)){
            result[0] = true;
            return;
        }

        for(int i = index; i < strings.length; i++){
            swap(strings, index, i);
            helper(strings, index + 1, result);
            swap(strings, index, i);
        }
    }

    private boolean canChain(String a, String b){
        return a.charAt(0) == b.charAt(b.length()-1) ? true : false;
    }

    private boolean canChain2(String[] strings){
        String a;
        String b;
        for(int i = 0; i < strings.length - 1; i++){
            a = strings[i];
            b = strings[i+1];
            if(a.charAt(a.length() - 1) != b.charAt(0)){
                return false;
            }
        }
        a = strings[0];
        b = strings[strings.length - 1];
        return b.charAt(b.length() - 1) == a.charAt(0);
    }

    private void swap(String[] strings, int a, int b){
        String temp = strings[a];
        strings[a] = strings[b];
        strings[b] = temp;
    }

    public void test1(){
        String[] s = {"aab", "bbb", "baa"};
        System.out.println(chained(s));
    }
}
