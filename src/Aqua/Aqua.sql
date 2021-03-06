create database if not exists `Algae`;
use `Algae`; 

create table `Guard_Info` (
	`Guard_ID` int auto_increment,
	`Fname` varchar(255),
    	`Lname` varchar(255),
    	`Age` int,
    	primary key (`Guard_ID`)
);

create table `Rotation` (
	`Ro_ID` int auto_increment,
    	`Position1` varchar (255),
    	`Position2` varchar (255),
    	`Position3` varchar (255),
    	`Position4` varchar (255),
    	`Position5` varchar (255),
    	`AgeReq` int,
    	primary key (`Ro_ID`)
);

create table `Rotation_His` (
	`Ro_ID` int auto_increment,
	`Team_Lead` varchar (40),
    	`Ro_Time` time,
    	`Position1` varchar (255),
    	`Position2` varchar (255),
    	`Position3` varchar (255),
    	`Position4` varchar (255),
    	`Position5` varchar (255),
        `AgeReq` int,
    	primary key (`Ro_ID`)
);

create table `ScheduleWork` (
	`G_name` varchar(255),
	`Sch_day` varchar(10),
    	`Sch_in_time` time,
    	`Sch_out_time` time
);

create table `ActualWork` (
    	`G_name` varchar(255),
	`Act_day` varchar(10),
    	`Act_in_time` time,
    	`Act_out_time` time,
    	`Act_date` date,
    	`Break_in1` time,
	`Break_out1` time,
    	`Break_in2` time,
    	`Break_out2` time   
);

insert into `ScheduleWork` values 
	('Jane', 'Monday', '8:0:0', '16:0:0'),
    	('Hannah', 'Monday', '9:0:0', '17:0:0'),
	('Kevin', 'Monday', '10:0:0', '18:0:0'),
	('Jean', 'Monday', '8:0:0', '16:0:0'),
	('John', 'Monday', '10:0:0', '18:0:0')
;

select * from `ScheduleWork`;
