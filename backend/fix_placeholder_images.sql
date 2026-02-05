-- Fix placeholder image URLs to use HTTPS instead of HTTP
-- This fixes the ERR_NAME_NOT_RESOLVED errors

UPDATE colleges 
SET logo_url = REPLACE(logo_url, 'via.placeholder.com', 'https://via.placeholder.com')
WHERE logo_url LIKE '%via.placeholder.com%' AND logo_url NOT LIKE 'https%';

UPDATE colleges 
SET banner_url = REPLACE(banner_url, 'via.placeholder.com', 'https://via.placeholder.com')
WHERE bannerurl LIKE '%via.placeholder.com%' AND banner_url NOT LIKE 'https%';

-- Or simply remove placeholder images completely
-- UPDATE colleges SET logo_url = NULL, banner_url = NULL WHERE logo_url LIKE '%placeholder%';
