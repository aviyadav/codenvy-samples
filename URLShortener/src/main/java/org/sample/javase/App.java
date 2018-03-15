package org.sample.javase;

public class App {
        public static void main (String[] args) {
		int n = 233434;
		String stUrl = idToShortURL(n);
		System.out.println(stUrl);
		System.out.println(shortURLtoID(stUrl));
	}
	
	private static String idToShortURL(int n) {
	    char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	    StringBuilder shortURL = new StringBuilder();
	    while(n > 0) {
	        shortURL.append(map[n % 62]);
	        n = n/62;
	    }
	    
	    return shortURL.reverse().toString();
	}
	
	private static int shortURLtoID(String sURL) {
	    int id = 0;
	    char[] cURL = sURL.toCharArray();
	    for(int i = 0; i < cURL.length; i++) {
	        if('a' <= cURL[i] && cURL[i] <= 'z') {
	            id = id * 62 + cURL[i] - 'a';
	        }
	        if('A' <= cURL[i] && cURL[i] <= 'Z') {
	            id = id * 62 + cURL[i] - 'A' + 26;
	        }
	        if('0' <= cURL[i] && cURL[i] <= '9') {
	            id = id * 62 + cURL[i] - '0' + 52;
	        }
	    }
	    
	    return id;
	}
}
