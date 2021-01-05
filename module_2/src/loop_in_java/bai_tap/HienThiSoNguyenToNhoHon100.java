package loop_in_java.bai_tap;
public class HienThiSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int num = 2;
        while (num <100) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(num);
            }
            num++;
        }
    }
}
