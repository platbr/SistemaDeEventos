
CREATE TABLE "area" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nome" text,
  "valor" float,
  "id_evento" integer
) 

--
-- Dumping data for table "area"
--

--
-- Table structure for table "cliente"
--


CREATE TABLE "cliente" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nome" text
) 

--
-- Dumping data for table "cliente"
--


--
-- Table structure for table "evento"
--

CREATE TABLE "evento" (
  "nome" text DEFAULT NULL,
  "inicio" datatime ,
  "fim" datatime ,
  "local" text DEFAULT NULL,
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL
) 

--
-- Dumping data for table "evento"
--



--
-- Table structure for table "ingresso"
--


CREATE TABLE "ingresso" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "numero" varchar(45) DEFAULT NULL
)

--
-- Dumping data for table "ingresso"
--



--
-- Table structure for table "operador"
--


CREATE TABLE "operador" (
  "nome" text ,
  "usuario" text,
  "senha" text,
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "nivel_acesso" int
) 

--
-- Dumping data for table "operador"
--


CREATE TABLE "venda" (
  "id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "data" datatime ,
  "status_venda" int(1),
  "id_cliente" int(10) ,
  "id_operador" int(10) ,
  "id_ingresso" int(10) 
) 
