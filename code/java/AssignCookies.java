import java.util.Arrays;

public class AssignCookies {
    static class Solution {
        public int findContentChildren(int[] child, int[] cookie) {

            qsort(child);
            qsort(cookie);

            int i = 0 ,j = 0;
            for(i = 0;i <child.length && i< cookie.length;i++){
                if(child[j]<=cookie[i]){
                    j++;
                }
            }
            return j;
        }

        public int partition(int[] arr,int low,int high){
            int pivot = arr[low];
            while(low < high){
                while( low < high && arr[high]>= pivot) --high;
                arr[low] = arr[high];
                while( low< high  && arr[low] <= pivot) ++low;
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            return low;
        }

        public void qsort(int arr[],int low,int high){
            if(low < high){
                int pivot = partition(arr,low,high);
                qsort(arr,low,pivot-1);
                qsort(arr,pivot+1,high);
            }
        }

        public void qsort(int arr[]){
            qsort(arr,0,arr.length-1);
        }
    }
}
