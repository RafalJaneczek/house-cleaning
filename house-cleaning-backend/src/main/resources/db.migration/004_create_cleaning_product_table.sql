CREATE TABLE T_CLEANING_PRODUCTS(
    ID               NUMBER(10) PRIMARY KEY,
    DATE_OF_PURCHASE TIMESTAMP   NOT NULL,
    PRODUCT_NAME     VARCHAR(50) NOT NULL,
    USER_ID          NUMBER(10),
    FOREIGN KEY (USER_ID) REFERENCES T_USERS (ID)
);

CREATE VIEW V_CLEANING_PRODUCTS AS
SELECT ID, DATE_OF_PURCHASE, PRODUCT_NAME, USER_ID
FROM T_CLEANING_PRODUCTS
WITH CHECK OPTION;

CREATE SEQUENCE CLEANING_PRODUCT_ID_SEQ
    START WITH 1
    INCREMENT BY 1 NOCACHE
    NOCYCLE;