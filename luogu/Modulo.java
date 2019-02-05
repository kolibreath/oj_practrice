import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Modulo {

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

        int[] hash = new int[42];
        int counter = 0;

        int result = 0;
        while(counter < 10){
            int a = cin.nextInt();

            if(hash[a%42] ==0 ){
                result++;
                hash[a%42]++;
            }
            counter++;
        }

        System.out.print(result);
        cout.close();
    }

}
