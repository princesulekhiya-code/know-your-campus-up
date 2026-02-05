-- Fix placeholdee.com typo in college data
-- Run this SQL to update any broken image URLs

UPDATE colleges 
SET logo_url = REPLACE(logo_url, 'placeholdee.com', 'via.placeholder.com')
WHERE logo_url LIKE '%placeholdee.com%';

UPDATE colleges 
SET banner_url = REPLACE(banner_url, 'placeholdee.com', 'via.placeholder.com')
WHERE banner_url LIKE '%placeholdee.com%';

-- Or set to NULL if you don't want placeholder images
UPDATE colleges 
SET logo_url = NULL, banner_url = NULL
WHERE logo_url LIKE '%placeholdee%' OR banner_url LIKE '%placeholdee%';
