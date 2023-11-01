create table emprestimo (
    id int auto_increment primary key,
    data_devoluçao varchar(200) not null,
    data_emprestimo varchar(200) not null,
    livro_emprestado varchar(200) not null,
    usuário_emprestimo varchar(200) not null
);
