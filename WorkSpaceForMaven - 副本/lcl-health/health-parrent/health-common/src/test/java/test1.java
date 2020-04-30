public class test1 {
    public static void main(String[] args) {
        int[] src = {1, 23, 4, 5, 7, 3,12};
//        test2(src);
//        test3(src);
//        test03(src);
        sort(src);
    }

    public static String test2(int[] src) {
        {
            int len = src.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int temp;
                    if (src[i] > src[j]) {
                        temp = src[j];
                        src[j] = src[i];
                        src[i] = temp;
                    }
                }
//                printResult(i, src);
                System.out.print(src[i] + ",");
            }
            return null;
        }
    }

    public static void test3(int[] arr) {
        int len = arr.length;
        int temp;
        for (int i = 0; i < len; i++) {
            temp = arr[i];
            int j;
            int smallist = i;
            for (j = i + 1; j < len; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    smallist = j;
                }
            }
            arr[smallist] = arr[i];
            arr[i] = temp;
            System.out.print(arr[i] + ",");
        }
    }

    public static void test03(int[] src) {
        int len = src.length;
        for (int i = 1; i < len; i++) {
            int temp = src[i];
            int j = i;
            while (src[j - 1] > temp) {
                src[j] = src[j - 1];
                j--;
                if (j < 0) {
                    break;
                }
            }
            src[j] = temp;
            System.out.print(src[i] + ",");
        }
    }
    public static void sort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[j] > temp) { //需要注意的是，这里array[j] > temp将会使数组从小到到排序。
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + ",");
        }
    }
}
