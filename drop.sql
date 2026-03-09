
    set client_min_messages = WARNING;

    alter table if exists abbonamento_attivita 
       drop constraint if exists FK853iwjge5sco7nac3v8pvs72v;

    alter table if exists abbonamento_attivita 
       drop constraint if exists FK7slwjgyb7wchv5gnm07g9m6v1;

    alter table if exists abbonamento_socio 
       drop constraint if exists FK22uaw7830fw71duo88vg10i3m;

    alter table if exists certificato_medico 
       drop constraint if exists FK4qvmdsjo3bhbkpvla58ue89un;

    drop table if exists abbonamento_attivita cascade;

    drop table if exists abbonamento_socio cascade;

    drop table if exists attivita cascade;

    drop table if exists certificato_medico cascade;

    drop table if exists messaggi_systema cascade;

    drop table if exists socio_palestra cascade;
