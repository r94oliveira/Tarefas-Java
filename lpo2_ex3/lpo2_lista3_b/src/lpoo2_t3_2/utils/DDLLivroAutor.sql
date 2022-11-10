CREATE TABLE autor(
	id serial,
	nome varchar(45) NOT NULL,
	constraint pk_Autor PRIMARY KEY (id)
);


CREATE TABLE livro(
	id serial,
	titulo varchar(45),
	constraint pk_Livro PRIMARY KEY (id)
);

CREATE TABLE Livro_Autor(
	idLivro int,
	idAutor int,
	constraint pk_LivroAutor primary key(idLivro, idAutor),
	constraint fk_LivroAutor_pk_Livro foreign key(idLivro) references livro(id) on update cascade,
	constraint fk_LivroAutor_pk_Autor foreign key(idAutor) references autor(id) on update cascade
);