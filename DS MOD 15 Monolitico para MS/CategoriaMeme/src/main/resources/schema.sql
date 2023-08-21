CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE categoria (
  id BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   descricao VARCHAR(255) NOT NULL,
   data_cadastro date NOT NULL,
   usuario_name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_categoria PRIMARY KEY (id)
);