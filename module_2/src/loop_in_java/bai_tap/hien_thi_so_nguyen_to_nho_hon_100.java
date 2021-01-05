package loop_in_java.bai_tap;

import java.util.Scanner;

public class hien_thi_so_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập các số nguyên tố nhỏ hơn n");
        int n=sc.nextInt();
        int count=0;
        for(int i=2;i<n;i++){
                if(n%i==0){
                    count++;
            }
            if(count==2){
                System.out.println(""+i);
            }
        }
    }
}
