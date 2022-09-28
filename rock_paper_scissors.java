package rock_paper_scissors;

public class Test_3 {
	static String a;	
	static String b;
	static String[] x = {
			"剪子",
			"石头",
			"布"
	};
	static int n;
	static int h;
	static String result;
	
	public static void A() {
		n = (int) (Math.random()*3 ); // 0 1 2
		a = x[n];
		h = (int) (Math.random()*3 );
		b = x[h];
		if ( a.equals(b) ) {
			A();
		} else {
			System.out.println("玩家A："+ a +"\t\t玩家B："+ b);
		}
	}
	
	public static void B() {
		if ( n % 2 == h % 2 ) {
			result = h > n ? "A 赢":" B 赢";
		} else {
			result = n > h ? "A 赢" : "B 赢";
		}
	}
	
	public static void main(String[] args) {
		A();
		B();
		System.out.println(result);
	}
}


public static void main(String[] args){
		int a1 = (int)( 3*(Math.random()) ) + 1;
		int a2 = (int)( 3*(Math.random()) ) + 1;
		String str1 = a1 == 1 ? "石头" : a1 == 2 ? "剪刀" : "布";
		String str2 = a2 == 1 ? "石头":a2==2?"剪刀":"布";
		System.out.println("甲出-----"+ str1);
		System.out.println("乙出-----"+ str2);
		
		int n = a1 %3 + 1 == a2 ? 2 : a2 % 3 + 1 == a1 ? 1 : 0;
		
		String str3 = n == 0 ? "平局" : n==1 ? "乙赢" : "甲赢";
		System.out.println( str3 );
	}
