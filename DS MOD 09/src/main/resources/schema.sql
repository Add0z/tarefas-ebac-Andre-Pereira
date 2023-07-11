CREATE TABLE cuidador (
  id BIGINT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   telefone VARCHAR(255) NOT NULL,
   idade INT NOT NULL,
   data_contratacao date NOT NULL,
   data_saida date,
   CONSTRAINT pk_cuidador PRIMARY KEY (id)
);

CREATE TABLE animal (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome_provisoria VARCHAR(255) NOT NULL,
  especie VARCHAR(255) NOT NULL,
  idade_estimada INT NOT NULL,
  raca VARCHAR(255) NOT NULL,
  data_entrada DATE NOT NULL,
  data_saida DATE,
  condicao_de_chegada VARCHAR(255) NOT NULL,
  cuidador_id BIGINT NOT NULL,
  data_obito DATE,
  porte VARCHAR(255) NOT NULL,
  CONSTRAINT fk_animal_on_cuidador_nome FOREIGN KEY (cuidador_id) REFERENCES cuidador (id)
);