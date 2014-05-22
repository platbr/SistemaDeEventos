PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;

DROP TABLE cliente;
DROP TABLE evento;
DROP TABLE operador;
DROP TABLE venda;
DROP TABLE area;
DROP TABLE ingresso;

CREATE TABLE "cliente" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nome" text
);
CREATE TABLE "evento" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nome" text,
  "inicio" datatime ,
  "fim" datatime ,
  "local" text
);
CREATE TABLE "operador" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nome" text ,
  "usuario" text,
  "senha" text,
  "nivel_acesso" integer
);
CREATE TABLE "venda" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "data" datatime ,
  "status_venda" int(1),
  "id_cliente" integer ,
  "id_operador" integer ,
  "id_ingresso" integer,
 FOREIGN KEY(id_cliente) REFERENCES cliente(id),
 FOREIGN KEY(id_operador) REFERENCES operador(id),
 FOREIGN KEY(id_ingresso) REFERENCES ingresso(id)
);
CREATE TABLE "area" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nome" text,
  "valor" float,
  "id_evento" integer,
 "lotacao" integer,
FOREIGN KEY(id_evento) REFERENCES evento(id)
);
CREATE TABLE "ingresso" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "numero" varchar(30),
  "id_area" integer,
 FOREIGN KEY(id_area) REFERENCES area(id)
);
COMMIT;
