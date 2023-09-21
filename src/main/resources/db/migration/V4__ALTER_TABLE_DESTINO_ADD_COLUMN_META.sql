create schema if not exists milhas;

alter table milhas.destinos
    add column meta text not null default 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.';