import java.util.Arrays;

class Emirps {

    public static boolean isNumPalindrom(long n) {
        String str = "" + n, s = "";
        for(int i=str.length() - 1; i >= 0; i--) {
            s += str.charAt(i);
        }
        return str.equals(s);
    }

    public static long reverse(long n) {
        long rez = 0;
        String str = "" + n, s = "";
        for(int i=str.length() - 1; i >= 0; i--) {
            s += str.charAt(i);
        }
        for(int k = 0; k < s.length(); k++){
            rez *= 10;
            rez += s.charAt(k) - '0';
        }

        return rez;
    }

    public static boolean isNumPrime(long n) {
        for(long i=2; i < (long)Math.sqrt(n) + 1; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static long[] findEmirp(long n){
        long k = 13;
        long[] rez = {0, 0, 0};

        while(k <= n) {
            if(isNumPalindrom(k)){
                k+=2;
                continue;
            }
            if(isNumPrime(k) && isNumPrime(reverse(k))) {
                rez[2] += k;
                rez[0]++;
                if(rez[1] < k)
                    rez[1] = k;
            }

            k+=2;
        }

        return rez;
    }
}