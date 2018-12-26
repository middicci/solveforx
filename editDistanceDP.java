import java.util.*;

public class EDITDP{

	int min(int x, int y, int z){
		if(x <= y && x <= z) return x;
		if(y <= x && y <= z) return y;
		else return z;
	}

	int editDist(String str1, String str2, int m, int n){

		int dp[][] = new int[n+1][m+1];

		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++){
				if(i==0)
					dp[i][j] = j;
				else if(j==0)
					dp[i][j] = i;
				else if(str1.charAt(i-1) == str2.charAt(j-1))	
					dp[i][j] = dp[i-1][j-1];
				else {
					dp[i][j] = 1 + min(dp[i][j-1],
									   dp[i-1][j],
									   dp[i-1][j-1]);
				}
				
			}

		return dp[m][n];

	}

	public static void main(String args[]){
		EDITDP ed = new EDITDP();
		String s1 = "abc";
		String s2 = "abd";
		int n = ed.editDist(s1, s2, s1.length(), s2.length());
		System.out.println(n);
	}
}