insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Sam', 'Sammy', 'sams', 'pass', 'CEO', 0, null, 1000, 0);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Jess', 'Jessie', 'jessj', 'pass', 'Department Head', 1, 1, 1000, 1);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Rob', 'Robby', 'robr', 'pass', 'Project Manager', 2, 1, 1000, 2);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Mike', 'Mikey', 'mikem', 'pass', 'Associate', 3, 1, 1000, 3);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Bob', 'Bobby', 'bobb', 'pass', 'Analyst', 3, 1, 1000, 3);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Alex', 'Alexis', 'alexa', 'pass', 'Associate', 3, 1, 1000, 3);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Elliot', 'Ellie', 'elliote', 'pass', 'HR Director', 1, 2, 1000, 0);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Eve', 'Evelyn', 'evee', 'pass', 'HR Manager', 7, 2, 1000, 0);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Kyle', 'Kylie', 'kylek', 'pass', 'HR Associate', 8, 2, 1000, 1);
insert into employee(firstname, lastname, username, pass, title, reportsto, id_dep, reimbursement_left, emp_type) values ('Charlie', 'Charles', 'charliec', 'pass', 'HR Associate', 8, 2, 1000, 1);

insert into department(department, id_dep_head) values ('Engineer', 2);
insert into department(department, id_dep_head) values ('Human Resource', 7);

insert into event(event, coverage, passing) values ('University Course', 80, 80);
insert into event(event, coverage, passing) values ('Seminar', 60, 0);
insert into event(event, coverage, passing) values ('Certification Prep Class', 75, 70);
insert into event(event, coverage, passing) values ('Certification', 100, 60);
insert into event(event, coverage, passing) values ('Technical Training', 90, 50);
insert into event(event, coverage, passing) values ('Other', 30, 40);

commit;

select * from rform;    