import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    
        //Queue used for producer-consumer problem
        Queue<Integer> items = new LinkedList<>();

        // Items Bucket/Queue capacity
        int capacity=3;
        
        public void produce() throws InterruptedException
        {
            int value = 1;
            while(true)
            {
                synchronized (this)
                {
                    // producer thread waits while list is full
                    while(items.size()==capacity){
                        System.out.println("\n....Producer Waiting till Bucket full....\n");
                        wait();
                    }

                    System.out.println("The Producer produced item number: "+ value);
                    items.add(value++);

                    // notifies the consumer thread that now it can start consuming
                    notify();
                    // sleep
                    Thread.sleep(1000);
                }
            }
        }
        
        public void consume() throws InterruptedException
        {
            while(true)
            {
                synchronized (this)
                {
                    // consumer thread waits while list is empty
                    while(items.isEmpty()) {
                        System.out.println("\n....Consumer Waiting till Bucket empty....\n");
                        wait();
                    }

                    int consumedValue=items.remove();
                    System.out.println("The Consumer consumed item number: "+ consumedValue);

                    // Wake up producer thread
                    notify();
                    //sleep
                    Thread.sleep(500);
                }
            }
        }
        
    public static void main(String[] args)  {

        System.out.println("\n=======Producer-Consumer (Bucket size:3) Transaction=======");

        //Object of a class that has both produce() and consume() methods
        final ProducerConsumer pc;
        pc = new ProducerConsumer();

        // Create producer thread
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        // Create consumer thread
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        try {
            // starting threads
            producerThread.start();
            consumerThread.start();

            // producerThread finishes before consumerThread
            producerThread.join();
            consumerThread.join();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Ending Producer Consumer (Bucket size:3) Transaction");
        }

    }
}
