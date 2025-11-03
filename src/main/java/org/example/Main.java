package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Quotes{
    String quote;
    String writer;
    boolean deleted;
    int num;
    Quotes(String quote, String writer,int num){
        this.quote = quote;
        this.writer = writer;
        this.num = num;
        this.deleted = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("== 명언 앱 == ");

        ArrayList<Quotes> Qts = new ArrayList<Quotes>();

        int Qts_count = 1;

        while(true) {
            System.out.print("명령) ");
            String query = input.nextLine();

            //종료
            if(query.equals("종료"))
                break;
            //등록
            else if (query.equals("등록")) {
                System.out.print("명언 : ");
                String quotes =  input.nextLine();

                System.out.print("작가 : ");
                String writer =  input.nextLine();

                Qts.add(new Quotes(quotes, writer,Qts_count));
                System.out.println(Qts_count + "번 명언이 등록되었습니다.");
                Qts_count++;
            }
            //목록
            else if(query.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------------------");

                for(Quotes q : Qts) {
                    if(!q.deleted){
                        System.out.println(q.num + " / " + q.writer + " / " + q.quote);
                    }
                }
            }
            //삭제
            else if(query.startsWith("삭제")){

                int del_num = Integer.parseInt(query.substring(6));

                boolean det = false;

                for(Quotes q : Qts) {
                    //삭제 가능
                    if(!q.deleted) {
                        if (q.num == del_num) {
                            q.deleted = true;
                            System.out.println(del_num + "번 명언이 삭제되었습니다.");
                            det = true;
                        }
                    }
                }
                // 탐색 실패 / 삭제 불가능
                if(!det) {
                    System.out.println(del_num + "번 명언은 존재하지 않습니다.");
                }
            }
            else if(query.startsWith("수정")){
                int mod_num =  Integer.parseInt(query.substring(6));

                boolean det = false;

                for(Quotes q : Qts) {
                    if(!q.deleted) {
                        //수정 가능
                        if (q.num == mod_num) {
                            System.out.println("명언(기존) : "  +  q.quote);
                            System.out.print("명언 : ");
                            String quotes =  input.nextLine();
                            q.quote = quotes;

                            System.out.println("작가(기존) : "  +  q.writer);
                            System.out.print("작가 : ");
                            String writer =  input.nextLine();
                            q.writer = writer;

                            det = true;
                        }
                    }
                }
                if(!det) {
                    System.out.println(mod_num + "번 명언은 존재하지 않습니다.");
                }
            }

        }
    }
}