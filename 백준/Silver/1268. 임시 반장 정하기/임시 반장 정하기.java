import java.io.*;

public class Main {
   public static void main(String[] args) throws Exception {
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
           String str2 = br.readLine();
           int n=Integer.parseInt(str2);
       

       int [][]cnt=new int[5][10]; //학생 학년
       int [][]stu=new int[n][5];  //학생 학년ㄴ

       
       for(int i=0;i<n ;i++) //학생
       { 
           String[] str = br.readLine().split(" ");
           int v=0;
           for(int j=0;j<5;j++) //학년
           {
               v=Integer.parseInt(str[j] ); //반ㅂ
               // cnt[i][j]=v;
               stu[i][j]= v;
               // System.out.println(i+" "+"ㅊㅊ" +cnt[i][v]+" "+v);
               
           }
                   
       }
// 2
// 1 1 1 1 1
// 2 2 2 2 2

       
// 4
// 4 1 9 6 4
// 8 5 2 4 4
// 6 5 2 6 2
// 8 4 2 2 4
       
       int [] person=new int[n];
       int max=-1;
       int maxperson=0;
       
       for(int i=0;i<n ;i++) //학생.
       {
           boolean []visit=new boolean[n];
           
           for(int j=0;j<5;j++) //학년마다ㅁ
           { 
               int v=stu[i][j]; //반ㅂ

               for(int k=i+1;k<n;k++){
                   int v2=stu[k][j]; //반ㅂ

                   if(v==v2&&!visit[k])
                   {
                       person[i]++;
                       person[k]++;
                       
                       visit[k]=true;
                   }
                   
               }

               
               // person[i]+=cnt[j][v]-1;

               
           // System.out.println(i+" "+"dd" +person[i]+" "+cnt[i][v]+" "+v);
               
           }
           
           // System.out.println(i+" "+"pp" +person[i]);
           
           if(max<person[i]){

               max=person[i];
               maxperson=i+1;
           }
           
       }

       System.out.println(maxperson);
           

   } 
}
