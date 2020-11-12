public class Main {

    static boolean useTestAndSet = false;

    public static void main(String[] args) {
        System.out.println("Hello world");
        MyThread t1 = new MyThread(0);
        MyThread t2 = new MyThread(1);
        t1.start();
        t2.start();
    }

    public static void executeCS(Lock lock, int id) {
        lock.requestCS(id);
        System.out.println("Thread: " + id);
        lock.releaseCS(id);
    }

    static class MyThread extends Thread {
        int id;

        public MyThread(int id) {
            this.id = id;
        }

        public void run() {
            if(useTestAndSet) {
                TestAndSetMutex testAndSetMutex = new TestAndSetMutex();
                executeCS(testAndSetMutex, this.id);
            } else {
                SwapMutex swapMutex = new SwapMutex();
                executeCS(swapMutex, this.id);
            }
        }
    }
}


