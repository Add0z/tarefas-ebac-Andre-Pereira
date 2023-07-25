--CREATE TABLE jogo (
--  id BIGINT NOT NULL,
--   nome VARCHAR(255),
--   desenvolvedora VARCHAR(255),
--   plataforma VARCHAR(255),
--   CONSTRAINT pk_jogo PRIMARY KEY (id)
--);
--
--CREATE TABLE usuario (
--  id BIGINT NOT NULL,
--   nome VARCHAR(255),
--   login VARCHAR(255),
--   idade VARCHAR(255),
--   CONSTRAINT pk_usuario PRIMARY KEY (id)
--);
--
--CREATE TABLE jogo_usuario (
--  jogo_id BIGINT NOT NULL,
--   usuario_id BIGINT NOT NULL,
--   CONSTRAINT pk_jogo_usuario PRIMARY KEY (jogo_id, usuario_id)
--);
--
--ALTER TABLE jogo_usuario ADD CONSTRAINT fk_jogo_usuario_jogo FOREIGN KEY (jogo_id) REFERENCES jogo (id);
--ALTER TABLE jogo_usuario ADD CONSTRAINT fk_jogo_usuario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

INSERT
INTO
  jogo
  (id, nome, desenvolvedora, plataforma)
VALUES
  (1, 'Chrono Trigger', 'SquareSoft', 'SNES');

  INSERT
  INTO
    jogo
    (id, nome, desenvolvedora, plataforma)
  VALUES
    (2, 'Final Fantasy VII', 'SquareSoft', 'PlayStation ');

    INSERT
    INTO
      jogo
      (id, nome, desenvolvedora, plataforma)
    VALUES
      (3, 'Xenoblade', 'Monolithsoft', 'Nintendo Switch');


INSERT
INTO
  usuario
  (id, nome, login, idade)
VALUES
  (1, 'Andre', 'Add0z', '27');

  INSERT
INTO
  jogo_usuario
  (id, jogo_id, usuario_id)
VALUES
  (1, 1, 1);

