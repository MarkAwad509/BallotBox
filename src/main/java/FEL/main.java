package FEL;

import java.util.*;

public class main {
    public static void main(String[] args) {
        SortedSet<String> cities = new TreeSet<String>();
        cities.add("Toronto");
        cities.add("Montreal");
        cities.add("Vancouver");
        cities.add("Colorado");
        cities.add("Houston");
        cities.add("Boston");

        for(String c : cities)
            System.out.println(c);
    }
}
