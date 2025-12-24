public class patternrevealhelper {

    // 🔹 Check if the new pattern reveals any new letters compared to the old one
    public static boolean patternReveals(String oldPattern, String newPattern) {
        for (int i = 0; i < oldPattern.length(); i++) {
            if (oldPattern.charAt(i) == '_' && newPattern.charAt(i) != '_') {
                return true;
            }
        }
        return false;
    }
}
