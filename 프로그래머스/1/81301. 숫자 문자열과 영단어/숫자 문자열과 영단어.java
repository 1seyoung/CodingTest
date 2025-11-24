class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i < arr.length; i++){
            if("0123456789".contains(String.valueOf(arr[i]))){
                sb.append(arr[i]);
                continue;
            }
            
            if(arr[i] == 'z'){ // zero
                sb.append('0');
                i = i+3;
                continue;
            }
            if(arr[i] == 'o'){ // one 
                sb.append('1');
                i = i+2;
                continue;
            }
            
            if(arr[i] == 't'){ // two, three
                if(arr[i+1] == 'w'){
                    sb.append('2');
                    i = i+2;
                    continue;
                } else {
                    sb.append('3');
                    i  = i+4;
                    continue;
                }
            }
            
            if(arr[i]=='f') {//four , five
                if(arr[i+1] == 'o'){
                    sb.append('4');
                    i = i +3;
                    continue;
                } else {
                    sb.append('5');
                    i = i +3;
                    continue;
                }
            }
            
            if(arr[i] == 's'){ // six, seven
                if(arr[i+1]=='i'){
                    sb.append('6');
                    i = i+2;
                    continue;
                } else{
                    sb.append('7');
                    i = i + 4;
                    continue;
                }
            }
            
            if(arr[i] == 'e'){ // eight
                sb.append('8');
                i = i+4;
                continue;
            }
            
            if(arr[i] == 'n'){ // nine
                sb.append('9');
                i = i+3;
                continue;
            }
        }
        
        return Integer.valueOf(sb.toString());
    }
}