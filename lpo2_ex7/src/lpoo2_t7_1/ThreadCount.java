package lpoo2_t7_1;

import static java.lang.Thread.sleep;

public class ThreadCount implements Runnable{
    private int max;
    private int num;
    
    public ThreadCount(int num, int max){ 
        if (max > 0) 
            this.max = max; 
        else throw new RuntimeException("Invalid maximum count number!");
        if (num > 0)
            this.num = num;
        else throw new RuntimeException("Invalid thread number!");
    }
            
    @Override
    public synchronized void run(){
        for (int i = 0; i < max + 1; i ++){
            System.out.println("Thread " + num + ", valor = " + i);
            try {
                sleep(1000);
            } 
            catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }
}
