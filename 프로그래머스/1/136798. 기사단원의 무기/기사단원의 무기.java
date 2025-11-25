class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // number -> 기사 단원 수 , limit -> 기준 , power -> 기준 넘으면 줄 공격력
        
        // 각 기사는 자기 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매한다
        
        // 기준보다 넘어가는 약수 개수를 가지면 기준 공격력을 가져간다.
        
        // 공격력 1 = > 1kg
        
        // 구할 것 : 필요한 철의 무게
        
        int sum = 0; // 철 무게 
        
        for(int i = 1 ; i <= number ; i++){
            int attackPoint = getAttackPoint(i);
            if(attackPoint <= limit){
                sum += attackPoint;
            } else {
                sum += power;
            }
        }
        
        
        
        return sum;
    }
    
    public int getAttackPoint(int num){
        int count = 0;
        for(int i = 1; i*i <= num; i++){
            if(num % i == 0){
                if(i * i == num){
                    count +=1;
                } else{
                    count += 2;
                }
            }
        }
        
        return count;
    }
}