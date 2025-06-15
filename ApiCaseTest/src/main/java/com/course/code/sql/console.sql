# 查询当前mysql系统中所有的数据库
show databases ;
#使用一个数据库
use guangguangschool;

#显示使用的当前数据库是哪个?
select database();
#显示数据库版本
select version();

#显示时间
select now();

#创建students表 ,字段有id,name,age,height,gender,cls_id,is_delete
# unsigned 为非负数 decimal(5,2) 共5位 2位为小数位
create table liguangStudents (
    id int unsigned primary key  auto_increment not null,
    name varchar(20) default '',
    age tinyint unsigned default 0,
    height decimal(5,2),
    gender enum('男','女','中性','保密') default '保密',
    cls_id int unsigned default 0,
    is_delete bit default 0
);

create table  classes(
    id int unsigned auto_increment primary key  not null ,
    name varchar(30) not null
);

#插入数据 insert into 表名(列1,...) values(值1,...)
insert into liguangStudents values
  (0,'小明',18,180.00,2,1,0),
    (0,'小月月',18,180.00,2,2,1),
    (0,'彭于晏',29,185.00,1,1,0),
    (0,'刘德华',59,175.00,1,2,1),
    (0,'黄蓉',38,160.00,2,1,0),
    (0,'凤姐',28,150.00,4,2,1),
    (0,'王祖贤',18,172.00,2,1,1),
    (0,'周杰伦',36,NULL,1,1,0),
    (0,'程坤',27,181.00,1,2,0),
    (0,'刘亦菲',25,166.00,2,2,0),
    (0,'金星',33,162.00,3,3,1),
    (0,'静香',12,180.00,2,4,0),
    (0,'郭靖',12,170.00,1,4,0),
    (0,'周杰',34,176.00,2,5,0);
# 向classes表中插入数据
insert into classes values (0, 'python_01期'), (0, 'python_02期');

#修改表-添加字段 alter table 表名 add 列名 类型;
alter table liguangStudents add birthday datetime;
desc liguangStudents;
#修改表-修改字段：不重命名版 alter table 表名 modify 列名 类型及约束;
alter table liguangStudents modify  birthday date;
desc liguangStudents;

# 修改表-修改字段：重命名列名称
alter table liguangStudents change birthday birth date default '1990-01-01';
desc liguangStudents;

#修改表-删除字段 alter table 表名 drop 列名;
alter table liguangStudents add can_dele int default 0;
desc liguangStudents;
alter table liguangStudents drop can_dele;
desc liguangStudents;

#更新表数据 update 表名 set 列1=值1,列2=值2... where 条件;
select * from liguangStudents where id = 1;
update liguangStudents set age=17,gender='男' where id=1;

# 逻辑删除 用一个字段来表示 这条信息是否已经不能再使用了
alter table liguangStudents modify is_delete bit default 0;
update liguangStudents set is_delete=0 where id between 1 and 20;

#消除重复行 distinct 字段
select distinct gender from liguangStudents;

# 条件查询 > < >= <= !=

# 逻辑运算符 and or not

#模糊查询
# like 、% 替换0个或1或多个、_ 替换1个
# rlike 正则

# 范围查询
# in (1, 3, 8)表示在一个非连续的范围内
# not in 不非连续的范围之内
# between ... and ...表示在一个连续的范围内
# not between ... and ...表示不在一个连续的范围内

# 空判断 判空is null、判非空is not null

# 查找姓名至少为2字的
select * from liguangStudents where age > 20 and gender in('男','女') and  name like '__%';

#聚合函数 count(),sum(),min(),max(),average(),round()
select count(*) from liguangStudents where gender = '女';
select * from liguangStudents where gender = '女';
select sum(age) from liguangStudents where gender = '男';
select max(age),s.name,s.age from liguangStudents s where gender = '男';
select  max.age,max.name from  liguangStudents max where age =
                                          (select max(age) from liguangStudents where gender = '男');
select  min.age,min.name from  liguangStudents min where age =
                                          (select min(age) from liguangStudents where gender = '男');

select avg(age) from liguangStudents where gender = '女';
select sum(age) / count(*) as '女平均年龄' from liguangStudents where gender = '女';
select round(avg(height),3) as '男平均身高' from liguangStudents as ls where ls.gender = '男';

#分组 年龄大于25岁的分组 group_concat() 将筛选的结果按照字段连接
select gender,count(*) as 人数 from liguangStudents where age > 25 group by gender;
select gender,group_concat(name) as '姓名', count(*) as 人数 from
     liguangStudents where age > 25 group by gender;

# having 的条件必须是from前面的某一个条件
select gender,group_concat(name) as '姓名', count(*) as 人数 from
     liguangStudents where age > 25 group by gender having count(*) > 1;

# 分页
select * from liguangStudents;
select * from liguangStudents limit 0,2;
#   limit (第N页-1)*每页的个数, 每页的个数;
select * from liguangStudents limit 2,2; #每页显示2个 第2页
select * from liguangStudents limit 12,2; # limit (第N页-1)*每页的个数, 每页的个数; 第7页 每页两个

select * from liguangStudents limit 12,4; # 第4页，每页4个

# 查找第三页的数据，每页4条，按照年龄从大到小
select * from liguangStudents order by age desc limit 8,4;

# 连接查询

select ls.id,ls.name,c.name from liguangStudents ls left join classes c on ls.cls_id = c.id;
select ls.id,ls.name,c.name from liguangStudents ls right join classes c on ls.cls_id = c.id;
##137,138相等的查询效果
select ls.id,ls.name,c.name from liguangStudents ls inner join classes c on ls.cls_id = c.id;
select ls.id,ls.name,c.name from liguangStudents ls,  classes c  where ls.cls_id = c.id;


select ls.id,ls.name,c.name from liguangStudents ls left join classes c on ls.cls_id = c.id union all
select ls.id,ls.name,c.name from liguangStudents ls right join classes c on ls.cls_id = c.id;
select ls.id,ls.name,c.name,c.id from liguangStudents ls inner join classes c on ls.cls_id = c.id having c.id is not null;


#子查询
 # 1标量子查询
select * from liguangStudents where height = (select max(height) from liguangStudents where gender ='女');
# 列级子查询 查询学生的班级号能够对应的学生信息
select * from liguangStudents where cls_id in (select id from classes);

#筛选出年龄大于35岁的人
select student.SId as 学生编号,student.Sname  as  学生姓名,TIMESTAMPDIFF(YEAR,student.Sage,CURDATE()) as 学生年龄
from student where TIMESTAMPDIFF(YEAR,student.Sage,CURDATE()) >33;

select  * from student;
insert into student values (14,'吴兰','1992-08-20 13:12:23','男');

#更新数据
update  student  set Ssex = '女'  where SId = 14;

#筛选出名字重复的人
select Sname,count(*) from student group by Sname having count(*) > 1;

#1.查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数
#第一步 查询出每个学生的01课程的成绩
select  sid,score, CId from sc where CId = 01;
#第二步 查询出每个学生的02课程的成绩
select  sid,score, CId from sc where CId = 02;
#第三步 查询出成绩01比02成绩高的学生id和成绩
select score_01.SId,score_01.score from (select  sid,score, CId from sc where CId = 01) as score_01 inner join
    (select  sid,score, CId from sc where CId = 02) as score_02 on score_01.SId = score_02.SId where score_01.score > score_02.score;

#第四步 连接表student和第三步查出的表信息
select  ST.SId,ST.Sname,ST.Ssex,score_Info.sc_1,score_Info.sc_2 from student as ST
    inner join (select score_01.SId,score_01.score as sc_1,score_02.score as sc_2 from (select  sid,score, CId from sc where CId = 01) as score_01 inner join
    (select  sid,score, CId from sc where CId = 02) as score_02 on score_01.SId = score_02.SId where score_01.score > score_02.score) as score_Info on
        ST.SId = score_Info.SId;

#原答案
select *
from (select SId ,score from sc where sc.CId='01')as t1 , (select SId ,score from sc where sc.CId='02') as t2
where t1.SId=t2.SId
and   t1.score>t2.score;

# 1.1查询同时存在" 01 "课程和" 02 "课程的情况
select *
from (select SId ,score from sc where sc.CId='01')as t1 , (select SId ,score from sc where sc.CId='02') as t2
where t1.SId=t2.SId;
#1.2查询存在" 01 "课程但可能不存在" 02 "课程的情况(不存在时显示为 null )
select *
from (select SId ,score from sc where sc.CId='01')as t1 left join (select SId ,score from sc where sc.CId='02') as t2
on t1.SId=t2.SId;
#1.3查询不存在" 01 "课程但存在" 02 "课程的情况
select *
from sc
where sc.SId not in (select SId from sc where sc.CId='01')
and  sc.CId='02';

#2.查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

#第一步 先通过成绩表查询出平均成绩和sid
select   sc.SId,avg(sc.score) as ave_score from sc group by sc.SId having avg(sc.score) > 60;
#第二步 进行学生表和成绩表的连接
select S.SId,s.Sname,av_t.ave_score from student as S inner join (select sc.SId,avg(sc.score) as ave_score from sc group by sc.SId having avg(sc.score) > 60) as av_t
   on S.SId = av_t.SId;
#这个方法也可以
select a.SId,a.Sname, avg(s.score) from student a left join sc s on a.SId = s.SId group by a.Sname having avg(s.score) > 60;

# 3.查询在 SC 表存在成绩的学生信息

select  distinct s.Sname,s.Ssex,s.SId from sc left join student s on sc.SId = s.SId;

select DISTINCT student.*
from student ,sc
where student.SId=sc.SId;

# 4.查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为null)
#第一步 查询学生的总成绩和选课总数
select s.SId, sum(s.score) as s_score_sum,count(s.CId) as s_score_count from sc as s group by s.SId;
#第二步 和学生表连接 ，查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为null)
select sts.SId,sts.Sname,sts.Ssex,sco.s_score_sum,sco.s_score_count from student sts left join (select s.SId, sum(s.score) as s_score_sum,count(s.CId) as s_score_count from sc as s group by s.SId) as sco
    on sts.SId = sco.SId;

#答案
select student.SId,student.Sname,t1.sumscore,t1.coursecount
from student ,(
select SC.SId,sum(sc.score)as sumscore ,count(sc.CId) as coursecount
from sc
GROUP BY sc.SId) as t1
where student.SId =t1.SId;
# 4.1 查有成绩的学生信息
# EXISTS 一种通俗的可以理解为：将外查询表的每一行，代入内查询作为检验，如果内查询返回的结果取非空值，则EXISTS子句返回TRUE，这一行行可作为外查询的结果行，否则不能作为结果。
select *
from student
where EXISTS(select * from sc where student.SId=sc.SId);

#5.查询「李」姓老师的数量
select Tname as 姓名, count(*) as 数量 from teacher where Tname like "李%";

# 6.查询学过「张三」老师授课的同学的信息
#第一步 查询张三老师的授课
select te.Tname,co.CId,co.Cname from teacher te inner join course co on te.TId = co.TId where te.Tname = '张三';

#第二步 查询学数学的学生的SID
select s.SId,s_math.c_math_name from sc s inner join (select te.Tname,co.CId as c_math,co.Cname as c_math_name from teacher te inner join course co on te.TId = co.TId where te.Tname = '张三') as s_math
    on s.CId = s_math.c_math;

# 第三 步查询学生信息
select st.*,ss.c_math_name,ss.t_name from student st
    inner join (select s.SId,s_math.c_math_name,t_name from sc s
    inner join (select te.Tname as t_name,co.CId as c_math,co.Cname as c_math_name from teacher te
    inner join course co on te.TId = co.TId where te.Tname = '张三') as s_math
    on s.CId = s_math.c_math) as ss on st.SId = ss.SId;



# 7. 查询没有学全所有课程的同学的信息
#查询没有学

select st.*,s.CId from student st left join sc  as s on st.SId = s.SId;

#查询出学生和课程信息
select student.SId,course.CId from student,course;
#关联学生课程表信息
select  distinct  student.* from (select student.SId,course.CId from student,course) as t1
    left join (select sc.SId,sc.CId from sc) as t2 on t1.SId=t2.SId and t1.CId = t2.CId,student
where t2.SId is null
and t1.SId = student.SId;

#查询出学生信息

# 答案 ---这个题有难度
select DISTINCT student.*
from
(select student.SId,course.CId
from student,course ) as t1 LEFT JOIN (SELECT sc.SId,sc.CId from sc)as t2 on t1.SId=t2.SId and t1.CId=t2.CId,student
where t2.SId is null
and   t1.SId=student.SId;

# 8.查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息
# 第一步查询学号为01的同学的课程
select sc.CId from sc where sc.SId = '01';
# 第二 查询CId为1，2，3的学生信息
select * from sc where CId in (select sc.CId from sc where sc.SId = '01');

#第三关联学生表 查询学生信息
select distinct s1.* from student s1 inner join (select SId as id,CId as cid from sc where CId in (select sc.CId from sc where sc.SId = '01')) as t1
    on s1.SId = t1.id;
# 答案
select DISTINCT student.*
from  sc ,student
where sc.CId in (select CId from sc where sc.SId='01')
and   sc.SId=student.SId;

# 9.查询和" 01 "号的同学学习的课程完全相同的其他同学的信息
# 第一步查询学号为01的同学的课程
select sc.CId from sc where sc.SId = '01';
#查询课程为01，02 03的学生信息
select * from sc where sc.CId in (select sc.CId from sc where sc.SId = '01');
#查询和SId=01用户学一样多课程的学生
select SId,count(sc.CId) as 课程数 from sc group by SId having count(sc.CId) = (select count(sc.CId) from sc where sc.SId = '01');
select s.* from student s inner join
(select SId,count(sc.CId) as 课程数 from sc group by SId having count(sc.CId) = (select count(sc.CId) from sc where sc.SId = '01')) as t
on s.SId = t.SId;

#答案
select DISTINCT student.*
from (
select student.SId,t.CId
from student ,(select sc.CId from sc where sc.SId='01') as t) as t1 LEFT JOIN sc on t1.SId=sc.SId and t1.CId=sc.CId,student
where sc.SId is null
and   t1.SId=student.SId;

# 10.查询没学过"张三"老师讲授的任一门课程的学生姓名

#查询出学了张三老师课程的学生
select s.SId from teacher te,course co, sc s where te.Tname = '张三' and te.TId = co.TId and s.CId = co.CId;

#查询出没学习张三课程的学生
select * from student where SId not in (select s.SId from teacher te,course co, sc s where te.Tname = '张三' and te.TId = co.TId and s.CId = co.CId);
#答案
select *
from student
where student.SId not in
(
select student.SId
from student left join sc on student.SId=sc.SId
where EXISTS
(select *
from teacher ,course
where teacher.Tname='张三'
and   teacher.TId=course.TId
and 	course.CId=sc.CId));

#11.查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
/*
 有两个表以上的内容需要查询出来的话 就不能使用子查询去查，因为子查询的条件只能是一个条件
 */
# 第一步 查询两门成绩以上不合格的学生
select SId from sc where score < 60 group by SId having count(score) > 2;

select s.* from student s where SId in (select SId from sc where score < 60 group by SId having count(*) >= 2);

# 答案
select s.*,avg(sco.score) as 平均成绩 from student s,sc sco
where sco.score < 60
and s.SId = sco.SId
group by sco.SId
having count(sco.score) >= 2;

#12 检索" 01 "课程分数小于 60，按分数降序排列的学生信息
select  st.*,c.score from student st, sc  c where st.SId = c.SId and c.CId = '01' and c.score < 60 order by c.score desc;

# 13 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

select  t.SId,s.score, t.avg_s from sc s,(select SId, avg(score) as avg_s from sc group by SId ) as t where s.SId = t.SId
order by t.avg_s desc;
#标准答案
select
sc.SId,sc.CId,sc.score,t1.avgscore
from  sc left join (select sc.SId,avg(sc.score) as avgscore
from sc
GROUP BY sc.SId) as t1 on sc.SId =t1.SId
ORDER BY t1.avgscore DESC;

# 14.查询各科成绩最高分、最低分和平均分： 以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，
#优秀率 及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90 要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
select sc.CId,max(sc.score) as 最高分,min(sc.score) as 最低分,avg(score) as 平均分,count(*) as 选修人数
,sum(case when sc.score >= 60 then 1 else 0 end) / count(*) as 及格率
,sum(case when sc.score >= 70 and sc.score < 80 then 1 else 0 end) / count(*) as 及格率
,sum(case when sc.score >= 80 and sc.score < 90 then 1 else 0 end) / count(*) as 优良率
,sum(case when sc.score >= 90 then 1 else 0 end) / count(*) as 优秀率
,course.Cname as 课程名
from sc,course where sc.CId = course.CId group by sc.CId order by count(*) desc,sc.CId asc;

# 15 按各科成绩进行排序，并显示排名，Score重复时保留名次空缺
/*
select @curRank := 0 相当于赋值，只不过在这里作为一个表被select出来。
类似于select * from a,b中的表b
 */


SELECT a.`CId`,IFNULL((
	SELECT COUNT(score)+1
	FROM sc b
	WHERE a.`CId`=b.CId AND b.score>a.`score`
	GROUP BY b.CId
),1) number,a.`SId`,a.`score`
FROM sc a
ORDER BY CId,number;

SELECT a.`CId`,IFNULL((
	SELECT COUNT(DISTINCT score)+1
	FROM sc b
	WHERE a.`CId`=b.CId AND b.score>a.`score`
	GROUP BY b.CId
),1) number,a.`SId`,a.`score`
FROM sc a
ORDER BY CId,number;

# 17 统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比
select sc.CId,course.Cname
,concat(sum(case when sc.score >= 85 and sc.score <= 100 then 1 else 0 end) / count(*)*100,'%') as '[85-100]',sum(case when sc.score >= 85 and sc.score <= 100 then 1 else 0 end) as '[85-100]人数'
,concat(sum(case when sc.score >= 70 and sc.score < 85 then 1 else 0 end) / count(*)*100,'%') as '[70-85]'
,concat(sum(case when sc.score >= 60 and sc.score < 70 then 1 else 0 end) / count(*)*100,'%') as '[60-70]'
,concat(sum(case when sc.score >= 0 and sc.score < 60 then 1 else 0 end) / count(*)*100,'%') as '[0-60]'
from sc,course where sc.CId = course.CId group by sc.CId;

select course.CId,course.Cname,t1.*
from course LEFT JOIN (
select sc.CId,CONCAT(sum(case when sc.score>=85 and sc.score<=100 then 1 else 0 end )/count(*)*100,'%') as '[85-100]',
CONCAT(sum(case when sc.score>=70 and sc.score<85 then 1 else 0 end )/count(*)*100,'%') as '[70-85)',
CONCAT(sum(case when sc.score>=60 and sc.score<70 then 1 else 0 end )/count(*)*100,'%') as '[60-70)',
CONCAT(sum(case when sc.score>=0 and sc.score<60 then 1 else 0 end )/count(*)*100,'%') as '[0-60)'
from sc
GROUP BY sc.CId) as t1 on course.CId=t1.CId;

select sum(case when sc.score >= 85 and sc.score <= 100 then 1 else 0 end) as ren from sc;

#18 查询各科成绩前三名的记录 思路：前三名转化为若大于此成绩的数量少于3即为前三名。
select * from sc where
    (select count(*) from sc as a where sc.CId = a.CId and sc.score < a.score) < 3 order by CId asc,score desc;

# 	19. 查询每门课程被选修的学生数
select sc.CId,count(*) as 学生数 from  sc  group by sc.CId;

# 20 查询出只选修两门课程的学生学号和姓名
#查询按照学生分组 各自选修的课程数
select sc.SId,count(*) from sc group by sc.SId;
select s.SId,s.Sname from student s,(select sc.SId,count(*) from sc group by sc.SId having count(*) = 2) t where
 s.SId = t.SId;

select student.SId,student.Sname from student,sc where student.SId= sc.SId group by sc.SId having count(*) = 2;

#21.查询男生、女生人数
select student.Ssex, count(*) from student group by (Ssex);

# 22. 查询名字中含有「风」字的学生信息
select * from student where Sname  like "%风%";

# 23. 查询同名同性学生名单，并统计同名人数
select  distinct  student.Sname,t1.同名人数 from student,(select Ssex,Sname, count(*) 同名人数 from student group by Sname,Ssex) as t1 where
t1.Sname = student.Sname and t1.Ssex = student.Ssex  and t1.同名人数> 1;

# 24.查询 1990 年出生的学生名单

select * from student where year(Sage) = 1990;
select * from student where extract(year from student.Sage) = 1990;
select * from student where extract(month from student.Sage) = 01;

#日期函数
# 获取当前日期和时间:
select now(); # 2025-06-15 19:06:09
select current_timestamp();
select curdate();#2025-06-15
select curtime();#19:06:09

#提取日期部分的函数
select year(now());
select dayofweek('2025-06-15'); # 1表示星期天
select extract(year from now()); # 等价于 select year(now())
#日期计算函数
select date_add(now(),interval 1 MONTH ); # 向日期添加一个时间间隔。  1 是预期加的，MONTH是单位，INTERVAL 是固定语法，now()是日期
select date_sub(now(),interval 1 MONTH ); # 从日期中减去一个时间间隔。。  1 是预期加的，MONTH是单位，INTERVAL 是固定语法，now()是日期
select datediff('2025-06-15','1992-08-19');#DATEDIFF(date1, date2): 返回两个日期之间相差的天数。
select timediff('12-18-15','00-08-19');#返回两个时间之间相差的时间，结果为 HH:MM:SS 格式。

select timestampdiff(year ,'1992-08-19',now()) as 年龄; #计算两个时间的差值  year单位
#日期和时间格式化函数:
select date_format(now(),'%Y-%m-%d %H:%i:%s');

# 25 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
select sc.CId,avg(score) from sc group by sc.CId order by avg(score) desc ,sc.CId asc;

# 26 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
select s.*,t.av_s from student s, (select sc.SId,avg(score) as av_s from sc group by sc.SId) t where s.SId = t.SId and t.av_s >=85;

# 40.查询各学生的年龄，只按年份来算
select Sname, timestampdiff(year,Sage,curdate()) as 年龄 from student;

# 41按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一
select SId,Sname, timestampdiff(year ,Sage,curdate()) from student;

# 42查询本周过生日的学生
select * from student where yearweek(Sage)=yearweek(curdate());

# 43查询下周过生日的学生
select * from student where yearweek(Sage) = concat(year(curdate()),week(curdate())+1);
select *
from student
where YEARWEEK(student.Sage)=CONCAT(YEAR(CURDATE()),week(CURDATE())+1);

































