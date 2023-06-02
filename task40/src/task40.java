public class task40 {
    public static void main(String[] args) {
        Thread timerThread = new Thread(new TimerTask());
        Thread messageThread1 = new Thread(new MessageTask("Сообщение каждые 7 секунд"));
        Thread messageThread2 = new Thread(new MessageTask("Сообщение каждые 10 секунд"));

        timerThread.start();
        messageThread1.start();
        messageThread2.start();

        try {
            Thread.sleep(60000); // Программа работает одну минуту
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timerThread.interrupt();
        messageThread1.interrupt();
        messageThread2.interrupt();
    }

    static class TimerTask implements Runnable {
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            while (!Thread.currentThread().isInterrupted()) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Прошло времени: " + elapsedTime / 1000 + " секунд");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class MessageTask implements Runnable {
        private String message;

        public MessageTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(message);
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
