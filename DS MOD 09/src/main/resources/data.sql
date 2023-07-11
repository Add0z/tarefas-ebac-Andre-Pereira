INSERT
INTO
  cuidador
  (id, nome, telefone, idade, data_contratacao)
VALUES
  (1, 'andre', '21231231233', '23', '2022-01-01');

  INSERT
  INTO
    cuidador
    (id, nome, telefone, idade, data_contratacao)
  VALUES
    (2, 'ariel', '21231231233', '20', '2022-01-01');


INSERT
INTO
  Animal
  (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte)
VALUES
  ('ebaco','cachorro', 2, 'SRD', current_date, 'pulgado', 1, 'pequeno');

INSERT
INTO
Animal
  (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte)
VALUES
('ebakito','cachorro', 3, 'poodle', current_date - 30, 'limpo', 2, 'medio');

INSERT
INTO
  animal
  (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte,data_Obito)
VALUES
  ('cabe','cachorro', 1, 'pincher', current_date - 45, 'fedido', 1, 'pequeno', current_date + 1);

INSERT
INTO
  animal
  (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte, data_Saida)
VALUES
  ('baco','cachorro',9, 'chiaua', current_date - 60, 'doente', 2, 'micro', current_date + 1);

  INSERT
  INTO
    Animal
    (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte)
  VALUES
    ('cataco','gato', 2, 'SRD', current_date - 90, 'pulgado', 1, 'pequeno');

    INSERT
    INTO
      Animal
    (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte)
    VALUES
      ('catiko','gato', 3, 'siames', current_date - 120, 'limpo', 2, 'medio');

  INSERT
  INTO
    animal
    (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte, data_Saida)
  VALUES
    ('gate','gato', 1, 'pelo curto', current_date - 150, 'fedido', 1, 'pequeno', current_date + 1);

  INSERT
  INTO
    animal
    (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte, data_Obito)
  VALUES
    ('gaco','gato',9, 'malhado', current_date  - 180, 'doente', 2, 'micro', current_date + 1);

    INSERT
    INTO
      animal
    (nome_Provisoria, especie, idade_Estimada, raca, data_Entrada, condicao_De_Chegada, cuidador_id, porte)
    VALUES
      ('miau', 'gato', 2, 'pelo longo', current_date - 210, 'pelo muito longo', 1, 'medio');

