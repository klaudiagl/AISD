package zad2;



public final class LCSAlgorithm {

	public static String findLCS(String word1, String word2){
		
		int n = word1.length();
		int m = word2.length();
		int[][] arr = new int[n+1][m+1];
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= m; j++){
				if(i == 0 || j ==0)
					arr[i][j] = 0;
				else{
					if(word1.charAt(i-1) == word2.charAt(j-1)){
						arr[i][j] = arr[i-1][j-1] + 1;
					}
					else{
						arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
					}
				}
			}
		}

		int p1 = n;
		int p2 = m;
		String result = "";
		String temp;
		
		while(arr[p1][p2] != 0){
			if(word1.charAt(p1-1) == word2.charAt(p2-1)){
				temp = result;
				result = "" + word1.charAt(p1 - 1);
				result += temp;
				p1 -= 1;
				p2 -= 1;
			}
			else if(arr[p1][p2] == arr[p1][p2-1]){
				p2 -= 1;
			}
			else if(arr[p1][p2] == arr[p1-1][p2]){
				p1 -= 1;
			}
		}
		return result;
	}

}
