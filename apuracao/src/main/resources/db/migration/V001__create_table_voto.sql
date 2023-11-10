create table apuracao.votos (
    id serial primary key,
    id_jogador bigint,
    nome_jogador varchar(255),
    time_jogador varchar(255),
    camisa_jogador smallint
);
