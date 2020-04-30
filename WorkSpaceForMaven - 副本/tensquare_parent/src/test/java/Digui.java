import java.util.Scanner;

public class Digui {
    public static void main(String[] args){
        method1(1024);
        String str="aaaabbbrrrzxc";
        method2(str);
        System.out.println(jeCheng(6));
    }

    private static int jeCheng(int i) {
        if (i<=1) {
            return 1;
        }else {
            return i*jeCheng(i - 1);
        }

    }

    private static void method2(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars=str.toCharArray();
        int flag=0;
        int j=0;
        for (int i = 0; i < chars.length ; i++) {
            flag++;
            if (j==chars.length-1) {
                j=i;
            }else {
                j=i+1;
            }
            if (chars[i]!=chars[j]||i==chars.length-1) {
                if (flag>1) {
                    stringBuffer.append(chars[i]);
                    stringBuffer.append(flag);
                }else {
                    stringBuffer.append(chars[i]);
                }
                flag=0;
            }

        }
        System.out.println(stringBuffer);
    }

    private static void method1(int sum) {
        System.out.println(sum);

        if (sum<5024) {
            method1(2*sum);
        }
        System.out.println(sum);
    }
}
