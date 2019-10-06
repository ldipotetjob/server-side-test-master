-- !Ups

-- Fill Impression table with following values


-- Placement Id  --  Bidder   --  Time
-----------------------------------------------------------
-- ABC123        --  Appnexus --  12th September 2019 07:30  12-09-2019 07:30
-- ABC124        --  Rubicon  --  12th September 2019 13:30  12-09-2019 13:30
-- ABC125        --  Rubicon  --  12th September 2019 18:00  12-09-2019 18:30

-- ABC126        --  Appnexus --  14th September 2019 07:30  14-09-2019 07:30
-- ABC127        --  Rubicon  --  14th September 2019 13:30  14-09-2019 13:30
-- ABC128        --  Rubicon  --  14th September 2019 18:00  14-09-2019 18:00

-- ABC129        --  Rubicon  --  15th September 2019 18:00
-----------------------------------------------------------

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC123','Appnexus',PARSEDATETIME('12-09-2019 07:30', 'dd-MM-yyyy hh:mm'));

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC124','Rubicon',PARSEDATETIME('12-09-2019 13:30', 'dd-MM-yyyy hh:mm'));

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC125','Rubicon',PARSEDATETIME('12-09-2019 18:30', 'dd-MM-yyyy hh:mm'));

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC126','Appnexus',PARSEDATETIME('14-09-2019 07:30', 'dd-MM-yyyy hh:mm'));

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC127','Rubicon',PARSEDATETIME('14-09-2019 13:30', 'dd-MM-yyyy hh:mm'));

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC128','Rubicon',PARSEDATETIME('14-09-2019 18:00', 'dd-MM-yyyy hh:mm'));

INSERT INTO IMPRESSION (PLACEMENT, BIDDER, TIMEVAL)
VALUES ('ABC129','Rubicon',PARSEDATETIME('15-09-2019 18:00', 'dd-MM-yyyy hh:mm'));



-- !Downs

-- <Remove all values will impression table>

TRUNCATE TABLE IMPRESSION