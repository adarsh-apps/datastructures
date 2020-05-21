//   Prior to Java 5, java memory model had a lot of issues and the above approaches used
//   to fail in certain scenarios where too many threads try to get the instance of the
//   Singleton class simultaneously. So Bill Pugh came up with a different approach to
//   create the Singleton class using an inner static helper class.


package DesignPatterns.Creational.Singleton;

public class BillPughSingleton {
    private BillPughSingleton() {

    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
