DROP ROLE reg_admin;

CREATE ROLE reg_admin LOGIN
  ENCRYPTED PASSWORD 'md57872ad59c0486f923e1ddd5af952b07c'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;


-- Database: asm

DROP DATABASE asm;

CREATE DATABASE asm
  WITH OWNER = reg_admin
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Estonian_Estonia.1257'
       LC_CTYPE = 'Estonian_Estonia.1257'
       CONNECTION LIMIT = -1;
