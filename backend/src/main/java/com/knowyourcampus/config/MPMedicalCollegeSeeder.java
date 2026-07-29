package com.knowyourcampus.config;

import com.knowyourcampus.entity.*;
import com.knowyourcampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class MPMedicalCollegeSeeder {

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

        public void seedAllMPMedicalColleges() {
                System.out.println("🏥 Seeding MP Medical Colleges (MBBS, BAMS, BHMS, BDS, BPT)...");

                seedGovernmentMBBSColleges();
                seedGovernmentAyurvedaColleges();
                seedGovernmentHomoeopathyColleges();
                seedGovernmentDentalColleges();
                seedPrivateMBBSColleges();
                seedPrivateAyurvedaColleges();
                seedPrivateHomoeopathyColleges();
                seedPrivateDentalColleges();
                seedPhysiotherapyColleges();

                System.out.println("✅ All MP Medical Colleges seeded successfully!");
        }

        // ==================== GOVERNMENT MBBS COLLEGES ====================
        private void seedGovernmentMBBSColleges() {
                System.out.println("📍 Seeding Government MBBS Colleges...");

                // 1. Netaji Subhash Chandra Bose Medical College, Jabalpur
                College nscbmc = createCollege(
                                "Netaji Subhash Chandra Bose Medical College (NSCBMC) Jabalpur",
                                "NSCBMC Jabalpur is one of the premier government medical colleges in MP, established in 1955. Attached to the 1200-bed Netaji Subhash Chandra Bose Hospital. Known for excellent clinical training and strong alumni network across India.",
                                "GOVERNMENT",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Garha Road, Jabalpur, MP 482003",
                                "482003",
                                "0761-2600655",
                                "nscbmcjbp@mp.gov.in",
                                "https://www.nscbmedicalcollege.mp.gov.in",
                                "A",
                                true,
                                1955,
                                "MPMC / Rani Durgavati University");

                Course nscbMBBS = createCourse(nscbmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 5.5 year program with 1 year internship. Excellent clinical exposure at attached 1200-bed hospital.",
                                "NEET UG qualified with minimum 50% marks in 12th PCB");
                createSeatMatrix(nscbMBBS, "GENERAL", 75, 10, "2026-27");
                createSeatMatrix(nscbMBBS, "OBC", 40, 6, "2026-27");
                createSeatMatrix(nscbMBBS, "SC", 22, 4, "2026-27");
                createSeatMatrix(nscbMBBS, "ST", 12, 2, "2026-27");
                createSeatMatrix(nscbMBBS, "EWS", 15, 3, "2026-27");
                createFeeStructure(nscbMBBS, "2026-27", new BigDecimal("28000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("57000"), "PER_YEAR");
                createCutoff(nscbMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.5"), 15000, "NEET UG");
                createCutoff(nscbMBBS, "OBC", "2023-2024", "Round 1", new BigDecimal("95.0"), 30000, "NEET UG");

                Course nscbMS = createCourse(nscbmc, "MS", "General Surgery", "PG", 3,
                                "Master of Surgery in General Surgery", "NEET PG qualified with MBBS");
                createSeatMatrix(nscbMS, "GENERAL", 15, 3, "2026-27");
                createFeeStructure(nscbMS, "2026-27", new BigDecimal("40000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("73000"), "PER_YEAR");

                Course nscbMD = createCourse(nscbmc, "MD", "General Medicine", "PG", 3,
                                "Doctor of Medicine in General Medicine", "NEET PG qualified with MBBS");
                createSeatMatrix(nscbMD, "GENERAL", 12, 2, "2026-27");
                createFeeStructure(nscbMD, "2026-27", new BigDecimal("40000"), new BigDecimal("20000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("5000"),
                                new BigDecimal("73000"), "PER_YEAR");

                // 2. Gajra Raja Medical College (GRMC), Gwalior
                College grmc = createCollege(
                                "Gajra Raja Medical College (GRMC) Gwalior",
                                "GRMC Gwalior is the oldest medical college in MP, established in 1946. Attached to Jayarogya Hospital (JAH) with 1000+ beds. Renowned for quality medical education and affordable fees.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Jayarogya Hospital Campus, Gwalior, MP 474009",
                                "474009",
                                "0751-2340251",
                                "grmc.gwalior@mp.gov.in",
                                "https://www.grmcgwalior.mp.gov.in",
                                "A",
                                true,
                                1946,
                                "MPMC / Jiwaji University");

                Course grmcMBBS = createCourse(grmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. Oldest medical college in MP with 1000+ bed hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(grmcMBBS, "GENERAL", 75, 10, "2026-27");
                createSeatMatrix(grmcMBBS, "OBC", 40, 6, "2026-27");
                createSeatMatrix(grmcMBBS, "SC", 22, 4, "2026-27");
                createSeatMatrix(grmcMBBS, "ST", 12, 2, "2026-27");
                createSeatMatrix(grmcMBBS, "EWS", 15, 3, "2026-27");
                createFeeStructure(grmcMBBS, "2026-27", new BigDecimal("25000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("5000"),
                                new BigDecimal("3000"),
                                new BigDecimal("50000"), "PER_YEAR");
                createCutoff(grmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("97.8"), 13000, "NEET UG");
                createCutoff(grmcMBBS, "OBC", "2023-2024", "Round 1", new BigDecimal("95.5"), 28000, "NEET UG");

                // 3. SS Medical College, Rewa
                College ssmc = createCollege(
                                "Shyam Shah Medical College (SSMC) Rewa",
                                "SSMC Rewa is a prestigious government medical college established in 1963. Attached to Sanjay Gandhi Memorial Hospital. Known for quality MBBS and PG medical education in Vindhya region.",
                                "GOVERNMENT",
                                "Rewa",
                                "Madhya Pradesh",
                                "Rewa, MP 486001",
                                "486001",
                                "07662-252066",
                                "ssmcrewa@mp.gov.in",
                                "https://www.ssmcrewa.mp.gov.in",
                                "B++",
                                true,
                                1963,
                                "MPMC / APS University");

                Course ssmcMBBS = createCourse(ssmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. Attached to SGM Hospital with 800+ beds.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(ssmcMBBS, "GENERAL", 75, 12, "2026-27");
                createSeatMatrix(ssmcMBBS, "OBC", 40, 7, "2026-27");
                createSeatMatrix(ssmcMBBS, "SC", 22, 4, "2026-27");
                createSeatMatrix(ssmcMBBS, "ST", 12, 3, "2026-27");
                createFeeStructure(ssmcMBBS, "2026-27", new BigDecimal("22000"), new BigDecimal("12000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("3000"),
                                new BigDecimal("43000"), "PER_YEAR");
                createCutoff(ssmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("96.5"), 22000, "NEET UG");

                // 4. Bundelkhand Medical College, Sagar
                College bmc = createCollege(
                                "Bundelkhand Medical College (BMC) Sagar",
                                "BMC Sagar is a government medical college established in 1968. Known for affordable medical education serving the Bundelkhand region.",
                                "GOVERNMENT",
                                "Sagar",
                                "Madhya Pradesh",
                                "Tili Road, Sagar, MP 470001",
                                "470001",
                                "07582-264810",
                                "bmcsagar@mp.gov.in",
                                "https://www.bmcsagar.mp.gov.in",
                                "B++",
                                true,
                                1968,
                                "MPMC / Dr. Harisingh Gour University");

                Course bmcMBBS = createCourse(bmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(bmcMBBS, "GENERAL", 75, 12, "2026-27");
                createSeatMatrix(bmcMBBS, "OBC", 40, 7, "2026-27");
                createSeatMatrix(bmcMBBS, "SC", 22, 4, "2026-27");
                createSeatMatrix(bmcMBBS, "ST", 12, 3, "2026-27");
                createFeeStructure(bmcMBBS, "2026-27", new BigDecimal("22000"), new BigDecimal("12000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("3000"),
                                new BigDecimal("43000"), "PER_YEAR");
                createCutoff(bmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("95.0"), 30000, "NEET UG");

                // 5. Government Medical College, Chhindwara
                College gmcChhindwara = createCollege(
                                "Government Medical College Chhindwara",
                                "Government Medical College Chhindwara is a new-generation government medical college established to strengthen medical education in MP.",
                                "GOVERNMENT",
                                "Chhindwara",
                                "Madhya Pradesh",
                                "Chhindwara, MP 480001",
                                "480001",
                                "07162-240100",
                                "gmcchhindwara@mp.gov.in",
                                "https://www.gmcchhindwara.mp.gov.in",
                                "B+",
                                true,
                                2018,
                                "MPMC");

                Course gmcChhMBBS = createCourse(gmcChhindwara, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcChhMBBS, "GENERAL", 50, 10, "2026-27");
                createSeatMatrix(gmcChhMBBS, "OBC", 27, 5, "2026-27");
                createSeatMatrix(gmcChhMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcChhMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcChhMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcChhMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("93.0"), 45000, "NEET UG");

                // 6. Government Medical College, Datia
                College gmcDatia = createCollege(
                                "Government Medical College Datia",
                                "Government Medical College Datia is a new government medical college established under PM's expansion plan for medical education.",
                                "GOVERNMENT",
                                "Datia",
                                "Madhya Pradesh",
                                "Datia, MP 475661",
                                "475661",
                                "07522-231100",
                                "gmcdatia@mp.gov.in",
                                "https://www.gmcdatia.mp.gov.in",
                                "B+",
                                true,
                                2019,
                                "MPMC");

                Course gmcDatiaMBBS = createCourse(gmcDatia, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcDatiaMBBS, "GENERAL", 50, 12, "2026-27");
                createSeatMatrix(gmcDatiaMBBS, "OBC", 27, 6, "2026-27");
                createSeatMatrix(gmcDatiaMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcDatiaMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcDatiaMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcDatiaMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("91.0"), 55000, "NEET UG");

                // 7. Government Medical College, Vidisha
                College gmcVidisha = createCollege(
                                "Government Medical College Vidisha",
                                "Government Medical College Vidisha is a newly established government medical college to expand medical education access.",
                                "GOVERNMENT",
                                "Vidisha",
                                "Madhya Pradesh",
                                "Vidisha, MP 464001",
                                "464001",
                                "07592-234100",
                                "gmcvidisha@mp.gov.in",
                                "https://www.gmcvidisha.mp.gov.in",
                                "B+",
                                true,
                                2019,
                                "MPMC");

                Course gmcVidishaMBBS = createCourse(gmcVidisha, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcVidishaMBBS, "GENERAL", 50, 12, "2026-27");
                createSeatMatrix(gmcVidishaMBBS, "OBC", 27, 6, "2026-27");
                createSeatMatrix(gmcVidishaMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcVidishaMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcVidishaMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcVidishaMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("91.5"), 52000, "NEET UG");

                // 8. Government Medical College, Shahdol
                College gmcShahdol = createCollege(
                                "Government Medical College Shahdol",
                                "Government Medical College Shahdol is established under the expansion of government medical education in tribal and backward areas of MP.",
                                "GOVERNMENT",
                                "Shahdol",
                                "Madhya Pradesh",
                                "Shahdol, MP 484001",
                                "484001",
                                "07652-241100",
                                "gmcshahdol@mp.gov.in",
                                "https://www.gmcshahdol.mp.gov.in",
                                "B+",
                                true,
                                2019,
                                "MPMC");

                Course gmcShahdolMBBS = createCourse(gmcShahdol, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcShahdolMBBS, "GENERAL", 50, 12, "2026-27");
                createSeatMatrix(gmcShahdolMBBS, "OBC", 27, 6, "2026-27");
                createSeatMatrix(gmcShahdolMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcShahdolMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcShahdolMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcShahdolMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("89.0"), 65000, "NEET UG");

                // 9. Government Medical College, Khandwa
                College gmcKhandwa = createCollege(
                                "Government Medical College Khandwa",
                                "Government Medical College Khandwa is a newly established college to expand medical education infrastructure in MP.",
                                "GOVERNMENT",
                                "Khandwa",
                                "Madhya Pradesh",
                                "Khandwa, MP 450001",
                                "450001",
                                "0733-2243100",
                                "gmckhandwa@mp.gov.in",
                                "https://www.gmckhandwa.mp.gov.in",
                                "B+",
                                true,
                                2020,
                                "MPMC");

                Course gmcKhandwaMBBS = createCourse(gmcKhandwa, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcKhandwaMBBS, "GENERAL", 50, 12, "2026-27");
                createSeatMatrix(gmcKhandwaMBBS, "OBC", 27, 6, "2026-27");
                createSeatMatrix(gmcKhandwaMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcKhandwaMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcKhandwaMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcKhandwaMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), 60000, "NEET UG");

                // 10. Government Medical College, Ratlam
                College gmcRatlam = createCollege(
                                "Government Medical College Ratlam",
                                "Government Medical College Ratlam established to expand medical education in Malwa-Nimar region of MP.",
                                "GOVERNMENT",
                                "Ratlam",
                                "Madhya Pradesh",
                                "Ratlam, MP 457001",
                                "457001",
                                "07412-263100",
                                "gmcratlam@mp.gov.in",
                                "https://www.gmcratlam.mp.gov.in",
                                "B+",
                                true,
                                2020,
                                "MPMC");

                Course gmcRatlamMBBS = createCourse(gmcRatlam, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcRatlamMBBS, "GENERAL", 50, 12, "2026-27");
                createSeatMatrix(gmcRatlamMBBS, "OBC", 27, 6, "2026-27");
                createSeatMatrix(gmcRatlamMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcRatlamMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcRatlamMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcRatlamMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.5"), 58000, "NEET UG");

                // 11. Government Medical College, Shivpuri
                College gmcShivpuri = createCollege(
                                "Government Medical College Shivpuri",
                                "Government Medical College Shivpuri is a new government medical college established under PM's expansion of medical education.",
                                "GOVERNMENT",
                                "Shivpuri",
                                "Madhya Pradesh",
                                "Shivpuri, MP 473551",
                                "473551",
                                "07492-231100",
                                "gmcshivpuri@mp.gov.in",
                                "https://www.gmcshivpuri.mp.gov.in",
                                "B+",
                                true,
                                2020,
                                "MPMC");

                Course gmcShivpuriMBBS = createCourse(gmcShivpuri, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gmcShivpuriMBBS, "GENERAL", 50, 12, "2026-27");
                createSeatMatrix(gmcShivpuriMBBS, "OBC", 27, 6, "2026-27");
                createSeatMatrix(gmcShivpuriMBBS, "SC", 15, 3, "2026-27");
                createSeatMatrix(gmcShivpuriMBBS, "ST", 8, 2, "2026-27");
                createFeeStructure(gmcShivpuriMBBS, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("4000"),
                                new BigDecimal("2000"),
                                new BigDecimal("38000"), "PER_YEAR");
                createCutoff(gmcShivpuriMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("89.5"), 62000, "NEET UG");
        }

        // ==================== GOVERNMENT AYURVEDA (BAMS) COLLEGES ====================
        private void seedGovernmentAyurvedaColleges() {
                System.out.println("📍 Seeding Government Ayurveda (BAMS) Colleges...");

                // 1. Government Autonomous Dhanwantari Ayurved College, Ujjain
                College dhanwantari = createCollege(
                                "Government Autonomous Dhanwantari Ayurved College Ujjain",
                                "Dhanwantari Ayurved College Ujjain is the oldest and most prestigious government Ayurveda college in MP, established in 1948. Known for authentic Ayurvedic education with attached 200-bed hospital. NAAC accredited and recognized by CCIM/NCISM.",
                                "GOVERNMENT",
                                "Ujjain",
                                "Madhya Pradesh",
                                "Agar Road, Ujjain, MP 456006",
                                "456006",
                                "0734-2515700",
                                "gdacujjain@mp.gov.in",
                                "https://www.gdacujjain.mp.gov.in",
                                "A",
                                true,
                                1948,
                                "NCISM / Vikram University");

                Course dhanBAMS = createCourse(dhanwantari, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery. 5.5 year program (4.5 years academic + 1 year internship). Covers Ayurvedic Samhita, Dravyaguna, Panchakarma, Kayachikitsa, Shalya Tantra, Shalakya Tantra, and Prasooti Tantra.",
                                "NEET UG qualified with minimum 50% in 12th PCB (40% for reserved categories)");
                createSeatMatrix(dhanBAMS, "GENERAL", 50, 8, "2026-27");
                createSeatMatrix(dhanBAMS, "OBC", 27, 5, "2026-27");
                createSeatMatrix(dhanBAMS, "SC", 15, 3, "2026-27");
                createSeatMatrix(dhanBAMS, "ST", 10, 2, "2026-27");
                createFeeStructure(dhanBAMS, "2026-27", new BigDecimal("15000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("2000"),
                                new BigDecimal("32000"), "PER_YEAR");
                createCutoff(dhanBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), 120000, "NEET UG");
                createCutoff(dhanBAMS, "OBC", "2023-2024", "Round 1", new BigDecimal("78.0"), 200000, "NEET UG");

                Course dhanMD = createCourse(dhanwantari, "MD (Ayu)", "Kayachikitsa", "PG", 3,
                                "Doctor of Medicine in Ayurvedic Medicine (Kayachikitsa)", "AIAPGET qualified with BAMS");
                createSeatMatrix(dhanMD, "GENERAL", 10, 3, "2026-27");
                createFeeStructure(dhanMD, "2026-27", new BigDecimal("25000"), new BigDecimal("12000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("3000"),
                                new BigDecimal("45000"), "PER_YEAR");

                // 2. Pt. Khushilal Sharma Government Ayurveda College, Bhopal
                College pksAyurved = createCollege(
                                "Pt. Khushilal Sharma Government Autonomous Ayurveda College Bhopal",
                                "Pt. KLS Ayurveda College Bhopal is a premier government Ayurveda institution in the state capital. Offers BAMS and PG Ayurveda programs with 150-bed attached hospital. Known for clinical training and Ayurvedic research.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Berasia Road, Bhopal, MP 462038",
                                "462038",
                                "0755-2750100",
                                "pklsgac.bhopal@mp.gov.in",
                                "https://www.pklsgac.mp.gov.in",
                                "A",
                                true,
                                1952,
                                "NCISM / Barkatullah University");

                Course pksBAMS = createCourse(pksAyurved, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery with 150-bed attached hospital for clinical training.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(pksBAMS, "GENERAL", 60, 10, "2026-27");
                createSeatMatrix(pksBAMS, "OBC", 32, 6, "2026-27");
                createSeatMatrix(pksBAMS, "SC", 18, 3, "2026-27");
                createSeatMatrix(pksBAMS, "ST", 10, 2, "2026-27");
                createFeeStructure(pksBAMS, "2026-27", new BigDecimal("12000"), new BigDecimal("8000"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2500"),
                                new BigDecimal("2000"),
                                new BigDecimal("26000"), "PER_YEAR");
                createCutoff(pksBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("82.0"), 140000, "NEET UG");

                // 3. Government Ayurveda College, Rewa
                College gacRewa = createCollege(
                                "Government Ayurveda College Rewa",
                                "Government Ayurveda College Rewa offers quality BAMS education with attached hospital for clinical training in Vindhya region.",
                                "GOVERNMENT",
                                "Rewa",
                                "Madhya Pradesh",
                                "Rewa, MP 486001",
                                "486001",
                                "07662-252100",
                                "gacrewa@mp.gov.in",
                                "https://www.gacrewa.mp.gov.in",
                                "B++",
                                true,
                                1965,
                                "NCISM / APS University");

                Course gacRewaBAMS = createCourse(gacRewa, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gacRewaBAMS, "GENERAL", 40, 8, "2026-27");
                createSeatMatrix(gacRewaBAMS, "OBC", 22, 5, "2026-27");
                createSeatMatrix(gacRewaBAMS, "SC", 12, 3, "2026-27");
                createSeatMatrix(gacRewaBAMS, "ST", 8, 2, "2026-27");
                createFeeStructure(gacRewaBAMS, "2026-27", new BigDecimal("10000"), new BigDecimal("7000"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("1500"),
                                new BigDecimal("22000"), "PER_YEAR");
                createCutoff(gacRewaBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("78.0"), 180000, "NEET UG");

                // 4. Government Ayurveda College, Gwalior
                College gacGwalior = createCollege(
                                "Government Ayurveda College Gwalior",
                                "Government Ayurveda College Gwalior provides authentic Ayurvedic education and clinical training in the Gwalior-Chambal region.",
                                "GOVERNMENT",
                                "Gwalior",
                                "Madhya Pradesh",
                                "Gwalior, MP 474001",
                                "474001",
                                "0751-2340300",
                                "gacgwalior@mp.gov.in",
                                "https://www.gacgwalior.mp.gov.in",
                                "B++",
                                true,
                                1960,
                                "NCISM / Jiwaji University");

                Course gacGwaliorBAMS = createCourse(gacGwalior, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gacGwaliorBAMS, "GENERAL", 40, 8, "2026-27");
                createSeatMatrix(gacGwaliorBAMS, "OBC", 22, 5, "2026-27");
                createSeatMatrix(gacGwaliorBAMS, "SC", 12, 3, "2026-27");
                createSeatMatrix(gacGwaliorBAMS, "ST", 8, 2, "2026-27");
                createFeeStructure(gacGwaliorBAMS, "2026-27", new BigDecimal("10000"), new BigDecimal("7000"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("1500"),
                                new BigDecimal("22000"), "PER_YEAR");
                createCutoff(gacGwaliorBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("80.0"), 160000, "NEET UG");
        }

        // ==================== GOVERNMENT HOMOEOPATHY (BHMS) COLLEGES ====================
        private void seedGovernmentHomoeopathyColleges() {
                System.out.println("📍 Seeding Government Homoeopathy (BHMS) Colleges...");

                College ghmc = createCollege(
                                "Government Homoeopathic Medical College Bhopal",
                                "Government Homoeopathic Medical College Bhopal is the only government BHMS college in MP. Established in 1960, it offers quality Homoeopathic education with 100-bed attached hospital. Recognized by CCH/NCH.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Near Lalghati, Bhopal, MP 462038",
                                "462038",
                                "0755-2750200",
                                "ghmcbhopal@mp.gov.in",
                                "https://www.ghmcbhopal.mp.gov.in",
                                "B++",
                                true,
                                1960,
                                "NCH / Barkatullah University");

                Course ghmcBHMS = createCourse(ghmc, "BHMS", "Homoeopathic Medicine and Surgery", "UG", 5,
                                "Bachelor of Homoeopathic Medicine and Surgery. 5.5 year program (4.5 years academic + 1 year internship). Covers Organon of Medicine, Materia Medica, Repertory, Case Taking, and Clinical Practice.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(ghmcBHMS, "GENERAL", 40, 8, "2026-27");
                createSeatMatrix(ghmcBHMS, "OBC", 22, 5, "2026-27");
                createSeatMatrix(ghmcBHMS, "SC", 12, 3, "2026-27");
                createSeatMatrix(ghmcBHMS, "ST", 8, 2, "2026-27");
                createFeeStructure(ghmcBHMS, "2026-27", new BigDecimal("8000"), new BigDecimal("6000"),
                                new BigDecimal("0"), new BigDecimal("1500"), new BigDecimal("2000"),
                                new BigDecimal("1500"),
                                new BigDecimal("19000"), "PER_YEAR");
                createCutoff(ghmcBHMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("65.0"), 350000, "NEET UG");
        }

        // ==================== GOVERNMENT DENTAL (BDS) COLLEGES ====================
        private void seedGovernmentDentalColleges() {
                System.out.println("📍 Seeding Government Dental (BDS) Colleges...");

                College gcdIndore = createCollege(
                                "Government College of Dentistry Indore",
                                "Government College of Dentistry Indore is the premier government dental college in MP, attached to MY Hospital. Established in 1958, known for excellent BDS and MDS programs with strong clinical training.",
                                "GOVERNMENT",
                                "Indore",
                                "Madhya Pradesh",
                                "MY Hospital Campus, Indore, MP 452001",
                                "452001",
                                "0731-2527400",
                                "gcdindore@mp.gov.in",
                                "https://www.gcdindore.mp.gov.in",
                                "A",
                                true,
                                1958,
                                "MPMC / DAVV");

                Course gcdBDS = createCourse(gcdIndore, "BDS", "Dental Surgery", "UG", 5,
                                "Bachelor of Dental Surgery. 5-year program (4 years academic + 1 year internship). Covers Oral Medicine, Orthodontics, Prosthodontics, Periodontics, Oral Surgery, and Conservative Dentistry.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(gcdBDS, "GENERAL", 30, 5, "2026-27");
                createSeatMatrix(gcdBDS, "OBC", 16, 3, "2026-27");
                createSeatMatrix(gcdBDS, "SC", 9, 2, "2026-27");
                createSeatMatrix(gcdBDS, "ST", 5, 1, "2026-27");
                createFeeStructure(gcdBDS, "2026-27", new BigDecimal("25000"), new BigDecimal("15000"),
                                new BigDecimal("0"), new BigDecimal("3000"), new BigDecimal("5000"),
                                new BigDecimal("4000"),
                                new BigDecimal("52000"), "PER_YEAR");
                createCutoff(gcdBDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("92.0"), 60000, "NEET UG");

                Course gcdMDS = createCourse(gcdIndore, "MDS", "Orthodontics", "PG", 3,
                                "Master of Dental Surgery in Orthodontics", "NEET MDS qualified with BDS");
                createSeatMatrix(gcdMDS, "GENERAL", 6, 2, "2026-27");
                createFeeStructure(gcdMDS, "2026-27", new BigDecimal("50000"), new BigDecimal("18000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("6000"),
                                new BigDecimal("5000"),
                                new BigDecimal("83000"), "PER_YEAR");
        }

        // ==================== PRIVATE MBBS COLLEGES ====================
        private void seedPrivateMBBSColleges() {
                System.out.println("📍 Seeding Private MBBS Colleges...");

                // 1. People's College of Medical Sciences, Bhopal
                College peoples = createCollege(
                                "People's College of Medical Sciences and Research Centre Bhopal",
                                "People's College of Medical Sciences is one of the top private medical colleges in MP. Part of People's Group. Offers MBBS, MD, MS with 750-bed multi-specialty hospital. NAAC A graded with excellent placements.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Bhanpur, Bhopal, MP 462037",
                                "462037",
                                "0755-4005000",
                                "info@pcmsrc.ac.in",
                                "https://www.pcmsrc.ac.in",
                                "A",
                                true,
                                1998,
                                "MPMC / Barkatullah University");

                Course peoplesMBBS = createCourse(peoples, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 750-bed multi-specialty hospital for clinical training.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(peoplesMBBS, "GENERAL", 100, 20, "2026-27");
                createSeatMatrix(peoplesMBBS, "OBC", 54, 10, "2026-27");
                createSeatMatrix(peoplesMBBS, "SC", 30, 6, "2026-27");
                createFeeStructure(peoplesMBBS, "2026-27", new BigDecimal("1100000"), new BigDecimal("80000"),
                                new BigDecimal("0"), new BigDecimal("15000"), new BigDecimal("20000"),
                                new BigDecimal("25000"),
                                new BigDecimal("1240000"), "PER_YEAR");
                createCutoff(peoplesMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("90.0"), 60000, "NEET UG");

                // 2. Chirayu Medical College, Bhopal
                College chirayu = createCollege(
                                "Chirayu Medical College and Hospital Bhopal",
                                "Chirayu Medical College is a well-known private medical college in Bhopal with 600-bed attached hospital. Known for quality MBBS education and clinical exposure.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Bairagarh, Bhopal-Indore Highway, Bhopal, MP 462030",
                                "462030",
                                "0755-6679999",
                                "info@chirayuhospital.com",
                                "https://www.chirayuhospital.com",
                                "A",
                                true,
                                2005,
                                "MPMC / Barkatullah University");

                Course chirayuMBBS = createCourse(chirayu, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 600-bed hospital for clinical training.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(chirayuMBBS, "GENERAL", 100, 20, "2026-27");
                createSeatMatrix(chirayuMBBS, "OBC", 54, 10, "2026-27");
                createFeeStructure(chirayuMBBS, "2026-27", new BigDecimal("1000000"), new BigDecimal("70000"),
                                new BigDecimal("0"), new BigDecimal("12000"), new BigDecimal("18000"),
                                new BigDecimal("20000"),
                                new BigDecimal("1120000"), "PER_YEAR");
                createCutoff(chirayuMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("88.0"), 75000, "NEET UG");

                // 3. LN Medical College, Bhopal
                College lnmc = createCollege(
                                "L.N. Medical College and J.K. Hospital Bhopal",
                                "LN Medical College is part of the LNCT Group offering MBBS with J.K. Hospital (500+ beds) for clinical training. Modern infrastructure and good clinical exposure.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "JK Hospital Campus, Kolar Road, Bhopal, MP 462042",
                                "462042",
                                "0755-4009500",
                                "info@lnmc.ac.in",
                                "https://www.lnmc.ac.in",
                                "A",
                                true,
                                2009,
                                "MPMC / Barkatullah University");

                Course lnmcMBBS = createCourse(lnmc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. Attached to 500-bed J.K. Hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(lnmcMBBS, "GENERAL", 100, 22, "2026-27");
                createSeatMatrix(lnmcMBBS, "OBC", 54, 12, "2026-27");
                createFeeStructure(lnmcMBBS, "2026-27", new BigDecimal("950000"), new BigDecimal("65000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("15000"),
                                new BigDecimal("18000"),
                                new BigDecimal("1058000"), "PER_YEAR");
                createCutoff(lnmcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("87.0"), 82000, "NEET UG");

                // 4. RKDF Medical College, Bhopal
                College rkdfMed = createCollege(
                                "RKDF Medical College Hospital and Research Centre Bhopal",
                                "RKDF Medical College is part of the RKDF Group with attached 500-bed hospital. Offers MBBS with modern facilities and experienced faculty.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Jatkhedi, Hoshangabad Road, Bhopal, MP 462026",
                                "462026",
                                "0755-4002500",
                                "info@rkdfmedical.ac.in",
                                "https://www.rkdfmedical.ac.in",
                                "B++",
                                true,
                                2012,
                                "MPMC / Barkatullah University");

                Course rkdfMBBS = createCourse(rkdfMed, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 500-bed attached hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(rkdfMBBS, "GENERAL", 100, 25, "2026-27");
                createSeatMatrix(rkdfMBBS, "OBC", 54, 12, "2026-27");
                createFeeStructure(rkdfMBBS, "2026-27", new BigDecimal("900000"), new BigDecimal("60000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("15000"),
                                new BigDecimal("15000"),
                                new BigDecimal("1000000"), "PER_YEAR");
                createCutoff(rkdfMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("85.0"), 95000, "NEET UG");

                // 5. Amaltas Institute of Medical Sciences, Dewas
                College amaltas = createCollege(
                                "Amaltas Institute of Medical Sciences Dewas",
                                "Amaltas Institute of Medical Sciences is a private medical college in Dewas with modern infrastructure and 300-bed attached hospital.",
                                "PRIVATE",
                                "Dewas",
                                "Madhya Pradesh",
                                "Banediya, Dewas, MP 455001",
                                "455001",
                                "07272-253100",
                                "info@amaltasioms.com",
                                "https://www.amaltasioms.com",
                                "B++",
                                true,
                                2014,
                                "MPMC / DAVV");

                Course amalMBBS = createCourse(amaltas, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 300-bed modern hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(amalMBBS, "GENERAL", 100, 25, "2026-27");
                createSeatMatrix(amalMBBS, "OBC", 54, 12, "2026-27");
                createFeeStructure(amalMBBS, "2026-27", new BigDecimal("850000"), new BigDecimal("55000"),
                                new BigDecimal("0"), new BigDecimal("10000"), new BigDecimal("12000"),
                                new BigDecimal("15000"),
                                new BigDecimal("942000"), "PER_YEAR");
                createCutoff(amalMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("83.0"), 110000, "NEET UG");

                // 6. Sri Aurobindo Medical College, Indore
                College samc = createCollege(
                                "Sri Aurobindo Medical College and PG Institute Indore",
                                "Sri Aurobindo Medical College Indore is a reputed private medical college with 700-bed hospital. Part of Sri Aurobindo Institute of Medical Sciences (SAIMS) group.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Indore-Ujjain Highway, Indore, MP 453555",
                                "453555",
                                "0731-4231000",
                                "info@saims.ac.in",
                                "https://www.saims.ac.in",
                                "A",
                                true,
                                2002,
                                "MPMC / DAVV");

                Course samcMBBS = createCourse(samc, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 700-bed multi-specialty hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(samcMBBS, "GENERAL", 150, 25, "2026-27");
                createSeatMatrix(samcMBBS, "OBC", 80, 15, "2026-27");
                createFeeStructure(samcMBBS, "2026-27", new BigDecimal("1150000"), new BigDecimal("75000"),
                                new BigDecimal("0"), new BigDecimal("14000"), new BigDecimal("20000"),
                                new BigDecimal("22000"),
                                new BigDecimal("1281000"), "PER_YEAR");
                createCutoff(samcMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("89.0"), 68000, "NEET UG");

                // 7. R.D. Gardi Medical College, Ujjain
                College rdGardi = createCollege(
                                "R.D. Gardi Medical College Ujjain",
                                "R.D. Gardi Medical College is a well-established private medical college in Ujjain with 550-bed attached hospital. Known for quality medical education and affordable fees.",
                                "PRIVATE",
                                "Ujjain",
                                "Madhya Pradesh",
                                "Agar Road, Ujjain, MP 456006",
                                "456006",
                                "0734-2640330",
                                "info@rdgmc.edu.in",
                                "https://www.rdgmc.edu.in",
                                "A",
                                true,
                                2000,
                                "MPMC / Vikram University");

                Course rdGardiMBBS = createCourse(rdGardi, "MBBS", "Medicine and Surgery", "UG", 5,
                                "Bachelor of Medicine and Bachelor of Surgery. 550-bed attached hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(rdGardiMBBS, "GENERAL", 100, 20, "2026-27");
                createSeatMatrix(rdGardiMBBS, "OBC", 54, 10, "2026-27");
                createFeeStructure(rdGardiMBBS, "2026-27", new BigDecimal("1050000"), new BigDecimal("70000"),
                                new BigDecimal("0"), new BigDecimal("12000"), new BigDecimal("18000"),
                                new BigDecimal("20000"),
                                new BigDecimal("1170000"), "PER_YEAR");
                createCutoff(rdGardiMBBS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("88.5"), 72000, "NEET UG");
        }

        // ==================== PRIVATE AYURVEDA (BAMS) COLLEGES ====================
        private void seedPrivateAyurvedaColleges() {
                System.out.println("📍 Seeding Private Ayurveda (BAMS) Colleges...");

                // 1. Mansarovar Ayurvedic Medical College, Bhopal
                College mansarovar = createCollege(
                                "Mansarovar Ayurvedic Medical College Bhopal",
                                "Mansarovar Ayurvedic Medical College is a well-known private BAMS college in Bhopal with 100-bed Ayurveda hospital. Approved by NCISM and affiliated to Barkatullah University.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Kolar Road, Bhopal, MP 462042",
                                "462042",
                                "0755-4005100",
                                "info@mansarovarayurved.com",
                                "https://www.mansarovarayurved.com",
                                "B++",
                                true,
                                2003,
                                "NCISM / Barkatullah University");

                Course mansBAMS = createCourse(mansarovar, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery. 100-bed Ayurveda hospital for clinical training. Comprehensive Ayurveda curriculum with Panchakarma center.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(mansBAMS, "GENERAL", 60, 15, "2026-27");
                createSeatMatrix(mansBAMS, "OBC", 32, 8, "2026-27");
                createFeeStructure(mansBAMS, "2026-27", new BigDecimal("200000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("268000"), "PER_YEAR");
                createCutoff(mansBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("55.0"), 500000, "NEET UG");

                // 2. Rani Dullaiya Smriti Ayurveda College, Bhopal
                College raniDullaiya = createCollege(
                                "Rani Dullaiya Smriti Ayurveda PG College and Hospital Bhopal",
                                "Rani Dullaiya Smriti is a reputed private Ayurveda college in Bhopal offering BAMS and PG programs. Attached 60-bed Ayurveda hospital.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Govindpura, Bhopal, MP 462023",
                                "462023",
                                "0755-2586100",
                                "info@ranidullaiya.com",
                                "https://www.ranidullaiya.com",
                                "B++",
                                true,
                                1996,
                                "NCISM / Barkatullah University");

                Course raniBAMS = createCourse(raniDullaiya, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery with 60-bed Ayurveda hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(raniBAMS, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(raniBAMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(raniBAMS, "2026-27", new BigDecimal("180000"), new BigDecimal("40000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("8000"),
                                new BigDecimal("240000"), "PER_YEAR");
                createCutoff(raniBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), 550000, "NEET UG");

                // 3. LN Ayurved College and Hospital, Bhopal
                College lnAyurved = createCollege(
                                "L.N. Ayurved College and Hospital Bhopal",
                                "LN Ayurved College is part of the LNCT Group. Offers quality BAMS education with modern infrastructure and attached Ayurveda hospital.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Kolar Road, Bhopal, MP 462042",
                                "462042",
                                "0755-4009600",
                                "info@lnayurved.ac.in",
                                "https://www.lnayurved.ac.in",
                                "B++",
                                true,
                                2010,
                                "NCISM / Barkatullah University");

                Course lnAyurvedBAMS = createCourse(lnAyurved, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery. Part of LNCT Group.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(lnAyurvedBAMS, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(lnAyurvedBAMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(lnAyurvedBAMS, "2026-27", new BigDecimal("220000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("6000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("289000"), "PER_YEAR");
                createCutoff(lnAyurvedBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("52.0"), 530000, "NEET UG");

                // 4. Pt. Shivshakti Lal Sharma Ayurveda College, Ratlam
                College ptSSL = createCollege(
                                "Pt. Shivshakti Lal Sharma Ayurveda College Ratlam",
                                "A well-established private Ayurveda college in Ratlam offering BAMS with attached 60-bed hospital.",
                                "PRIVATE",
                                "Ratlam",
                                "Madhya Pradesh",
                                "Ratlam, MP 457001",
                                "457001",
                                "07412-262100",
                                "info@ptssl.ac.in",
                                "https://www.ptssl.ac.in",
                                "B+",
                                true,
                                2001,
                                "NCISM / Vikram University");

                Course ptSSLBAMS = createCourse(ptSSL, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery with 60-bed hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(ptSSLBAMS, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(ptSSLBAMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(ptSSLBAMS, "2026-27", new BigDecimal("165000"), new BigDecimal("35000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("219000"), "PER_YEAR");
                createCutoff(ptSSLBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), 580000, "NEET UG");

                // 5. Veena Vadini Ayurved College, Bhopal
                College veenaVadini = createCollege(
                                "Veena Vadini Ayurved College and Hospital Bhopal",
                                "Veena Vadini Ayurved College offers quality BAMS education with attached Ayurveda hospital in Bhopal.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Khajuri Kalan, Bhopal, MP 462022",
                                "462022",
                                "0755-2730100",
                                "info@veenavadini.com",
                                "https://www.veenavadini.com",
                                "B+",
                                true,
                                2005,
                                "NCISM / Barkatullah University");

                Course vvBAMS = createCourse(veenaVadini, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery. Attached Ayurveda hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(vvBAMS, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(vvBAMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(vvBAMS, "2026-27", new BigDecimal("175000"), new BigDecimal("38000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("232000"), "PER_YEAR");
                createCutoff(vvBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), 590000, "NEET UG");

                // 6. Rishikul Ayurvedic Medical College, Bhopal
                College rishikul = createCollege(
                                "Rishikul Ayurvedic Medical College and Hospital Bhopal",
                                "Rishikul Ayurvedic Medical College is a private Ayurveda college offering quality BAMS education with practical Ayurvedic clinical training.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hoshangabad Road, Bhopal, MP 462026",
                                "462026",
                                "0755-2730200",
                                "info@rishikulayurved.com",
                                "https://www.rishikulayurved.com",
                                "B+",
                                true,
                                2008,
                                "NCISM / Barkatullah University");

                Course rishikulBAMS = createCourse(rishikul, "BAMS", "Ayurvedic Medicine and Surgery", "UG", 5,
                                "Bachelor of Ayurvedic Medicine and Surgery with clinical hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(rishikulBAMS, "GENERAL", 60, 22, "2026-27");
                createSeatMatrix(rishikulBAMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(rishikulBAMS, "2026-27", new BigDecimal("190000"), new BigDecimal("42000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("9000"),
                                new BigDecimal("253000"), "PER_YEAR");
                createCutoff(rishikulBAMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), 610000, "NEET UG");
        }

        // ==================== PRIVATE HOMOEOPATHY (BHMS) COLLEGES ====================
        private void seedPrivateHomoeopathyColleges() {
                System.out.println("📍 Seeding Private Homoeopathy (BHMS) Colleges...");

                // 1. Nehru Homoeopathic Medical College, Bhopal
                College nehruHomo = createCollege(
                                "Nehru Homoeopathic Medical College and Hospital Bhopal",
                                "Nehru Homoeopathic Medical College is a well-known private BHMS college in Bhopal. Approved by NCH/CCH with attached Homoeopathic hospital for clinical training.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Lalghati, Bhopal, MP 462001",
                                "462001",
                                "0755-2748100",
                                "info@nehruhmc.com",
                                "https://www.nehruhmc.com",
                                "B++",
                                true,
                                1985,
                                "NCH / Barkatullah University");

                Course nehruBHMS = createCourse(nehruHomo, "BHMS", "Homoeopathic Medicine and Surgery", "UG", 5,
                                "Bachelor of Homoeopathic Medicine and Surgery. 5.5 year program with attached Homoeopathic hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(nehruBHMS, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(nehruBHMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(nehruBHMS, "2026-27", new BigDecimal("150000"), new BigDecimal("35000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("204000"), "PER_YEAR");
                createCutoff(nehruBHMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("45.0"), 600000, "NEET UG");

                // 2. Mahatma Gandhi Homoeopathic Medical College, Jabalpur
                College mgHomo = createCollege(
                                "Mahatma Gandhi Homoeopathic Medical College and Hospital Jabalpur",
                                "MG Homoeopathic Medical College Jabalpur is a reputed private BHMS college in Jabalpur with attached hospital.",
                                "PRIVATE",
                                "Jabalpur",
                                "Madhya Pradesh",
                                "Jabalpur, MP 482001",
                                "482001",
                                "0761-2603100",
                                "info@mghmcjbp.com",
                                "https://www.mghmcjbp.com",
                                "B+",
                                true,
                                1990,
                                "NCH / Rani Durgavati University");

                Course mgBHMS = createCourse(mgHomo, "BHMS", "Homoeopathic Medicine and Surgery", "UG", 5,
                                "Bachelor of Homoeopathic Medicine and Surgery with clinical hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(mgBHMS, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(mgBHMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(mgBHMS, "2026-27", new BigDecimal("140000"), new BigDecimal("30000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("7000"),
                                new BigDecimal("186000"), "PER_YEAR");
                createCutoff(mgBHMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("42.0"), 630000, "NEET UG");

                // 3. Sarvepalli Radhakrishnan Homoeopathic College, Indore
                College srkHomo = createCollege(
                                "Sarvepalli Radhakrishnan Homoeopathic Medical College Indore",
                                "Sarvepalli Radhakrishnan Homoeopathic Medical College offers quality BHMS education in Indore with attached hospital.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Indore, MP 452001",
                                "452001",
                                "0731-2520100",
                                "info@srkhomeo.ac.in",
                                "https://www.srkhomeo.ac.in",
                                "B+",
                                true,
                                2002,
                                "NCH / DAVV");

                Course srkBHMS = createCourse(srkHomo, "BHMS", "Homoeopathic Medicine and Surgery", "UG", 5,
                                "Bachelor of Homoeopathic Medicine and Surgery with attached hospital.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(srkBHMS, "GENERAL", 60, 20, "2026-27");
                createSeatMatrix(srkBHMS, "OBC", 32, 10, "2026-27");
                createFeeStructure(srkBHMS, "2026-27", new BigDecimal("135000"), new BigDecimal("32000"),
                                new BigDecimal("0"), new BigDecimal("4000"), new BigDecimal("5000"),
                                new BigDecimal("7000"),
                                new BigDecimal("183000"), "PER_YEAR");
                createCutoff(srkBHMS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("40.0"), 650000, "NEET UG");
        }

        // ==================== PRIVATE DENTAL (BDS) COLLEGES ====================
        private void seedPrivateDentalColleges() {
                System.out.println("📍 Seeding Private Dental (BDS) Colleges...");

                // 1. People's Dental Academy, Bhopal
                College peoplesDental = createCollege(
                                "People's Dental Academy Bhopal",
                                "People's Dental Academy is part of People's Group offering quality BDS and MDS programs. Attached to People's Hospital with modern dental clinics and labs.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Bhanpur, Bhopal, MP 462037",
                                "462037",
                                "0755-4005100",
                                "info@peoplesdental.com",
                                "https://www.peoplesdental.com",
                                "A",
                                true,
                                2005,
                                "MPMC / Barkatullah University");

                Course pdaBDS = createCourse(peoplesDental, "BDS", "Dental Surgery", "UG", 5,
                                "Bachelor of Dental Surgery. 5-year program with comprehensive dental clinical training.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(pdaBDS, "GENERAL", 60, 15, "2026-27");
                createSeatMatrix(pdaBDS, "OBC", 32, 8, "2026-27");
                createFeeStructure(pdaBDS, "2026-27", new BigDecimal("450000"), new BigDecimal("55000"),
                                new BigDecimal("0"), new BigDecimal("8000"), new BigDecimal("15000"),
                                new BigDecimal("12000"),
                                new BigDecimal("540000"), "PER_YEAR");
                createCutoff(pdaBDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("78.0"), 180000, "NEET UG");

                // 2. RKDF Dental College, Bhopal
                College rkdfDental = createCollege(
                                "RKDF Dental College and Research Centre Bhopal",
                                "RKDF Dental College is a private dental college in Bhopal with modern dental infrastructure and clinical practice.",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Hoshangabad Road, Bhopal, MP 462026",
                                "462026",
                                "0755-4002600",
                                "info@rkdfdental.ac.in",
                                "https://www.rkdfdental.ac.in",
                                "B++",
                                true,
                                2010,
                                "MPMC / Barkatullah University");

                Course rkdfBDS = createCourse(rkdfDental, "BDS", "Dental Surgery", "UG", 5,
                                "Bachelor of Dental Surgery. Modern dental labs and clinics.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(rkdfBDS, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(rkdfBDS, "OBC", 32, 10, "2026-27");
                createFeeStructure(rkdfBDS, "2026-27", new BigDecimal("380000"), new BigDecimal("48000"),
                                new BigDecimal("0"), new BigDecimal("7000"), new BigDecimal("12000"),
                                new BigDecimal("10000"),
                                new BigDecimal("457000"), "PER_YEAR");
                createCutoff(rkdfBDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("72.0"), 220000, "NEET UG");

                // 3. Sri Aurobindo College of Dentistry, Indore
                College saDental = createCollege(
                                "Sri Aurobindo College of Dentistry Indore",
                                "Sri Aurobindo College of Dentistry is part of SAIMS Group in Indore offering quality BDS education with 700-bed attached hospital.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Indore-Ujjain Highway, Indore, MP 453555",
                                "453555",
                                "0731-4231100",
                                "info@saimsdental.ac.in",
                                "https://www.saimsdental.ac.in",
                                "A",
                                true,
                                2006,
                                "MPMC / DAVV");

                Course saBDS = createCourse(saDental, "BDS", "Dental Surgery", "UG", 5,
                                "Bachelor of Dental Surgery with comprehensive clinical training.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(saBDS, "GENERAL", 60, 15, "2026-27");
                createSeatMatrix(saBDS, "OBC", 32, 8, "2026-27");
                createFeeStructure(saBDS, "2026-27", new BigDecimal("420000"), new BigDecimal("52000"),
                                new BigDecimal("0"), new BigDecimal("8000"), new BigDecimal("14000"),
                                new BigDecimal("12000"),
                                new BigDecimal("506000"), "PER_YEAR");
                createCutoff(saBDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("75.0"), 200000, "NEET UG");

                // 4. Modern Dental College, Indore
                College modernDental = createCollege(
                                "Modern Dental College and Research Centre Indore",
                                "Modern Dental College is a reputed private dental college in Indore with modern dental infrastructure, advanced labs, and excellent clinical training.",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "AB Road, Indore, MP 453112",
                                "453112",
                                "0731-2832100",
                                "info@moderndental.com",
                                "https://www.moderndental.com",
                                "B++",
                                true,
                                2004,
                                "MPMC / DAVV");

                Course modBDS = createCourse(modernDental, "BDS", "Dental Surgery", "UG", 5,
                                "Bachelor of Dental Surgery with advanced dental labs and clinical practice.",
                                "NEET UG qualified with minimum 50% in 12th PCB");
                createSeatMatrix(modBDS, "GENERAL", 60, 18, "2026-27");
                createSeatMatrix(modBDS, "OBC", 32, 10, "2026-27");
                createFeeStructure(modBDS, "2026-27", new BigDecimal("400000"), new BigDecimal("50000"),
                                new BigDecimal("0"), new BigDecimal("7000"), new BigDecimal("12000"),
                                new BigDecimal("10000"),
                                new BigDecimal("479000"), "PER_YEAR");
                createCutoff(modBDS, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), 240000, "NEET UG");
        }

        // ==================== PHYSIOTHERAPY (BPT) COLLEGES ====================
        private void seedPhysiotherapyColleges() {
                System.out.println("📍 Seeding Physiotherapy (BPT) Colleges...");

                // 1. Government College of Physiotherapy, Bhopal (Attached to GMC)
                College gcpBhopal = createCollege(
                                "Government College of Physiotherapy Bhopal",
                                "Government College of Physiotherapy Bhopal is attached to Gandhi Medical College. Only government BPT college in MP offering affordable physiotherapy education with excellent clinical training at Hamidia Hospital.",
                                "GOVERNMENT",
                                "Bhopal",
                                "Madhya Pradesh",
                                "GMC Campus, Sultania Road, Bhopal, MP 462001",
                                "462001",
                                "0755-2540600",
                                "gcphysiobhopal@mp.gov.in",
                                "https://www.gcphysiobhopal.mp.gov.in",
                                "B++",
                                true,
                                2005,
                                "MPMC / Barkatullah University");

                Course gcpBPT = createCourse(gcpBhopal, "BPT", "Physiotherapy", "UG", 4,
                                "Bachelor of Physiotherapy. 4.5 year program (4 years academic + 6 months internship). Covers Musculoskeletal, Neurological, Cardiopulmonary, Sports Physiotherapy and Rehabilitation. Clinical training at Hamidia Hospital.",
                                "NEET UG qualified / State-level entrance with 12th PCB 50%");
                createSeatMatrix(gcpBPT, "GENERAL", 25, 5, "2026-27");
                createSeatMatrix(gcpBPT, "OBC", 14, 3, "2026-27");
                createSeatMatrix(gcpBPT, "SC", 8, 2, "2026-27");
                createSeatMatrix(gcpBPT, "ST", 5, 1, "2026-27");
                createFeeStructure(gcpBPT, "2026-27", new BigDecimal("12000"), new BigDecimal("8000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("2000"),
                                new BigDecimal("27000"), "PER_YEAR");
                createCutoff(gcpBPT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("70.0"), 250000, "NEET UG");

                Course gcpMPT = createCourse(gcpBhopal, "MPT", "Orthopaedic Physiotherapy", "PG", 2,
                                "Master of Physiotherapy in Orthopaedic Physiotherapy", "BPT with 55% marks");
                createSeatMatrix(gcpMPT, "GENERAL", 8, 3, "2026-27");
                createFeeStructure(gcpMPT, "2026-27", new BigDecimal("20000"), new BigDecimal("10000"),
                                new BigDecimal("0"), new BigDecimal("2000"), new BigDecimal("3000"),
                                new BigDecimal("3000"),
                                new BigDecimal("38000"), "PER_YEAR");

                // 2. People's College of Physiotherapy, Bhopal
                College peoplesPhysio = createCollege(
                                "People's College of Paramedical Sciences and Physiotherapy Bhopal",
                                "Part of People's Group offering quality BPT and MPT programs with clinical training at People's Hospital (750 beds).",
                                "PRIVATE",
                                "Bhopal",
                                "Madhya Pradesh",
                                "Bhanpur, Bhopal, MP 462037",
                                "462037",
                                "0755-4005200",
                                "info@peoplescppt.com",
                                "https://www.peoplescppt.com",
                                "A",
                                true,
                                2005,
                                "MPMC / Barkatullah University");

                Course ppBPT = createCourse(peoplesPhysio, "BPT", "Physiotherapy", "UG", 4,
                                "Bachelor of Physiotherapy. Clinical training at People's Hospital (750 beds).",
                                "12th PCB with 50% / NEET UG qualified");
                createSeatMatrix(ppBPT, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(ppBPT, "OBC", 22, 6, "2026-27");
                createFeeStructure(ppBPT, "2026-27", new BigDecimal("120000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("8000"),
                                new BigDecimal("8000"),
                                new BigDecimal("186000"), "PER_YEAR");
                createCutoff(ppBPT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), 500000, "NEET UG");

                // 3. Index College of Physiotherapy, Indore
                College indexPhysio = createCollege(
                                "Index College of Physiotherapy and Research Indore",
                                "Part of Index Group of Institutions offering BPT with clinical training at Index Medical College Hospital (500 beds).",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "NH-59A, Nemawar Road, Indore, MP 452016",
                                "452016",
                                "0731-4247200",
                                "info@indexphysio.com",
                                "https://www.indexphysio.com",
                                "B++",
                                true,
                                2010,
                                "MPMC / DAVV");

                Course ipBPT = createCourse(indexPhysio, "BPT", "Physiotherapy", "UG", 4,
                                "Bachelor of Physiotherapy with clinical training at Index Hospital.",
                                "12th PCB with 50% / NEET UG qualified");
                createSeatMatrix(ipBPT, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(ipBPT, "OBC", 22, 6, "2026-27");
                createFeeStructure(ipBPT, "2026-27", new BigDecimal("110000"), new BigDecimal("42000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("7000"),
                                new BigDecimal("8000"),
                                new BigDecimal("172000"), "PER_YEAR");
                createCutoff(ipBPT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("48.0"), 520000, "NEET UG");

                // 4. Sri Aurobindo College of Physiotherapy, Indore
                College saPhysio = createCollege(
                                "Sri Aurobindo College of Nursing and Physiotherapy Indore",
                                "Part of SAIMS Group offering BPT and BSc Nursing with training at SAIMS Hospital (700 beds).",
                                "PRIVATE",
                                "Indore",
                                "Madhya Pradesh",
                                "Indore-Ujjain Highway, Indore, MP 453555",
                                "453555",
                                "0731-4231200",
                                "info@saimsphysio.ac.in",
                                "https://www.saimsphysio.ac.in",
                                "A",
                                true,
                                2008,
                                "MPMC / DAVV");

                Course saBPT = createCourse(saPhysio, "BPT", "Physiotherapy", "UG", 4,
                                "Bachelor of Physiotherapy with clinical training at SAIMS Hospital (700 beds).",
                                "12th PCB with 50% / NEET UG qualified");
                createSeatMatrix(saBPT, "GENERAL", 40, 12, "2026-27");
                createSeatMatrix(saBPT, "OBC", 22, 6, "2026-27");
                createFeeStructure(saBPT, "2026-27", new BigDecimal("125000"), new BigDecimal("48000"),
                                new BigDecimal("0"), new BigDecimal("6000"), new BigDecimal("8000"),
                                new BigDecimal("10000"),
                                new BigDecimal("197000"), "PER_YEAR");
                createCutoff(saBPT, "GENERAL", "2023-2024", "Round 1", new BigDecimal("50.0"), 510000, "NEET UG");

                Course saBSN = createCourse(saPhysio, "B.Sc", "Nursing", "UG", 4,
                                "Bachelor of Science in Nursing. Clinical training at SAIMS Hospital (700 beds).",
                                "12th PCB with 45% / NEET UG qualified");
                createSeatMatrix(saBSN, "GENERAL", 60, 15, "2026-27");
                createSeatMatrix(saBSN, "OBC", 30, 8, "2026-27");
                createFeeStructure(saBSN, "2026-27", new BigDecimal("100000"), new BigDecimal("45000"),
                                new BigDecimal("0"), new BigDecimal("5000"), new BigDecimal("6000"),
                                new BigDecimal("8000"),
                                new BigDecimal("164000"), "PER_YEAR");
        }

        // ==================== HELPER METHODS ====================

        private College createCollege(String name, String description, String type, String city,
                        String state, String address, String pincode, String phone,
                        String email, String website, String naacRating,
                        Boolean admissionOpen, Integer establishedYear, String affiliatedTo) {
                java.util.List<College> colleges = collegeRepository.findByName(name);
                College college = colleges.isEmpty() ? null : colleges.get(0);
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

                // Medical-specific facilities
                String facilities = "Library,Hostel,Hospital,Labs,Pharmacy,Operation Theatre,ICU,OPD,Wi-Fi,Auditorium,Cafeteria,Sports,Transport";
                if (name.toLowerCase().contains("ayurved") || name.toLowerCase().contains("bams")) {
                        facilities = "Library,Hostel,Ayurveda Hospital,Panchakarma Centre,Herbal Garden,Dravyaguna Lab,Labs,OPD,Wi-Fi,Auditorium,Cafeteria,Sports,Transport";
                } else if (name.toLowerCase().contains("homoeo") || name.toLowerCase().contains("bhms")) {
                        facilities = "Library,Hostel,Homoeopathic Hospital,Dispensary,Materia Medica Lab,OPD,Wi-Fi,Auditorium,Cafeteria,Sports,Transport";
                } else if (name.toLowerCase().contains("dental") || name.toLowerCase().contains("dentistry")) {
                        facilities = "Library,Hostel,Dental Hospital,Dental Clinics,Prosthetics Lab,Radiology Lab,OPD,Wi-Fi,Auditorium,Cafeteria,Sports,Transport";
                } else if (name.toLowerCase().contains("physiotherapy")) {
                        facilities = "Library,Hostel,Physiotherapy OPD,Rehabilitation Centre,Electrotherapy Lab,Exercise Therapy Lab,Wi-Fi,Auditorium,Cafeteria,Sports,Transport";
                }
                college.setFacilities(facilities);

                // Set banner and logo
                Map<String, String> realImages = getMedicalCollegeImageMap();
                String realImage = realImages.get(name);
                if (realImage != null) {
                        college.setBannerUrl(realImage);
                } else {
                        String seed = name.replaceAll("[^a-zA-Z0-9]", "-").toLowerCase();
                        college.setBannerUrl("https://picsum.photos/seed/" + seed + "/800/400");
                }
                String initials = getInitials(name);
                String bgColor;
                if ("GOVERNMENT".equals(type)) {
                        bgColor = "1a56db";
                } else if (name.toLowerCase().contains("ayurved")) {
                        bgColor = "059669"; // Green for Ayurveda
                } else if (name.toLowerCase().contains("homoeo")) {
                        bgColor = "7c3aed"; // Purple for Homoeo
                } else if (name.toLowerCase().contains("dental")) {
                        bgColor = "0891b2"; // Cyan for Dental
                } else if (name.toLowerCase().contains("physio")) {
                        bgColor = "dc2626"; // Red for Physio
                } else {
                        bgColor = "be123c"; // Rose for medical
                }
                college.setLogoUrl("https://ui-avatars.com/api/?name=" + initials + "&size=128&background=" + bgColor
                                + "&color=fff&bold=true&font-size=0.4");

                return collegeRepository.save(college);
        }

        private Map<String, String> getMedicalCollegeImageMap() {
                Map<String, String> map = new HashMap<>();
                // Real medical college images from Wikimedia Commons
                map.put("Netaji Subhash Chandra Bose Medical College (NSCBMC) Jabalpur",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Medical_College_Jabalpur.jpg/800px-Medical_College_Jabalpur.jpg");
                map.put("Gajra Raja Medical College (GRMC) Gwalior",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Gajra_Raja_Medical_College.jpg/800px-Gajra_Raja_Medical_College.jpg");
                map.put("People's College of Medical Sciences and Research Centre Bhopal",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/People%27s_College_of_Medical_Sciences_Campus.jpg/800px-People%27s_College_of_Medical_Sciences_Campus.jpg");
                map.put("Government Autonomous Dhanwantari Ayurved College Ujjain",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Ujjain_temple.jpg/800px-Ujjain_temple.jpg");
                map.put("Government College of Dentistry Indore",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Rajwada-Indore.jpg/800px-Rajwada-Indore.jpg");
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
