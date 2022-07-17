package level1;

public class LottoTopRankNBottomRank {
    public static void main(String[] args){
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] winNums = new int[]{31, 10, 45, 1, 6, 19};
        System.out.println(solution(lottos,winNums)[0]);
        System.out.println(solution(lottos,winNums)[1]);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[]{0,0};
        int zeroCnt = 0;
        int correctCnt = 0;

        for(int i = 0; i < win_nums.length; i++){
            for(int j = 0; j < lottos.length; j++){
                if(lottos[j] == win_nums[i]) correctCnt++;
            }
            if(lottos[i] == 0) zeroCnt++;
        }
        answer[0] = zeroCnt + correctCnt;
        answer[1] = correctCnt;

        for(int i = 0; i < 2; i++){
            switch (answer[i]){
                case 6 : answer[i] = 1;
                    break;
                case 5 : answer[i] = 2;
                    break;
                case 4 : answer[i] = 3;
                    break;
                case 3 : answer[i] = 4;
                    break;
                case 2 : answer[i] = 5;
                    break;
                default: answer[i] = 6;
                    break;
            }
        }

        return answer;
    }
}
