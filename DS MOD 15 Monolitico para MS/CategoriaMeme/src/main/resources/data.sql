INSERT
INTO
  categoria
  (id, nome, descricao, data_cadastro, usuario_name)
VALUES
  (NEXTVAL('hibernate_sequence'), 'divertido', 'testeCategoria', current_date, 'andre');

INSERT
INTO
categoria
(id, nome, descricao, data_cadastro, usuario_name)
VALUES
(NEXTVAL('hibernate_sequence'), 'alegre', 'testeCategoria', current_date, 'ariel');

INSERT
INTO
  categoria
  (id, nome, descricao, data_cadastro, usuario_name)
VALUES
  (NEXTVAL('hibernate_sequence'), 'triste', 'testeCategoria', current_date, 'gabriel');