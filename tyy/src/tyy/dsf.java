package tyy;

import java.util.Scanner;

public class dsf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = new int[4][4];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(i<j)
				{
					a[i][j]=0;
				}
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
