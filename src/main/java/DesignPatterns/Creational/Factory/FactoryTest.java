package DesignPatterns.Creational.Factory;

public class FactoryTest {
    public static void main(String[] a) {
        Computer pc = Factory.getComputer("pc","2 GB","500 GB","2.4 GHz");
        Computer server = Factory.getComputer("server","16 GB","1 TB","2.9 GHz");

        System.out.println("Factory PC Config::" + pc);
        System.out.println("Factory Server Config::" + server);
    }
}


// Eg: wardrobe creation(Custom wardrobe, full panel wardrobe, sliding door wardrobe, etc..)

// The factory design pattern is used when we have a superclass with multiple sub-classes
// and based on input, we need to return one of the sub-class. This pattern takes out the
// responsibility of the instantiation of a class from the client program to the factory class.