package level1;

public class CompressString {
    public static void main(String[] args) {
        String str = "werwerwsdgsdfsdfsdf";
        System.out.println(compress(str));
    }

    static int compress(String str) {
        int answer = Integer.MAX_VALUE;
        if(str.length() == 1){
            return 1;
        }
        for (int i = 1; i <= str.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;

            String pivot = str.substring(0, i); // 기준 문자
            for (int j = 0; j <= str.length(); j += i) {
                if (j + i >= str.length()) {
                    if (cnt >= 0) {
                        if (pivot.equals(str.substring(j, str.length()))) {
                            sb.append(++cnt + pivot);
                        } else {
                            if(cnt > 1){
                                sb.append(cnt + pivot + str.substring(j , str.length()));
                            } else{
                                sb.append(pivot + str.substring(j , str.length()));
                            }
                        }

                    } else sb.append(i + str.length());
                    break;
                }

                if (str.substring(j, j + i).equals(pivot)) {
                    cnt++;
                } else {
                    if(cnt <= 1){
                        sb.append(pivot);
                    } else{
                        sb.append(cnt + pivot);
                    }
                    pivot = str.substring(j, j + i);
                    cnt = 1;
                }

            }
            String res = sb.toString();
            if (answer >= res.length()) {
                answer = res.length();
            }
        }
        return answer;
    }
}
