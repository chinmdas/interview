package com.practice.chin.ds.algo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) throws ParseException {

		System.out.println(firstUniqChar("eetcod"));
	}

	public static int firstUniqChar(String s) {

		if (s == null) {
			return -1;
		} else {
			if (s == null) {
				return -1;
			} else {
				int count = 0;
				if (s == null || s.length() < 1) {
					return -1;
				} else if (s.length() == 1) {
					return 0;
				}

				for (int i=0;i<s.length();i++) {
					if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
						count = s.indexOf(s.charAt(i));

						break;
					}

				}

				return count;
			}
		}
	}

}
