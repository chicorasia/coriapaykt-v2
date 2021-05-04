CREATE TABLE IF NOT EXISTS usuarios (
	id	INTEGER AUTOINCREMENT() PRIMARY KEY,
	login	VARCHER,
	"senha"	TEXT,
	"nomecompleto"	TEXT,
	"cpf"	TEXT,
	"datanascimento"	TEXT,
	"numerotelefone"	TEXT,
	"ativo"	INTEGER,
	"saldo"	NUMERIC,
	PRIMARY KEY("Id")
)