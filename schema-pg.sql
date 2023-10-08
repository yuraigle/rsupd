CREATE TABLE rsupd.operation
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    tip_op       VARCHAR(255),
    enp          VARCHAR(255),
    fam          VARCHAR(255),
    im           VARCHAR(255),
    ot           VARCHAR(255),
    dr           DATE,
    gender       INTEGER,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    progress     TIMESTAMP WITHOUT TIME ZONE,
    processed_at TIMESTAMP WITHOUT TIME ZONE,
    result       VARCHAR(255),
    CONSTRAINT pk_operation PRIMARY KEY (id)
);

CREATE TABLE rsupd.udl
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    type         INTEGER,
    docser       VARCHAR(255),
    docnum       VARCHAR(255),
    doc_date     date,
    operation_id BIGINT,
    CONSTRAINT pk_udl PRIMARY KEY (id)
);

ALTER TABLE rsupd.udl
    ADD CONSTRAINT FK_UDL_ON_OPERATION FOREIGN KEY (operation_id) REFERENCES rsupd.operation (id);