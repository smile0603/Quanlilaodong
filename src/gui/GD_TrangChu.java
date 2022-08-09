package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class GD_TrangChu extends JFrame implements ActionListener, MouseListener {
	private JButton btnQuanLyCongTrinh;
	private JButton btnTrangChu;
	
	private JButton btnQuanLyNhanVien;
	private JPanel panelTacVu;
	private JPanel panelBang;
	private QuanLyCongTrinh QLCT;
	private QuanLyLaoDong QLLD;
	private JButton btnThoat;
	
	public GD_TrangChu() throws Exception {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 450, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit (). getScreenSize ();
		setTitle("Phần mềm quản lí lao động");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (screenSize.width, screenSize.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panelTieuDe = new JPanel();
		panelTieuDe.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelTieuDe.setBounds(0, 0, 1350, 78);
		panelTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(panelTieuDe);
		JLabel lblNewLabel = new JLabel("Công Ty XXX");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panelTieuDe.add(lblNewLabel);
		
		panelTacVu = new JPanel();
		panelTacVu.setBounds(10, 99, 358, 575);
		getContentPane().add(panelTacVu);
		panelTacVu.setLayout(null);
		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQuanLyNhanVien.setBounds(10, 221, 338, 65);
		panelTacVu.add(btnQuanLyNhanVien);
		btnQuanLyCongTrinh = new JButton("Quản lý công trình");
		btnQuanLyCongTrinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQuanLyCongTrinh.setBounds(10, 366, 338, 65);
		panelTacVu.add(btnQuanLyCongTrinh);
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTrangChu.setBounds(10, 87, 338, 65);
		panelTacVu.add(btnTrangChu);
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThoat.setBounds(10, 499, 338, 65);
		panelTacVu.add(btnThoat);
		panelBang = new JPanel();
		panelBang.setBounds(378, 99, 972, 575);
		getContentPane().add(panelBang);
		panelBang.setLayout(null);
		String col[] = {"Mã Nhân Viên","Tên Nhân Viên","Ngày sinh","Giới tính","Chức Vụ","Phòng Ban"};
		DefaultTableModel tbmodel = new DefaultTableModel(col,0);
		JLabel lblDSNLD = new JLabel("HỆ THỐNG QUẢN LÝ PHÂN CÔNG LAO ĐỘNG");
		lblDSNLD.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblDSNLD.setBounds(131, 10, 634, 44);
		panelBang.add(lblDSNLD);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(10, 80, 952, 485);
		panelBang.add(lblNewLabel_1);
		ImageIcon icon = new ImageIcon("D:\\LTHSK\\HuynhCongTruyen\\QuanLyLaoDong\\icon\\java.jpg");
		lblNewLabel_1.setIcon(icon);
		btnTrangChu.setBackground(Color.cyan);
		btnQuanLyCongTrinh.setBackground(Color.cyan);
		btnQuanLyNhanVien.setBackground(Color.cyan);
		btnThoat.setBackground(Color.cyan);
		btnQuanLyNhanVien.addActionListener(this);
		btnQuanLyCongTrinh.addActionListener(this);
		btnTrangChu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnQuanLyNhanVien.addMouseListener(this);
		btnQuanLyCongTrinh.addMouseListener(this);
		btnThoat.addMouseListener(this);
		QLCT = new QuanLyCongTrinh();
		QLLD = new QuanLyLaoDong();
		
	}
	public static void main(String[] args) throws Exception {
		new GD_TrangChu().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(btnQuanLyCongTrinh)) {
			QLCT.setVisible(true);
			
		}
		else if(object.equals(btnQuanLyNhanVien)) {
			QLLD.setVisible(true);
		}else if(object.equals(btnThoat)) {
			this.dispose();
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnQuanLyNhanVien)) {
			btnQuanLyNhanVien.setBackground(Color.LIGHT_GRAY);
			btnTrangChu.setBackground(Color.cyan);
			btnQuanLyCongTrinh.setBackground(Color.cyan);
			btnThoat.setBackground(Color.cyan);
		}
		else if(o.equals(btnQuanLyCongTrinh)) {
			btnQuanLyNhanVien.setBackground(Color.cyan);
			btnTrangChu.setBackground(Color.cyan);
			btnQuanLyCongTrinh.setBackground(Color.LIGHT_GRAY);
			btnThoat.setBackground(Color.cyan);
		}
		else if(o.equals(btnThoat)) {
			btnQuanLyNhanVien.setBackground(Color.cyan);
			btnTrangChu.setBackground(Color.cyan);
			btnQuanLyCongTrinh.setBackground(Color.cyan);
			btnThoat.setBackground(Color.LIGHT_GRAY);
		}
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
