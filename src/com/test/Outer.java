package com.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tool.Tool;

public class Outer {

	private int age = 100;

	class Innter {
		public void sayAge() {
			Tool.print(age);
		}
	}

	public void fn() {
		final int sal = 100;
		class ClassInMethod {
			public void say1() {
				Tool.print(sal);
			}
		}
	}
	
	public void fn2(){
//		new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		};
		//like 
		class MyAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}
		
		ActionListener al = new MyAction();
		
	}
	
}
