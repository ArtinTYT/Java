package MyCalendar;

import java.util.Scanner;

public class Calendar {
	static boolean bissextile = false;
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("请输入年月日(20170825):");
		int nowTime = in.nextInt();			// 201708
		int year = nowTime / 1_0000 - 1;	// 查找头一年
		int month = nowTime % 1_0000 /100;	// 这个月
		int day = nowTime % 100;		    // 几号
		print(year,month,day);
	}
	
	public static void print(int year, int month, int day) {
		int num = y1900(year);			// 判断1900 到 某年的头一天总天数
		int numDay =0;	
		for(int a=1; a<month; a++){		// 计算今年一月～上个月最后一天
			numDay += month_days(a,(year+1));
		}	
		int myBug = (num + numDay+1)%7;	// 查询上个月最后一天星期几 + 1900 1月1号星期一	
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for (int j=0; j<myBug; j++) {
			System.out.print("\t");			// 空格
		}
		for (int i=1; i<= month_days(month,(year+1));i++){
			if(i == day) {
				System.out.print("("+i+")"+"\t");
			} else {
				System.out.print(i+"\t");				
			}
			if ( (i+myBug) % 7 == 0 ) {
				System.out.println();
			} 
		}
	}
	
	public static int y1900(int year){		// 判断1900 到今年头一天的天数
		int num = 0;
		for (int i=1900; i<=year; i++) {
			num += bissextile(i);
		}
		return num;
	}
	
	public static int  bissextile(int year) {		// 判断是否为闰年
		return ( year%4 == 0 && year%100 != 0 || year%400 == 0) ? 366 :	365;
	}
	
	public static int month_days(int month, int year) {	
		switch(month) {
		case 2:
			return bissextile(year)==366 ? 29:28;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
				System.out.println("month function has a error");
				break;
		}
		return -1;
	}
}
