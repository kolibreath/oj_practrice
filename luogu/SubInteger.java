import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SubInteger {

    static class Input{
        BufferedReader reader;
        StringTokenizer tok;

        Input(){
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasNext(){
            while(tok == null || !tok.hasMoreElements()){
                try {
                    tok = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    return false;
                }
            }

            return true;
        }
        String next() {
            if(hasNext())
                return tok.nextToken();
            else
                return null;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }

    static Input cin = new Input();
    static PrintWriter cout = new PrintWriter(System.out);


    //思路1 将这个题作为字符串问题考虑
    //所以一定要使用输入输出挂 不然java容易在开虚拟机上消耗时间和内存
    //思路 abcde abc 的范围一定在100-300闭区间，所以先计算最小abc
    //如15*14=210 则 a = 2 b = 1 c = 0

    /***
     * 方法一 这个方法太弱鸡了 时间复杂度很低
     */

    public static void solutionOne(){
        int k = cin.nextInt();
        //输出的数字可以不用是int类型 string类型也可以 oj 不检查类型
        LinkedList<String> range = range(k);


        boolean  flag = false;
        //考虑不是040的情况
        for (String start : range) {
            int a = start.charAt(0) - '0';
            int b = start.charAt(1) - '0';
            int c = start.charAt(2) - '0';

            for(int i = 0;i < 10;i++){
                int second = b * 100 + c * 10 + i;

                if(second % k != 0)
                    continue;

                for (int j = 0; j < 10; j++) {
                    int third = c * 100 + i * 10 + j;

                    if(third % k != 0) {
                        continue;
                    }
                    else{
                        flag = true;
                        int result = a * 10000 + b * 1000 + c * 100 + i*10 +j;
                        if(result <= 30000)
                            System.out.println(result);
                    }
                }
            }
        }

        if (!flag){
            System.out.println("No");
        }

        cout.close();
    }


    /**
     * 方法二 暴力法   时间复杂度相对要高一点
     * 和方法一的思路相同 但是使用了数学的方法将五位数分成的三个数字分别剥离出来了
     */

    public static void solutionTwo(){
        int k = cin.nextInt();
        boolean flag = true;
        for(int i = 10000; i <=30000;i++){

            int first = i / 100;
            int second = i /10 - (i/ 10000) * 1000;
            int third = i - (i / 1000) * 1000;

            if( first % k == 0 && second % k ==0 && third % k == 0){
                flag = false;
                System.out.println(i);
            }
        }

        if(flag){
            System.out.println("No");
        }
    }

    public static void main(String args[]){
//        solutionOne();
        solutionTwo();
    }

    public static LinkedList<String> range(int k){
        LinkedList<String> range = new LinkedList<>();

        int result= 0;
        int counter = 0;
        while(result < 300 ){
            result =counter * k;
            if(result <= 300 && result >= 100){
                range.add(String.valueOf(result));
            }

            counter ++;
        }

        return range;
    }




}
