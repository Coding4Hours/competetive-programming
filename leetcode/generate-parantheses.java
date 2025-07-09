class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int left, int right, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        if (left < n) 
            backtrack(result, current + "(", left + 1, right, n);
        
        
        if (right < left) 
            backtrack(result, current + ")", left, right + 1, n);
        
    }
}
