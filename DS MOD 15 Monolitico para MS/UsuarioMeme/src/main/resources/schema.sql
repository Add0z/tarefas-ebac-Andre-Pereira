CREATE SEQUENCE sequence_usuario START WITH 1 INCREMENT BY 50;

CREATE TABLE usuario (
  id BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   data_cadastro date NOT NULL,
   karma BIGINT NOT NULL,
   CONSTRAINT pk_usuario PRIMARY KEY (id)
);
