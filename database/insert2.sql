-- Insert dữ liệu vào bảng [role]
INSERT INTO [role] ([name])
VALUES ('Admin'), ('Staff'), ('Customer');
GO

-- Insert dữ liệu vào bảng [size]
INSERT INTO [size] ([code], [name], [status])
VALUES 
('S', 'Small', 1),
('M', 'Medium', 1),
('L', 'Large', 1);
GO

-- Insert dữ liệu vào bảng [category]
INSERT INTO [category] ([name])
VALUES ('Polo Shirt');
GO

-- Insert dữ liệu vào bảng [brand]
INSERT INTO [brand] ([code], [name], [status])
VALUES 
('BR001', 'Brand A', 1),
('BR002', 'Brand B', 1);
GO

-- Insert dữ liệu vào bảng [material]
INSERT INTO [material] ([code], [name], [status])
VALUES 
('M001', 'Cotton', 1),
('M002', 'Polyester', 1),
('M003', 'Blended', 1);
GO

-- Insert dữ liệu vào bảng [color]
INSERT INTO [color] ([code], [name], [status])
VALUES 
('C001', 'Blue', 1),
('C002', 'Red', 1),
('C003', 'Green', 1),
('C004', 'Black', 1),
('C005', 'White', 1),
('C006', 'Yellow', 1),
('C007', 'Purple', 1),
('C008', 'Grey', 1);
GO

-- Insert dữ liệu vào bảng [account]
INSERT INTO [account] ([username], [password], [email], [address], [phone_number], [role_id], [salary], [date_of_birth], [status])
VALUES 
('admin', 'password1', 'admin@example.com', '123 Admin St', '1234567890', 1, 50000000, '1980-01-01', 1),
('staff1', 'password2', 'staff1@example.com', '456 Staff Rd', '2345678901', 2, 30000000, '1990-05-15', 1),
('staff2', 'password3', 'staff2@example.com', '789 Staff Ln', '3456789012', 2, 28000000, '1992-07-21', 1),
('customer1', 'password4', 'customer1@example.com', '101 Customer Ave', '4567890123', 3, 0, '1995-09-10', 1),
('customer2', 'password5', 'customer2@example.com', '202 Customer Blvd', '5678901234', 3, 0, '1988-12-22', 1);
GO

-- Insert dữ liệu vào bảng [customer]
INSERT INTO [customer] ([name], [phone_number], [gender], [email], [account_id], [address], [create_at], [update_at])
VALUES 
('John Doe', '4567890123', 'Male', 'customer1@example.com', 4, '101 Customer Ave', GETDATE(), GETDATE()),
('Jane Smith', '5678901234', 'Female', 'customer2@example.com', 5, '202 Customer Blvd', GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [staff]
INSERT INTO [staff] ([name], [gender], [date_of_birth], [phone_number], [email], [address], [salary], [account_id], [hire_date], [status], [notes], [create_at], [update_at])
VALUES 
('Alice Johnson', 'Female', '1990-05-15', '2345678901', 'staff1@example.com', '456 Staff Rd', 30000000, 2, '2015-01-10', 1, 'Excellent performance', GETDATE(), GETDATE()),
('Bob Williams', 'Male', '1992-07-21', '3456789012', 'staff2@example.com', '789 Staff Ln', 28000000, 3, '2016-03-22', 1, 'Good performance', GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [product]
INSERT INTO [product] ([code], [name], [image_url], [price], [description], [category_id], [brand_id], [create_at], [update_at])
VALUES 
('P001', 'Polo Shirt Blue', 'images/p001.png', 250000, 'Blue polo shirt, cotton material.', 1, 1, GETDATE(), GETDATE()),
('P002', 'Polo Shirt Red', 'images/p002.png', 300000, 'Red polo shirt, polyester material.', 1, 1, GETDATE(), GETDATE()),
('P003', 'Polo Shirt Green', 'images/p003.png', 275000, 'Green polo shirt, blended material.', 1, 1, GETDATE(), GETDATE()),
('P004', 'Polo Shirt Black', 'images/p004.png', 220000, 'Black polo shirt, cotton material.', 1, 1, GETDATE(), GETDATE()),
('P005', 'Polo Shirt White', 'images/p005.png', 200000, 'White polo shirt, polyester material.', 1, 1, GETDATE(), GETDATE()),
('P006', 'Polo Shirt Yellow', 'images/p006.png', 240000, 'Yellow polo shirt, cotton material.', 1, 1, GETDATE(), GETDATE()),
('P007', 'Polo Shirt Purple', 'images/p007.png', 280000, 'Purple polo shirt, blended material.', 1, 1, GETDATE(), GETDATE()),
('P008', 'Polo Shirt Grey', 'images/p008.png', 260000, 'Grey polo shirt, cotton material.', 1, 1, GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [product_detail]
INSERT INTO [product_detail] ([code], [quantity], [price], [product_id], [size_id], [material_id], [color_id], [create_at], [update_at])
VALUES 
('PD001', 10, 250000, 1, 1, 1, 1, GETDATE(), GETDATE()),
('PD002', 15, 300000, 2, 2, 2, 2, GETDATE(), GETDATE()),
('PD003', 20, 275000, 3, 3, 3, 3, GETDATE(), GETDATE()),
('PD004', 25, 220000, 4, 1, 1, 4, GETDATE(), GETDATE()),
('PD005', 30, 200000, 5, 2, 2, 5, GETDATE(), GETDATE()),
('PD006', 12, 240000, 6, 3, 3, 6, GETDATE(), GETDATE()),
('PD007', 8, 280000, 7, 1, 1, 7, GETDATE(), GETDATE()),
('PD008', 18, 260000, 8, 2, 2, 8, GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [product_detail_image]
INSERT INTO [product_detail_image] ([image_url], [product_detail_id])
VALUES 
('images/pd001.png', 1),
('images/pd002.png', 2),
('images/pd003.png', 3),
('images/pd004.png', 4),
('images/pd005.png', 5),
('images/pd006.png', 6),
('images/pd007.png', 7),
('images/pd008.png', 8);
GO

-- Insert dữ liệu vào bảng [promotion]
INSERT INTO [promotion] ([name], [start_date], [end_date], [discount_percentage], [discount_amount], [promotion_type], [status], [create_at], [update_at])
VALUES 
('Summer Sale', '2024-06-01', '2024-08-31', 10, 0, 'Percentage', 1, GETDATE(), GETDATE()),
('Clearance Sale', '2024-09-01', '2024-09-30', 0, 50000, 'Fixed', 1, GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [product_detail_promotion]
INSERT INTO [product_detail_promotion] ([promotion_id], [product_detail_id])
VALUES 
(1, 1),
(2, 2);
GO

-- Insert dữ liệu vào bảng [order]
INSERT INTO [order] ([status], [order_date], [total_amount], [customer_id], [staff_id], [voucher_id], [create_at], [update_at])
VALUES 
(1, GETDATE(), 10000000, 1, 1, NULL, GETDATE(), GETDATE()),
(1, GETDATE(), 25000000, 2, 2, NULL, GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [payment]
INSERT INTO [payment] ([payment_date], [payment_method], [amount], [order_id])
VALUES 
(GETDATE(), 'Credit Card', 10000000, 1),
(GETDATE(), 'Paypal', 25000000, 2);
GO

-- Insert dữ liệu vào bảng [order_detail]
INSERT INTO [order_detail] ([price], [quantity], [order_id], [product_detail_id], [create_at], [update_at])
VALUES 
(250000, 2, 1, 1, GETDATE(), GETDATE()),
(300000, 1, 2, 2, GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [cart]
INSERT INTO [cart] ([customer_id], [create_at], [update_at])
VALUES 
(1, GETDATE(), GETDATE()),
(2, GETDATE(), GETDATE());
GO

-- Insert dữ liệu vào bảng [cart_detail]
INSERT INTO [cart_detail] ([cart_id], [product_detail_id], [quantity], [price], [create_at], [update_at])
VALUES 
(1, 1, 2, 250000, GETDATE(), GETDATE()),
(1, 2, 1, 300000, GETDATE(), GETDATE());
GO
