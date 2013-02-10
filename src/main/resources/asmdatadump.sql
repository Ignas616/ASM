--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.1
-- Dumped by pg_dump version 9.1.1
-- Started on 2013-02-07 14:32:30

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 182 (class 3079 OID 11638)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1936 (class 0 OID 0)
-- Dependencies: 182
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 536 (class 1247 OID 21278)
-- Dependencies: 5 181
-- Name: cardtypereport; Type: TYPE; Schema: public; Owner: reg_admin
--

CREATE TYPE cardtypereport AS (
	physicalid integer,
	addressid integer,
	count bigint
);


ALTER TYPE public.cardtypereport OWNER TO reg_admin;

--
-- TOC entry 194 (class 1255 OID 21279)
-- Dependencies: 536 5
-- Name: get_card_type_report(integer); Type: FUNCTION; Schema: public; Owner: reg_admin
--

CREATE FUNCTION get_card_type_report(cardid integer) RETURNS SETOF cardtypereport
    LANGUAGE sql
    AS $_$SELECT 
  physical_location.id as physicalid, 
  null as addressid,
  count(card_type.id) as count  
FROM 
  public.card_type, 
  public.card, 
  public.shelf, 
  public.device, 
  public.physical_location
WHERE 
  card_type.id = card.card_type AND
  card.shelf_id = shelf.id AND
  shelf.device_id = device.id AND
  device.physical_location_id = physical_location.id AND
  card_type.id = $1
 group by card_type.id, physicalid
UNION ALL 
SELECT 
  null as physicalid,
  address_location.id  as addressid, 
  count(card_type.id) as count 
FROM 
  public.card_type, 
  public.card, 
  public.shelf, 
  public.device, 
  public.address_location
WHERE 
  card_type.id = card.card_type AND
  card.shelf_id = shelf.id AND
  shelf.device_id = device.id AND
  device.address_location_id = address_location.id AND
  card_type.id = $1
 group by card_type.id, addressid;$_$;


ALTER FUNCTION public.get_card_type_report(cardid integer) OWNER TO reg_admin;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 21120)
-- Dependencies: 5
-- Name: address_location; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE address_location (
    id integer NOT NULL,
    city_name character varying(255),
    street_name character varying(255),
    name character varying(255),
    house_no character varying(25)
);


ALTER TABLE public.address_location OWNER TO reg_admin;

--
-- TOC entry 176 (class 1259 OID 21191)
-- Dependencies: 5
-- Name: address_location_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE address_location_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.address_location_seq OWNER TO reg_admin;

--
-- TOC entry 1937 (class 0 OID 0)
-- Dependencies: 176
-- Name: address_location_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('address_location_seq', 1, true);


--
-- TOC entry 165 (class 1259 OID 21132)
-- Dependencies: 5
-- Name: card; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE card (
    id integer NOT NULL,
    name character varying(255),
    card_type integer,
    shelf_id integer
);


ALTER TABLE public.card OWNER TO reg_admin;

--
-- TOC entry 173 (class 1259 OID 21180)
-- Dependencies: 5
-- Name: card_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE card_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.card_seq OWNER TO reg_admin;

--
-- TOC entry 1938 (class 0 OID 0)
-- Dependencies: 173
-- Name: card_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('card_seq', 2, true);


--
-- TOC entry 167 (class 1259 OID 21141)
-- Dependencies: 5
-- Name: card_type; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE card_type (
    id integer NOT NULL,
    name character varying(255),
    no_of_ports integer
);


ALTER TABLE public.card_type OWNER TO reg_admin;

--
-- TOC entry 174 (class 1259 OID 21182)
-- Dependencies: 5
-- Name: card_type_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE card_type_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.card_type_seq OWNER TO reg_admin;

--
-- TOC entry 1939 (class 0 OID 0)
-- Dependencies: 174
-- Name: card_type_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('card_type_seq', 1, false);


--
-- TOC entry 163 (class 1259 OID 21126)
-- Dependencies: 5
-- Name: device; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE device (
    id integer NOT NULL,
    name character varying(255),
    device_type integer,
    address_location_id integer,
    physical_location_id integer
);


ALTER TABLE public.device OWNER TO reg_admin;

--
-- TOC entry 179 (class 1259 OID 21241)
-- Dependencies: 5
-- Name: device_allowed_shelf_types; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE device_allowed_shelf_types (
    id integer NOT NULL,
    device_type integer,
    shelf_type integer
);


ALTER TABLE public.device_allowed_shelf_types OWNER TO reg_admin;

--
-- TOC entry 180 (class 1259 OID 21246)
-- Dependencies: 5
-- Name: device_allowed_shelf_types_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE device_allowed_shelf_types_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.device_allowed_shelf_types_seq OWNER TO reg_admin;

--
-- TOC entry 1940 (class 0 OID 0)
-- Dependencies: 180
-- Name: device_allowed_shelf_types_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('device_allowed_shelf_types_seq', 1, false);


--
-- TOC entry 168 (class 1259 OID 21144)
-- Dependencies: 5
-- Name: device_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE device_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.device_seq OWNER TO reg_admin;

--
-- TOC entry 1941 (class 0 OID 0)
-- Dependencies: 168
-- Name: device_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('device_seq', 6, true);


--
-- TOC entry 170 (class 1259 OID 21165)
-- Dependencies: 5
-- Name: device_type; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE device_type (
    id integer NOT NULL,
    name character varying(255),
    no_of_shelves integer
);


ALTER TABLE public.device_type OWNER TO reg_admin;

--
-- TOC entry 169 (class 1259 OID 21161)
-- Dependencies: 5
-- Name: device_type_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE device_type_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.device_type_seq OWNER TO reg_admin;

--
-- TOC entry 1942 (class 0 OID 0)
-- Dependencies: 169
-- Name: device_type_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('device_type_seq', 1, false);


--
-- TOC entry 161 (class 1259 OID 21117)
-- Dependencies: 5
-- Name: physical_location; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE physical_location (
    id integer NOT NULL,
    coord_x integer,
    coord_y integer,
    coord_z integer,
    name character varying(255)
);


ALTER TABLE public.physical_location OWNER TO reg_admin;

--
-- TOC entry 175 (class 1259 OID 21189)
-- Dependencies: 5
-- Name: physical_location_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE physical_location_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.physical_location_seq OWNER TO reg_admin;

--
-- TOC entry 1943 (class 0 OID 0)
-- Dependencies: 175
-- Name: physical_location_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('physical_location_seq', 1, true);


--
-- TOC entry 164 (class 1259 OID 21129)
-- Dependencies: 5
-- Name: shelf; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE shelf (
    id integer NOT NULL,
    number integer,
    shelf_type integer,
    device_id integer
);


ALTER TABLE public.shelf OWNER TO reg_admin;

--
-- TOC entry 177 (class 1259 OID 21234)
-- Dependencies: 5
-- Name: shelf_allowed_card_types; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE shelf_allowed_card_types (
    shelf_type_id integer,
    card_type_id integer,
    id integer NOT NULL
);


ALTER TABLE public.shelf_allowed_card_types OWNER TO reg_admin;

--
-- TOC entry 178 (class 1259 OID 21237)
-- Dependencies: 5
-- Name: shelf_allowed_card_types_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE shelf_allowed_card_types_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.shelf_allowed_card_types_seq OWNER TO reg_admin;

--
-- TOC entry 1945 (class 0 OID 0)
-- Dependencies: 178
-- Name: shelf_allowed_card_types_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('shelf_allowed_card_types_seq', 1, false);


--
-- TOC entry 171 (class 1259 OID 21172)
-- Dependencies: 5
-- Name: shelf_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE shelf_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.shelf_seq OWNER TO reg_admin;

--
-- TOC entry 1946 (class 0 OID 0)
-- Dependencies: 171
-- Name: shelf_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('shelf_seq', 10, true);


--
-- TOC entry 166 (class 1259 OID 21138)
-- Dependencies: 5
-- Name: shelf_type; Type: TABLE; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE TABLE shelf_type (
    id integer NOT NULL,
    name character varying(255),
    no_of_allowed_card_slots integer
);


ALTER TABLE public.shelf_type OWNER TO reg_admin;

--
-- TOC entry 172 (class 1259 OID 21174)
-- Dependencies: 5
-- Name: shelf_type_seq; Type: SEQUENCE; Schema: public; Owner: reg_admin
--

CREATE SEQUENCE shelf_type_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.shelf_type_seq OWNER TO reg_admin;

--
-- TOC entry 1947 (class 0 OID 0)
-- Dependencies: 172
-- Name: shelf_type_seq; Type: SEQUENCE SET; Schema: public; Owner: reg_admin
--

SELECT pg_catalog.setval('shelf_type_seq', 1, false);


--
-- TOC entry 1922 (class 0 OID 21120)
-- Dependencies: 162
-- Data for Name: address_location; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO address_location VALUES (1, 'Tallinn', 'Sqpruse', 'MyHouse', '24s');


--
-- TOC entry 1925 (class 0 OID 21132)
-- Dependencies: 165
-- Data for Name: card; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO card VALUES (4, '4gb Card', 4, NULL);
INSERT INTO card VALUES (2, '2gb Card', 2, NULL);
INSERT INTO card VALUES (3, '3gb', 3, NULL);


--
-- TOC entry 1927 (class 0 OID 21141)
-- Dependencies: 167
-- Data for Name: card_type; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO card_type VALUES (1, 'hearts', 1);
INSERT INTO card_type VALUES (2, 'diamonds', 2);
INSERT INTO card_type VALUES (3, 'spades', 3);
INSERT INTO card_type VALUES (4, 'kings', 4);
INSERT INTO card_type VALUES (5, 'aces', 5);


--
-- TOC entry 1923 (class 0 OID 21126)
-- Dependencies: 163
-- Data for Name: device; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO device VALUES (1, 'Apple Server', 2, NULL, 1);
INSERT INTO device VALUES (6, 'Apple Server 2', 2, NULL, 2);


--
-- TOC entry 1930 (class 0 OID 21241)
-- Dependencies: 179
-- Data for Name: device_allowed_shelf_types; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO device_allowed_shelf_types VALUES (1, 1, 1);
INSERT INTO device_allowed_shelf_types VALUES (2, 2, 1);
INSERT INTO device_allowed_shelf_types VALUES (3, 2, 2);
INSERT INTO device_allowed_shelf_types VALUES (4, 3, 1);
INSERT INTO device_allowed_shelf_types VALUES (5, 3, 2);
INSERT INTO device_allowed_shelf_types VALUES (6, 3, 3);


--
-- TOC entry 1928 (class 0 OID 21165)
-- Dependencies: 170
-- Data for Name: device_type; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO device_type VALUES (1, 'Server', 1);
INSERT INTO device_type VALUES (2, 'Small Server', 2);
INSERT INTO device_type VALUES (3, 'Big  Server', 3);


--
-- TOC entry 1921 (class 0 OID 21117)
-- Dependencies: 161
-- Data for Name: physical_location; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO physical_location VALUES (2, 4, 5, 6, 'Location 2');
INSERT INTO physical_location VALUES (1, 1, 2, 3, 'Location 1');


--
-- TOC entry 1924 (class 0 OID 21129)
-- Dependencies: 164
-- Data for Name: shelf; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO shelf VALUES (10, 1111, 2, NULL);


--
-- TOC entry 1929 (class 0 OID 21234)
-- Dependencies: 177
-- Data for Name: shelf_allowed_card_types; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO shelf_allowed_card_types VALUES (1, 1, 1);
INSERT INTO shelf_allowed_card_types VALUES (1, 2, 2);
INSERT INTO shelf_allowed_card_types VALUES (1, 4, 3);
INSERT INTO shelf_allowed_card_types VALUES (2, 1, 4);
INSERT INTO shelf_allowed_card_types VALUES (2, 3, 5);
INSERT INTO shelf_allowed_card_types VALUES (2, 5, 6);
INSERT INTO shelf_allowed_card_types VALUES (3, 2, 7);
INSERT INTO shelf_allowed_card_types VALUES (3, 4, 8);


--
-- TOC entry 1926 (class 0 OID 21138)
-- Dependencies: 166
-- Data for Name: shelf_type; Type: TABLE DATA; Schema: public; Owner: reg_admin
--

INSERT INTO shelf_type VALUES (1, 'shelfType1', 1);
INSERT INTO shelf_type VALUES (2, 'shelfType2', 2);
INSERT INTO shelf_type VALUES (3, 'shelfType3', 3);


--
-- TOC entry 1901 (class 2606 OID 21198)
-- Dependencies: 162 162
-- Name: addresslocation_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY address_location
    ADD CONSTRAINT addresslocation_pkey PRIMARY KEY (id);


--
-- TOC entry 1908 (class 2606 OID 21185)
-- Dependencies: 165 165
-- Name: card_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY card
    ADD CONSTRAINT card_pkey PRIMARY KEY (id);


--
-- TOC entry 1915 (class 2606 OID 21169)
-- Dependencies: 170 170
-- Name: deviceType_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY device_type
    ADD CONSTRAINT "deviceType_pkey" PRIMARY KEY (id);


--
-- TOC entry 1919 (class 2606 OID 21245)
-- Dependencies: 179 179
-- Name: device_allowed_shelf_types_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY device_allowed_shelf_types
    ADD CONSTRAINT device_allowed_shelf_types_pkey PRIMARY KEY (id);


--
-- TOC entry 1903 (class 2606 OID 21156)
-- Dependencies: 163 163
-- Name: device_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY device
    ADD CONSTRAINT device_pkey PRIMARY KEY (id);


--
-- TOC entry 1913 (class 2606 OID 21188)
-- Dependencies: 167 167
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY card_type
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1899 (class 2606 OID 21196)
-- Dependencies: 161 161
-- Name: physicallocation_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY physical_location
    ADD CONSTRAINT physicallocation_pkey PRIMARY KEY (id);


--
-- TOC entry 1917 (class 2606 OID 21240)
-- Dependencies: 177 177
-- Name: shelf_allowed_card_types_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY shelf_allowed_card_types
    ADD CONSTRAINT shelf_allowed_card_types_pkey PRIMARY KEY (id);


--
-- TOC entry 1906 (class 2606 OID 21179)
-- Dependencies: 164 164
-- Name: shelf_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY shelf
    ADD CONSTRAINT shelf_pkey PRIMARY KEY (id);


--
-- TOC entry 1911 (class 2606 OID 21177)
-- Dependencies: 166 166
-- Name: shelftype_pkey; Type: CONSTRAINT; Schema: public; Owner: reg_admin; Tablespace: 
--

ALTER TABLE ONLY shelf_type
    ADD CONSTRAINT shelftype_pkey PRIMARY KEY (id);


--
-- TOC entry 1904 (class 1259 OID 21296)
-- Dependencies: 164
-- Name: fki_device_fkey; Type: INDEX; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE INDEX fki_device_fkey ON shelf USING btree (device_id);


--
-- TOC entry 1909 (class 1259 OID 21302)
-- Dependencies: 165
-- Name: fki_shelf_fk; Type: INDEX; Schema: public; Owner: reg_admin; Tablespace: 
--

CREATE INDEX fki_shelf_fk ON card USING btree (shelf_id);


--
-- TOC entry 1920 (class 2606 OID 21291)
-- Dependencies: 164 1902 163
-- Name: device_fkey; Type: FK CONSTRAINT; Schema: public; Owner: reg_admin
--

ALTER TABLE ONLY shelf
    ADD CONSTRAINT device_fkey FOREIGN KEY (device_id) REFERENCES device(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1935 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 1944 (class 0 OID 0)
-- Dependencies: 177
-- Name: shelf_allowed_card_types; Type: ACL; Schema: public; Owner: reg_admin
--

REVOKE ALL ON TABLE shelf_allowed_card_types FROM PUBLIC;
REVOKE ALL ON TABLE shelf_allowed_card_types FROM reg_admin;
GRANT ALL ON TABLE shelf_allowed_card_types TO reg_admin;


-- Completed on 2013-02-07 14:32:32

--
-- PostgreSQL database dump complete
--

