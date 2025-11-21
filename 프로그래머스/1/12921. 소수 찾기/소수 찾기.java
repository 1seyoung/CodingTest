class Solution {
    public int solution(int n) {

        // 소수 여부를 저장할 배열 (true = 소수로 가정)
        boolean[] prime = new boolean[n + 1];

        // 0과 1은 소수가 아님 → false
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        // 에라토스테네스의 체 핵심 알고리즘
        // i*i <= n 까지만 확인하면 됨 (i > sqrt(n)이면 이미 모두 처리됨)
        for (int i = 2; i * i <= n; i++) {

            // prime[i]가 true → i는 소수
            // i가 소수라면, i의 배수들은 소수가 아님
            if (prime[i]) {
                // j = i*i부터 시작하는 이유:
                // i * 2, i * 3 ... 은 이미 이전 단계에서 지워짐 (중복 제거)
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false; // i의 배수라서 소수 아님
                }
            }
        }

        // 남아 있는 true 개수 = 소수 개수
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) count++;
        }

        return count;
    }
}