# Software de atendimento de um hospital

> ### Software hospital mizericordia, possui diversas telas e cada uma com suas proprias funcionalidades. O software completo porém, possui todas as caracteristica CRUD.

## Funcionalidades incluem:

- Cadastro de pacientes : Logar com o perfil de recepção -> Menu OPÇÔES -> Cadastrar.
- Atualização de dados do paciente já cadastrado: Logar com o perfil de recepção -> Menu OPÇÔES -> atualizar.
- Excluir paciente das tabelas(Recomendado fazer isso depois do medico dar alta no paciente, para evitar conflitos): Logar com o perfil de recepção -> Menu OPÇÔES -> atualizar.
- Atender / Dar alta em pacientes vinculados a um medico: Logar com o perfil de medico -> Clicar no paciente desejado -> ATENDER primeiro e depois DAR ALTA.


## Observações:
  > Antes de começar é preciso fazer alguns passos.

  - Ter o mySQL Workbench 8.0.28 para poder rodar os codigos necessários para o programa rodar;
  - Execute as linhas de codigo abaixo na Query:
    > preparar o schema e as tabelas.
    - create database db2va;
    - create table paciente ( id int primary key auto_increment, nome varchar(30), cpf varchar(11) unique, telefone varchar(15));
    - create table status_atd (cpf_paciente varchar(11) primary key, sts_atd varchar(25), id_medico int, tipo_atd varchar(20));
    - create table usuarios (id int primary key auto_increment, login varchar(30), senha varchar(30), nome varchar(30), especialidade varchar(15), status_lg int);
    > Adicionar usuarios padrão para a aplicação
    - insert into usuarios (login, senha, nome, especialidade, status_lg) values ('*login desejado*', '*senha desejada*', '*nome desejado*', 'Medico', 0); --INSERT PARA TER ACESSO A JANELA DE ATENDIMENTO
    - insert into usuarios (login, senha, nome, especialidade, status_lg) values ('*login desejado*', '*senha desejada*', '*nome desejado*', 'Recepcionista', 0); --INSERT PARA TER ACESSO A JANELA DA RECEPÇÂO

 ### Boa experiência!!
