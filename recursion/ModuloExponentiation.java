package recursion;

public class ModuloExponentiation {
    public static void main(String[] args) {
        System.out.println(moduloExponentiation(5, 1000, (long) (1e9+7)));
    }

    private static long moduloExponentiation(int a, int b, long C) {
        if (a == 0) return 0;
        if (b == 0) return 1;

        long y;
        if (b % 2 != 0) {
            y = ((a % C) * (moduloExponentiation(a, b - 1, C) % C)) % C;
        } else {
            y = (moduloExponentiation(a, b / 2, C));
            y = (y * y) % C;
        }
        return y;
    }
}
