CREATE TABLE [role] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [name] NVARCHAR(255),
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [account] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [username] NVARCHAR(255),
  [password] NVARCHAR(255),
  [email] VARCHAR(255),
  [address] NVARCHAR(255),
  [phone_number] VARCHAR(255),
  [role_id] INT,
  [salary] DECIMAL,
  [date_of_birth] DATE,
  [status] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [customer] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [name] NVARCHAR(255),
  [phone_number] VARCHAR(255),
  [gender] NVARCHAR(255),
  [email] VARCHAR(255),
  [account_id] INT,
  [address] NVARCHAR(255),
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [staff] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [name] NVARCHAR(255),
  [gender] NVARCHAR(255),
  [date_of_birth] DATE,
  [phone_number] VARCHAR(255),
  [email] VARCHAR(255),
  [address] NVARCHAR(255),
  [salary] DECIMAL,
  [account_id] INT,
  [hire_date] DATE,
  [status] INT,
  [notes] NVARCHAR(255),
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [order] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [status] INT,
  [order_date] DATETIME,
  [total_amount] DECIMAL,
  [customer_id] INT,
  [staff_id] INT,
  [voucher_id] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [payment] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [payment_date] DATETIME,
  [payment_method] NVARCHAR(255),
  [amount] DECIMAL(38, 3),
  [order_id] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [order_detail] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [price] DECIMAL(38, 3),
  [quantity] INT,
  [order_id] INT,
  [product_detail_id] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [product] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [name] NVARCHAR(255),
  [image_url] VARCHAR(255),
  [price] DECIMAL(18, 0),
  [description] NVARCHAR(255),
  [category_id] INT,
  [brand_id] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [product_detail] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [quantity] INT,
  [price] DECIMAL(18, 0),
  [product_id] INT,
  [size_id] INT,
  [material_id] INT,
  [color_id] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [size] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [name] NVARCHAR(255),
  [status] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [category] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [name] NVARCHAR(255),
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [brand] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [name] NVARCHAR(255),
  [status] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [material] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [name] NVARCHAR(255),
  [status] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [product_detail_promotion] (
  [promotion_id] INT UNIQUE NOT NULL,
  [product_detail_id] INT,
  PRIMARY KEY ([promotion_id], [product_detail_id])
)
GO

CREATE TABLE [promotion] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [name] NVARCHAR(255),
  [start_date] DATETIME,
  [end_date] DATETIME,
  [discount_percentage] DECIMAL(18, 3),
  [discount_amount] DECIMAL,
  [promotion_type] NVARCHAR(255),
  [status] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [cart] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [customer_id] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [cart_detail] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [cart_id] INT,
  [product_detail_id] INT,
  [quantity] INT,
  [price] DECIMAL(38, 3),
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [product_detail_image] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [image_url] VARCHAR(255),
  [product_detail_id] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [color] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [name] NVARCHAR(255),
  [status] INT,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [voucher] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [code] VARCHAR(255),
  [discount_amount] DECIMAL(18, 2),
  [discount_percentage] DECIMAL(18, 2),
  [start_date] DATETIME,
  [end_date] DATETIME,
  [minimum_order_amount] DECIMAL(18, 2),
  [voucher_type] NVARCHAR(255),
  [max_discount_amount] DECIMAL(18, 2),
  [usage_limit] INT,
  [status] INT,
  [create_at] DATETIME,
  [update_at] DATETIME,
  PRIMARY KEY ([id])
)
GO

CREATE TABLE [voucher_usage] (
  [id] INT UNIQUE NOT NULL IDENTITY(1, 1),
  [voucher_id] INT,
  [customer_id] INT,
  [order_id] INT,
  [usage_date] DATETIME,
  PRIMARY KEY ([id])
)
GO

ALTER TABLE [account] ADD FOREIGN KEY ([role_id]) REFERENCES [role] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [customer] ADD FOREIGN KEY ([account_id]) REFERENCES [account] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [staff] ADD FOREIGN KEY ([account_id]) REFERENCES [account] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [order] ADD FOREIGN KEY ([staff_id]) REFERENCES [staff] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [order] ADD FOREIGN KEY ([customer_id]) REFERENCES [customer] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [payment] ADD FOREIGN KEY ([order_id]) REFERENCES [order] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [order_detail] ADD FOREIGN KEY ([order_id]) REFERENCES [order] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail] ADD FOREIGN KEY ([product_id]) REFERENCES [product] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail] ADD FOREIGN KEY ([size_id]) REFERENCES [size] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product] ADD FOREIGN KEY ([category_id]) REFERENCES [category] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product] ADD FOREIGN KEY ([brand_id]) REFERENCES [brand] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail] ADD FOREIGN KEY ([material_id]) REFERENCES [material] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [order_detail] ADD FOREIGN KEY ([product_detail_id]) REFERENCES [product_detail] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail_promotion] ADD FOREIGN KEY ([product_detail_id]) REFERENCES [product_detail] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail_promotion] ADD FOREIGN KEY ([promotion_id]) REFERENCES [promotion] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [cart] ADD FOREIGN KEY ([customer_id]) REFERENCES [customer] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [cart_detail] ADD FOREIGN KEY ([product_detail_id]) REFERENCES [product_detail] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [cart_detail] ADD FOREIGN KEY ([cart_id]) REFERENCES [cart] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail_image] ADD FOREIGN KEY ([product_detail_id]) REFERENCES [product_detail] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [product_detail] ADD FOREIGN KEY ([color_id]) REFERENCES [color] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [voucher_usage] ADD FOREIGN KEY ([voucher_id]) REFERENCES [voucher] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [voucher_usage] ADD FOREIGN KEY ([customer_id]) REFERENCES [customer] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [voucher_usage] ADD FOREIGN KEY ([order_id]) REFERENCES [order] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
