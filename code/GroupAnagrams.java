import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs.length == 0){
                List<String> list = new ArrayList<String>();
                list.add(strs[0]);
                List<List<String>> result = new ArrayList<>();
                result.add(list);
                return result;
            }

            List<List<String>> result = new ArrayList<>();
            boolean visited[] = new boolean[strs.length];
            visited[0] = false;
            for(int i =0;i<visited.length;i++){
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                for(int j =1;j<visited.length;j++){
                    if(isAnagram(strs[i],strs[j])){
                        l.add(strs[j]);
                    }
                }
                result.add(l);
            }
            return result;
        }

        public boolean isAnagram(String src,String tar){
         char srcA[] = src.toCharArray();
         char tarA[] = src.toCharArray();

         sort(srcA,0,src.length());
         sort(tarA,0,tar.length());

         for(int i = 0, j = 0;i< srcA.length && j < tarA.length;i++){
             if(srcA[i] != tarA[j])
                 return false;
         }
         return true;
        }

        public void sort(char[]a,int left,int right){
            if(left >= right)
                return;
            int mid = (left + right) >>1;
            sort(a,left,mid);
            sort(a,mid+1,right);
            merge(a,left,mid,right);
        }

        public void merge(char[]a,int left,int mid,int right){
            char temp[] = new char[a.length];
            int mr = mid + 1;
            int tindex = left;
            int cindex = left;
            while(left<=mid && mr<=right){
                if(a[left]<=a[mr]){
                    temp[tindex++] = a[left++];
                }else
                    temp[tindex++] = a[mr++];
            }

            while(left <= mid)
                temp[tindex++] = a[left++];

            while(mr<=right)
                temp[tindex] = a[mr++];

            while(cindex<=right){
                a[cindex] = temp[cindex];
                cindex++;
            }
        }
    }
}
