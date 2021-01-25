package algorithm.bai_tap;

public class binaryDeQuy {
    static int[] numbers = {4, 5, 7, 9, 10, 20, 59, 75, 89};

    public static void main(String[] args) {
        System.out.println(binarySearch(numbers, 9));
    }
    public static int binarySearch(int[] arr, int value){
        int low = 0;
        int high = arr.length -1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                return mid - 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }
}

