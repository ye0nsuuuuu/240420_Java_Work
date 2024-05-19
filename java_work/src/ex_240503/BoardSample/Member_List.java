package ex_240503.BoardSample;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Member_List extends JFrame implements MouseListener, ActionListener {

	// 동기화를 지원 해주는 컬렉션의 리스트
	Vector v;
	Vector cols;
	// 테이블 기능을 지원해주는 인스턴스
	DefaultTableModel model;
	// 표 형식
	JTable jTable;
	// 스크롤
	JScrollPane pane;
	// 패널은 창에 추가로 붙이는 공간.
	JPanel pbtn;
	// 버튼.
	JButton btnInsert;

	// 생성자
	public Member_List() {
		// 부모 JFrame의 제목을 설정하는 생성자.
		super("회원관리 프로그램  v0.1.1");
		// v=getMemberList();
		// MemberDAO
		// 데이터베이스에 접근 및 crud 기능이 있음.
		MemberDAO dao = new MemberDAO();
		// 디비 내용을 조회한 결과를 받아두기.
		// 순서 있는 리스트
		v = dao.getMemberList();
		//
		System.out.println("v=" + v);
		// 각 열의 정보를 의미.
		// cols , 벡터 타입의 리스트
		cols = getColumn();
		// Vector v;
		// Vector cols;
		model = new DefaultTableModel(v, cols);

		// 자바에서 지원해주는 표 형식. 
		jTable = new JTable(model);
		// 스크롤 기능을 해당 패널에 추가. 
		pane = new JScrollPane(jTable);
		// 프레임이라는 창에 , 요소 붙이기. 
		add(pane);

		// 버튼을 붙이는 패널 , 캔버스 
		pbtn = new JPanel();
		// 버튼 
		btnInsert = new JButton("회원가입");
		// 버튼을 붙이는 패널 , 버튼 붙이기. 
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);

		// 이벤트 핸들러 등록, 
		// 인터페이스이고, -> 추상메서드를 가지고 있으니, 필수 재정의 해주기.
		// 결론, 액션의 역할, 새로운 입력창을 불러오기. 
		jTable.addMouseListener(this); // 리스너 등록
		btnInsert.addActionListener(this); // 회원가입버튼 리스너 등록

		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end 생성자

	// JTable의 컬럼
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("아이디");
		col.add("비밀번호");
		col.add("이름");
		col.add("전화");
		col.add("주소");
		col.add("생일");
		col.add("직업");
		col.add("성별");
		col.add("이메일");
		col.add("자기소개");

		return col;
	}// getColumn

	// Jtable 내용 갱신 메서드
	public void jTableRefresh() {

		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());
		jTable.setModel(model);

	}

	public static void main(String[] args) {
		new Member_List();
	}// main

	// 마우스 클릭시 수행하는 동작. 
	@Override
	public void mouseClicked(MouseEvent e) { // 클릭을 하면, e 라는 인스턴스에 담겨있음. 
		// mouseClicked 만 사용
		// 클릭시 해당 번호를 가지고 온다. 
		int r = jTable.getSelectedRow();
		System.out.println("클릭시 클릭된 행번호 확인: " + r);
		String id = (String) jTable.getValueAt(r, 0);
		System.out.println("클릭시 클릭된 선택된 id 조회: " + id);
		// System.out.println("id="+id);
		// 
		MemberProc mem = new MemberProc(id, this); // 아이디를 인자로 수정창 생성

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 클릭하면
		if (e.getSource() == btnInsert) {
			new MemberProc(this);

			/* 테스트 */
			// dao = new MemberDAO();
			// dao.userSelectAll(model);
			// model.fireTableDataChanged();
			// jTable.updateUI();
			// jTable.requestFocusInWindow();

		}

	}

}