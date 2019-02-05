import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MeanOfTwo {

    static class Input{
        BufferedReader reader;
        StringTokenizer tok;

        public Input(){
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

    public static void main(String args[]){
        int a = cin.nextInt();
        int b = cin.nextInt();

        System.out.print(2*b - a);
        cout.close();;
    }
}
