--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Ubuntu 14.5-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.5 (Ubuntu 14.5-0ubuntu0.22.04.1)

-- Started on 2023-01-16 20:51:56 IST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 17422)
-- Name: booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.booking (
    booking_id uuid NOT NULL,
    id uuid,
    screen_show_id uuid,
    seats_booked character varying(255)[],
    user_id uuid
);


ALTER TABLE public.booking OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17383)
-- Name: playground; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playground (
    equip_id integer NOT NULL,
    type character varying(50) NOT NULL,
    color character varying(25) NOT NULL,
    location character varying(25),
    install_date date,
    CONSTRAINT playground_location_check CHECK (((location)::text = ANY (ARRAY[('north'::character varying)::text, ('south'::character varying)::text, ('west'::character varying)::text, ('east'::character varying)::text, ('northeast'::character varying)::text, ('southeast'::character varying)::text, ('southwest'::character varying)::text, ('northwest'::character varying)::text])))
);


ALTER TABLE public.playground OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17387)
-- Name: playground_equip_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.playground_equip_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.playground_equip_id_seq OWNER TO postgres;

--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 210
-- Name: playground_equip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.playground_equip_id_seq OWNED BY public.playground.equip_id;


--
-- TOC entry 211 (class 1259 OID 17388)
-- Name: screen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screen (
    screen_id uuid NOT NULL,
    name character varying(255),
    theater_id uuid
);


ALTER TABLE public.screen OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17391)
-- Name: screen_show; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screen_show (
    screen_show_id uuid NOT NULL,
    screen_id uuid,
    show_date_time timestamp(6) without time zone,
    show_id uuid
);


ALTER TABLE public.screen_show OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17394)
-- Name: show; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.show (
    show_id uuid NOT NULL,
    genere smallint,
    language character varying(255),
    title character varying(255)
);


ALTER TABLE public.show OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 17399)
-- Name: theater; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.theater (
    theater_id uuid NOT NULL,
    email_id character varying(255),
    hashed_password character varying(255),
    name character varying(255),
    phone integer NOT NULL,
    zip character varying(255)
);


ALTER TABLE public.theater OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17404)
-- Name: user_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_entity (
    id uuid NOT NULL,
    email_id character varying(255),
    hashed_password character varying(255),
    phone integer NOT NULL,
    user_name character varying(255),
    zip character varying(255)
);


ALTER TABLE public.user_entity OWNER TO postgres;

--
-- TOC entry 3229 (class 2604 OID 17409)
-- Name: playground equip_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playground ALTER COLUMN equip_id SET DEFAULT nextval('public.playground_equip_id_seq'::regclass);


--
-- TOC entry 3391 (class 0 OID 17422)
-- Dependencies: 216
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.booking (booking_id, id, screen_show_id, seats_booked, user_id) FROM stdin;
93718f72-0a5f-4d28-96c0-4c7b4ab450a0	\N	2cc69acc-1e2a-4aa7-a2e6-0b61eb94f6a0	{A1,A2,A3,A4}	1d127e60-9179-4703-981b-c4fec74c9a70
3e150729-b047-4806-b25b-83a10456a9ea	\N	2cc69acc-1e2a-4aa7-a2e6-0b61eb94f6a0	{B1,B2}	159d06df-6e28-466e-86f2-32e8e0123a11
a4c0309a-eddd-463e-a637-43869967a670	\N	2cc69acc-1e2a-4aa7-a2e6-0b61eb94f6a0	{B3,B4}	4319bab8-cd80-4150-80d3-c9ffab69a3cf
15432822-b23a-433c-b741-05d99845226e	\N	2cc69acc-1e2a-4aa7-a2e6-0b61eb94f6a0	{"Z1,Z2,Z3"}	1d127e60-9179-4703-981b-c4fec74c9a70
adf3b8aa-5282-4eb0-98d0-46ded95cf2b8	\N	2cc69acc-1e2a-4aa7-a2e6-0b61eb94f6a0	{"X1,X2,X3"}	192cf3f7-e66b-4dce-bad1-5c6bb46e1bb5
\.


--
-- TOC entry 3384 (class 0 OID 17383)
-- Dependencies: 209
-- Data for Name: playground; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playground (equip_id, type, color, location, install_date) FROM stdin;
\.


--
-- TOC entry 3386 (class 0 OID 17388)
-- Dependencies: 211
-- Data for Name: screen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.screen (screen_id, name, theater_id) FROM stdin;
6ba75181-7e92-4d4a-8df3-47fe79d62d90	PVR1	6571a436-5a80-42dd-8ea9-2be0ab90650b
0cc16657-bbac-428b-b6cd-6dec97023bef	PVR2	6571a436-5a80-42dd-8ea9-2be0ab90650b
3280b7b4-7b50-4013-8f5e-b48f97cf6bbe	PVR3	6571a436-5a80-42dd-8ea9-2be0ab90650b
2275bbd8-e416-4757-be2f-6b67d68f4c9d	CP1	68c79a58-3795-4f03-bfb9-2c7c43bcc5f5
f0052a79-37de-40e3-8b18-a6c01f623368	CP2	68c79a58-3795-4f03-bfb9-2c7c43bcc5f5
cb37332a-8f5d-4174-8a63-94e006f78ad3	CP3	68c79a58-3795-4f03-bfb9-2c7c43bcc5f5
\.


--
-- TOC entry 3387 (class 0 OID 17391)
-- Dependencies: 212
-- Data for Name: screen_show; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.screen_show (screen_show_id, screen_id, show_date_time, show_id) FROM stdin;
2cc69acc-1e2a-4aa7-a2e6-0b61eb94f6a0	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 08:30:00	826b0dd1-9f71-4063-920f-24256ee7965d
9cea14d0-e4af-435a-9f33-95140d68567a	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 10:30:00	826b0dd1-9f71-4063-920f-24256ee7965d
157b0d3b-ec02-4939-8a4c-215ec90a87b0	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 12:30:00	826b0dd1-9f71-4063-920f-24256ee7965d
3cba938b-cb5d-45fd-a96b-77369f19729d	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 14:30:00	07d98b33-4836-49cb-a69f-01078157ee11
9342175b-1a43-4c80-9ba5-9caa7f4607eb	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 16:30:00	07d98b33-4836-49cb-a69f-01078157ee11
d9f70912-134e-465f-9a46-f7d6ccb2ca8d	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 18:30:00	07d98b33-4836-49cb-a69f-01078157ee11
2126c35a-9903-44b9-9e1e-2b20bdbdfa01	0cc16657-bbac-428b-b6cd-6dec97023bef	2023-01-20 22:30:00	07d98b33-4836-49cb-a69f-01078157ee11
1826ff8f-2822-470b-90ca-215d0a93ad93	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 22:30:00	07d98b33-4836-49cb-a69f-01078157ee11
5f51b5fe-4a6a-450b-8481-e4a5420885b5	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 20:30:00	07d98b33-4836-49cb-a69f-01078157ee11
e0298bff-c423-4fa4-b716-5249f7704435	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 18:30:00	07d98b33-4836-49cb-a69f-01078157ee11
82d698cf-7a49-467e-ab0c-175df60f6774	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 16:30:00	07d98b33-4836-49cb-a69f-01078157ee11
4a3bb225-5c25-446b-9cff-bc1490186272	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 14:30:00	07d98b33-4836-49cb-a69f-01078157ee11
6a6b80fa-6f88-418b-b764-0f7381c80e86	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 12:30:00	07d98b33-4836-49cb-a69f-01078157ee11
af05dac0-f763-4f7d-bcdf-46409a399ae5	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 10:30:00	07d98b33-4836-49cb-a69f-01078157ee11
06e4a9ca-dcf4-4af2-abc9-85d70a7eeb00	6ba75181-7e92-4d4a-8df3-47fe79d62d90	2023-01-20 08:30:00	07d98b33-4836-49cb-a69f-01078157ee11
c8cc5a15-3f2e-4344-9ecc-a9b9aeb29fad	cb37332a-8f5d-4174-8a63-94e006f78ad3	2023-01-12 00:12:18.51	826b0dd1-9f71-4063-920f-24256ee7965d
78d3ec46-5947-40da-9d43-342e185ed892	cb37332a-8f5d-4174-8a63-94e006f78ad3	2023-01-12 14:12:18.51	826b0dd1-9f71-4063-920f-24256ee7965d
f43fe733-26ca-4797-b761-ba2e3ddb1011	cb37332a-8f5d-4174-8a63-94e006f78ad3	2023-01-12 16:12:18.51	826b0dd1-9f71-4063-920f-24256ee7965d
c840cac4-2935-42c6-8406-f95934b380bc	0cc16657-bbac-428b-b6cd-6dec97023bef	2010-01-12 11:42:03.702	e8fdf6db-9067-47ae-a715-58f10182cc66
5025aa6f-424e-4ed6-9d72-407e0ca4bbd3	0cc16657-bbac-428b-b6cd-6dec97023bef	2010-01-12 13:42:03.702	e8fdf6db-9067-47ae-a715-58f10182cc66
ab5aa554-5b58-44f1-803b-8fec4ae5bc0b	0cc16657-bbac-428b-b6cd-6dec97023bef	2010-01-12 15:42:03.702	e8fdf6db-9067-47ae-a715-58f10182cc66
\.


--
-- TOC entry 3388 (class 0 OID 17394)
-- Dependencies: 213
-- Data for Name: show; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.show (show_id, genere, language, title) FROM stdin;
826b0dd1-9f71-4063-920f-24256ee7965d	0	English	Avtaar2
b9d68530-2301-413f-a636-7eaa4cfeebad	4	Hindi	Drushyam2
9a6ea086-18ca-4017-9d50-60fe78d960ab	4	Hindi	Unchayiya
36a406d2-d4d1-45f3-81b5-9550c54aff65	2	English	Operation Fortune
07d98b33-4836-49cb-a69f-01078157ee11	4	English	Titanic
e8fdf6db-9067-47ae-a715-58f10182cc66	0	English	Avtaar
\.


--
-- TOC entry 3389 (class 0 OID 17399)
-- Dependencies: 214
-- Data for Name: theater; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.theater (theater_id, email_id, hashed_password, name, phone, zip) FROM stdin;
68c79a58-3795-4f03-bfb9-2c7c43bcc5f5	cp@test.com	Cp123	City Pride	111111	111111
6571a436-5a80-42dd-8ea9-2be0ab90650b	pvr@test.com	Pvr123	PVR	222222	111111
ef3e9edb-88e0-4ae1-b5b9-438a8ad15c36	inox@test.com	Inox123	Inox	333333	111111
7c9d92fd-afa2-4972-ad59-0a9994a24de1	funtime@test.com	Funtime123	Funtime	444444	111111
\.


--
-- TOC entry 3390 (class 0 OID 17404)
-- Dependencies: 215
-- Data for Name: user_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_entity (id, email_id, hashed_password, phone, user_name, zip) FROM stdin;
192cf3f7-e66b-4dce-bad1-5c6bb46e1bb5	cp@test.com	{bcrypt}$2a$10$z/oq112bYRXhp4hyb11u9.ys0kLfDrNZfMAYLE6M1hLCZqpcsS65C	111111	Fiona	111111
1d127e60-9179-4703-981b-c4fec74c9a70	alice@test.com	{bcrypt}$2a$10$sHPEVhA4LT9TwlgzGmNB2euLdx3Zw0yhL0Eu.6PUDnjmZETrdwY7.	11223344	Alice	111111
159d06df-6e28-466e-86f2-32e8e0123a11	bob@test.com	{bcrypt}$2a$10$rtJkitEdg04cDvqEkCdNrucGWh0Bkoos0hNjKfnytBro7dtlE5wSW	22334411	Bob	111111
4319bab8-cd80-4150-80d3-c9ffab69a3cf	charlie@test.com	{bcrypt}$2a$10$pXUTp9XBjd.O14tqKzCUa.XxKEJYWmWn3WhawsIsfZ1ZIRoYRltKa	33441122	Charlie	111111
a9824b19-faaa-49a7-a61e-f09d1edb4d71	danny@test.com	{bcrypt}$2a$10$40NNDNbMzwfjgPRewewt3eZpPepBE6UWYU.EtVwRLI0UO47qG.xmq	44112233	Danny	111111
74117e3d-4e35-46e5-9011-18d789187c7c	emma@test.com	{bcrypt}$2a$10$DBw9BOFsROWi7m3K.8HZ0OwFFrG5md0CFdBeSCnW7BV6P6JAy1a82	55112233	Emma	111111
8a22c572-9ac2-420b-8983-554beda0a40e	greta@test.com	{bcrypt}$2a$10$zxBcrS0bgvnUB3dewsItzeqmnr5Ms.f0rk8yOLrFxFpJXHocb5HSO	66112233	Greta	111111
27abd09d-928e-4d6c-9a46-54e570e0f631	helena@test.com	{bcrypt}$2a$10$n5OwkyTe7OIXViBQ2ZPTTOEAFAbwYQLTHV5sKhDZJvsYbJq4mubxq	77112233	Helena	111111
ef5ae639-a74c-449f-baa7-8f71afc0e06f	validation@tester.com	{bcrypt}$2a$10$kTBrUIxBlaqdR58C25TzmuILqioU8P.AN5xK.JFOynY5blzHGGzC2	1234567890	Tester	string
\.


--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 210
-- Name: playground_equip_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.playground_equip_id_seq', 1, false);


--
-- TOC entry 3244 (class 2606 OID 17428)
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (booking_id);


--
-- TOC entry 3232 (class 2606 OID 17411)
-- Name: playground playground_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playground
    ADD CONSTRAINT playground_pkey PRIMARY KEY (equip_id);


--
-- TOC entry 3234 (class 2606 OID 17413)
-- Name: screen screen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen
    ADD CONSTRAINT screen_pkey PRIMARY KEY (screen_id);


--
-- TOC entry 3236 (class 2606 OID 17415)
-- Name: screen_show screen_show_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen_show
    ADD CONSTRAINT screen_show_pkey PRIMARY KEY (screen_show_id);


--
-- TOC entry 3238 (class 2606 OID 17417)
-- Name: show show_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.show
    ADD CONSTRAINT show_pkey PRIMARY KEY (show_id);


--
-- TOC entry 3240 (class 2606 OID 17419)
-- Name: theater theater_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.theater
    ADD CONSTRAINT theater_pkey PRIMARY KEY (theater_id);


--
-- TOC entry 3242 (class 2606 OID 17421)
-- Name: user_entity user_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT user_entity_pkey PRIMARY KEY (id);


-- Completed on 2023-01-16 20:51:56 IST

--
-- PostgreSQL database dump complete
--

