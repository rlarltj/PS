class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=3;i<brown+yellow;i++){
            int width = (brown+yellow)/i; 
            if(width>=i){
                 if ((i - 2) * (width - 2) == yellow) {
                answer[0] = width;
                answer[1] = i;
                break;
                }
            }
        }
        return answer;
    }
}