
CREATE TABLE [Role] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[name] NVARCHAR(255),
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Account] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[username] NVARCHAR(255),
	[password] NVARCHAR(255),
	[email] NVARCHAR(255),
	[address] NVARCHAR(255),
	[phone_number] NVARCHAR(255),
	[role_id] INT,
	[salary] DECIMAL,
	[date_of_birth] DATE,
	[status] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Customer] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[name] NVARCHAR(255),
	[phone_number] NVARCHAR(255),
	[gender] NVARCHAR(255),
	[email] NVARCHAR(255),
	[account_id] INT,
	[address] NVARCHAR(255),
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Staff] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[name] NVARCHAR(255),
	[gender] NVARCHAR(255),
	[date_of_birth] DATE,
	[phone_number] NVARCHAR(255),
	[email] NVARCHAR(255),
	[address] NVARCHAR(255),
	[salary] DECIMAL,
	[account_id] INT,
	[hire_date] DATE,
	[status] INT,
	[notes] NVARCHAR(255),
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Order] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[status] INT,
	[order_date] DATETIME,
	[total_amout] DECIMAL,
	[customer_id] INT,
	[staff_id] INT,
	[voucher_id] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Payment] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[payment_date] DATETIME,
	[payment_method] NVARCHAR(255),
	[amount] DECIMAL,
	[order_id] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Order_Detail] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[price] DECIMAL,
	[quantity] INT,
	[order_id] INT,
	[product_detail_id] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Product] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[name] NVARCHAR(255),
	[price] DECIMAL,
	[description] NVARCHAR(255),
	[category_id] INT,
	[brand_id] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [ProductDetail] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[quantity] INT,
	[price] DECIMAL,
	[product_id] INT,
	[size_id] INT,
	[material_id] INT,
	[color_id] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Size] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[name] NVARCHAR(255),
	[status] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Category] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[name] NVARCHAR(255),
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Brand] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[name] NVARCHAR(255),
	[status] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Material] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[name] NVARCHAR(255),
	[status] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [ProductDetail_Promotion] (
	[promotion_id] INT NOT NULL IDENTITY UNIQUE,
	[product__detail_id] INT,
	PRIMARY KEY([promotion_id])
);
GO

CREATE TABLE [Promotion] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[name] NVARCHAR(255),
	[start_date] DATETIME,
	[end_date] DATETIME,
	[discount_percentage] DECIMAL,
	[discount_amount] DECIMAL,
	[promotion_type] NVARCHAR(255),
	[status] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Cart] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[customer_id] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [CartDetail] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[cart_id] INT,
	[product_detail_id] INT,
	[quantity] INT,
	[price] DECIMAL,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [ProductDetail_image] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[image_url] NVARCHAR(255),
	[product_detail_id] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Color] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[name] NVARCHAR(255),
	[status] INT,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [Voucher] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[code] NVARCHAR(255),
	[discount_amount] DECIMAL,
	[discount_percentage] DECIMAL,
	[start_date] DATETIME,
	[end_date] DATETIME,
	[minimum_order_amount] DECIMAL,
	[voucher_type] NVARCHAR(255),
	[max_discount_amount] DECIMAL,
	[usage_limit] INT,
	[status] INT,
	[create_at] DATETIME,
	[update_at] DATETIME,
	PRIMARY KEY([id])
);
GO

CREATE TABLE [VoucherUsage] (
	[id] INT NOT NULL IDENTITY UNIQUE,
	[voucher_id] INT,
	[customer_id] INT,
	[order_id] INT,
	[usage_date] DATETIME,
	PRIMARY KEY([id])
);
GO

ALTER TABLE [Account]
ADD FOREIGN KEY([role_id]) REFERENCES [Role]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Customer]
ADD FOREIGN KEY([account_id]) REFERENCES [Account]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Staff]
ADD FOREIGN KEY([account_id]) REFERENCES [Account]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Order]
ADD FOREIGN KEY([staff_id]) REFERENCES [Staff]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Order]
ADD FOREIGN KEY([customer_id]) REFERENCES [Customer]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Payment]
ADD FOREIGN KEY([order_id]) REFERENCES [Order]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Order_Detail]
ADD FOREIGN KEY([order_id]) REFERENCES [Order]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail]
ADD FOREIGN KEY([product_id]) REFERENCES [Product]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail]
ADD FOREIGN KEY([size_id]) REFERENCES [Size]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Product]
ADD FOREIGN KEY([category_id]) REFERENCES [Category]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Product]
ADD FOREIGN KEY([brand_id]) REFERENCES [Brand]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail]
ADD FOREIGN KEY([material_id]) REFERENCES [Material]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Order_Detail]
ADD FOREIGN KEY([product_detail_id]) REFERENCES [ProductDetail]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail_Promotion]
ADD FOREIGN KEY([product__detail_id]) REFERENCES [ProductDetail]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail_Promotion]
ADD FOREIGN KEY([promotion_id]) REFERENCES [Promotion]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Cart]
ADD FOREIGN KEY([customer_id]) REFERENCES [Customer]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [CartDetail]
ADD FOREIGN KEY([product_detail_id]) REFERENCES [ProductDetail]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [CartDetail]
ADD FOREIGN KEY([cart_id]) REFERENCES [Cart]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail_image]
ADD FOREIGN KEY([product_detail_id]) REFERENCES [ProductDetail]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [ProductDetail]
ADD FOREIGN KEY([color_id]) REFERENCES [Color]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [Order]
ADD FOREIGN KEY([voucher_id]) REFERENCES [Voucher]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [VoucherUsage]
ADD FOREIGN KEY([voucher_id]) REFERENCES [Voucher]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [VoucherUsage]
ADD FOREIGN KEY([customer_id]) REFERENCES [Customer]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [VoucherUsage]
ADD FOREIGN KEY([order_id]) REFERENCES [Order]([id])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO