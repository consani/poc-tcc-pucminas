DROP TABLE IF EXISTS ATIVO;
DROP TABLE IF EXISTS SENSOR_DATA;
 
CREATE TABLE ativo (
  codigo INT AUTO_INCREMENT  PRIMARY KEY,
  descricao VARCHAR(256) NOT NULL,
  categoria VARCHAR(128) NOT NULL,
  fornecedor VARCHAR(128) NOT NULL,
  data_fabricacao DATE,
  valor_unitario DECIMAL(10,2),
  prazo_validade INTEGER  
  
);

CREATE TABLE sensor_data (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  barragem VARCHAR(256) ,
  tipo_metrica VARCHAR(128) ,
  valor_metrica DECIMAL(10,2),
  data_coleta DATE,
  latitude DECIMAL(10,2),
  longitude DECIMAL(10,2)  
  
);

 
INSERT INTO ativo (descricao, categoria, fornecedor, data_fabricacao, valor_unitario, prazo_validade ) VALUES
  ('Trator Modelo A', 'VEICULO', 'Empresa Fornecedora Beltrano', '2019-04-21', 195500, 60),
  ('Triturador WYK', 'EQUIPAMENTO', 'WYK Industria e Comércio', '2020-07-05', 234567, 48),
  ('Areia Peneirada', 'INSUMO', 'Cascalhos e Barbalhos Insumos', '2018-11-12', 23456, 6),
  ('Britadeira', 'EQUIPAMENTO', 'Empresa Fornecedora Beltrano', '2017-05-17', 347885, 60),
  ('Motor Tracionado BwP', 'MECANISMO', 'Peças Industriais Canário', '2018-12-27', 223400, 36),
  ('Sensor IoT de Temperatura', 'EQUIPAMENTO', 'Grupo Tecnologico ABC', '2019-08-13', 3500, 24); 
 
