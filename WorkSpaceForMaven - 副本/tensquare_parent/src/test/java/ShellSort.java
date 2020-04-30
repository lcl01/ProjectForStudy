import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr={13250,329,8,7,3256,5,45,3,552,1};

        sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr01={10,923,8,2347,6,5213,4235,3234,2,1};
        sort01(arr01);
        System.out.println(Arrays.toString(arr01));
        int[] arr02={9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quick(arr02,0,arr02.length-1);
        System.out.println(Arrays.toString(arr02));


    }

    private static void quick(int[] arr02, int left, int right) {
        if (left<right){
            dealPivot(arr02,left,right);
            int pivot = right - 1;
            int i = left;
            int j = right - 1;
            while (true) {
                while (arr02[++i] < arr02[pivot]) {
                }
                while (j > left && arr02[--j] > arr02[pivot]) {
                }
                if (i < j) {
                    swap02(arr02, i, j);
                } else {
                    break;
                }
            }
            if (i < right) {
                swap(arr02, i, right - 1);
            }
            quick(arr02, left, i - 1);
            quick(arr02, i + 1, right);
        }
    }

    private static void dealPivot(int[] arr02, int left, int right) {
        int mid=(left+right)/2;
        if (arr02[left]>arr02[mid]) {
            swap02(arr02,left,mid);
        }
        if (arr02[left] > arr02[right]) {
            swap02(arr02, left, right);
        }
        if (arr02[right] < arr02[mid]) {
            swap02(arr02, right, mid);
        }
        swap02(arr02,right-1,mid);
    }

    private static void swap02(int[] arr02, int i, int j) {
        int temp=arr02[i];
        arr02[i]=arr02[j];
        arr02[j]=temp;
    }


    private static void sort01(int[] arr01) {
        for (int gap = arr01.length/2; gap >0; gap/=2) {
            for (int i = gap; i <arr01.length; i++) {
                int j=i;
                while (j-gap>=0&& arr01[j]>arr01[j-gap]){
                    int temp=arr01[j];
                    arr01[j]=arr01[j-gap];
                    arr01[j-gap]=temp;
                }

            }
        }

    }

    private static void sort(int[] arr) {
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                while (j - gap >= 0 && arr[j]<arr[j-gap]) {

                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
