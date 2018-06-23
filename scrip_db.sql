--------------------------------------------------------
-- Archivo creado  - sábado-junio-23-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_EI
--------------------------------------------------------

   CREATE SEQUENCE  "UNI"."SEQ_EI"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 23 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_EI_DETALLE
--------------------------------------------------------

   CREATE SEQUENCE  "UNI"."SEQ_EI_DETALLE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 25 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_INVESTIGADOR
--------------------------------------------------------

   CREATE SEQUENCE  "UNI"."SEQ_INVESTIGADOR"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 12 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PARTIDA
--------------------------------------------------------

   CREATE SEQUENCE  "UNI"."SEQ_PARTIDA"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 9 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PROYECTO
--------------------------------------------------------

   CREATE SEQUENCE  "UNI"."SEQ_PROYECTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 9 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_USUARIO
--------------------------------------------------------

   CREATE SEQUENCE  "UNI"."SEQ_USUARIO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 13 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table EI_DETALLE
--------------------------------------------------------

  CREATE TABLE "UNI"."EI_DETALLE" 
   (	"ID_EI_DETALLE" NUMBER(*,0), 
	"ID_EI" NUMBER(*,0), 
	"ID_PARTIDA" NUMBER(*,0), 
	"IMPORTE" NUMBER(10,2), 
	"ESTADO" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ENCARGO_INTERNO
--------------------------------------------------------

  CREATE TABLE "UNI"."ENCARGO_INTERNO" 
   (	"ID_EI" NUMBER(*,0), 
	"ID_INV" NUMBER(*,0), 
	"ID_PROY" NUMBER(*,0), 
	"FECHA_INICIO" DATE, 
	"FECHA_FIN" DATE, 
	"CERTIFICADO" VARCHAR2(10 BYTE), 
	"EXP_OCEF" VARCHAR2(10 BYTE), 
	"EXP_SIAF" VARCHAR2(20 BYTE), 
	"IMPORTE_TOTAL" FLOAT(126), 
	"ESTADO" CHAR(1 BYTE), 
	"FECHA_RENDICION" DATE, 
	"EXP_OCEF_RENDICION" VARCHAR2(20 BYTE), 
	"IMPORTE_RENDICION" FLOAT(126), 
	"IMPORTE_DEVOLUCION" FLOAT(126), 
	"RESPONSABLE_RENDICION" VARCHAR2(500 BYTE), 
	"EXP_OCEF_DEVOLUCION" VARCHAR2(20 BYTE), 
	"TIPO_TRAMITE" VARCHAR2(300 BYTE), 
	"ESTADO_TRAMITE" VARCHAR2(300 BYTE), 
	"ID_OCEF" VARCHAR2(300 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table INVESTIGADOR
--------------------------------------------------------

  CREATE TABLE "UNI"."INVESTIGADOR" 
   (	"ID_INVESTIGADOR" NUMBER(*,0), 
	"DNI" VARCHAR2(20 BYTE), 
	"NOMBRE" VARCHAR2(200 BYTE), 
	"TELEFONO" VARCHAR2(150 BYTE), 
	"EMAIL" VARCHAR2(150 BYTE), 
	"COD_UNI" VARCHAR2(100 BYTE), 
	"ESTADO" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PARTIDA
--------------------------------------------------------

  CREATE TABLE "UNI"."PARTIDA" 
   (	"ID_PARTIDA" NUMBER(*,0), 
	"ESPECIFICA" VARCHAR2(50 BYTE), 
	"DETALLE" VARCHAR2(1000 BYTE), 
	"NOMBRE" VARCHAR2(500 BYTE), 
	"ESTADO" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROYECTO
--------------------------------------------------------

  CREATE TABLE "UNI"."PROYECTO" 
   (	"ID_PROYECTO" NUMBER(*,0), 
	"CODIGO_OCPLA" VARCHAR2(150 BYTE), 
	"CODIGO_OCEF" VARCHAR2(150 BYTE), 
	"NOMBRE" VARCHAR2(1000 BYTE), 
	"ESTADO" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "UNI"."USUARIO" 
   (	"ID" NUMBER(*,0), 
	"USUARIO" VARCHAR2(20 BYTE), 
	"CLAVE" VARCHAR2(60 BYTE), 
	"NOMBRE" VARCHAR2(120 BYTE), 
	"ESTADO" CHAR(1 BYTE), 
	"AUD_TIPO" CHAR(1 BYTE), 
	"AUD_IDUSUARIO" NUMBER(*,0), 
	"AUD_SESION" VARCHAR2(60 BYTE), 
	"AUD_FECHA" DATE, 
	"AUD_IP" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for View VIEW_EI
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "UNI"."VIEW_EI" ("ID_EI", "NOMBRE", "CODIGO_OCPLA", "FECHA_INICIO", "FECHA_FIN", "EXP_OCEF", "IMPORTE_TOTAL", "FECHA_RENDICION", "EXP_OCEF_RENDICION", "IMPORTE_RENDICION", "IMPORTE_DEVOLUCION", "ESTADO_TRAMITE", "TIPO_TRAMITE") AS 
  SELECT
        ei.id_ei,
        inv.nombre,
        proy.codigo_ocpla,
        ei.fecha_inicio,
        ei.fecha_fin,
        ei.exp_ocef,
        ei.importe_total,
        ei.fecha_rendicion,
        ei.exp_ocef_rendicion,
        ei.importe_rendicion,
        ei.importe_devolucion,
        ei.ESTADO_TRAMITE,
        ei.TIPO_TRAMITE
    FROM
        encargo_interno ei
        INNER JOIN investigador inv ON ( ei.id_inv = inv.id_investigador )
        INNER JOIN proyecto proy ON ( ei.id_proy = proy.id_proyecto )
    WHERE
        ei.estado = 1
;
--------------------------------------------------------
--  DDL for Package PKG_INVESTIGADOR
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "UNI"."PKG_INVESTIGADOR" AS 


  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_NOMBRE      IN  INVESTIGADOR.NOMBRE%TYPE
  );

  PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_COD_UNI	IN  INVESTIGADOR.COD_UNI%TYPE
  );


  PROCEDURE SP_INSERTAR
  (
      P_ID_INVESTIGADOR	OUT INVESTIGADOR.ID_INVESTIGADOR%TYPE,
      P_DNI		        IN  INVESTIGADOR.DNI%TYPE,
      P_NOMBRE		    IN  INVESTIGADOR.NOMBRE%TYPE,
      P_TELEFONO	    IN  INVESTIGADOR.TELEFONO%TYPE,
      P_EMAIL	    	IN  INVESTIGADOR.EMAIL%TYPE,
      P_COD_UNI		    IN  INVESTIGADOR.COD_UNI%TYPE
  );

  PROCEDURE SP_ACTUALIZAR
  (
      P_ID_INVESTIGADOR	IN  INVESTIGADOR.ID_INVESTIGADOR%TYPE,
      P_DNI		        IN  INVESTIGADOR.DNI%TYPE,
      P_NOMBRE	    	IN  INVESTIGADOR.NOMBRE%TYPE,
      P_TELEFONO    	IN  INVESTIGADOR.TELEFONO%TYPE,
      P_EMAIL	    	IN  INVESTIGADOR.EMAIL%TYPE,
      P_COD_UNI	    	IN  INVESTIGADOR.COD_UNI%TYPE
  );

    PROCEDURE SP_ELIMINAR
  (
      P_ID_INVESTIGADOR	IN  INVESTIGADOR.ID_INVESTIGADOR%TYPE
  );

END PKG_INVESTIGADOR;

/
--------------------------------------------------------
--  DDL for Package PKG_PARTIDA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "UNI"."PKG_PARTIDA" AS 


  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_NOMBRE      IN  PARTIDA.NOMBRE%TYPE
  );

  PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_ID_PARTIDA IN  PARTIDA.ID_PARTIDA%TYPE
  );


  PROCEDURE SP_INSERTAR
  (
      P_ID_PARTIDA OUT PARTIDA.ID_PARTIDA%TYPE,
      P_ESPECIFICA IN  PARTIDA.ESPECIFICA%TYPE,
      P_DETALLE IN  PARTIDA.DETALLE%TYPE,
      P_NOMBRE IN  PARTIDA.NOMBRE%TYPE
  );

  PROCEDURE SP_ACTUALIZAR
  (
      P_ID_PARTIDA IN PARTIDA.ID_PARTIDA%TYPE,
      P_ESPECIFICA IN  PARTIDA.ESPECIFICA%TYPE,
      P_DETALLE IN  PARTIDA.DETALLE%TYPE,
      P_NOMBRE IN  PARTIDA.NOMBRE%TYPE
  );

    PROCEDURE SP_ELIMINAR
  (
      P_ID_PARTIDA IN  PARTIDA.ID_PARTIDA%TYPE
  );

END PKG_PARTIDA;

/
--------------------------------------------------------
--  DDL for Package PKG_PROYECTO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "UNI"."PKG_PROYECTO" AS 


  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_CODIGO_OCPLA      IN  PROYECTO.CODIGO_OCPLA%TYPE
  );

  PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_ID_PROYECTO IN  PROYECTO.ID_PROYECTO%TYPE
  );


  PROCEDURE SP_INSERTAR
  (
      P_ID_PROYECTO OUT PROYECTO.ID_PROYECTO%TYPE,
      P_CODIGO_OCPLA IN  PROYECTO.CODIGO_OCPLA%TYPE,
      P_CODIGO_OCEF IN  PROYECTO.CODIGO_OCEF%TYPE,
      P_NOMBRE IN  PROYECTO.NOMBRE%TYPE
  );

  PROCEDURE SP_ACTUALIZAR
  (
     P_ID_PROYECTO IN PROYECTO.ID_PROYECTO%TYPE,
      P_CODIGO_OCPLA IN  PROYECTO.CODIGO_OCPLA%TYPE,
      P_CODIGO_OCEF IN  PROYECTO.CODIGO_OCEF%TYPE,
      P_NOMBRE IN  PROYECTO.NOMBRE%TYPE
  );

    PROCEDURE SP_ELIMINAR
  (
      P_ID_PROYECTO IN  PROYECTO.ID_PROYECTO%TYPE
  );

END PKG_PROYECTO;

/
--------------------------------------------------------
--  DDL for Package PKG_TRAMITE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "UNI"."PKG_TRAMITE" AS
    PROCEDURE sp_buscar_x_criterios (
        p_c_cursor       OUT SYS_REFCURSOR,
        p_codigo_ocpla   IN proyecto.codigo_ocpla%TYPE
    );

    PROCEDURE sp_buscar (
        p_cursor OUT SYS_REFCURSOR
    );

    PROCEDURE sp_buscar_x_id (
        p_cursor   OUT SYS_REFCURSOR,
        p_id_ei    IN encargo_interno.id_ei%TYPE
    );

    PROCEDURE sp_eliminar (
        p_id_ei   IN encargo_interno.id_ei%TYPE
    );

    PROCEDURE sp_actualizar (
        p_id_ei                   IN encargo_interno.id_ei%TYPE,
        p_id_inv                  IN encargo_interno.id_inv%TYPE,
        p_id_proy                 IN encargo_interno.id_proy%TYPE,
        p_fecha_inicio            IN encargo_interno.fecha_inicio%TYPE,
        p_fecha_fin               IN encargo_interno.fecha_fin%TYPE,
        p_certificado             IN encargo_interno.certificado%TYPE,
        p_exp_ocef                IN encargo_interno.exp_ocef%TYPE,
        p_exp_siaf                IN encargo_interno.exp_siaf%TYPE,
        p_importe                 IN encargo_interno.importe_total%TYPE,
        p_fecha_rendicion         IN encargo_interno.fecha_rendicion%TYPE,
        p_exp_ocef_rendicion      IN encargo_interno.exp_ocef_rendicion%TYPE,
        p_importe_rendicion       IN encargo_interno.importe_rendicion%TYPE,
        p_importe_devolucion      IN encargo_interno.importe_devolucion%TYPE,
        p_responsable_rendicion   IN encargo_interno.responsable_rendicion%TYPE,
        p_exp_ocef_devolucion     IN encargo_interno.exp_ocef_devolucion%TYPE,
        p_tipo_tramite            IN encargo_interno.tipo_tramite%TYPE,
        p_estado_tramite          IN encargo_interno.estado_tramite%TYPE,
        p_id_ocef                 IN encargo_interno.id_ocef%TYPE
    );

    PROCEDURE sp_insertar_detalle (
        p_id_ei_detalle   OUT ei_detalle.id_ei_detalle%TYPE,
        p_id_ei           IN ei_detalle.id_ei%TYPE,
        p_id_partida      IN ei_detalle.id_partida%TYPE,
        p_importe         IN ei_detalle.importe%TYPE
    );

    PROCEDURE sp_eliminar_detalle (
        p_id_ei_detalle   IN ei_detalle.id_ei_detalle%TYPE
    );

    PROCEDURE sp_actualizar_detalle (
        p_id_ei_detalle   IN ei_detalle.id_ei_detalle%TYPE,
        p_id_ei           IN ei_detalle.id_ei%TYPE,
        p_id_partida      IN ei_detalle.id_partida%TYPE,
        p_importe         IN ei_detalle.importe%TYPE
    );

    PROCEDURE sp_insertar (
        p_id_ei                   OUT encargo_interno.id_ei%TYPE,
        p_id_inv                  IN encargo_interno.id_inv%TYPE,
        p_id_proy                 IN encargo_interno.id_proy%TYPE,
        p_fecha_inicio            IN encargo_interno.fecha_inicio%TYPE,
        p_fecha_fin               IN encargo_interno.fecha_fin%TYPE,
        p_certificado             IN encargo_interno.certificado%TYPE,
        p_exp_ocef                IN encargo_interno.exp_ocef%TYPE,
        p_exp_siaf                IN encargo_interno.exp_siaf%TYPE,
        p_importe                 IN encargo_interno.importe_total%TYPE,
        p_fecha_rendicion         IN encargo_interno.fecha_rendicion%TYPE,
        p_exp_ocef_rendicion      IN encargo_interno.exp_ocef_rendicion%TYPE,
        p_importe_rendicion       IN encargo_interno.importe_rendicion%TYPE,
        p_importe_devolucion      IN encargo_interno.importe_devolucion%TYPE,
        p_responsable_rendicion   IN encargo_interno.responsable_rendicion%TYPE,
        p_exp_ocef_devolucion     IN encargo_interno.exp_ocef_devolucion%TYPE,
        p_tipo_tramite            IN encargo_interno.tipo_tramite%TYPE,
        p_estado_tramite          IN encargo_interno.estado_tramite%TYPE,
        p_id_ocef                 IN encargo_interno.id_ocef%TYPE
    );

END pkg_tramite;

/
--------------------------------------------------------
--  DDL for Package PKG_USUARIO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "UNI"."PKG_USUARIO" AS 

  PROCEDURE SP_VALIDAR_ACCESO
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_USUARIO     IN  USUARIO.USUARIO%TYPE,
      P_CLAVE       IN  USUARIO.CLAVE%TYPE 
  );

  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_NOMBRE      IN  USUARIO.NOMBRE%TYPE
  );

  PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_ID          IN  USUARIO.ID%TYPE
  );


  PROCEDURE SP_INSERTAR
  (
      P_ID          OUT USUARIO.ID%TYPE,
      P_USUARIO     IN  USUARIO.USUARIO%TYPE,
      P_CLAVE       IN  USUARIO.CLAVE%TYPE,
      P_NOMBRE      IN  USUARIO.NOMBRE%TYPE
  );

  PROCEDURE SP_ACTUALIZAR
  (
      P_ID          IN  USUARIO.ID%TYPE,
      P_USUARIO     IN  USUARIO.USUARIO%TYPE,
      P_CLAVE       IN  USUARIO.CLAVE%TYPE,
      P_NOMBRE      IN  USUARIO.NOMBRE%TYPE
  );

    PROCEDURE SP_ELIMINAR
  (
      P_ID          IN  USUARIO.ID%TYPE
  );

END PKG_USUARIO;


/
--------------------------------------------------------
--  DDL for Package Body PKG_INVESTIGADOR
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "UNI"."PKG_INVESTIGADOR" AS

  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_NOMBRE      IN  INVESTIGADOR.NOMBRE%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID_INVESTIGADOR,
              DNI,
              NOMBRE,
              TELEFONO,
              EMAIL,
              COD_UNI
          FROM
              INVESTIGADOR
          WHERE
                  UPPER(NOMBRE)    LIKE '%'||UPPER(P_NOMBRE)||'%'
              AND ESTADO            =   '1';

  END SP_BUSCAR_X_CRITERIOS;

  PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_COD_UNI	IN  INVESTIGADOR.COD_UNI%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID_INVESTIGADOR,
              DNI,
              NOMBRE,
              TELEFONO,
              EMAIL,
              COD_UNI
          FROM
              INVESTIGADOR
          WHERE
              COD_UNI   = P_COD_UNI
              AND ESTADO    = '1';

  END SP_BUSCAR_X_ID;


  PROCEDURE SP_INSERTAR
  (
      P_ID_INVESTIGADOR	OUT INVESTIGADOR.ID_INVESTIGADOR%TYPE,
      P_DNI		IN  INVESTIGADOR.DNI%TYPE,
      P_NOMBRE		IN  INVESTIGADOR.NOMBRE%TYPE,
      P_TELEFONO	IN  INVESTIGADOR.TELEFONO%TYPE,
      P_EMAIL		IN  INVESTIGADOR.EMAIL%TYPE,
      P_COD_UNI		IN  INVESTIGADOR.COD_UNI%TYPE
  )AS
  BEGIN
      SELECT
          SEQ_INVESTIGADOR.NEXTVAL
      INTO
          P_ID_INVESTIGADOR	
      FROM
          DUAL;
      INSERT INTO INVESTIGADOR
      (
          ID_INVESTIGADOR,
          DNI,
          NOMBRE,
	      TELEFONO,
		  EMAIL,
		  COD_UNI,
		  ESTADO
      )
      VALUES
      (
          P_ID_INVESTIGADOR,
          P_DNI,
          P_NOMBRE,
          P_TELEFONO,
          P_EMAIL,
          P_COD_UNI,	
          '1'   
      );

  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR
  (
      P_ID_INVESTIGADOR	IN  INVESTIGADOR.ID_INVESTIGADOR%TYPE,
      P_DNI		        IN  INVESTIGADOR.DNI%TYPE,
      P_NOMBRE	    	IN  INVESTIGADOR.NOMBRE%TYPE,
      P_TELEFONO    	IN  INVESTIGADOR.TELEFONO%TYPE,
      P_EMAIL	    	IN  INVESTIGADOR.EMAIL%TYPE,
      P_COD_UNI	    	IN  INVESTIGADOR.COD_UNI%TYPE
  )AS
  BEGIN
    UPDATE 
        INVESTIGADOR
    SET
        DNI   =  P_DNI,
        NOMBRE =  P_NOMBRE,
        TELEFONO=  P_TELEFONO,
        EMAIL= P_EMAIL,
        COD_UNI= P_COD_UNI
    WHERE
        ID_INVESTIGADOR	=  P_ID_INVESTIGADOR;

  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR
  (
      P_ID_INVESTIGADOR	IN  INVESTIGADOR.ID_INVESTIGADOR%TYPE
  )IS
  BEGIN
    UPDATE 
        INVESTIGADOR
    SET
        ESTADO   =  0
    WHERE
        ID_INVESTIGADOR =  P_ID_INVESTIGADOR;

  END SP_ELIMINAR;

END PKG_INVESTIGADOR;

/
--------------------------------------------------------
--  DDL for Package Body PKG_PARTIDA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "UNI"."PKG_PARTIDA" AS

  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_NOMBRE      IN  PARTIDA.NOMBRE%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID_PARTIDA,
              ESPECIFICA,
              DETALLE,
              NOMBRE
          FROM
              PARTIDA
          WHERE
                  UPPER(NOMBRE)    LIKE '%'||UPPER(P_NOMBRE)||'%'
              AND ESTADO            =   '1';

  END SP_BUSCAR_X_CRITERIOS;

  PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_ID_PARTIDA IN  PARTIDA.ID_PARTIDA%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID_PARTIDA,
              ESPECIFICA,
              DETALLE,
              NOMBRE
          FROM
              PARTIDA
          WHERE
              ID_PARTIDA = P_ID_PARTIDA 
              AND ESTADO    = '1';

  END SP_BUSCAR_X_ID;


  PROCEDURE SP_INSERTAR
  (
      P_ID_PARTIDA OUT PARTIDA.ID_PARTIDA%TYPE,
      P_ESPECIFICA IN  PARTIDA.ESPECIFICA%TYPE,
      P_DETALLE IN  PARTIDA.DETALLE%TYPE,
      P_NOMBRE IN  PARTIDA.NOMBRE%TYPE
  )AS
  BEGIN
      SELECT
          SEQ_PARTIDA.NEXTVAL
      INTO
          P_ID_PARTIDA 
      FROM
          DUAL;
      INSERT INTO PARTIDA
      (
              ID_PARTIDA,
              ESPECIFICA,
              DETALLE,
              NOMBRE,
	      ESTADO
      )
      VALUES
      (
      P_ID_PARTIDA, 
      P_ESPECIFICA, 
      P_DETALLE, 
      P_NOMBRE, 
          '1'   
      );

  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR
  (
      P_ID_PARTIDA IN PARTIDA.ID_PARTIDA%TYPE,
      P_ESPECIFICA IN  PARTIDA.ESPECIFICA%TYPE,
      P_DETALLE IN  PARTIDA.DETALLE%TYPE,
      P_NOMBRE IN  PARTIDA.NOMBRE%TYPE
  )AS
  BEGIN
    UPDATE
        PARTIDA
    SET
              ID_PARTIDA = P_ID_PARTIDA, 
              ESPECIFICA = P_ESPECIFICA, 
              DETALLE = P_DETALLE, 
              NOMBRE = P_NOMBRE
    WHERE
        ID_PARTIDA =  P_ID_PARTIDA;

  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR
  (
      P_ID_PARTIDA IN  PARTIDA.ID_PARTIDA%TYPE
  )AS
  BEGIN
    UPDATE 
        PARTIDA
    SET
        ESTADO   =  0
    WHERE
        ID_PARTIDA =  P_ID_PARTIDA;

  END SP_ELIMINAR;

END PKG_PARTIDA;

/
--------------------------------------------------------
--  DDL for Package Body PKG_PROYECTO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "UNI"."PKG_PROYECTO" AS

  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_CODIGO_OCPLA      IN  PROYECTO.CODIGO_OCPLA%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID_PROYECTO,
              CODIGO_OCPLA,
              CODIGO_OCEF,
              NOMBRE
          FROM
              PROYECTO
          WHERE
                  UPPER(CODIGO_OCPLA)    LIKE '%'||UPPER(P_CODIGO_OCPLA)||'%'
              AND ESTADO            =   '1';

  END SP_BUSCAR_X_CRITERIOS;

  PROCEDURE SP_BUSCAR_X_ID
  (
     P_CURSOR      OUT SYS_REFCURSOR,
      P_ID_PROYECTO IN  PROYECTO.ID_PROYECTO%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID_PROYECTO,
               CODIGO_OCPLA,
              CODIGO_OCEF,
              NOMBRE
          FROM
              PROYECTO
          WHERE
              ID_PROYECTO = P_ID_PROYECTO 
              AND ESTADO    = '1';

  END SP_BUSCAR_X_ID;


  PROCEDURE SP_INSERTAR
  (
      P_ID_PROYECTO OUT PROYECTO.ID_PROYECTO%TYPE,
      P_CODIGO_OCPLA IN  PROYECTO.CODIGO_OCPLA%TYPE,
      P_CODIGO_OCEF IN  PROYECTO.CODIGO_OCEF%TYPE,
      P_NOMBRE IN  PROYECTO.NOMBRE%TYPE
  )AS
  BEGIN
      SELECT
          SEQ_PROYECTO.NEXTVAL
      INTO
          P_ID_PROYECTO 
      FROM
          DUAL;
      INSERT INTO PROYECTO
      (
              ID_PROYECTO,
              CODIGO_OCPLA,
              CODIGO_OCEF,
              NOMBRE,
		ESTADO
      )
      VALUES
      (
      P_ID_PROYECTO, 
      P_CODIGO_OCPLA, 
      P_CODIGO_OCEF, 
      P_NOMBRE, 
          '1'   
      );

  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR
  (
     P_ID_PROYECTO IN PROYECTO.ID_PROYECTO%TYPE,
      P_CODIGO_OCPLA IN  PROYECTO.CODIGO_OCPLA%TYPE,
      P_CODIGO_OCEF IN  PROYECTO.CODIGO_OCEF%TYPE,
      P_NOMBRE IN  PROYECTO.NOMBRE%TYPE
  )AS
  BEGIN
    UPDATE
        PROYECTO
    SET
              ID_PROYECTO = P_ID_PROYECTO, 
              CODIGO_OCPLA = P_CODIGO_OCPLA, 
              CODIGO_OCEF = P_CODIGO_OCEF, 
              NOMBRE = P_NOMBRE
    WHERE
        ID_PROYECTO =  P_ID_PROYECTO;

  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR
  (
      P_ID_PROYECTO IN  PROYECTO.ID_PROYECTO%TYPE
  )AS
  BEGIN
    UPDATE 
        PROYECTO
    SET
        ESTADO   =  0
    WHERE
        ID_PROYECTO =  P_ID_PROYECTO;

  END SP_ELIMINAR;

END PKG_PROYECTO;

/
--------------------------------------------------------
--  DDL for Package Body PKG_TRAMITE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "UNI"."PKG_TRAMITE" AS

    PROCEDURE sp_buscar (
        p_cursor OUT SYS_REFCURSOR
    )
        AS
    BEGIN
        OPEN p_cursor FOR SELECT
            id_ei,
            id_inv,
            id_proy,
            fecha_inicio,
            fecha_fin,
            certificado,
            exp_ocef,
            exp_siaf,
            importe_total,
            fecha_rendicion,
            exp_ocef_rendicion,
            importe_rendicion,
            importe_devolucion,
            responsable_rendicion,
            exp_ocef_devolucion,
            tipo_tramite,
            estado_tramite,
            id_ocef
                          FROM
            encargo_interno
                          WHERE
            estado = '1';

    END sp_buscar;

    PROCEDURE sp_insertar (
        p_id_ei                   OUT encargo_interno.id_ei%TYPE,
        p_id_inv                  IN encargo_interno.id_inv%TYPE,
        p_id_proy                 IN encargo_interno.id_proy%TYPE,
        p_fecha_inicio            IN encargo_interno.fecha_inicio%TYPE,
        p_fecha_fin               IN encargo_interno.fecha_fin%TYPE,
        p_certificado             IN encargo_interno.certificado%TYPE,
        p_exp_ocef                IN encargo_interno.exp_ocef%TYPE,
        p_exp_siaf                IN encargo_interno.exp_siaf%TYPE,
        p_importe                 IN encargo_interno.importe_total%TYPE,
        p_fecha_rendicion         IN encargo_interno.fecha_rendicion%TYPE,
        p_exp_ocef_rendicion      IN encargo_interno.exp_ocef_rendicion%TYPE,
        p_importe_rendicion       IN encargo_interno.importe_rendicion%TYPE,
        p_importe_devolucion      IN encargo_interno.importe_devolucion%TYPE,
        p_responsable_rendicion   IN encargo_interno.responsable_rendicion%TYPE,
        p_exp_ocef_devolucion     IN encargo_interno.exp_ocef_devolucion%TYPE,
        p_tipo_tramite            IN encargo_interno.tipo_tramite%TYPE,
        p_estado_tramite          IN encargo_interno.estado_tramite%TYPE,
        p_id_ocef                 IN encargo_interno.id_ocef%TYPE
    )
        AS
    BEGIN
        SELECT
            seq_ei.NEXTVAL
        INTO
            p_id_ei
        FROM
            dual;

        INSERT INTO encargo_interno (
            id_ei,
            id_inv,
            id_proy,
            fecha_inicio,
            fecha_fin,
            certificado,
            exp_ocef,
            exp_siaf,
            importe_total,
            fecha_rendicion,
            exp_ocef_rendicion,
            importe_rendicion,
            importe_devolucion,
            responsable_rendicion,
            exp_ocef_devolucion,
            estado_tramite,
            tipo_tramite,
            id_ocef,
            estado
        ) VALUES (
            p_id_ei,
            p_id_inv,
            p_id_proy,
            p_fecha_inicio,
            p_fecha_fin,
            p_certificado,
            p_exp_ocef,
            p_exp_siaf,
            p_importe,
            p_fecha_rendicion,
            p_exp_ocef_rendicion,
            p_importe_rendicion,
            p_importe_devolucion,
            p_responsable_rendicion,
            p_exp_ocef_devolucion,
            p_estado_tramite,
            p_tipo_tramite,
            p_id_ocef,
            '1'
        );

    END sp_insertar;

    PROCEDURE sp_insertar_detalle (
        p_id_ei_detalle   OUT ei_detalle.id_ei_detalle%TYPE,
        p_id_ei           IN ei_detalle.id_ei%TYPE,
        p_id_partida      IN ei_detalle.id_partida%TYPE,
        p_importe         IN ei_detalle.importe%TYPE
    )
        AS
    BEGIN
        SELECT
            seq_ei_detalle.NEXTVAL
        INTO
            p_id_ei_detalle
        FROM
            dual;

        INSERT INTO ei_detalle (
            id_ei_detalle,
            id_ei,
            id_partida,
            importe,
            estado
        ) VALUES (
            p_id_ei_detalle,
            p_id_ei,
            p_id_partida,
            p_importe,
            '1'
        );

    END sp_insertar_detalle;

    PROCEDURE sp_eliminar_detalle (
        p_id_ei_detalle   IN ei_detalle.id_ei_detalle%TYPE
    )
        AS
    BEGIN
        UPDATE ei_detalle
            SET
                estado = 0
        WHERE
            id_ei_detalle = p_id_ei_detalle;

    END sp_eliminar_detalle;

    PROCEDURE sp_actualizar_detalle (
        p_id_ei_detalle   IN ei_detalle.id_ei_detalle%TYPE,
        p_id_ei           IN ei_detalle.id_ei%TYPE,
        p_id_partida      IN ei_detalle.id_partida%TYPE,
        p_importe         IN ei_detalle.importe%TYPE
    )
        AS
    BEGIN
        UPDATE ei_detalle
            SET
                id_ei_detalle = p_id_ei_detalle,
                id_ei = p_id_ei,
                id_partida = p_id_partida,
                importe = p_importe
        WHERE
            id_ei_detalle = p_id_ei_detalle;

    END sp_actualizar_detalle;

    PROCEDURE sp_eliminar (
        p_id_ei   IN encargo_interno.id_ei%TYPE
    )
        AS
    BEGIN
        UPDATE encargo_interno
            SET
                estado = 0
        WHERE
            id_ei = p_id_ei;

    END sp_eliminar;

    PROCEDURE sp_actualizar (
        p_id_ei                   IN encargo_interno.id_ei%TYPE,
        p_id_inv                  IN encargo_interno.id_inv%TYPE,
        p_id_proy                 IN encargo_interno.id_proy%TYPE,
        p_fecha_inicio            IN encargo_interno.fecha_inicio%TYPE,
        p_fecha_fin               IN encargo_interno.fecha_fin%TYPE,
        p_certificado             IN encargo_interno.certificado%TYPE,
        p_exp_ocef                IN encargo_interno.exp_ocef%TYPE,
        p_exp_siaf                IN encargo_interno.exp_siaf%TYPE,
        p_importe                 IN encargo_interno.importe_total%TYPE,
        p_fecha_rendicion         IN encargo_interno.fecha_rendicion%TYPE,
        p_exp_ocef_rendicion      IN encargo_interno.exp_ocef_rendicion%TYPE,
        p_importe_rendicion       IN encargo_interno.importe_rendicion%TYPE,
        p_importe_devolucion      IN encargo_interno.importe_devolucion%TYPE,
        p_responsable_rendicion   IN encargo_interno.responsable_rendicion%TYPE,
        p_exp_ocef_devolucion     IN encargo_interno.exp_ocef_devolucion%TYPE,
        p_tipo_tramite            IN encargo_interno.tipo_tramite%TYPE,
        p_estado_tramite          IN encargo_interno.estado_tramite%TYPE,
        p_id_ocef                 IN encargo_interno.id_ocef%TYPE
    )
        AS
    BEGIN
        UPDATE encargo_interno
            SET
                id_inv = p_id_inv,
                id_proy = p_id_proy,
                fecha_inicio = p_fecha_inicio,
                fecha_fin = p_fecha_fin,
                certificado = p_certificado,
                exp_ocef = p_exp_ocef,
                exp_siaf = p_exp_siaf,
                importe_total = p_importe,
                fecha_rendicion = p_fecha_rendicion,
                exp_ocef_rendicion = p_exp_ocef_rendicion,
                importe_rendicion = p_importe_rendicion,
                importe_devolucion = p_importe_devolucion,
                responsable_rendicion = p_responsable_rendicion,
                exp_ocef_devolucion = p_exp_ocef_devolucion,
                tipo_tramite = p_tipo_tramite,
                estado_tramite = p_estado_tramite,
                id_ocef = p_id_ocef
        WHERE
            id_ei = p_id_ei;

    END sp_actualizar;

    PROCEDURE sp_buscar_x_id (
        p_cursor   OUT SYS_REFCURSOR,
        p_id_ei    IN encargo_interno.id_ei%TYPE
    )
        AS
    BEGIN
        OPEN p_cursor FOR SELECT
            id_ei,
            id_inv,
            id_proy,
            fecha_inicio,
            fecha_fin,
            certificado,
            exp_ocef,
            exp_siaf,
            importe_total,
            fecha_rendicion,
            exp_ocef_rendicion,
            importe_rendicion,
            importe_devolucion,
            responsable_rendicion,
            exp_ocef_devolucion,
            tipo_tramite,
            estado_tramite,
            id_ocef
                          FROM
            encargo_interno
                          WHERE
            id_ei = p_id_ei
            AND   estado = '1';

    END sp_buscar_x_id;

    PROCEDURE sp_buscar_x_criterios (
        p_c_cursor       OUT SYS_REFCURSOR,
        p_codigo_ocpla   IN proyecto.codigo_ocpla%TYPE
    )
        AS
    BEGIN
        OPEN p_c_cursor FOR SELECT
            id_ei,
            nombre,
            codigo_ocpla,
            fecha_inicio,
            fecha_fin,
            exp_ocef,
            importe_total,
            fecha_rendicion,
            exp_ocef_rendicion,
            importe_rendicion,
            importe_devolucion,
            tipo_tramite,
            estado_tramite
                            FROM
            view_ei
                            WHERE
            upper(codigo_ocpla) LIKE '%'
            || upper(p_codigo_ocpla)
            || '%';

    END sp_buscar_x_criterios;

END pkg_tramite;

/
--------------------------------------------------------
--  DDL for Package Body PKG_USUARIO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "UNI"."PKG_USUARIO" AS

  PROCEDURE SP_VALIDAR_ACCESO
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_USUARIO     IN  USUARIO.USUARIO%TYPE,
      P_CLAVE       IN  USUARIO.CLAVE%TYPE 
  ) AS
  BEGIN
    OPEN P_CURSOR
        FOR 
          SELECT
              ID,
              USUARIO,
              CLAVE,
              NOMBRE
          FROM
              USUARIO
          WHERE
                  USUARIO   = P_USUARIO
              AND CLAVE     = P_CLAVE
              AND ESTADO    = '1';

  END SP_VALIDAR_ACCESO;


  PROCEDURE SP_BUSCAR_X_CRITERIOS
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_NOMBRE      IN  USUARIO.NOMBRE%TYPE
  )AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID,
              USUARIO,
              CLAVE,
              NOMBRE
          FROM
              USUARIO
          WHERE
                  UPPER(NOMBRE)    LIKE '%'||UPPER(P_NOMBRE)||'%'
              AND ESTADO            =   '1';

  END SP_BUSCAR_X_CRITERIOS;

    PROCEDURE SP_BUSCAR_X_ID
  (
      P_CURSOR      OUT SYS_REFCURSOR,
      P_ID          IN  USUARIO.ID%TYPE
  )
  AS
  BEGIN
   OPEN P_CURSOR
        FOR 
          SELECT
              ID,
              USUARIO,
              CLAVE,
              NOMBRE
          FROM
              USUARIO
          WHERE
                  ID        = P_ID
              AND ESTADO    = '1';

  END SP_BUSCAR_X_ID;


  PROCEDURE SP_INSERTAR
  (
      P_ID          OUT USUARIO.ID%TYPE,
      P_USUARIO     IN  USUARIO.USUARIO%TYPE,
      P_CLAVE       IN  USUARIO.CLAVE%TYPE,
      P_NOMBRE      IN  USUARIO.NOMBRE%TYPE
  )AS
  BEGIN
      SELECT
          SEQ_USUARIO.NEXTVAL
      INTO
          P_ID
      FROM
          DUAL;
      INSERT INTO USUARIO
      (
          ID,
          USUARIO,
          CLAVE,
          NOMBRE,
          ESTADO
      )
      VALUES
      (
          P_ID,
          P_USUARIO,
          P_CLAVE,
          P_NOMBRE,
          '1'   
      );

  END SP_INSERTAR;


    PROCEDURE SP_ACTUALIZAR
  (
      P_ID          IN  USUARIO.ID%TYPE,
      P_USUARIO     IN  USUARIO.USUARIO%TYPE,
      P_CLAVE       IN  USUARIO.CLAVE%TYPE,
      P_NOMBRE      IN  USUARIO.NOMBRE%TYPE
  )IS
  BEGIN
    UPDATE 
        USUARIO
    SET
        USUARIO   =  P_USUARIO,
        CLAVE     =  P_CLAVE,
        NOMBRE    =  P_NOMBRE
    WHERE
        ID        =  P_ID;   

  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR
  (
      P_ID          IN  USUARIO.ID%TYPE
  )IS
  BEGIN
    UPDATE 
        USUARIO
    SET
        ESTADO   =  0
    WHERE
        ID        =  P_ID;   

  END SP_ELIMINAR;

END PKG_USUARIO;

/
--------------------------------------------------------
--  Constraints for Table ENCARGO_INTERNO
--------------------------------------------------------

  ALTER TABLE "UNI"."ENCARGO_INTERNO" MODIFY ("ID_PROY" NOT NULL ENABLE);
  ALTER TABLE "UNI"."ENCARGO_INTERNO" MODIFY ("ID_INV" NOT NULL ENABLE);
  ALTER TABLE "UNI"."ENCARGO_INTERNO" ADD UNIQUE ("EXP_SIAF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."ENCARGO_INTERNO" ADD UNIQUE ("EXP_OCEF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."ENCARGO_INTERNO" ADD UNIQUE ("CERTIFICADO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."ENCARGO_INTERNO" ADD PRIMARY KEY ("ID_EI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."ENCARGO_INTERNO" MODIFY ("ID_EI" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROYECTO
--------------------------------------------------------

  ALTER TABLE "UNI"."PROYECTO" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PROYECTO" ADD UNIQUE ("CODIGO_OCPLA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."PROYECTO" ADD PRIMARY KEY ("ID_PROYECTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."PROYECTO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PROYECTO" MODIFY ("CODIGO_OCEF" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PROYECTO" MODIFY ("CODIGO_OCPLA" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PROYECTO" MODIFY ("ID_PROYECTO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "UNI"."USUARIO" ADD UNIQUE ("USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."USUARIO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."USUARIO" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."USUARIO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."USUARIO" MODIFY ("CLAVE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."USUARIO" MODIFY ("USUARIO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."USUARIO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EI_DETALLE
--------------------------------------------------------

  ALTER TABLE "UNI"."EI_DETALLE" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."EI_DETALLE" MODIFY ("ID_PARTIDA" NOT NULL ENABLE);
  ALTER TABLE "UNI"."EI_DETALLE" MODIFY ("ID_EI" NOT NULL ENABLE);
  ALTER TABLE "UNI"."EI_DETALLE" ADD PRIMARY KEY ("ID_EI_DETALLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."EI_DETALLE" MODIFY ("IMPORTE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."EI_DETALLE" MODIFY ("ID_EI_DETALLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PARTIDA
--------------------------------------------------------

  ALTER TABLE "UNI"."PARTIDA" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PARTIDA" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PARTIDA" ADD UNIQUE ("ESPECIFICA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."PARTIDA" ADD PRIMARY KEY ("ID_PARTIDA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."PARTIDA" MODIFY ("DETALLE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PARTIDA" MODIFY ("ESPECIFICA" NOT NULL ENABLE);
  ALTER TABLE "UNI"."PARTIDA" MODIFY ("ID_PARTIDA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table INVESTIGADOR
--------------------------------------------------------

  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("ESTADO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("COD_UNI" NOT NULL ENABLE);
  ALTER TABLE "UNI"."INVESTIGADOR" ADD UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."INVESTIGADOR" ADD UNIQUE ("DNI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."INVESTIGADOR" ADD PRIMARY KEY ("ID_INVESTIGADOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("TELEFONO" NOT NULL ENABLE);
  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("DNI" NOT NULL ENABLE);
  ALTER TABLE "UNI"."INVESTIGADOR" MODIFY ("ID_INVESTIGADOR" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table EI_DETALLE
--------------------------------------------------------

  ALTER TABLE "UNI"."EI_DETALLE" ADD FOREIGN KEY ("ID_EI")
	  REFERENCES "UNI"."ENCARGO_INTERNO" ("ID_EI") ENABLE;
  ALTER TABLE "UNI"."EI_DETALLE" ADD FOREIGN KEY ("ID_PARTIDA")
	  REFERENCES "UNI"."PARTIDA" ("ID_PARTIDA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ENCARGO_INTERNO
--------------------------------------------------------

  ALTER TABLE "UNI"."ENCARGO_INTERNO" ADD FOREIGN KEY ("ID_INV")
	  REFERENCES "UNI"."INVESTIGADOR" ("ID_INVESTIGADOR") ENABLE;
  ALTER TABLE "UNI"."ENCARGO_INTERNO" ADD FOREIGN KEY ("ID_PROY")
	  REFERENCES "UNI"."PROYECTO" ("ID_PROYECTO") ENABLE;
