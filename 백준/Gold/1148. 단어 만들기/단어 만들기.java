import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> dict = new ArrayList<>();
        String s;
        
        // 1. 사전 단어 입력
        while (!(s = br.readLine()).equals("-")) {
            dict.add(s);
        }

        
        // 2. 퍼즐 입력 및 처리
        while (!(s = br.readLine()).equals("#")) {
            
            char[] puzzleChar = s.toCharArray();
            int[] puzzleCount = new int[26];

            // 퍼즐 문자 빈도 계산 
            for (char c : puzzleChar) {   //LEPAPBNAM
                puzzleCount[c - 'A']++;
            }

            int[] result = new int[26]; // 각 문자별 가능한 단어 개수 초기화 0
            
            int[] wordCount = new int[26];

            
            // 각 단어에 대하여 검사
            out: for (String word : dict) {
                
                  for (int i = 0; i < 26; i++) {
                    wordCount[i]=0;
                }
                
                for (char c : word.toCharArray()) {
                    wordCount[c - 'A']++;
                }

                // 퍼즐 문자를 이용해 단어 생성 가능한지 검사
                for (int i = 0; i < 26; i++) {
                    if (wordCount[i] > puzzleCount[i]) {
                        continue out;
                    }
                }

                // 퍼즐 문자의 각 문자가 그 단어에 포함되어 있으면 카운트 증가
                 for (int i = 0; i < 26; i++) {
                     if(puzzleCount[i]==0){
                        continue;
                    }
                     if(wordCount[i]==0){
                        continue;
                    }
                     
                     result[i]++;
                }
                
            }


            // 결과에서 min, max 값을 구하고 해당 문자 추출
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            List<Character> minChars = new ArrayList<>();
            List<Character> maxChars = new ArrayList<>();

            for( int i=0;i<26;i++){

                if(puzzleCount[i]==0){
                    continue;
                }
                
                min=Math.min(min,result[i]);
                max=Math.max(max,result[i]);
            }

              for( int i=0;i<26;i++){ 
                  
                if(puzzleCount[i]==0){
                    continue;
                }
                  
                  if(min==result[i])
                  {
                        // System.out.println(i+" "+min );
                      
                       minChars.add( (char) (i+'A'));
                  }

                  if(max==result[i])
                  {
                        // System.out.println(i );
                      
                       maxChars.add( (char) (i+'A'));
                      
                  }
                  
            }
            
           

            // 정렬 후 출력
            Collections.sort(minChars);
            Collections.sort(maxChars);

            StringBuilder minStr = new StringBuilder();
            for (char c : minChars) minStr.append(c);
            
            StringBuilder maxStr = new StringBuilder();
            for (char c : maxChars) maxStr.append(c);

            System.out.println(minStr.toString() + " " + min + " " + maxStr.toString() + " " + max);
            
        }
    }
}
