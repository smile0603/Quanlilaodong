package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_CongTrinh;
import entity.CongTrinh;
import entity.NguoiLaoDong;

public class ThemCongTrinh extends JFrame implements ActionListener{
	private JTextField txtMaCT;
	private JTextField txtTenCT;
	private JTextField txtDiaChi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnThoat;
	private JDateChooser date_CapPhep;
	private JDateChooser date_KhoiCong;
	private JDateChooser date_HoanThanh;
	private JTextComponent txtMess;
	private DAO_CongTrinh daoCT;
	public ThemCongTrinh() throws Exception {
		// TODO Auto-generated constructor stub
		
		setBounds(100, 100, 896, 497);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Nhập thông tin công trình");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(282, 11, 334, 41);
		getContentPane().add(lblNewLabel);
		
		txtMess = new JTextField();
		txtMess.setBounds(20,40 , 300, 20);
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(txtMess);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 63, 860, 384);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã công trình:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 11, 130, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên công trình:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(21, 60, 130, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(21, 118, 130, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày cấp phép:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(21, 185, 130, 28);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày khởi công:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(368, 185, 130, 28);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày dự kiến HT:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(10, 249, 157, 28);
		panel.add(lblNewLabel_1_5);
		
		txtMaCT = new JTextField();
		txtMaCT.setBounds(161, 9, 592, 36);
		panel.add(txtMaCT);
		txtMaCT.setColumns(10);
		
		txtTenCT = new JTextField();
		txtTenCT.setColumns(10);
		txtTenCT.setBounds(161, 58, 592, 36);
		panel.add(txtTenCT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(161, 116, 592, 36);
		panel.add(txtDiaChi);
		
		date_CapPhep = new JDateChooser();
		date_CapPhep.setBounds(161, 177, 163, 36);
		date_CapPhep.setDateFormatString("yyyy-MM-dd");
		panel.add(date_CapPhep);
		
		date_KhoiCong = new JDateChooser();
		date_KhoiCong.setBounds(521, 177, 163, 36);
		date_KhoiCong.setDateFormatString("yyyy-MM-dd");
		panel.add(date_KhoiCong);
		
		
		date_HoanThanh = new JDateChooser();
		date_HoanThanh.setBounds(161, 249, 563, 36);
		date_HoanThanh.setDateFormatString("yyyy-MM-dd");
		panel.add(date_HoanThanh);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 299, 840, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(75, 23, 133, 40);
		panel_1.add(btnThem);
		
		btnXoa = new JButton("Xóa rỗng");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(328, 23, 133, 40);
		panel_1.add(btnXoa);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(573, 23, 133, 40);
		panel_1.add(btnThoat);
		
	
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		daoCT = new DAO_CongTrinh();
		ConnectDB.getInstance().connect();
		
	}
	public static void main(String[] args) throws Exception {
		new ThemCongTrinh().setVisible(true);
	}
	private void xoaRongTextfields() {
	
		txtMaCT.setText("");
		txtTenCT.setText("");
		txtDiaChi.setText("");
		date_CapPhep.setCalendar(null);
		date_KhoiCong.setCalendar(null);
		date_HoanThanh.setCalendar(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			this.dispose();
		}
		else if(o.equals(btnXoa)) {
			xoaRongTextfields();
		}
		else if(o.equals(btnThem)) {
			if(validData()) {
				CongTrinh ct;
				try {
					ct = reverseCTFromTxtField();
					if(daoCT.themCongTrinh(ct)) {
						JOptionPane.showMessageDialog(this,"Thêm thành công");
						
						try {
							new QuanLyCongTrinh().setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(this,"Trùng mã");
					}
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
			}
		}
		
	}
	
	private boolean validData() {
		String maCT = txtMaCT.getText().trim();
		String tenCT = txtTenCT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = ((JTextField)date_CapPhep.getDateEditor().getUiComponent()).getText();
		
		String s1 = ((JTextField)date_KhoiCong.getDateEditor().getUiComponent()).getText();
		String s2 = ((JTextField)date_HoanThanh.getDateEditor().getUiComponent()).getText();
		
		// Có 5 ký tự 2 chữ, theo sau là 3 ký số
		if (!(maCT.length() > 0 && maCT.matches("[A-Z]{2}\\d{3}"))) {
			showMessage("Error: Mã Công trình (AA123)", txtMaCT);
			return false;
		}
		//chữ và số
		if (!(tenCT.length() > 0 && tenCT.matches("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+"))) {
			showMessage("Error: Tên Công trình bao gồm chữ và số", txtTenCT);
			return false;
		}
		//chữ và số và /
		if (!(diaChi.length() > 0 && diaChi.matches("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ /]+"))) {
			showMessage("Error: Địa chỉ bao gồm chữ và số", txtDiaChi);
			return false;
		}
		if (s.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày cấp phép", "Warning!", JOptionPane.ERROR_MESSAGE);
		    return false;
		}
		if (s1.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày khởi công", "Warning!", JOptionPane.ERROR_MESSAGE);
		    return false;
		}
		if (s2.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày Hoàn thành dự kiến", "Warning!", JOptionPane.ERROR_MESSAGE);
		    return false;
		}
		

		return true;
	}
	public CongTrinh reverseCTFromTxtField() throws ParseException{
		String maCT = txtMaCT.getText().trim();
		String tenCT = txtTenCT.getText().trim();
		String diaDiem = txtDiaChi.getText().trim();
		String s = ((JTextField)date_CapPhep.getDateEditor().getUiComponent()).getText();
		String s1 = ((JTextField)date_KhoiCong.getDateEditor().getUiComponent()).getText();
		String s2 = ((JTextField)date_HoanThanh.getDateEditor().getUiComponent()).getText();
		Date ngayCP =Date.valueOf(s);
		Date ngayKC =Date.valueOf(s1);
		Date ngayHT =Date.valueOf(s2);
		CongTrinh ct = new CongTrinh(maCT, tenCT, diaDiem, ngayCP, ngayKC, ngayHT);
		return ct;
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}

	
}
