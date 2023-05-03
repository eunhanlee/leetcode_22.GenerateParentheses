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
