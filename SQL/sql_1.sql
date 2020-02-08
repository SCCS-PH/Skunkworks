CREATE SEQUENCE registration_sequence INCREMENT 1 CYCLE;
CREATE SEQUENCE machine_sequence INCREMENT 1 CYCLE;
CREATE SEQUENCE person_sequence INCREMENT 1 CYCLE;


CREATE TABLE persons
(
	personid integer NOT NULL,
	name character varying(75),
	phonenumber character varying(50),
	email character varying(50),
	location character varying(50),
	CONSTRAINT person_pkey PRIMARY KEY (personid)
);

CREATE TABLE machines
(
	machineid integer NOT NULL,
	osversion character varying(50),
	javaversion character varying(50),
	profilename character varying(50),
	computername character varying(50),
	harddisk character varying(250),
	motherboard character varying(250),
	CONSTRAINT machine_pkey PRIMARY KEY (machineid)
);


 
 CREATE TABLE registrations
(
	registrationid integer NOT NULL,
	personid integer NOT NULL,
	machineid integer NOT NULL,
	registrationdate DATE,
	expirationdate DATE,
	lastlogin DATE,
	skunkwork Boolean DEFAULT FALSE,
	active Boolean DEFAULT NULL,
	CONSTRAINT registration_pkey PRIMARY KEY (registrationid),
	CONSTRAINT fk_person FOREIGN KEY (personid)
		REFERENCES persons (personid) MATCH SIMPLE
		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT fk_machine FOREIGN KEY (machineid)
		REFERENCES machines (machineid) MATCH SIMPLE
		ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE OR REPLACE FUNCTION delete_table() RETURNS trigger AS
$SCRIPT$
BEGIN

DELETE FROM machines where machineid = OLD.machineid;
DELETE FROM persons where personid = OLD.personid;
return new;
END
$SCRIPT$
LANGUAGE 'plpgsql' VOLATILE;

CREATE TRIGGER trig_delete_table
AFTER DELETE ON "registrations"
FOR EACH ROW
EXECUTE PROCEDURE delete_table();