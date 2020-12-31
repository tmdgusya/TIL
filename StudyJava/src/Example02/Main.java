package Example02;

public class Main {

    public static void main(String[] args) {
        ChildThread childThread = new ChildThread("jsh", 10000);
        ParentThread parentThread = new ParentThread("yjs", 110000);
        Thread thread1 = new Thread(childThread);
        Thread thread2 = new Thread(parentThread);
        GetStateThread stateThread = new GetStateThread(thread1, thread2);
        Thread thread_ = new Thread(stateThread);

        thread_.start();
        try {
            Thread.sleep(50);
        }catch (Exception e){
            e.printStackTrace();
        }
        thread1.start();
        try {
            Thread.sleep(50);
        }catch (Exception e){
            e.printStackTrace();
        }
        thread2.start();
    }


    static class GetStateThread implements Runnable {
        private Thread thread1;
        private Thread thread2;

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

                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void printThreadState(Thread thread) {
            String threadInfo = String.format("%s.getState() = " + thread.getState(), thread.getId());
            switch (thread.getState()) {
                case NEW:
                    System.out.println(threadInfo);
                    break;
                case BLOCKED:
                    System.out.println(threadInfo);
                    break;
                case WAITING:
                    System.out.println(threadInfo);
                    break;
                case RUNNABLE:
                    System.out.println(threadInfo);
                    break;
                case TERMINATED:
                    System.out.println(threadInfo);
                    break;
                case TIMED_WAITING:
                    System.out.println(threadInfo);
                    break;
            }
        }
    }
}
