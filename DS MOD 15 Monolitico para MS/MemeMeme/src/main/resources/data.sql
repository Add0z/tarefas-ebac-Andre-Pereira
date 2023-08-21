INSERT
INTO
  meme
  (id, nome, descricao, data_cadastro, categoria, usuario)
VALUES
  (NEXTVAL('sequence_meme'), 'cachorro caramelo', 'caramel', current_date, 'divertido', 'andre');

INSERT
INTO
  meme
  (id, nome, descricao, data_cadastro, categoria, usuario)
VALUES
  (NEXTVAL('sequence_meme'), 'bebe foca', 'baby', current_date, 'alegre', 'ariel');

INSERT
INTO
  meme
  (id, nome, descricao, data_cadastro, categoria, usuario)
VALUES
  (NEXTVAL('sequence_meme'), 'gato preto', 'black', current_date, 'triste', 'gabriel');