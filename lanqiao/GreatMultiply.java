import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Fuck {
    static class Input{
        StringTokenizer tok;
        BufferedReader reader;

        Input(){
            reader= new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasNext(){
            while(tok == null || !tok.hasMoreElements()) {
                try {
                    tok = new StringTokenizer(reader.readLine());
                }catch (Exception e){
                    return false;
                }
            }

            return true;
        }

        public String next(){
            if(hasNext())
                return tok.nextToken();
            else
                return null;
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }

    static Input cin = new Input();
    static PrintWriter cout = new PrintWriter(System.out);


    public static void main(String args[]){
        String a = cin.next();
        String b = cin.next();

        String mul = a;
        String mee = b;
        String temp = "";

        if(mul.length() < mee.length()){
            temp= mul;
            mul = mee;
            mee = temp;
        }

        cal(mul,mee);

    }

    private static void cal(String mul,String mee){
        mul = new StringBuilder(mul).reverse().toString();
        mee = new StringBuilder(mee).reverse().toString();

        //表示需要加上0的个数
        int base = 0;
        int shorter = mee.length();
        String lastResult = "0";
        int carries[] = new int[1];
        for(int i = 0;i<shorter;i++){
            String curResult = singleMul(mul,mee.charAt(i)+"");
            lastResult = singleAdd(lastResult,curResult,base,carries);
            base++;
        }

        println(new StringBuilder(lastResult).reverse().toString());
    }

    //计算一个字母和一整个字符串相乘
    private static String singleMul(String mul,String c){
        int index = 0;
        String builder = "";
        int carry = 0;
        int mee = c.charAt(0) - '0';

        for(index=0;index<mul.length();index++){
            int curvalue = mul.charAt(index) - '0';
            int result = curvalue *  mee + carry;
            carry =  result / 10;
            builder += result % 10;
        }

        return builder;
    }

    //加上
    //4321
    //765
    //的形式
    private static String singleAdd(String last,String cur,int base,int[] carries){
        StringBuilder tempBuilder = new StringBuilder(cur);
        for(int i = 0;i<base;i++){
            tempBuilder.insert(0,"0");
        }
        cur = tempBuilder.toString();

        String adder = last;
        String addee = cur;
        String temp = "";

        if(addee.length() < adder.length()){
            temp = adder;
            adder = addee;
            addee = temp;
        }
        String builder = "";
        int carry = carries[0];
        int index = 0;
        for(index = 0;index<adder.length();index++){
            int ervalue = adder.charAt(index) - '0';
            int eevalue = addee.charAt(index) - '0';

            int result = ervalue + eevalue + carry;
            builder += result % 10;
            carry = result / 10;
        }

        for(;index<addee.length();index++){
            int result = ( addee.charAt(index) - '0') + carry;
            builder += result % 10;
            carry = result / 10;
        }
        carries[0] = carry;
        return builder;
    }

    private static void println(String value){
        System.out.println(value);
    }
}

