package String;

public class SubstringFind {
    public int substring(String large, String small) {
        // Write your solution here
        if(large.length() < small.length()){
            return -1;
        }
        if(small.length() == 0){
            return 0;
        }

        int largePrime = 101;
        int prime = 31;
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        for(int i = 1; i < small.length(); i++){
            seed = (seed * prime % largePrime + 0) % largePrime;
            targetHash = (targetHash * prime % largePrime + small.charAt(i)) % largePrime;
        }

        int hash = 0;
        for(int i = 0; i < small.length();i++){
            hash = (hash * prime % largePrime + large.charAt(i)) % largePrime;
        }

        if(hash == targetHash && equals(large, 0, small)){
            return 0;
        }

        for(int i = 1; i <= large.length() - small.length(); i++){
            int hashValue = hash - seed * large.charAt(i-1) % largePrime;
            hash = nonNegative(hashValue, largePrime);
            hash = (hash * prime + large.charAt(i + small.length() - 1)) % largePrime;
            if(hash == targetHash && equals(large, i, small)){
                return i;
            }
        }
        return -1;
    }

    private int nonNegative(int hash, int largePrime){
        if(hash < 0){
            hash += largePrime;
        }
        return hash;
    }

    private boolean equals(String large, int start, String small){
        for(int i = 0; i < small.length(); i++){
            if(large.charAt(i + start) != small.charAt(i)){
                return false;
            }
        }
        return true;
    }

}
