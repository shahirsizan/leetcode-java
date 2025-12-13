//https://leetcode.com/problems/encode-and-decode-strings/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

//	encode method
	public String encode(List<String> stringsList) {
		StringBuilder encodedString = new StringBuilder();

		for (String str : stringsList) {
			//	append length of string
			encodedString.append(str.length());
			// append '/' is delimiter
			encodedString.append('/');
			//	append actual string
			encodedString.append(str);
		}

		// ["Hello", "World"] -> encoding -> "5/Hello5/World"
		return encodedString.toString();
	}

	//	decode method
	public List<String> decode(String receivedEncodedString) {
		List<String> decodedList = new ArrayList<>();

		int i = 0;
		while (i < receivedEncodedString.length()) {
			// extract the word length:
			//		1. get delimiter index
			//		2. extract from current `i` index upto delimiter index, this is `length`, convert -> int
			//		3. extract substring from `delimiter index` with a `length` offset
			int delimiterIndex = receivedEncodedString.indexOf('/', i);
			int length = Integer.parseInt(receivedEncodedString.substring(i, delimiterIndex));
			int stringStart = delimiterIndex + 1;
			int stringEnd = stringStart + length;
			decodedList.add(receivedEncodedString.substring(stringStart, stringEnd));

			i = stringEnd;
		}

		return decodedList;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		Codec codec = new Codec();

		// Test Case 1: Simple strings
		List<String> strs1 = Arrays.asList("Hello", "World");
		String encoded1 = codec.encode(strs1);
		List<String> decoded1 = codec.decode(encoded1);
		System.out.println("--- Test 1 ---");
		System.out.println("Original: " + strs1);
		System.out.println("Encoded: \"" + encoded1 + "\"");
		System.out.println("Decoded: " + decoded1);

		System.out.println("-----------------");

		// Test Case 2: Edge case with delimiter and empty string
		List<String> strs2 = Arrays.asList("data/1", "", "abc");
		String encoded2 = codec.encode(strs2);
		List<String> decoded2 = codec.decode(encoded2);
		System.out.println("--- Test 2 (Edge Cases) ---");
		System.out.println("Original: " + strs2);
		System.out.println("Encoded: \"" + encoded2 + "\"");
		System.out.println("Decoded: " + decoded2);
	}
}