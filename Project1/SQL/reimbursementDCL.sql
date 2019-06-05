drop user reimbursementapp cascade;

create user reimbursementapp
identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;

-- we need to be able to connect to another user from bookapp
grant connect to reimbursementapp;
-- we want the ability to create types
grant resource to reimbursementapp;
-- we don't want the ability to alter and destroy types
-- grant dba to bookapp;
-- We do want the ability to create a session for transactions
grant create session to reimbursementapp;
-- self explanatory
grant create table to reimbursementapp;
grant create view to reimbursementapp;