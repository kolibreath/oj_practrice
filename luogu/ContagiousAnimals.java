import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ContagiousAnimals {

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

    //很大会溢出
    //可以使用BigInteger 或者long
    //Biginteger 可能会很占用内存 不推荐使用 直接使用long比较好 而且没有超出long的范围
    //或者可以使用快速幂的方法求一个数的幂 这样比较快
    public static void main(String args[]) {
//       solution_one_two();
        solution_three();
    }

    private static void solution_three(){
        int catagious = cin.nextInt();
        int round = cin.nextInt();
        long result;

        result = fastPower((catagious + 1), round);
        System.out.print(result);
    }
    //求a^b
    private static long fastPower(int a, int b){
        long base = a;
        long result = 1;
        while(b != 0){
            if((b & 1) == 1){
                result = result * base;
            }
            base = base * base;
            b = b >> 1;
        }

        return result;
    }
    private static void  solution_one_two(){
        int catagoius = cin.nextInt();
        int round = cin.nextInt();
//        BigInteger result = BigInteger.valueOf(1);
        long result = 1;
        int counter = 0;
        while(counter < round){
            result = result + result* catagoius;
//           result = result.add(result.multiply(BigInteger.valueOf(catagoius)));
            counter ++;
        }
        System.out.print(result);

        cout.close();
    }
}
