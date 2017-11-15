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


insert into guard_info (Fname, Lname, Age)
values
('Brad', 'Hennes', 16), ('Quinn', 'OConnor', 17), ('Jean', 'Leow', 18), ('Kevin', 'Eanes', 19), 
('Hannah', 'Lebakken', 20), ('Jane', 'Doe', 21), ('Jon', 'Doe', 22), ('Steve', 'Stevenson', 23), 
('Nick', 'Nickerson', 24), ('Bob', 'Builder', 25), ('Brad2', 'Hennes2', 16), ('Quinn2', 'OConnor2', 17), 
('Jean2', 'Leow2', 18), ('Kevin2', 'Eanes2', 19), ('Hannah2', 'Lebakken2', 20), ('Jane2', 'Doe2', 21), 
('Jon', 'Doe2', 22), ('Steve2', 'Stevenson2', 23), ('Nick2', 'Nickerson2', 24), ('Bob2', 'Builder2', 25),
('Brad3', 'Hennes3', 16), ('Quinn3', 'OConnor3', 17), ('Jean3', 'Leow3', 18), ('Kevin3', 'Eanes3', 19), 
('Hannah3', 'Lebakken3', 20), ('Jane3', 'Doe3', 21), ('Jon3', 'Doe3', 22), ('Steve3', 'Stevenson3', 23);

insert into rotation (Position1, Position2, Position3, Position4, Position5, AgeReq) 
values
('Wavepool 1', 'Lazy River 3', 'Waterslide 3', 'Wavepool 3', 'Hurricane 1', 18), 
('Hurricane Entrance', 'Wavepool 2', 'Waterslide 1', 'Wavepool 4', ' Hurricane 2', 18), 
('Lazy River 5', 'Lazy River 4', 'Waterslide 2', 'Waterslide Entrance', 'Cleaning Duty', 16), 
('Lazy River 2', 'Lazy River 6', 'Waterslide Exit Pool', 'Cleaning Duty', 'Lazy River 1', 16);