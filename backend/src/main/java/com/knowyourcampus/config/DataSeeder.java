package com.knowyourcampus.config;

import com.knowyourcampus.entity.*;
import com.knowyourcampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSeeder implements CommandLineRunner {

        @Autowired
        private AdminUserRepository adminUserRepository;

        @Autowired
        private CollegeRepository collegeRepository;

        @Autowired
        private CourseRepository courseRepository;

        @Autowired
        private SeatMatrixRepository seatMatrixRepository;

        @Autowired
        private FeeStructureRepository feeStructureRepository;

        @Autowired
        private CutoffRepository cutoffRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private BhopalCollegeSeeder bhopalCollegeSeeder;

        @Autowired
        private MPCollegeSeeder mpCollegeSeeder;

        @Override
        public void run(String... args) throws Exception {
                // Seed admin user if not exists
                if (!adminUserRepository.existsByEmail("admin@knowyourcampus.com")) {
                        AdminUser admin = new AdminUser();
                        admin.setEmail("admin@knowyourcampus.com");
                        admin.setPassword(passwordEncoder.encode("Admin@123"));
                        admin.setFullName("System Administrator");
                        admin.setRole("ADMIN");
                        admin.setActive(true);
                        adminUserRepository.save(admin);
                        System.out.println("✓ Admin user created");
                }

                // Seed Prince Sulekhiya as Admin (User Request)
                if (!adminUserRepository.existsByEmail("princesulekhiya@gmail.com")) {
                        AdminUser prince = new AdminUser();
                        prince.setEmail("princesulekhiya@gmail.com");
                        prince.setPassword(passwordEncoder.encode("Pince@123"));
                        prince.setFullName("Prince Sulekhiya");
                        prince.setRole("ADMIN");
                        prince.setActive(true);
                        adminUserRepository.save(prince);
                        System.out.println("✓ Prince admin created");
                }

                // Seed colleges if database is empty
                if (collegeRepository.count() == 0) {
                        seedColleges();
                        // Seed Bhopal colleges
                        bhopalCollegeSeeder.seedBhopalColleges();
                        // Seed all MP colleges (Indore, Gwalior, Jabalpur, Ujjain, Rewa, Sagar, etc.)
                        mpCollegeSeeder.seedAllMPColleges();
                        System.out.println("✓ All MP colleges seeded successfully!");
                }
        }

        private void seedColleges() {
                // IIT Delhi
                College iitDelhi = createCollege(
                                "Indian Institute of Technology Delhi",
                                "IIT Delhi is one of the premier engineering institutions in India, known for excellence in technical education and research.",
                                "GOVERNMENT",
                                "New Delhi",
                                "Delhi",
                                "Hauz Khas, New Delhi, Delhi 110016",
                                "110016",
                                "011-26591999",
                                "info@admin.iitd.ac.in",
                                "https://home.iitd.ac.in",
                                "A++",
                                true,
                                1961,
                                "Autonomous");

                // Add B.Tech CSE course
                Course btechCSE = createCourse(iitDelhi, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in Computer Science and Engineering", "JEE Advanced qualified");

                createSeatMatrix(btechCSE, "GENERAL", 50, 10, "2026-27");
                createSeatMatrix(btechCSE, "OBC", 30, 5, "2026-27");
                createSeatMatrix(btechCSE, "SC", 15, 3, "2026-27");
                createSeatMatrix(btechCSE, "ST", 10, 2, "2026-27");

                createFeeStructure(btechCSE, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("275000"), "PER_YEAR");

                createCutoff(btechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.5"), 150, "JEE Advanced");
                createCutoff(btechCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("98.8"), 450, "JEE Advanced");

                // IIT Delhi - B.Tech ECE
                Course iitECE = createCourse(iitDelhi, "B.Tech", "Electrical Engineering", "UG", 4,
                                "Bachelor of Technology in Electrical Engineering", "JEE Advanced qualified");
                createSeatMatrix(iitECE, "GENERAL", 45, 8, "2026-27");
                createSeatMatrix(iitECE, "OBC", 25, 4, "2026-27");
                createSeatMatrix(iitECE, "SC", 12, 2, "2026-27");
                createSeatMatrix(iitECE, "ST", 8, 2, "2026-27");
                createFeeStructure(iitECE, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("275000"), "PER_YEAR");
                createCutoff(iitECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.3"), 200, "JEE Advanced");
                createCutoff(iitECE, "OBC", "2023-2024", "Round 1", new BigDecimal("98.5"), 550, "JEE Advanced");

                // IIT Delhi - B.Tech Mechanical
                Course iitMech = createCourse(iitDelhi, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "JEE Advanced qualified");
                createSeatMatrix(iitMech, "GENERAL", 50, 10, "2026-27");
                createSeatMatrix(iitMech, "OBC", 28, 5, "2026-27");
                createSeatMatrix(iitMech, "SC", 14, 3, "2026-27");
                createSeatMatrix(iitMech, "ST", 9, 2, "2026-27");
                createFeeStructure(iitMech, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("275000"), "PER_YEAR");
                createCutoff(iitMech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.0"), 350, "JEE Advanced");
                createCutoff(iitMech, "OBC", "2023-2024", "Round 1", new BigDecimal("98.0"), 800, "JEE Advanced");

                // IIT Delhi - B.Tech Civil
                Course iitCivil = createCourse(iitDelhi, "B.Tech", "Civil Engineering", "UG", 4,
                                "Bachelor of Technology in Civil Engineering", "JEE Advanced qualified");
                createSeatMatrix(iitCivil, "GENERAL", 40, 8, "2026-27");
                createSeatMatrix(iitCivil, "OBC", 22, 4, "2026-27");
                createSeatMatrix(iitCivil, "SC", 10, 2, "2026-27");
                createSeatMatrix(iitCivil, "ST", 7, 2, "2026-27");
                createFeeStructure(iitCivil, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("275000"), "PER_YEAR");
                createCutoff(iitCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.5"), 600, "JEE Advanced");
                createCutoff(iitCivil, "OBC", "2023-2024", "Round 1", new BigDecimal("97.5"), 1200, "JEE Advanced");

                // IIT Delhi - B.Tech Chemical
                Course iitChem = createCourse(iitDelhi, "B.Tech", "Chemical Engineering", "UG", 4,
                                "Bachelor of Technology in Chemical Engineering", "JEE Advanced qualified");
                createSeatMatrix(iitChem, "GENERAL", 35, 7, "2026-27");
                createSeatMatrix(iitChem, "OBC", 20, 4, "2026-27");
                createSeatMatrix(iitChem, "SC", 9, 2, "2026-27");
                createFeeStructure(iitChem, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("275000"), "PER_YEAR");
                createCutoff(iitChem, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.2"), 700, "JEE Advanced");

                // IIT Delhi - M.Tech CSE
                Course iitMtechCSE = createCourse(iitDelhi, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in CSE", "GATE qualified with B.Tech/BE");
                createSeatMatrix(iitMtechCSE, "GENERAL", 40, 8, "2026-27");
                createSeatMatrix(iitMtechCSE, "OBC", 20, 4, "2026-27");
                createSeatMatrix(iitMtechCSE, "SC", 10, 2, "2026-27");
                createFeeStructure(iitMtechCSE, "2026-27",
                                new BigDecimal("100000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("170000"), "PER_YEAR");
                createCutoff(iitMtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.0"), 100, "GATE");

                // IIT Delhi - M.Tech EE
                Course iitMtechEE = createCourse(iitDelhi, "M.Tech", "Electrical Engineering", "PG", 2,
                                "Master of Technology in Electrical Engineering", "GATE qualified with B.Tech/BE");
                createSeatMatrix(iitMtechEE, "GENERAL", 35, 7, "2026-27");
                createSeatMatrix(iitMtechEE, "OBC", 18, 4, "2026-27");
                createFeeStructure(iitMtechEE, "2026-27",
                                new BigDecimal("100000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("170000"), "PER_YEAR");
                createCutoff(iitMtechEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.5"), 150, "GATE");

                // IIT Delhi - MBA
                Course iitMBA = createCourse(iitDelhi, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT qualified with graduation");
                createSeatMatrix(iitMBA, "GENERAL", 60, 10, "2026-27");
                createSeatMatrix(iitMBA, "OBC", 30, 5, "2026-27");
                createFeeStructure(iitMBA, "2026-27",
                                new BigDecimal("1200000"), new BigDecimal("80000"), new BigDecimal("0"),
                                new BigDecimal("15000"), new BigDecimal("0"), new BigDecimal("50000"),
                                new BigDecimal("1345000"), "PER_YEAR");
                createCutoff(iitMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.5"), null, "CAT");

                // IIT Delhi - M.Sc Physics
                Course iitMscPhy = createCourse(iitDelhi, "M.Sc", "Physics", "PG", 2,
                                "Master of Science in Physics", "IIT JAM qualified");
                createSeatMatrix(iitMscPhy, "GENERAL", 25, 5, "2026-27");
                createSeatMatrix(iitMscPhy, "OBC", 12, 3, "2026-27");
                createFeeStructure(iitMscPhy, "2026-27",
                                new BigDecimal("50000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("5000"),
                                new BigDecimal("115000"), "PER_YEAR");
                createCutoff(iitMscPhy, "GENERAL", "2023-2024", "Round 1", new BigDecimal("95.0"), null, "IIT JAM");

                // IIT Delhi - Ph.D CSE
                Course iitPhdCSE = createCourse(iitDelhi, "Ph.D", "Computer Science", "Doctoral", 4,
                                "Doctor of Philosophy in Computer Science", "GATE/NET qualified with M.Tech/ME");
                createSeatMatrix(iitPhdCSE, "GENERAL", 15, 5, "2026-27");
                createSeatMatrix(iitPhdCSE, "OBC", 8, 3, "2026-27");
                createFeeStructure(iitPhdCSE, "2026-27",
                                new BigDecimal("50000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("5000"),
                                new BigDecimal("115000"), "PER_YEAR");

                // AIIMS Delhi
                College aiimsDelhi = createCollege(
                                "All India Institute of Medical Sciences Delhi",
                                "AIIMS Delhi is India's premier medical institution offering world-class medical education and healthcare.",
                                "GOVERNMENT",
                                "New Delhi",
                                "Delhi",
                                "Ansari Nagar, New Delhi, Delhi 110029",
                                "110029",
                                "011-26588500",
                                "info@aiims.edu",
                                "https://www.aiims.edu",
                                "A++",
                                true,
                                1956,
                                "Autonomous");

                Course mbbs = createCourse(aiimsDelhi, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");

                createSeatMatrix(mbbs, "GENERAL", 50, 5, "2026-27");
                createSeatMatrix(mbbs, "OBC", 27, 3, "2026-27");
                createSeatMatrix(mbbs, "SC", 15, 2, "2026-27");

                createFeeStructure(mbbs, "2026-27",
                                new BigDecimal("5000"), new BigDecimal("30000"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("45000"), "PER_YEAR");

                createCutoff(mbbs, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.99"), 50, "NEET UG");
                createCutoff(mbbs, "OBC", "2023-2024", "Round 1", new BigDecimal("99.95"), 100, "NEET UG");

                // AIIMS Delhi - B.Sc Nursing
                Course aiimsBscNursing = createCourse(aiimsDelhi, "B.Sc", "Nursing", "UG", 4,
                                "Bachelor of Science in Nursing", "NEET UG qualified with 12th PCB");
                createSeatMatrix(aiimsBscNursing, "GENERAL", 60, 8, "2026-27");
                createSeatMatrix(aiimsBscNursing, "OBC", 30, 4, "2026-27");
                createSeatMatrix(aiimsBscNursing, "SC", 15, 2, "2026-27");
                createSeatMatrix(aiimsBscNursing, "ST", 8, 1, "2026-27");
                createFeeStructure(aiimsBscNursing, "2026-27",
                                new BigDecimal("3000"), new BigDecimal("25000"), new BigDecimal("0"),
                                new BigDecimal("1500"), new BigDecimal("2000"), new BigDecimal("3500"),
                                new BigDecimal("35000"), "PER_YEAR");
                createCutoff(aiimsBscNursing, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.0"), null,
                                "NEET UG");

                // AIIMS Delhi - MD General Medicine
                Course aiimsMD = createCourse(aiimsDelhi, "MD", "General Medicine", "PG", 3,
                                "Doctor of Medicine in General Medicine", "MBBS with NEET PG qualified");
                createSeatMatrix(aiimsMD, "GENERAL", 20, 3, "2026-27");
                createSeatMatrix(aiimsMD, "OBC", 10, 2, "2026-27");
                createSeatMatrix(aiimsMD, "SC", 5, 1, "2026-27");
                createFeeStructure(aiimsMD, "2026-27",
                                new BigDecimal("10000"), new BigDecimal("30000"), new BigDecimal("0"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("55000"), "PER_YEAR");
                createCutoff(aiimsMD, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.9"), 50, "NEET PG");

                // AIIMS Delhi - MS Surgery
                Course aiimsMS = createCourse(aiimsDelhi, "MS", "General Surgery", "PG", 3,
                                "Master of Surgery in General Surgery", "MBBS with NEET PG qualified");
                createSeatMatrix(aiimsMS, "GENERAL", 15, 2, "2026-27");
                createSeatMatrix(aiimsMS, "OBC", 8, 1, "2026-27");
                createSeatMatrix(aiimsMS, "SC", 4, 1, "2026-27");
                createFeeStructure(aiimsMS, "2026-27",
                                new BigDecimal("10000"), new BigDecimal("30000"), new BigDecimal("0"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("55000"), "PER_YEAR");
                createCutoff(aiimsMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.85"), 80, "NEET PG");

                // AIIMS Delhi - MD Pediatrics
                Course aiimsMDPed = createCourse(aiimsDelhi, "MD", "Pediatrics", "PG", 3,
                                "Doctor of Medicine in Pediatrics", "MBBS with NEET PG qualified");
                createSeatMatrix(aiimsMDPed, "GENERAL", 12, 2, "2026-27");
                createSeatMatrix(aiimsMDPed, "OBC", 6, 1, "2026-27");
                createFeeStructure(aiimsMDPed, "2026-27",
                                new BigDecimal("10000"), new BigDecimal("30000"), new BigDecimal("0"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("55000"), "PER_YEAR");
                createCutoff(aiimsMDPed, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.8"), 100, "NEET PG");

                // AIIMS Delhi - M.Sc Anatomy
                Course aiimsMscAnatomy = createCourse(aiimsDelhi, "M.Sc", "Anatomy", "PG", 2,
                                "Master of Science in Anatomy", "B.Sc with 55% / AIIMS entrance");
                createSeatMatrix(aiimsMscAnatomy, "GENERAL", 10, 3, "2026-27");
                createSeatMatrix(aiimsMscAnatomy, "OBC", 5, 2, "2026-27");
                createFeeStructure(aiimsMscAnatomy, "2026-27",
                                new BigDecimal("5000"), new BigDecimal("25000"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("40000"), "PER_YEAR");

                // AIIMS Delhi - Ph.D Medical Sciences
                Course aiimsPhd = createCourse(aiimsDelhi, "Ph.D", "Medical Sciences", "Doctoral", 3,
                                "Doctor of Philosophy in Medical Sciences", "MD/MS with research aptitude");
                createSeatMatrix(aiimsPhd, "GENERAL", 8, 3, "2026-27");
                createSeatMatrix(aiimsPhd, "OBC", 4, 2, "2026-27");
                createFeeStructure(aiimsPhd, "2026-27",
                                new BigDecimal("8000"), new BigDecimal("30000"), new BigDecimal("0"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("4000"),
                                new BigDecimal("50000"), "PER_YEAR");

                // Delhi University - SRCC
                College srcc = createCollege(
                                "Shri Ram College of Commerce",
                                "SRCC is one of India's most prestigious commerce colleges under Delhi University.",
                                "GOVERNMENT",
                                "New Delhi",
                                "Delhi",
                                "Maurice Nagar, Delhi University, North Campus, Delhi 110007",
                                "110007",
                                "011-27667891",
                                "principal@srcc.du.ac.in",
                                "https://www.srcc.du.ac.in",
                                "A++",
                                true,
                                1926,
                                "Delhi University");

                Course bcom = createCourse(srcc, "B.Com (Hons)", "Commerce", "UG", 3,
                                "Bachelor of Commerce Honours", "12th pass with 60% minimum");

                createSeatMatrix(bcom, "GENERAL", 200, 20, "2026-27");
                createSeatMatrix(bcom, "OBC", 100, 10, "2026-27");

                createFeeStructure(bcom, "2026-27",
                                new BigDecimal("15000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1000"), new BigDecimal("500"), new BigDecimal("2000"),
                                new BigDecimal("18500"), "PER_YEAR");

                createCutoff(bcom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.0"), null, "CUET");
                createCutoff(bcom, "OBC", "2023-2024", "Round 1", new BigDecimal("97.5"), null, "CUET");

                // SRCC - BA Economics (Hons)
                Course srccBAEco = createCourse(srcc, "BA (Hons)", "Economics", "UG", 3,
                                "Bachelor of Arts Honours in Economics", "12th pass with 60% / CUET qualified");
                createSeatMatrix(srccBAEco, "GENERAL", 150, 15, "2026-27");
                createSeatMatrix(srccBAEco, "OBC", 75, 8, "2026-27");
                createSeatMatrix(srccBAEco, "SC", 35, 5, "2026-27");
                createFeeStructure(srccBAEco, "2026-27",
                                new BigDecimal("15000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1000"), new BigDecimal("500"), new BigDecimal("2000"),
                                new BigDecimal("18500"), "PER_YEAR");
                createCutoff(srccBAEco, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.5"), null, "CUET");

                // SRCC - M.Com
                Course srccMCom = createCourse(srcc, "M.Com", "Commerce", "PG", 2,
                                "Master of Commerce", "B.Com with 60% / CUET PG qualified");
                createSeatMatrix(srccMCom, "GENERAL", 80, 10, "2026-27");
                createSeatMatrix(srccMCom, "OBC", 40, 5, "2026-27");
                createFeeStructure(srccMCom, "2026-27",
                                new BigDecimal("18000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1500"), new BigDecimal("500"), new BigDecimal("2500"),
                                new BigDecimal("22500"), "PER_YEAR");
                createCutoff(srccMCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.0"), null, "CUET PG");

                // SRCC - MA Economics
                Course srccMAEco = createCourse(srcc, "MA", "Economics", "PG", 2,
                                "Master of Arts in Economics", "BA Economics with 55% / CUET PG qualified");
                createSeatMatrix(srccMAEco, "GENERAL", 50, 8, "2026-27");
                createSeatMatrix(srccMAEco, "OBC", 25, 4, "2026-27");
                createFeeStructure(srccMAEco, "2026-27",
                                new BigDecimal("18000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1500"), new BigDecimal("500"), new BigDecimal("2500"),
                                new BigDecimal("22500"), "PER_YEAR");
                createCutoff(srccMAEco, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.0"), null, "CUET PG");

                // SRCC - B.Com
                Course srccBCom = createCourse(srcc, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th pass with 55% / CUET qualified");
                createSeatMatrix(srccBCom, "GENERAL", 180, 20, "2026-27");
                createSeatMatrix(srccBCom, "OBC", 90, 10, "2026-27");
                createSeatMatrix(srccBCom, "SC", 45, 6, "2026-27");
                createFeeStructure(srccBCom, "2026-27",
                                new BigDecimal("12000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1000"), new BigDecimal("500"), new BigDecimal("1500"),
                                new BigDecimal("15000"), "PER_YEAR");
                createCutoff(srccBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.0"), null, "CUET");

                // Amity University Noida
                College amity = createCollege(
                                "Amity University Noida",
                                "Amity University is a leading private research university offering diverse programs.",
                                "PRIVATE",
                                "Noida",
                                "Uttar Pradesh",
                                "Sector 125, Noida, Uttar Pradesh 201313",
                                "201313",
                                "0120-4392000",
                                "info@amity.edu",
                                "https://www.amity.edu",
                                "A+",
                                true,
                                2005,
                                "UGC Approved");

                Course btechAI = createCourse(amity, "B.Tech", "Artificial Intelligence", "UG", 4,
                                "Bachelor of Technology in Artificial Intelligence", "12th with 60% in PCM");

                createSeatMatrix(btechAI, "GENERAL", 120, 30, "2026-27");
                createSeatMatrix(btechAI, "MANAGEMENT", 60, 15, "2026-27");

                createFeeStructure(btechAI, "2026-27",
                                new BigDecimal("350000"), new BigDecimal("100000"), new BigDecimal("25000"),
                                new BigDecimal("10000"), new BigDecimal("15000"), new BigDecimal("20000"),
                                new BigDecimal("520000"), "PER_YEAR");
                createCutoff(btechAI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("80.0"), null, "Amity JEE");

                // Amity - B.Tech CSE
                Course amityBtechCSE = createCourse(amity, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 60% in PCM / JEE Main");
                createSeatMatrix(amityBtechCSE, "GENERAL", 180, 40, "2026-27");
                createSeatMatrix(amityBtechCSE, "MANAGEMENT", 90, 20, "2026-27");
                createFeeStructure(amityBtechCSE, "2026-27",
                                new BigDecimal("340000"), new BigDecimal("100000"), new BigDecimal("25000"),
                                new BigDecimal("10000"), new BigDecimal("15000"), new BigDecimal("20000"),
                                new BigDecimal("510000"), "PER_YEAR");
                createCutoff(amityBtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("78.0"), null,
                                "Amity JEE");

                // Amity - BBA
                Course amityBBA = createCourse(amity, "BBA", "Business Administration", "UG", 3,
                                "Bachelor of Business Administration", "12th pass with 55%");
                createSeatMatrix(amityBBA, "GENERAL", 200, 50, "2026-27");
                createSeatMatrix(amityBBA, "MANAGEMENT", 100, 25, "2026-27");
                createFeeStructure(amityBBA, "2026-27",
                                new BigDecimal("250000"), new BigDecimal("90000"), new BigDecimal("20000"),
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("15000"),
                                new BigDecimal("383000"), "PER_YEAR");
                createCutoff(amityBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), null, "Merit Based");

                // Amity - BCA
                Course amityBCA = createCourse(amity, "BCA", "Computer Applications", "UG", 3,
                                "Bachelor of Computer Applications", "12th pass with 55%");
                createSeatMatrix(amityBCA, "GENERAL", 150, 35, "2026-27");
                createSeatMatrix(amityBCA, "MANAGEMENT", 75, 18, "2026-27");
                createFeeStructure(amityBCA, "2026-27",
                                new BigDecimal("220000"), new BigDecimal("90000"), new BigDecimal("20000"),
                                new BigDecimal("8000"), new BigDecimal("10000"), new BigDecimal("12000"),
                                new BigDecimal("360000"), "PER_YEAR");
                createCutoff(amityBCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "Merit Based");

                // Amity - MBA
                Course amityMBA = createCourse(amity, "MBA", "Business Administration", "PG", 2,
                                "Master of Business Administration", "Graduation with 50% / CAT / MAT qualified");
                createSeatMatrix(amityMBA, "GENERAL", 120, 25, "2026-27");
                createSeatMatrix(amityMBA, "MANAGEMENT", 60, 15, "2026-27");
                createFeeStructure(amityMBA, "2026-27",
                                new BigDecimal("500000"), new BigDecimal("100000"), new BigDecimal("20000"),
                                new BigDecimal("10000"), new BigDecimal("0"), new BigDecimal("20000"),
                                new BigDecimal("650000"), "PER_YEAR");
                createCutoff(amityMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), null, "CAT / MAT");

                // Amity - B.Com
                Course amityBCom = createCourse(amity, "B.Com (Hons)", "Commerce", "UG", 3,
                                "Bachelor of Commerce Honours", "12th pass with 55% in Commerce");
                createSeatMatrix(amityBCom, "GENERAL", 120, 30, "2026-27");
                createSeatMatrix(amityBCom, "MANAGEMENT", 60, 15, "2026-27");
                createFeeStructure(amityBCom, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("90000"), new BigDecimal("20000"),
                                new BigDecimal("5000"), new BigDecimal("0"), new BigDecimal("10000"),
                                new BigDecimal("325000"), "PER_YEAR");
                createCutoff(amityBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "Merit Based");

                // Amity - BA Journalism
                Course amityBAJourn = createCourse(amity, "BA", "Journalism and Mass Communication", "UG", 3,
                                "Bachelor of Arts in Journalism and Mass Communication", "12th pass with 50%");
                createSeatMatrix(amityBAJourn, "GENERAL", 100, 25, "2026-27");
                createSeatMatrix(amityBAJourn, "MANAGEMENT", 50, 12, "2026-27");
                createFeeStructure(amityBAJourn, "2026-27",
                                new BigDecimal("230000"), new BigDecimal("90000"), new BigDecimal("20000"),
                                new BigDecimal("5000"), new BigDecimal("0"), new BigDecimal("10000"),
                                new BigDecimal("355000"), "PER_YEAR");
                createCutoff(amityBAJourn, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "Merit Based");

                // Amity - MCA
                Course amityMCA = createCourse(amity, "MCA", "Computer Applications", "PG", 2,
                                "Master of Computer Applications", "BCA/B.Sc CS with 50%");
                createSeatMatrix(amityMCA, "GENERAL", 80, 20, "2026-27");
                createSeatMatrix(amityMCA, "MANAGEMENT", 40, 10, "2026-27");
                createFeeStructure(amityMCA, "2026-27",
                                new BigDecimal("280000"), new BigDecimal("90000"), new BigDecimal("20000"),
                                new BigDecimal("8000"), new BigDecimal("10000"), new BigDecimal("12000"),
                                new BigDecimal("420000"), "PER_YEAR");
                createCutoff(amityMCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "Merit Based");

                // Amity - BA LLB
                Course amityBALLB = createCourse(amity, "BA LLB", "Law", "UG", 5,
                                "Bachelor of Arts and Bachelor of Laws (Integrated)",
                                "12th pass with 50% / CLAT qualified");
                createSeatMatrix(amityBALLB, "GENERAL", 100, 20, "2026-27");
                createSeatMatrix(amityBALLB, "MANAGEMENT", 50, 12, "2026-27");
                createFeeStructure(amityBALLB, "2026-27",
                                new BigDecimal("300000"), new BigDecimal("90000"), new BigDecimal("20000"),
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("12000"),
                                new BigDecimal("430000"), "PER_YEAR");
                createCutoff(amityBALLB, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), null,
                                "CLAT / Merit");

                // Manipal University
                College manipal = createCollege(
                                "Manipal Institute of Technology",
                                "MIT Manipal is a constituent institute of MAHE offering quality technical education.",
                                "PRIVATE",
                                "Manipal",
                                "Karnataka",
                                "Manipal, Karnataka 576104",
                                "576104",
                                "0820-2925100",
                                "mit@manipal.edu",
                                "https://www.manipal.edu/mit.html",
                                "A+",
                                true,
                                1957,
                                "MAHE");

                Course btechMech = createCourse(manipal, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "JEE Main / MET qualified");

                createSeatMatrix(btechMech, "GENERAL", 180, 40, "2026-27");

                createFeeStructure(btechMech, "2026-27",
                                new BigDecimal("320000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("8000"), new BigDecimal("12000"), new BigDecimal("15000"),
                                new BigDecimal("450000"), "PER_YEAR");
                createCutoff(btechMech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), null, "MET");

                // Manipal - B.Tech CSE
                Course manipalCSE = createCourse(manipal, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / MET qualified");
                createSeatMatrix(manipalCSE, "GENERAL", 200, 45, "2026-27");
                createFeeStructure(manipalCSE, "2026-27",
                                new BigDecimal("350000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("8000"), new BigDecimal("12000"), new BigDecimal("15000"),
                                new BigDecimal("480000"), "PER_YEAR");
                createCutoff(manipalCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), null, "MET");

                // Manipal - B.Tech ECE
                Course manipalECE = createCourse(manipal, "B.Tech", "Electronics and Communication Engineering", "UG",
                                4,
                                "Bachelor of Technology in ECE", "JEE Main / MET qualified");
                createSeatMatrix(manipalECE, "GENERAL", 160, 35, "2026-27");
                createFeeStructure(manipalECE, "2026-27",
                                new BigDecimal("330000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("8000"), new BigDecimal("12000"), new BigDecimal("15000"),
                                new BigDecimal("460000"), "PER_YEAR");
                createCutoff(manipalECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("87.0"), null, "MET");

                // Manipal - B.Tech Civil
                Course manipalCivil = createCourse(manipal, "B.Tech", "Civil Engineering", "UG", 4,
                                "Bachelor of Technology in Civil Engineering", "JEE Main / MET qualified");
                createSeatMatrix(manipalCivil, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(manipalCivil, "2026-27",
                                new BigDecimal("310000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("8000"), new BigDecimal("12000"), new BigDecimal("15000"),
                                new BigDecimal("440000"), "PER_YEAR");
                createCutoff(manipalCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("82.0"), null, "MET");

                // Manipal - B.Tech IT
                Course manipalIT = createCourse(manipal, "B.Tech", "Information Technology", "UG", 4,
                                "Bachelor of Technology in Information Technology", "JEE Main / MET qualified");
                createSeatMatrix(manipalIT, "GENERAL", 150, 35, "2026-27");
                createFeeStructure(manipalIT, "2026-27",
                                new BigDecimal("340000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("8000"), new BigDecimal("12000"), new BigDecimal("15000"),
                                new BigDecimal("470000"), "PER_YEAR");
                createCutoff(manipalIT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("88.0"), null, "MET");

                // Manipal - MBA
                Course manipalMBA = createCourse(manipal, "MBA", "Business Administration", "PG", 2,
                                "Master of Business Administration", "Graduation with 50% / CAT / MAT / XAT");
                createSeatMatrix(manipalMBA, "GENERAL", 120, 25, "2026-27");
                createFeeStructure(manipalMBA, "2026-27",
                                new BigDecimal("800000"), new BigDecimal("90000"), new BigDecimal("15000"),
                                new BigDecimal("10000"), new BigDecimal("0"), new BigDecimal("25000"),
                                new BigDecimal("940000"), "PER_YEAR");
                createCutoff(manipalMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("80.0"), null, "CAT / MAT");

                // Manipal - BBA
                Course manipalBBA = createCourse(manipal, "BBA", "Business Administration", "UG", 3,
                                "Bachelor of Business Administration", "12th pass with 50%");
                createSeatMatrix(manipalBBA, "GENERAL", 100, 25, "2026-27");
                createFeeStructure(manipalBBA, "2026-27",
                                new BigDecimal("280000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("0"), new BigDecimal("10000"),
                                new BigDecimal("390000"), "PER_YEAR");
                createCutoff(manipalBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), null,
                                "Merit Based");

                // Manipal - M.Tech CSE
                Course manipalMtechCSE = createCourse(manipal, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in CSE", "B.Tech/BE with 55% / GATE qualified");
                createSeatMatrix(manipalMtechCSE, "GENERAL", 40, 10, "2026-27");
                createFeeStructure(manipalMtechCSE, "2026-27",
                                new BigDecimal("250000"), new BigDecimal("80000"), new BigDecimal("15000"),
                                new BigDecimal("8000"), new BigDecimal("10000"), new BigDecimal("12000"),
                                new BigDecimal("375000"), "PER_YEAR");
                createCutoff(manipalMtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("75.0"), null,
                                "GATE / MET");

                // NIT Trichy
                College nitTrichy = createCollege(
                                "National Institute of Technology Tiruchirappalli",
                                "NIT Trichy is one of the top NITs in India known for engineering excellence.",
                                "GOVERNMENT",
                                "Tiruchirappalli",
                                "Tamil Nadu",
                                "Tanjore Main Road, National Highway 67, Tiruchirappalli, Tamil Nadu 620015",
                                "620015",
                                "0431-2503000",
                                "director@nitt.edu",
                                "https://www.nitt.edu",
                                "A++",
                                true,
                                1964,
                                "NIT System");

                Course btechECE = createCourse(nitTrichy, "B.Tech", "Electronics and Communication Engineering", "UG",
                                4,
                                "Bachelor of Technology in ECE", "JEE Main qualified");

                createSeatMatrix(btechECE, "GENERAL", 80, 15, "2026-27");
                createSeatMatrix(btechECE, "OBC", 40, 8, "2026-27");

                createFeeStructure(btechECE, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("210000"), "PER_YEAR");
                createCutoff(btechECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.5"), 5000, "JEE Main");
                createCutoff(btechECE, "OBC", "2023-2024", "Round 1", new BigDecimal("95.0"), 12000, "JEE Main");

                // NIT Trichy - B.Tech CSE
                Course nitCSE = createCourse(nitTrichy, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(nitCSE, "GENERAL", 70, 12, "2026-27");
                createSeatMatrix(nitCSE, "OBC", 35, 6, "2026-27");
                createSeatMatrix(nitCSE, "SC", 18, 3, "2026-27");
                createSeatMatrix(nitCSE, "ST", 10, 2, "2026-27");
                createFeeStructure(nitCSE, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("210000"), "PER_YEAR");
                createCutoff(nitCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.5"), 3000, "JEE Main");
                createCutoff(nitCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("96.5"), 8000, "JEE Main");

                // NIT Trichy - B.Tech Mechanical
                Course nitMech = createCourse(nitTrichy, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "JEE Main qualified");
                createSeatMatrix(nitMech, "GENERAL", 75, 15, "2026-27");
                createSeatMatrix(nitMech, "OBC", 38, 7, "2026-27");
                createSeatMatrix(nitMech, "SC", 18, 3, "2026-27");
                createFeeStructure(nitMech, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("210000"), "PER_YEAR");
                createCutoff(nitMech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.0"), 8000, "JEE Main");

                // NIT Trichy - B.Tech Civil
                Course nitCivil = createCourse(nitTrichy, "B.Tech", "Civil Engineering", "UG", 4,
                                "Bachelor of Technology in Civil Engineering", "JEE Main qualified");
                createSeatMatrix(nitCivil, "GENERAL", 65, 14, "2026-27");
                createSeatMatrix(nitCivil, "OBC", 32, 6, "2026-27");
                createSeatMatrix(nitCivil, "SC", 16, 3, "2026-27");
                createFeeStructure(nitCivil, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("210000"), "PER_YEAR");
                createCutoff(nitCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("94.5"), 12000, "JEE Main");

                // NIT Trichy - B.Tech EEE
                Course nitEEE = createCourse(nitTrichy, "B.Tech", "Electrical and Electronics Engineering", "UG", 4,
                                "Bachelor of Technology in EEE", "JEE Main qualified");
                createSeatMatrix(nitEEE, "GENERAL", 70, 13, "2026-27");
                createSeatMatrix(nitEEE, "OBC", 35, 6, "2026-27");
                createSeatMatrix(nitEEE, "SC", 17, 3, "2026-27");
                createFeeStructure(nitEEE, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("210000"), "PER_YEAR");
                createCutoff(nitEEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.5"), 7000, "JEE Main");

                // NIT Trichy - M.Tech CSE
                Course nitMtechCSE = createCourse(nitTrichy, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in CSE", "B.Tech/BE with GATE qualified");
                createSeatMatrix(nitMtechCSE, "GENERAL", 25, 5, "2026-27");
                createSeatMatrix(nitMtechCSE, "OBC", 12, 3, "2026-27");
                createSeatMatrix(nitMtechCSE, "SC", 6, 2, "2026-27");
                createFeeStructure(nitMtechCSE, "2026-27",
                                new BigDecimal("80000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("6000"), new BigDecimal("5000"),
                                new BigDecimal("136000"), "PER_YEAR");
                createCutoff(nitMtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), 500, "GATE");

                // NIT Trichy - MBA
                Course nitMBA = createCourse(nitTrichy, "MBA", "Business Administration", "PG", 2,
                                "Master of Business Administration", "CAT / GATE qualified with graduation");
                createSeatMatrix(nitMBA, "GENERAL", 60, 10, "2026-27");
                createSeatMatrix(nitMBA, "OBC", 30, 5, "2026-27");
                createFeeStructure(nitMBA, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("0"), new BigDecimal("10000"),
                                new BigDecimal("255000"), "PER_YEAR");
                createCutoff(nitMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), null, "CAT");

                // NIT Trichy - Ph.D
                Course nitPhd = createCourse(nitTrichy, "Ph.D", "Engineering", "Doctoral", 4,
                                "Doctor of Philosophy in Engineering", "M.Tech/ME with GATE/NET qualified");
                createSeatMatrix(nitPhd, "GENERAL", 20, 8, "2026-27");
                createSeatMatrix(nitPhd, "OBC", 10, 4, "2026-27");
                createFeeStructure(nitPhd, "2026-27",
                                new BigDecimal("50000"), new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("5000"),
                                new BigDecimal("105000"), "PER_YEAR");

                // IIM Ahmedabad
                College iimA = createCollege(
                                "Indian Institute of Management Ahmedabad",
                                "IIM Ahmedabad is India's premier business school offering world-class management education.",
                                "GOVERNMENT",
                                "Ahmedabad",
                                "Gujarat",
                                "Vastrapur, Ahmedabad, Gujarat 380015",
                                "380015",
                                "079-66324321",
                                "info@iima.ac.in",
                                "https://www.iima.ac.in",
                                "A++",
                                true,
                                1961,
                                "Autonomous");

                Course mba = createCourse(iimA, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT qualified with work experience");

                createSeatMatrix(mba, "GENERAL", 250, 30, "2026-27");

                createFeeStructure(mba, "2026-27",
                                new BigDecimal("1600000"), new BigDecimal("100000"), new BigDecimal("0"),
                                new BigDecimal("25000"), new BigDecimal("0"), new BigDecimal("75000"),
                                new BigDecimal("1800000"), "PER_YEAR");

                createCutoff(mba, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.5"), null, "CAT");
                createCutoff(mba, "OBC", "2023-2024", "Round 1", new BigDecimal("98.0"), null, "CAT");

                // IIM Ahmedabad - MBA HR
                Course iimMBAHR = createCourse(iimA, "MBA", "Human Resource Management", "PG", 2,
                                "MBA in Human Resource Management", "CAT qualified with work experience");
                createSeatMatrix(iimMBAHR, "GENERAL", 60, 8, "2026-27");
                createSeatMatrix(iimMBAHR, "OBC", 30, 4, "2026-27");
                createFeeStructure(iimMBAHR, "2026-27",
                                new BigDecimal("1600000"), new BigDecimal("100000"), new BigDecimal("0"),
                                new BigDecimal("25000"), new BigDecimal("0"), new BigDecimal("75000"),
                                new BigDecimal("1800000"), "PER_YEAR");
                createCutoff(iimMBAHR, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.0"), null, "CAT");

                // IIM Ahmedabad - MBA Finance
                Course iimMBAFin = createCourse(iimA, "MBA", "Finance", "PG", 2,
                                "MBA in Finance", "CAT qualified with work experience");
                createSeatMatrix(iimMBAFin, "GENERAL", 80, 10, "2026-27");
                createSeatMatrix(iimMBAFin, "OBC", 40, 5, "2026-27");
                createFeeStructure(iimMBAFin, "2026-27",
                                new BigDecimal("1600000"), new BigDecimal("100000"), new BigDecimal("0"),
                                new BigDecimal("25000"), new BigDecimal("0"), new BigDecimal("75000"),
                                new BigDecimal("1800000"), "PER_YEAR");
                createCutoff(iimMBAFin, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.2"), null, "CAT");

                // IIM Ahmedabad - MBA Marketing
                Course iimMBAMkt = createCourse(iimA, "MBA", "Marketing", "PG", 2,
                                "MBA in Marketing Management", "CAT qualified with work experience");
                createSeatMatrix(iimMBAMkt, "GENERAL", 70, 8, "2026-27");
                createSeatMatrix(iimMBAMkt, "OBC", 35, 4, "2026-27");
                createFeeStructure(iimMBAMkt, "2026-27",
                                new BigDecimal("1600000"), new BigDecimal("100000"), new BigDecimal("0"),
                                new BigDecimal("25000"), new BigDecimal("0"), new BigDecimal("75000"),
                                new BigDecimal("1800000"), "PER_YEAR");
                createCutoff(iimMBAMkt, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.0"), null, "CAT");

                // IIM Ahmedabad - Executive MBA
                Course iimEMBA = createCourse(iimA, "Executive MBA", "Management", "PG", 1,
                                "Executive MBA for Working Professionals", "5+ years work experience with graduation");
                createSeatMatrix(iimEMBA, "GENERAL", 50, 10, "2026-27");
                createFeeStructure(iimEMBA, "2026-27",
                                new BigDecimal("2800000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("30000"), new BigDecimal("0"), new BigDecimal("100000"),
                                new BigDecimal("2930000"), "PER_YEAR");

                // IIM Ahmedabad - Ph.D Management
                Course iimPhd = createCourse(iimA, "Ph.D", "Management", "Doctoral", 4,
                                "Fellow Programme in Management (Ph.D equivalent)", "CAT/GMAT with MBA/PG degree");
                createSeatMatrix(iimPhd, "GENERAL", 15, 5, "2026-27");
                createSeatMatrix(iimPhd, "OBC", 8, 3, "2026-27");
                createFeeStructure(iimPhd, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("80000"), new BigDecimal("0"),
                                new BigDecimal("15000"), new BigDecimal("0"), new BigDecimal("30000"),
                                new BigDecimal("325000"), "PER_YEAR");

                // Jadavpur University
                College jadavpur = createCollege(
                                "Jadavpur University",
                                "Jadavpur University is a premier state university in West Bengal known for engineering and arts.",
                                "GOVERNMENT",
                                "Kolkata",
                                "West Bengal",
                                "188, Raja S.C. Mallick Road, Kolkata, West Bengal 700032",
                                "700032",
                                "033-24146666",
                                "registrar@jadavpuruniversity.in",
                                "http://www.jadavpuruniversity.in",
                                "A+",
                                true,
                                1955,
                                "State University");

                Course btechCivil = createCourse(jadavpur, "B.Tech", "Civil Engineering", "UG", 4,
                                "Bachelor of Technology in Civil Engineering", "WBJEE qualified");

                createSeatMatrix(btechCivil, "GENERAL", 60, 12, "2026-27");

                createFeeStructure(btechCivil, "2026-27",
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("2000"),
                                new BigDecimal("15000"), "PER_YEAR");
                createCutoff(btechCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("92.0"), null, "WBJEE");

                // Jadavpur - B.Tech CSE
                Course jadCSE = createCourse(jadavpur, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "WBJEE qualified");
                createSeatMatrix(jadCSE, "GENERAL", 55, 10, "2026-27");
                createSeatMatrix(jadCSE, "OBC", 28, 5, "2026-27");
                createSeatMatrix(jadCSE, "SC", 14, 3, "2026-27");
                createSeatMatrix(jadCSE, "ST", 7, 2, "2026-27");
                createFeeStructure(jadCSE, "2026-27",
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("2000"),
                                new BigDecimal("15000"), "PER_YEAR");
                createCutoff(jadCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.0"), 200, "WBJEE");
                createCutoff(jadCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("96.0"), 500, "WBJEE");

                // Jadavpur - B.Tech ECE
                Course jadECE = createCourse(jadavpur, "B.Tech", "Electronics and Telecommunication Engineering", "UG",
                                4,
                                "Bachelor of Technology in ETCE", "WBJEE qualified");
                createSeatMatrix(jadECE, "GENERAL", 50, 10, "2026-27");
                createSeatMatrix(jadECE, "OBC", 25, 5, "2026-27");
                createSeatMatrix(jadECE, "SC", 12, 3, "2026-27");
                createFeeStructure(jadECE, "2026-27",
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("2000"),
                                new BigDecimal("15000"), "PER_YEAR");
                createCutoff(jadECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.0"), 350, "WBJEE");

                // Jadavpur - B.Tech Mechanical
                Course jadMech = createCourse(jadavpur, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "WBJEE qualified");
                createSeatMatrix(jadMech, "GENERAL", 55, 12, "2026-27");
                createSeatMatrix(jadMech, "OBC", 28, 5, "2026-27");
                createSeatMatrix(jadMech, "SC", 14, 3, "2026-27");
                createFeeStructure(jadMech, "2026-27",
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("2000"),
                                new BigDecimal("15000"), "PER_YEAR");
                createCutoff(jadMech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("95.0"), 600, "WBJEE");

                // Jadavpur - BA English
                Course jadBAEng = createCourse(jadavpur, "BA", "English", "UG", 3,
                                "Bachelor of Arts in English", "12th pass with 55%");
                createSeatMatrix(jadBAEng, "GENERAL", 80, 15, "2026-27");
                createSeatMatrix(jadBAEng, "OBC", 40, 8, "2026-27");
                createSeatMatrix(jadBAEng, "SC", 20, 5, "2026-27");
                createFeeStructure(jadBAEng, "2026-27",
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1000"), new BigDecimal("0"), new BigDecimal("1500"),
                                new BigDecimal("5500"), "PER_YEAR");
                createCutoff(jadBAEng, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), null, "Merit Based");

                // Jadavpur - B.Sc Physics
                Course jadBscPhy = createCourse(jadavpur, "B.Sc", "Physics", "UG", 3,
                                "Bachelor of Science in Physics", "12th with 60% in Science");
                createSeatMatrix(jadBscPhy, "GENERAL", 60, 12, "2026-27");
                createSeatMatrix(jadBscPhy, "OBC", 30, 6, "2026-27");
                createSeatMatrix(jadBscPhy, "SC", 15, 4, "2026-27");
                createFeeStructure(jadBscPhy, "2026-27",
                                new BigDecimal("4000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1500"), new BigDecimal("2000"), new BigDecimal("1500"),
                                new BigDecimal("9000"), "PER_YEAR");
                createCutoff(jadBscPhy, "GENERAL", "2023-2024", "Round 1", new BigDecimal("88.0"), null, "Merit Based");

                // Jadavpur - M.Tech CSE
                Course jadMtechCSE = createCourse(jadavpur, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in CSE", "B.Tech/BE with GATE qualified");
                createSeatMatrix(jadMtechCSE, "GENERAL", 25, 5, "2026-27");
                createSeatMatrix(jadMtechCSE, "OBC", 12, 3, "2026-27");
                createFeeStructure(jadMtechCSE, "2026-27",
                                new BigDecimal("10000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("2000"),
                                new BigDecimal("17000"), "PER_YEAR");
                createCutoff(jadMtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), 800, "GATE");

                // Jadavpur - MA English
                Course jadMAEng = createCourse(jadavpur, "MA", "English", "PG", 2,
                                "Master of Arts in English", "BA English with 55%");
                createSeatMatrix(jadMAEng, "GENERAL", 40, 8, "2026-27");
                createSeatMatrix(jadMAEng, "OBC", 20, 4, "2026-27");
                createFeeStructure(jadMAEng, "2026-27",
                                new BigDecimal("4000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("1000"), new BigDecimal("0"), new BigDecimal("1500"),
                                new BigDecimal("6500"), "PER_YEAR");
                createCutoff(jadMAEng, "GENERAL", "2023-2024", "Round 1", new BigDecimal("75.0"), null, "Merit Based");

                // Jadavpur - Ph.D Engineering
                Course jadPhd = createCourse(jadavpur, "Ph.D", "Engineering", "Doctoral", 4,
                                "Doctor of Philosophy in Engineering", "M.Tech/ME with GATE/NET qualified");
                createSeatMatrix(jadPhd, "GENERAL", 15, 5, "2026-27");
                createSeatMatrix(jadPhd, "OBC", 8, 3, "2026-27");
                createFeeStructure(jadPhd, "2026-27",
                                new BigDecimal("8000"), new BigDecimal("0"), new BigDecimal("0"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("2000"),
                                new BigDecimal("15000"), "PER_YEAR");

                // Lovely Professional University
                College lpu = createCollege(
                                "Lovely Professional University",
                                "LPU is one of India's largest private universities offering diverse programs.",
                                "PRIVATE",
                                "Phagwara",
                                "Punjab",
                                "Jalandhar-Delhi G.T. Road, Phagwara, Punjab 144411",
                                "144411",
                                "01824-517000",
                                "info@lpu.co.in",
                                "https://www.lpu.in",
                                "A",
                                true,
                                2005,
                                "UGC Approved");

                Course bba = createCourse(lpu, "BBA", "Business Administration", "UG", 3,
                                "Bachelor of Business Administration", "12th pass");

                createSeatMatrix(bba, "GENERAL", 300, 100, "2026-27");

                createFeeStructure(bba, "2026-27",
                                new BigDecimal("180000"), new BigDecimal("60000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("275000"), "PER_YEAR");
                createCutoff(bba, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "Merit Based");

                // LPU - B.Tech CSE
                Course lpuCSE = createCourse(lpu, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 60% in PCM / JEE Main / LPUNEST");
                createSeatMatrix(lpuCSE, "GENERAL", 500, 120, "2026-27");
                createSeatMatrix(lpuCSE, "MANAGEMENT", 250, 60, "2026-27");
                createFeeStructure(lpuCSE, "2026-27",
                                new BigDecimal("220000"), new BigDecimal("70000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("330000"), "PER_YEAR");
                createCutoff(lpuCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), null, "LPUNEST");

                // LPU - B.Tech ECE
                Course lpuECE = createCourse(lpu, "B.Tech", "Electronics and Communication Engineering", "UG", 4,
                                "Bachelor of Technology in ECE", "12th with 60% in PCM / JEE Main / LPUNEST");
                createSeatMatrix(lpuECE, "GENERAL", 300, 80, "2026-27");
                createSeatMatrix(lpuECE, "MANAGEMENT", 150, 40, "2026-27");
                createFeeStructure(lpuECE, "2026-27",
                                new BigDecimal("210000"), new BigDecimal("70000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("320000"), "PER_YEAR");
                createCutoff(lpuECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), null, "LPUNEST");

                // LPU - B.Tech Mechanical
                Course lpuMech = createCourse(lpu, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "12th with 60% in PCM / LPUNEST");
                createSeatMatrix(lpuMech, "GENERAL", 250, 70, "2026-27");
                createSeatMatrix(lpuMech, "MANAGEMENT", 120, 35, "2026-27");
                createFeeStructure(lpuMech, "2026-27",
                                new BigDecimal("200000"), new BigDecimal("70000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                                new BigDecimal("310000"), "PER_YEAR");
                createCutoff(lpuMech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "LPUNEST");

                // LPU - MBA
                Course lpuMBA = createCourse(lpu, "MBA", "Business Administration", "PG", 2,
                                "Master of Business Administration", "Graduation with 50% / CAT / MAT / LPUNEST");
                createSeatMatrix(lpuMBA, "GENERAL", 200, 50, "2026-27");
                createSeatMatrix(lpuMBA, "MANAGEMENT", 100, 25, "2026-27");
                createFeeStructure(lpuMBA, "2026-27",
                                new BigDecimal("250000"), new BigDecimal("70000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("0"), new BigDecimal("10000"),
                                new BigDecimal("350000"), "PER_YEAR");
                createCutoff(lpuMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "CAT / MAT");

                // LPU - BCA
                Course lpuBCA = createCourse(lpu, "BCA", "Computer Applications", "UG", 3,
                                "Bachelor of Computer Applications", "12th pass with 50%");
                createSeatMatrix(lpuBCA, "GENERAL", 250, 70, "2026-27");
                createSeatMatrix(lpuBCA, "MANAGEMENT", 120, 35, "2026-27");
                createFeeStructure(lpuBCA, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("60000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("245000"), "PER_YEAR");
                createCutoff(lpuBCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "Merit Based");

                // LPU - B.Com
                Course lpuBCom = createCourse(lpu, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th pass with 50%");
                createSeatMatrix(lpuBCom, "GENERAL", 200, 60, "2026-27");
                createSeatMatrix(lpuBCom, "MANAGEMENT", 100, 30, "2026-27");
                createFeeStructure(lpuBCom, "2026-27",
                                new BigDecimal("120000"), new BigDecimal("60000"), new BigDecimal("15000"),
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("5000"),
                                new BigDecimal("203000"), "PER_YEAR");
                createCutoff(lpuBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit Based");

                // LPU - BA Journalism
                Course lpuBAJourn = createCourse(lpu, "BA", "Journalism and Mass Communication", "UG", 3,
                                "Bachelor of Arts in Journalism and Mass Communication", "12th pass with 50%");
                createSeatMatrix(lpuBAJourn, "GENERAL", 150, 45, "2026-27");
                createSeatMatrix(lpuBAJourn, "MANAGEMENT", 75, 20, "2026-27");
                createFeeStructure(lpuBAJourn, "2026-27",
                                new BigDecimal("140000"), new BigDecimal("60000"), new BigDecimal("15000"),
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("5000"),
                                new BigDecimal("223000"), "PER_YEAR");
                createCutoff(lpuBAJourn, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null,
                                "Merit Based");

                // LPU - MCA
                Course lpuMCA = createCourse(lpu, "MCA", "Computer Applications", "PG", 2,
                                "Master of Computer Applications", "BCA/B.Sc CS with 50% / LPUNEST");
                createSeatMatrix(lpuMCA, "GENERAL", 150, 40, "2026-27");
                createSeatMatrix(lpuMCA, "MANAGEMENT", 75, 20, "2026-27");
                createFeeStructure(lpuMCA, "2026-27",
                                new BigDecimal("180000"), new BigDecimal("65000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("280000"), "PER_YEAR");
                createCutoff(lpuMCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "LPUNEST");

                // LPU - M.Tech CSE
                Course lpuMtechCSE = createCourse(lpu, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in CSE", "B.Tech/BE with 55% / GATE / LPUNEST");
                createSeatMatrix(lpuMtechCSE, "GENERAL", 80, 20, "2026-27");
                createSeatMatrix(lpuMtechCSE, "MANAGEMENT", 40, 10, "2026-27");
                createFeeStructure(lpuMtechCSE, "2026-27",
                                new BigDecimal("190000"), new BigDecimal("65000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("8000"),
                                new BigDecimal("293000"), "PER_YEAR");
                createCutoff(lpuMtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null,
                                "GATE / LPUNEST");

                // LPU - B.Pharmacy
                Course lpuBPharm = createCourse(lpu, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy", "12th with 50% in PCB");
                createSeatMatrix(lpuBPharm, "GENERAL", 120, 30, "2026-27");
                createSeatMatrix(lpuBPharm, "MANAGEMENT", 60, 15, "2026-27");
                createFeeStructure(lpuBPharm, "2026-27",
                                new BigDecimal("160000"), new BigDecimal("65000"), new BigDecimal("15000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("260000"), "PER_YEAR");
                createCutoff(lpuBPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "LPUNEST");

                // LPU - Ph.D
                Course lpuPhd = createCourse(lpu, "Ph.D", "Various Disciplines", "Doctoral", 3,
                                "Doctor of Philosophy", "PG degree with 55% / NET/SET qualified");
                createSeatMatrix(lpuPhd, "GENERAL", 50, 20, "2026-27");
                createFeeStructure(lpuPhd, "2026-27",
                                new BigDecimal("100000"), new BigDecimal("60000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("5000"),
                                new BigDecimal("175000"), "PER_YEAR");

                // Sam Global University, Bhopal
                College samGlobal = createCollege(
                                "Sam Global University",
                                "Sam Global University is a private university in Bhopal offering quality education in engineering, management, and arts programs.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "NH-12, Sahpura, Bhopal, MP 462039",
                                "462039",
                                "0755-4350999",
                                "info@samglobaluniversity.ac.in",
                                "https://www.samglobaluniversity.ac.in",
                                "A",
                                true,
                                2010,
                                "UGC Approved");

                // B.Tech CSE
                Course samBtechCSE = createCourse(samGlobal, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in Computer Science and Engineering",
                                "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechCSE, "GENERAL", 120, 30, "2026-27");
                createSeatMatrix(samBtechCSE, "OBC", 60, 15, "2026-27");
                createSeatMatrix(samBtechCSE, "SC", 30, 8, "2026-27");
                createSeatMatrix(samBtechCSE, "ST", 15, 5, "2026-27");

                createFeeStructure(samBtechCSE, "2026-27",
                                new BigDecimal("150000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("240000"), "PER_YEAR");

                createCutoff(samBtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("75.0"), null, "MP DTE");
                createCutoff(samBtechCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("70.0"), null, "MP DTE");

                // MBA
                Course samMBA = createCourse(samGlobal, "MBA", "Business Administration", "PG", 2,
                                "Master of Business Administration", "Graduation with 50% / CAT / MAT qualified");

                createSeatMatrix(samMBA, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(samMBA, "OBC", 30, 10, "2026-27");

                createFeeStructure(samMBA, "2026-27",
                                new BigDecimal("120000"), new BigDecimal("50000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("5000"),
                                new BigDecimal("186000"), "PER_YEAR");

                // B.Sc Computer Science
                Course samBscCS = createCourse(samGlobal, "B.Sc", "Computer Science", "UG", 3,
                                "Bachelor of Science in Computer Science", "12th with 50% in Science");

                createSeatMatrix(samBscCS, "GENERAL", 80, 25, "2026-27");
                createSeatMatrix(samBscCS, "OBC", 40, 12, "2026-27");

                createFeeStructure(samBscCS, "2026-27",
                                new BigDecimal("50000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("3000"),
                                new BigDecimal("106000"), "PER_YEAR");

                createCutoff(samBscCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "MP DTE");
                createCutoff(samBscCS, "OBC", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "MP DTE");

                // B.Tech ECE
                Course samBtechECE = createCourse(samGlobal, "B.Tech", "Electronics and Communication Engineering",
                                "UG", 4,
                                "Bachelor of Technology in Electronics and Communication Engineering",
                                "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechECE, "GENERAL", 100, 25, "2026-27");
                createSeatMatrix(samBtechECE, "OBC", 50, 12, "2026-27");
                createSeatMatrix(samBtechECE, "SC", 25, 6, "2026-27");
                createSeatMatrix(samBtechECE, "ST", 10, 3, "2026-27");

                createFeeStructure(samBtechECE, "2026-27",
                                new BigDecimal("140000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("230000"), "PER_YEAR");

                createCutoff(samBtechECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("72.0"), null, "MP DTE");
                createCutoff(samBtechECE, "OBC", "2023-2024", "Round 1", new BigDecimal("67.0"), null, "MP DTE");

                // B.Tech Mechanical Engineering
                Course samBtechMech = createCourse(samGlobal, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechMech, "GENERAL", 90, 20, "2026-27");
                createSeatMatrix(samBtechMech, "OBC", 45, 10, "2026-27");
                createSeatMatrix(samBtechMech, "SC", 20, 5, "2026-27");
                createSeatMatrix(samBtechMech, "ST", 10, 3, "2026-27");

                createFeeStructure(samBtechMech, "2026-27",
                                new BigDecimal("130000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("220000"), "PER_YEAR");

                createCutoff(samBtechMech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("68.0"), null, "MP DTE");
                createCutoff(samBtechMech, "OBC", "2023-2024", "Round 1", new BigDecimal("63.0"), null, "MP DTE");

                // B.Tech Civil Engineering
                Course samBtechCivil = createCourse(samGlobal, "B.Tech", "Civil Engineering", "UG", 4,
                                "Bachelor of Technology in Civil Engineering", "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechCivil, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(samBtechCivil, "OBC", 30, 8, "2026-27");
                createSeatMatrix(samBtechCivil, "SC", 15, 4, "2026-27");
                createSeatMatrix(samBtechCivil, "ST", 8, 3, "2026-27");

                createFeeStructure(samBtechCivil, "2026-27",
                                new BigDecimal("120000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("7000"), new BigDecimal("6000"),
                                new BigDecimal("208000"), "PER_YEAR");

                createCutoff(samBtechCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), null, "MP DTE");
                createCutoff(samBtechCivil, "OBC", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "MP DTE");

                // B.Tech EEE
                Course samBtechEEE = createCourse(samGlobal, "B.Tech", "Electrical and Electronics Engineering", "UG",
                                4,
                                "Bachelor of Technology in Electrical and Electronics Engineering",
                                "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechEEE, "GENERAL", 80, 20, "2026-27");
                createSeatMatrix(samBtechEEE, "OBC", 40, 10, "2026-27");
                createSeatMatrix(samBtechEEE, "SC", 20, 5, "2026-27");
                createSeatMatrix(samBtechEEE, "ST", 10, 3, "2026-27");

                createFeeStructure(samBtechEEE, "2026-27",
                                new BigDecimal("135000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("225000"), "PER_YEAR");

                createCutoff(samBtechEEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), null, "MP DTE");
                createCutoff(samBtechEEE, "OBC", "2023-2024", "Round 1", new BigDecimal("65.0"), null, "MP DTE");

                // B.Tech IT
                Course samBtechIT = createCourse(samGlobal, "B.Tech", "Information Technology", "UG", 4,
                                "Bachelor of Technology in Information Technology", "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechIT, "GENERAL", 100, 25, "2026-27");
                createSeatMatrix(samBtechIT, "OBC", 50, 12, "2026-27");
                createSeatMatrix(samBtechIT, "SC", 25, 6, "2026-27");
                createSeatMatrix(samBtechIT, "ST", 12, 4, "2026-27");

                createFeeStructure(samBtechIT, "2026-27",
                                new BigDecimal("145000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("235000"), "PER_YEAR");

                createCutoff(samBtechIT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("73.0"), null, "MP DTE");
                createCutoff(samBtechIT, "OBC", "2023-2024", "Round 1", new BigDecimal("68.0"), null, "MP DTE");

                // B.Tech AI & Data Science
                Course samBtechAIDS = createCourse(samGlobal, "B.Tech", "Artificial Intelligence and Data Science",
                                "UG", 4,
                                "Bachelor of Technology in AI and Data Science", "12th with 50% in PCM / JEE Main");

                createSeatMatrix(samBtechAIDS, "GENERAL", 60, 15, "2026-27");
                createSeatMatrix(samBtechAIDS, "OBC", 30, 8, "2026-27");
                createSeatMatrix(samBtechAIDS, "SC", 15, 4, "2026-27");
                createSeatMatrix(samBtechAIDS, "ST", 8, 3, "2026-27");

                createFeeStructure(samBtechAIDS, "2026-27",
                                new BigDecimal("160000"), new BigDecimal("60000"), new BigDecimal("10000"),
                                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                                new BigDecimal("250000"), "PER_YEAR");

                createCutoff(samBtechAIDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("78.0"), null, "MP DTE");
                createCutoff(samBtechAIDS, "OBC", "2023-2024", "Round 1", new BigDecimal("73.0"), null, "MP DTE");

                // BBA
                Course samBBA = createCourse(samGlobal, "BBA", "Business Administration", "UG", 3,
                                "Bachelor of Business Administration", "12th pass with 50%");

                createSeatMatrix(samBBA, "GENERAL", 100, 30, "2026-27");
                createSeatMatrix(samBBA, "OBC", 50, 15, "2026-27");
                createSeatMatrix(samBBA, "SC", 25, 8, "2026-27");

                createFeeStructure(samBBA, "2026-27",
                                new BigDecimal("80000"), new BigDecimal("45000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("4000"),
                                new BigDecimal("140000"), "PER_YEAR");

                createCutoff(samBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "Merit Based");
                createCutoff(samBBA, "OBC", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit Based");

                // BCA
                Course samBCA = createCourse(samGlobal, "BCA", "Computer Applications", "UG", 3,
                                "Bachelor of Computer Applications", "12th pass with 50% in any stream");

                createSeatMatrix(samBCA, "GENERAL", 90, 25, "2026-27");
                createSeatMatrix(samBCA, "OBC", 45, 12, "2026-27");
                createSeatMatrix(samBCA, "SC", 20, 6, "2026-27");

                createFeeStructure(samBCA, "2026-27",
                                new BigDecimal("70000"), new BigDecimal("45000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("4000"),
                                new BigDecimal("135000"), "PER_YEAR");

                createCutoff(samBCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "Merit Based");
                createCutoff(samBCA, "OBC", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit Based");

                // B.Com
                Course samBCom = createCourse(samGlobal, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th pass with 50% in Commerce");

                createSeatMatrix(samBCom, "GENERAL", 120, 35, "2026-27");
                createSeatMatrix(samBCom, "OBC", 60, 18, "2026-27");
                createSeatMatrix(samBCom, "SC", 30, 10, "2026-27");

                createFeeStructure(samBCom, "2026-27",
                                new BigDecimal("40000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("0"), new BigDecimal("3000"),
                                new BigDecimal("93000"), "PER_YEAR");

                createCutoff(samBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "Merit Based");

                // BA English
                Course samBAEng = createCourse(samGlobal, "BA", "English Literature", "UG", 3,
                                "Bachelor of Arts in English Literature", "12th pass with 45%");

                createSeatMatrix(samBAEng, "GENERAL", 80, 30, "2026-27");
                createSeatMatrix(samBAEng, "OBC", 40, 15, "2026-27");
                createSeatMatrix(samBAEng, "SC", 20, 8, "2026-27");

                createFeeStructure(samBAEng, "2026-27",
                                new BigDecimal("30000"), new BigDecimal("35000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("0"), new BigDecimal("3000"),
                                new BigDecimal("78000"), "PER_YEAR");

                createCutoff(samBAEng, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit Based");

                // BA Tamil
                Course samBATamil = createCourse(samGlobal, "BA", "Tamil Literature", "UG", 3,
                                "Bachelor of Arts in Tamil Literature", "12th pass with 45%");

                createSeatMatrix(samBATamil, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(samBATamil, "OBC", 30, 12, "2026-27");
                createSeatMatrix(samBATamil, "SC", 15, 6, "2026-27");

                createFeeStructure(samBATamil, "2026-27",
                                new BigDecimal("25000"), new BigDecimal("35000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("0"), new BigDecimal("3000"),
                                new BigDecimal("73000"), "PER_YEAR");

                createCutoff(samBATamil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null,
                                "Merit Based");

                // B.Sc Mathematics
                Course samBscMath = createCourse(samGlobal, "B.Sc", "Mathematics", "UG", 3,
                                "Bachelor of Science in Mathematics", "12th with 50% in Science/Maths");

                createSeatMatrix(samBscMath, "GENERAL", 70, 22, "2026-27");
                createSeatMatrix(samBscMath, "OBC", 35, 10, "2026-27");
                createSeatMatrix(samBscMath, "SC", 18, 6, "2026-27");

                createFeeStructure(samBscMath, "2026-27",
                                new BigDecimal("40000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("3000"),
                                new BigDecimal("96000"), "PER_YEAR");

                createCutoff(samBscMath, "GENERAL", "2023-2024", "Round 1", new BigDecimal("58.0"), null,
                                "Merit Based");

                // B.Sc Physics
                Course samBscPhy = createCourse(samGlobal, "B.Sc", "Physics", "UG", 3,
                                "Bachelor of Science in Physics", "12th with 50% in Science");

                createSeatMatrix(samBscPhy, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(samBscPhy, "OBC", 30, 10, "2026-27");
                createSeatMatrix(samBscPhy, "SC", 15, 5, "2026-27");

                createFeeStructure(samBscPhy, "2026-27",
                                new BigDecimal("42000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("5000"), new BigDecimal("3000"),
                                new BigDecimal("100000"), "PER_YEAR");

                createCutoff(samBscPhy, "GENERAL", "2023-2024", "Round 1", new BigDecimal("58.0"), null, "Merit Based");

                // B.Sc Chemistry
                Course samBscChem = createCourse(samGlobal, "B.Sc", "Chemistry", "UG", 3,
                                "Bachelor of Science in Chemistry", "12th with 50% in Science");

                createSeatMatrix(samBscChem, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(samBscChem, "OBC", 30, 10, "2026-27");
                createSeatMatrix(samBscChem, "SC", 15, 5, "2026-27");

                createFeeStructure(samBscChem, "2026-27",
                                new BigDecimal("42000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("5000"), new BigDecimal("3000"),
                                new BigDecimal("100000"), "PER_YEAR");

                createCutoff(samBscChem, "GENERAL", "2023-2024", "Round 1", new BigDecimal("56.0"), null,
                                "Merit Based");

                // M.Tech CSE
                Course samMtechCSE = createCourse(samGlobal, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in Computer Science and Engineering",
                                "B.Tech/BE with 55% / GATE qualified");

                createSeatMatrix(samMtechCSE, "GENERAL", 30, 10, "2026-27");
                createSeatMatrix(samMtechCSE, "OBC", 15, 5, "2026-27");
                createSeatMatrix(samMtechCSE, "SC", 8, 3, "2026-27");

                createFeeStructure(samMtechCSE, "2026-27",
                                new BigDecimal("100000"), new BigDecimal("55000"), new BigDecimal("10000"),
                                new BigDecimal("4000"), new BigDecimal("6000"), new BigDecimal("5000"),
                                new BigDecimal("180000"), "PER_YEAR");

                createCutoff(samMtechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), null,
                                "GATE / MP DTE");
                createCutoff(samMtechCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "GATE / MP DTE");

                // M.Tech VLSI Design
                Course samMtechVLSI = createCourse(samGlobal, "M.Tech", "VLSI Design", "PG", 2,
                                "Master of Technology in VLSI Design",
                                "B.Tech/BE in ECE/EEE with 55% / GATE qualified");

                createSeatMatrix(samMtechVLSI, "GENERAL", 20, 8, "2026-27");
                createSeatMatrix(samMtechVLSI, "OBC", 10, 4, "2026-27");

                createFeeStructure(samMtechVLSI, "2026-27",
                                new BigDecimal("95000"), new BigDecimal("55000"), new BigDecimal("10000"),
                                new BigDecimal("4000"), new BigDecimal("6000"), new BigDecimal("5000"),
                                new BigDecimal("175000"), "PER_YEAR");

                createCutoff(samMtechVLSI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("62.0"), null,
                                "GATE / MP DTE");

                // MCA
                Course samMCA = createCourse(samGlobal, "MCA", "Computer Applications", "PG", 2,
                                "Master of Computer Applications", "BCA/B.Sc CS with 50% / MP DTE qualified");

                createSeatMatrix(samMCA, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(samMCA, "OBC", 30, 9, "2026-27");
                createSeatMatrix(samMCA, "SC", 15, 5, "2026-27");

                createFeeStructure(samMCA, "2026-27",
                                new BigDecimal("85000"), new BigDecimal("50000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("4000"),
                                new BigDecimal("155000"), "PER_YEAR");

                createCutoff(samMCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "MP DTE");
                createCutoff(samMCA, "OBC", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "MP DTE");

                // M.Sc Computer Science
                Course samMscCS = createCourse(samGlobal, "M.Sc", "Computer Science", "PG", 2,
                                "Master of Science in Computer Science", "B.Sc CS with 50%");

                createSeatMatrix(samMscCS, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(samMscCS, "OBC", 20, 6, "2026-27");

                createFeeStructure(samMscCS, "2026-27",
                                new BigDecimal("55000"), new BigDecimal("45000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("4000"), new BigDecimal("3000"),
                                new BigDecimal("118000"), "PER_YEAR");

                createCutoff(samMscCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("58.0"), null, "Merit Based");

                // M.Sc Mathematics
                Course samMscMath = createCourse(samGlobal, "M.Sc", "Mathematics", "PG", 2,
                                "Master of Science in Mathematics", "B.Sc Mathematics with 50%");

                createSeatMatrix(samMscMath, "GENERAL", 30, 10, "2026-27");
                createSeatMatrix(samMscMath, "OBC", 15, 5, "2026-27");

                createFeeStructure(samMscMath, "2026-27",
                                new BigDecimal("45000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("3000"),
                                new BigDecimal("101000"), "PER_YEAR");

                createCutoff(samMscMath, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "Merit Based");

                // M.Com
                Course samMCom = createCourse(samGlobal, "M.Com", "Commerce", "PG", 2,
                                "Master of Commerce", "B.Com with 50%");

                createSeatMatrix(samMCom, "GENERAL", 40, 15, "2026-27");
                createSeatMatrix(samMCom, "OBC", 20, 8, "2026-27");

                createFeeStructure(samMCom, "2026-27",
                                new BigDecimal("45000"), new BigDecimal("40000"), new BigDecimal("8000"),
                                new BigDecimal("2000"), new BigDecimal("0"), new BigDecimal("3000"),
                                new BigDecimal("98000"), "PER_YEAR");

                createCutoff(samMCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "Merit Based");

                // B.Pharmacy
                Course samBPharm = createCourse(samGlobal, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy", "12th with 50% in PCB / NEET qualified");

                createSeatMatrix(samBPharm, "GENERAL", 60, 15, "2026-27");
                createSeatMatrix(samBPharm, "OBC", 30, 8, "2026-27");
                createSeatMatrix(samBPharm, "SC", 15, 4, "2026-27");
                createSeatMatrix(samBPharm, "ST", 8, 3, "2026-27");

                createFeeStructure(samBPharm, "2026-27",
                                new BigDecimal("110000"), new BigDecimal("55000"), new BigDecimal("10000"),
                                new BigDecimal("4000"), new BigDecimal("8000"), new BigDecimal("6000"),
                                new BigDecimal("193000"), "PER_YEAR");

                createCutoff(samBPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null, "MP DTE");
                createCutoff(samBPharm, "OBC", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "MP DTE");

                // D.Pharm
                Course samDPharm = createCourse(samGlobal, "D.Pharm", "Pharmacy", "UG", 2,
                                "Diploma in Pharmacy", "12th with 45% in PCB");

                createSeatMatrix(samDPharm, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(samDPharm, "OBC", 20, 6, "2026-27");
                createSeatMatrix(samDPharm, "SC", 10, 4, "2026-27");

                createFeeStructure(samDPharm, "2026-27",
                                new BigDecimal("65000"), new BigDecimal("45000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("5000"), new BigDecimal("4000"),
                                new BigDecimal("130000"), "PER_YEAR");

                createCutoff(samDPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit Based");

                // MBA HR
                Course samMBAHR = createCourse(samGlobal, "MBA", "Human Resource Management", "PG", 2,
                                "Master of Business Administration in HR", "Graduation with 50% / CAT / MAT qualified");

                createSeatMatrix(samMBAHR, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(samMBAHR, "OBC", 20, 6, "2026-27");

                createFeeStructure(samMBAHR, "2026-27",
                                new BigDecimal("115000"), new BigDecimal("50000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("5000"),
                                new BigDecimal("181000"), "PER_YEAR");

                createCutoff(samMBAHR, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "CAT / MAT / MP DTE");

                // MBA Finance
                Course samMBAFin = createCourse(samGlobal, "MBA", "Finance", "PG", 2,
                                "Master of Business Administration in Finance",
                                "Graduation with 50% / CAT / MAT qualified");

                createSeatMatrix(samMBAFin, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(samMBAFin, "OBC", 20, 6, "2026-27");

                createFeeStructure(samMBAFin, "2026-27",
                                new BigDecimal("118000"), new BigDecimal("50000"), new BigDecimal("8000"),
                                new BigDecimal("3000"), new BigDecimal("0"), new BigDecimal("5000"),
                                new BigDecimal("184000"), "PER_YEAR");

                createCutoff(samMBAFin, "GENERAL", "2023-2024", "Round 1", new BigDecimal("57.0"), null,
                                "CAT / MAT / MP DTE");

                // Ph.D Computer Science
                Course samPhdCS = createCourse(samGlobal, "Ph.D", "Computer Science", "Doctoral", 3,
                                "Doctor of Philosophy in Computer Science",
                                "M.Tech/M.Sc CS with 55% / NET/SET qualified");

                createSeatMatrix(samPhdCS, "GENERAL", 10, 5, "2026-27");
                createSeatMatrix(samPhdCS, "OBC", 5, 3, "2026-27");

                createFeeStructure(samPhdCS, "2026-27",
                                new BigDecimal("75000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("5000"),
                                new BigDecimal("140000"), "PER_YEAR");

                // Ph.D Management
                Course samPhdMgmt = createCourse(samGlobal, "Ph.D", "Management", "Doctoral", 3,
                                "Doctor of Philosophy in Management", "MBA/M.Com with 55% / NET/SET qualified");

                createSeatMatrix(samPhdMgmt, "GENERAL", 8, 4, "2026-27");
                createSeatMatrix(samPhdMgmt, "OBC", 4, 2, "2026-27");

                createFeeStructure(samPhdMgmt, "2026-27",
                                new BigDecimal("70000"), new BigDecimal("50000"), new BigDecimal("0"),
                                new BigDecimal("5000"), new BigDecimal("0"), new BigDecimal("5000"),
                                new BigDecimal("130000"), "PER_YEAR");
        }

        private College createCollege(String name, String description, String type, String city,
                        String state, String address, String pincode, String phone,
                        String email, String website, String naacRating,
                        Boolean admissionOpen, Integer establishedYear, String affiliatedTo) {
                College college = collegeRepository.findByName(name);
                if (college == null) {
                        college = new College();
                        college.setName(name);
                }

                college.setDescription(description);
                college.setType(type);
                college.setCity(city);
                college.setState(state);
                college.setAddress(address);
                college.setPincode(pincode);
                college.setPhone(phone);
                college.setEmail(email);
                college.setWebsite(website);
                college.setNaacRating(naacRating);
                college.setAdmissionOpen(admissionOpen);
                college.setEstablishedYear(establishedYear);
                college.setAffiliatedTo(affiliatedTo);
                college.setFacilities("Library,Hostel,Sports Complex,Cafeteria,Labs,Wi-Fi,Auditorium");

                // Set real college images (verified Wikimedia Commons URLs)
                Map<String, String> realImages = getCollegeImageMap();
                String realImage = realImages.get(name);
                if (realImage != null) {
                        college.setBannerUrl(realImage);
                } else {
                        String seed = name.replaceAll("[^a-zA-Z0-9]", "-").toLowerCase();
                        college.setBannerUrl("https://picsum.photos/seed/" + seed + "/800/400");
                }
                String initials = getInitials(name);
                String bgColor = "GOVERNMENT".equals(type) ? "1a56db" : "7c3aed";
                college.setLogoUrl("https://ui-avatars.com/api/?name=" + initials + "&size=128&background=" + bgColor
                                + "&color=fff&bold=true&font-size=0.4");

                return collegeRepository.save(college);
        }

        private Map<String, String> getCollegeImageMap() {
                Map<String, String> map = new HashMap<>();
                map.put("Indian Institute of Technology Delhi",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/IIT_Delhi_Main_Building.jpeg/800px-IIT_Delhi_Main_Building.jpeg");
                map.put("All India Institute of Medical Sciences Delhi",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/AIIMS_-New_Delhi%27s_Ward_Block.jpg/800px-AIIMS_-New_Delhi%27s_Ward_Block.jpg");
                map.put("Shri Ram College of Commerce",
                                "https://upload.wikimedia.org/wikipedia/commons/4/4c/Shriramcollegeofcommerce.JPG");
                map.put("Amity University Noida",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Amity_University%2C_Campus_Noida.jpg/800px-Amity_University%2C_Campus_Noida.jpg");
                map.put("Manipal Institute of Technology",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/MIT_Academic_Block_1_-_Quadrangle.jpg/800px-MIT_Academic_Block_1_-_Quadrangle.jpg");
                map.put("National Institute of Technology Tiruchirappalli",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/National_Institute_of_Technology%2C_Trichy.jpg/800px-National_Institute_of_Technology%2C_Trichy.jpg");
                map.put("Indian Institute of Management Ahmedabad",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Iima_new_campus_panorama.jpg/800px-Iima_new_campus_panorama.jpg");
                map.put("Jadavpur University",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Jadavpur_University_Gate_No._4.jpg/800px-Jadavpur_University_Gate_No._4.jpg");
                map.put("Lovely Professional University",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Lovely_Professional_University_%28LPU%29%2C_Jalandhar-Phagwara_Highway%2C_Jalandhar.jpg/800px-Lovely_Professional_University_%28LPU%29%2C_Jalandhar-Phagwara_Highway%2C_Jalandhar.jpg");
                map.put("Sam Global University",
                                "https://www.shikshahub.com/uploads/blogs/SAM%20Global%20University.jpg");
                return map;
        }

        private String getInitials(String name) {
                String cleaned = name.replaceAll("\\(.*?\\)", "").trim();
                String[] words = cleaned.split("\\s+");
                StringBuilder sb = new StringBuilder();
                for (String word : words) {
                        if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                                sb.append(word.charAt(0));
                        }
                }
                return sb.length() > 0 ? sb.toString() : String.valueOf(name.charAt(0));
        }

        private Course createCourse(College college, String name, String specialization,
                        String degree, Integer duration, String description, String eligibility) {
                Course course = new Course();
                course.setCollege(college);
                course.setName(name);
                course.setSpecialization(specialization);
                course.setDegree(degree);
                course.setDurationYears(duration);
                course.setDescription(description);
                course.setEligibility(eligibility);
                course.setActive(true);
                return courseRepository.save(course);
        }

        private void createSeatMatrix(Course course, String category, Integer total, Integer available, String year) {
                SeatMatrix seat = new SeatMatrix();
                seat.setCourse(course);
                seat.setCategory(category);
                seat.setTotalSeats(total);
                seat.setAvailableSeats(available);
                seat.setAcademicYear(year);
                seatMatrixRepository.save(seat);
        }

        private void createFeeStructure(Course course, String year, BigDecimal tuition, BigDecimal hostel,
                        BigDecimal transport, BigDecimal library, BigDecimal lab,
                        BigDecimal other, BigDecimal total, String feeType) {
                FeeStructure fee = new FeeStructure();
                fee.setCourse(course);
                fee.setAcademicYear(year);
                fee.setTuitionFee(tuition);
                fee.setHostelFee(hostel);
                fee.setTransportFee(transport);
                fee.setLibraryFee(library);
                fee.setLabFee(lab);
                fee.setOtherFees(other);
                fee.setTotalFee(total);
                fee.setFeeType(feeType);
                feeStructureRepository.save(fee);
        }

        private void createCutoff(Course course, String category, String year, String round,
                        BigDecimal percentage, Integer rank, String examType) {
                Cutoff cutoff = new Cutoff();
                cutoff.setCourse(course);
                cutoff.setCategory(category);
                cutoff.setAcademicYear(year);
                cutoff.setRound(round);
                cutoff.setCutoffPercentage(percentage);
                cutoff.setCutoffRank(rank);
                cutoff.setExamType(examType);
                cutoffRepository.save(cutoff);
        }
}
