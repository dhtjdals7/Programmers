package level1;


import java.util.Deque;
import java.util.LinkedList;

public class RecommendNewID {
    public static void main(String[] args){
        String str = "...!@BaT#*..y.abcdefghijklm";

        // 1단계 대문자를 소문자로
        str = str.toLowerCase();

        // 2단게 특수문자 제거
        String str2 = "";
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(Character.isLowerCase(chars[i])){
                str2 += chars[i];
            } else if(Character.isDigit(chars[i])){
                str2 += chars[i];
            } else if(chars[i] == '-'){
                str2 += chars[i];
            } else if(chars[i] == '_'){
                str2 += chars[i];
            } else if(chars[i] == '.'){
                str2 += chars[i];
            }
        }

        // 3단계 마침표가 연속으로 2개이상 나오는거 -> . 으로 치환
        chars = str2.toCharArray();
        String str3 = "";
        int i = 0;
        while(i < chars.length){
            if(chars.length == 1){
                str3 += chars[i];
                break;
            }
            if(chars[i] == '.'){
                for(int k = i; k < chars.length; k++){
                    if(k + 1 >= chars.length || chars[k + 1] != '.'){
                        str3 += ".";
                        i = k;
                        break;
                    }
                }
            } else{
                str3 += chars[i];
            }
            i++;
        }

        // 4단계 아이디의 처음에 위치한 '.'가 제거
        Deque<Character> deque = new LinkedList<>();
        String str4 = "";
        for(int k = 0; k < str3.length(); k++){
            deque.add(str3.charAt(k));
        }

        if(deque.size() > 1){
            if(deque.peekFirst() == '.'){
                deque.pollFirst();
            }
            if(deque.peekLast() == '.'){
                deque.pollLast();
            }
        } else if(deque.size() == 1){
            if(deque.peekFirst() == '.'){
                deque.pollFirst();
            }
        }

        for(char c : deque){
            str4 += c;
        }

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입
        String str5 = "";
        if(str4.trim().equals("")){
            str5 += "a";
        } else{
            str5 += str4;
        }

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String str6 = "";
        if(str5.length() >= 16){
            str6 = str5.substring(0, 15);
        } else{
            str6 += str5;
        }

        if(str6.charAt(str6.length() - 1) == '.'){
            str6 = str6.substring(0, str6.length() - 1);
        }

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String str7 = "";
        if(str6.length() <= 2){
            str7 += str6;
            for(int k = str6.length(); k < 3; k++){
                str7 += str6.charAt(str6.length() - 1);
            }
        } else{
            str7 += str6;
        }

        System.out.println(str7);
    }
}
