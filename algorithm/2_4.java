/*
윤년,평년 구분하여 현재 경과일 구하기
*/
public class Main {

    public static int[][] mdays = {
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    //윤년은 1, 평년은 0
    public static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    //반환값은 현재까지 경과한 일수
    public static int dayOfYear(int year, int month, int day) {
        while(month-1 > 0) {
            day += mdays[isLeap(year)][month-1];
            month--;
        }
        return day;
    }

    public static void main(String[] args) {
        System.out.println("2018년 10월 19일까지 경과일수는 ==>" + Main.dayOfYear(2018,10,19));

    }
}
