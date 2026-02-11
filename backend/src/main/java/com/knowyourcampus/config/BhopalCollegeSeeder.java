package com.knowyourcampus.config;

import com.knowyourcampus.entity.*;
import com.knowyourcampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class BhopalCollegeSeeder {

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

        public void seedBhopalColleges() {
                System.out.println("🏛️ Seeding Bhopal Colleges...");

                // ==================== GOVERNMENT ENGINEERING ====================

                // 1. MANIT Bhopal - Top Engineering
                College manit = createCollege(
                                "Maulana Azad National Institute of Technology (MANIT)",
                                "MANIT Bhopal is a premier technical institute and one of the oldest NITs in India. Established in 1960, it offers excellent engineering programs with strong placement records.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Link Road Number 3, Near Habibganj Naka, Bhopal, MP 462003",
                                "462003",
                                "0755-4051000",
                                "registrar@manit.ac.in",
                                "https://www.manit.ac.in",
                                "A++",
                                true,
                                1960,
                                "NIT System (Autonomous)");

                Course manitCSE = createCourse(manit, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in Computer Science", "JEE Main qualified");
                createSeatMatrix(manitCSE, "GENERAL", 80, 15, "2026-27");
                createSeatMatrix(manitCSE, "OBC", 45, 10, "2026-27");
                createSeatMatrix(manitCSE, "SC", 20, 5, "2026-27");
                createSeatMatrix(manitCSE, "ST", 12, 3, "2026-27");
                createSeatMatrix(manitCSE, "EWS", 15, 4, "2026-27");
                createFeeStructure(manitCSE, "2026-27", new BigDecimal("125000"), new BigDecimal("35000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("7000"),
                                new BigDecimal("180000"), "PER_YEAR");
                createCutoff(manitCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.5"), 18500, "JEE Main");
                createCutoff(manitCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("95.2"), 35000, "JEE Main");

                Course manitECE = createCourse(manit, "B.Tech", "Electronics and Communication Engineering", "UG", 4,
                                "Bachelor of Technology in ECE", "JEE Main qualified");
                createSeatMatrix(manitECE, "GENERAL", 70, 12, "2026-27");
                createSeatMatrix(manitECE, "OBC", 40, 8, "2026-27");
                createFeeStructure(manitECE, "2026-27", new BigDecimal("125000"), new BigDecimal("35000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("7000"),
                                new BigDecimal("180000"), "PER_YEAR");
                createCutoff(manitECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.8"), 22000, "JEE Main");

                Course manitME = createCourse(manit, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering", "JEE Main qualified");
                createSeatMatrix(manitME, "GENERAL", 90, 18, "2026-27");
                createFeeStructure(manitME, "2026-27", new BigDecimal("125000"), new BigDecimal("35000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("7000"),
                                new BigDecimal("180000"), "PER_YEAR");
                createCutoff(manitME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("94.5"), 38000, "JEE Main");
                createCutoff(manitME, "OBC", "2023-2024", "Round 1", new BigDecimal("91.2"), 65000, "JEE Main");
                createCutoff(manitME, "SC", "2023-2024", "Round 1", new BigDecimal("82.5"), 150000, "JEE Main");

                Course manitMBA = createCourse(manit, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT qualified with graduation");
                createSeatMatrix(manitMBA, "GENERAL", 60, 10, "2026-27");
                createFeeStructure(manitMBA, "2026-27", new BigDecimal("200000"), new BigDecimal("40000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("255000"), "PER_YEAR");
                createCutoff(manitMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), null, "CAT");

                // 2. RGPV - Rajiv Gandhi Proudyogiki Vishwavidyalaya
                College rgpv = createCollege(
                                "Rajiv Gandhi Proudyogiki Vishwavidyalaya (RGPV)",
                                "RGPV is the state technical university of Madhya Pradesh. It affiliates over 200 engineering colleges across MP and offers quality technical education.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Airport Bypass Road, Gandhi Nagar, Bhopal, MP 462033",
                                "462033",
                                "0755-2678833",
                                "registrar@rgpv.ac.in",
                                "https://www.rgpv.ac.in",
                                "A",
                                true,
                                1998,
                                "State University");

                Course rgpvBtech = createCourse(rgpv, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "MP PET / JEE Main qualified");
                createSeatMatrix(rgpvBtech, "GENERAL", 60, 12, "2026-27");
                createSeatMatrix(rgpvBtech, "OBC", 35, 8, "2026-27");
                createFeeStructure(rgpvBtech, "2026-27", new BigDecimal("34520"), new BigDecimal("12000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("3500"),
                                new BigDecimal("55020"), "PER_YEAR");
                createCutoff(rgpvBtech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), 70000, "JEE Main");
                createCutoff(rgpvBtech, "OBC", "2023-2024", "Round 1", new BigDecimal("85.0"), 120000, "JEE Main");
                createCutoff(rgpvBtech, "SC", "2023-2024", "Round 1", new BigDecimal("72.0"), 250000, "JEE Main");

                Course rgpvMtech = createCourse(rgpv, "M.Tech", "Computer Science", "PG", 2,
                                "Master of Technology in CS", "GATE qualified / Valid RGPV score");
                createSeatMatrix(rgpvMtech, "GENERAL", 30, 8, "2026-27");
                createFeeStructure(rgpvMtech, "2026-27", new BigDecimal("50000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("3000"),
                                new BigDecimal("73000"), "PER_YEAR");
                createCutoff(rgpvMtech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("450"), null, "GATE Score");

                // 3. UIT-RGPV
                College uitRgpv = createCollege(
                                "University Institute of Technology (UIT-RGPV)",
                                "UIT is the constituent institute of RGPV offering quality engineering education with excellent faculty and infrastructure.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "RGPV Campus, Airport Bypass Road, Bhopal, MP 462033",
                                "462033",
                                "0755-2678844",
                                "director.uit@rgpv.ac.in",
                                "https://www.rgpv.ac.in/uit",
                                "A",
                                true,
                                1999,
                                "RGPV");

                Course uitCSE = createCourse(uitRgpv, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(uitCSE, "GENERAL", 60, 10, "2026-27");
                createSeatMatrix(uitCSE, "OBC", 35, 7, "2026-27");
                createFeeStructure(uitCSE, "2026-27", new BigDecimal("75000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("107000"), "PER_YEAR");
                createCutoff(uitCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("92.5"), 55000, "JEE Main");

                // ==================== GOVERNMENT MEDICAL ====================

                // 4. AIIMS Bhopal
                College aiimsBhopal = createCollege(
                                "All India Institute of Medical Sciences (AIIMS) Bhopal",
                                "AIIMS Bhopal is a premier medical institution established under PMSSY. It offers world-class medical education and healthcare facilities.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Saket Nagar, Bhopal, MP 462020",
                                "462020",
                                "0755-2672001",
                                "director@aiimsbhopal.edu.in",
                                "https://www.aiimsbhopal.edu.in",
                                "A++",
                                true,
                                2012,
                                "Autonomous (Central Government)");

                Course aiimsMBBS = createCourse(aiimsBhopal, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(aiimsMBBS, "GENERAL", 50, 5, "2026-27");
                createSeatMatrix(aiimsMBBS, "OBC", 27, 3, "2026-27");
                createSeatMatrix(aiimsMBBS, "SC", 15, 2, "2026-27");
                createSeatMatrix(aiimsMBBS, "ST", 8, 1, "2026-27");
                createFeeStructure(aiimsMBBS, "2026-27", new BigDecimal("1628"), new BigDecimal("25000"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("2000"),
                                new BigDecimal("3000"),
                                new BigDecimal("32628"), "PER_YEAR");
                createCutoff(aiimsMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.95"), 120, "NEET UG");
                createCutoff(aiimsMBBS, "OBC", "2023-2024", "Round 1", new BigDecimal("99.85"), 350, "NEET UG");

                Course aiimsMD = createCourse(aiimsBhopal, "MD", "General Medicine", "PG", 3,
                                "Doctor of Medicine", "NEET PG qualified");
                createSeatMatrix(aiimsMD, "GENERAL", 15, 2, "2026-27");
                createFeeStructure(aiimsMD, "2026-27", new BigDecimal("5000"), new BigDecimal("25000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("5000"),
                                new BigDecimal("40000"), "PER_YEAR");

                Course aiimsNursing = createCourse(aiimsBhopal, "B.Sc", "Nursing", "UG", 4,
                                "Bachelor of Science in Nursing", "12th PCB with 55%");
                createSeatMatrix(aiimsNursing, "GENERAL", 60, 10, "2026-27");
                createFeeStructure(aiimsNursing, "2026-27", new BigDecimal("5000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("2000"),
                                new BigDecimal("2000"),
                                new BigDecimal("25000"), "PER_YEAR");

                // 5. Gandhi Medical College
                College gmc = createCollege(
                                "Gandhi Medical College (GMC) Bhopal",
                                "Gandhi Medical College is one of the oldest and most prestigious government medical colleges in Madhya Pradesh, established in 1955.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Royal Market, Sultania Road, Bhopal, MP 462001",
                                "462001",
                                "0755-2540570",
                                "principal@gmcbhopal.net",
                                "https://www.gmcbhopal.mp.gov.in",
                                "A",
                                true,
                                1955,
                                "MPMC");

                Course gmcMBBS = createCourse(gmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(gmcMBBS, "GENERAL", 100, 15, "2026-27");
                createSeatMatrix(gmcMBBS, "OBC", 54, 8, "2026-27");
                createSeatMatrix(gmcMBBS, "SC", 30, 5, "2026-27");
                createSeatMatrix(gmcMBBS, "ST", 16, 3, "2026-27");
                createFeeStructure(gmcMBBS, "2026-27", new BigDecimal("25000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("5000"),
                                new BigDecimal("3000"),
                                new BigDecimal("50000"), "PER_YEAR");
                createCutoff(gmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.5"), 8500, "NEET UG");

                // ==================== GOVERNMENT MANAGEMENT ====================

                // 6. IIFM Bhopal
                College iifm = createCollege(
                                "Indian Institute of Forest Management (IIFM)",
                                "IIFM Bhopal is a premier autonomous management institute specializing in forest, environment and sustainability management.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Nehru Nagar, Bhopal, MP 462003",
                                "462003",
                                "0755-2775716",
                                "admission@iifm.ac.in",
                                "https://www.iifm.ac.in",
                                "A+",
                                true,
                                1982,
                                "Autonomous (Ministry of Environment)");

                Course iifmPGDFM = createCourse(iifm, "PGDFM", "Forest Management", "PG", 2,
                                "Post Graduate Diploma in Forest Management", "CAT/XAT/GMAT with graduation");
                createSeatMatrix(iifmPGDFM, "GENERAL", 80, 15, "2026-27");
                createFeeStructure(iifmPGDFM, "2026-27", new BigDecimal("450000"), new BigDecimal("80000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("0"),
                                new BigDecimal("20000"),
                                new BigDecimal("560000"), "PER_YEAR");
                createCutoff(iifmPGDFM, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), null, "CAT");

                // ==================== GOVERNMENT ARTS/SCIENCE ====================

                // 7. Barkatullah University
                College bu = createCollege(
                                "Barkatullah University",
                                "Barkatullah University is a state university in Bhopal named after freedom fighter Maulana Barkatullah. It offers diverse programs in arts, science, and commerce.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hoshangabad Road, Bhopal, MP 462026",
                                "462026",
                                "0755-2517100",
                                "registrar@bubhopal.ac.in",
                                "https://www.bubhopal.ac.in",
                                "A",
                                true,
                                1970,
                                "State University");

                Course buBA = createCourse(bu, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(buBA, "GENERAL", 500, 150, "2026-27");
                createSeatMatrix(buBA, "OBC", 300, 80, "2026-27");
                createFeeStructure(buBA, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("0"),
                                new BigDecimal("1500"),
                                new BigDecimal("7500"), "PER_YEAR");

                Course buBSc = createCourse(bu, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(buBSc, "GENERAL", 400, 100, "2026-27");
                createFeeStructure(buBSc, "2026-27", new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("2000"),
                                new BigDecimal("13500"), "PER_YEAR");

                Course buBCom = createCourse(bu, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th with Commerce");
                createSeatMatrix(buBCom, "GENERAL", 350, 80, "2026-27");
                createFeeStructure(buBCom, "2026-27", new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("500"),
                                new BigDecimal("1500"),
                                new BigDecimal("9000"), "PER_YEAR");

                Course buMBA = createCourse(bu, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "Graduation with 50%");
                createSeatMatrix(buMBA, "GENERAL", 120, 25, "2026-27");
                createFeeStructure(buMBA, "2026-27", new BigDecimal("35000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("40000"), "PER_YEAR");

                // 8. Govt. Hamidia Arts & Commerce College
                College hamidia = createCollege(
                                "Government Hamidia Arts and Commerce College",
                                "One of the oldest and most prestigious arts and commerce colleges in Bhopal, known for quality education and rich heritage.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hamidia Road, Near Tajul Masajid, Bhopal, MP 462001",
                                "462001",
                                "0755-2740326",
                                "principalhamidia@gmail.com",
                                "https://www.hamidiacollege.ac.in",
                                "A",
                                true,
                                1937,
                                "Barkatullah University");

                Course hamidiaBA = createCourse(hamidia, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(hamidiaBA, "GENERAL", 400, 100, "2026-27");
                createFeeStructure(hamidiaBA, "2026-27", new BigDecimal("3500"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("800"), new BigDecimal("0"), new BigDecimal("1200"),
                                new BigDecimal("5500"), "PER_YEAR");

                Course hamidiaBCom = createCourse(hamidia, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th with Commerce");
                createSeatMatrix(hamidiaBCom, "GENERAL", 300, 70, "2026-27");
                createFeeStructure(hamidiaBCom, "2026-27", new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("500"),
                                new BigDecimal("1000"),
                                new BigDecimal("6500"), "PER_YEAR");

                // 9. Govt. Motilal Vigyan Mahavidyalaya
                College mlvm = createCollege(
                                "Government Motilal Vigyan Mahavidyalaya",
                                "Premier government science college in Bhopal offering quality science education at affordable fees.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Nehru Nagar, Bhopal, MP 462003",
                                "462003",
                                "0755-2661543",
                                "mlvm.bhopal@mp.gov.in",
                                "https://www.mlvmbhopal.ac.in",
                                "B++",
                                true,
                                1968,
                                "Barkatullah University");

                Course mlvmBSc = createCourse(mlvm, "B.Sc", "Science (PCM/PCB)", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(mlvmBSc, "GENERAL", 300, 80, "2026-27");
                createFeeStructure(mlvmBSc, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1200"), new BigDecimal("2000"),
                                new BigDecimal("1500"),
                                new BigDecimal("9700"), "PER_YEAR");

                // 10. Sarojini Naidu Govt. Girls PG College
                College sngc = createCollege(
                                "Sarojini Naidu Government Girls PG College",
                                "Premier women's college in Bhopal offering quality education in arts, science and commerce for girls.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Shivaji Nagar, Bhopal, MP 462016",
                                "462016",
                                "0755-2557289",
                                "sngc.bhopal@mp.gov.in",
                                "https://www.sngcbhopal.ac.in",
                                "A",
                                true,
                                1948,
                                "Barkatullah University");

                Course sngcBA = createCourse(sngc, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts (Girls Only)", "12th pass (Girls)");
                createSeatMatrix(sngcBA, "GENERAL", 350, 100, "2026-27");
                createFeeStructure(sngcBA, "2026-27", new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("700"), new BigDecimal("0"), new BigDecimal("1000"),
                                new BigDecimal("4700"), "PER_YEAR");

                Course sngcBSc = createCourse(sngc, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science (Girls Only)", "12th with Science (Girls)");
                createSeatMatrix(sngcBSc, "GENERAL", 250, 60, "2026-27");
                createFeeStructure(sngcBSc, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("1500"),
                                new BigDecimal("1200"),
                                new BigDecimal("8700"), "PER_YEAR");

                // ==================== PRIVATE ENGINEERING ====================

                // 11. LNCT Group of Colleges
                College lnct = createCollege(
                                "Lakshmi Narain College of Technology (LNCT)",
                                "LNCT is the flagship institute of LNCT Group, one of the largest private engineering college chains in MP. Known for strong placements and industry connections.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Raisen Road, Bhopal, MP 462021",
                                "462021",
                                "0755-6185300",
                                "info@lnct.ac.in",
                                "https://www.lnct.ac.in",
                                "A+",
                                true,
                                1994,
                                "RGPV");

                Course lnctCSE = createCourse(lnct, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(lnctCSE, "GENERAL", 180, 40, "2026-27");
                createSeatMatrix(lnctCSE, "OBC", 90, 20, "2026-27");
                createFeeStructure(lnctCSE, "2026-27", new BigDecimal("70000"), new BigDecimal("45000"),
                                new BigDecimal("15000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("12000"),
                                new BigDecimal("155000"), "PER_YEAR");
                createCutoff(lnctCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("75.0"), 150000, "JEE Main");

                Course lnctAI = createCourse(lnct, "B.Tech", "Artificial Intelligence & ML", "UG", 4,
                                "B.Tech in AI and Machine Learning", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(lnctAI, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(lnctAI, "2026-27", new BigDecimal("85000"), new BigDecimal("45000"),
                                new BigDecimal("15000"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("15000"),
                                new BigDecimal("175000"), "PER_YEAR");
                createCutoff(lnctAI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("72.0"), 180000, "JEE Main");
                createCutoff(lnctAI, "OBC", "2023-2024", "Round 1", new BigDecimal("65.0"), 280000, "JEE Main");

                Course lnctME = createCourse(lnct, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(lnctME, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(lnctME, "2026-27", new BigDecimal("85000"), new BigDecimal("45000"),
                                new BigDecimal("15000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("168000"), "PER_YEAR");
                createCutoff(lnctME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("68.0"), 220000, "JEE Main");
                createCutoff(lnctME, "OBC", "2023-2024", "Round 1", new BigDecimal("60.0"), 350000, "JEE Main");

                Course lnctMBA = createCourse(lnct, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT/CMAT with graduation");
                createSeatMatrix(lnctMBA, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(lnctMBA, "2026-27", new BigDecimal("125000"), new BigDecimal("50000"),
                                new BigDecimal("15000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("15000"),
                                new BigDecimal("210000"), "PER_YEAR");
                createCutoff(lnctMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "CAT/MAT");

                // 12. Oriental Institute of Science and Technology
                College oriental = createCollege(
                                "Oriental Institute of Science and Technology (OIST)",
                                "Oriental Group is a well-established private engineering institute in Bhopal known for quality education and placements.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Opposite Patel Nagar, Raisen Road, Bhopal, MP 462021",
                                "462021",
                                "0755-2751882",
                                "info@oriental.ac.in",
                                "https://www.oriental.ac.in",
                                "A",
                                true,
                                1995,
                                "RGPV");

                Course oistCSE = createCourse(oriental, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(oistCSE, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(oistCSE, "2026-27", new BigDecimal("96000"), new BigDecimal("40000"),
                                new BigDecimal("12000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("166000"), "PER_YEAR");
                createCutoff(oistCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), 200000, "JEE Main");
                createCutoff(oistCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("62.0"), 320000, "JEE Main");

                Course oistECE = createCourse(oriental, "B.Tech", "Electronics and Communication", "UG", 4,
                                "Bachelor of Technology in ECE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(oistECE, "GENERAL", 90, 25, "2026-27");
                createFeeStructure(oistECE, "2026-27", new BigDecimal("90000"), new BigDecimal("40000"),
                                new BigDecimal("12000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("160000"), "PER_YEAR");
                createCutoff(oistECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), 250000, "JEE Main");

                // 13. TIT Group (Technocrats Institute of Technology)
                College tit = createCollege(
                                "Technocrats Institute of Technology (TIT)",
                                "TIT is a leading private engineering college known for excellent infrastructure, labs, and industry-focused curriculum.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "BHEL, Sector-E, Govindpura, Bhopal, MP 462023",
                                "462023",
                                "0755-4226500",
                                "info@titbhopal.net",
                                "https://www.titbhopal.net",
                                "A",
                                true,
                                1999,
                                "RGPV");

                Course titCSE = createCourse(tit, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(titCSE, "GENERAL", 180, 45, "2026-27");
                createFeeStructure(titCSE, "2026-27", new BigDecimal("100000"), new BigDecimal("38000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("9000"),
                                new BigDecimal("171000"), "PER_YEAR");
                createCutoff(titCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("72.0"), 190000, "JEE Main");
                createCutoff(titCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("64.0"), 300000, "JEE Main");
                createCutoff(titCSE, "SC", "2023-2024", "Round 1", new BigDecimal("55.0"), 450000, "JEE Main");

                Course titDS = createCourse(tit, "B.Tech", "Data Science", "UG", 4,
                                "Bachelor of Technology in Data Science", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(titDS, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(titDS, "2026-27", new BigDecimal("95000"), new BigDecimal("42000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("172000"), "PER_YEAR");
                createCutoff(titDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), 210000, "JEE Main");

                // 14. Sagar Institute of Research & Technology (SIRT)
                College sirt = createCollege(
                                "Sagar Institute of Research and Technology (SIRT)",
                                "SIRT Bhopal is a premier institute of Sagar Group of Institutions (SGI), established in 2001. NAAC A graded, AICTE approved and RGPV affiliated. Known for excellent placements in top MNCs like TCS, Infosys, Wipro, Cognizant, Capgemini. Features 25+ acre green campus with smart classrooms, advanced labs, central library, sports complex, boys & girls hostel, cafeteria, Wi-Fi campus, auditorium, and placement cell.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Ayodhya Bypass Road, Bhopal, MP 462041",
                                "462041",
                                "0755-4274800",
                                "info@sfrirt.ac.in",
                                "https://www.sfrirt.ac.in",
                                "A",
                                true,
                                2001,
                                "RGPV");

                // ---- SIRT B.Tech CSE ----
                Course sirtCSE = createCourse(sirt, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "B.Tech CSE with strong focus on programming, software development, database, networking, and OS. Top recruiters: TCS, Infosys, Wipro, Cognizant",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtCSE, "GENERAL", 180, 50, "2026-27");
                createSeatMatrix(sirtCSE, "OBC", 90, 25, "2026-27");
                createSeatMatrix(sirtCSE, "SC", 45, 12, "2026-27");
                createSeatMatrix(sirtCSE, "ST", 25, 8, "2026-27");
                createSeatMatrix(sirtCSE, "EWS", 30, 10, "2026-27");
                createFeeStructure(sirtCSE, "2026-27", new BigDecimal("90000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("158000"), "PER_YEAR");
                createCutoff(sirtCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), 210000, "JEE Main");
                createCutoff(sirtCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("62.0"), 330000, "JEE Main");
                createCutoff(sirtCSE, "SC", "2023-2024", "Round 1", new BigDecimal("50.0"), 520000, "JEE Main");
                createCutoff(sirtCSE, "ST", "2023-2024", "Round 1", new BigDecimal("45.0"), 600000, "JEE Main");
                createCutoff(sirtCSE, "GENERAL", "2022-2023", "Round 1", new BigDecimal("72.0"), 195000, "JEE Main");
                createCutoff(sirtCSE, "OBC", "2022-2023", "Round 1", new BigDecimal("64.0"), 310000, "JEE Main");

                // ---- SIRT B.Tech IT ----
                Course sirtIT = createCourse(sirt, "B.Tech", "Information Technology", "UG", 4,
                                "B.Tech IT with Web Technologies, Cloud Computing, Software Engineering, and DBMS",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtIT, "GENERAL", 120, 35, "2026-27");
                createSeatMatrix(sirtIT, "OBC", 60, 18, "2026-27");
                createSeatMatrix(sirtIT, "SC", 30, 10, "2026-27");
                createFeeStructure(sirtIT, "2026-27", new BigDecimal("78000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("146000"), "PER_YEAR");
                createCutoff(sirtIT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("68.0"), 230000, "JEE Main");
                createCutoff(sirtIT, "OBC", "2023-2024", "Round 1", new BigDecimal("60.0"), 350000, "JEE Main");

                // ---- SIRT B.Tech AI & ML ----
                Course sirtAI = createCourse(sirt, "B.Tech", "Artificial Intelligence and Machine Learning", "UG", 4,
                                "B.Tech AI/ML with Python, TensorFlow, Deep Learning, NLP, Computer Vision. Industry-oriented curriculum",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtAI, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(sirtAI, "OBC", 30, 10, "2026-27");
                createFeeStructure(sirtAI, "2026-27", new BigDecimal("90000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("162000"), "PER_YEAR");
                createCutoff(sirtAI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("68.0"), 240000, "JEE Main");
                createCutoff(sirtAI, "OBC", "2023-2024", "Round 1", new BigDecimal("58.0"), 370000, "JEE Main");

                // ---- SIRT B.Tech Data Science ----
                Course sirtDS = createCourse(sirt, "B.Tech", "Data Science", "UG", 4,
                                "B.Tech Data Science with Big Data Analytics, Hadoop, Spark, Tableau, R, and Python",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtDS, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(sirtDS, "OBC", 30, 10, "2026-27");
                createFeeStructure(sirtDS, "2026-27", new BigDecimal("90000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("162000"), "PER_YEAR");
                createCutoff(sirtDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("66.0"), 250000, "JEE Main");

                // ---- SIRT B.Tech Cyber Security ----
                Course sirtCyber = createCourse(sirt, "B.Tech", "Cyber Security", "UG", 4,
                                "B.Tech Cyber Security with Ethical Hacking, Network Security, Cryptography, Digital Forensics",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtCyber, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sirtCyber, "2026-27", new BigDecimal("90000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("162000"), "PER_YEAR");
                createCutoff(sirtCyber, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), 260000, "JEE Main");

                // ---- SIRT B.Tech ECE ----
                Course sirtECE = createCourse(sirt, "B.Tech", "Electronics and Communication Engineering", "UG", 4,
                                "B.Tech ECE with VLSI Design, Embedded Systems, IoT, Signal Processing, and Communication Systems",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtECE, "GENERAL", 120, 40, "2026-27");
                createSeatMatrix(sirtECE, "OBC", 60, 20, "2026-27");
                createSeatMatrix(sirtECE, "SC", 30, 10, "2026-27");
                createFeeStructure(sirtECE, "2026-27", new BigDecimal("75000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("143000"), "PER_YEAR");
                createCutoff(sirtECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("62.0"), 310000, "JEE Main");
                createCutoff(sirtECE, "OBC", "2023-2024", "Round 1", new BigDecimal("54.0"), 430000, "JEE Main");

                // ---- SIRT B.Tech EE ----
                Course sirtEE = createCourse(sirt, "B.Tech", "Electrical Engineering", "UG", 4,
                                "B.Tech EE with Power Systems, Control Engineering, Electrical Machines, and Renewable Energy",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtEE, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(sirtEE, "OBC", 30, 12, "2026-27");
                createFeeStructure(sirtEE, "2026-27", new BigDecimal("72000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("7000"),
                                new BigDecimal("139000"), "PER_YEAR");
                createCutoff(sirtEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("58.0"), 370000, "JEE Main");
                createCutoff(sirtEE, "OBC", "2023-2024", "Round 1", new BigDecimal("50.0"), 500000, "JEE Main");

                // ---- SIRT B.Tech ME (Mechanical) ----
                Course sirtME = createCourse(sirt, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "B.Tech ME with CAD/CAM, Robotics, Thermodynamics, Manufacturing, Automobile Engineering",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtME, "GENERAL", 120, 40, "2026-27");
                createSeatMatrix(sirtME, "OBC", 60, 20, "2026-27");
                createSeatMatrix(sirtME, "SC", 30, 10, "2026-27");
                createFeeStructure(sirtME, "2026-27", new BigDecimal("75000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("143000"), "PER_YEAR");
                createCutoff(sirtME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("62.0"), 320000, "JEE Main");
                createCutoff(sirtME, "OBC", "2023-2024", "Round 1", new BigDecimal("54.0"), 440000, "JEE Main");
                createCutoff(sirtME, "SC", "2023-2024", "Round 1", new BigDecimal("42.0"), 620000, "JEE Main");

                // ---- SIRT B.Tech Civil ----
                Course sirtCivil = createCourse(sirt, "B.Tech", "Civil Engineering", "UG", 4,
                                "B.Tech Civil with Structural Engineering, Surveying, Construction Management, Environmental Engineering",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sirtCivil, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(sirtCivil, "OBC", 30, 12, "2026-27");
                createFeeStructure(sirtCivil, "2026-27", new BigDecimal("70000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("7000"),
                                new BigDecimal("136000"), "PER_YEAR");
                createCutoff(sirtCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), 420000, "JEE Main");
                createCutoff(sirtCivil, "OBC", "2023-2024", "Round 1", new BigDecimal("48.0"), 550000, "JEE Main");

                // ---- SIRT M.Tech CSE ----
                Course sirtMTechCSE = createCourse(sirt, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "M.Tech CSE with Advanced Algorithms, AI/ML, Cloud Computing, and Research",
                                "GATE / B.Tech with 55%");
                createSeatMatrix(sirtMTechCSE, "GENERAL", 18, 8, "2026-27");
                createFeeStructure(sirtMTechCSE, "2026-27", new BigDecimal("72000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("140000"), "PER_YEAR");
                createCutoff(sirtMTechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("400"), null,
                                "GATE Score");

                // ---- SIRT M.Tech VLSI ----
                Course sirtMTechVLSI = createCourse(sirt, "M.Tech", "VLSI Design", "PG", 2,
                                "M.Tech VLSI Design with Chip Design, Verilog/VHDL, FPGA, and ASIC Design",
                                "GATE / B.Tech ECE with 55%");
                createSeatMatrix(sirtMTechVLSI, "GENERAL", 18, 8, "2026-27");
                createFeeStructure(sirtMTechVLSI, "2026-27", new BigDecimal("72000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("140000"), "PER_YEAR");
                createCutoff(sirtMTechVLSI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("350"), null,
                                "GATE Score");

                // ---- SIRT MBA ----
                Course sirtMBA = createCourse(sirt, "MBA", "Management", "PG", 2,
                                "MBA with specializations in Finance, Marketing, HR, Operations, IT. Industry visits, live projects, summer internship mandatory",
                                "CAT/MAT/CMAT/MP-MET with graduation 50%");
                createSeatMatrix(sirtMBA, "GENERAL", 120, 35, "2026-27");
                createSeatMatrix(sirtMBA, "OBC", 60, 18, "2026-27");
                createSeatMatrix(sirtMBA, "SC", 30, 10, "2026-27");
                createFeeStructure(sirtMBA, "2026-27", new BigDecimal("65000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("129000"), "PER_YEAR");
                createCutoff(sirtMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "CAT/MAT");
                createCutoff(sirtMBA, "OBC", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "CAT/MAT");

                // ---- SIRT BBA ----
                Course sirtBBA = createCourse(sirt, "BBA", "Business Administration", "UG", 3,
                                "BBA with Marketing, Finance, HR specializations. Industry exposure, guest lectures, and placement training",
                                "12th with 45%");
                createSeatMatrix(sirtBBA, "GENERAL", 120, 40, "2026-27");
                createSeatMatrix(sirtBBA, "OBC", 60, 20, "2026-27");
                createFeeStructure(sirtBBA, "2026-27", new BigDecimal("48000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("6000"),
                                new BigDecimal("100000"), "PER_YEAR");
                createCutoff(sirtBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit");

                // ---- SIRT BCA ----
                Course sirtBCA = createCourse(sirt, "BCA", "Computer Applications", "UG", 3,
                                "BCA with C, C++, Java, Python, Web Development, DBMS, Data Structures, and Project Work",
                                "12th with 45%");
                createSeatMatrix(sirtBCA, "GENERAL", 120, 40, "2026-27");
                createSeatMatrix(sirtBCA, "OBC", 60, 20, "2026-27");
                createFeeStructure(sirtBCA, "2026-27", new BigDecimal("45000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("102000"), "PER_YEAR");
                createCutoff(sirtBCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- SIRT MCA ----
                Course sirtMCA = createCourse(sirt, "MCA", "Computer Applications", "PG", 2,
                                "MCA with Advanced Java, .NET, Python, Android Development, Cloud Computing, and Software Project Management",
                                "BCA/B.Sc (CS/IT) with 50%");
                createSeatMatrix(sirtMCA, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(sirtMCA, "OBC", 30, 10, "2026-27");
                createFeeStructure(sirtMCA, "2026-27", new BigDecimal("60000"), new BigDecimal("38000"),
                                new BigDecimal("8000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("7000"),
                                new BigDecimal("123000"), "PER_YEAR");
                createCutoff(sirtMCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("52.0"), null, "Merit");

                // ---- SIRT B.Pharm ----
                Course sirtBPharm = createCourse(sirt, "B.Pharm", "Pharmacy", "UG", 4,
                                "B.Pharm with Pharmaceutics, Pharmacology, Pharmaceutical Chemistry, Pharmacognosy. PCI approved with modern drug testing lab",
                                "12th with PCM/PCB 45%");
                createSeatMatrix(sirtBPharm, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(sirtBPharm, "OBC", 30, 10, "2026-27");
                createSeatMatrix(sirtBPharm, "SC", 15, 5, "2026-27");
                createFeeStructure(sirtBPharm, "2026-27", new BigDecimal("72000"), new BigDecimal("38000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("10000"),
                                new BigDecimal("8000"),
                                new BigDecimal("142000"), "PER_YEAR");
                createCutoff(sirtBPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit/PEPT");
                createCutoff(sirtBPharm, "OBC", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit/PEPT");

                // ---- SIRT D.Pharm ----
                Course sirtDPharm = createCourse(sirt, "D.Pharm", "Pharmacy", "Diploma", 2,
                                "Diploma in Pharmacy - foundation course for pharmacy practice. PCI approved",
                                "12th with PCM/PCB 40%");
                createSeatMatrix(sirtDPharm, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(sirtDPharm, "OBC", 30, 10, "2026-27");
                createFeeStructure(sirtDPharm, "2026-27", new BigDecimal("52000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("8000"),
                                new BigDecimal("6000"),
                                new BigDecimal("112000"), "PER_YEAR");
                createCutoff(sirtDPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- SIRT B.Com ----
                Course sirtBCom = createCourse(sirt, "B.Com", "Commerce", "UG", 3,
                                "B.Com with Accounting, Taxation, Business Law, Economics, Financial Management",
                                "12th with 45%");
                createSeatMatrix(sirtBCom, "GENERAL", 120, 45, "2026-27");
                createSeatMatrix(sirtBCom, "OBC", 60, 22, "2026-27");
                createFeeStructure(sirtBCom, "2026-27", new BigDecimal("28000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("4000"),
                                new BigDecimal("70000"), "PER_YEAR");
                createCutoff(sirtBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- SIRT B.Sc CS ----
                Course sirtBScCS = createCourse(sirt, "B.Sc", "Computer Science", "UG", 3,
                                "B.Sc CS with Programming (C, Java, Python), Data Structures, DBMS, Web Development",
                                "12th with 50% in PCM");
                createSeatMatrix(sirtBScCS, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sirtBScCS, "2026-27", new BigDecimal("35000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("4000"),
                                new BigDecimal("4500"),
                                new BigDecimal("82000"), "PER_YEAR");
                createCutoff(sirtBScCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit");

                // ---- SIRT B.Sc IT ----
                Course sirtBScIT = createCourse(sirt, "B.Sc", "Information Technology", "UG", 3,
                                "B.Sc IT with Networking, Database Administration, Software Testing, and Web Technologies",
                                "12th with 45%");
                createSeatMatrix(sirtBScIT, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sirtBScIT, "2026-27", new BigDecimal("32000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("4000"),
                                new BigDecimal("4500"),
                                new BigDecimal("79000"), "PER_YEAR");
                createCutoff(sirtBScIT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit");

                // ---- SIRT Diploma Polytechnic ----
                Course sirtDiplomaCS = createCourse(sirt, "Diploma", "Computer Science Engineering", "Diploma", 3,
                                "Diploma in CS Engineering (Polytechnic) after 10th. Covers programming, hardware, networking basics",
                                "10th pass with 35%");
                createSeatMatrix(sirtDiplomaCS, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(sirtDiplomaCS, "OBC", 30, 12, "2026-27");
                createFeeStructure(sirtDiplomaCS, "2026-27", new BigDecimal("32000"), new BigDecimal("28000"),
                                new BigDecimal("6000"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("76000"), "PER_YEAR");
                createCutoff(sirtDiplomaCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("40.0"), null,
                                "Merit (10th)");

                // ---- SIRT Diploma ME ----
                Course sirtDiplomaME = createCourse(sirt, "Diploma", "Mechanical Engineering", "Diploma", 3,
                                "Diploma in Mechanical Engineering (Polytechnic) after 10th. Workshop practice, manufacturing basics",
                                "10th pass with 35%");
                createSeatMatrix(sirtDiplomaME, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sirtDiplomaME, "2026-27", new BigDecimal("30000"), new BigDecimal("28000"),
                                new BigDecimal("6000"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("74000"), "PER_YEAR");
                createCutoff(sirtDiplomaME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("35.0"), null,
                                "Merit (10th)");

                // ---- SIRT Diploma EE ----
                Course sirtDiplomaEE = createCourse(sirt, "Diploma", "Electrical Engineering", "Diploma", 3,
                                "Diploma in Electrical Engineering (Polytechnic) after 10th. Power systems, wiring, electrical machines",
                                "10th pass with 35%");
                createSeatMatrix(sirtDiplomaEE, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sirtDiplomaEE, "2026-27", new BigDecimal("30000"), new BigDecimal("28000"),
                                new BigDecimal("6000"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("74000"), "PER_YEAR");
                createCutoff(sirtDiplomaEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("35.0"), null,
                                "Merit (10th)");

                // ---- SIRT Diploma Civil ----
                Course sirtDiplomaCivil = createCourse(sirt, "Diploma", "Civil Engineering", "Diploma", 3,
                                "Diploma in Civil Engineering (Polytechnic) after 10th. Surveying, construction, building materials",
                                "10th pass with 35%");
                createSeatMatrix(sirtDiplomaCivil, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sirtDiplomaCivil, "2026-27", new BigDecimal("28000"), new BigDecimal("28000"),
                                new BigDecimal("6000"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("4000"),
                                new BigDecimal("71000"), "PER_YEAR");
                createCutoff(sirtDiplomaCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("35.0"), null,
                                "Merit (10th)");

                // 15. Truba Institute of Engineering
                College truba = createCollege(
                                "Truba Institute of Engineering and Information Technology",
                                "Truba is an AICTE approved engineering college offering quality technical education in various disciplines.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Mandideep, Bhopal, MP 462046",
                                "462046",
                                "07480-233500",
                                "info@trubainstitute.ac.in",
                                "https://www.trubainstitute.ac.in",
                                "B++",
                                true,
                                2001,
                                "RGPV");

                Course trubaCSE = createCourse(truba, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(trubaCSE, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(trubaCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("7000"),
                                new BigDecimal("120000"), "PER_YEAR");
                createCutoff(trubaCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), 350000,
                                "JEE Main/Merit");
                createCutoff(trubaCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("52.0"), 500000, "JEE Main/Merit");

                // 16. Scope College of Engineering
                College scope = createCollege(
                                "Scope College of Engineering",
                                "Scope College offers quality engineering education with focus on practical learning and industry readiness.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hoshangabad Road, Misrod, Bhopal, MP 462047",
                                "462047",
                                "0755-2835600",
                                "info@scopecollege.ac.in",
                                "https://www.scopecollege.ac.in",
                                "B+",
                                true,
                                2003,
                                "RGPV");

                Course scopeCSE = createCourse(scope, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(scopeCSE, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(scopeCSE, "2026-27", new BigDecimal("50000"), new BigDecimal("30000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("5000"),
                                new BigDecimal("100000"), "PER_YEAR");
                createCutoff(scopeCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), 400000,
                                "JEE Main/Merit");

                // 17. RKDF University
                College rkdf = createCollege(
                                "RKDF University",
                                "RKDF University is a private university in Bhopal offering diverse programs in engineering, management, pharmacy and more.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Airport Bypass Road, Gandhi Nagar, Bhopal, MP 462033",
                                "462033",
                                "0755-4082800",
                                "info@rkdf.ac.in",
                                "https://www.rkdf.ac.in",
                                "A",
                                true,
                                2012,
                                "UGC Approved Private University");

                Course rkdfCSE = createCourse(rkdf, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 50% in PCM");
                createSeatMatrix(rkdfCSE, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(rkdfCSE, "2026-27", new BigDecimal("90000"), new BigDecimal("45000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("10000"),
                                new BigDecimal("169000"), "PER_YEAR");
                createCutoff(rkdfCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("68.0"), 230000, "JEE Main");
                createCutoff(rkdfCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("60.0"), 360000, "JEE Main");

                Course rkdfBBA = createCourse(rkdf, "BBA", "Business Administration", "UG", 3,
                                "Bachelor of Business Administration", "12th pass with 50%");
                createSeatMatrix(rkdfBBA, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(rkdfBBA, "2026-27", new BigDecimal("22000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("7000"),
                                new BigDecimal("82000"), "PER_YEAR");
                createCutoff(rkdfBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null, "Merit");

                Course rkdfBPharm = createCourse(rkdf, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy", "12th with PCB/PCM 50%");
                createSeatMatrix(rkdfBPharm, "GENERAL", 100, 25, "2026-27");
                createFeeStructure(rkdfBPharm, "2026-27", new BigDecimal("55000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("8000"),
                                new BigDecimal("8000"),
                                new BigDecimal("125000"), "PER_YEAR");
                createCutoff(rkdfBPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "Merit");

                // 18. VNS Group of Institutions
                College vns = createCollege(
                                "VNS Group of Institutions",
                                "VNS offers engineering and management programs with focus on skill development and employability.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Vidisha Road, Raisen, Bhopal, MP 462044",
                                "462044",
                                "07482-221000",
                                "info@vns.ac.in",
                                "https://www.vns.ac.in",
                                "B++",
                                true,
                                2001,
                                "RGPV");

                Course vnsCSE = createCourse(vns, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(vnsCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(vnsCSE, "2026-27", new BigDecimal("45000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("104000"), "PER_YEAR");
                createCutoff(vnsCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("58.0"), 380000,
                                "JEE Main/Merit");

                // 19. Bansal Institute of Science and Technology
                College bansal = createCollege(
                                "Bansal Institute of Science and Technology (BIST)",
                                "BIST is an AICTE approved engineering college providing quality education with strong industry connections.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Kokta, Anand Nagar, Bhopal, MP 462021",
                                "462021",
                                "0755-2696444",
                                "info@bistbhopal.com",
                                "https://www.bistbhopal.com",
                                "B+",
                                true,
                                2004,
                                "RGPV");

                Course bansalCSE = createCourse(bansal, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(bansalCSE, "GENERAL", 90, 25, "2026-27");
                createFeeStructure(bansalCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("32000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("113000"), "PER_YEAR");
                createCutoff(bansalCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), 420000,
                                "JEE Main/Merit");
                createCutoff(bansalCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("48.0"), 550000,
                                "JEE Main/Merit");

                // 20. NRI Institute of Information Science & Technology
                College nri = createCollege(
                                "NRI Institute of Information Science and Technology",
                                "NRI Institute offers quality technical education with modern labs and experienced faculty.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Govindpura, Bhopal, MP 462023",
                                "462023",
                                "0755-2676350",
                                "info@nriist.com",
                                "https://www.nriist.com",
                                "B+",
                                true,
                                2000,
                                "RGPV");

                Course nriCSE = createCourse(nri, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(nriCSE, "GENERAL", 90, 30, "2026-27");
                createCutoff(nriCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("52.0"), 450000,
                                "JEE Main/Merit");
                createFeeStructure(nriCSE, "2026-27", new BigDecimal("65000"), new BigDecimal("30000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("5000"),
                                new BigDecimal("115000"), "PER_YEAR");

                // 21. Chameli Devi Group of Institutions
                College chameli = createCollege(
                                "Chameli Devi Group of Institutions",
                                "Chameli Devi offers engineering and management education with focus on holistic development.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Kolar Road, Bhopal, MP 462042",
                                "462042",
                                "0755-2493693",
                                "info@cdgi.edu.in",
                                "https://www.cdgi.edu.in",
                                "B++",
                                true,
                                2006,
                                "RGPV");

                Course chameliCSE = createCourse(chameli, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(chameliCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(chameliCSE, "2026-27", new BigDecimal("85000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("145000"), "PER_YEAR");

                // 22. Radharaman Group of Institutes
                College radharaman = createCollege(
                                "Radharaman Group of Institutes",
                                "Radharaman offers quality engineering and management education with modern infrastructure.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Ratibad, Bhopal, MP 462044",
                                "462044",
                                "0755-2401500",
                                "info@radharaman.in",
                                "https://www.radharaman.in",
                                "B+",
                                true,
                                2000,
                                "RGPV");

                Course radharamanCSE = createCourse(radharaman, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(radharamanCSE, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(radharamanCSE, "2026-27", new BigDecimal("52000"), new BigDecimal("32000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("5000"),
                                new BigDecimal("104000"), "PER_YEAR");

                // 23. Patel College of Science and Technology
                College patel = createCollege(
                                "Patel College of Science and Technology (PCST)",
                                "PCST offers engineering and management programs with emphasis on practical skills and placements.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Ratibad, Bhopal, MP 462044",
                                "462044",
                                "0755-2895100",
                                "info@pcst.ac.in",
                                "https://www.pcst.ac.in",
                                "B++",
                                true,
                                2002,
                                "RGPV");

                Course patelCSE = createCourse(patel, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(patelCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(patelCSE, "2026-27", new BigDecimal("56000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("115500"), "PER_YEAR");

                // 24. Bhabha Engineering Research Institute
                College bhabha = createCollege(
                                "Bhabha Engineering Research Institute (BERI)",
                                "BERI is an AICTE approved engineering institute offering B.Tech programs in various specializations.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hoshangabad Road, Bhopal, MP 462026",
                                "462026",
                                "0755-2462015",
                                "info@bhabhaengg.com",
                                "https://www.bhabhaengg.com",
                                "B+",
                                true,
                                1999,
                                "RGPV");

                Course bhabhaCSE = createCourse(bhabha, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(bhabhaCSE, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(bhabhaCSE, "2026-27", new BigDecimal("44000"), new BigDecimal("28000"),
                                new BigDecimal("7000"), new BigDecimal("2500"), new BigDecimal("4000"),
                                new BigDecimal("4500"),
                                new BigDecimal("90000"), "PER_YEAR");

                // ==================== PRIVATE MEDICAL ====================

                // 25. People's College of Medical Sciences
                College peoples = createCollege(
                                "People's College of Medical Sciences and Research Centre",
                                "PCMS is a well-established private medical college offering MBBS and other medical programs with attached hospital.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Peoples Campus, Bhanpur, Bhopal, MP 462037",
                                "462037",
                                "0755-4005000",
                                "pcms@peoplesuniversity.edu.in",
                                "https://www.peoplesuniversity.edu.in",
                                "A",
                                true,
                                1997,
                                "People's University");

                Course peoplesMBBS = createCourse(peoples, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(peoplesMBBS, "GENERAL", 150, 20, "2026-27");
                createFeeStructure(peoplesMBBS, "2026-27", new BigDecimal("1500000"), new BigDecimal("80000"),
                                new BigDecimal("0"), new BigDecimal("15000"), new BigDecimal("25000"),
                                new BigDecimal("30000"),
                                new BigDecimal("1650000"), "PER_YEAR");
                createCutoff(peoplesMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), 150000, "NEET UG");

                Course peoplesBDS = createCourse(peoples, "BDS", "Dental Surgery", "UG", 5,
                                "Bachelor of Dental Surgery", "NEET UG qualified");
                createSeatMatrix(peoplesBDS, "GENERAL", 100, 15, "2026-27");
                createFeeStructure(peoplesBDS, "2026-27", new BigDecimal("800000"), new BigDecimal("60000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("15000"),
                                new BigDecimal("20000"),
                                new BigDecimal("905000"), "PER_YEAR");

                // 26. Chirayu Medical College
                College chirayu = createCollege(
                                "Chirayu Medical College and Hospital",
                                "Chirayu is a private medical college with multi-specialty hospital offering comprehensive medical education.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Bhainsakhedi, Bairagarh, Bhopal, MP 462030",
                                "462030",
                                "0755-6679100",
                                "info@chirayumedicalcollege.com",
                                "https://www.chirayumedicalcollege.com",
                                "A",
                                true,
                                2010,
                                "MPMC");

                Course chirayuMBBS = createCourse(chirayu, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(chirayuMBBS, "GENERAL", 150, 25, "2026-27");
                createFeeStructure(chirayuMBBS, "2026-27", new BigDecimal("1400000"), new BigDecimal("75000"),
                                new BigDecimal("0"), new BigDecimal("12000"), new BigDecimal("20000"),
                                new BigDecimal("25000"),
                                new BigDecimal("1532000"), "PER_YEAR");
                createCutoff(chirayuMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("82.0"), 180000, "NEET UG");

                Course chirayuBSc = createCourse(chirayu, "B.Sc", "Nursing", "UG", 4,
                                "Bachelor of Science in Nursing", "12th PCB with 50%");
                createSeatMatrix(chirayuBSc, "GENERAL", 100, 20, "2026-27");
                createFeeStructure(chirayuBSc, "2026-27", new BigDecimal("120000"), new BigDecimal("50000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("193000"), "PER_YEAR");

                // 27. L.N. Medical College
                College lnmc = createCollege(
                                "L.N. Medical College and J.K. Hospital",
                                "LNMC is part of LNCT Group offering medical education with attached super-specialty hospital.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "J.K. Town, Kolar Road, Bhopal, MP 462042",
                                "462042",
                                "0755-4084100",
                                "info@lnmc.ac.in",
                                "https://www.lnmc.ac.in",
                                "A",
                                true,
                                2007,
                                "MPMC");

                Course lnmcMBBS = createCourse(lnmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(lnmcMBBS, "GENERAL", 150, 20, "2026-27");
                createFeeStructure(lnmcMBBS, "2026-27", new BigDecimal("1350000"), new BigDecimal("70000"),
                                new BigDecimal("0"), new BigDecimal("12000"), new BigDecimal("18000"),
                                new BigDecimal("25000"),
                                new BigDecimal("1475000"), "PER_YEAR");

                // ==================== PHARMACY COLLEGES ====================

                // 28. People's College of Pharmacy
                College peoplesPharmacy = createCollege(
                                "People's College of Pharmacy",
                                "Part of People's University, offering comprehensive pharmacy education with excellent labs.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Peoples Campus, Bhanpur, Bhopal, MP 462037",
                                "462037",
                                "0755-4005200",
                                "pharmacy@peoplesuniversity.edu.in",
                                "https://www.peoplesuniversity.edu.in/pharmacy",
                                "A",
                                true,
                                1998,
                                "People's University");

                Course peoplesBPharm = createCourse(peoplesPharmacy, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy", "12th with PCM/PCB 50%");
                createSeatMatrix(peoplesBPharm, "GENERAL", 100, 25, "2026-27");
                createFeeStructure(peoplesBPharm, "2026-27", new BigDecimal("85000"), new BigDecimal("45000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("165000"), "PER_YEAR");

                Course peoplesDPharm = createCourse(peoplesPharmacy, "D.Pharm", "Pharmacy", "Diploma", 2,
                                "Diploma in Pharmacy", "12th with PCM/PCB 45%");
                createSeatMatrix(peoplesDPharm, "GENERAL", 60, 15, "2026-27");
                createFeeStructure(peoplesDPharm, "2026-27", new BigDecimal("55000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("112000"), "PER_YEAR");

                // 29. Oriental College of Pharmacy
                College orientalPharm = createCollege(
                                "Oriental College of Pharmacy",
                                "Part of Oriental Group offering quality pharmacy education with good placement record.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Raisen Road, Bhopal, MP 462021",
                                "462021",
                                "0755-2751900",
                                "pharmacy@oriental.ac.in",
                                "https://www.oriental.ac.in/pharmacy",
                                "B++",
                                true,
                                2002,
                                "RGPV");

                Course orientalBPharm = createCourse(orientalPharm, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy", "12th with PCM/PCB 50%");
                createSeatMatrix(orientalBPharm, "GENERAL", 60, 18, "2026-27");
                createFeeStructure(orientalBPharm, "2026-27", new BigDecimal("70000"), new BigDecimal("38000"),
                                new BigDecimal("8000"), new BigDecimal("4000"), new BigDecimal("8000"),
                                new BigDecimal("7000"),
                                new BigDecimal("135000"), "PER_YEAR");

                // ==================== LAW COLLEGES ====================

                // 30. National Law Institute University (NLIU)
                College nliu = createCollege(
                                "National Law Institute University (NLIU) Bhopal",
                                "NLIU is a premier national law university offering quality legal education. One of the top NLUs in India.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Kerwa Dam Road, Bhopal, MP 462044",
                                "462044",
                                "0755-2696965",
                                "registrar@nliu.ac.in",
                                "https://www.nliu.ac.in",
                                "A++",
                                true,
                                1997,
                                "Autonomous (National Law University)");

                Course nliuBALLB = createCourse(nliu, "BA LLB", "Law", "UG", 5,
                                "Bachelor of Arts and Bachelor of Laws (Integrated)", "CLAT qualified");
                createSeatMatrix(nliuBALLB, "GENERAL", 80, 8, "2026-27");
                createSeatMatrix(nliuBALLB, "OBC", 45, 5, "2026-27");
                createSeatMatrix(nliuBALLB, "SC", 25, 3, "2026-27");
                createSeatMatrix(nliuBALLB, "ST", 15, 2, "2026-27");
                createFeeStructure(nliuBALLB, "2026-27", new BigDecimal("210000"), new BigDecimal("68100"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("0"),
                                new BigDecimal("7700"),
                                new BigDecimal("295800"), "PER_YEAR");
                createCutoff(nliuBALLB, "GENERAL", "2023-2024", "Round 1", new BigDecimal("95.0"), 750, "CLAT");

                Course nliuLLM = createCourse(nliu, "LLM", "Law", "PG", 1,
                                "Master of Laws", "LLB with 55% / CLAT PG");
                createSeatMatrix(nliuLLM, "GENERAL", 50, 8, "2026-27");
                createFeeStructure(nliuLLM, "2026-27", new BigDecimal("165000"), new BigDecimal("60000"),
                                new BigDecimal("0"), new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("12000"),
                                new BigDecimal("245000"), "PER_YEAR");

                // ==================== MORE ENGINEERING COLLEGES ====================

                // 31. Sushila Devi Bansal College of Technology
                College sdbct = createCollege(
                                "Sushila Devi Bansal College of Technology (SDBCT)",
                                "SDBCT offers quality technical education with good infrastructure and experienced faculty.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Kokta, Anand Nagar, Bhopal, MP 462021",
                                "462021",
                                "0755-2696500",
                                "info@sdbct.ac.in",
                                "https://www.sdbct.ac.in",
                                "B+",
                                true,
                                2006,
                                "RGPV");

                Course sdbctCSE = createCourse(sdbct, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(sdbctCSE, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sdbctCSE, "2026-27", new BigDecimal("55000"), new BigDecimal("30000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("5000"),
                                new BigDecimal("105000"), "PER_YEAR");

                // 32. Extol College
                College extol = createCollege(
                                "Extol College of Engineering and Management",
                                "Extol College offers engineering and management programs with focus on skill development.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "AB Road, Bhopal, MP 462026",
                                "462026",
                                "0755-2605100",
                                "info@extolcollege.ac.in",
                                "https://www.extolcollege.ac.in",
                                "B",
                                true,
                                2007,
                                "RGPV");

                Course extolCSE = createCourse(extol, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(extolCSE, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(extolCSE, "2026-27", new BigDecimal("48000"), new BigDecimal("28000"),
                                new BigDecimal("7000"), new BigDecimal("2500"), new BigDecimal("3500"),
                                new BigDecimal("4000"),
                                new BigDecimal("93000"), "PER_YEAR");

                // 33. Sri Satya Sai College of Engineering
                College sssEngg = createCollege(
                                "Sri Satya Sai College of Engineering (SSCE)",
                                "SSCE offers engineering education with focus on values-based learning and holistic development.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Sehore Road, Bhopal, MP 462036",
                                "462036",
                                "0755-2483100",
                                "info@sssit.ac.in",
                                "https://www.sssit.ac.in",
                                "B",
                                true,
                                2005,
                                "RGPV");

                Course sssCSE = createCourse(sssEngg, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(sssCSE, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sssCSE, "2026-27", new BigDecimal("52000"), new BigDecimal("28000"),
                                new BigDecimal("7000"), new BigDecimal("2500"), new BigDecimal("4000"),
                                new BigDecimal("4500"),
                                new BigDecimal("98000"), "PER_YEAR");

                // 34. Millennium Group of Institutions
                College millennium = createCollege(
                                "Millennium Group of Institutions",
                                "Millennium offers engineering and management programs with industry-oriented curriculum.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Neelbad Road, Bhopal, MP 462044",
                                "462044",
                                "0755-4271400",
                                "info@millenniumgroup.edu.in",
                                "https://www.millenniumgroup.edu.in",
                                "B+",
                                true,
                                2008,
                                "RGPV");

                Course millenniumCSE = createCourse(millennium, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(millenniumCSE, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(millenniumCSE, "2026-27", new BigDecimal("58000"), new BigDecimal("32000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("4500"),
                                new BigDecimal("5000"),
                                new BigDecimal("110500"), "PER_YEAR");

                // 35. Lakshmi Narain College of Technology - Excellence
                College lncte = createCollege(
                                "Lakshmi Narain College of Technology Excellence (LNCTE)",
                                "LNCTE is part of LNCT Group offering specialized engineering programs with excellent placements.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Naveen Nagar, Kalchuri, Bhopal, MP 462022",
                                "462022",
                                "0755-4003100",
                                "info@lncte.ac.in",
                                "https://www.lncte.ac.in",
                                "A",
                                true,
                                2004,
                                "RGPV");

                Course lncteCSE = createCourse(lncte, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(lncteCSE, "GENERAL", 180, 45, "2026-27");
                createFeeStructure(lncteCSE, "2026-27", new BigDecimal("90000"), new BigDecimal("45000"),
                                new BigDecimal("15000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("173000"), "PER_YEAR");

                Course lncteAI = createCourse(lncte, "B.Tech", "Artificial Intelligence", "UG", 4,
                                "B.Tech in Artificial Intelligence", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(lncteAI, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(lncteAI, "2026-27", new BigDecimal("105000"), new BigDecimal("45000"),
                                new BigDecimal("15000"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("192000"), "PER_YEAR");

                // 36. IES College of Technology
                College ies = createCollege(
                                "IES College of Technology",
                                "IES offers engineering programs with emphasis on practical skills and industry exposure.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Ratibad, Bhopal, MP 462044",
                                "462044",
                                "0755-2895500",
                                "info@iescollege.ac.in",
                                "https://www.iescollege.ac.in",
                                "B++",
                                true,
                                2003,
                                "RGPV");

                Course iesCSE = createCourse(ies, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(iesCSE, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(iesCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("32000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5500"),
                                new BigDecimal("113500"), "PER_YEAR");

                // 37. Sagar Institute of Science Technology & Engineering (SISTec)
                College sistec = createCollege(
                                "Sagar Institute of Science Technology and Engineering (SISTec)",
                                "SISTec is part of Sagar Group offering quality engineering education with excellent placements.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Gandhi Nagar, Bhopal, MP 462036",
                                "462036",
                                "0755-4274900",
                                "info@sistec.ac.in",
                                "https://www.sistec.ac.in",
                                "A",
                                true,
                                2008,
                                "RGPV");

                Course sistecCSE = createCourse(sistec, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(sistecCSE, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(sistecCSE, "2026-27", new BigDecimal("80000"), new BigDecimal("42000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("9000"),
                                new BigDecimal("155000"), "PER_YEAR");

                Course sistecMBA = createCourse(sistec, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT/CMAT with graduation");
                createSeatMatrix(sistecMBA, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(sistecMBA, "2026-27", new BigDecimal("76000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("141000"), "PER_YEAR");

                // 38. Jaypee Vyapti Engineering College (Part of ITM University)
                College itm = createCollege(
                                "ITM University Gwalior - Bhopal Campus",
                                "ITM offers quality management and engineering programs with excellent corporate connections.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hoshangabad Road, Bhopal, MP 462026",
                                "462026",
                                "0755-4224600",
                                "info@itmuniversity.ac.in",
                                "https://www.itmuniversity.ac.in",
                                "A",
                                true,
                                2011,
                                "UGC Approved");

                Course itmMBA = createCourse(itm, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT/XAT with graduation");
                createSeatMatrix(itmMBA, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(itmMBA, "2026-27", new BigDecimal("250000"), new BigDecimal("60000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("17000"),
                                new BigDecimal("350000"), "PER_YEAR");

                // 39. IPS Academy
                College ips = createCollege(
                                "IPS Academy Bhopal",
                                "IPS Academy offers diverse programs in engineering, management, pharmacy and computer applications.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Knowledge Village, Rajendra Nagar, Bhopal, MP 462023",
                                "462023",
                                "0755-2677500",
                                "info@ipsacademy.org",
                                "https://www.ipsacademy.org",
                                "A",
                                true,
                                1999,
                                "RGPV / DAVV");

                Course ipsCSE = createCourse(ips, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(ipsCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(ipsCSE, "2026-27", new BigDecimal("75000"), new BigDecimal("38000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("7000"),
                                new BigDecimal("140000"), "PER_YEAR");

                Course ipsMCA = createCourse(ips, "MCA", "Computer Applications", "PG", 2,
                                "Master of Computer Applications", "BCA/B.Sc with 50%");
                createSeatMatrix(ipsMCA, "GENERAL", 90, 25, "2026-27");
                createFeeStructure(ipsMCA, "2026-27", new BigDecimal("65000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("123000"), "PER_YEAR");

                // 40. Govt. M.L.B. Girls PG Autonomous College
                College mlb = createCollege(
                                "Government M.L.B. Girls PG Autonomous College",
                                "One of the premier government women's colleges in Bhopal offering quality education in various disciplines.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "South TT Nagar, Bhopal, MP 462003",
                                "462003",
                                "0755-2555789",
                                "principal.mlb@mp.gov.in",
                                "https://www.mlbbhopal.ac.in",
                                "A",
                                true,
                                1954,
                                "Barkatullah University");

                Course mlbBA = createCourse(mlb, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts (Girls Only)", "12th pass (Girls)");
                createSeatMatrix(mlbBA, "GENERAL", 400, 100, "2026-27");
                createFeeStructure(mlbBA, "2026-27", new BigDecimal("2500"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("600"), new BigDecimal("0"), new BigDecimal("900"),
                                new BigDecimal("4000"), "PER_YEAR");

                Course mlbBSc = createCourse(mlb, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science (Girls Only)", "12th with Science (Girls)");
                createSeatMatrix(mlbBSc, "GENERAL", 300, 80, "2026-27");
                createFeeStructure(mlbBSc, "2026-27", new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("1500"),
                                new BigDecimal("1000"),
                                new BigDecimal("7500"), "PER_YEAR");

                // ==================== SAGE UNIVERSITY BHOPAL ====================

                // 41. Sage University Bhopal
                College sageBhopal = createCollege(
                                "Sage University Bhopal",
                                "SAGE University Bhopal is a premier private university offering diverse programs in Engineering, Management, Law, Pharmacy, Agriculture, and Design. Known for excellent infrastructure, industry collaborations, and 100% placement assistance.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Katara Hills, Kolar Road, Bhopal, MP 462043",
                                "462043",
                                "0755-6676999",
                                "info@sfrseuniversity.edu.in",
                                "https://www.sageuniversity.edu.in",
                                "A+",
                                true,
                                2017,
                                "UGC Approved Private University");

                // B.Tech CSE
                Course sageBhopalCSE = createCourse(sageBhopal, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in Computer Science with specializations in AI, ML, Data Science, Cyber Security",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalCSE, "GENERAL", 240, 60, "2026-27");
                createSeatMatrix(sageBhopalCSE, "OBC", 120, 30, "2026-27");
                createSeatMatrix(sageBhopalCSE, "SC", 60, 15, "2026-27");
                createFeeStructure(sageBhopalCSE, "2026-27", new BigDecimal("90000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("15000"),
                                new BigDecimal("208000"), "PER_YEAR");
                createCutoff(sageBhopalCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), null,
                                "JEE Main / Merit");

                // B.Tech AI & ML
                Course sageBhopalAI = createCourse(sageBhopal, "B.Tech", "Artificial Intelligence and Machine Learning",
                                "UG", 4,
                                "B.Tech in AI & ML with industry-oriented curriculum and hands-on projects",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalAI, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(sageBhopalAI, "2026-27", new BigDecimal("140000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("264000"), "PER_YEAR");

                // B.Tech Data Science
                Course sageBhopalDS = createCourse(sageBhopal, "B.Tech", "Data Science", "UG", 4,
                                "B.Tech in Data Science with Big Data, Analytics, and Cloud Computing",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalDS, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalDS, "2026-27", new BigDecimal("140000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("264000"), "PER_YEAR");

                // B.Tech ECE
                Course sageBhopalECE = createCourse(sageBhopal, "B.Tech", "Electronics and Communication Engineering",
                                "UG", 4,
                                "Bachelor of Technology in ECE with VLSI, IoT specializations",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalECE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(sageBhopalECE, "2026-27", new BigDecimal("115000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("14000"),
                                new BigDecimal("232000"), "PER_YEAR");

                // B.Tech Mechanical
                Course sageBhopalME = createCourse(sageBhopal, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in Mechanical Engineering with Robotics and Automation",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalME, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(sageBhopalME, "2026-27", new BigDecimal("110000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("12000"),
                                new BigDecimal("225000"), "PER_YEAR");

                // B.Tech Civil
                Course sageBhopalCivil = createCourse(sageBhopal, "B.Tech", "Civil Engineering", "UG", 4,
                                "Bachelor of Technology in Civil Engineering with focus on smart infrastructure",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalCivil, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalCivil, "2026-27", new BigDecimal("105000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("216000"), "PER_YEAR");

                // MBA
                Course sageBhopalMBA = createCourse(sageBhopal, "MBA", "Management", "PG", 2,
                                "Master of Business Administration with specializations in Finance, Marketing, HR, Operations, IT",
                                "CAT/MAT/CMAT/SAAT with graduation 50%");
                createSeatMatrix(sageBhopalMBA, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(sageBhopalMBA, "2026-27", new BigDecimal("165000"), new BigDecimal("60000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("15000"),
                                new BigDecimal("263000"), "PER_YEAR");
                createCutoff(sageBhopalMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("60.0"), null,
                                "CAT/MAT/SAAT");

                // BBA
                Course sageBhopalBBA = createCourse(sageBhopal, "BBA", "Business Administration", "UG", 3,
                                "Bachelor of Business Administration with industry exposure and internships",
                                "12th with 50%");
                createSeatMatrix(sageBhopalBBA, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(sageBhopalBBA, "2026-27", new BigDecimal("85000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("167000"), "PER_YEAR");

                // BCA
                Course sageBhopalBCA = createCourse(sageBhopal, "BCA", "Computer Applications", "UG", 3,
                                "Bachelor of Computer Applications with programming and software development skills",
                                "12th with 45%");
                createSeatMatrix(sageBhopalBCA, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(sageBhopalBCA, "2026-27", new BigDecimal("58000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("8000"),
                                new BigDecimal("146000"), "PER_YEAR");

                // MCA
                Course sageBhopalMCA = createCourse(sageBhopal, "MCA", "Computer Applications", "PG", 2,
                                "Master of Computer Applications with advanced programming and IT skills",
                                "BCA/B.Sc (CS) with 50%");
                createSeatMatrix(sageBhopalMCA, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(sageBhopalMCA, "2026-27", new BigDecimal("95000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("188000"), "PER_YEAR");

                // BA LLB (Integrated Law)
                Course sageBhopalLaw = createCourse(sageBhopal, "BA LLB", "Law", "UG", 5,
                                "Integrated Bachelor of Arts and Bachelor of Laws with Moot Court practice",
                                "CLAT / 12th with 45%");
                createSeatMatrix(sageBhopalLaw, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(sageBhopalLaw, "2026-27", new BigDecimal("95000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("12000"),
                                new BigDecimal("180000"), "PER_YEAR");
                createCutoff(sageBhopalLaw, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "CLAT/Merit");

                // BBA LLB (Integrated Law)
                Course sageBhopalBBALLB = createCourse(sageBhopal, "BBA LLB", "Law with Management", "UG", 5,
                                "Integrated Bachelor of Business Administration and Bachelor of Laws",
                                "CLAT / 12th with 45%");
                createSeatMatrix(sageBhopalBBALLB, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalBBALLB, "2026-27", new BigDecimal("105000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("14000"),
                                new BigDecimal("192000"), "PER_YEAR");

                // B.Pharm
                Course sageBhopalBPharm = createCourse(sageBhopal, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy with modern labs and hospital training", "12th with PCM/PCB 45%");
                createSeatMatrix(sageBhopalBPharm, "GENERAL", 100, 30, "2026-27");
                createFeeStructure(sageBhopalBPharm, "2026-27", new BigDecimal("110000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("15000"),
                                new BigDecimal("12000"),
                                new BigDecimal("210000"), "PER_YEAR");

                // D.Pharm
                Course sageBhopalDPharm = createCourse(sageBhopal, "D.Pharm", "Pharmacy", "Diploma", 2,
                                "Diploma in Pharmacy - foundation course for pharmacy practice",
                                "12th with PCM/PCB 40%");
                createSeatMatrix(sageBhopalDPharm, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalDPharm, "2026-27", new BigDecimal("70000"), new BigDecimal("45000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("10000"),
                                new BigDecimal("8000"),
                                new BigDecimal("147000"), "PER_YEAR");

                // B.Sc Agriculture
                Course sageBhopalAgri = createCourse(sageBhopal, "B.Sc", "Agriculture", "UG", 4,
                                "Bachelor of Science in Agriculture with farm practices and modern techniques",
                                "12th with PCB/PCM 45%");
                createSeatMatrix(sageBhopalAgri, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalAgri, "2026-27", new BigDecimal("85000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("170000"), "PER_YEAR");

                // B.Des
                Course sageBhopalBDes = createCourse(sageBhopal, "B.Des", "Design", "UG", 4,
                                "Bachelor of Design with specializations in Fashion, Interior, Product Design",
                                "12th with 45% + Design Aptitude");
                createSeatMatrix(sageBhopalBDes, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalBDes, "2026-27", new BigDecimal("150000"), new BigDecimal("60000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("10000"),
                                new BigDecimal("15000"),
                                new BigDecimal("258000"), "PER_YEAR");

                // B.Sc Nursing
                Course sageBhopalNursing = createCourse(sageBhopal, "B.Sc", "Nursing", "UG", 4,
                                "Bachelor of Science in Nursing with hospital training", "12th PCB with 45% + NEET");
                createSeatMatrix(sageBhopalNursing, "GENERAL", 60, 15, "2026-27");
                createFeeStructure(sageBhopalNursing, "2026-27", new BigDecimal("125000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("220000"), "PER_YEAR");

                // M.Tech CSE
                Course sageBhopalMTech = createCourse(sageBhopal, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "Master of Technology in CSE with specializations in AI, ML, Data Science",
                                "GATE / B.Tech with 55%");
                createSeatMatrix(sageBhopalMTech, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalMTech, "2026-27", new BigDecimal("115000"), new BigDecimal("60000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("12000"),
                                new BigDecimal("222000"), "PER_YEAR");

                // B.Tech IT (Information Technology)
                Course sageBhopalIT = createCourse(sageBhopal, "B.Tech", "Information Technology", "UG", 4,
                                "B.Tech in IT with Web Development, Cloud Computing, and Software Engineering",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalIT, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(sageBhopalIT, "2026-27", new BigDecimal("120000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("14000"),
                                new BigDecimal("237000"), "PER_YEAR");

                // B.Tech Electrical Engineering
                Course sageBhopalEE = createCourse(sageBhopal, "B.Tech", "Electrical Engineering", "UG", 4,
                                "B.Tech in Electrical Engineering with Power Systems and Control Engineering",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalEE, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalEE, "2026-27", new BigDecimal("110000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("12000"),
                                new BigDecimal("225000"), "PER_YEAR");

                // B.Tech Cyber Security
                Course sageBhopalCyber = createCourse(sageBhopal, "B.Tech", "Cyber Security", "UG", 4,
                                "B.Tech in Cyber Security with Ethical Hacking, Network Security, and Digital Forensics",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageBhopalCyber, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalCyber, "2026-27", new BigDecimal("140000"), new BigDecimal("65000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("264000"), "PER_YEAR");

                // B.Com
                Course sageBhopalBCom = createCourse(sageBhopal, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce with Accounting, Taxation, and Business Studies",
                                "12th with 45%");
                createSeatMatrix(sageBhopalBCom, "GENERAL", 180, 60, "2026-27");
                createFeeStructure(sageBhopalBCom, "2026-27", new BigDecimal("45000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("6000"),
                                new BigDecimal("115000"), "PER_YEAR");

                // B.Com (Hons)
                Course sageBhopalBComHons = createCourse(sageBhopal, "B.Com (Hons)", "Commerce Honours", "UG", 3,
                                "B.Com Honours with advanced Accounting, Finance, and Business Analytics",
                                "12th with 50%");
                createSeatMatrix(sageBhopalBComHons, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalBComHons, "2026-27", new BigDecimal("55000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("8000"),
                                new BigDecimal("127000"), "PER_YEAR");

                // BA (Arts)
                Course sageBhopalBA = createCourse(sageBhopal, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts with English, Hindi, Political Science, Economics, Psychology",
                                "12th with 45%");
                createSeatMatrix(sageBhopalBA, "GENERAL", 180, 70, "2026-27");
                createFeeStructure(sageBhopalBA, "2026-27", new BigDecimal("35000"), new BigDecimal("45000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("96000"), "PER_YEAR");

                // B.Sc (Computer Science)
                Course sageBhopalBScCS = createCourse(sageBhopal, "B.Sc", "Computer Science", "UG", 3,
                                "B.Sc in Computer Science with Programming, Data Structures, and Web Development",
                                "12th with 50% in PCM");
                createSeatMatrix(sageBhopalBScCS, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(sageBhopalBScCS, "2026-27", new BigDecimal("55000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("7000"),
                                new BigDecimal("132000"), "PER_YEAR");

                // B.Sc (Mathematics)
                Course sageBhopalBScMath = createCourse(sageBhopal, "B.Sc", "Mathematics", "UG", 3,
                                "B.Sc in Mathematics with Calculus, Statistics, and Applied Mathematics",
                                "12th with 50% in PCM");
                createSeatMatrix(sageBhopalBScMath, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalBScMath, "2026-27", new BigDecimal("40000"), new BigDecimal("45000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("5000"),
                                new BigDecimal("105000"), "PER_YEAR");

                // B.Sc (Physics)
                Course sageBhopalBScPhy = createCourse(sageBhopal, "B.Sc", "Physics", "UG", 3,
                                "B.Sc in Physics with Electronics, Optics, and Modern Physics", "12th with 50% in PCM");
                createSeatMatrix(sageBhopalBScPhy, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalBScPhy, "2026-27", new BigDecimal("42000"), new BigDecimal("45000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("108000"), "PER_YEAR");

                // B.Sc (Biotechnology)
                Course sageBhopalBScBiotech = createCourse(sageBhopal, "B.Sc", "Biotechnology", "UG", 3,
                                "B.Sc in Biotechnology with Genetics, Microbiology, and Molecular Biology",
                                "12th with 50% in PCB");
                createSeatMatrix(sageBhopalBScBiotech, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalBScBiotech, "2026-27", new BigDecimal("65000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("8000"),
                                new BigDecimal("8000"),
                                new BigDecimal("145000"), "PER_YEAR");

                // LLB (3 Year)
                Course sageBhopalLLB = createCourse(sageBhopal, "LLB", "Law", "UG", 3,
                                "Bachelor of Laws (3 Year) for graduates", "Graduation with 45% / CLAT");
                createSeatMatrix(sageBhopalLLB, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalLLB, "2026-27", new BigDecimal("75000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("8000"),
                                new BigDecimal("148000"), "PER_YEAR");

                // LLM (Master of Laws)
                Course sageBhopalLLM = createCourse(sageBhopal, "LLM", "Law", "PG", 1,
                                "Master of Laws with Corporate Law, Criminal Law, Constitutional Law specializations",
                                "LLB with 50%");
                createSeatMatrix(sageBhopalLLM, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalLLM, "2026-27", new BigDecimal("85000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("160000"), "PER_YEAR");

                // M.Pharm
                Course sageBhopalMPharm = createCourse(sageBhopal, "M.Pharm", "Pharmacy", "PG", 2,
                                "Master of Pharmacy with Pharmaceutics, Pharmacology, Pharmaceutical Chemistry",
                                "B.Pharm with 55% / GPAT");
                createSeatMatrix(sageBhopalMPharm, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalMPharm, "2026-27", new BigDecimal("135000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("15000"),
                                new BigDecimal("15000"),
                                new BigDecimal("238000"), "PER_YEAR");

                // BJMC (Journalism and Mass Communication)
                Course sageBhopalBJMC = createCourse(sageBhopal, "BJMC", "Journalism and Mass Communication", "UG", 3,
                                "Bachelor of Journalism and Mass Communication with Print, TV, Digital Media",
                                "12th with 45%");
                createSeatMatrix(sageBhopalBJMC, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalBJMC, "2026-27", new BigDecimal("75000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("154000"), "PER_YEAR");

                // MJMC (Master in Journalism)
                Course sageBhopalMJMC = createCourse(sageBhopal, "MJMC", "Journalism and Mass Communication", "PG", 2,
                                "Master in Journalism and Mass Communication", "Graduation with 45%");
                createSeatMatrix(sageBhopalMJMC, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalMJMC, "2026-27", new BigDecimal("85000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("6000"),
                                new BigDecimal("10000"),
                                new BigDecimal("166000"), "PER_YEAR");

                // BPT (Physiotherapy)
                Course sageBhopalBPT = createCourse(sageBhopal, "BPT", "Physiotherapy", "UG", 4,
                                "Bachelor of Physiotherapy with clinical training and internship", "12th PCB with 50%");
                createSeatMatrix(sageBhopalBPT, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageBhopalBPT, "2026-27", new BigDecimal("115000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("210000"), "PER_YEAR");

                // MPT (Master of Physiotherapy)
                Course sageBhopalMPT = createCourse(sageBhopal, "MPT", "Physiotherapy", "PG", 2,
                                "Master of Physiotherapy with Orthopedics, Neurology, Sports specializations",
                                "BPT with 55%");
                createSeatMatrix(sageBhopalMPT, "GENERAL", 20, 8, "2026-27");
                createFeeStructure(sageBhopalMPT, "2026-27", new BigDecimal("135000"), new BigDecimal("55000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("12000"),
                                new BigDecimal("15000"),
                                new BigDecimal("235000"), "PER_YEAR");

                // B.Sc Hotel Management
                Course sageBhopalHM = createCourse(sageBhopal, "B.Sc", "Hotel Management", "UG", 3,
                                "B.Sc in Hotel Management with practical kitchen and hospitality training",
                                "12th with 45%");
                createSeatMatrix(sageBhopalHM, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalHM, "2026-27", new BigDecimal("95000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("180000"), "PER_YEAR");

                // Diploma in Engineering (Polytechnic)
                Course sageBhopalPoly = createCourse(sageBhopal, "Diploma", "Polytechnic Engineering", "Diploma", 3,
                                "Diploma in Engineering (CS, ME, Civil, EE) after 10th class", "10th pass with 35%");
                createSeatMatrix(sageBhopalPoly, "GENERAL", 180, 60, "2026-27");
                createFeeStructure(sageBhopalPoly, "2026-27", new BigDecimal("45000"), new BigDecimal("40000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("107000"), "PER_YEAR");

                // M.Sc (Computer Science)
                Course sageBhopalMScCS = createCourse(sageBhopal, "M.Sc", "Computer Science", "PG", 2,
                                "M.Sc in Computer Science with Advanced Programming, AI, and Data Science",
                                "B.Sc (CS) / BCA with 50%");
                createSeatMatrix(sageBhopalMScCS, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalMScCS, "2026-27", new BigDecimal("75000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("8000"),
                                new BigDecimal("156000"), "PER_YEAR");

                // M.Sc (Biotechnology)
                Course sageBhopalMScBiotech = createCourse(sageBhopal, "M.Sc", "Biotechnology", "PG", 2,
                                "M.Sc in Biotechnology with research and industrial training",
                                "B.Sc (Biotech) with 50%");
                createSeatMatrix(sageBhopalMScBiotech, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalMScBiotech, "2026-27", new BigDecimal("85000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("170000"), "PER_YEAR");

                // B.Ed (Bachelor of Education)
                Course sageBhopalBEd = createCourse(sageBhopal, "B.Ed", "Education", "UG", 2,
                                "Bachelor of Education for teaching profession", "Graduation with 50%");
                createSeatMatrix(sageBhopalBEd, "GENERAL", 100, 35, "2026-27");
                createFeeStructure(sageBhopalBEd, "2026-27", new BigDecimal("55000"), new BigDecimal("45000"),
                                new BigDecimal("8000"), new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("6000"),
                                new BigDecimal("118000"), "PER_YEAR");

                // M.A. (English)
                Course sageBhopalMAEng = createCourse(sageBhopal, "M.A.", "English", "PG", 2,
                                "Master of Arts in English Literature and Linguistics", "B.A. with 45%");
                createSeatMatrix(sageBhopalMAEng, "GENERAL", 40, 15, "2026-27");
                createFeeStructure(sageBhopalMAEng, "2026-27", new BigDecimal("45000"), new BigDecimal("45000"),
                                new BigDecimal("8000"), new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("6000"),
                                new BigDecimal("108000"), "PER_YEAR");

                // M.Com
                Course sageBhopalMCom = createCourse(sageBhopal, "M.Com", "Commerce", "PG", 2,
                                "Master of Commerce with Advanced Accounting, Finance, and Taxation", "B.Com with 50%");
                createSeatMatrix(sageBhopalMCom, "GENERAL", 40, 15, "2026-27");
                createFeeStructure(sageBhopalMCom, "2026-27", new BigDecimal("55000"), new BigDecimal("48000"),
                                new BigDecimal("8000"), new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("7000"),
                                new BigDecimal("122000"), "PER_YEAR");

                // B.Sc (IT)
                Course sageBhopalBScIT = createCourse(sageBhopal, "B.Sc", "Information Technology", "UG", 3,
                                "B.Sc in IT with Networking, Database, and Software Development", "12th with 45%");
                createSeatMatrix(sageBhopalBScIT, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageBhopalBScIT, "2026-27", new BigDecimal("50000"), new BigDecimal("50000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("6000"),
                                new BigDecimal("126000"), "PER_YEAR");

                // M.Sc Agriculture
                Course sageBhopalMScAgri = createCourse(sageBhopal, "M.Sc", "Agriculture", "PG", 2,
                                "M.Sc in Agriculture with Agronomy, Horticulture, Soil Science",
                                "B.Sc Agriculture with 55%");
                createSeatMatrix(sageBhopalMScAgri, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(sageBhopalMScAgri, "2026-27", new BigDecimal("95000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("180000"), "PER_YEAR");

                // ==================== SAM GLOBAL UNIVERSITY BHOPAL ====================

                // 42. Sam Global University Bhopal
                College samGlobal = createCollege(
                                "Sam Global University Bhopal",
                                "Sam Global University is a UGC approved private university in Bhopal offering diverse programs in Engineering, Management, Commerce, Science, Arts, Law, Pharmacy, Education, and Agriculture. Known for modern infrastructure, experienced faculty, industry-oriented curriculum, placement assistance, and vibrant campus life with sports, cultural activities, and hostel facilities.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "NH-12, Sahpura, Bhopal, MP 462039",
                                "462039",
                                "0755-4350999",
                                "info@samglobaluniversity.ac.in",
                                "https://www.samglobaluniversity.ac.in",
                                "B++",
                                true,
                                2014,
                                "UGC Approved Private University");

                // ---- Sam Global B.Tech CSE ----
                Course samCSE = createCourse(samGlobal, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "B.Tech CSE with Programming, Data Structures, Algorithms, DBMS, OS, Networking, Software Engineering. Placement in IT companies",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samCSE, "GENERAL", 120, 40, "2026-27");
                createSeatMatrix(samCSE, "OBC", 60, 20, "2026-27");
                createSeatMatrix(samCSE, "SC", 30, 10, "2026-27");
                createSeatMatrix(samCSE, "ST", 18, 6, "2026-27");
                createSeatMatrix(samCSE, "EWS", 20, 8, "2026-27");
                createFeeStructure(samCSE, "2026-27", new BigDecimal("65000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("6500"),
                                new BigDecimal("123000"), "PER_YEAR");
                createCutoff(samCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), 420000,
                                "JEE Main/Merit");
                createCutoff(samCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("48.0"), 550000, "JEE Main/Merit");
                createCutoff(samCSE, "SC", "2023-2024", "Round 1", new BigDecimal("40.0"), 680000, "JEE Main/Merit");
                createCutoff(samCSE, "GENERAL", "2022-2023", "Round 1", new BigDecimal("57.0"), 400000,
                                "JEE Main/Merit");

                // ---- Sam Global B.Tech AI/ML ----
                Course samAI = createCourse(samGlobal, "B.Tech", "Artificial Intelligence and Machine Learning", "UG",
                                4,
                                "B.Tech AI/ML with Python, TensorFlow, Deep Learning, NLP, Data Analytics, and Computer Vision",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samAI, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(samAI, "OBC", 30, 10, "2026-27");
                createFeeStructure(samAI, "2026-27", new BigDecimal("72000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("6000"),
                                new BigDecimal("7500"),
                                new BigDecimal("132000"), "PER_YEAR");
                createCutoff(samAI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("52.0"), 460000,
                                "JEE Main/Merit");
                createCutoff(samAI, "OBC", "2023-2024", "Round 1", new BigDecimal("45.0"), 600000, "JEE Main/Merit");

                // ---- Sam Global B.Tech Data Science ----
                Course samDS = createCourse(samGlobal, "B.Tech", "Data Science", "UG", 4,
                                "B.Tech Data Science with Big Data, Hadoop, Spark, R, Python, Tableau, and Statistical Modeling",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samDS, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(samDS, "2026-27", new BigDecimal("72000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("6000"),
                                new BigDecimal("7500"),
                                new BigDecimal("132000"), "PER_YEAR");
                createCutoff(samDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), 480000,
                                "JEE Main/Merit");

                // ---- Sam Global B.Tech IT ----
                Course samIT = createCourse(samGlobal, "B.Tech", "Information Technology", "UG", 4,
                                "B.Tech IT with Web Development, Cloud Computing, Software Engineering, DBMS, and Networking",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samIT, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(samIT, "OBC", 30, 12, "2026-27");
                createFeeStructure(samIT, "2026-27", new BigDecimal("62000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("6500"),
                                new BigDecimal("120000"), "PER_YEAR");
                createCutoff(samIT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("52.0"), 450000,
                                "JEE Main/Merit");

                // ---- Sam Global B.Tech ECE ----
                Course samECE = createCourse(samGlobal, "B.Tech", "Electronics and Communication Engineering", "UG", 4,
                                "B.Tech ECE with VLSI, Embedded Systems, IoT, Signal Processing, and Communication Networks",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samECE, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(samECE, "OBC", 30, 12, "2026-27");
                createFeeStructure(samECE, "2026-27", new BigDecimal("58000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("115500"), "PER_YEAR");
                createCutoff(samECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), 520000,
                                "JEE Main/Merit");
                createCutoff(samECE, "OBC", "2023-2024", "Round 1", new BigDecimal("42.0"), 640000, "JEE Main/Merit");

                // ---- Sam Global B.Tech EE ----
                Course samEE = createCourse(samGlobal, "B.Tech", "Electrical Engineering", "UG", 4,
                                "B.Tech EE with Power Systems, Control Engineering, Electrical Machines, and Renewable Energy",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samEE, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samEE, "2026-27", new BigDecimal("55000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("5500"),
                                new BigDecimal("112000"), "PER_YEAR");
                createCutoff(samEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), 560000,
                                "JEE Main/Merit");

                // ---- Sam Global B.Tech ME ----
                Course samME = createCourse(samGlobal, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "B.Tech ME with CAD/CAM, Robotics, Thermodynamics, Manufacturing Technology, and Automobile Engineering",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samME, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(samME, "OBC", 30, 12, "2026-27");
                createFeeStructure(samME, "2026-27", new BigDecimal("55000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("5500"),
                                new BigDecimal("112000"), "PER_YEAR");
                createCutoff(samME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), 550000,
                                "JEE Main/Merit");
                createCutoff(samME, "OBC", "2023-2024", "Round 1", new BigDecimal("38.0"), 680000, "JEE Main/Merit");

                // ---- Sam Global B.Tech Civil ----
                Course samCivil = createCourse(samGlobal, "B.Tech", "Civil Engineering", "UG", 4,
                                "B.Tech Civil with Structural Engineering, Surveying, Construction Management, and Environmental Engineering",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(samCivil, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samCivil, "2026-27", new BigDecimal("52000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("4500"),
                                new BigDecimal("5000"),
                                new BigDecimal("108000"), "PER_YEAR");
                createCutoff(samCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), 600000,
                                "JEE Main/Merit");

                // ---- Sam Global M.Tech CSE ----
                Course samMTech = createCourse(samGlobal, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "M.Tech CSE with AI, Cloud Computing, Software Engineering, and Research Projects",
                                "GATE / B.Tech with 50%");
                createSeatMatrix(samMTech, "GENERAL", 18, 8, "2026-27");
                createFeeStructure(samMTech, "2026-27", new BigDecimal("60000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("6500"),
                                new BigDecimal("118000"), "PER_YEAR");
                createCutoff(samMTech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("350"), null, "GATE Score");

                // ---- Sam Global MBA ----
                Course samMBA = createCourse(samGlobal, "MBA", "Management", "PG", 2,
                                "MBA with Finance, Marketing, HR, Operations, IT specializations. Industry visits, live projects, internship mandatory",
                                "CAT/MAT/CMAT/ATMA with graduation 50%");
                createSeatMatrix(samMBA, "GENERAL", 120, 40, "2026-27");
                createSeatMatrix(samMBA, "OBC", 60, 20, "2026-27");
                createSeatMatrix(samMBA, "SC", 30, 10, "2026-27");
                createFeeStructure(samMBA, "2026-27", new BigDecimal("68000"), new BigDecimal("35000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("0"),
                                new BigDecimal("7500"),
                                new BigDecimal("122000"), "PER_YEAR");
                createCutoff(samMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "CAT/MAT");
                createCutoff(samMBA, "OBC", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "CAT/MAT");

                // ---- Sam Global BBA ----
                Course samBBA = createCourse(samGlobal, "BBA", "Business Administration", "UG", 3,
                                "BBA with Marketing, Finance, HR, Entrepreneurship. Personality development, communication skills training",
                                "12th with 45%");
                createSeatMatrix(samBBA, "GENERAL", 120, 45, "2026-27");
                createSeatMatrix(samBBA, "OBC", 60, 22, "2026-27");
                createFeeStructure(samBBA, "2026-27", new BigDecimal("38000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("81500"), "PER_YEAR");
                createCutoff(samBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit");

                // ---- Sam Global BCA ----
                Course samBCA = createCourse(samGlobal, "BCA", "Computer Applications", "UG", 3,
                                "BCA with C, C++, Java, Python, Web Development, DBMS, Data Structures, Android Development",
                                "12th with 45%");
                createSeatMatrix(samBCA, "GENERAL", 120, 45, "2026-27");
                createSeatMatrix(samBCA, "OBC", 60, 22, "2026-27");
                createFeeStructure(samBCA, "2026-27", new BigDecimal("35000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("4000"),
                                new BigDecimal("4500"),
                                new BigDecimal("82000"), "PER_YEAR");
                createCutoff(samBCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global MCA ----
                Course samMCA = createCourse(samGlobal, "MCA", "Computer Applications", "PG", 2,
                                "MCA with Advanced Java, .NET, Python, Android, Cloud Computing, and Software Development",
                                "BCA/B.Sc (CS/IT) with 50%");
                createSeatMatrix(samMCA, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(samMCA, "OBC", 30, 10, "2026-27");
                createFeeStructure(samMCA, "2026-27", new BigDecimal("42000"), new BigDecimal("32000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("93000"), "PER_YEAR");
                createCutoff(samMCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- Sam Global B.Com ----
                Course samBCom = createCourse(samGlobal, "B.Com", "Commerce", "UG", 3,
                                "B.Com with Accounting, Taxation, Business Law, Economics, Financial Management, and Auditing",
                                "12th with 45%");
                createSeatMatrix(samBCom, "GENERAL", 180, 70, "2026-27");
                createSeatMatrix(samBCom, "OBC", 90, 35, "2026-27");
                createFeeStructure(samBCom, "2026-27", new BigDecimal("22000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3500"),
                                new BigDecimal("60500"), "PER_YEAR");
                createCutoff(samBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global B.Com (Hons) ----
                Course samBComHons = createCourse(samGlobal, "B.Com (Hons)", "Commerce Honours", "UG", 3,
                                "B.Com Hons with Advanced Accounting, Corporate Finance, Business Analytics, and Taxation",
                                "12th with 50%");
                createSeatMatrix(samBComHons, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samBComHons, "2026-27", new BigDecimal("30000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("4000"),
                                new BigDecimal("69000"), "PER_YEAR");
                createCutoff(samBComHons, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- Sam Global M.Com ----
                Course samMCom = createCourse(samGlobal, "M.Com", "Commerce", "PG", 2,
                                "M.Com with Advanced Accounting, Finance, Taxation, and Business Research",
                                "B.Com with 50%");
                createSeatMatrix(samMCom, "GENERAL", 40, 18, "2026-27");
                createFeeStructure(samMCom, "2026-27", new BigDecimal("28000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("4000"),
                                new BigDecimal("67000"), "PER_YEAR");
                createCutoff(samMCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- Sam Global BA ----
                Course samBA = createCourse(samGlobal, "B.A.", "Arts", "UG", 3,
                                "BA with English, Hindi, Political Science, Economics, History, Sociology, Psychology",
                                "12th with 40%");
                createSeatMatrix(samBA, "GENERAL", 240, 100, "2026-27");
                createSeatMatrix(samBA, "OBC", 120, 50, "2026-27");
                createFeeStructure(samBA, "2026-27", new BigDecimal("18000"), new BigDecimal("25000"),
                                new BigDecimal("4000"), new BigDecimal("1500"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("51500"), "PER_YEAR");
                createCutoff(samBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("38.0"), null, "Merit");

                // ---- Sam Global MA English ----
                Course samMA = createCourse(samGlobal, "M.A.", "English", "PG", 2,
                                "MA English with Literature, Linguistics, Criticism, and Communication Skills",
                                "BA with 45%");
                createSeatMatrix(samMA, "GENERAL", 40, 18, "2026-27");
                createFeeStructure(samMA, "2026-27", new BigDecimal("22000"), new BigDecimal("25000"),
                                new BigDecimal("4000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3500"),
                                new BigDecimal("56500"), "PER_YEAR");
                createCutoff(samMA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global B.Sc CS ----
                Course samBScCS = createCourse(samGlobal, "B.Sc", "Computer Science", "UG", 3,
                                "B.Sc CS with Programming (C, Java, Python), Data Structures, DBMS, OS, and Web Development",
                                "12th with 45% in PCM");
                createSeatMatrix(samBScCS, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samBScCS, "2026-27", new BigDecimal("30000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("73000"), "PER_YEAR");
                createCutoff(samBScCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit");

                // ---- Sam Global B.Sc Maths ----
                Course samBScMath = createCourse(samGlobal, "B.Sc", "Mathematics", "UG", 3,
                                "B.Sc Mathematics with Calculus, Algebra, Statistics, Differential Equations, and Numerical Methods",
                                "12th with 45% in PCM");
                createSeatMatrix(samBScMath, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samBScMath, "2026-27", new BigDecimal("25000"), new BigDecimal("25000"),
                                new BigDecimal("4000"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("3500"),
                                new BigDecimal("61000"), "PER_YEAR");
                createCutoff(samBScMath, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global B.Sc Biotechnology ----
                Course samBScBio = createCourse(samGlobal, "B.Sc", "Biotechnology", "UG", 3,
                                "B.Sc Biotechnology with Genetics, Microbiology, Molecular Biology, and Biochemistry",
                                "12th with 45% in PCB");
                createSeatMatrix(samBScBio, "GENERAL", 60, 22, "2026-27");
                createFeeStructure(samBScBio, "2026-27", new BigDecimal("35000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("79000"), "PER_YEAR");
                createCutoff(samBScBio, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global M.Sc CS ----
                Course samMScCS = createCourse(samGlobal, "M.Sc", "Computer Science", "PG", 2,
                                "M.Sc CS with Advanced Programming, AI, Data Science, and Software Engineering Research",
                                "B.Sc (CS)/BCA with 50%");
                createSeatMatrix(samMScCS, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(samMScCS, "2026-27", new BigDecimal("38000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("2500"), new BigDecimal("5000"),
                                new BigDecimal("4500"),
                                new BigDecimal("85000"), "PER_YEAR");
                createCutoff(samMScCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- Sam Global BA LLB ----
                Course samBALLB = createCourse(samGlobal, "BA LLB", "Law", "UG", 5,
                                "Integrated BA LLB with Constitutional Law, Criminal Law, Corporate Law, Moot Court, and Legal Aid Clinic",
                                "CLAT / 12th with 45%");
                createSeatMatrix(samBALLB, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(samBALLB, "OBC", 30, 10, "2026-27");
                createFeeStructure(samBALLB, "2026-27", new BigDecimal("55000"), new BigDecimal("32000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("6000"),
                                new BigDecimal("102000"), "PER_YEAR");
                createCutoff(samBALLB, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "CLAT/Merit");
                createCutoff(samBALLB, "OBC", "2023-2024", "Round 1", new BigDecimal("38.0"), null, "CLAT/Merit");

                // ---- Sam Global LLB 3 Year ----
                Course samLLB = createCourse(samGlobal, "LLB", "Law", "UG", 3,
                                "LLB (3 Year) with Civil Law, Criminal Law, Corporate Law, and Practical Training",
                                "Graduation with 45%");
                createSeatMatrix(samLLB, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samLLB, "2026-27", new BigDecimal("42000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("2500"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("84500"), "PER_YEAR");
                createCutoff(samLLB, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global LLM ----
                Course samLLM = createCourse(samGlobal, "LLM", "Law", "PG", 1,
                                "LLM with Corporate Law, Criminal Law, Constitutional Law specializations and Research",
                                "LLB with 50%");
                createSeatMatrix(samLLM, "GENERAL", 20, 10, "2026-27");
                createFeeStructure(samLLM, "2026-27", new BigDecimal("48000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("2500"), new BigDecimal("0"),
                                new BigDecimal("5500"),
                                new BigDecimal("91000"), "PER_YEAR");
                createCutoff(samLLM, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- Sam Global B.Pharm ----
                Course samBPharm = createCourse(samGlobal, "B.Pharm", "Pharmacy", "UG", 4,
                                "B.Pharm with Pharmaceutics, Pharmacology, Pharmaceutical Chemistry, Pharmacognosy. PCI approved labs",
                                "12th with PCM/PCB 45%");
                createSeatMatrix(samBPharm, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(samBPharm, "OBC", 30, 10, "2026-27");
                createFeeStructure(samBPharm, "2026-27", new BigDecimal("58000"), new BigDecimal("32000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("8000"),
                                new BigDecimal("6000"),
                                new BigDecimal("113000"), "PER_YEAR");
                createCutoff(samBPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit/PEPT");
                createCutoff(samBPharm, "OBC", "2023-2024", "Round 1", new BigDecimal("38.0"), null, "Merit/PEPT");

                // ---- Sam Global D.Pharm ----
                Course samDPharm = createCourse(samGlobal, "D.Pharm", "Pharmacy", "Diploma", 2,
                                "Diploma in Pharmacy with practical training in drug dispensing, hospital pharmacy, and community pharmacy",
                                "12th with PCM/PCB 40%");
                createSeatMatrix(samDPharm, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samDPharm, "2026-27", new BigDecimal("42000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("88000"), "PER_YEAR");
                createCutoff(samDPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("38.0"), null, "Merit");

                // ---- Sam Global B.Ed ----
                Course samBEd = createCourse(samGlobal, "B.Ed", "Education", "UG", 2,
                                "Bachelor of Education with Teaching Methodology, Pedagogy, Psychology, and Practice Teaching",
                                "Graduation with 50%");
                createSeatMatrix(samBEd, "GENERAL", 100, 40, "2026-27");
                createSeatMatrix(samBEd, "OBC", 50, 20, "2026-27");
                createFeeStructure(samBEd, "2026-27", new BigDecimal("35000"), new BigDecimal("28000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("4000"),
                                new BigDecimal("74000"), "PER_YEAR");
                createCutoff(samBEd, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null, "PTET/Merit");
                createCutoff(samBEd, "OBC", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "PTET/Merit");

                // ---- Sam Global B.Sc Agriculture ----
                Course samAgri = createCourse(samGlobal, "B.Sc", "Agriculture", "UG", 4,
                                "B.Sc Agriculture with Agronomy, Horticulture, Soil Science, Entomology, Plant Pathology, and Farm Management",
                                "12th with PCB/PCM 45%");
                createSeatMatrix(samAgri, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(samAgri, "OBC", 30, 12, "2026-27");
                createFeeStructure(samAgri, "2026-27", new BigDecimal("48000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("5000"),
                                new BigDecimal("5500"),
                                new BigDecimal("97000"), "PER_YEAR");
                createCutoff(samAgri, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global BJMC ----
                Course samBJMC = createCourse(samGlobal, "BJMC", "Journalism and Mass Communication", "UG", 3,
                                "BJMC with Print Media, Electronic Media, Digital Media, Advertising, and Public Relations",
                                "12th with 45%");
                createSeatMatrix(samBJMC, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samBJMC, "2026-27", new BigDecimal("38000"), new BigDecimal("30000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("3000"),
                                new BigDecimal("4500"),
                                new BigDecimal("84000"), "PER_YEAR");
                createCutoff(samBJMC, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- Sam Global B.Sc Nursing ----
                Course samNursing = createCourse(samGlobal, "B.Sc", "Nursing", "UG", 4,
                                "B.Sc Nursing with Anatomy, Physiology, Medical-Surgical Nursing, Community Health, and Clinical Training",
                                "12th PCB with 45%");
                createSeatMatrix(samNursing, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(samNursing, "2026-27", new BigDecimal("72000"), new BigDecimal("35000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("6000"),
                                new BigDecimal("128000"), "PER_YEAR");
                createCutoff(samNursing, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit");

                // ---- Sam Global Diploma Polytechnic ----
                Course samDiplomaCS = createCourse(samGlobal, "Diploma", "Computer Science Engineering", "Diploma", 3,
                                "Diploma in CS Engineering (Polytechnic) after 10th class with basic programming, hardware, and networking",
                                "10th pass with 35%");
                createSeatMatrix(samDiplomaCS, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(samDiplomaCS, "OBC", 30, 12, "2026-27");
                createFeeStructure(samDiplomaCS, "2026-27", new BigDecimal("28000"), new BigDecimal("25000"),
                                new BigDecimal("4000"), new BigDecimal("1500"), new BigDecimal("3000"),
                                new BigDecimal("3500"),
                                new BigDecimal("65000"), "PER_YEAR");
                createCutoff(samDiplomaCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("35.0"), null,
                                "Merit (10th)");

                // ---- Sam Global Diploma ME ----
                Course samDiplomaME = createCourse(samGlobal, "Diploma", "Mechanical Engineering", "Diploma", 3,
                                "Diploma in Mechanical Engineering (Polytechnic) after 10th class with workshop and manufacturing basics",
                                "10th pass with 35%");
                createSeatMatrix(samDiplomaME, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samDiplomaME, "2026-27", new BigDecimal("26000"), new BigDecimal("25000"),
                                new BigDecimal("4000"), new BigDecimal("1500"), new BigDecimal("3000"),
                                new BigDecimal("3500"),
                                new BigDecimal("63000"), "PER_YEAR");
                createCutoff(samDiplomaME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("32.0"), null,
                                "Merit (10th)");

                // ---- Sam Global Diploma Civil ----
                Course samDiplomaCivil = createCourse(samGlobal, "Diploma", "Civil Engineering", "Diploma", 3,
                                "Diploma in Civil Engineering (Polytechnic) after 10th class with surveying and construction basics",
                                "10th pass with 35%");
                createSeatMatrix(samDiplomaCivil, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(samDiplomaCivil, "2026-27", new BigDecimal("25000"), new BigDecimal("25000"),
                                new BigDecimal("4000"), new BigDecimal("1500"), new BigDecimal("2500"),
                                new BigDecimal("3000"),
                                new BigDecimal("61000"), "PER_YEAR");
                createCutoff(samDiplomaCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("32.0"), null,
                                "Merit (10th)");

                // ---- Sam Global B.Des ----
                Course samBDes = createCourse(samGlobal, "B.Des", "Design", "UG", 4,
                                "B.Des with Fashion Design, Interior Design, Graphic Design, and Product Design",
                                "12th with 45% + Design Aptitude");
                createSeatMatrix(samBDes, "GENERAL", 30, 12, "2026-27");
                createFeeStructure(samBDes, "2026-27", new BigDecimal("62000"), new BigDecimal("32000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("114000"), "PER_YEAR");
                createCutoff(samBDes, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null,
                                "Merit/Aptitude");

                // ---- Sam Global B.Sc Hotel Management ----
                Course samHM = createCourse(samGlobal, "B.Sc", "Hotel Management", "UG", 3,
                                "B.Sc Hotel Management with Food Production, F&B Service, Front Office, and Housekeeping",
                                "12th with 45%");
                createSeatMatrix(samHM, "GENERAL", 40, 18, "2026-27");
                createFeeStructure(samHM, "2026-27", new BigDecimal("55000"), new BigDecimal("32000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("5000"),
                                new BigDecimal("5500"),
                                new BigDecimal("106000"), "PER_YEAR");
                createCutoff(samHM, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ==================== 43. IES University Bhopal ====================
                College iesUni = createCollege(
                                "IES University",
                                "IES University Bhopal, established in 2019 by the Infotech Education Society, is a NAAC B+ accredited private university spread over 50+ acres. Recognized by UGC, AICTE, and PCI, it offers 75+ courses across Engineering, Management, Pharmacy, Law, Nursing, Agriculture, Arts, Commerce, and more with strong industry connections and placements.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "IES Campus, Ratibad Main Road, Kalkheda, Bhopal, MP 462044",
                                "462044",
                                "8516064444",
                                "admissions@iesuniversity.ac.in",
                                "https://www.iesuniversity.ac.in",
                                "B+",
                                true,
                                2019,
                                "Self (Private University - UGC Recognized)");

                // ---- IES B.Tech CSE ----
                Course iesUniCSE = createCourse(iesUni, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "B.Tech CSE with Data Structures, Algorithms, Software Engineering, AI, Machine Learning, Cloud Computing, and Cybersecurity",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniCSE, "GENERAL", 120, 35, "2026-27");
                createSeatMatrix(iesUniCSE, "OBC", 60, 18, "2026-27");
                createSeatMatrix(iesUniCSE, "SC", 25, 8, "2026-27");
                createSeatMatrix(iesUniCSE, "ST", 15, 5, "2026-27");
                createSeatMatrix(iesUniCSE, "EWS", 20, 6, "2026-27");
                createFeeStructure(iesUniCSE, "2026-27", new BigDecimal("67000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("131000"), "PER_YEAR");
                createCutoff(iesUniCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "JEE Main / Merit");
                createCutoff(iesUniCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("48.0"), null,
                                "JEE Main / Merit");

                // ---- IES B.Tech AI/ML ----
                Course iesUniAI = createCourse(iesUni, "B.Tech", "Artificial Intelligence & Machine Learning", "UG", 4,
                                "B.Tech AI/ML with Deep Learning, NLP, Computer Vision, Robotics, and Data Analytics",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniAI, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(iesUniAI, "OBC", 30, 10, "2026-27");
                createSeatMatrix(iesUniAI, "SC", 12, 4, "2026-27");
                createSeatMatrix(iesUniAI, "ST", 8, 3, "2026-27");
                createSeatMatrix(iesUniAI, "EWS", 10, 3, "2026-27");
                createFeeStructure(iesUniAI, "2026-27", new BigDecimal("70000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("134000"), "PER_YEAR");
                createCutoff(iesUniAI, "GENERAL", "2023-2024", "Round 1", new BigDecimal("52.0"), null,
                                "JEE Main / Merit");

                // ---- IES B.Tech Data Science ----
                Course iesUniDS = createCourse(iesUni, "B.Tech", "Data Science", "UG", 4,
                                "B.Tech Data Science with Big Data, Statistical Modeling, Data Engineering, and Business Intelligence",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniDS, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(iesUniDS, "OBC", 25, 8, "2026-27");
                createSeatMatrix(iesUniDS, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniDS, "ST", 6, 2, "2026-27");
                createSeatMatrix(iesUniDS, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniDS, "2026-27", new BigDecimal("70000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("134000"), "PER_YEAR");
                createCutoff(iesUniDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null,
                                "JEE Main / Merit");

                // ---- IES B.Tech ECE ----
                Course iesUniECE = createCourse(iesUni, "B.Tech", "Electronics and Communication Engineering", "UG", 4,
                                "B.Tech ECE with VLSI Design, Embedded Systems, Signal Processing, and IoT",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniECE, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniECE, "OBC", 30, 12, "2026-27");
                createSeatMatrix(iesUniECE, "SC", 12, 5, "2026-27");
                createSeatMatrix(iesUniECE, "ST", 8, 3, "2026-27");
                createSeatMatrix(iesUniECE, "EWS", 10, 4, "2026-27");
                createFeeStructure(iesUniECE, "2026-27", new BigDecimal("67000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("131000"), "PER_YEAR");
                createCutoff(iesUniECE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null,
                                "JEE Main / Merit");

                // ---- IES B.Tech EE ----
                Course iesUniEE = createCourse(iesUni, "B.Tech", "Electrical Engineering", "UG", 4,
                                "B.Tech EE with Power Systems, Control Systems, Electrical Machines, and Renewable Energy",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniEE, "GENERAL", 60, 28, "2026-27");
                createSeatMatrix(iesUniEE, "OBC", 25, 12, "2026-27");
                createSeatMatrix(iesUniEE, "SC", 10, 5, "2026-27");
                createSeatMatrix(iesUniEE, "ST", 6, 3, "2026-27");
                createSeatMatrix(iesUniEE, "EWS", 8, 4, "2026-27");
                createFeeStructure(iesUniEE, "2026-27", new BigDecimal("67000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("131000"), "PER_YEAR");
                createCutoff(iesUniEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null,
                                "JEE Main / Merit");

                // ---- IES B.Tech ME ----
                Course iesUniME = createCourse(iesUni, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "B.Tech ME with Thermodynamics, Manufacturing, CAD/CAM, Robotics, and Industrial Engineering",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniME, "GENERAL", 60, 30, "2026-27");
                createSeatMatrix(iesUniME, "OBC", 25, 12, "2026-27");
                createSeatMatrix(iesUniME, "SC", 10, 5, "2026-27");
                createSeatMatrix(iesUniME, "ST", 6, 3, "2026-27");
                createSeatMatrix(iesUniME, "EWS", 8, 4, "2026-27");
                createFeeStructure(iesUniME, "2026-27", new BigDecimal("67000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("131000"), "PER_YEAR");
                createCutoff(iesUniME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("40.0"), null,
                                "JEE Main / Merit");

                // ---- IES B.Tech Civil ----
                Course iesUniCivil = createCourse(iesUni, "B.Tech", "Civil Engineering", "UG", 4,
                                "B.Tech Civil with Structural Engineering, Geotechnical, Transportation, Environmental, and Construction Management",
                                "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(iesUniCivil, "GENERAL", 60, 30, "2026-27");
                createSeatMatrix(iesUniCivil, "OBC", 25, 12, "2026-27");
                createSeatMatrix(iesUniCivil, "SC", 10, 5, "2026-27");
                createSeatMatrix(iesUniCivil, "ST", 6, 3, "2026-27");
                createSeatMatrix(iesUniCivil, "EWS", 8, 4, "2026-27");
                createFeeStructure(iesUniCivil, "2026-27", new BigDecimal("67000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("131000"), "PER_YEAR");
                createCutoff(iesUniCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("38.0"), null,
                                "JEE Main / Merit");

                // ---- IES M.Tech CSE ----
                Course iesUniMTech = createCourse(iesUni, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "M.Tech CSE with advanced research in AI, Machine Learning, Data Science, and Cloud Computing",
                                "B.Tech/BE with 50% + GATE qualified (preferred)");
                createSeatMatrix(iesUniMTech, "GENERAL", 30, 12, "2026-27");
                createSeatMatrix(iesUniMTech, "OBC", 15, 6, "2026-27");
                createSeatMatrix(iesUniMTech, "SC", 6, 3, "2026-27");
                createSeatMatrix(iesUniMTech, "ST", 4, 2, "2026-27");
                createFeeStructure(iesUniMTech, "2026-27", new BigDecimal("55000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("118000"), "PER_YEAR");
                createCutoff(iesUniMTech, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "GATE / Merit");

                // ---- IES MBA ----
                Course iesUniMBA = createCourse(iesUni, "MBA", "Management", "PG", 2,
                                "MBA with Marketing, Finance, HR, Operations, and Business Analytics specializations",
                                "Graduation with 50% + CAT/MAT/CMAT");
                createSeatMatrix(iesUniMBA, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(iesUniMBA, "OBC", 30, 10, "2026-27");
                createSeatMatrix(iesUniMBA, "SC", 12, 4, "2026-27");
                createSeatMatrix(iesUniMBA, "ST", 8, 3, "2026-27");
                createSeatMatrix(iesUniMBA, "EWS", 10, 3, "2026-27");
                createFeeStructure(iesUniMBA, "2026-27", new BigDecimal("65000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("123000"), "PER_YEAR");
                createCutoff(iesUniMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null,
                                "CAT/MAT/CMAT");

                // ---- IES BBA ----
                Course iesUniBBA = createCourse(iesUni, "BBA", "Business Administration", "UG", 3,
                                "BBA with Marketing, Finance, HR, Entrepreneurship, and International Business",
                                "12th with 45%");
                createSeatMatrix(iesUniBBA, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(iesUniBBA, "OBC", 30, 10, "2026-27");
                createSeatMatrix(iesUniBBA, "SC", 12, 4, "2026-27");
                createSeatMatrix(iesUniBBA, "ST", 8, 3, "2026-27");
                createSeatMatrix(iesUniBBA, "EWS", 10, 4, "2026-27");
                createFeeStructure(iesUniBBA, "2026-27", new BigDecimal("55000"), new BigDecimal("38000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("0"),
                                new BigDecimal("4500"),
                                new BigDecimal("106000"), "PER_YEAR");
                createCutoff(iesUniBBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null,
                                "Merit (12th)");

                // ---- IES BCA ----
                Course iesUniBCA = createCourse(iesUni, "BCA", "Computer Applications", "UG", 3,
                                "BCA with Programming, Web Development, Database Management, Networking, and Software Development",
                                "12th with 45% (Math preferred)");
                createSeatMatrix(iesUniBCA, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(iesUniBCA, "OBC", 30, 10, "2026-27");
                createSeatMatrix(iesUniBCA, "SC", 12, 4, "2026-27");
                createSeatMatrix(iesUniBCA, "ST", 8, 3, "2026-27");
                createSeatMatrix(iesUniBCA, "EWS", 10, 4, "2026-27");
                createFeeStructure(iesUniBCA, "2026-27", new BigDecimal("25000"), new BigDecimal("38000"),
                                new BigDecimal("6000"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("3000"),
                                new BigDecimal("77000"), "PER_YEAR");
                createCutoff(iesUniBCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null,
                                "Merit (12th)");

                // ---- IES MCA ----
                Course iesUniMCA = createCourse(iesUni, "MCA", "Computer Applications", "PG", 2,
                                "MCA with Advanced Programming, Cloud Computing, AI, Data Science, and Full Stack Development",
                                "BCA/B.Sc CS/Graduation with Math + 50%");
                createSeatMatrix(iesUniMCA, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(iesUniMCA, "OBC", 25, 8, "2026-27");
                createSeatMatrix(iesUniMCA, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniMCA, "ST", 6, 2, "2026-27");
                createSeatMatrix(iesUniMCA, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniMCA, "2026-27", new BigDecimal("50000"), new BigDecimal("42000"),
                                new BigDecimal("8000"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("113000"), "PER_YEAR");
                createCutoff(iesUniMCA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- IES B.Pharm ----
                Course iesUniBPharm = createCourse(iesUni, "B.Pharm", "Pharmacy", "UG", 4,
                                "B.Pharm with Pharmacology, Pharmaceutical Chemistry, Pharmaceutics, Pharmacognosy (PCI approved)",
                                "12th with 45% in PCB/PCM");
                createSeatMatrix(iesUniBPharm, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(iesUniBPharm, "OBC", 25, 8, "2026-27");
                createSeatMatrix(iesUniBPharm, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniBPharm, "ST", 6, 2, "2026-27");
                createSeatMatrix(iesUniBPharm, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniBPharm, "2026-27", new BigDecimal("60000"), new BigDecimal("40000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("120000"), "PER_YEAR");
                createCutoff(iesUniBPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null,
                                "Merit (12th PCB)");

                // ---- IES D.Pharm ----
                Course iesUniDPharm = createCourse(iesUni, "D.Pharm", "Pharmacy", "Diploma", 2,
                                "D.Pharm (Diploma in Pharmacy) with Hospital Pharmacy, Community Pharmacy, Drug Store Management",
                                "12th with 45% in PCB/PCM");
                createSeatMatrix(iesUniDPharm, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniDPharm, "OBC", 25, 10, "2026-27");
                createSeatMatrix(iesUniDPharm, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniDPharm, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniDPharm, "2026-27", new BigDecimal("45000"), new BigDecimal("38000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("5000"),
                                new BigDecimal("4500"),
                                new BigDecimal("101000"), "PER_YEAR");
                createCutoff(iesUniDPharm, "GENERAL", "2023-2024", "Round 1", new BigDecimal("40.0"), null,
                                "Merit (12th)");

                // ---- IES B.Sc Nursing ----
                Course iesUniNursing = createCourse(iesUni, "B.Sc", "Nursing", "UG", 4,
                                "B.Sc Nursing with Medical-Surgical, Pediatric, Obstetric, Community Health, and Mental Health Nursing",
                                "12th with 45% in PCB + NEET qualified");
                createSeatMatrix(iesUniNursing, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(iesUniNursing, "OBC", 25, 8, "2026-27");
                createSeatMatrix(iesUniNursing, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniNursing, "ST", 6, 2, "2026-27");
                createSeatMatrix(iesUniNursing, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniNursing, "2026-27", new BigDecimal("60000"), new BigDecimal("42000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("122000"), "PER_YEAR");
                createCutoff(iesUniNursing, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null,
                                "NEET / Merit");

                // ---- IES B.Sc Agriculture ----
                Course iesUniAgri = createCourse(iesUni, "B.Sc", "Agriculture", "UG", 4,
                                "B.Sc Agriculture with Agronomy, Horticulture, Soil Science, Plant Pathology, and Entomology",
                                "12th with 45% in PCB/PCM/Agriculture");
                createSeatMatrix(iesUniAgri, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniAgri, "OBC", 25, 10, "2026-27");
                createSeatMatrix(iesUniAgri, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniAgri, "ST", 6, 3, "2026-27");
                createSeatMatrix(iesUniAgri, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniAgri, "2026-27", new BigDecimal("45000"), new BigDecimal("38000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("5000"),
                                new BigDecimal("4500"),
                                new BigDecimal("101000"), "PER_YEAR");
                createCutoff(iesUniAgri, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null,
                                "Merit (12th)");

                // ---- IES BA LLB ----
                Course iesUniBaLLB = createCourse(iesUni, "BA LLB", "Law", "UG", 5,
                                "BA LLB (Integrated) with Constitutional Law, Criminal Law, Corporate Law, and International Law",
                                "12th with 45% + CLAT/University entrance");
                createSeatMatrix(iesUniBaLLB, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(iesUniBaLLB, "OBC", 25, 8, "2026-27");
                createSeatMatrix(iesUniBaLLB, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniBaLLB, "ST", 6, 2, "2026-27");
                createSeatMatrix(iesUniBaLLB, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniBaLLB, "2026-27", new BigDecimal("55000"), new BigDecimal("40000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("109000"), "PER_YEAR");
                createCutoff(iesUniBaLLB, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null,
                                "CLAT / Merit");

                // ---- IES LLB 3 Year ----
                Course iesUniLLB = createCourse(iesUni, "LLB", "Law", "UG", 3,
                                "LLB 3-Year with Civil Law, Criminal Law, Property Law, Family Law, and Constitutional Law",
                                "Graduation with 45%");
                createSeatMatrix(iesUniLLB, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniLLB, "OBC", 25, 10, "2026-27");
                createSeatMatrix(iesUniLLB, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniLLB, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniLLB, "2026-27", new BigDecimal("45000"), new BigDecimal("40000"),
                                new BigDecimal("6000"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("99000"), "PER_YEAR");
                createCutoff(iesUniLLB, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit");

                // ---- IES B.Com ----
                Course iesUniBCom = createCourse(iesUni, "B.Com", "Commerce", "UG", 3,
                                "B.Com with Accounting, Taxation, Auditing, Business Law, Economics, and Financial Management",
                                "12th with 40% (Commerce preferred)");
                createSeatMatrix(iesUniBCom, "GENERAL", 120, 50, "2026-27");
                createSeatMatrix(iesUniBCom, "OBC", 50, 20, "2026-27");
                createSeatMatrix(iesUniBCom, "SC", 20, 8, "2026-27");
                createSeatMatrix(iesUniBCom, "ST", 12, 5, "2026-27");
                createSeatMatrix(iesUniBCom, "EWS", 15, 6, "2026-27");
                createFeeStructure(iesUniBCom, "2026-27", new BigDecimal("20000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("65000"), "PER_YEAR");
                createCutoff(iesUniBCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("38.0"), null,
                                "Merit (12th)");

                // ---- IES B.Com Hons ----
                Course iesUniBComH = createCourse(iesUni, "B.Com Hons", "Commerce (Honours)", "UG", 3,
                                "B.Com Honours with Advanced Accounting, Corporate Finance, Cost Accounting, and Research Methods",
                                "12th with 45% (Commerce preferred)");
                createSeatMatrix(iesUniBComH, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniBComH, "OBC", 25, 10, "2026-27");
                createSeatMatrix(iesUniBComH, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniBComH, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniBComH, "2026-27", new BigDecimal("25000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("70000"), "PER_YEAR");
                createCutoff(iesUniBComH, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null,
                                "Merit (12th)");

                // ---- IES M.Com ----
                Course iesUniMCom = createCourse(iesUni, "M.Com", "Commerce", "PG", 2,
                                "M.Com with Advanced Accounting, Business Statistics, Corporate Governance, and Research Methodology",
                                "B.Com/BBA with 45%");
                createSeatMatrix(iesUniMCom, "GENERAL", 40, 18, "2026-27");
                createSeatMatrix(iesUniMCom, "OBC", 18, 8, "2026-27");
                createSeatMatrix(iesUniMCom, "SC", 8, 3, "2026-27");
                createFeeStructure(iesUniMCom, "2026-27", new BigDecimal("22000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("67000"), "PER_YEAR");
                createCutoff(iesUniMCom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), null, "Merit");

                // ---- IES BA ----
                Course iesUniBA = createCourse(iesUni, "BA", "Arts", "UG", 3,
                                "BA with English, Hindi, Political Science, Economics, Sociology, History, and Psychology",
                                "12th with 40%");
                createSeatMatrix(iesUniBA, "GENERAL", 120, 55, "2026-27");
                createSeatMatrix(iesUniBA, "OBC", 50, 22, "2026-27");
                createSeatMatrix(iesUniBA, "SC", 20, 8, "2026-27");
                createSeatMatrix(iesUniBA, "ST", 12, 5, "2026-27");
                createSeatMatrix(iesUniBA, "EWS", 15, 6, "2026-27");
                createFeeStructure(iesUniBA, "2026-27", new BigDecimal("18000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("63000"), "PER_YEAR");
                createCutoff(iesUniBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("35.0"), null, "Merit (12th)");

                // ---- IES MA ----
                Course iesUniMA = createCourse(iesUni, "MA", "Arts", "PG", 2,
                                "MA with English, Hindi, Political Science, Economics, and Sociology",
                                "BA/Graduation with 45%");
                createSeatMatrix(iesUniMA, "GENERAL", 40, 18, "2026-27");
                createSeatMatrix(iesUniMA, "OBC", 18, 8, "2026-27");
                createSeatMatrix(iesUniMA, "SC", 8, 3, "2026-27");
                createFeeStructure(iesUniMA, "2026-27", new BigDecimal("18000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("63000"), "PER_YEAR");
                createCutoff(iesUniMA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null, "Merit");

                // ---- IES B.Sc CS ----
                Course iesUniBScCS = createCourse(iesUni, "B.Sc", "Computer Science", "UG", 3,
                                "B.Sc Computer Science with Programming, Data Structures, DBMS, Networking, and Web Technologies",
                                "12th with 45% (Math/CS preferred)");
                createSeatMatrix(iesUniBScCS, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniBScCS, "OBC", 25, 10, "2026-27");
                createSeatMatrix(iesUniBScCS, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniBScCS, "ST", 6, 3, "2026-27");
                createSeatMatrix(iesUniBScCS, "EWS", 8, 3, "2026-27");
                createFeeStructure(iesUniBScCS, "2026-27", new BigDecimal("28000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("3000"),
                                new BigDecimal("76000"), "PER_YEAR");
                createCutoff(iesUniBScCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("40.0"), null,
                                "Merit (12th)");

                // ---- IES M.Sc CS ----
                Course iesUniMScCS = createCourse(iesUni, "M.Sc", "Computer Science", "PG", 2,
                                "M.Sc CS with Advanced Algorithms, AI, Machine Learning, Cloud Computing, and Research Methods",
                                "B.Sc CS/BCA/B.Tech with 50%");
                createSeatMatrix(iesUniMScCS, "GENERAL", 30, 12, "2026-27");
                createSeatMatrix(iesUniMScCS, "OBC", 15, 6, "2026-27");
                createSeatMatrix(iesUniMScCS, "SC", 6, 3, "2026-27");
                createFeeStructure(iesUniMScCS, "2026-27", new BigDecimal("30000"), new BigDecimal("38000"),
                                new BigDecimal("5000"), new BigDecimal("2500"), new BigDecimal("4000"),
                                new BigDecimal("3500"),
                                new BigDecimal("83000"), "PER_YEAR");
                createCutoff(iesUniMScCS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null, "Merit");

                // ---- IES B.Ed ----
                Course iesUniBEd = createCourse(iesUni, "B.Ed", "Education", "UG", 2,
                                "B.Ed with Teaching Methodology, Educational Psychology, Curriculum Development, and Practice Teaching",
                                "Graduation with 50%");
                createSeatMatrix(iesUniBEd, "GENERAL", 100, 40, "2026-27");
                createSeatMatrix(iesUniBEd, "OBC", 40, 15, "2026-27");
                createSeatMatrix(iesUniBEd, "SC", 15, 6, "2026-27");
                createSeatMatrix(iesUniBEd, "ST", 10, 4, "2026-27");
                createSeatMatrix(iesUniBEd, "EWS", 12, 5, "2026-27");
                createFeeStructure(iesUniBEd, "2026-27", new BigDecimal("35000"), new BigDecimal("35000"),
                                new BigDecimal("5000"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("80000"), "PER_YEAR");
                createCutoff(iesUniBEd, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), null,
                                "MP B.Ed Entrance / Merit");

                // ---- IES BJMC ----
                Course iesUniBJMC = createCourse(iesUni, "BJMC", "Journalism and Mass Communication", "UG", 3,
                                "BJMC with Print, Electronic, Digital Media, Public Relations, Advertising, and Film Studies",
                                "12th with 45%");
                createSeatMatrix(iesUniBJMC, "GENERAL", 40, 18, "2026-27");
                createSeatMatrix(iesUniBJMC, "OBC", 18, 8, "2026-27");
                createSeatMatrix(iesUniBJMC, "SC", 8, 3, "2026-27");
                createSeatMatrix(iesUniBJMC, "ST", 5, 2, "2026-27");
                createFeeStructure(iesUniBJMC, "2026-27", new BigDecimal("40000"), new BigDecimal("38000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("3000"),
                                new BigDecimal("4000"),
                                new BigDecimal("93500"), "PER_YEAR");
                createCutoff(iesUniBJMC, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), null,
                                "Merit (12th)");

                // ---- IES B.Sc Hotel Management ----
                Course iesUniHM = createCourse(iesUni, "B.Sc", "Hotel Management", "UG", 3,
                                "B.Sc Hotel Management with Food Production, F&B Service, Front Office, Housekeeping, and Tourism",
                                "12th with 45%");
                createSeatMatrix(iesUniHM, "GENERAL", 40, 18, "2026-27");
                createSeatMatrix(iesUniHM, "OBC", 18, 8, "2026-27");
                createSeatMatrix(iesUniHM, "SC", 8, 3, "2026-27");
                createSeatMatrix(iesUniHM, "ST", 5, 2, "2026-27");
                createFeeStructure(iesUniHM, "2026-27", new BigDecimal("48000"), new BigDecimal("38000"),
                                new BigDecimal("6000"), new BigDecimal("2500"), new BigDecimal("5000"),
                                new BigDecimal("4500"),
                                new BigDecimal("104000"), "PER_YEAR");
                createCutoff(iesUniHM, "GENERAL", "2023-2024", "Round 1", new BigDecimal("40.0"), null, "Merit (12th)");

                // ---- IES Polytechnic Diploma CSE ----
                Course iesUniDipCSE = createCourse(iesUni, "Diploma", "Computer Science Engineering", "Diploma", 3,
                                "Polytechnic Diploma in CSE with Programming, Networking, Web Development, and Hardware basics",
                                "10th pass with 35%");
                createSeatMatrix(iesUniDipCSE, "GENERAL", 60, 25, "2026-27");
                createSeatMatrix(iesUniDipCSE, "OBC", 25, 10, "2026-27");
                createSeatMatrix(iesUniDipCSE, "SC", 10, 4, "2026-27");
                createSeatMatrix(iesUniDipCSE, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniDipCSE, "2026-27", new BigDecimal("24000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("1500"), new BigDecimal("3000"),
                                new BigDecimal("2500"),
                                new BigDecimal("66000"), "PER_YEAR");
                createCutoff(iesUniDipCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("35.0"), null,
                                "Merit (10th)");

                // ---- IES Polytechnic Diploma ME ----
                Course iesUniDipME = createCourse(iesUni, "Diploma", "Mechanical Engineering", "Diploma", 3,
                                "Polytechnic Diploma in ME with Workshop, Manufacturing, Thermodynamics, and Machine Drawing",
                                "10th pass with 35%");
                createSeatMatrix(iesUniDipME, "GENERAL", 60, 28, "2026-27");
                createSeatMatrix(iesUniDipME, "OBC", 25, 12, "2026-27");
                createSeatMatrix(iesUniDipME, "SC", 10, 5, "2026-27");
                createSeatMatrix(iesUniDipME, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniDipME, "2026-27", new BigDecimal("24000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("1500"), new BigDecimal("3000"),
                                new BigDecimal("2500"),
                                new BigDecimal("66000"), "PER_YEAR");
                createCutoff(iesUniDipME, "GENERAL", "2023-2024", "Round 1", new BigDecimal("32.0"), null,
                                "Merit (10th)");

                // ---- IES Polytechnic Diploma Civil ----
                Course iesUniDipCivil = createCourse(iesUni, "Diploma", "Civil Engineering", "Diploma", 3,
                                "Polytechnic Diploma in Civil with Surveying, Building Construction, and Structural Drawing",
                                "10th pass with 35%");
                createSeatMatrix(iesUniDipCivil, "GENERAL", 60, 28, "2026-27");
                createSeatMatrix(iesUniDipCivil, "OBC", 25, 12, "2026-27");
                createSeatMatrix(iesUniDipCivil, "SC", 10, 5, "2026-27");
                createSeatMatrix(iesUniDipCivil, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniDipCivil, "2026-27", new BigDecimal("24000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("1500"), new BigDecimal("3000"),
                                new BigDecimal("2500"),
                                new BigDecimal("66000"), "PER_YEAR");
                createCutoff(iesUniDipCivil, "GENERAL", "2023-2024", "Round 1", new BigDecimal("32.0"), null,
                                "Merit (10th)");

                // ---- IES Polytechnic Diploma EE ----
                Course iesUniDipEE = createCourse(iesUni, "Diploma", "Electrical Engineering", "Diploma", 3,
                                "Polytechnic Diploma in EE with Electrical Machines, Power Systems, and Wiring",
                                "10th pass with 35%");
                createSeatMatrix(iesUniDipEE, "GENERAL", 60, 28, "2026-27");
                createSeatMatrix(iesUniDipEE, "OBC", 25, 12, "2026-27");
                createSeatMatrix(iesUniDipEE, "SC", 10, 5, "2026-27");
                createSeatMatrix(iesUniDipEE, "ST", 6, 3, "2026-27");
                createFeeStructure(iesUniDipEE, "2026-27", new BigDecimal("24000"), new BigDecimal("30000"),
                                new BigDecimal("5000"), new BigDecimal("1500"), new BigDecimal("3000"),
                                new BigDecimal("2500"),
                                new BigDecimal("66000"), "PER_YEAR");
                createCutoff(iesUniDipEE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("32.0"), null,
                                "Merit (10th)");

                System.out.println("✅ Bhopal Colleges seeded successfully! Total: 43 colleges");
        }

        // Helper methods
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
                college.setFacilities(
                                "Library,Hostel,Sports Complex,Cafeteria,Labs,Wi-Fi,Auditorium,Medical Facility,Transport");

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
                map.put("Maulana Azad National Institute of Technology (MANIT)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/MANIT_Main_Building.jpg/800px-MANIT_Main_Building.jpg");
                map.put("Rajiv Gandhi Proudyogiki Vishwavidyalaya (RGPV)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Rajiv_Gandhi_Proudyogiki_Vishwavidyalaya_%28RGPV%29_Admin_building.jpg/800px-Rajiv_Gandhi_Proudyogiki_Vishwavidyalaya_%28RGPV%29_Admin_building.jpg");
                map.put("University Institute of Technology (UIT-RGPV)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/UIT_RGPV_Bhopal_Campus_%283%29.jpg/800px-UIT_RGPV_Bhopal_Campus_%283%29.jpg");
                map.put("All India Institute of Medical Sciences (AIIMS) Bhopal",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/AIIMS_Bhopal_Building_Front_%286%29.jpg/800px-AIIMS_Bhopal_Building_Front_%286%29.jpg");
                map.put("Gandhi Medical College (GMC) Bhopal",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Gandhi_Medical_College%2C_Bhopal.jpg/800px-Gandhi_Medical_College%2C_Bhopal.jpg");
                map.put("Indian Institute of Forest Management (IIFM)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/IIFM%2C_Bhopal_entrance_gate_2.jpg/800px-IIFM%2C_Bhopal_entrance_gate_2.jpg");
                map.put("Government Hamidia Arts and Commerce College",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Government_Hamidia_Arts_%26_Commerce_Degree_College_old_building%2C_Bhopal%2C_India.jpg/800px-Government_Hamidia_Arts_%26_Commerce_Degree_College_old_building%2C_Bhopal%2C_India.jpg");
                map.put("Oriental Institute of Science and Technology (OIST)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Oriental_institute_of_science_and_technology.jpg/800px-Oriental_institute_of_science_and_technology.jpg");
                map.put("Sagar Institute of Research and Technology (SIRT)",
                                "https://i.pinimg.com/736x/12/6d/95/126d95b5c926b36d44d2a8a8f35c690b.jpg");
                map.put("People's College of Medical Sciences and Research Centre",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/People%27s_College_of_Medical_Sciences_Campus.jpg/800px-People%27s_College_of_Medical_Sciences_Campus.jpg");
                map.put("National Law Institute University (NLIU) Bhopal",
                                "https://upload.wikimedia.org/wikipedia/commons/4/4d/NLIU_campus.jpg");
                map.put("IES College of Technology",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IES_College_of_Technology%2C_Bhopal_Main_Building.jpg/800px-IES_College_of_Technology%2C_Bhopal_Main_Building.jpg");
                map.put("IES University",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IES_College_of_Technology%2C_Bhopal_Main_Building.jpg/800px-IES_College_of_Technology%2C_Bhopal_Main_Building.jpg");
                map.put("Sagar Institute of Science Technology and Engineering (SISTec)",
                                "https://upload.wikimedia.org/wikipedia/commons/c/c2/SISTec-e.jpg");
                map.put("Sage University Bhopal",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/SAGE_University_Bhopal.jpg/800px-SAGE_University_Bhopal.jpg");
                // Remaining colleges - real Bhopal landmark photos from Wikimedia Commons
                String bhopalJunction = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Bhopal_Junction_new_building_01.jpg/800px-Bhopal_Junction_new_building_01.jpg";
                String bharatBhavan = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Bharat_Bhavan_Bhopal.JPG/800px-Bharat_Bhavan_Bhopal.JPG";
                String badaTalab = "https://upload.wikimedia.org/wikipedia/commons/9/92/Bada_Talab_In_Bhopal.png";
                String upperLake = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Boats_in_Upper_Lake%2C_Bhopal.JPG/800px-Boats_in_Upper_Lake%2C_Bhopal.JPG";
                String birlaMandir = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Birla_Mandir_Bhopal_Side_view.jpg/800px-Birla_Mandir_Bhopal_Side_view.jpg";
                String bhelBhopal = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/BHEL_Bhopal_in_rain.jpg/800px-BHEL_Bhopal_in_rain.jpg";
                String newMarket = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Deewali_New_market.jpg/800px-Deewali_New_market.jpg";
                // Real college photos from user-provided URLs
                map.put("Barkatullah University",
                                "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn");
                map.put("Government Motilal Vigyan Mahavidyalaya", bharatBhavan);
                map.put("Sarojini Naidu Government Girls PG College",
                                "https://media.collegedekho.com/media/img/institute/crawled_images/None/Sarojini_Naidu_Govt_Girls_PG_College2.jpeg?width=1080");
                map.put("Lakshmi Narain College of Technology (LNCT)", newMarket);
                map.put("Technocrats Institute of Technology (TIT)",
                                "https://technocratsgroup.edu.in/wp-content/uploads/2024/02/TIT-excellence.jpg");
                map.put("Truba Institute of Engineering and Information Technology",
                                "https://images.shiksha.com/mediadata/images/1579589944phpNiyJ9a.png");
                map.put("Scope College of Engineering",
                                "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eS1iaG9w/YWwtbWFkaHlhLXBy/YWRlc2gvc2NvcGUt/Z2xvYmFsLXNraWxs/cy11bml2ZXJzaXR5/LWJob3BhbC1tYWRo/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA");
                map.put("RKDF University", "https://images.shiksha.com/mediadata/images/1558506849phpBZBqun.jpeg");
                map.put("VNS Group of Institutions",
                                "https://www.collegebatch.com/static/clg-gallery/vns-group-of-institutions-faculty-of-engineering-bhopal-286585.webp");
                map.put("Bansal Institute of Science and Technology (BIST)",
                                "https://imgs.search.brave.com/0VFRpjp0tc-m2QVZZ9QwsU7az7_c-VV7ZPTWeFLn--s/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/eXV2YW1pbmQuY29tL2NvbGxlZ2VzL2lt/YWdlcy9jb2xsZWdl/L2JhbnNhbC1jb2xs/ZWdlLW9mLWVuZ2lu/ZWVyaW5nLWJob3Bh/bC1jYW1wdXMucG5n");
                map.put("NRI Institute of Information Science and Technology", newMarket);
                map.put("Chameli Devi Group of Institutions", birlaMandir);
                map.put("Radharaman Group of Institutes", bhelBhopal);
                map.put("Patel College of Science and Technology (PCST)", badaTalab);
                map.put("Bhabha Engineering Research Institute (BERI)", bhopalJunction);
                map.put("Chirayu Medical College and Hospital", upperLake);
                map.put("L.N. Medical College and J.K. Hospital", bharatBhavan);
                map.put("People's College of Pharmacy", newMarket);
                map.put("Oriental College of Pharmacy", badaTalab);
                map.put("Sushila Devi Bansal College of Technology (SDBCT)", birlaMandir);
                map.put("Extol College of Engineering and Management", bhelBhopal);
                map.put("Sri Satya Sai College of Engineering (SSCE)", upperLake);
                map.put("Millennium Group of Institutions", bhopalJunction);
                map.put("Lakshmi Narain College of Technology Excellence (LNCTE)", newMarket);
                map.put("ITM University Gwalior - Bhopal Campus", bharatBhavan);
                map.put("IPS Academy Bhopal", birlaMandir);
                map.put("Government M.L.B. Girls PG Autonomous College", badaTalab);
                map.put("Sam Global University Bhopal", bhelBhopal);
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
                java.util.List<Course> courses = courseRepository.findByCollegeAndNameAndSpecialization(college, name,
                                specialization);
                Course course = courses.isEmpty() ? null : courses.get(0);
                if (course == null) {
                        course = new Course();
                        course.setCollege(college);
                        course.setName(name);
                        course.setSpecialization(specialization);
                }
                course.setDegree(degree);
                course.setDurationYears(duration);
                course.setDescription(description);
                course.setEligibility(eligibility);
                course.setActive(true);
                return courseRepository.save(course);
        }

        private void createSeatMatrix(Course course, String category, Integer total, Integer available, String year) {
                java.util.List<SeatMatrix> seats = seatMatrixRepository.findByCourseAndCategoryAndAcademicYear(course,
                                category, year);
                SeatMatrix seat = seats.isEmpty() ? null : seats.get(0);
                if (seat == null) {
                        seat = new SeatMatrix();
                        seat.setCourse(course);
                        seat.setCategory(category);
                        seat.setAcademicYear(year);
                }
                seat.setTotalSeats(total);
                seat.setAvailableSeats(available);
                seatMatrixRepository.save(seat);
        }

        private void createFeeStructure(Course course, String year, BigDecimal tuition, BigDecimal hostel,
                        BigDecimal transport, BigDecimal library, BigDecimal lab,
                        BigDecimal other, BigDecimal total, String feeType) {
                java.util.List<FeeStructure> fees = feeStructureRepository.findByCourseAndAcademicYear(course, year);
                FeeStructure fee = fees.isEmpty() ? null : fees.get(0);
                if (fee == null) {
                        fee = new FeeStructure();
                        fee.setCourse(course);
                        fee.setAcademicYear(year);
                }
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
                java.util.List<Cutoff> cutoffs = cutoffRepository.findByCourseAndCategoryAndAcademicYearAndRound(course,
                                category, year, round);
                Cutoff cutoff = cutoffs.isEmpty() ? null : cutoffs.get(0);
                if (cutoff == null) {
                        cutoff = new Cutoff();
                        cutoff.setCourse(course);
                        cutoff.setCategory(category);
                        cutoff.setAcademicYear(year);
                        cutoff.setRound(round);
                }
                cutoff.setCutoffPercentage(percentage);
                cutoff.setCutoffRank(rank);
                cutoff.setExamType(examType);
                cutoffRepository.save(cutoff);
        }
}
