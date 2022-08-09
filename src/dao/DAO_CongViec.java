package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongTrinh;
import entity.CongViec;
import entity.PhongBan;


public class DAO_CongViec {
	public ArrayList<CongViec> layTatCaCongViec(){
		ArrayList<CongViec> dsCV = new ArrayList<CongViec>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CongViec";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maCV = rs.getString(1);
				String tenCV = rs.getString(2);
				CongTrinh ct = new CongTrinh(rs.getString(3));
				String trangThai = rs.getString(4);
				CongViec cv = new CongViec(maCV, tenCV, ct, trangThai);
				dsCV.add(cv);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCV;
	}
}