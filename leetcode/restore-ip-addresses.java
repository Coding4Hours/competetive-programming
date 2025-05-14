    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // Early check: string length must be between 4 and 12
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int start, int segmentCount, StringBuilder current, List<String> result) {
        // Base case: 4 segments and used all characters
        if (segmentCount == 4 && start == s.length()) {
            // Remove trailing dot and add to result
            result.add(current.toString());
            return;
        }

        // Prune: too many segments or not enough characters
        if (segmentCount >= 4 || start >= s.length()) {
            return;
        }

        // Prune: check remaining length
        int remainingLength = s.length() - start;
        int remainingSegments = 4 - segmentCount;
        if (remainingLength < remainingSegments || remainingLength > 3 * remainingSegments) {
            return;
        }

        // Try segments of length 1 to 3
        for (int length = 1; length <= 3 && start + length <= s.length(); length++) {
            String segment = s.substring(start, start + length);
            if (isValidSegment(segment)) {
                // Store current length to revert later
                int currentLength = current.length();
                // Append segment and dot
                current.append(segment);
                if (segmentCount < 3) {
                    current.append('.');
                }
                backtrack(s, start + length, segmentCount + 1, current, result);
                // Revert StringBuilder to previous state
                current.setLength(currentLength);
                // Early break if segment is "0" (no leading zeros allowed)
                if (segment.equals("0")) {
                    break;
                }
            }
        }
    }

    private boolean isValidSegment(String segment) {
        // Check length
        if (segment.length() > 3) {
            return false;
        }
        // Check for leading zero
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        // Check if number is between 0 and 255
        try {
            int num = Integer.parseInt(segment);
            return num >= 0 && num <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }
