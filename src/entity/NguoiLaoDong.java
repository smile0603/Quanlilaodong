package entity;



public class NguoiLaoDong {
	private String maNLD;
	private String tenNLD;
	private String ngaySinh;
	private boolean gioiTinh;
	private String chucVu;
	private PhongBan phongBan;
	public String getMaNLD() {
		return maNLD;
	}
	public void setMaNLD(String maNLD) {
		this.maNLD = maNLD;
	}
	public String getTenNLD() {
		return tenNLD;
	}
	public void setTenNLD(String tenNLD) {
		this.tenNLD = tenNLD;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	public NguoiLaoDong(String maNLD, String tenNLD, String ngaySinh, boolean gioiTinh, String chucVu,
			PhongBan phongBan) {
		super();
		this.maNLD = maNLD;
		this.tenNLD = tenNLD;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.phongBan = phongBan;
	}
	public NguoiLaoDong(String maNLD) {
		super();
		this.maNLD = maNLD;
	}
	public NguoiLaoDong() {
		super();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNLD == null) ? 0 : maNLD.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NguoiLaoDong other = (NguoiLaoDong) obj;
		if (maNLD == null) {
			if (other.maNLD != null)
				return false;
		} else if (!maNLD.equals(other.maNLD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
