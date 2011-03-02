drop table ACCOUNT if exists;
drop table TRANSACTION_LOG if exists;
drop sequence S_TRANSACTION_NUMBER if exists;

create table ACCOUNT (account_id varchar(50) primary key, savings double );

create table TRANSACTION_LOG (ID integer identity primary key, TRANSACTION_AMOUNT double not null,
  ACCOUNT_FROM_NUMBER varchar(9) not null,
  ACCOUNT_FROM_TO varchar(9) not null);
   
create sequence S_TRANSACTION_NUMBER start with 1;
create table DUAL_S_TRANSACTION_NUMBER (ZERO integer);
insert into DUAL_S_TRANSACTION_NUMBER values (0);
