/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019-07-29 00:03:05                          */
/*==============================================================*/
--删除数据库
DROP DATABASE cmdb;
--创建数据库
CREATE DATABASE cmdb;
--使用数据库
USE cmdb;
--删除数据表
drop table if exists customer;

drop table if exists dept;

drop table if exists logs;

drop table if exists member;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   cmid                 INT not null auto_increment,
   mid                  VARCHAR(50),
   name                 VARCHAR(50),
   phone                VARCHAR(50),
   address              VARCHAR(150),
   intention            VARCHAR(50),
   note                 VARCHAR(250),
   type                 VARCHAR(50),
   primary key (cmid)
);

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   did                  INT not null auto_increment,
   title                VARCHAR(50),
   note                 VARCHAR(150),
   primary key (did)
);

/*==============================================================*/
/* Table: logs                                                  */
/*==============================================================*/
create table logs
(
   logid                INT not null auto_increment,
   mid                  VARCHAR(50),
   logdate              DATETIME,
   ip                   VARCHAR(30),
   primary key (logid)
);

/*==============================================================*/
/* Table: member                                                */
/*==============================================================*/
create table member
(
   mid                  VARCHAR(50) not null,
   name                 VARCHAR(50),
   password             VARCHAR(32),
   phone                VARCHAR(50),
   flag                 INT,
   status               INT,
   lastdate             DATETIME,
   title                VARCHAR(50),
   primary key (mid)
);

alter table customer add constraint FK_Reference_2 foreign key (mid)
      references member (mid) on delete restrict on update restrict;

alter table logs add constraint FK_Reference_1 foreign key (mid)
      references member (mid) on delete restrict on update restrict;

--测试数据
INSERT INTO member(mid, name, password, flag, status) VALUES ('admin','AEBD3CA4A16CA5F5E669669A9427952C','李楠翔',0,7);
COMMIT;