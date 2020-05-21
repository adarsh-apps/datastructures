package DesignPatterns.Creational.Singleton;

import java.lang.reflect.Constructor;

public class ReflectionTestSingleton {
    public static void main(String[] a) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;

        try {
            Constructor[] constructors = instanceOne.getClass().getConstructors();

            for (Constructor constructor : constructors){
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
