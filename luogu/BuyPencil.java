import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BuyPencil {

    // 原题地址：https://www.luogu.org/problemnew/show/P1421

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
    static PrintWriter count = new PrintWriter(System.out);
    public static void main(String args[]){
        int yuan = cin.nextInt();
        int jiao = cin.nextInt();

        int value = yuan * 10 + jiao ;
        System.out.print(value /(19));


    }
}
