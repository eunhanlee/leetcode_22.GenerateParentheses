# 22. Generate Parentheses Problem Solved: Uncover the Most Efficient Java Algorithm

Related code_study: https://www.notion.so/22-Generate-Parentheses-3693f83f8b24426989235742513e5fc5
homepage: No
languange: Java
written language: English

# Problem

[Problem_Link](https://leetcode.com/problems/generate-parentheses/description/)

## **Problem Solving Approach**

- To generate all combinations, typically use recursive function DFS.
- Must open ‘(’ and then close ‘)’ to get valid combinations only (backtracking algorithm).
    - if (open < length)
    - if (close < open)
- When the length of the string becomes twice of n, it's the end of the recursion (base case).

# Time **O(**(2^n) / 2**)=**O(4^n/sqrt(n))**, Space O(**(2^n) / 2**)**

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Generates all combinations of well-formed parentheses.
     *
     * @param n the number of pairs of parentheses
     * @return a list of all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecur(result, "", 0, 0, n);
        return result;
    }

    /**
     * Generates all combinations of well-formed parentheses using recursion.
     *
     * @param result the list of generated combinations
     * @param currentString the current string being built
     * @param open the number of open parentheses in the current string
     * @param close the number of close parentheses in the current string
     * @param len the desired length of the current string
     */
    private void generateParenthesisRecur(List<String> result, String currentString, int open, int close, int len) {
        if (currentString.length() == len * 2) {
            result.add(currentString);
            return;
        }

        if (open < len) {
            generateParenthesisRecur(result, currentString + "(", open + 1, close, len);
        }
        if (close < open) {
            generateParenthesisRecur(result, currentString + ")", open, close + 1, len);
        }
    }
}
```

## **Explanation**

- The total number of combinations is 2^n, but this is reduced to half by the backtracking algorithm. Therefore, the time complexity is O(2^(2n)/2) = O(4^n/sqrt(n)).