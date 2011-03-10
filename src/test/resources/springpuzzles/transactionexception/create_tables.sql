drop table TRANSACTION_LOG if exists;
drop sequence S_TRANSACTION_NUMBER if exists;

create table TRANSACTION_LOG (ID integer identity primary key,
  LOG_MESSAGE varchar(9) not null);
   
create sequence S_TRANSACTION_NUMBER start with 1;
create table DUAL_S_TRANSACTION_NUMBER (ZERO integer);
insert into DUAL_S_TRANSACTION_NUMBER values (0);
