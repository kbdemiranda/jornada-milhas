create schema if not exists milhas;

CREATE TABLE depoimentos
(
    id         bigserial,
    nome       text not null,
    depoimento text not null,
    foto       text not null,

    constraint pk_depoimentos primary key (id)
);
