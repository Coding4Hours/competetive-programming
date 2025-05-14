class Solution {
  public int distributeCandies(int[] candyType) {
    int n = candyType.length / 2;
    HashSet<Integer> hs = new HashSet<Integer>();
    for (int i = 0; i < candyType.length; i++) {
      hs.add(candyType[i]);
    }
    return n >= hs.size() ? hs.size() : n;
  }
}
