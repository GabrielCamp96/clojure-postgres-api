CREATE SEQUENCE public.teachers_id_seq;

ALTER SEQUENCE public.teachers_id_seq
    OWNER TO pguser;

CREATE TABLE public.teachers
(
    id integer NOT NULL DEFAULT nextval('teachers_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
	class character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT friends_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.teachers
    OWNER to pguser;