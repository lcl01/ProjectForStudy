public class Test {
    public static void main(String[] args) {
        method1(1024);
        String str="aaaabbbrrrzxc";
        method2(str);

    }

    private static void method2(String str) {
        char[] ca=str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int j=0;
        int flag=0;
        for (int i = 0; i < ca.length; i++) {
            flag+=1;
            if (j==ca.length-1) {
                j=i;
            }else {
                j=i+1;
            }
            if (ca[i]!=ca[j]||i==ca.length-1) {
                if (flag>1) {
                    buffer.append(ca[i]);
                    buffer.append(flag);
                }else {
                    buffer.append(ca[i]);
                }
                flag=0;

            }
        }
        System.out.println(buffer);
    }

    public static void method1(int a){

        System.out.println(a);

        if(a<10000){
            method1(2*a);
            System.out.println(a);
        }
    }
}
