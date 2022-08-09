package entity;

import java.util.ArrayList;
import java.sql.Date;

public class ThamGia {
	private Date ngayThamGia;
	private NguoiLaoDong laoDong;
	private CongViec congViec;
	private CongTrinh congTrinh;
	public Date getNgayThamGia() {
		return ngayThamGia;
	}
	public void setNgayThamGia(Date ngayThamGia) {
		this.ngayThamGia = ngayThamGia;
	}
	
	
	public NguoiLaoDong getLaoDong() {
		return laoDong;
	}
	public void setLaoDong(NguoiLaoDong laoDong) {
		this.laoDong = laoDong;
	}
	public CongViec getCongViec() {
		return congViec;
	}
	public void setCongViec(CongViec congViec) {
		this.congViec = congViec;
	}
	public CongTrinh getCongTrinh() {
		return congTrinh;
	}
	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}

	public ThamGia(Date ngayThamGia, NguoiLaoDong laoDong, CongViec congViec, CongTrinh congTrinh) {
		super();
		this.ngayThamGia = ngayThamGia;
		this.laoDong = laoDong;
		this.congViec = congViec;
		this.congTrinh = congTrinh;
	}
	
	public ThamGia(NguoiLaoDong laoDong) {
		super();
		this.laoDong = laoDong;
	}
	public ThamGia(Date ngayThamGia) {
		super();
		this.ngayThamGia = ngayThamGia;
	}
	public ThamGia() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
