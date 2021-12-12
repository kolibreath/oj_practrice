public class 最少侧跳次数 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int num = 2;
        int res = 0;
        for(int i = 0; i < n-1;){
            //若当前跑道无障碍一直前进
            if(obstacles[i+1] != num){
                i++;
                continue;
            }
            //other和another为另外两条跑道编号
            int other = (num + 1) % 3, another = (num + 2) % 3;
            other = (other == 0)?3:other;
            another = (another == 0)?3:another;
            int t = i;
            //计算测跳道other号跑道时遇到的第一个障碍位置
            while(t < n && obstacles[t] != other){
                t++;
            }
            //计算测跳道another号跑道时遇到的第一个障碍位置
            while(i < n && obstacles[i] != another){
                i++;
            }
            //选择靠后的那条跑道，更新当前跑道序号和当前位置。
            if(t > i){
                num = other;
            }else{
                num = another;
            }
            i = Math.max(t, i) - 1;
            res++;
        }
        return res;
    }
}
