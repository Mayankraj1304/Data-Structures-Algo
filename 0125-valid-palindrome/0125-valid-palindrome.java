class Solution {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char ch[]=s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            ch[left] = ch[right];
            ch[right] = ch[left];
            left++;
            right--;
        }
        String str = new String(ch);
        if (str.equalsIgnoreCase(s)) {
            return true;
        }
        return false;
    }
}
