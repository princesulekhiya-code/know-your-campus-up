package com.knowyourcampus.config;

import com.knowyourcampus.entity.*;
import com.knowyourcampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

        // Seed colleges if database is empty
        if (collegeRepository.count() == 0) {
            seedColleges();
            System.out.println("✓ Sample data seeded successfully");
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

        createSeatMatrix(btechCSE, "GENERAL", 50, 10, "2024-2025");
        createSeatMatrix(btechCSE, "OBC", 30, 5, "2024-2025");
        createSeatMatrix(btechCSE, "SC", 15, 3, "2024-2025");
        createSeatMatrix(btechCSE, "ST", 10, 2, "2024-2025");

        createFeeStructure(btechCSE, "2024-2025",
                new BigDecimal("200000"), new BigDecimal("50000"), new BigDecimal("0"),
                new BigDecimal("5000"), new BigDecimal("10000"), new BigDecimal("10000"),
                new BigDecimal("275000"), "PER_YEAR");

        createCutoff(btechCSE, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.5"), 150, "JEE Advanced");
        createCutoff(btechCSE, "OBC", "2023-2024", "Round 1", new BigDecimal("98.8"), 450, "JEE Advanced");

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

        createSeatMatrix(mbbs, "GENERAL", 50, 5, "2024-2025");
        createSeatMatrix(mbbs, "OBC", 27, 3, "2024-2025");
        createSeatMatrix(mbbs, "SC", 15, 2, "2024-2025");

        createFeeStructure(mbbs, "2024-2025",
                new BigDecimal("5000"), new BigDecimal("30000"), new BigDecimal("0"),
                new BigDecimal("2000"), new BigDecimal("3000"), new BigDecimal("5000"),
                new BigDecimal("45000"), "PER_YEAR");

        createCutoff(mbbs, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.99"), 50, "NEET UG");

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

        createSeatMatrix(bcom, "GENERAL", 200, 20, "2024-2025");
        createSeatMatrix(bcom, "OBC", 100, 10, "2024-2025");

        createFeeStructure(bcom, "2024-2025",
                new BigDecimal("15000"), new BigDecimal("0"), new BigDecimal("0"),
                new BigDecimal("1000"), new BigDecimal("500"), new BigDecimal("2000"),
                new BigDecimal("18500"), "PER_YEAR");

        createCutoff(bcom, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.0"), null, "CUET");

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

        createSeatMatrix(btechAI, "GENERAL", 120, 30, "2024-2025");
        createSeatMatrix(btechAI, "MANAGEMENT", 60, 15, "2024-2025");

        createFeeStructure(btechAI, "2024-2025",
                new BigDecimal("350000"), new BigDecimal("100000"), new BigDecimal("25000"),
                new BigDecimal("10000"), new BigDecimal("15000"), new BigDecimal("20000"),
                new BigDecimal("520000"), "PER_YEAR");

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

        createSeatMatrix(btechMech, "GENERAL", 180, 40, "2024-2025");

        createFeeStructure(btechMech, "2024-2025",
                new BigDecimal("320000"), new BigDecimal("80000"), new BigDecimal("15000"),
                new BigDecimal("8000"), new BigDecimal("12000"), new BigDecimal("15000"),
                new BigDecimal("450000"), "PER_YEAR");

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

        Course btechECE = createCourse(nitTrichy, "B.Tech", "Electronics and Communication Engineering", "UG", 4,
                "Bachelor of Technology in ECE", "JEE Main qualified");

        createSeatMatrix(btechECE, "GENERAL", 80, 15, "2024-2025");
        createSeatMatrix(btechECE, "OBC", 40, 8, "2024-2025");

        createFeeStructure(btechECE, "2024-2025",
                new BigDecimal("150000"), new BigDecimal("40000"), new BigDecimal("0"),
                new BigDecimal("5000"), new BigDecimal("8000"), new BigDecimal("7000"),
                new BigDecimal("210000"), "PER_YEAR");

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

        createSeatMatrix(mba, "GENERAL", 250, 30, "2024-2025");

        createFeeStructure(mba, "2024-2025",
                new BigDecimal("1600000"), new BigDecimal("100000"), new BigDecimal("0"),
                new BigDecimal("25000"), new BigDecimal("0"), new BigDecimal("75000"),
                new BigDecimal("1800000"), "PER_YEAR");

        createCutoff(mba, "GENERAL", "2023-2024", "Round 1", new BigDecimal("99.5"), null, "CAT");

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

        createSeatMatrix(btechCivil, "GENERAL", 60, 12, "2024-2025");

        createFeeStructure(btechCivil, "2024-2025",
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

        createSeatMatrix(bba, "GENERAL", 300, 100, "2024-2025");

        createFeeStructure(bba, "2024-2025",
                new BigDecimal("180000"), new BigDecimal("60000"), new BigDecimal("15000"),
                new BigDecimal("5000"), new BigDecimal("5000"), new BigDecimal("10000"),
                new BigDecimal("275000"), "PER_YEAR");
    }

    private College createCollege(String name, String description, String type, String city,
            String state, String address, String pincode, String phone,
            String email, String website, String naacRating,
            Boolean admissionOpen, Integer establishedYear, String affiliatedTo) {
        College college = new College();
        college.setName(name);
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
        return collegeRepository.save(college);
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
