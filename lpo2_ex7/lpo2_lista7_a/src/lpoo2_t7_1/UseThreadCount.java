package lpoo2_t7_1;

import java.util.ArrayList;
import java.util.List;

public class UseThreadCount {
    public static void main(String args[]){
        List<ThreadCount> array = new ArrayList<ThreadCount>();

        for (int i = 1; i < 3; i++){
            array.add(new ThreadCount(i, i*10));
            new Thread(array.get(i-1)).start();
        }
    }
}
