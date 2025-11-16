import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        Map<String, Map<Integer, Integer>> streaming = new HashMap<>();
        // 장르 , 곡 번호, 재생 수
        int n = genres.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            streaming.putIfAbsent(genres[i], new HashMap<>());
            streaming.get(genres[i]).put(i,plays[i]);
            
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        // 속한 노래가 가장 많이 재생된 장르 수록
        
        // 재생 수 많은 장르대로 나열하기
        List<String> order = new ArrayList<>();
        while(!map.isEmpty()){
            String maxGenre = "";
            int max = Integer.MIN_VALUE;
            
            for(String  key : map.keySet()  ){
            if(max < map.get(key)){
                maxGenre = key;
                max = map.get(key);
                }
            }
            
            order.add(maxGenre);
            map.remove(maxGenre);
        }
        
        List<Integer> res = new ArrayList<>();
        for(String gen : order){
            // 장르 내에서 많이 재생된 노래 수록
            int max1Song = -1;
            int max2Song = -1;
            
            int max1Play = -1;
            int max2Play = -1;
            
            Map<Integer, Integer> stream = streaming.get(gen);
            //곡 번호, 재생 수
            
            for(int song : stream.keySet() ){
                // int song 곡번호
                int play = stream.get(song);
                
                if(play > max1Play){
                    max2Song = max1Song;
                    max2Play = max1Play;
                    
                    
                    max1Song = song;
                    max1Play = play;
                    
                    
                } else if(play == max1Play){
                    
                    if(song < max1Song){
                        // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래 먼저 수록
                        max2Song = max1Song;
                        max2Play = max1Play;
                        
                        max1Song = song;
                        max1Play = play;

                            
                    } else {
                        max2Song = song;
                        max2Play = play;
                    }
                } else if(play > max2Play){
                        max2Song = song;
                        max2Play = play;
                } else if(play == max2Play){
                    if(song < max2Song){
                        max2Song = song;
                        max2Play = play;
                    }
                }
                
                
            }
            
            res.add(max1Song);
            if(max2Song != -1){
                res.add(max2Song);
            }
        }
        
        
        
        
        int[] answer = new int[res.size()];
        
        for(int i = 0; i <res.size(); i++ ){
            answer[i] = res.get(i);
        }
            
    
        
        return answer;
    }
}