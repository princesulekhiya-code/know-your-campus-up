package com.knowyourcampus.config;

import com.knowyourcampus.entity.*;
import com.knowyourcampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class MPCollegeSeeder {

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

        public void seedAllMPColleges() {
                System.out.println("🏛️ Seeding All Madhya Pradesh Colleges...");

                seedIndoreColleges();
                seedGwaliorColleges();
                seedJabalpurColleges();
                seedUjjainColleges();
                seedRewaColleges();
                seedSagarColleges();
                seedOtherCitiesColleges();

                System.out.println("✅ All MP Colleges seeded successfully!");
        }

        // ==================== INDORE COLLEGES ====================
        private void seedIndoreColleges() {
                System.out.println("📍 Seeding Indore Colleges...");

                // 1. IIT Indore
                College iitIndore = createCollege(
                                "Indian Institute of Technology Indore (IIT Indore)",
                                "IIT Indore is one of the new generation IITs established in 2009. Known for excellent research and academics in engineering and sciences.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "Khandwa Road, Simrol, Indore, MP 453552",
                                "453552",
                                "0731-6603100",
                                "registrar@iiti.ac.in",
                                "https://www.iiti.ac.in",
                                "A++",
                                true,
                                2009,
                                "Autonomous (IIT System)");

                Course iitIndoreCSE = createCourse(iitIndore, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Advanced qualified");
                createSeatMatrix(iitIndoreCSE, "GENERAL", 60, 8, "2026-27");
                createSeatMatrix(iitIndoreCSE, "OBC", 35, 5, "2026-27");
                createSeatMatrix(iitIndoreCSE, "SC", 18, 3, "2026-27");
                createSeatMatrix(iitIndoreCSE, "ST", 10, 2, "2026-27");
                createFeeStructure(iitIndoreCSE, "2026-27", new BigDecimal("220000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("290000"), "PER_YEAR");
                createCutoff(iitIndoreCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.2"), 2500,
                                "JEE Advanced");

                Course iitIndoreEE = createCourse(iitIndore, "B.Tech", "Electrical Engineering", "UG", 4,
                                "Bachelor of Technology in EE", "JEE Advanced qualified");
                createSeatMatrix(iitIndoreEE, "GENERAL", 55, 7, "2026-27");
                createFeeStructure(iitIndoreEE, "2026-27", new BigDecimal("220000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("290000"), "PER_YEAR");

                Course iitIndoreME = createCourse(iitIndore, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in ME", "JEE Advanced qualified");
                createSeatMatrix(iitIndoreME, "GENERAL", 55, 8, "2026-27");
                createFeeStructure(iitIndoreME, "2026-27", new BigDecimal("220000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("290000"), "PER_YEAR");

                // 2. IIM Indore
                College iimIndore = createCollege(
                                "Indian Institute of Management Indore (IIM Indore)",
                                "IIM Indore is a premier business school in India, part of the prestigious IIM family. Known for excellence in management education and research.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "Prabandh Shikhar, Rau-Pithampur Road, Indore, MP 453556",
                                "453556",
                                "0731-2439670",
                                "admission@iimidr.ac.in",
                                "https://www.iimidr.ac.in",
                                "A++",
                                true,
                                1996,
                                "Autonomous (IIM System)");

                Course iimIndorePGP = createCourse(iimIndore, "PGP", "Management", "PG", 2,
                                "Post Graduate Programme in Management (MBA equivalent)",
                                "CAT qualified with work experience");
                createSeatMatrix(iimIndorePGP, "GENERAL", 350, 40, "2026-27");
                createSeatMatrix(iimIndorePGP, "OBC", 180, 20, "2026-27");
                createFeeStructure(iimIndorePGP, "2026-27", new BigDecimal("1200000"), new BigDecimal("100000"),
                                new BigDecimal("0"), new BigDecimal("20000"), new BigDecimal("0"),
                                new BigDecimal("80000"),
                                new BigDecimal("1400000"), "PER_YEAR");
                createCutoff(iimIndorePGP, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.5"), null, "CAT");

                Course iimIndoreIPM = createCourse(iimIndore, "IPM", "Management", "UG", 5,
                                "Integrated Programme in Management (After 12th)", "IPMAT qualified");
                createSeatMatrix(iimIndoreIPM, "GENERAL", 120, 15, "2026-27");
                createFeeStructure(iimIndoreIPM, "2026-27", new BigDecimal("800000"), new BigDecimal("80000"),
                                new BigDecimal("0"), new BigDecimal("15000"), new BigDecimal("0"),
                                new BigDecimal("50000"),
                                new BigDecimal("945000"), "PER_YEAR");
                createCutoff(iimIndoreIPM, "GENERAL", "2023-2024", "Round 1", new BigDecimal("95.0"), 500, "IPMAT");

                // 3. DAVV (Devi Ahilya Vishwavidyalaya)
                College davv = createCollege(
                                "Devi Ahilya Vishwavidyalaya (DAVV)",
                                "DAVV is a premier state university in Indore, named after Rani Ahilya Bai Holkar. Offers diverse programs in arts, science, commerce, and professional courses.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "Takshashila Campus, Khandwa Road, Indore, MP 452001",
                                "452001",
                                "0731-2527532",
                                "registrar@dfrv.mp.gov.in",
                                "https://www.dfrv.ac.in",
                                "A+",
                                true,
                                1964,
                                "State University");

                Course davvBA = createCourse(davv, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(davvBA, "GENERAL", 600, 150, "2026-27");
                createFeeStructure(davvBA, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("0"),
                                new BigDecimal("1500"),
                                new BigDecimal("7500"), "PER_YEAR");

                Course davvBSc = createCourse(davv, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(davvBSc, "GENERAL", 500, 120, "2026-27");
                createFeeStructure(davvBSc, "2026-27", new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("2000"),
                                new BigDecimal("13500"), "PER_YEAR");

                Course davvBCom = createCourse(davv, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th with Commerce");
                createSeatMatrix(davvBCom, "GENERAL", 450, 100, "2026-27");
                createFeeStructure(davvBCom, "2026-27", new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("500"),
                                new BigDecimal("1500"),
                                new BigDecimal("9000"), "PER_YEAR");

                Course davvMBA = createCourse(davv, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "Graduation with 50%");
                createSeatMatrix(davvMBA, "GENERAL", 200, 40, "2026-27");
                createFeeStructure(davvMBA, "2026-27", new BigDecimal("45000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("53000"), "PER_YEAR");

                // 4. SGSITS Indore
                College sgsits = createCollege(
                                "Shri Govindram Seksaria Institute of Technology and Science (SGSITS)",
                                "SGSITS is a premier government engineering college in MP, established in 1952. Known for quality engineering education and excellent placements.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "23, Park Road, Indore, MP 452003",
                                "452003",
                                "0731-2432711",
                                "director@sgsits.ac.in",
                                "https://www.sgsits.ac.in",
                                "A+",
                                true,
                                1952,
                                "RGPV");

                Course sgsitsCSE = createCourse(sgsits, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(sgsitsCSE, "GENERAL", 90, 15, "2026-27");
                createSeatMatrix(sgsitsCSE, "OBC", 50, 10, "2026-27");
                createSeatMatrix(sgsitsCSE, "SC", 25, 5, "2026-27");
                createFeeStructure(sgsitsCSE, "2026-27", new BigDecimal("95000"), new BigDecimal("30000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("140000"), "PER_YEAR");
                createCutoff(sgsitsCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("94.5"), 45000, "JEE Main");

                Course sgsitsECE = createCourse(sgsits, "B.Tech", "Electronics and Communication", "UG", 4,
                                "Bachelor of Technology in ECE", "JEE Main qualified");
                createSeatMatrix(sgsitsECE, "GENERAL", 80, 12, "2026-27");
                createFeeStructure(sgsitsECE, "2026-27", new BigDecimal("95000"), new BigDecimal("30000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("140000"), "PER_YEAR");

                Course sgsitsME = createCourse(sgsits, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in ME", "JEE Main qualified");
                createSeatMatrix(sgsitsME, "GENERAL", 90, 18, "2026-27");
                createFeeStructure(sgsitsME, "2026-27", new BigDecimal("95000"), new BigDecimal("30000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("140000"), "PER_YEAR");

                // 5. IET DAVV Indore
                College ietDavv = createCollege(
                                "Institute of Engineering and Technology (IET-DAVV)",
                                "IET is a constituent college of DAVV offering quality engineering education with good infrastructure.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "DAVV Campus, Khandwa Road, Indore, MP 452017",
                                "452017",
                                "0731-2467881",
                                "director.iet@dfrv.ac.in",
                                "https://www.ietdavv.edu.in",
                                "A",
                                true,
                                1996,
                                "DAVV");

                Course ietCSE = createCourse(ietDavv, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(ietCSE, "GENERAL", 60, 12, "2026-27");
                createFeeStructure(ietCSE, "2026-27", new BigDecimal("75000"), new BigDecimal("25000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("112000"), "PER_YEAR");
                createCutoff(ietCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("92.0"), 60000, "JEE Main");

                // 6. MGM Medical College Indore
                College mgmIndore = createCollege(
                                "Mahatma Gandhi Memorial Medical College (MGM)",
                                "MGM Medical College is one of the oldest and most prestigious government medical colleges in MP.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "AB Road, Indore, MP 452001",
                                "452001",
                                "0731-2527383",
                                "principal@mgmmc.mp.gov.in",
                                "https://www.mgmmedicalcollege.in",
                                "A+",
                                true,
                                1948,
                                "MPMC");

                Course mgmMBBS = createCourse(mgmIndore, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(mgmMBBS, "GENERAL", 150, 20, "2026-27");
                createSeatMatrix(mgmMBBS, "OBC", 80, 12, "2026-27");
                createSeatMatrix(mgmMBBS, "SC", 40, 6, "2026-27");
                createFeeStructure(mgmMBBS, "2026-27", new BigDecimal("30000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("63000"), "PER_YEAR");
                createCutoff(mgmMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("98.0"), 12000, "NEET UG");

                // 7. Medicaps University
                College medicaps = createCollege(
                                "Medicaps University",
                                "Medicaps is a leading private university in Indore offering engineering, pharmacy, and management programs with excellent placements.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "A.B. Road, Pigdamber, Rau, Indore, MP 453331",
                                "453331",
                                "0731-4259500",
                                "info@medicaps.ac.in",
                                "https://www.medicaps.ac.in",
                                "A+",
                                true,
                                2000,
                                "UGC Approved Private University");

                Course medicapsCSE = createCourse(medicaps, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(medicapsCSE, "GENERAL", 180, 45, "2026-27");
                createFeeStructure(medicapsCSE, "2026-27", new BigDecimal("150000"), new BigDecimal("60000"),
                                new BigDecimal("20000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("15000"),
                                new BigDecimal("265000"), "PER_YEAR");

                Course medicapsAI = createCourse(medicaps, "B.Tech", "Artificial Intelligence", "UG", 4,
                                "B.Tech in AI and Data Science", "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(medicapsAI, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(medicapsAI, "2026-27", new BigDecimal("170000"), new BigDecimal("60000"),
                                new BigDecimal("20000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("17000"),
                                new BigDecimal("290000"), "PER_YEAR");

                Course medicapsMBA = createCourse(medicaps, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT with graduation");
                createSeatMatrix(medicapsMBA, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(medicapsMBA, "2026-27", new BigDecimal("180000"), new BigDecimal("50000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("12000"),
                                new BigDecimal("265000"), "PER_YEAR");

                // 8. Prestige Institute of Management
                College prestige = createCollege(
                                "Prestige Institute of Management and Research (PIMR)",
                                "PIMR is a leading management institute in Indore affiliated to DAVV, known for excellent MBA program.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Scheme No. 74-C, Vijay Nagar, Indore, MP 452010",
                                "452010",
                                "0731-2557500",
                                "admission@pfrr.ac.in",
                                "https://www.pfrr.ac.in",
                                "A",
                                true,
                                1994,
                                "DAVV");

                Course prestigeMBA = createCourse(prestige, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT/CMAT with graduation");
                createSeatMatrix(prestigeMBA, "GENERAL", 180, 40, "2026-27");
                createFeeStructure(prestigeMBA, "2026-27", new BigDecimal("250000"), new BigDecimal("55000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("15000"),
                                new BigDecimal("343000"), "PER_YEAR");

                // 9. Acropolis Institute
                College acropolis = createCollege(
                                "Acropolis Institute of Technology and Research",
                                "Acropolis is a leading private engineering college in Indore known for quality education and placements.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Manglia Bypass, Indore, MP 453771",
                                "453771",
                                "0731-4226000",
                                "info@acropolis.in",
                                "https://www.acropolis.in",
                                "A",
                                true,
                                2004,
                                "RGPV");

                Course acropolisCSE = createCourse(acropolis, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(acropolisCSE, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(acropolisCSE, "2026-27", new BigDecimal("110000"), new BigDecimal("50000"),
                                new BigDecimal("15000"), new BigDecimal("6000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("199000"), "PER_YEAR");

                Course acropolisMBA = createCourse(acropolis, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT with graduation");
                createSeatMatrix(acropolisMBA, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(acropolisMBA, "2026-27", new BigDecimal("130000"), new BigDecimal("45000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("202000"), "PER_YEAR");

                // 10. IPS Academy Indore
                College ipsIndore = createCollege(
                                "IPS Academy Indore",
                                "IPS Academy is a multi-disciplinary institute offering engineering, pharmacy, and management programs.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Rajendra Nagar, A.B. Road, Indore, MP 452012",
                                "452012",
                                "0731-4014700",
                                "info@ipsacademy.org",
                                "https://www.ipsacademy.org",
                                "A",
                                true,
                                1999,
                                "RGPV / DAVV");

                Course ipsIndoreCSE = createCourse(ipsIndore, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(ipsIndoreCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(ipsIndoreCSE, "2026-27", new BigDecimal("95000"), new BigDecimal("42000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("8000"),
                                new BigDecimal("169000"), "PER_YEAR");

                // 11. SVITS Indore
                College svits = createCollege(
                                "Shri Vaishnav Vidyapeeth Vishwavidyalaya (SVVV)",
                                "SVVV is a private university offering diverse programs in engineering, management, and sciences with excellent infrastructure.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Gram Baroli, Sanwer Road, Indore, MP 453111",
                                "453111",
                                "0731-2842800",
                                "info@svvv.edu.in",
                                "https://www.svvv.edu.in",
                                "A+",
                                true,
                                2015,
                                "UGC Approved Private University");

                Course svitsCSE = createCourse(svits, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(svitsCSE, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(svitsCSE, "2026-27", new BigDecimal("130000"), new BigDecimal("55000"),
                                new BigDecimal("18000"), new BigDecimal("7000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("232000"), "PER_YEAR");

                Course svitsMBA = createCourse(svits, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT with graduation");
                createSeatMatrix(svitsMBA, "GENERAL", 180, 45, "2026-27");
                createFeeStructure(svitsMBA, "2026-27", new BigDecimal("150000"), new BigDecimal("50000"),
                                new BigDecimal("15000"), new BigDecimal("7000"), new BigDecimal("0"),
                                new BigDecimal("13000"),
                                new BigDecimal("235000"), "PER_YEAR");

                // 12. Index Medical College
                College indexMedical = createCollege(
                                "Index Medical College Hospital and Research Centre",
                                "Index Medical College is a private medical college with multi-specialty hospital in Indore.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "NH-59A, Nemawar Road, Indore, MP 452016",
                                "452016",
                                "0731-4247100",
                                "info@indexmedicalcollege.com",
                                "https://www.indexmedicalcollege.com",
                                "A",
                                true,
                                2008,
                                "MPMC");

                Course indexMBBS = createCourse(indexMedical, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(indexMBBS, "GENERAL", 150, 25, "2026-27");
                createFeeStructure(indexMBBS, "2026-27", new BigDecimal("1200000"), new BigDecimal("70000"),
                                new BigDecimal("0"), new BigDecimal("12000"), new BigDecimal("18000"),
                                new BigDecimal("25000"),
                                new BigDecimal("1325000"), "PER_YEAR");

                // 13. MIT Indore (Malwa Institute)
                College mitIndore = createCollege(
                                "Malwa Institute of Technology (MIT Indore)",
                                "MIT Indore offers quality engineering education with focus on practical learning and industry exposure.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Near Dewas Naka, Indore, MP 452016",
                                "452016",
                                "0731-4280100",
                                "info@mitindore.ac.in",
                                "https://www.mitindore.ac.in",
                                "B++",
                                true,
                                2000,
                                "RGPV");

                Course mitIndoreCSE = createCourse(mitIndore, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(mitIndoreCSE, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(mitIndoreCSE, "2026-27", new BigDecimal("72000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("132000"), "PER_YEAR");

                // 14. Chameli Devi Group Indore
                College chameliIndore = createCollege(
                                "Chameli Devi Group of Institutions Indore",
                                "Chameli Devi offers engineering and pharmacy programs with modern facilities and good placements.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Khandwa Road, Indore, MP 452020",
                                "452020",
                                "0731-4220100",
                                "info@cdgi.edu.in",
                                "https://www.cdgi.edu.in",
                                "B++",
                                true,
                                2006,
                                "RGPV");

                Course chameliIndoreCSE = createCourse(chameliIndore, "B.Tech", "Computer Science and Engineering",
                                "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(chameliIndoreCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(chameliIndoreCSE, "2026-27", new BigDecimal("68000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("128000"), "PER_YEAR");

                // 15. Sage University Indore
                College sageIndore = createCollege(
                                "Sage University Indore",
                                "SAGE University Indore is a leading private university offering comprehensive programs in Engineering, Management, Law, Pharmacy, Design, and Sciences. Known for industry partnerships, modern campus, and excellent placement record.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Bypass Road, Ayodhya Nagar, Indore, MP 452020",
                                "452020",
                                "0731-6699999",
                                "info@sageindore.in",
                                "https://www.sageuniversity.in",
                                "A+",
                                true,
                                2017,
                                "UGC Approved Private University");

                // B.Tech CSE
                Course sageIndoreCSE = createCourse(sageIndore, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "B.Tech in CSE with specializations in AI, ML, Cyber Security, Cloud Computing",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreCSE, "GENERAL", 240, 70, "2026-27");
                createSeatMatrix(sageIndoreCSE, "OBC", 120, 35, "2026-27");
                createSeatMatrix(sageIndoreCSE, "SC", 60, 18, "2026-27");
                createFeeStructure(sageIndoreCSE, "2026-27", new BigDecimal("130000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("15000"),
                                new BigDecimal("243000"), "PER_YEAR");
                createCutoff(sageIndoreCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("68.0"), null,
                                "JEE Main / Merit");

                // B.Tech AI & ML
                Course sageIndoreAI = createCourse(sageIndore, "B.Tech", "Artificial Intelligence and Machine Learning",
                                "UG", 4,
                                "B.Tech in AI & ML with Python, Deep Learning, NLP, and Computer Vision",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreAI, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(sageIndoreAI, "2026-27", new BigDecimal("145000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("264000"), "PER_YEAR");

                // B.Tech Data Science
                Course sageIndoreDS = createCourse(sageIndore, "B.Tech", "Data Science and Analytics", "UG", 4,
                                "B.Tech in Data Science with Big Data, Hadoop, Spark, and Tableau",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreDS, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreDS, "2026-27", new BigDecimal("145000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("264000"), "PER_YEAR");

                // B.Tech Cyber Security
                Course sageIndoreCyber = createCourse(sageIndore, "B.Tech", "Cyber Security", "UG", 4,
                                "B.Tech in Cyber Security with Ethical Hacking, Network Security, and Digital Forensics",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreCyber, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageIndoreCyber, "2026-27", new BigDecimal("145000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("264000"), "PER_YEAR");

                // B.Tech ECE
                Course sageIndoreECE = createCourse(sageIndore, "B.Tech", "Electronics and Communication Engineering",
                                "UG", 4,
                                "B.Tech in ECE with VLSI, Embedded Systems, and IoT",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreECE, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(sageIndoreECE, "2026-27", new BigDecimal("120000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("14000"),
                                new BigDecimal("232000"), "PER_YEAR");

                // B.Tech Mechanical
                Course sageIndoreME = createCourse(sageIndore, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "B.Tech in Mechanical Engineering with CAD/CAM, Robotics, and 3D Printing",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreME, "GENERAL", 90, 35, "2026-27");
                createFeeStructure(sageIndoreME, "2026-27", new BigDecimal("115000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("12000"),
                                new BigDecimal("225000"), "PER_YEAR");

                // B.Tech Civil
                Course sageIndoreCivil = createCourse(sageIndore, "B.Tech", "Civil Engineering", "UG", 4,
                                "B.Tech in Civil Engineering with Smart City and Green Building concepts",
                                "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(sageIndoreCivil, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreCivil, "2026-27", new BigDecimal("110000"), new BigDecimal("60000"),
                                new BigDecimal("18000"), new BigDecimal("8000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("216000"), "PER_YEAR");

                // MBA
                Course sageIndoreMBA = createCourse(sageIndore, "MBA", "Management", "PG", 2,
                                "MBA with specializations in Finance, Marketing, HR, Operations, Business Analytics",
                                "CAT/MAT/CMAT/SAAT with graduation 50%");
                createSeatMatrix(sageIndoreMBA, "GENERAL", 240, 70, "2026-27");
                createFeeStructure(sageIndoreMBA, "2026-27", new BigDecimal("175000"), new BigDecimal("55000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("15000"),
                                new BigDecimal("268000"), "PER_YEAR");
                createCutoff(sageIndoreMBA, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), null,
                                "CAT/MAT/SAAT");

                // BBA
                Course sageIndoreBBA = createCourse(sageIndore, "BBA", "Business Administration", "UG", 3,
                                "BBA with industry visits, live projects, and internship program", "12th with 50%");
                createSeatMatrix(sageIndoreBBA, "GENERAL", 180, 55, "2026-27");
                createFeeStructure(sageIndoreBBA, "2026-27", new BigDecimal("90000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("167000"), "PER_YEAR");

                // BCA
                Course sageIndoreBCA = createCourse(sageIndore, "BCA", "Computer Applications", "UG", 3,
                                "BCA with programming languages, web development, and software skills",
                                "12th with 45%");
                createSeatMatrix(sageIndoreBCA, "GENERAL", 120, 45, "2026-27");
                createFeeStructure(sageIndoreBCA, "2026-27", new BigDecimal("78000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("8000"),
                                new BigDecimal("161000"), "PER_YEAR");

                // MCA
                Course sageIndoreMCA = createCourse(sageIndore, "MCA", "Computer Applications", "PG", 2,
                                "MCA with advanced programming, cloud computing, and software development",
                                "BCA/B.Sc (CS) with 50%");
                createSeatMatrix(sageIndoreMCA, "GENERAL", 90, 35, "2026-27");
                createFeeStructure(sageIndoreMCA, "2026-27", new BigDecimal("98000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("10000"),
                                new BigDecimal("10000"),
                                new BigDecimal("186000"), "PER_YEAR");

                // BA LLB (Integrated Law)
                Course sageIndoreLaw = createCourse(sageIndore, "BA LLB", "Law", "UG", 5,
                                "Integrated BA LLB with Moot Court, Legal Aid Clinic, and Court Visits",
                                "CLAT / 12th with 45%");
                createSeatMatrix(sageIndoreLaw, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(sageIndoreLaw, "2026-27", new BigDecimal("100000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("12000"),
                                new BigDecimal("180000"), "PER_YEAR");
                createCutoff(sageIndoreLaw, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), null,
                                "CLAT/Merit");

                // BBA LLB
                Course sageIndoreBBALLB = createCourse(sageIndore, "BBA LLB", "Law with Management", "UG", 5,
                                "Integrated BBA LLB - Corporate Law and Business Management", "CLAT / 12th with 45%");
                createSeatMatrix(sageIndoreBBALLB, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreBBALLB, "2026-27", new BigDecimal("110000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("14000"),
                                new BigDecimal("192000"), "PER_YEAR");

                // B.Pharm
                Course sageIndoreBPharm = createCourse(sageIndore, "B.Pharm", "Pharmacy", "UG", 4,
                                "Bachelor of Pharmacy with advanced labs, hospital training, and industrial visits",
                                "12th with PCM/PCB 45%");
                createSeatMatrix(sageIndoreBPharm, "GENERAL", 100, 35, "2026-27");
                createFeeStructure(sageIndoreBPharm, "2026-27", new BigDecimal("115000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("15000"),
                                new BigDecimal("12000"),
                                new BigDecimal("210000"), "PER_YEAR");

                // D.Pharm
                Course sageIndoreDPharm = createCourse(sageIndore, "D.Pharm", "Pharmacy", "Diploma", 2,
                                "Diploma in Pharmacy with practical training", "12th with PCM/PCB 40%");
                createSeatMatrix(sageIndoreDPharm, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreDPharm, "2026-27", new BigDecimal("75000"), new BigDecimal("40000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("10000"),
                                new BigDecimal("8000"),
                                new BigDecimal("147000"), "PER_YEAR");

                // B.Des
                Course sageIndoreBDes = createCourse(sageIndore, "B.Des", "Design", "UG", 4,
                                "Bachelor of Design with Fashion Design, Interior Design, and Graphic Design",
                                "12th with 45% + Design Aptitude Test");
                createSeatMatrix(sageIndoreBDes, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreBDes, "2026-27", new BigDecimal("155000"), new BigDecimal("55000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("10000"),
                                new BigDecimal("15000"),
                                new BigDecimal("258000"), "PER_YEAR");

                // B.Sc Agriculture
                Course sageIndoreAgri = createCourse(sageIndore, "B.Sc", "Agriculture", "UG", 4,
                                "B.Sc Agriculture with farm management and modern agricultural technology",
                                "12th with PCB/PCM 45%");
                createSeatMatrix(sageIndoreAgri, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreAgri, "2026-27", new BigDecimal("88000"), new BigDecimal("45000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("168000"), "PER_YEAR");

                // B.Sc Nursing
                Course sageIndoreNursing = createCourse(sageIndore, "B.Sc", "Nursing", "UG", 4,
                                "Bachelor of Science in Nursing with clinical training", "12th PCB with 45%");
                createSeatMatrix(sageIndoreNursing, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageIndoreNursing, "2026-27", new BigDecimal("130000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("220000"), "PER_YEAR");

                // M.Tech
                Course sageIndoreMTech = createCourse(sageIndore, "M.Tech", "Computer Science and Engineering", "PG", 2,
                                "M.Tech CSE with AI, ML, Data Science specializations", "GATE / B.Tech with 55%");
                createSeatMatrix(sageIndoreMTech, "GENERAL", 30, 15, "2026-27");
                createFeeStructure(sageIndoreMTech, "2026-27", new BigDecimal("120000"), new BigDecimal("55000"),
                                new BigDecimal("15000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("12000"),
                                new BigDecimal("222000"), "PER_YEAR");

                // BPT - Physiotherapy
                Course sageIndoreBPT = createCourse(sageIndore, "BPT", "Physiotherapy", "UG", 4,
                                "Bachelor of Physiotherapy with hospital training", "12th PCB with 50%");
                createSeatMatrix(sageIndoreBPT, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(sageIndoreBPT, "2026-27", new BigDecimal("120000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("6000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("210000"), "PER_YEAR");

                // B.Sc Hotel Management
                Course sageIndoreHM = createCourse(sageIndore, "B.Sc", "Hotel Management", "UG", 3,
                                "B.Sc Hotel Management with practical kitchen training", "12th with 45%");
                createSeatMatrix(sageIndoreHM, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(sageIndoreHM, "2026-27", new BigDecimal("95000"), new BigDecimal("50000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("180000"), "PER_YEAR");

                System.out.println("✅ Indore: 15 colleges added (including Sage University Indore)");
        }

        // ==================== GWALIOR COLLEGES ====================
        private void seedGwaliorColleges() {
                System.out.println("📍 Seeding Gwalior Colleges...");

                // 1. IIITM Gwalior (ABV-IIITM)
                College iiitmGwalior = createCollege(
                                "ABV Indian Institute of Information Technology and Management (IIITM) Gwalior",
                                "ABV-IIITM is a premier government institute offering IT and management education. Known as 'MIT of India'.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Morena Link Road, Gwalior, MP 474015",
                                "474015",
                                "0751-2449801",
                                "registrar@iiitm.ac.in",
                                "https://www.iiitm.ac.in",
                                "A++",
                                true,
                                1997,
                                "Autonomous (Central Government)");

                Course iiitmIPM = createCourse(iiitmGwalior, "IPM", "IT + Management", "UG", 5,
                                "Integrated Program in Management (Dual Degree)", "AIEEE/JEE qualified");
                createSeatMatrix(iiitmIPM, "GENERAL", 120, 15, "2026-27");
                createSeatMatrix(iiitmIPM, "OBC", 65, 10, "2026-27");
                createFeeStructure(iiitmIPM, "2026-27", new BigDecimal("180000"), new BigDecimal("50000"),
                                new BigDecimal("0"), new BigDecimal("8000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("260000"), "PER_YEAR");
                createCutoff(iiitmIPM, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.0"), 28000, "JEE Main");

                Course iiitmBtech = createCourse(iiitmGwalior, "B.Tech", "Information Technology", "UG", 4,
                                "Bachelor of Technology in IT", "JEE Main qualified");
                createSeatMatrix(iiitmBtech, "GENERAL", 90, 12, "2026-27");
                createFeeStructure(iiitmBtech, "2026-27", new BigDecimal("170000"), new BigDecimal("50000"),
                                new BigDecimal("0"), new BigDecimal("8000"), new BigDecimal("10000"),
                                new BigDecimal("12000"),
                                new BigDecimal("250000"), "PER_YEAR");

                Course iiitmMBA = createCourse(iiitmGwalior, "MBA", "Information Technology Management", "PG", 2,
                                "MBA in IT Management", "CAT qualified with graduation");
                createSeatMatrix(iiitmMBA, "GENERAL", 60, 10, "2026-27");
                createFeeStructure(iiitmMBA, "2026-27", new BigDecimal("300000"), new BigDecimal("60000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("0"),
                                new BigDecimal("20000"),
                                new BigDecimal("390000"), "PER_YEAR");

                // 2. MITS Gwalior
                College mitsGwalior = createCollege(
                                "Madhav Institute of Technology and Science (MITS) Gwalior",
                                "MITS is a premier government autonomous engineering college, one of the oldest and best in MP.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Race Course Road, Gwalior, MP 474005",
                                "474005",
                                "0751-2409300",
                                "director@mitsgwalior.in",
                                "https://www.mitsgwalior.in",
                                "A+",
                                true,
                                1957,
                                "RGPV (Autonomous)");

                Course mitsCSE = createCourse(mitsGwalior, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(mitsCSE, "GENERAL", 90, 15, "2026-27");
                createSeatMatrix(mitsCSE, "OBC", 50, 10, "2026-27");
                createFeeStructure(mitsCSE, "2026-27", new BigDecimal("95000"), new BigDecimal("28000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("138000"), "PER_YEAR");
                createCutoff(mitsCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("93.5"), 50000, "JEE Main");

                Course mitsECE = createCourse(mitsGwalior, "B.Tech", "Electronics and Communication", "UG", 4,
                                "Bachelor of Technology in ECE", "JEE Main qualified");
                createSeatMatrix(mitsECE, "GENERAL", 80, 12, "2026-27");
                createFeeStructure(mitsECE, "2026-27", new BigDecimal("95000"), new BigDecimal("28000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("138000"), "PER_YEAR");

                Course mitsME = createCourse(mitsGwalior, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in ME", "JEE Main qualified");
                createSeatMatrix(mitsME, "GENERAL", 90, 18, "2026-27");
                createFeeStructure(mitsME, "2026-27", new BigDecimal("95000"), new BigDecimal("28000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("138000"), "PER_YEAR");

                // 3. Jiwaji University
                College jiwaji = createCollege(
                                "Jiwaji University",
                                "Jiwaji University is a major state university in Gwalior named after Jiwajirao Scindia. Offers diverse programs.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Vidya Vihar, Gwalior, MP 474011",
                                "474011",
                                "0751-2442702",
                                "registrar@jfraju.ac.in",
                                "https://www.jfraju.ac.in",
                                "A",
                                true,
                                1964,
                                "State University");

                Course jiwajiBA = createCourse(jiwaji, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(jiwajiBA, "GENERAL", 500, 120, "2026-27");
                createFeeStructure(jiwajiBA, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("0"),
                                new BigDecimal("1500"),
                                new BigDecimal("7500"), "PER_YEAR");

                Course jiwajiBSc = createCourse(jiwaji, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(jiwajiBSc, "GENERAL", 400, 100, "2026-27");
                createFeeStructure(jiwajiBSc, "2026-27", new BigDecimal("7000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("2000"),
                                new BigDecimal("12500"), "PER_YEAR");

                Course jiwajiMBA = createCourse(jiwaji, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "Graduation with 50%");
                createSeatMatrix(jiwajiMBA, "GENERAL", 150, 35, "2026-27");
                createFeeStructure(jiwajiMBA, "2026-27", new BigDecimal("40000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("48000"), "PER_YEAR");

                // 4. ITM Gwalior (Now ITM University)
                College itmGwalior = createCollege(
                                "ITM University Gwalior",
                                "ITM University is a leading private university offering diverse programs with excellent placements.",
                                "PRIVATE",
                                "Gwalior",
                                "Madhya Pradesh",
                                "ITM Campus, NH-75, Jhansi Road, Gwalior, MP 474001",
                                "474001",
                                "0751-2432977",
                                "info@itmuniversity.ac.in",
                                "https://www.itmuniversity.ac.in",
                                "A+",
                                true,
                                1997,
                                "UGC Approved Private University");

                Course itmGwaliorCSE = createCourse(itmGwalior, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 50% in PCM");
                createSeatMatrix(itmGwaliorCSE, "GENERAL", 180, 50, "2026-27");
                createFeeStructure(itmGwaliorCSE, "2026-27", new BigDecimal("160000"), new BigDecimal("65000"),
                                new BigDecimal("20000"), new BigDecimal("8000"), new BigDecimal("12000"),
                                new BigDecimal("15000"),
                                new BigDecimal("280000"), "PER_YEAR");

                Course itmGwaliorMBA = createCourse(itmGwalior, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT/XAT with graduation");
                createSeatMatrix(itmGwaliorMBA, "GENERAL", 180, 45, "2026-27");
                createFeeStructure(itmGwaliorMBA, "2026-27", new BigDecimal("280000"), new BigDecimal("70000"),
                                new BigDecimal("18000"), new BigDecimal("10000"), new BigDecimal("0"),
                                new BigDecimal("20000"),
                                new BigDecimal("398000"), "PER_YEAR");

                Course itmGwaliorLaw = createCourse(itmGwalior, "BA LLB", "Law", "UG", 5,
                                "Integrated BA LLB", "CLAT / 12th with 50%");
                createSeatMatrix(itmGwaliorLaw, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(itmGwaliorLaw, "2026-27", new BigDecimal("140000"), new BigDecimal("55000"),
                                new BigDecimal("15000"), new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("10000"),
                                new BigDecimal("226000"), "PER_YEAR");

                // 5. GEC Gwalior (Gajra Raja Medical College)
                College grmc = createCollege(
                                "Gajra Raja Medical College (GRMC) Gwalior",
                                "GRMC is one of the oldest government medical colleges in MP, established in 1946.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Hospital Road, Gwalior, MP 474009",
                                "474009",
                                "0751-2321710",
                                "principal@grmc.mp.gov.in",
                                "https://www.grmcgwalior.ac.in",
                                "A",
                                true,
                                1946,
                                "MPMC");

                Course grmcMBBS = createCourse(grmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(grmcMBBS, "GENERAL", 150, 20, "2026-27");
                createSeatMatrix(grmcMBBS, "OBC", 80, 12, "2026-27");
                createFeeStructure(grmcMBBS, "2026-27", new BigDecimal("28000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("58000"), "PER_YEAR");
                createCutoff(grmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.5"), 15000, "NEET UG");

                // 6. Amity University Gwalior
                College amityGwalior = createCollege(
                                "Amity University Madhya Pradesh (Gwalior Campus)",
                                "Amity University MP offers diverse programs in a world-class campus with excellent facilities.",
                                "PRIVATE",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Maharajpura Air Force Station, Gwalior, MP 474020",
                                "474020",
                                "0751-2496001",
                                "gwalior@amity.edu",
                                "https://www.amity.edu/gwalior",
                                "A+",
                                true,
                                2010,
                                "UGC Approved Private University");

                Course amityGwaliorCSE = createCourse(amityGwalior, "B.Tech", "Computer Science and Engineering", "UG",
                                4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 60% in PCM");
                createSeatMatrix(amityGwaliorCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(amityGwaliorCSE, "2026-27", new BigDecimal("350000"), new BigDecimal("100000"),
                                new BigDecimal("25000"), new BigDecimal("15000"), new BigDecimal("20000"),
                                new BigDecimal("20000"),
                                new BigDecimal("530000"), "PER_YEAR");

                Course amityGwaliorMBA = createCourse(amityGwalior, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT with graduation");
                createSeatMatrix(amityGwaliorMBA, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(amityGwaliorMBA, "2026-27", new BigDecimal("380000"), new BigDecimal("90000"),
                                new BigDecimal("20000"), new BigDecimal("12000"), new BigDecimal("0"),
                                new BigDecimal("25000"),
                                new BigDecimal("527000"), "PER_YEAR");

                // 7. Laxmibai National Institute of Physical Education (LNIPE)
                College lnipe = createCollege(
                                "Laxmibai National Institute of Physical Education (LNIPE)",
                                "LNIPE is India's premier sports university, named after Rani Laxmibai. Offers sports science and PE programs.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Shaktinagar, Gwalior, MP 474002",
                                "474002",
                                "0751-2409500",
                                "info@lnipe.edu.in",
                                "https://www.lnipe.edu.in",
                                "A++",
                                true,
                                1957,
                                "Central University (Deemed)");

                Course lnipeBPEd = createCourse(lnipe, "B.P.Ed", "Physical Education", "UG", 4,
                                "Bachelor of Physical Education", "12th pass + Physical fitness test");
                createSeatMatrix(lnipeBPEd, "GENERAL", 120, 20, "2026-27");
                createFeeStructure(lnipeBPEd, "2026-27", new BigDecimal("35000"), new BigDecimal("25000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("73000"), "PER_YEAR");

                Course lnipeMPEd = createCourse(lnipe, "M.P.Ed", "Physical Education", "PG", 2,
                                "Master of Physical Education", "B.P.Ed / B.Sc PE");
                createSeatMatrix(lnipeMPEd, "GENERAL", 80, 15, "2026-27");
                createFeeStructure(lnipeMPEd, "2026-27", new BigDecimal("40000"), new BigDecimal("25000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("80000"), "PER_YEAR");

                // 8. RKDF College Gwalior
                College rkdfGwalior = createCollege(
                                "RKDF College of Engineering Gwalior",
                                "RKDF Gwalior offers quality engineering education with good infrastructure and placements.",
                                "PRIVATE",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Jhansi Road, Gwalior, MP 474001",
                                "474001",
                                "0751-2429500",
                                "info@rkdfgwalior.in",
                                "https://www.rkdfgwalior.in",
                                "B++",
                                true,
                                2009,
                                "RGPV");

                Course rkdfGwaliorCSE = createCourse(rkdfGwalior, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(rkdfGwaliorCSE, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(rkdfGwaliorCSE, "2026-27", new BigDecimal("72000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("132000"), "PER_YEAR");

                System.out.println("✅ Gwalior: 8 colleges added");
        }

        // ==================== JABALPUR COLLEGES ====================
        private void seedJabalpurColleges() {
                System.out.println("📍 Seeding Jabalpur Colleges...");

                // 1. RDVV (Rani Durgavati Vishwavidyalaya)
                College rdvv = createCollege(
                                "Rani Durgavati Vishwavidyalaya (RDVV)",
                                "RDVV is a major state university in Jabalpur, named after Rani Durgavati. Offers diverse academic programs.",
                                "GOVERNMENT",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Saraswati Vihar, Pachpedi, Jabalpur, MP 482001",
                                "482001",
                                "0761-2600567",
                                "registrar@rdunijbpin.org",
                                "https://www.rdunijbpin.org",
                                "A",
                                true,
                                1956,
                                "State University");

                Course rdvvBA = createCourse(rdvv, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(rdvvBA, "GENERAL", 500, 120, "2026-27");
                createFeeStructure(rdvvBA, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("0"),
                                new BigDecimal("1500"),
                                new BigDecimal("7500"), "PER_YEAR");

                Course rdvvBSc = createCourse(rdvv, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(rdvvBSc, "GENERAL", 450, 110, "2026-27");
                createFeeStructure(rdvvBSc, "2026-27", new BigDecimal("7500"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("2000"),
                                new BigDecimal("13000"), "PER_YEAR");

                Course rdvvMBA = createCourse(rdvv, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "Graduation with 50%");
                createSeatMatrix(rdvvMBA, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(rdvvMBA, "2026-27", new BigDecimal("38000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("46000"), "PER_YEAR");

                // 2. JNKVV (Jawaharlal Nehru Krishi Vishwa Vidyalaya)
                College jnkvv = createCollege(
                                "Jawaharlal Nehru Krishi Vishwa Vidyalaya (JNKVV)",
                                "JNKVV is a premier agricultural university in MP, offering excellent programs in agriculture and allied sciences.",
                                "GOVERNMENT",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Krishinagar, Jabalpur, MP 482004",
                                "482004",
                                "0761-2681706",
                                "registrar@jnkvv.org",
                                "https://www.jnkvv.org",
                                "A+",
                                true,
                                1964,
                                "State Agricultural University");

                Course jnkvvBSc = createCourse(jnkvv, "B.Sc", "Agriculture", "UG", 4,
                                "Bachelor of Science in Agriculture", "12th with PCB/Agriculture");
                createSeatMatrix(jnkvvBSc, "GENERAL", 200, 40, "2026-27");
                createSeatMatrix(jnkvvBSc, "OBC", 100, 20, "2026-27");
                createFeeStructure(jnkvvBSc, "2026-27", new BigDecimal("25000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("53000"), "PER_YEAR");

                Course jnkvvBtech = createCourse(jnkvv, "B.Tech", "Agricultural Engineering", "UG", 4,
                                "B.Tech in Agricultural Engineering", "12th with PCM");
                createSeatMatrix(jnkvvBtech, "GENERAL", 60, 12, "2026-27");
                createFeeStructure(jnkvvBtech, "2026-27", new BigDecimal("35000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("64000"), "PER_YEAR");

                Course jnkvvMSc = createCourse(jnkvv, "M.Sc", "Agriculture", "PG", 2,
                                "Master of Science in Agriculture", "B.Sc Agriculture");
                createSeatMatrix(jnkvvMSc, "GENERAL", 100, 25, "2026-27");
                createFeeStructure(jnkvvMSc, "2026-27", new BigDecimal("30000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("58000"), "PER_YEAR");

                // 3. GEC Jabalpur (Government Engineering College)
                College gecJabalpur = createCollege(
                                "Government Engineering College Jabalpur (GECJ)",
                                "GEC Jabalpur is one of the oldest government engineering colleges in MP, established in 1947.",
                                "GOVERNMENT",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Shastri Bridge, Jabalpur, MP 482011",
                                "482011",
                                "0761-2620728",
                                "principal@gecjabalpur.ac.in",
                                "https://www.gecjabalpur.ac.in",
                                "A",
                                true,
                                1947,
                                "RGPV");

                Course gecJabalpurCSE = createCourse(gecJabalpur, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecJabalpurCSE, "GENERAL", 60, 12, "2026-27");
                createSeatMatrix(gecJabalpurCSE, "OBC", 35, 7, "2026-27");
                createFeeStructure(gecJabalpurCSE, "2026-27", new BigDecimal("75000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("107000"), "PER_YEAR");
                createCutoff(gecJabalpurCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), 75000,
                                "JEE Main");

                Course gecJabalpurME = createCourse(gecJabalpur, "B.Tech", "Mechanical Engineering", "UG", 4,
                                "Bachelor of Technology in ME", "JEE Main qualified");
                createSeatMatrix(gecJabalpurME, "GENERAL", 60, 15, "2026-27");
                createFeeStructure(gecJabalpurME, "2026-27", new BigDecimal("75000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("107000"), "PER_YEAR");

                // 4. NSMC Jabalpur (Netaji Subhash Chandra Bose Medical College)
                College nscmc = createCollege(
                                "Netaji Subhash Chandra Bose Medical College (NSCMC) Jabalpur",
                                "NSCMC is a government medical college in Jabalpur, offering quality medical education.",
                                "GOVERNMENT",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Garha, Jabalpur, MP 482003",
                                "482003",
                                "0761-2650021",
                                "principal@nscmcjabalpur.mp.gov.in",
                                "https://www.nscmcjabalpur.ac.in",
                                "A",
                                true,
                                1955,
                                "MPMC");

                Course nscmcMBBS = createCourse(nscmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(nscmcMBBS, "GENERAL", 150, 20, "2026-27");
                createSeatMatrix(nscmcMBBS, "OBC", 80, 12, "2026-27");
                createFeeStructure(nscmcMBBS, "2026-27", new BigDecimal("28000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("58000"), "PER_YEAR");
                createCutoff(nscmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.0"), 18000, "NEET UG");

                // 5. Hitkarini College of Engineering & Technology
                College hitkarini = createCollege(
                                "Hitkarini College of Engineering and Technology (HCET)",
                                "Hitkarini is a leading private engineering college in Jabalpur with good placements.",
                                "PRIVATE",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Dumna Airport Road, Jabalpur, MP 482005",
                                "482005",
                                "0761-2670567",
                                "info@hfrtet.ac.in",
                                "https://www.hfrtet.ac.in",
                                "A",
                                true,
                                1997,
                                "RGPV");

                Course hitkariniCSE = createCourse(hitkarini, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / 12th with 45% in PCM");
                createSeatMatrix(hitkariniCSE, "GENERAL", 120, 35, "2026-27");
                createFeeStructure(hitkariniCSE, "2026-27", new BigDecimal("85000"), new BigDecimal("40000"),
                                new BigDecimal("12000"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("8000"),
                                new BigDecimal("157000"), "PER_YEAR");

                Course hitkariniMBA = createCourse(hitkarini, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "CAT/MAT with graduation");
                createSeatMatrix(hitkariniMBA, "GENERAL", 90, 25, "2026-27");
                createFeeStructure(hitkariniMBA, "2026-27", new BigDecimal("95000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("8000"),
                                new BigDecimal("153000"), "PER_YEAR");

                // 6. Gyan Ganga College Jabalpur
                College gyanGanga = createCollege(
                                "Gyan Ganga Institute of Technology and Sciences",
                                "Gyan Ganga offers engineering and management programs with modern facilities.",
                                "PRIVATE",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Bargi Hills, Jabalpur, MP 482003",
                                "482003",
                                "0761-2680400",
                                "info@ggits.org",
                                "https://www.ggits.org",
                                "B++",
                                true,
                                2002,
                                "RGPV");

                Course gyanGangaCSE = createCourse(gyanGanga, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(gyanGangaCSE, "GENERAL", 120, 40, "2026-27");
                createFeeStructure(gyanGangaCSE, "2026-27", new BigDecimal("72000"), new BigDecimal("35000"),
                                new BigDecimal("10000"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("6000"),
                                new BigDecimal("132000"), "PER_YEAR");

                // 7. St. Aloysius College (Autonomous)
                College stAloysius = createCollege(
                                "St. Aloysius College (Autonomous) Jabalpur",
                                "St. Aloysius is one of the oldest and most reputed colleges in MP, known for quality education.",
                                "PRIVATE",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Sadar, Jabalpur, MP 482001",
                                "482001",
                                "0761-2624736",
                                "principal@staloysiuscollege.ac.in",
                                "https://www.staloysiuscollege.ac.in",
                                "A+",
                                true,
                                1951,
                                "RDVV (Autonomous)");

                Course stAloBA = createCourse(stAloysius, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(stAloBA, "GENERAL", 300, 80, "2026-27");
                createFeeStructure(stAloBA, "2026-27", new BigDecimal("12000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("17000"), "PER_YEAR");

                Course stAloBSc = createCourse(stAloysius, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(stAloBSc, "GENERAL", 250, 60, "2026-27");
                createFeeStructure(stAloBSc, "2026-27", new BigDecimal("15000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("2500"), new BigDecimal("3000"),
                                new BigDecimal("3500"),
                                new BigDecimal("24000"), "PER_YEAR");

                Course stAloBCom = createCourse(stAloysius, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th with Commerce");
                createSeatMatrix(stAloBCom, "GENERAL", 200, 50, "2026-27");
                createFeeStructure(stAloBCom, "2026-27", new BigDecimal("13000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("1000"),
                                new BigDecimal("3000"),
                                new BigDecimal("19000"), "PER_YEAR");

                System.out.println("✅ Jabalpur: 7 colleges added");
        }

        // ==================== UJJAIN COLLEGES ====================
        private void seedUjjainColleges() {
                System.out.println("📍 Seeding Ujjain Colleges...");

                // 1. Vikram University
                College vikram = createCollege(
                                "Vikram University Ujjain",
                                "Vikram University is a major state university in Ujjain, named after legendary king Vikramaditya.",
                                "GOVERNMENT",
                                "Ujjain",
                                "Madhya Pradesh",
                                "University Road, Ujjain, MP 456010",
                                "456010",
                                "0734-2514276",
                                "registrar@vikramuniv.net",
                                "https://www.vikramuniv.net",
                                "A",
                                true,
                                1957,
                                "State University");

                Course vikramBA = createCourse(vikram, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(vikramBA, "GENERAL", 500, 120, "2026-27");
                createFeeStructure(vikramBA, "2026-27", new BigDecimal("4500"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("900"), new BigDecimal("0"), new BigDecimal("1400"),
                                new BigDecimal("6800"), "PER_YEAR");

                Course vikramBSc = createCourse(vikram, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(vikramBSc, "GENERAL", 400, 100, "2026-27");
                createFeeStructure(vikramBSc, "2026-27", new BigDecimal("7000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1400"), new BigDecimal("1800"),
                                new BigDecimal("1800"),
                                new BigDecimal("12000"), "PER_YEAR");

                Course vikramMBA = createCourse(vikram, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "Graduation with 50%");
                createSeatMatrix(vikramMBA, "GENERAL", 120, 30, "2026-27");
                createFeeStructure(vikramMBA, "2026-27", new BigDecimal("35000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("4500"),
                                new BigDecimal("42500"), "PER_YEAR");

                // 2. Mahakal Institute of Technology
                College mahakal = createCollege(
                                "Mahakal Institute of Technology (MIT Ujjain)",
                                "MIT Ujjain offers engineering and management programs with good infrastructure.",
                                "PRIVATE",
                                "Ujjain",
                                "Madhya Pradesh",
                                "Datana, Ujjain-Dewas Highway, Ujjain, MP 456664",
                                "456664",
                                "0734-2540100",
                                "info@mitujjain.ac.in",
                                "https://www.mitujjain.ac.in",
                                "B++",
                                true,
                                2001,
                                "RGPV");

                Course mahakalCSE = createCourse(mahakal, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "12th with 45% in PCM");
                createSeatMatrix(mahakalCSE, "GENERAL", 90, 30, "2026-27");
                createFeeStructure(mahakalCSE, "2026-27", new BigDecimal("65000"), new BigDecimal("32000"),
                                new BigDecimal("8000"), new BigDecimal("3500"), new BigDecimal("5000"),
                                new BigDecimal("5500"),
                                new BigDecimal("119000"), "PER_YEAR");

                // 3. RD Gardi Medical College
                College rdGardi = createCollege(
                                "RD Gardi Medical College Ujjain",
                                "RD Gardi Medical College is a private medical college with attached hospital.",
                                "PRIVATE",
                                "Ujjain",
                                "Madhya Pradesh",
                                "Agar Road, Ujjain, MP 456006",
                                "456006",
                                "0734-2540200",
                                "principal@rdgmc.edu.in",
                                "https://www.rdgmc.edu.in",
                                "A",
                                true,
                                1997,
                                "MPMC");

                Course rdGardiMBBS = createCourse(rdGardi, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(rdGardiMBBS, "GENERAL", 100, 15, "2026-27");
                createFeeStructure(rdGardiMBBS, "2026-27", new BigDecimal("950000"), new BigDecimal("60000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("15000"),
                                new BigDecimal("20000"),
                                new BigDecimal("1055000"), "PER_YEAR");

                System.out.println("✅ Ujjain: 3 colleges added");
        }

        // ==================== REWA COLLEGES ====================
        private void seedRewaColleges() {
                System.out.println("📍 Seeding Rewa Colleges...");

                // 1. APS University
                College apsRewa = createCollege(
                                "Awadhesh Pratap Singh University (APSU) Rewa",
                                "APSU is the major state university in Rewa region, offering diverse academic programs.",
                                "GOVERNMENT",
                                "Rewa",
                                "Madhya Pradesh",
                                "University Road, Rewa, MP 486003",
                                "486003",
                                "07662-222200",
                                "registrar@apsurewa.ac.in",
                                "https://www.apsurewa.ac.in",
                                "A",
                                true,
                                1968,
                                "State University");

                Course apsBA = createCourse(apsRewa, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(apsBA, "GENERAL", 400, 100, "2026-27");
                createFeeStructure(apsBA, "2026-27", new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("800"), new BigDecimal("0"), new BigDecimal("1200"),
                                new BigDecimal("6000"), "PER_YEAR");

                Course apsBSc = createCourse(apsRewa, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(apsBSc, "GENERAL", 350, 90, "2026-27");
                createFeeStructure(apsBSc, "2026-27", new BigDecimal("6500"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1200"), new BigDecimal("1600"),
                                new BigDecimal("1700"),
                                new BigDecimal("11000"), "PER_YEAR");

                // 2. GEC Rewa
                College gecRewa = createCollege(
                                "Government Engineering College Rewa",
                                "GEC Rewa is a government engineering college offering quality technical education.",
                                "GOVERNMENT",
                                "Rewa",
                                "Madhya Pradesh",
                                "Vindhyanagar, Rewa, MP 486001",
                                "486001",
                                "07662-230800",
                                "principal@gecrewa.ac.in",
                                "https://www.gecrewa.ac.in",
                                "B++",
                                true,
                                1997,
                                "RGPV");

                Course gecRewaCSE = createCourse(gecRewa, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecRewaCSE, "GENERAL", 60, 15, "2026-27");
                createFeeStructure(gecRewaCSE, "2026-27", new BigDecimal("65000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("94000"), "PER_YEAR");
                createCutoff(gecRewaCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), 120000, "JEE Main");

                // 3. SS Medical College Rewa
                College ssMedical = createCollege(
                                "Shyam Shah Medical College Rewa",
                                "SS Medical College is a government medical college in Rewa with attached hospital.",
                                "GOVERNMENT",
                                "Rewa",
                                "Madhya Pradesh",
                                "Medical College Road, Rewa, MP 486001",
                                "486001",
                                "07662-222266",
                                "principal@ssmcrewa.mp.gov.in",
                                "https://www.ssmcrewa.ac.in",
                                "A",
                                true,
                                1963,
                                "MPMC");

                Course ssMBBS = createCourse(ssMedical, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(ssMBBS, "GENERAL", 100, 15, "2026-27");
                createSeatMatrix(ssMBBS, "OBC", 55, 8, "2026-27");
                createFeeStructure(ssMBBS, "2026-27", new BigDecimal("25000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("51000"), "PER_YEAR");
                createCutoff(ssMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.0"), 25000, "NEET UG");

                System.out.println("✅ Rewa: 3 colleges added");
        }

        // ==================== SAGAR COLLEGES ====================
        private void seedSagarColleges() {
                System.out.println("📍 Seeding Sagar Colleges...");

                // 1. Dr. HS Gour University
                College hsGour = createCollege(
                                "Dr. Harisingh Gour Vishwavidyalaya (Central University)",
                                "Dr. HS Gour University is a central university in Sagar, known for excellence in research and academics.",
                                "GOVERNMENT",
                                "Sagar",
                                "Madhya Pradesh",
                                "Sagar, MP 470003",
                                "470003",
                                "07582-264001",
                                "registrar@dhsgsu.ac.in",
                                "https://www.dhsgsu.ac.in",
                                "A+",
                                true,
                                1946,
                                "Central University");

                Course hsGourBA = createCourse(hsGour, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(hsGourBA, "GENERAL", 400, 80, "2026-27");
                createFeeStructure(hsGourBA, "2026-27", new BigDecimal("8000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("0"),
                                new BigDecimal("2000"),
                                new BigDecimal("11500"), "PER_YEAR");

                Course hsGourBSc = createCourse(hsGour, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(hsGourBSc, "GENERAL", 350, 70, "2026-27");
                createFeeStructure(hsGourBSc, "2026-27", new BigDecimal("12000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("2500"),
                                new BigDecimal("2500"),
                                new BigDecimal("19000"), "PER_YEAR");

                Course hsGourBtech = createCourse(hsGour, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main / CUET");
                createSeatMatrix(hsGourBtech, "GENERAL", 60, 12, "2026-27");
                createFeeStructure(hsGourBtech, "2026-27", new BigDecimal("45000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("78000"), "PER_YEAR");

                Course hsGourLLB = createCourse(hsGour, "LLB", "Law", "UG", 3,
                                "Bachelor of Laws", "Graduation");
                createSeatMatrix(hsGourLLB, "GENERAL", 100, 20, "2026-27");
                createFeeStructure(hsGourLLB, "2026-27", new BigDecimal("15000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("0"),
                                new BigDecimal("3000"),
                                new BigDecimal("20000"), "PER_YEAR");

                Course hsGourMBA = createCourse(hsGour, "MBA", "Management", "PG", 2,
                                "Master of Business Administration", "Graduation with CUET");
                createSeatMatrix(hsGourMBA, "GENERAL", 80, 20, "2026-27");
                createFeeStructure(hsGourMBA, "2026-27", new BigDecimal("50000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("0"),
                                new BigDecimal("5000"),
                                new BigDecimal("78000"), "PER_YEAR");

                // 2. Bundelkhand Medical College
                College bundelkhandMedical = createCollege(
                                "Bundelkhand Medical College Sagar",
                                "BMC is a government medical college in Sagar district offering MBBS program.",
                                "GOVERNMENT",
                                "Sagar",
                                "Madhya Pradesh",
                                "Medical College Road, Sagar, MP 470001",
                                "470001",
                                "07582-262200",
                                "principal@bmcsagar.mp.gov.in",
                                "https://www.bmcsagar.ac.in",
                                "B++",
                                true,
                                1968,
                                "MPMC");

                Course bundelMBBS = createCourse(bundelkhandMedical, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery", "NEET UG qualified");
                createSeatMatrix(bundelMBBS, "GENERAL", 100, 15, "2026-27");
                createFeeStructure(bundelMBBS, "2026-27", new BigDecimal("25000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("51000"), "PER_YEAR");
                createCutoff(bundelMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("95.5"), 30000, "NEET UG");

                System.out.println("✅ Sagar: 2 colleges added");
        }

        // ==================== OTHER CITIES COLLEGES ====================
        private void seedOtherCitiesColleges() {
                System.out.println("📍 Seeding Other MP Cities Colleges...");

                // SATNA
                College gecSatna = createCollege(
                                "Government Engineering College Satna",
                                "GEC Satna offers quality engineering education in the Satna district.",
                                "GOVERNMENT",
                                "Satna",
                                "Madhya Pradesh",
                                "NH-7, Satna, MP 485001",
                                "485001",
                                "07672-222300",
                                "principal@gecsatna.ac.in",
                                "https://www.gecsatna.ac.in",
                                "B+",
                                true,
                                2008,
                                "RGPV");

                Course gecSatnaCSE = createCourse(gecSatna, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecSatnaCSE, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(gecSatnaCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("89000"), "PER_YEAR");

                // CHHINDWARA - GEC
                College gecChhindwara = createCollege(
                                "Government Engineering College Chhindwara",
                                "GEC Chhindwara is a government engineering college serving the tribal district.",
                                "GOVERNMENT",
                                "Chhindwara",
                                "Madhya Pradesh",
                                "Parasia Road, Chhindwara, MP 480001",
                                "480001",
                                "07162-248200",
                                "principal@gecchhindwara.ac.in",
                                "https://www.gecchhindwara.ac.in",
                                "B+",
                                true,
                                2000,
                                "RGPV");

                Course gecChhindwaraCSE = createCourse(gecChhindwara, "B.Tech", "Computer Science and Engineering",
                                "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecChhindwaraCSE, "GENERAL", 60, 18, "2026-27");
                createFeeStructure(gecChhindwaraCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("89000"), "PER_YEAR");

                // RATLAM
                College vikramRatlam = createCollege(
                                "Vikram University Institute of Engineering Ratlam",
                                "Engineering institute under Vikram University offering technical programs.",
                                "GOVERNMENT",
                                "Ratlam",
                                "Madhya Pradesh",
                                "Ujjain Road, Ratlam, MP 457001",
                                "457001",
                                "07412-262200",
                                "principal@vueratlam.ac.in",
                                "https://www.vueratlam.ac.in",
                                "B+",
                                true,
                                2005,
                                "Vikram University");

                Course vuRatlamCSE = createCourse(vikramRatlam, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(vuRatlamCSE, "GENERAL", 60, 20, "2026-27");
                createFeeStructure(vuRatlamCSE, "2026-27", new BigDecimal("55000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("84000"), "PER_YEAR");

                // DEWAS - GEC
                College gecDewas = createCollege(
                                "Government Engineering College Dewas",
                                "GEC Dewas offers quality engineering education in Dewas district.",
                                "GOVERNMENT",
                                "Dewas",
                                "Madhya Pradesh",
                                "AB Road, Dewas, MP 455001",
                                "455001",
                                "07272-252300",
                                "principal@gecdewas.ac.in",
                                "https://www.gecdewas.ac.in",
                                "B+",
                                true,
                                2008,
                                "RGPV");

                Course gecDewasCSE = createCourse(gecDewas, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecDewasCSE, "GENERAL", 60, 18, "2026-27");
                createFeeStructure(gecDewasCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("89000"), "PER_YEAR");

                // KHANDWA
                College gecKhandwa = createCollege(
                                "Government Engineering College Khandwa",
                                "GEC Khandwa serves the East Nimar region with quality technical education.",
                                "GOVERNMENT",
                                "Khandwa",
                                "Madhya Pradesh",
                                "Betul Road, Khandwa, MP 450001",
                                "450001",
                                "0733-2224100",
                                "principal@geckhandwa.ac.in",
                                "https://www.geckhandwa.ac.in",
                                "B",
                                true,
                                2010,
                                "RGPV");

                Course gecKhandwaCSE = createCourse(gecKhandwa, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecKhandwaCSE, "GENERAL", 60, 22, "2026-27");
                createFeeStructure(gecKhandwaCSE, "2026-27", new BigDecimal("55000"), new BigDecimal("16000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("82000"), "PER_YEAR");

                // VIDISHA
                College gecVidisha = createCollege(
                                "Government Engineering College Vidisha",
                                "GEC Vidisha offers engineering education near the historical city of Vidisha.",
                                "GOVERNMENT",
                                "Vidisha",
                                "Madhya Pradesh",
                                "Ganjbasoda Road, Vidisha, MP 464001",
                                "464001",
                                "07592-232400",
                                "principal@gecvidisha.ac.in",
                                "https://www.gecvidisha.ac.in",
                                "B+",
                                true,
                                1999,
                                "RGPV");

                Course gecVidishaCSE = createCourse(gecVidisha, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecVidishaCSE, "GENERAL", 60, 18, "2026-27");
                createFeeStructure(gecVidishaCSE, "2026-27", new BigDecimal("60000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("89000"), "PER_YEAR");

                // BURHANPUR
                College burhanpur = createCollege(
                                "Government Degree College Burhanpur",
                                "Government college in historical Burhanpur city offering arts and science programs.",
                                "GOVERNMENT",
                                "Burhanpur",
                                "Madhya Pradesh",
                                "College Road, Burhanpur, MP 450331",
                                "450331",
                                "07325-252100",
                                "principal@gdcburhanpur.ac.in",
                                "https://www.gdcburhanpur.ac.in",
                                "B",
                                true,
                                1965,
                                "DAVV");

                Course burhanpurBA = createCourse(burhanpur, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(burhanpurBA, "GENERAL", 200, 60, "2026-27");
                createFeeStructure(burhanpurBA, "2026-27", new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("800"), new BigDecimal("0"), new BigDecimal("1200"),
                                new BigDecimal("6000"), "PER_YEAR");

                // SHAHDOL - GEC
                College gecShahdol = createCollege(
                                "Government Engineering College Shahdol",
                                "GEC Shahdol serves the tribal region with quality engineering education.",
                                "GOVERNMENT",
                                "Shahdol",
                                "Madhya Pradesh",
                                "Amarkantak Road, Shahdol, MP 484001",
                                "484001",
                                "07652-242200",
                                "principal@gecshahdol.ac.in",
                                "https://www.gecshahdol.ac.in",
                                "B",
                                true,
                                2012,
                                "RGPV");

                Course gecShahdolCSE = createCourse(gecShahdol, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecShahdolCSE, "GENERAL", 60, 25, "2026-27");
                createFeeStructure(gecShahdolCSE, "2026-27", new BigDecimal("55000"), new BigDecimal("16000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("82000"), "PER_YEAR");

                // HOSHANGABAD (NARMADAPURAM)
                College hoshangabad = createCollege(
                                "Government Narmada PG College Hoshangabad",
                                "Premier government college in Narmadapuram (Hoshangabad) district.",
                                "GOVERNMENT",
                                "Hoshangabad",
                                "Madhya Pradesh",
                                "College Road, Hoshangabad, MP 461001",
                                "461001",
                                "07574-252200",
                                "principal@gnpgc.ac.in",
                                "https://www.gnpgc.ac.in",
                                "B++",
                                true,
                                1958,
                                "Barkatullah University");

                Course hoshangabadBA = createCourse(hoshangabad, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(hoshangabadBA, "GENERAL", 250, 70, "2026-27");
                createFeeStructure(hoshangabadBA, "2026-27", new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("800"), new BigDecimal("0"), new BigDecimal("1200"),
                                new BigDecimal("6000"), "PER_YEAR");

                Course hoshangabadBSc = createCourse(hoshangabad, "B.Sc", "Science", "UG", 3,
                                "Bachelor of Science", "12th with Science");
                createSeatMatrix(hoshangabadBSc, "GENERAL", 200, 50, "2026-27");
                createFeeStructure(hoshangabadBSc, "2026-27", new BigDecimal("6000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1200"), new BigDecimal("1500"),
                                new BigDecimal("1500"),
                                new BigDecimal("10200"), "PER_YEAR");

                // SHIVPURI - GEC
                College gecShivpuri = createCollege(
                                "Government Engineering College Shivpuri",
                                "GEC Shivpuri offers engineering programs in the Gwalior-Chambal region.",
                                "GOVERNMENT",
                                "Shivpuri",
                                "Madhya Pradesh",
                                "Pohri Road, Shivpuri, MP 473551",
                                "473551",
                                "07492-232300",
                                "principal@gecshivpuri.ac.in",
                                "https://www.gecshivpuri.ac.in",
                                "B",
                                true,
                                2010,
                                "RGPV");

                Course gecShivpuriCSE = createCourse(gecShivpuri, "B.Tech", "Computer Science and Engineering", "UG", 4,
                                "Bachelor of Technology in CSE", "JEE Main qualified");
                createSeatMatrix(gecShivpuriCSE, "GENERAL", 60, 22, "2026-27");
                createFeeStructure(gecShivpuriCSE, "2026-27", new BigDecimal("55000"), new BigDecimal("16000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("4000"),
                                new BigDecimal("4000"),
                                new BigDecimal("82000"), "PER_YEAR");

                // DAMOH
                College damoh = createCollege(
                                "Government PG College Damoh",
                                "Government college in Damoh district offering arts and science programs.",
                                "GOVERNMENT",
                                "Damoh",
                                "Madhya Pradesh",
                                "College Road, Damoh, MP 470661",
                                "470661",
                                "07812-222200",
                                "principal@pgcdamoh.ac.in",
                                "https://www.pgcdamoh.ac.in",
                                "B",
                                true,
                                1960,
                                "RDVV");

                Course damohBA = createCourse(damoh, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(damohBA, "GENERAL", 200, 60, "2026-27");
                createFeeStructure(damohBA, "2026-27", new BigDecimal("4000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("800"), new BigDecimal("0"), new BigDecimal("1200"),
                                new BigDecimal("6000"), "PER_YEAR");

                // MANDSAUR
                College mandsaur = createCollege(
                                "Vikram University PG College Mandsaur",
                                "College under Vikram University serving Mandsaur district.",
                                "GOVERNMENT",
                                "Mandsaur",
                                "Madhya Pradesh",
                                "University Road, Mandsaur, MP 458001",
                                "458001",
                                "07422-252300",
                                "principal@vupgcmandsaur.ac.in",
                                "https://www.vupgcmandsaur.ac.in",
                                "B+",
                                true,
                                1962,
                                "Vikram University");

                Course mandsaurBA = createCourse(mandsaur, "B.A.", "Arts", "UG", 3,
                                "Bachelor of Arts", "12th pass");
                createSeatMatrix(mandsaurBA, "GENERAL", 250, 70, "2026-27");
                createFeeStructure(mandsaurBA, "2026-27", new BigDecimal("4500"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("900"), new BigDecimal("0"), new BigDecimal("1400"),
                                new BigDecimal("6800"), "PER_YEAR");

                Course mandsaurBCom = createCourse(mandsaur, "B.Com", "Commerce", "UG", 3,
                                "Bachelor of Commerce", "12th with Commerce");
                createSeatMatrix(mandsaurBCom, "GENERAL", 180, 45, "2026-27");
                createFeeStructure(mandsaurBCom, "2026-27", new BigDecimal("5000"), new BigDecimal("0"),
                                new BigDecimal("0"), new BigDecimal("1000"), new BigDecimal("500"),
                                new BigDecimal("1500"),
                                new BigDecimal("8000"), "PER_YEAR");

                System.out.println("✅ Other Cities: 12 colleges added");
        }

        // ==================== HELPER METHODS ====================
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

                // ===== COLLEGE-SPECIFIC PHOTOS (verified from Wikimedia Commons) =====
                map.put("Indian Institute of Technology Indore (IIT Indore)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Health_Centre_IIT_Indore.jpg/800px-Health_Centre_IIT_Indore.jpg");
                map.put("Indian Institute of Management Indore (IIM Indore)",
                                "https://upload.wikimedia.org/wikipedia/commons/e/ec/Academic_block%2C_IIM_Indore.jpg");
                map.put("Shri Govindram Seksaria Institute of Technology and Science (SGSITS)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Sgsits.jpg/800px-Sgsits.jpg");
                map.put("Mahatma Gandhi Memorial Medical College (MGM)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/King_Edward_Medical_School%2C_indore.jpg/800px-King_Edward_Medical_School%2C_indore.jpg");
                map.put("Medicaps University",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Main_block1.jpg/800px-Main_block1.jpg");
                map.put("IPS Academy Indore",
                                "https://upload.wikimedia.org/wikipedia/commons/a/a7/IPS_Academy_main_building.JPG");
                map.put("ABV Indian Institute of Information Technology and Management (IIITM) Gwalior",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/IIITM_panoramic_view.jpg/800px-IIITM_panoramic_view.jpg");
                map.put("Madhav Institute of Technology and Science (MITS) Gwalior",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Madhav_Institute_of_Technology_and_Science.jpg/800px-Madhav_Institute_of_Technology_and_Science.jpg");
                map.put("Jiwaji University",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Jiwaji_University_Main_Gate_Entrance_Gwalior_-_panoramio.jpg/800px-Jiwaji_University_Main_Gate_Entrance_Gwalior_-_panoramio.jpg");
                map.put("Gajra Raja Medical College (GRMC) Gwalior",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/GAJARA_RAJA_MEDICAL_COLLEGE%2C_GWALIOR_-_panoramio.jpg/800px-GAJARA_RAJA_MEDICAL_COLLEGE%2C_GWALIOR_-_panoramio.jpg");
                map.put("Laxmibai National Institute of Physical Education (LNIPE)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/LAXMI_BAI_NATIONAL_UNIVERSITY_OF_PHYSICAL_EDUCATION_GWALIOR_-_panoramio.jpg/800px-LAXMI_BAI_NATIONAL_UNIVERSITY_OF_PHYSICAL_EDUCATION_GWALIOR_-_panoramio.jpg");
                map.put("Rani Durgavati Vishwavidyalaya (RDVV)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cemented_path_covered_with_mid-size_trees.jpg/800px-Cemented_path_covered_with_mid-size_trees.jpg");
                map.put("Jawaharlal Nehru Krishi Vishwa Vidyalaya (JNKVV)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Jawaharlal_Nehru_krishi_Vishwa_vidyalaya_Jabalpur.jpg/800px-Jawaharlal_Nehru_krishi_Vishwa_vidyalaya_Jabalpur.jpg");
                map.put("St. Aloysius College (Autonomous) Jabalpur",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/St._Aloysius_Institute_of_Technology%2C_Jabalpur.jpg/800px-St._Aloysius_Institute_of_Technology%2C_Jabalpur.jpg");
                map.put("Vikram University Ujjain",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Swarnagate.jpg/800px-Swarnagate.jpg");
                map.put("RD Gardi Medical College Ujjain",
                                "https://upload.wikimedia.org/wikipedia/commons/2/2e/Rdgmc.jpg");
                map.put("Dr. Harisingh Gour Vishwavidyalaya (Central University)",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Entry_gate_of_sagar_university.jpg/800px-Entry_gate_of_sagar_university.jpg");

                // ===== CITY LANDMARK PHOTOS (real Wikimedia images for remaining colleges)
                // =====
                String indoreRajwada = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Indore_Rajwada01.jpg/800px-Indore_Rajwada01.jpg";
                String gwaliorFort = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Gwalior_Fort_front.jpg/800px-Gwalior_Fort_front.jpg";
                String jabalpurTemple = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/0010322_Chausath_Yogini_Temple_and_Gowri_Shankar_Temple%2C_Bhedaghat_Madhya_Pradesh_054.jpg/800px-0010322_Chausath_Yogini_Temple_and_Gowri_Shankar_Temple%2C_Bhedaghat_Madhya_Pradesh_054.jpg";
                String ujjainTemple = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Mahakaleshwar_Temple%2C_Ujjain.jpg/800px-Mahakaleshwar_Temple%2C_Ujjain.jpg";
                String rewaPalace = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Vyankat_Bhawan.jpg/800px-Vyankat_Bhawan.jpg";
                String sagarLake = "https://upload.wikimedia.org/wikipedia/commons/4/47/Lakha_Banjara_Lake_Sagar.png";
                String satna = "https://upload.wikimedia.org/wikipedia/commons/9/9f/Satna_MP_2.png";
                String chhindwara = "https://upload.wikimedia.org/wikipedia/commons/2/27/Badalbhoi_museum.png";
                String ratlam = "https://upload.wikimedia.org/wikipedia/commons/a/a2/Ratlam_junction_MP.png";
                String dewas = "https://upload.wikimedia.org/wikipedia/commons/7/75/Sayaji-Dwar%2C_Dewas_%28M.P.%29.jpg";
                String khandwa = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Kishore_Kumar_memorial_in_Khandwa.jpg/800px-Kishore_Kumar_memorial_in_Khandwa.jpg";
                String vidisha = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Samrat_ashok_technological_institute_vidisha_mp.jpg/800px-Samrat_ashok_technological_institute_vidisha_mp.jpg";
                String burhanpur = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Dargah-e-Hakimi_%28Burhanpur%29%2C_February_2015.jpg/800px-Dargah-e-Hakimi_%28Burhanpur%29%2C_February_2015.jpg";
                String shahdol = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/0101022_Virateshwar_temple%2C_Sohagpur%2C_Madhya_Pradesh_008.jpg/800px-0101022_Virateshwar_temple%2C_Sohagpur%2C_Madhya_Pradesh_008.jpg";
                String hoshangabad = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Sethanighataman.jpg/800px-Sethanighataman.jpg";
                String shivpuri = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Scindia_cenotaphs%2C_shivpuri.jpg/800px-Scindia_cenotaphs%2C_shivpuri.jpg";
                String damoh = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Kundalpur_lake.jpg/800px-Kundalpur_lake.jpg";
                String mandsaur = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/0111321_Pasupatinath_temple%2C_Mandsaur_Madhya_Pradesh_138.jpg/800px-0111321_Pasupatinath_temple%2C_Mandsaur_Madhya_Pradesh_138.jpg";

                // Indore colleges - Rajwada Palace landmark
                map.put("Devi Ahilya Vishwavidyalaya (DAVV)", indoreRajwada);
                map.put("Institute of Engineering and Technology (IET-DAVV)", indoreRajwada);
                map.put("Prestige Institute of Management and Research (PIMR)", indoreRajwada);
                map.put("Acropolis Institute of Technology and Research", indoreRajwada);
                map.put("Shri Vaishnav Vidyapeeth Vishwavidyalaya (SVVV)", indoreRajwada);
                map.put("Index Medical College Hospital and Research Centre", indoreRajwada);
                map.put("Malwa Institute of Technology (MIT Indore)", indoreRajwada);
                map.put("Chameli Devi Group of Institutions Indore", indoreRajwada);
                map.put("Sage University Indore", indoreRajwada);

                // Gwalior colleges - Gwalior Fort landmark
                map.put("ITM University Gwalior", gwaliorFort);
                map.put("Amity University Madhya Pradesh (Gwalior Campus)", gwaliorFort);
                map.put("RKDF College of Engineering Gwalior", gwaliorFort);

                // Jabalpur colleges - Chausath Yogini Temple landmark
                map.put("Government Engineering College Jabalpur (GECJ)", jabalpurTemple);
                map.put("Netaji Subhash Chandra Bose Medical College (NSCMC) Jabalpur", jabalpurTemple);
                map.put("Hitkarini College of Engineering and Technology (HCET)", jabalpurTemple);
                map.put("Gyan Ganga Institute of Technology and Sciences", jabalpurTemple);

                // Ujjain - Mahakaleshwar Temple landmark
                map.put("Mahakal Institute of Technology (MIT Ujjain)", ujjainTemple);

                // Rewa - Vyankat Bhawan landmark
                map.put("Awadhesh Pratap Singh University (APSU) Rewa", rewaPalace);
                map.put("Government Engineering College Rewa", rewaPalace);
                map.put("Shyam Shah Medical College Rewa", rewaPalace);

                // Sagar - Lakha Banjara Lake landmark
                map.put("Bundelkhand Medical College Sagar", sagarLake);

                // Other MP cities - respective city landmarks
                map.put("Government Engineering College Satna", satna);
                map.put("Government Engineering College Chhindwara", chhindwara);
                map.put("Vikram University Institute of Engineering Ratlam", ratlam);
                map.put("Government Engineering College Dewas", dewas);
                map.put("Government Engineering College Khandwa", khandwa);
                map.put("Government Engineering College Vidisha", vidisha);
                map.put("Government Degree College Burhanpur", burhanpur);
                map.put("Government Engineering College Shahdol", shahdol);
                map.put("Government Narmada PG College Hoshangabad", hoshangabad);
                map.put("Government Engineering College Shivpuri", shivpuri);
                map.put("Government PG College Damoh", damoh);
                map.put("Vikram University PG College Mandsaur", mandsaur);

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
