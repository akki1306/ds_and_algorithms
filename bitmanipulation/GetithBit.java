package bitmanipulation;

public class GetithBit {
    public static void main(String[] args) {
        System.out.println(getithBit(2, 1));
    }

    private static int getithBit(int n, int i) {
        int mask = (1 << i);
        return (n & mask) > 0 ? 1 : 0;
    }
}
