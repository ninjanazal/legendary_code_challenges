package org.legendary_code_challenges.tools;

import java.util.*;

public class Assertions {
  private Assertions() {
  }

  /**
   * Checks if all the nested lists in the first list are contained within any of
   * the nested lists in the second list. The containment is determined by the
   * {@link List#containsAll} method.
   *
   * @param <T> the type of elements in the lists
   * @param a   the first list of nested lists
   * @param b   the second list of nested lists to check against
   * @return true if all nested lists in 'a' are contained within any nested list
   *         in 'b',
   *         false otherwise
   */
  public static <T> boolean containeUNestedList(List<List<T>> a, List<List<T>> b) {
    for (List<T> expextList : a) {
      for (int i = 0; i < b.size(); i++) {
        List<T> outputList = b.get(i);
        if (outputList.containsAll(expextList)) {
          break;
        }
        if (i == b.size() - 1) {
          return false;
        }
      }
    }
    return true;
  }
}
