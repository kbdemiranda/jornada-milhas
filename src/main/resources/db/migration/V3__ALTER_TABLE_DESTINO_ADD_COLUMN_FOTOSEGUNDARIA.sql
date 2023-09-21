create schema if not exists milhas;

alter table milhas.destinos
    add column fotoSegundaria text not null default 'https://images.com/destino.jpg';