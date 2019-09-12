package download.dsalgo.poc;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.sun.org.apache.xpath.internal.operations.Mult;

/**
 * @author: Kaustav Sarkar
 * @created: 8/22/2019
 */
public class MultiThread extends Thread {

    public static void main(String[] args) {
        Thread t1 = new MultiThread();
        t1.start();
        t1.stop();
        try {
            t1.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(true) {
            System.out.println("print true");
        }else if(true) {
            System.out.println("print else");
        }

    }

    @Override
    public void run() {
        System.out.println("Hello...");
    }
}
