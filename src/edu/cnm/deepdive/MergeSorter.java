package edu.cnm.deepdive;

import java.util.Arrays;

public class MergeSorter {


  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  private static void sort(int[] data, int from, int to) {

    if (to - from <= 1) {
      return;
    }
    int midpoint = (to + from) / 2;
    sort(data, from, midpoint);
    sort(data, midpoint, to);
    int[] merged = new int[to - from];
    int left = from;
    int right = midpoint;
    int mergedIdx = 0;
    while (left < midpoint && right < to) {
      if (data[left] <= data[right]) {
        merged[mergedIdx++] = data[left++];
      } else {
        merged[mergedIdx++] = data[right++];
      }
    }
    for (int i = left; i < midpoint; i++) {
      merged[mergedIdx++] = data[left++];
    }
    for (int i = right; i < to; i++) {
      merged[mergedIdx++] = data[right++];
    }
    System.arraycopy(merged, 0, data, from, merged.length);
  }

}
