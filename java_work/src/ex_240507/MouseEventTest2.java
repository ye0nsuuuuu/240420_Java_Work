package ex_240507;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

import util.RandomSelectNumber;
import util.dto.Person;
import util.eventListener.MyMouseListener;
import util.eventListener.MyMouseListener2;

public class MouseEventTest2 extends JFrame {

	public MouseEventTest2(JLabel jLabel) {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		MyMouseListener2 listener = new MyMouseListener2(jLabel);
		c.addMouseListener(listener);
		c.addMouseMotionListener((MouseMotionListener) listener);
		c.setLayout(null);
		jLabel.setSize(150, 20);
		jLabel.setLocation(100, 80);
		c.add(jLabel); // 레이블 컴포넌트 삽입
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		JLabel la = new JLabel(" Move Me");
		MouseEventTest2 mouseEventTest2 = new MouseEventTest2(la);

	}

}
