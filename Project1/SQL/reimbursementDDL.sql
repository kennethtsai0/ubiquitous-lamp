drop table employee cascade constraints;
drop table department cascade constraints;
drop table event cascade constraints;
drop table rform cascade constraints;

drop sequence emp_sequence;
drop sequence dep_sequence;
drop sequence event_sequence;
drop sequence form_sequence;

create table employee (
    empid number(20) primary key,
    firstname varchar2(20) not null,
    lastname varchar2(20) not null,
    username varchar2(20) unique not null,
    pass varchar2(12) not null,
    title varchar2(20) not null,
    id_dep number(20),
    reportsto number(20) not null,
    reimbursement_left number(10,2) not null,
    emp_type number(1) not null
);

create table department (
    depid number(20) primary key,
    department varchar2(20) unique not null,
    id_dep_head number(20),
    constraint foreign_dep_emp foreign key (id_dep_head) references employee(empid)
);

create table event (
    eventid number(20) primary key,
    event varchar2(50) not null,
    coverage number(3) not null,
    passing number(3) not null
);

create table rform (
    formid number(20) primary key,
    id_emp number(20),
    id_event number(20),
    datetime varchar2(50),
    location varchar2(20) not null,
    description varchar2(256),
    cost number(10,2) not null,
    justification varchar2(1000) not null,
    grade number(5),
    status varchar2(20) default 'Pending' not null,
    hierarchy number(1) not null,
    constraint foreign_form_event foreign key (id_event) references event(eventid)
);

create sequence emp_sequence;
create sequence dep_sequence;
create sequence event_sequence;
create sequence form_sequence;

create or replace trigger employee_pk_trigger
before insert or update on employee
for each row
begin
    if INSERTING then
        select emp_sequence.nextVal into :new.empid from dual;
    elsif UPDATING then
        select :old.empid into :new.empid from dual;
    end if;
end;
/

create or replace trigger department_pk_trigger
before insert or update on department
for each row
begin
    if INSERTING then
        select dep_sequence.nextVal into :new.depid from dual;
    elsif UPDATING then
        select :old.depid into :new.depid from dual;
    end if;
end;
/

create or replace trigger event_pk_trigger
before insert or update on event
for each row
begin
    if INSERTING then
        select event_sequence.nextVal into :new.eventid from dual;
    elsif UPDATING then
        select :old.eventid into :new.eventid from dual;
    end if;
end;
/

create or replace trigger form_pk_trigger
before insert or update on rform
for each row
begin
    if INSERTING then
        select form_sequence.nextVal into :new.formid from dual;
    elsif UPDATING then
        select :old.formid into :new.formid from dual;
    end if;
end;
/

alter table employee add constraint foreign_emp_dep foreign key (id_dep) references department(depid);