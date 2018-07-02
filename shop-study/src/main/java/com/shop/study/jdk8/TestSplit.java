package com.shop.study.jdk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestSplit {

	public static void main(String[] args) {
		List<String> targetList = new ArrayList<String>();
		for(int i=0;i<1102;i++) {
			targetList.add("a"+i);
		}
	 
		List<List<String>> targetGroups = new ArrayList<List<String>>();
		double targetSize = targetList.size();
		int group = (int) Math.ceil(targetSize / 500.0);
		System.out.println(group);
		for (int i = 0, index = 0; i < group; i++) {
			if ((index + 500) > targetSize) {
				targetGroups.add(targetList.subList(index, (int) targetSize));
				break;
			} else {
				targetGroups.add(targetList.subList(index, index + 500));
			}
			index = index + 500;
		}
		
		for (List<String> list : targetGroups) {
			System.out.println(list.toString());
		}
	}

}
