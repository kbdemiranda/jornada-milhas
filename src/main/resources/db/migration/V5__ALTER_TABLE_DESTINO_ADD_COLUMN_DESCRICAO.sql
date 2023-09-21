create schema if not exists milhas;

alter table milhas.destinos
    add column descricao text;