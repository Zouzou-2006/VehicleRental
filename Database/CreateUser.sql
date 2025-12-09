-- ============================================
-- Create SQL Login for Vehicle Rental Application
-- Run this in SQL Server Management Studio
-- ============================================

USE master;
GO

-- Create login
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = 'vehicleuser')
BEGIN
    CREATE LOGIN vehicleuser WITH PASSWORD = 'VehiclePass123!';
    PRINT 'Login vehicleuser created successfully';
END
ELSE
BEGIN
    PRINT 'Login vehicleuser already exists';
END
GO

-- Switch to the database
USE dbVehicleRental;
GO

-- Create user for the login
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = 'vehicleuser')
BEGIN
    CREATE USER vehicleuser FOR LOGIN vehicleuser;
    PRINT 'User vehicleuser created successfully';
END
ELSE
BEGIN
    PRINT 'User vehicleuser already exists';
END
GO

-- Grant permissions
ALTER ROLE db_owner ADD MEMBER vehicleuser;
GO

PRINT 'Setup complete! You can now run the Java application.';
GO
