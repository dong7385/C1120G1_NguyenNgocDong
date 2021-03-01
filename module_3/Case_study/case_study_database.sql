drop database if exists case_study;
create database case_study;
use case_study;

create table ViTri(
idViTri int auto_increment primary key,
tenViTri varchar(45)
);

insert into ViTri(tenViTri)
values 
('Lễ Tân '),
('Phục Vụ '),
('Chuyên Viên '),
('Giám Sát'),
('Quản Lý '),
('Giám Đốc')
;

create table TrinhDo(
idTrinhDo  int auto_increment primary key,
trinhDo varchar(45)
);

insert into TrinhDo(trinhDo)
values
('Trung Cấp'),
('Cao Đẳng'),
('Đại Học'),
('Sau Đại Học')
;

create table BoPhan(
idBoPhan  int auto_increment primary key,
tenBoPhan varchar(45)
);

insert into BoPhan(tenBoPhan)
values
('Sale – Marketing'),
('Hành Chính'),
('Phục vụ'),
('Quản Lý')
;

create table NhanVien(
idNhanVien int auto_increment primary key,
hoTen varchar(45),
idViTri int,
idTrinhDo  int,
idBoPhan  int,
ngaySinh date,
soCmnd int,
luong double,
sdt int,
email varchar(45),
diaChi varchar(45),
foreign key(idViTri)references ViTri(idViTri),
foreign key(idTrinhDo)references TrinhDo(idTrinhDo),
foreign key(idBoPhan)references BoPhan(idBoPhan)
);

insert into NhanVien(hoTen,idViTri,idTrinhDo,idBoPhan,ngaySinh,soCmnd,luong,sdt,email,diaChi)
value
('Nguyễn Văn A',1,1,3,'1990-12-12',201535456,300,0905222321,'A@gmail.com','Đà Nẵng'),
('Nguyễn Văn B',5,3,4,'1987-12-12',201534444,10000,0905123456,'B@gmail.com','Hà Tĩnh'),
('Nguyễn Văn C',5,3,4,'1987-12-12',201534449,10000,0905123956,'C@gmail.com','Quảng Bình');

create table LoaiKhach(
idLoaiKhach int auto_increment primary key,
tenLoaiKhach varchar(45)
);

insert into LoaiKhach(tenLoaiKhach)
values
('Diamond'), 
('Platinium'), 
('Gold'), 
('Silver'), 
('Member');

create table KhachHang(
idKhachHang int auto_increment primary key,
idLoaiKhach int,
hoTen varchar(45),
ngaySinh date,
soCmnd int,
email varchar(45),
diaChi varchar(45),
foreign key (idLoaiKhach) references LoaiKhach(idLoaiKhach)
);

insert into KhachHang(idLoaiKhach,hoTen,ngaySinh,soCmnd,email,diaChi)
values
(1,'Nguyễn Văn Tèo','1993-1-1',2015282890,'teo@gmail.com','Sài Gòn '),

(2,'Nguyễn VĂn Tí','1987-2-2',201922222,'ti@gmail.com','Huế')
;

create table KieuThue(
idKieuThue int auto_increment primary key,
tenKieuThue varchar(45),
gia double
);

insert into KieuThue(tenKieuThue,gia)
values 
('Năm','10000'),
('Tháng','1200'),
('Ngày','200'),
('Giờ','50');

create table LoaiDichVu(
idLoaiDichVu int auto_increment primary key,
tenLoaiDichVu varchar(45)
);

insert into LoaiDichVu(tenLoaiDichVu)
values 
('Villa'),
('House'),
('Room');

create table DichVu(
idDichVu int auto_increment primary key,
tenDichVu varchar(45),
dienTich int,
soTang int,
soNguoiToiDa int,
chiPhiThue double,
idKieuThue int,
idLoaiDichVu int,
trangThai varchar(45),
foreign key (idKieuThue) references KieuThue(idKieuThue),
foreign key (idLoaiDichVu) references LoaiDichVu(idLoaiDichVu)
);

insert into DichVu(tenDichVu,dienTich,soTang,soNguoiToiDa,chiPhiThue,idKieuThue,idLoaiDichVu,trangThai)
values 
('Tuyệt Vời ',100,2,20,1000,2,1,'Còn Phòng'),
('Thoải Mái ',50,6,15,600,1,2,'Còn Phòng')
;


create table HopDong(
idHopDong int auto_increment primary key,
idNhanVien int,
idKhachHang int,
idDichVu int,
ngayLamHopDong date,
ngayKetThuc date,
tienDatCoc double,
tongTien double,
foreign key (idNhanVien) references NhanVien(idNhanVien),
foreign key (idKhachHang) references KhachHang(idKhachHang),
foreign key (idDichVu) references DichVu(idDichVu)
);

insert into HopDong(idNhanVien,idKhachHang,idDichVu,ngayLamHopDong,ngayKetThuc,tienDatCoc,tongTien)
values
(1,1,1,'2021-2-2','2021-2-21',200,2000),

(1,1,1,'2021-1-11','2021-1-21',100,1500)
;

create table DichVuDiKem(
idDichVuDiKem int auto_increment primary key,
tenDichVuDiKem varchar(45),
gia double,
donVi varchar(45),
trangThaiKhaDung varchar(45)
);

insert into DichVuDiKem(tenDichVuDiKem,gia,donVi,trangThaiKhaDung)
values 
('Massage',15,'USD','Đang khả dụng'),

('karaoke',20,'USD','Đang khả dụng'),

('Thức ăn',30,'USD','Đang khả dụng'),

('Nước uống',1,'USD','Đang khả dụng'),

('xe',100,'USD','Đang khả dụng');

create table HopDongChiTiet(
idHopDongChiTiet int auto_increment primary key,
idHopDong int,
idDichVuDiKem int,
soLuong int,
foreign key (idHopDong)references HopDong (idHopDong),
foreign key (idDichVuDiKem)references DichVuDiKem (idDichVuDiKem)
);

insert into HopDongChiTiet(idHopDong,idDichVuDiKem,soLuong)
values
(1,2,2),
(1,1,1)
;