-- Sample Data for Bhopal Institute of Engineering & Technology (College ID = 10)
-- Courses, Fee Structure, and Seat Matrix

-- ============================================
-- COURSES FOR BIET BHOPAL (College ID = 10)
-- ============================================

-- 1. B.Tech Computer Science & Engineering
INSERT INTO courses (college_id, name, specialization, degree, duration_years, description, eligibility, active, created_at, updated_at)
VALUES (
    10,
    'B.Tech',
    'Computer Science & Engineering',
    'UG',
    4,
    'Bachelor of Technology in Computer Science & Engineering is a 4-year undergraduate program that focuses on the fundamental concepts of computer programming, software development, algorithms, data structures, computer networks, database management, and artificial intelligence.',
    '10+2 with Physics, Chemistry, and Mathematics with minimum 60% marks. Valid JEE Main score required.',
    true,
    NOW(),
    NOW()
);

-- 2. B.Tech Mechanical Engineering
INSERT INTO courses (college_id, name, specialization, degree, duration_years, description, eligibility, active, created_at, updated_at)
VALUES (
    10,
    'B.Tech',
    'Mechanical Engineering',
    'UG',
    4,
    'Bachelor of Technology in Mechanical Engineering is a 4-year program covering thermodynamics, fluid mechanics, manufacturing processes, machine design, automotive engineering, and robotics.',
    '10+2 with Physics, Chemistry, and Mathematics with minimum 60% marks. Valid JEE Main score required.',
    true,
    NOW(),
    NOW()
);

-- 3. B.Tech Civil Engineering
INSERT INTO courses (college_id, name, specialization, degree, duration_years, description, eligibility, active, created_at, updated_at)
VALUES (
    10,
    'B.Tech',
    'Civil Engineering',
    'UG',
    4,
    'Bachelor of Technology in Civil Engineering is a 4-year program that covers structural engineering, transportation engineering, environmental engineering, geotechnical engineering, and construction management.',
    '10+2 with Physics, Chemistry, and Mathematics with minimum 60% marks. Valid JEE Main score required.',
    true,
    NOW(),
    NOW()
);

-- 4. B.Tech Electronics & Communication Engineering
INSERT INTO courses (college_id, name, specialization, degree, duration_years, description, eligibility, active, created_at, updated_at)
VALUES (
    10,
    'B.Tech',
    'Electronics & Communication Engineering',
    'UG',
    4,
    'Bachelor of Technology in Electronics & Communication Engineering is a 4-year program focusing on analog and digital electronics, communication systems, microprocessors, VLSI design, embedded systems, and signal processing.',
    '10+2 with Physics, Chemistry, and Mathematics with minimum 60% marks. Valid JEE Main score required.',
    true,
    NOW(),
    NOW()
);

-- 5. B.Tech Electrical Engineering
INSERT INTO courses (college_id, name, specialization, degree, duration_years, description, eligibility, active, created_at, updated_at)
VALUES (
    10,
    'B.Tech',
    'Electrical Engineering',
    'UG',
    4,
    'Bachelor of Technology in Electrical Engineering is a 4-year program covering power systems, electrical machines, power electronics, control systems, renewable energy, and electrical drives.',
    '10+2 with Physics, Chemistry, and Mathematics with minimum 60% marks. Valid JEE Main score required.',
    true,
    NOW(),
    NOW()
);

-- 6. M.Tech Computer Science & Engineering
INSERT INTO courses (college_id, name, specialization, degree, duration_years, description, eligibility, active, created_at, updated_at)
VALUES (
    10,
    'M.Tech',
    'Computer Science & Engineering',
    'PG',
    2,
    'Master of Technology in Computer Science & Engineering is a 2-year postgraduate program focusing on advanced topics like machine learning, artificial intelligence, cloud computing, big data analytics, and cybersecurity.',
    'B.Tech/B.E. in CSE/IT or related field with minimum 55% marks. Valid GATE score preferred.',
    true,
    NOW(),
    NOW()
);

-- ============================================
-- FEE STRUCTURE (Academic Year 2024-2025)
-- ============================================

-- Fee for B.Tech CSE (assuming course_id will be assigned sequentially)
-- Note: We'll need to get the course IDs after insertion
-- For now, assuming course IDs start from next available ID

-- Fees for Course ID (will be updated after knowing actual IDs)
-- B.Tech CSE - Annual Fee
INSERT INTO fee_structure (course_id, academic_year, tuition_fee, hostel_fee, transport_fee, library_fee, lab_fee, other_fees, total_fee, fee_type, remarks, created_at, updated_at)
SELECT 
    id,
    '2024-2025',
    95000.00,
    45000.00,
    12000.00,
    3000.00,
    8000.00,
    7000.00,
    170000.00,
    'PER_YEAR',
    'Annual fee structure for B.Tech Computer Science & Engineering. Fee is subject to annual revision.',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Computer Science & Engineering';

-- B.Tech Mechanical - Annual Fee
INSERT INTO fee_structure (course_id, academic_year, tuition_fee, hostel_fee, transport_fee, library_fee, lab_fee, other_fees, total_fee, fee_type, remarks, created_at, updated_at)
SELECT 
    id,
    '2024-2025',
    85000.00,
    45000.00,
    12000.00,
    3000.00,
    7000.00,
    6000.00,
    158000.00,
    'PER_YEAR',
    'Annual fee structure for B.Tech Mechanical Engineering. Fee is subject to annual revision.',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Mechanical Engineering';

-- B.Tech Civil - Annual Fee
INSERT INTO fee_structure (course_id, academic_year, tuition_fee, hostel_fee, transport_fee, library_fee, lab_fee, other_fees, total_fee, fee_type, remarks, created_at, updated_at)
SELECT 
    id,
    '2024-2025',
    80000.00,
    45000.00,
    12000.00,
    3000.00,
    6000.00,
    6000.00,
    152000.00,
    'PER_YEAR',
    'Annual fee structure for B.Tech Civil Engineering. Fee is subject to annual revision.',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Civil Engineering';

-- B.Tech ECE - Annual Fee
INSERT INTO fee_structure (course_id, academic_year, tuition_fee, hostel_fee, transport_fee, library_fee, lab_fee, other_fees, total_fee, fee_type, remarks, created_at, updated_at)
SELECT 
    id,
    '2024-2025',
    90000.00,
    45000.00,
    12000.00,
    3000.00,
    8000.00,
    7000.00,
    165000.00,
    'PER_YEAR',
    'Annual fee structure for B.Tech Electronics & Communication Engineering. Fee is subject to annual revision.',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Electronics & Communication Engineering';

-- B.Tech Electrical - Annual Fee
INSERT INTO fee_structure (course_id, academic_year, tuition_fee, hostel_fee, transport_fee, library_fee, lab_fee, other_fees, total_fee, fee_type, remarks, created_at, updated_at)
SELECT 
    id,
    '2024-2025',
    85000.00,
    45000.00,
    12000.00,
    3000.00,
    7000.00,
    6000.00,
    158000.00,
    'PER_YEAR',
    'Annual fee structure for B.Tech Electrical Engineering. Fee is subject to annual revision.',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Electrical Engineering';

-- M.Tech CSE - Annual Fee
INSERT INTO fee_structure (course_id, academic_year, tuition_fee, hostel_fee, transport_fee, library_fee, lab_fee, other_fees, total_fee, fee_type, remarks, created_at, updated_at)
SELECT 
    id,
    '2024-2025',
    110000.00,
    50000.00,
    12000.00,
    4000.00,
    10000.00,
    8000.00,
    194000.00,
    'PER_YEAR',
    'Annual fee structure for M.Tech Computer Science & Engineering. Fee is subject to annual revision.',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'M.Tech' AND specialization = 'Computer Science & Engineering';

-- ============================================
-- SEAT MATRIX (Academic Year 2024-2025)
-- ============================================

-- B.Tech CSE - Seat Matrix by Category
INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'GENERAL',
    60,
    15,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Computer Science & Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'OBC',
    40,
    12,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Computer Science & Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'SC',
    20,
    8,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Computer Science & Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'ST',
    10,
    5,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Computer Science & Engineering';

-- B.Tech Mechanical - Seat Matrix by Category
INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'GENERAL',
    60,
    25,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Mechanical Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'OBC',
    40,
    18,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Mechanical Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'SC',
    20,
    10,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Mechanical Engineering';

-- B.Tech Civil - Seat Matrix
INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'GENERAL',
    60,
    30,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Civil Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'OBC',
    40,
    20,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Civil Engineering';

-- B.Tech ECE - Seat Matrix
INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'GENERAL',
    60,
    20,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Electronics & Communication Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'OBC',
    40,
    15,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Electronics & Communication Engineering';

-- B.Tech Electrical - Seat Matrix
INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'GENERAL',
    60,
    28,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Electrical Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'OBC',
    40,
    18,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'B.Tech' AND specialization = 'Electrical Engineering';

-- M.Tech CSE - Seat Matrix
INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'GENERAL',
    24,
    10,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'M.Tech' AND specialization = 'Computer Science & Engineering';

INSERT INTO seat_matrix (course_id, category, total_seats, available_seats, academic_year, created_at, updated_at)
SELECT 
    id,
    'OBC',
    12,
    6,
    '2024-2025',
    NOW(),
    NOW()
FROM courses 
WHERE college_id = 10 AND name = 'M.Tech' AND specialization = 'Computer Science & Engineering';

-- ============================================
-- VERIFICATION QUERIES
-- ============================================
-- Uncomment to verify after running the script

-- SELECT * FROM courses WHERE college_id = 10;
-- SELECT fs.* FROM fee_structure fs JOIN courses c ON fs.course_id = c.id WHERE c.college_id = 10;
-- SELECT sm.* FROM seat_matrix sm JOIN courses c ON sm.course_id = c.id WHERE c.college_id = 10;
