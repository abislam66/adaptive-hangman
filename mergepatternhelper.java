public class mergepatternhelper {

    // Merge the new pattern into the old one (revealing the new letters)
    public static StringBuilder mergePatterns(String oldPattern, String newPattern) {
        StringBuilder merged = new StringBuilder();
        for (int i = 0; i < oldPattern.length(); i++) {
            if (newPattern.charAt(i) != '_') {
                merged.append(newPattern.charAt(i));
            } else {
                merged.append(oldPattern.charAt(i));
            }
        }
        return merged;
    }
}
