package com.suanfa.sort;

import java.util.Arrays;

public class Fast {
    public static void main(String[] args) {
        int[] a = {5,6,3,4,8,9,89,0,21,43,890,12,56,888,890,36};
//            sort(a,0,a.length-1);
        System.out.println(findMid(a,0,a.length-1));
        System.out.println(Arrays.toString(a));
        System.out.println("*************round 2************");
        System.out.println(findMid(a,0,a.length-1));
        System.out.println(Arrays.toString(a));
    }

        public static void sort(int[] nums,int l,int h){
            int mid = findMid(nums,l,h);
            if(l<mid-1){
                sort(nums,l,mid-1>0?mid-1:0);
            }
            if(h>mid+1){
                sort(nums,mid+1,h);
            }

        }

        public  static int findMid(int[] nums,int l,int h){
            int mid = (l+h)/2;
            int t = nums[mid];
            while (l<h){
                while (l<mid){
                    if(nums[l]>t){
                        nums[mid] = nums[l];
                        nums[l] = t;
                        mid = l;
                        break;
                    }
                    l++;
                }
                while(h>mid){
                    if(nums[h]<t){
                        nums[mid] = nums[h];
                        nums[h] = t;
                        mid = h;
                        break;
                    }
                    h--;
                }
            }
            return mid;
        }


}
