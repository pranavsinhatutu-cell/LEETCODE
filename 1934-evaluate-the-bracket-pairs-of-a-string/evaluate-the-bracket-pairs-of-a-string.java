import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Convert the knowledge base into a HashMap for O(1) lookups
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;

        // Step 2: Iterate through the string s
        while (i < n) {
            char c = s.charAt(i);

            if (c == '(') {
                // Find the closing bracket ')'
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }

                // Extract key and replace with value or '?'
                String key = s.substring(i + 1, j);
                sb.append(map.getOrDefault(key, "?"));

                // Move pointer past the closing bracket
                i = j + 1;
            } else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}