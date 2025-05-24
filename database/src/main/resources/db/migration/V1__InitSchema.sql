CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    name       VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(100)   NOT NULL,
    description    TEXT,
    price          DECIMAL(10, 2) NOT NULL,
    stock_quantity INTEGER        NOT NULL DEFAULT 0,
    created_at     TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP               DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders
(
    id               BIGSERIAL PRIMARY KEY,
    user_id          BIGINT         NOT NULL,
    order_date       TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    status           VARCHAR(20)    NOT NULL DEFAULT 'NEW',
    total_amount     DECIMAL(10, 2) NOT NULL,
    shipping_address TEXT,
    created_at       TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_items
(
    id             BIGSERIAL PRIMARY KEY,
    order_id       BIGINT        NOT NULL,
    product_id     BIGINT        NOT NULL,
    quantity       INTEGER        NOT NULL,
    price_per_unit DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE INDEX idx_orders_user_id ON orders (user_id);
CREATE INDEX idx_order_items_order_id ON order_items (order_id);
CREATE INDEX idx_order_items_product_id ON order_items (product_id);