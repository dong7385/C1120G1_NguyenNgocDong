select ten
from hoc_vien
union
select ten_gv
from giang_vien;

select * from hoc_vien
where ten = "Ngoc" or ten = "Thuan" or ten = "Son";

select * from hoc_vien
limit 1, 3;

select * from hoc_vien
order by ngay_sinh
limit 1;


select min(ngay_sinh) as a
from hoc_vien;

select * from hoc_vien
where ngay_sinh =  (select max(ngay_sinh) from hoc_vien);

select ma_hv, ten, ngay_sinh, concat("CGDN-",ma_lop) as ma_lop from hoc_vien;

select ma_hv, ten, year(ngay_sinh) as nam, concat("CGDN-",ma_lop) as ma_lop from hoc_vien;

select ma_hv, ucase(ten) as ten, year(ngay_sinh) as nam, concat("CGDN-",ma_lop) as ma_lop from hoc_vien;

select ma_hv, ucase(ten) as ten, year(ngay_sinh) as nam, timestampdiff(YEAR, ngay_sinh, curdate()) as tuoi, concat("CGDN-",ma_lop) as ma_lop from hoc_vien;