package org.example;

import obs.*;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);
        observable.subscribe(o2);
        observable.subscribe(obs -> {
            if (obs instanceof ObservableImpl o){
                System.out.println("++++++++++++++++Obs Impl 3++++++++++++++++++");
                System.out.println("Res ="+o.getState()*Math.cos(o.getState()));
                System.out.println("++++++++++++++++Obs Impl 3++++++++++++++++++");
            }

        });
        observable.setState(60);
        observable.setState(80);
        observable.subscribe(o2);
        observable.setState(100);


    }
}