package suanfa;

import java.util.HashMap;

public class Rob {
    public static void main(String[] args) {
        int[] a = {1,2,4,2,8,4};
        HashMap<Integer,Integer> map = new HashMap();
        int max = rob(a,0,map);
        System.out.println(max);
    }

    public static int rob(int[] a,int start,HashMap<Integer,Integer> map){
        if (start>=a.length) return 0;
        if(map.get(start)!= null)  {
         //   System.out.println("get-->"+start);
            return  map.get(start);
        }
        int i = Math.max(a[start]+rob(a,start+2,map),rob(a,start+1,map));
        map.put(start,i);
        return i;
    }
}
