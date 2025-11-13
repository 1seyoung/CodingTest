class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int bonusCan = n /10;
        answer = n *12000 + (k-bonusCan)*2000;
        return answer;
    }
}