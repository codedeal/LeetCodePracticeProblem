package org.geeksOfGeeks;

import java.util.*;

public class AlternatePositiveAndNegativeNumber
{
  public static void alternatePositiveNegativeNumber(int[] numbers)
  {
    Queue<Integer> positivesQueue = new LinkedList<Integer>();
    Queue<Integer> negativesQueue = new LinkedList<Integer>();

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] >= 0) {
        positivesQueue.add(numbers[i]);
      } else {
        negativesQueue.add(numbers[i]);
      }
    }

    for (int i = 0; i < numbers.length; i++) {
      if (i % 2 == 0 && !positivesQueue.isEmpty()) {
        numbers[i] = positivesQueue.poll();
      } else if (i % 2 == 1 && !negativesQueue.isEmpty()) {
        numbers[i] = negativesQueue.poll();
      } else if (!positivesQueue.isEmpty()) {
        numbers[i] = positivesQueue.poll();
      } else {
        numbers[i] = negativesQueue.poll();
      }
    }

    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }
  }


  public static void main(String[] args) {
    alternatePositiveNegativeNumber(new int[]{ 1, -2, 3, -4, 5, -6 });
  }
}
