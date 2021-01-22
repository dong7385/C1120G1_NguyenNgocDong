package exception.thuc_hanh;

import java.io.IOException;

public class Persion {
    public static void print() throws ArrayIndexOutOfBoundsException, IOException {
        int[] mang = {1, 2};
        System.out.println(mang[2]); //khi chay mang nay se ban ra 1 exception và chúng ta dung try catch để bắt lỗi,tuy nhiên vì không muốn dùng try catch ơ hàm nay ,
        //tạo ra throws ném ra cái lỗi  ArrayIndexOutOfBoundsException
        //hàm nào mà gọi thằng print này thì sẽ bị ném ra 1 exception,ta dùng try catch để bắt lỗi này
    }

    // để thay cho try catch thì ta throws ra 1 exception.... ,khi thằng nào gọi đến nó thì try catch hoac bat loi lại
    public static void main(String[] args) {
//        try {
//            print();
//        }catch (Exception e){
//            System.out.println("r");
//        }

       try {
           exceptionExample();
       }catch (ArrayIndexOutOfBoundsException e){
           System.out.println("t");
       }
    }

    public static void exceptionExample() {
        throw new ArrayIndexOutOfBoundsException(); //throw dùng từ new tạo đối tượng có ArrayIndexOutOfBoundsException
    }
}
