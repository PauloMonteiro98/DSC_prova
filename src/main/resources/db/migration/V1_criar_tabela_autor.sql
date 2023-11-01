create table autor (
    id int auto_increment primary key,
    nome varchar(200) not null,
    nacionalidade varchar(200) not null,
    lista_livros_escritos varchar(200) not null,
    quantidade_copia_disponivel int not null
);