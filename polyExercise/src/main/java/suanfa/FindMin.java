package suanfa;

public class FindMin {
    public static void main(String[] args) {
        int[] a = {1,3,5,6,8,11,3,4,9};
        int index = findIndex(a,0,a.length-1);
        System.out.println("index:"+index+",num:"+a[index]);
        int min = a[0]<a[index]?a[0]:a[index];
        System.out.println("min:"+min);
    }

    public static int findIndex(int[] nums,int l,int h){
        if(l == h) return l;
        int mid = (l+h)/2;
        if(nums[l]>=nums[h] && nums[mid] < nums[h])
            return findIndex(nums,l,mid);
        if(nums[l]<nums[mid] && nums[mid]>= nums[h])
            return findIndex(nums,mid,h);
        return findIndex(nums,l+1,h);
       // return l;
    }
}
