import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int e = 0; e < t; e++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int targetTeamID = Integer.parseInt(str[2]);
            int m = Integer.parseInt(str[3]);

            int[][] su = new int[n + 1][k + 1];
            int[] sum = new int[n + 1];
            int[] cnt = new int[n + 1];
            int[] last = new int[n + 1];

            for (int a = 0; a < m; a++) {
                String[] str2 = br.readLine().split(" ");
                int i = Integer.parseInt(str2[0]);
                int j = Integer.parseInt(str2[1]);
                int s = Integer.parseInt(str2[2]);

                if (su[i][j] < s) {
                    sum[i] -= su[i][j];
                    su[i][j] = s;
                    sum[i] += s;
                }
                cnt[i]++;
                last[i] = a;
            }

            List<Team> teams = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                teams.add(new Team(i, sum[i], cnt[i], last[i]));
            }

            teams.sort((team1, team2) -> {
                if (team1.score != team2.score) {
                    return  team2.score- team1.score; // 점수는 내림차순
                } else if (team1.count != team2.count) {
                    return team1.count- team2.count; // 제출 횟수는 오름차순
                } else {
                    return  team1.lastTime- team2.lastTime; // 마지막 제출 시간은 오름차순
                }
            });

            int rank = 1;
            for (Team team : teams) {
                if (team.id == targetTeamID) {
                    System.out.println(rank);
                    // break;
                }
                rank++;
            }
        }
    }

    static class Team {
        int id;
        int score;
        int count;
        int lastTime;

        Team(int id, int score, int count, int lastTime) {
            this.id = id;
            this.score = score;
            this.count = count;
            this.lastTime = lastTime;
        }
    }
}
