/*
 *  Program:    Exercise 19.8
 *  Date:       3/24/18
 *  Developer:  Garrett Wolfe
 *  Purpose:    Write the following method that sorts an ArrayList:
 *              public static <E extends Comparable<E>> void sort(ArrayList<E> list)
 */
package exercise.pkg19_9;

import java.util.ArrayList;
public class Exercise19_9 {
      public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println("Original: " + list);
        shuffle(list);
        System.out.println("Shuffled: " + list);
        sort(list);
        System.out.println("Sorted: " + list);
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            E currentMin = list.get(i);
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(currentMin) < 0) {
                    currentMin = list.get(j);
                    min = j;
                }
            }
            if (min != i) {
                list.set(min, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int random = (int) (Math.random() * list.size());
            E tmp = list.get(random);
            list.set(random, list.get(i));
            list.set(i, tmp);
        }
    }
}