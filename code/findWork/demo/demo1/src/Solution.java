import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        int[] a = new int[20];
        List<int[]> merge = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){

            int s=intervals[i][0];
            int e=intervals[i][1];

            //如果是第一个 直接并入 或者 前一个并入的endi<后一个的starti
            if(merge.size()==0||merge.get(merge.size()-1)[1]<s){
                merge.add(intervals[i]);
            }else{

                //选择endi大的
                int maxEnd=Math.max(merge.get(merge.size()-1)[1],e);

                merge.add(new int[]{1,2});



            }
        }

    }
}
