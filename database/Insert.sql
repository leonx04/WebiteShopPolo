-- Insert data into Role table
INSERT INTO [Role] ([name]) VALUES
('Admin'),
('Staff'),
('Customer');

-- Insert data into Account table
INSERT INTO [Account] ([username], [password], [email], [address], [phone_number], [role_id], [salary], [date_of_birth], [status]) VALUES
('admin', 'admin123', 'admin@example.com', '123 Admin St', '1234567890', 1, 5000.00, '1990-01-01', 1),
('staff1', 'staff123', 'staff1@example.com', '456 Staff Ave', '2345678901', 2, 3000.00, '1995-05-15', 1),
('customer1', 'cust123', 'customer1@example.com', '789 Customer Blvd', '3456789012', 3, NULL, '1988-10-20', 1);

-- Insert data into Customer table
INSERT INTO [Customer] ([name], [phone_number], [gender], [email], [account_id], [address], [create_at], [update_at]) VALUES
('John Doe', '3456789012', 'Male', 'customer1@example.com', 3, '789 Customer Blvd', GETDATE(), GETDATE());

-- Insert data into Staff table
INSERT INTO [Staff] ([name], [gender], [date_of_birth], [phone_number], [email], [address], [salary], [account_id], [hire_date], [status], [notes], [create_at], [update_at]) VALUES
('Jane Smith', 'Female', '1995-05-15', '2345678901', 'staff1@example.com', '456 Staff Ave', 3000.00, 2, '2023-01-15', 1, 'Experienced sales staff', GETDATE(), GETDATE());

-- Insert data into Category table
INSERT INTO [Category] ([name]) VALUES
('Shirts'),
('Pants'),
('Accessories');

-- Insert data into Brand table
INSERT INTO [Brand] ([code], [name], [status]) VALUES
('BRD001', 'Polo Ralph Lauren', 1),
('BRD002', 'Tommy Hilfiger', 1);

-- Insert data into Material table
INSERT INTO [Material] ([code], [name], [status]) VALUES
('MAT001', 'Cotton', 1),
('MAT002', 'Polyester', 1);

-- Insert data into Size table
INSERT INTO [Size] ([code], [name], [status]) VALUES
('S', 'Small', 1),
('M', 'Medium', 1),
('L', 'Large', 1);

-- Insert data into Color table
INSERT INTO [Color] ([code], [name], [status]) VALUES
('COL001', 'White', 1),
('COL002', 'Black', 1),
('COL003', 'Blue', 1);

-- Insert data into Product table
INSERT INTO [Product] ([code], [name], [price], [description], [category_id], [brand_id], [create_at], [update_at]) VALUES
('PRD001', 'Classic Polo Shirt', 59.99, 'A timeless classic polo shirt', 1, 1, GETDATE(), GETDATE()),
('PRD002', 'Slim Fit Chinos', 79.99, 'Comfortable and stylish chinos', 2, 2, GETDATE(), GETDATE());

-- Insert data into ProductDetail table
INSERT INTO [ProductDetail] ([code], [quantity], [price], [product_id], [size_id], [material_id], [color_id], [create_at], [update_at]) VALUES
('PRD001-S-WHT', 100, 59.99, 1, 1, 1, 1, GETDATE(), GETDATE()),
('PRD001-M-BLU', 150, 59.99, 1, 2, 1, 3, GETDATE(), GETDATE()),
('PRD002-M-BLK', 75, 79.99, 2, 2, 2, 2, GETDATE(), GETDATE());

-- Insert data into ProductDetail_image table
INSERT INTO [ProductDetail_image] ([image_url], [product_detail_id]) VALUES
('https://down-vn.img.susercontent.com/file/82cef649b54589ebc5aab730aa94d0af_tn', 1),
('https://down-vn.img.susercontent.com/file/82cef649b54589ebc5aab730aa94d0af_tn', 2),
('https://down-vn.img.susercontent.com/file/82cef649b54589ebc5aab730aa94d0af_tn', 3);

-- Insert data into Promotion table
INSERT INTO [Promotion] ([name], [start_date], [end_date], [discount_percentage], [discount_amount], [promotion_type], [status], [create_at], [update_at]) VALUES
('Summer Sale', '2024-06-01', '2024-06-30', 20.00, NULL, 'Percentage', 1, GETDATE(), GETDATE()),
('Clearance', '2024-07-01', '2024-07-15', NULL, 10.00, 'Fixed Amount', 1, GETDATE(), GETDATE());

---- Insert data into ProductDetail_Promotion table
--INSERT INTO [ProductDetail_Promotion] ([promotion_id], [product_detail_id]) VALUES
--(1, 1),
--(1, 2),
--(2, 3);

-- Insert data into Voucher table
INSERT INTO [Voucher] ([code], [discount_amount], [discount_percentage], [start_date], [end_date], [minimum_order_amount], [voucher_type], [max_discount_amount], [usage_limit], [status], [create_at], [update_at]) VALUES
('SUMMER10', NULL, 10.00, '2024-06-01', '2024-08-31', 50.00, 'Percentage', 30.00, 1000, 1, GETDATE(), GETDATE()),
('NEWCUST20', 20.00, NULL, '2024-05-01', '2024-12-31', 100.00, 'Fixed Amount', NULL, 500, 1, GETDATE(), GETDATE());

-- Insert data into Cart table
INSERT INTO [Cart] ([customer_id], [create_at], [update_at]) VALUES
(1, GETDATE(), GETDATE());

-- Insert data into CartDetail table
INSERT INTO [CartDetail] ([cart_id], [product_detail_id], [quantity], [price], [create_at], [update_at]) VALUES
(1, 1, 2, 59.99, GETDATE(), GETDATE()),
(1, 3, 1, 79.99, GETDATE(), GETDATE());

-- Insert data into Order table
INSERT INTO [Order] ([status], [order_date], [total_amount], [customer_id], [staff_id], [voucher_id], [create_at], [update_at]) VALUES
(1, GETDATE(), 199.97, 1, 1, 1, GETDATE(), GETDATE());

-- Insert data into Order_Detail table
INSERT INTO [Order_Detail] ([price], [quantity], [order_id], [product_detail_id], [create_at], [update_at]) VALUES
(59.99, 2, 1, 1, GETDATE(), GETDATE()),
(79.99, 1, 1, 3, GETDATE(), GETDATE());

-- Insert data into Payment table
INSERT INTO [Payment] ([payment_date], [payment_method], [amount], [order_id]) VALUES
(GETDATE(), 'Credit Card', 199.97, 1);

-- Insert data into VoucherUsage table
INSERT INTO [VoucherUsage] ([voucher_id], [customer_id], [order_id], [usage_date]) VALUES
(1, 1, 1, GETDATE());