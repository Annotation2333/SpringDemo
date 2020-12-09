package com.example.spring;

import java.util.Scanner;

public class MAIN {
    private final static String NOT_UP_TIME = "未上线";

    private final static String YEAR = "年";

    private final static String MONTH = "月";
    private final static String ONE_MONATH = "1月";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入天数: ");
            Integer useTime = sc.nextInt();
            String converTime = test(useTime);
            System.out.println(converTime);
        }
    }

    private static String test(Integer useTime) {
        String convertUseTime;
        if (useTime < 0) {
            convertUseTime = NOT_UP_TIME;
            return convertUseTime;
        } else if (useTime >= 0 && useTime < 30) {
            convertUseTime = ONE_MONATH;
            return convertUseTime;
        } else {
            //整年数(考虑360-365之间的天数)
            Integer years = useTime / 365;
            //非整年剩余天数
            Integer days = useTime % 365;
            //计算月份
            Integer months = days / 30;
            //非整月剩余天数
            Integer monthDays = days % 30;
            months = months != 12 && monthDays > 0 ? months + 1 : months;
            if (months == 12) {
                months = 0;
                years = years + 1;
            }
            String year = years>0?years+YEAR:"";
            String month = months>0?months+MONTH:"";
            convertUseTime = year+month;
            return convertUseTime;
        }
    }
}
