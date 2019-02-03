import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        fun(list);
        System.out.println(list.size());
    }

    private static void fun(List<String> list){
        if(list.size()> 5)
            return;
        list.add(new String());
        fun(list);
    }
}
