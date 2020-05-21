package DesignPatterns.Creational.Prototype;

import java.util.List;

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }

}
//   Prototype design pattern is used when the Object creation is a costly affair and requires a
//   lot of time and resources and you have a similar object already existing.
//   Prototype pattern provides a mechanism to copy the original object to a new object and
//   then modify it according to our needs. Prototype design pattern uses java cloning to copy the object.

//   Eg: wardrobe size increasing(clone old one increase size check collisions).

//   suppose we have an Object that loads data from database. Now we need to modify this data in our program
//   multiple times, so it’s not a good idea to create the Object using new keyword and load all the data again
//   from database.
//   The better approach would be to clone the existing object into a new object and then do the data manipulation.