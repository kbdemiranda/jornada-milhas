create schema if not exists milhas;

CREATE TABLE destinos
(
    id           bigserial,
    nome_destino text           not null,
    valor        numeric(10, 2) not null,
    foto         text           not null,

    constraint pk_destinos primary key (id)
);
