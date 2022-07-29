package udemy.bitmanipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int i = 8;
        /*System.out.println(~i);
        System.out.println(3 & 7);
        System.out.println(3 ^ 7);
        System.out.println(5 << 10);
        System.out.println(5 & 1);

        System.out.println(getithBit(3, 3));
        System.out.println(setithBit(3, 3));
        System.out.println(clearithBit(13, 2));
        System.out.println(updateithBit(13, 1, 1));
        System.out.println(clearLastiBits(15, 2));*/
        System.out.println(earthLevels(7));
    }

    private static int getithBit(int n, int i) {
        int mask = (1 << i);
        return (n & mask) > 0 ? 1 : 0;
    }

    private static Integer setithBit(Integer n, int i) {
        int mask = (1 << i);
        n = (n | mask);
        return n;
    }

    private static Integer clearithBit(Integer n, int i) {
        int mask = ~(1 << i);
        n = (n & mask);
        return n;
    }

    private static Integer updateithBit(Integer n, int i, int v) {
        clearithBit(n, i);
        int mask = (v << i);
        return n | mask;
    }

    private static Integer clearLastiBits(Integer n, int cnt) {
        int i = 1;
        int mask = -1;
        mask = mask << cnt;
        return n & mask;
    }

    private static int replaceBitsInNByM(int N, int M, int i, int j) {
        int a = (-1) << j + 1;
        int b = M << i;
        int m = a | b;
        return N & m;
    }

    private static boolean twoPower() {
        return false;
    }

    private static int earthLevels(int n) {
        int s = 1;
        int cnt = 0;
        while (s < n) {
            if (s << 1 > n) {
                break;
            } else {
                s <<= 1;
                cnt++;
            }
        }

        int i = n - s;
        while (s < n) {
            s = s | i;
            cnt++;
            i--;
        }

        return cnt;
    }
}
