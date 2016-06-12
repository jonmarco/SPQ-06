CREATE DATABASE spotifydb;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON spotifydb.*
           TO spq@'%'
           IDENTIFIED BY 'spq';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON spotifydb.*
           TO spq@localhost
           IDENTIFIED BY 'spq';