package com.dfw.dfw.service


import org.apache.commons.lang3.RandomUtils
import org.springframework.stereotype.Service

@Service
class DfwServiceUtils {
	
		public static String alphaNumericString(int len) {
    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rnd = new Random();

    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
        sb.append(AB.charAt(rnd.nextInt(AB.length())));
    }
    return sb.toString();
}

		
}
