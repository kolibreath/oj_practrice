import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ContinousNumbers {
    public static class Input{
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Input(){
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasNext(){
            while(tokenizer == null || !tokenizer.hasMoreElements()){
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        String next(){
            if(hasNext()){
                return tokenizer.nextToken();
            }else{
                return null;
            }
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        //使用BigInteger 完成计算
        BigInteger nextBigInteger(){
            return  new BigInteger(next());
        }

        //使用long 完成计算
        long nextLong(){
            return Long.parseLong(next());
        }

    }

    static Input cin = new Input();
    static PrintWriter cout = new PrintWriter(System.out);

    public static void main(String args[]){
        int n = cin.nextInt();
        int[] numbers = new int[n];

        int counter = 0;

        while(counter < n) {
            numbers[counter++] = cin.nextInt();
        }

        int predict = numbers[0];
        int cur = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            predict++;
            if(predict == numbers[i]){
                cur ++;
            }else{
                predict = numbers[i];
                cur = 1;
            }
            if(cur > max) max = cur;
        }

        System.out.print(max);

        cout.close();
    }
}
