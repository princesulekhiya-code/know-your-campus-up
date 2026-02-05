-- Remove placeholder images from College ID 10
-- This will fix the "site can't be reached" error

USE knowyourcampus_db;

UPDATE colleges 
SET logo_url = NULL, banner_url = NULL 
WHERE id = 10;

-- Verify the update
SELECT id, name, logo_url, banner_url FROM colleges WHERE id = 10;
