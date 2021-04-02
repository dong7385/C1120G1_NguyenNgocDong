use case_study;
/*task 2.	Hiển thị thông tin của tất cả nhân viên có
 trong hệ thống có tên bắt đầu là một trong các ký tự 
“H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

-- Cach_1:
select *
from NhanVien
where hoTen regexp '[:space:][T|H|G][a-z]*$' AND CHAR_LENGTH(hoTen) < 15;

-- Cach_2:
-- SELECT 
--     *
-- FROM
--     NhanVien
-- WHERE
--     hoTen LIKE '%H%' OR hoTen LIKE '%T%'
--         OR hoTen LIKE '%K%'
--         AND CHAR_LENGTH(hoTen) < 15
-- ;
/*task 3.Hiển thị thông tin của tất cả khách hàng có 
độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select * 
from KhachHang
where (timestampdiff(YEAR, ngaySinh, curdate())>18 or timestampdiff(YEAR, ngaySinh, curdate())<50)
and diaChi in ('Huế','Quảng Trị')
;
/*task 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/

SELECT 
    KhachHang.hoTen,
    COUNT(HopDong.idHopDong) AS so_lan_dat_phong
FROM
    KhachHang
        INNER JOIN
    HopDong ON KhachHang.idKhachHang = HopDong.idKhachHang
WHERE
    KhachHang.idLoaiKhach = 1
GROUP BY KhachHang.idKhachHang
ORDER BY so_lan_dat_phong asc;

/*task 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từ ng đặt phòng cũng phải hiển thị ra).*/

SELECT 
    KhachHang.idLoaiKhach,
    KhachHang.hoTen,
    LoaiKhach.tenLoaiKhach,
    HopDong.idHopDong,
    DichVu.idDichVu,
    HopDong.ngayLamHopDong,
    HopDong.ngayKetThuc,
    SUM(DichVu.chiPhiThue + HopDongChiTiet.soLuong * DichVuDiKem.gia) AS Tong_tien
FROM
    KhachHang
        LEFT JOIN
    LoaiKhach ON KhachHang.idLoaiKhach = LoaiKhach.idLoaiKhach
        LEFT JOIN
    HopDong ON KhachHang.idKhachHang = HopDong.idKhachHang
        LEFT JOIN
    DichVu ON HopDong.idDichVu = DichVu.idDichVu
        LEFT JOIN
    HopDongChiTiet ON HopDong.idHopDong = HopDongChiTiet.idHopDong
        LEFT JOIN
    DichVuDiKem ON HopDongChiTiet.idDichVuDiKem = DichVuDiKem.idDichVuDiKem
GROUP BY HopDong.idHopDong
ORDER BY KhachHang.idKhachHang asc;

/* task 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 
của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select DichVu.IdDichVu, tenDichVu, dienTich, chiPhiThue, LoaiDichVu.tenLoaiDichVu,HopDong.ngayLamHopDong
from DichVu
left join LoaiDichVu on DichVu.idLoaiDichVu=LoaiDichVu.idLoaiDichVu
left join HopDong on DichVu.idDichVu=HopDong.idDichVu
where (year(HopDong.ngayLamHopDong)>=2019) and month(HopDong.ngayLamHopDong) in (1,2,3) ;

/*task 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.*/

SELECT 
    DichVu.idDichVu,
    tenDichVu,
    dienTich,
    soNguoiToiDa,
    chiPhiThue,
    LoaiDichVu.tenLoaiDichVu,
    HopDong.ngayLamHopDong
FROM
    DichVu
        LEFT JOIN
    LoaiDichVu ON DichVu.idLoaiDichVu = LoaiDichVu.idLoaiDichVu
        LEFT JOIN
    HopDong ON DichVu.idDichVu = HopDong.idDichVu
WHERE
    (YEAR(HopDong.ngayLamHopDong) = 2018)
        AND NOT YEAR(HopDong.ngayLamHopDong) = 2019;

/*task8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, 
với yêu cầu HoTenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/

select distinct KhachHang.hoTen
from KhachHang;

select  KhachHang.hoTen
from KhachHang
group by KhachHang.hoTen;

/*task 9.	Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2019 
thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select month(HopDong.ngayLamHopDong) as soThang, count(month(HopDong.ngayLamHopDong)) as SoKhachHangDatPhong
from HopDong
where year(HopDong.ngayLamHopDong)=2019
group by month(HopDong.ngayLamHopDong);

/*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).
*/

SELECT 
    HopDong.idHopDong,
    HopDong.ngayLamHopDong,
    HopDong.ngayKetthuc,
    HopDong.tienDatCoc,
    COUNT(HopDongChiTiet.idDichVuDiKem) AS so_luong_dung_dich_vu_di_kem
FROM
    HopDong
        LEFT JOIN
    HopDongChiTiet ON HopDong.idHopDong = HopDongChiTiet.idHopDong
        LEFT JOIN
    DichVuDiKem ON HopDongChiTiet.idDichVuDiKem = DichVuDiKem.idDichVuDiKem
GROUP BY HopDong.idHopDong;

/*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng
 có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
 
select DichVuDiKem.tenDichVuDiKem,KhachHang.hoTen,LoaiKhach.tenLoaiKhach
from DichVuDiKem
left join HopDongChiTiet on DichVuDiKem.idDichVuDiKem=HopDongChiTiet.idDichVuDiKem
left join HopDong on HopDongChiTiet.idHopDong=HopDong.idHopDong
left join KhachHang on HopDong.idKhachHang=KhachHang.idKhachHang
left join LoaiKhach on KhachHang.idLoaiKhach=LoaiKhach.idLoaiKhach
 where (LoaiKhach.tenLoaiKhach='Diamond')and khachHang.diaChi in('Đà Nẵng','Sài Gòn');
 
 /*task 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
 (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019*/
 
select HopDong.idHopDong, NhanVien.hoTen, KhachHang.hoTen, KhachHang.sdtKhachHang, DichVu.tenDichVu, 
 count(HopDongChiTiet.idHopDongChiTiet)as So_luong_dich_vu_di_kem,count(DichVu.idDichVu)as tien_Dat_Coc,HopDong.ngayLamHopDong
from HopDong
inner join khachHang on HopDong.idKhachHang=khachHang.idKhachHang
inner join NhanVien on HopDong.idNhanVien=NhanVien.idNhanVien
inner join DichVu on HopDong.idDichVu=DichVu.idDichVu
inner join HopDongChiTiet on HopDong.idHopDong=HopDongChiTiet.idHopDong
inner join DichVuDiKem on HopDongChiTiet.idDichVuDiKem=DichVuDiKem.idDichVuDiKem
 where (year(HopDong.ngayLamHopDong)=2019) and (month(HopDong.ngayLamHopDong)in (10,11,12)) and (not month(HopDong.ngayLamHopDong)in (1,2,3,4,5,6))

group by HopDongChiTiet.idHopDongChiTiet;

    /*13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
 
select DichVuDiKem.tenDichVuDiKem,count(HopDongChiTiet.idDichVuDiKem)As so_lan_su_dung
from HopDongChiTiet
join DicHVuDiKem on HopDongChiTiet.idDichVuDiKem=DicHVuDiKem.idDichVuDiKem
group by DichVuDiKem.idDichVuDiKem
having count(HopDongChiTiet.idDichVuDiKem)=(select max(so_lan_su_dung) 
from (select tenDichVuDiKem,count(HopDongChiTiet.idDichVuDiKem) AS so_lan_su_dung 
from HopDongChiTiet
join DichVuDiKem on HopDongChiTiet.idDichVuDiKem=DichVuDiKem.idDichVuDiKem
group by DichVuDiKem.idDichVuDiKem) as temp
);


/*task 14.	Hiển thị thông tin 
tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
*/
 
 select HopDong.idHopDong, LoaiDichVu.tenLoaiDichVu, DichVuDiKem.tenDichVuDiKem, count(HopDongChiTiet.idDichVuDiKem)as so_lan_su_dung
 from HopDong
 inner join  HopDongChiTiet on HopDong.idHopDong=HopDongChiTiet.idHopDong
 inner join DichVuDiKem on HopDongChiTiet.idDichVuDiKem=DichVuDiKem.idDichVuDiKem
 inner join DichVu on HopDong.idDichVu=DichVu.idDichVu
 inner join LoaiDichVu on DichVu.idLoaiDichVu=LoaiDichVu.idLoaiDichVu
 
 group by HopDong.idHopDong
having count(HopDongChiTiet.idDichVuDiKem)=1;
 
 
 /*task 15.	Hiển thi thông tin của tất cả nhân viên bao gồm 
 IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
 mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
 
 SELECT 
    NhanVien.hoTen,
    TrinhDo.trinhDo,
    BoPhan.tenBoPhan,
    NhanVien.sdtNhanVien,
    NhanVien.diaChi,
    COUNT(HopDong.idNhanVien),
    HopDong.ngayLamHopDong
FROM
    NhanVien
        LEFT JOIN
    TrinhDo ON NhanVien.idTrinhDo = TrinhDo.idTrinhDo
        LEFT JOIN
    BoPhan ON NhanVien.idBoPhan = BoPhan.idBoPhan
        LEFT JOIN
    HopDong ON NhanVien.idNhanVien = HopDong.idNhanVien
WHERE
    YEAR(HopDong.ngayLamHopDong) in(2018,2019)
       
GROUP BY HopDong.idNhanVien
HAVING COUNT(HopDong.idNhanVien) <= 3;
 
 /*task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào
 từ năm 2017 đến năm 2019.*/
 
-- delete from NhanVien
-- where idNhanVien;

 /*task 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
 chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán 
 trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/
 
 SET SQL_SAFE_UPDATES = 0;
 
 UPDATE khachhang,
    (SELECT 
        KhachHang.idKhachHang
    FROM
        KhachHang
    LEFT JOIN HopDong ON KhachHang.idKhachHang = HopDong.idKhachHang
    GROUP BY KhachHang.idKhachHang
    HAVING SUM(HopDong.tongTien) > 1000000) AS Platinium_len_Diamond 
SET 
    KhachHang.idLoaiKhach = 1
WHERE
    KhachHang.idKhachHang = Platinium_len_Diamond.idKhachHang;
 
 /*task 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/
 create temporary table temp select KhachHang.idKhachHang as id
								from KhachHang
								left join HopDong on KhachHang.idKhachHang=HopDong.idKhachHang
								where year(HopDong.ngayLamHopdong)<2016
								group by KhachHang.idKhachHang;
drop temporary table temp;
 delete from KhachHang
 where KhachHang.idKhachHang in (select temp.id from temp);
    
/*task 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/
  
 
 select NhanVien.idNhanVien, KhachHang.idKhachHang, HoTen, Email, SoDienThoai, NgaySinh, DiaChi
 
