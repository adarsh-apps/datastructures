package DesignPatterns.Creational.Singleton;

public class ThreadSafeSynchronizedBlockSingleton {
    private static ThreadSafeSynchronizedBlockSingleton instance;

    private ThreadSafeSynchronizedBlockSingleton() {

    }

    public static ThreadSafeSynchronizedBlockSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSynchronizedBlockSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSynchronizedBlockSingleton();
                }
            }
        }

        return instance;
    }
}
