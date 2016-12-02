package tn.enis.clients;

import java.math.BigInteger;

public class testL {

	public static void main(String[] args) {
		String passwd = "abcde";
		System.out.println(passwd.hashCode());
		long hash = 1;
	     hash = hash * 17 + passwd.hashCode();
	     hash = hash * 31 + (passwd.hashCode()+hash);
	     hash = hash * 29+198751329;
	     System.out.println(hash);
	}
}
