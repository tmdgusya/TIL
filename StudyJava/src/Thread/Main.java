package Thread;

public class Main {

    public static void main(String[] args) {

        ChildThread childThread = new ChildThread("jsh", 10000);
        ParentThread parentThread = new ParentThread("yjs", 110000);

        Thread thread1 = new Thread(childThread); // New
        Thread thread2 = new Thread(parentThread); // New
        GetStateThread stateThread = new GetStateThread(thread1, thread2);
        Thread thread_ = new Thread(stateThread);

        thread_.start();

        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        thread1.start();
//        thread2.start();

         try{
         thread1.start();
         thread1.join();
         thread2.start();
         }catch (Exception e){
         e.printStackTrace();
         }
    }

    static class GetStateThread implements Runnable {
        private Thread thread1;
        private Thread thread2;
        private final int delayToNexThread = 500;

        public GetStateThread(Thread tr1, Thread tr2) {
            this.thread1 = tr1;
            this.thread2 = tr2;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    printThreadState(thread1);
                    printThreadState(thread2);
                    Thread.sleep(delayToNexThread);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void printThreadState(Thread thread) {
            String threadInfo = String.format("%s.getState() = " + thread.getState(), thread.getId());
            System.out.println(threadInfo);

        }
    }
}

// synchronized (thread1) {
// try {
// System.out.println("jsh 의 Thread 작업을 기다립니다.");
// thread1.wait();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }

// synchronized (thread2) {
// try {
// System.out.println("jsh 의 Thread 작업을 기다립니다.");
// thread2.wait();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }