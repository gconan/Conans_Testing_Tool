package exterminator.utils.test;

import java.util.Scanner;

import exterminator.utils.TextBuilder;

public class test{
	
	public static void main(String[]args){
		int x=0;
		int y=9;
		
		TextBuilder t = new TextBuilder();
		t.increaseTab();
		t.increaseTab();
		t.increaseTab();
		t.increaseTab();
		t.appendNew("4");
		String s = t.toString();
		System.out.println("******");
		System.out.println("|"+s+"|");
		System.out.println("******");
		
		TextBuilder b = new TextBuilder();
		b.increaseTab();
		b.increaseTab();
		b.increaseTab();
		b.increaseTab();
		b.decreaseTab();
		b.decreaseTab();
		b.appendNew("2");
		s=b.toString();
		System.out.println("******");
		System.out.println("|"+s+"|");
		System.out.println("******");
		
	}
}