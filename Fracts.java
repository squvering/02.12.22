public class Fracts {

    public static long NOK(long a, long b) {
        if(a < b) {
            long t = a;
            a = b;
            b = t;
        }
        long nok = a;
        while(!(nok % b == 0)) {
            nok += a;
        }
        return nok;
    }

    public static long NOD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return NOD(b, a % b);
    }

    public static String convertFrac(long[][] lst) {
        long NOK_All = 1;
        for(int i = 0; i < lst.length; i++) {
            long d = NOD(lst[i][0], lst[i][1]);
            lst[i][0] /= d;
            lst[i][1] /= d;
            NOK_All = NOK(lst[i][1],NOK_All);
        }

        String rez = "";
        for(int i = 0; i < lst.length; i++) {
            rez +="(" + lst[i][0] * (NOK_All / lst[i][1]) + "," + NOK_All + ")";
        }
        return rez;
    }

}