//    1.Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class
//    exists in the java virtual machine.

//    2.The singleton class must provide a global access point to get the instance of the class.
//    3.Singleton pattern is used for logging, drivers objects, caching and thread pool.
//    4.Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
//    5.Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.


//    Java Singleton Pattern Implementation
//    Private constructor to restrict instantiation of the class from other classes.
//    Private static variable of the same class that is the only instance of the class.
//    Public static method that returns the instance of the class, this is the global
//    access point for outer world to get the instance of the singleton class.


package DesignPatterns.Creational.Singleton;

public class EagerInitializedSingleton {
    private final static EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {

    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}

//   If your singleton class is not using a lot of resources, this is the approach to use.
//   But in most of the scenarios, Singleton classes are created for resources such as File System,
//   Database connections, etc. We should avoid the instantiation until unless client calls the getInstance method.
//   Also, this method doesn’t provide any options for exception handling.

//   Cache: We can use the cache as a singleton object as it can have a global point of reference
//   and for all future calls to the cache object the client application will use the in-memory object

//   Logger : Singleton classes are used in log file generations. Log files are created by the logger class object.
//   Suppose an application where the logging utility has to produce one log file based on the messages received
//   from the users. If there is multiple client application using this logging utility class they might create
//   multiple instances of this class and it can potentially cause issues during concurrent access to the same logger
//   file. We can use the logger utility class as a singleton and provide a global point of reference so that each
//   user can use this utility and no 2 users access it at the same time.