package DesignPatterns.Creational.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list){
        this.empList=list;
    }
    public void loadData(){
        //read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();

        for(String s : this.getEmpList()){
            temp.add(s);
        }

        return new Employees(temp);
    }
}

//    Notice that the clone method is overridden to provide a deep copy of the employees list.


//    If the object cloning was not provided, we will have to make database call to fetch the
//    employee list every time. Then do the manipulations that would have been resource and time consuming.