-- ============================================
-- Database: dbVehicleRental
-- Author: NF
-- Date: 12/08/2025
-- Description: Vehicle Rental Database
-- ============================================

-- Create Database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'dbVehicleRental')
BEGIN
    CREATE DATABASE dbVehicleRental;
END
GO

USE dbVehicleRental;
GO

-- Drop table if exists
IF OBJECT_ID('TLocations', 'U') IS NOT NULL
    DROP TABLE TLocations;
GO

-- Create TLocations table
CREATE TABLE TLocations (
    intLocationID INT PRIMARY KEY IDENTITY(1,1),
    strName VARCHAR(50) NOT NULL,
    strAddress VARCHAR(100) NOT NULL,
    strCity VARCHAR(50) NOT NULL,
    strState VARCHAR(2) NOT NULL,
    strZip VARCHAR(10) NOT NULL
);
GO

-- Insert sample location records
INSERT INTO TLocations (strName, strAddress, strCity, strState, strZip) VALUES
('Northwest', '10 Colerain', 'Cinti', 'OH', '45241'),
('Downtown', '2010 Vine', 'Cinti', 'OH', '45201'),
('Loveland', '202 Main St', 'Loveland', 'OH', '45140'),
('Hamilton', '9010 C Street', 'Hamilton', 'OH', '45013');
GO

-- Verify data
SELECT * FROM TLocations ORDER BY strName;
GO
