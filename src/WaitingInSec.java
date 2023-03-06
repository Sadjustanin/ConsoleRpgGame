public interface WaitingInSec {
    static void waitingInSec(long a) {
        try {
            Thread.sleep(a * 1000);
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}
