#===========================================================================================
CREATE OR REPLACE PROCEDURE sp_regions_insert
  (  p_region_id     OUT       regions.region_id%type
   , p_region_name   IN      regions.region_name%type
   )
IS
BEGIN
  SELECT REGIONS_SEQ.NEXTVAL INTO p_region_id FROM dual;
  INSERT INTO regions(region_id, region_name) values(p_region_id,p_region_name);
  COMMIT;
END;
#===========================================================================================
CREATE OR REPLACE PROCEDURE sp_regions_update
  (  p_region_id     IN       regions.region_id%type
   , p_region_name   IN      regions.region_name%type
   )
IS
BEGIN
   UPDATE 
     regions
   SET
     region_name = p_region_name
  WHERE
     region_id = p_region_id;
  COMMIT;
END;
#===========================================================================================
CREATE OR REPLACE PROCEDURE sp_regions_delete
  (  p_region_id     IN       regions.region_id%type
   )
IS
BEGIN
   DELETE FROM
     regions
   WHERE
     region_id = p_region_id;
  COMMIT;
END;
#===========================================================================================
CREATE OR REPLACE PROCEDURE sp_regions_all (cursorRegions out sys_refcursor)
IS
BEGIN
OPEN cursorRegions for SELECT * FROM regions;
END;
#===========================================================================================
-- Create sequence 
create sequence REGIONS_SEQ
minvalue 1
maxvalue 9990
start with 5
increment by 1
nocache;