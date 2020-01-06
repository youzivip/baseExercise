package suanfa;

import java.util.Arrays;

public class MergeTwoNums {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,8};
        int[] b = {2,4,5};
        int[] c = merge(a,b);
        for (int i = 0;i<c.length;i++){
            System.out.print(c[i]+"<");
        }
    }

    public static int[] merge(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        int i = 0,j = 0,k = 0;
        while (i<a.length && j<b.length){
            if(a[i] < b[j]){
                c[k] = a[i];
                i++;
            }
            else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        if(i <a.length-1){
            for (;i<a.length;i++){
                c[k] = a[i];
                k++;
            }
        }else if(j < b.length-1){
            for (;j<b.length;j++){
                c[k] = b[j];
                k++;
            }
        }
        return c;
    }
}
