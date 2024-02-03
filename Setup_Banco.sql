create database db2va;

use db2va;

create table paciente ( 
	id int primary key auto_increment,
    nome varchar(30), 
    cpf varchar(11) unique,
    telefone varchar(15)
    );
    
create table status_atd (
	cpf_paciente varchar(11) primary key,
    sts_atd varchar(25),
    id_medico int,
    tipo_atd varchar(20)
    );
    
create table usuarios (
	id int primary key auto_increment,
    login varchar(30),
    senha varchar(30),
    nome varchar(30),
    especialidade varchar(15),
    status_lg int
    );

insert into usuarios (login, senha, nome, especialidade, status_lg) 
values ('MedicoUsuario1', '123456', 'Medico1', 'Medico', 0);

insert into usuarios (login, senha, nome, especialidade, status_lg) 
values ('MedicoUsuario2', '123456', 'Medico2', 'Medico', 0);

insert into usuarios (login, senha, nome, especialidade, status_lg) 
values ('MedicoUsuario3', '123456', 'Medico3', 'Medico', 0);

insert into usuarios (login, senha, nome, especialidade, status_lg) 
values ('RecepcaoUsuario', '123456', 'Recepcionista', 'Recepcionista', 0);

