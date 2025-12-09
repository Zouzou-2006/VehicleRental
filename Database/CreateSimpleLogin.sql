-- ============================================
-- INSTRUCTIONS: Run these commands in SQL Server Management Studio
-- ============================================

-- Step 1: Enable Mixed Mode Authentication
-- Right-click on the server in SSMS → Properties → Security
-- Select "SQL Server and Windows Authentication mode"
-- Click OK, then restart SQL Server service

-- Step 2: Create a new login with a simple password
USE master;
GO

CREATE LOGIN rentalapp WITH PASSWORD = 'Rental123';
GO

-- Step 3: Grant access to the database
USE dbVehicleRental;
GO

CREATE USER rentalapp FOR LOGIN rentalapp;
GO

ALTER ROLE db_owner ADD MEMBER rentalapp;
GO

-- Verify the login was created
SELECT name, is_disabled, create_date
FROM sys.server_principals
WHERE name = 'rentalapp';
GO

PRINT 'Setup complete! Login: rentalapp | Password: Rental123';
GO
