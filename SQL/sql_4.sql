CREATE SEQUENCE command_sequence INCREMENT 1 CYCLE;

CREATE TABLE commands
(
	commandid integer NOT NULL,
	name character varying(100),
	extension character varying(10),
	command character varying(250),
	description character varying(250),
	active Boolean DEFAULT NULL,
	CONSTRAINT command_pkey PRIMARY KEY (commandid)
);