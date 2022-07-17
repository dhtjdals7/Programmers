package level1;

import java.util.*;

public class ReceiveReport {
    public static void main(String[] args){

    }

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        List<UserInfo> usrList = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < id_list.length; i++){
            usrList.add(new UserInfo(0, id_list[i]));
        }

        for(int i = 0; i < report.length; i++){
            if(set.contains(report[i])){
                continue;
            } else{
                for(UserInfo usrInfo : usrList ){
                    String receiver = report[i].split(" ")[1];
                    if(receiver.equals(usrInfo.name)){
                        usrInfo.setCnt();
                        if(usrInfo.cnt >= 2){

                        }
                    }
                }
                set.add(report[i]);
            }
        }
        for(int i = 0; i < id_list.length; i++){

        }

        return answer;
    }

    static class UserInfo{
        int cnt;

        String name;

        public UserInfo(int cnt, String name){
            this.cnt = cnt;
            this.name = name;
        }

        public void setCnt(){
            this.cnt++;
        }

        public String toString(){
            return "cnt = " + this.cnt + ", name = " +this.name;
        }
    }
}
