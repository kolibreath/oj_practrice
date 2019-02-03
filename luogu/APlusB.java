import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class APlusB {

    static class Input{
        StringTokenizer tok;
        BufferedReader  buf;

        public Input(){
            buf= new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasNext(){
            while(tok == null || !tok.hasMoreElements()){
                try{
                    tok = new StringTokenizer(buf.readLine());
                }catch (Exception e){
                    return false;
                }
            }

            return true;
        }

        String next(){
            if(hasNext()){
                return tok.nextToken();
            }
            return null;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }

    static Input input = new Input();
    static PrintWriter output = new PrintWriter(System.out);
    static public void main(String args[]){
        int a  = input.nextInt();
        int b = input.nextInt();

        output.println(a + b);

        output.close();
    }


}
