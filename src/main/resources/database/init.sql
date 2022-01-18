CREATE TABLE districts (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    square_meter_price NUMERIC(10, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_districts PRIMARY KEY(id)
);

CREATE TABLE properties (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    district_id BIGINT UNSIGNED NOT NULL,
    
    CONSTRAINT pk_properties PRIMARY KEY(id),
    CONSTRAINT fk_properties_districts FOREIGN KEY(district_id) REFERENCES districts(id)
);

CREATE TABLE rooms (
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    width NUMERIC(5, 2) NOT NULL,
    length NUMERIC(5, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    property_id BIGINT UNSIGNED NOT NULL,

    CONSTRAINT pk_rooms PRIMARY KEY(id),
    CONSTRAINT fk_rooms_properties FOREIGN KEY(property_id) REFERENCES properties(id)
);