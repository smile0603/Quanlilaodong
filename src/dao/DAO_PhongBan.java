package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongTrinh;
import entity.PhongBan;

public class DAO_PhongBan {
	public ArrayList<PhongBan> layTatPhongBan(){
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhongBan";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maPB = rs.getString(1);
				String tenPB = rs.getString(2);
				PhongBan pb = new PhongBan(maPB, tenPB);
				dsPB.add(pb);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsPB;
	}
	public PhongBan layPhongBanTheoMa(String maPB){
		PhongBan pb = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhongBan where maPhongBan = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maPB1 = rs.getString(1);
				String tenPB = rs.getString(2);
				pb = new PhongBan(maPB1, tenPB);
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return pb;
	}
}
