drop database if exists Session_3_bai_tap_lam_them;
create database Session_3_bai_tap_lam_them;
use Session_3_bai_tap_lam_them;

CREATE TABLE Phong_ban (
    MAPB INT PRIMARY KEY,
    TENPB VARCHAR(255)
);
CREATE TABLE Nhan_vien (
    MANV INT PRIMARY KEY,
    HO VARCHAR(255),
    TEN VARCHAR(255),    
    NGAYSINH DATE,
    PHAI VARCHAR(255),
    DIACHI VARCHAR(255),
    MAPB INT,
    FOREIGN KEY (MAPB)
        REFERENCES Phong_ban (MAPB)
);
create table Cong_trinh(
MACT INT primary KEY,
TENCT varchar(255),
DIADIEM varchar(255),
NGAYCAPGP date,
NGAYKC date,
NGAYHT date
);
CREATE TABLE Nhan_vien_Cong_trinh (
    MANV INT,
    MACT INT,
    SONGAYCONG INT,
    constraint PK_Nhan_vien_Cong_trinh primary key(MANV,MACT)
);

CREATE TABLE So_bao_hiem (
    MASOBH INT PRIMARY KEY,
    NGAYCAP DATE,
    THOIHAN DATE,
    MANV INT,
    FOREIGN KEY (MANV)
        REFERENCES Nhan_vien (MANV)
);

