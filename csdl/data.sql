USE [CSDL_QLLD]
GO
/****** Object:  Table [dbo].[CongTrinh]    Script Date: 5/31/2021 5:26:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongTrinh](
	[maCT] [nvarchar](50) NOT NULL,
	[tenCT] [nvarchar](50) NULL,
	[diaDiemCT] [nvarchar](50) NULL,
	[ngayCapPhep] [datetime] NULL,
	[ngayKhoiCong] [datetime] NULL,
	[ngayHoanThanhDuKien] [datetime] NULL,
 CONSTRAINT [PK_CongTrinh] PRIMARY KEY CLUSTERED 
(
	[maCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongViec]    Script Date: 5/31/2021 5:26:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongViec](
	[maCV] [nvarchar](50) NOT NULL,
	[tenCV] [nvarchar](500) NULL,
	[maCT] [nvarchar](50) NULL,
 CONSTRAINT [PK_CongViec] PRIMARY KEY CLUSTERED 
(
	[maCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiLaoDong]    Script Date: 5/31/2021 5:26:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiLaoDong](
	[maNLD] [nvarchar](50) NOT NULL,
	[tenNLD] [nvarchar](100) NULL,
	[ngaySinh] [nvarchar](50) NULL,
	[gioiTinh] [nvarchar](10) NULL,
	[chucVu] [nvarchar](50) NULL,
	[phongBan] [nvarchar](50) NULL,
 CONSTRAINT [PK_NguoiLaoDong] PRIMARY KEY CLUSTERED 
(
	[maNLD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThamGia]    Script Date: 5/31/2021 5:26:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThamGia](
	[ngayTG] [datetime] NULL,
	[congViec] [nvarchar](200) NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[maCV] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ThamGia] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC,
	[maCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CongTrinh] ([maCT], [tenCT], [diaDiemCT], [ngayCapPhep], [ngayKhoiCong], [ngayHoanThanhDuKien]) VALUES (N'CKO111', N'ONE VERANDAH', N'TP H? Chí Minh', CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime))
INSERT [dbo].[CongTrinh] ([maCT], [tenCT], [diaDiemCT], [ngayCapPhep], [ngayKhoiCong], [ngayHoanThanhDuKien]) VALUES (N'CKS111', N'Chung cư Sunshine Horizon', N'TP H? Chí Minh', CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime))
INSERT [dbo].[CongTrinh] ([maCT], [tenCT], [diaDiemCT], [ngayCapPhep], [ngayKhoiCong], [ngayHoanThanhDuKien]) VALUES (N'CKV111', N'Chung cư Verosa Park', N'TP H? Chí Minh', CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime))
INSERT [dbo].[CongTrinh] ([maCT], [tenCT], [diaDiemCT], [ngayCapPhep], [ngayKhoiCong], [ngayHoanThanhDuKien]) VALUES (N'CKX111', N'Chung cư Hà Đô', N'TP H? Chí Minh', CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime))
INSERT [dbo].[CongTrinh] ([maCT], [tenCT], [diaDiemCT], [ngayCapPhep], [ngayKhoiCong], [ngayHoanThanhDuKien]) VALUES (N'TDC111', N'Khu tái định cư Tam Quang', N'Quảng Nam', CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime), CAST(N'1900-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CongViec] ([maCV], [tenCV], [maCT]) VALUES (N'NVGS11', N'Nhân viên giám sát', NULL)
INSERT [dbo].[CongViec] ([maCV], [tenCV], [maCT]) VALUES (N'NVTK11', N'Nhân viên thi?t k?', NULL)
INSERT [dbo].[CongViec] ([maCV], [tenCV], [maCT]) VALUES (N'QLCL11', N'Nhân viên qu?n l? ch?t lư?ng', NULL)
INSERT [dbo].[CongViec] ([maCV], [tenCV], [maCT]) VALUES (N'TTCT11', N'Nhân viên th?c thi công tr?nh', NULL)
GO
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'QLNS11', N'Nguyễn Nhật Nam', N'2/4/1989', N'Nam', N'Quản lý', N'Quản Lý Nhân Sự')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'QLNS16', N'Nguyễn Thị Nhung', N'9/5/1979', N'Nữ', N'Quản Lý', N'Quản Lý Nhân Sự')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'QLNS26', N'Nguyễn Anh Tú', N'5/6/1994', N'Nữ', N'Quản Lý', N'Quản Lý Nhân Sự')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD12', N'Lê Văn Tám', N'7/8/1998', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD13', N'Nguyễn Duy Trung', N'29/10/2000', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD14', N'Nguyễn Duy Tâm', N'2/4/1999', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD15', N'Cao Thành Nam', N'7/9/1998', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD17	', N'Nguyễn Thành Sang', N'20/10/1999', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD18', N'Nguyễn Thành Nam', N'20/1/1999', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD19 ', N'Lê Thành Sang', N'20/12/1999', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD20', N'Lê Công Sơn', N'7/8/1995', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD21', N'Nguyễn Trúc Nhân', N'2/1/2003', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD22', N'Hồ Dương KHa', N'9/10/1996', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD23', N'Nguyễn Thanh Nhàn', N'2/1/2003', N'Nữ', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD24', N'Bạch Tiến Đạt', N'20/12/2000', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD25', N'Lê Bá Thọ', N'16/7/2000', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD27', N'Nguyễn Anh Thư', N'4/5/1990', N'Nữ', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD28', N'Lê Bá Thọ', N'16/7/2000', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD29', N'Hồ Hiền Quang', N'4/4/1990', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD30', N'Nguyễn Kỳ Duyên', N'4/5/1990', N'Nữ', N'Nhân Viên', N'Tổ Chức Lao Động')
INSERT [dbo].[NguoiLaoDong] ([maNLD], [tenNLD], [ngaySinh], [gioiTinh], [chucVu], [phongBan]) VALUES (N'TCLD31', N'Nguyễn Duy Khánh', N'2/1/2000', N'Nam', N'Nhân Viên', N'Tổ Chức Lao Động')
GO
ALTER TABLE [dbo].[CongViec]  WITH CHECK ADD  CONSTRAINT [FK_CongViec_CongTrinh] FOREIGN KEY([maCT])
REFERENCES [dbo].[CongTrinh] ([maCT])
GO
ALTER TABLE [dbo].[CongViec] CHECK CONSTRAINT [FK_CongViec_CongTrinh]
GO
ALTER TABLE [dbo].[ThamGia]  WITH CHECK ADD  CONSTRAINT [FK_ThamGia_CongViec] FOREIGN KEY([maCV])
REFERENCES [dbo].[CongViec] ([maCV])
GO
ALTER TABLE [dbo].[ThamGia] CHECK CONSTRAINT [FK_ThamGia_CongViec]
GO
ALTER TABLE [dbo].[ThamGia]  WITH CHECK ADD  CONSTRAINT [FK_ThamGia_NguoiLaoDong] FOREIGN KEY([maNV])
REFERENCES [dbo].[NguoiLaoDong] ([maNLD])
GO
ALTER TABLE [dbo].[ThamGia] CHECK CONSTRAINT [FK_ThamGia_NguoiLaoDong]
GO
