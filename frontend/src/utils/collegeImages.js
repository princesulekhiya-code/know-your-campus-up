// High-Resolution Campus & Building Photos
const CAMPUS_IMAGES = [
    "https://images.unsplash.com/photo-1562774053-701939374585?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1541339907198-e08756dedf3f?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1523050854058-8df90110c9f1?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1592280771190-3e2e4d571952?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1607237138186-7374c529a310?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1564981797816-1043664bf78d?w=1200&auto=format&fit=crop&q=80"
];

// Realistic Medical, Hospital, Dental, BAMS, BHMS & BPT Photos
const MEDICAL_IMAGES = [
    "https://images.unsplash.com/photo-1586773860418-d37222d8fce3?w=1200&auto=format&fit=crop&q=80", // Medical Hospital Main Building
    "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=1200&auto=format&fit=crop&q=80", // Medical College Entrance & Hospital
    "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=1200&auto=format&fit=crop&q=80", // Stethoscope & Doctor Desk
    "https://images.unsplash.com/photo-1551076805-e1869033e561?w=1200&auto=format&fit=crop&q=80", // Doctors & Medical Ward
    "https://images.unsplash.com/photo-1516549655169-df83a0774514?w=1200&auto=format&fit=crop&q=80", // Clinical Pathology Lab
    "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1200&auto=format&fit=crop&q=80", // Modern Teaching Hospital
    "https://images.unsplash.com/photo-1538108149393-fbbd81895907?w=1200&auto=format&fit=crop&q=80", // Emergency Hospital Wing
    "https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=1200&auto=format&fit=crop&q=80", // Medical Science Research Facility
    "https://images.unsplash.com/photo-1505751172876-fa1923c5c528?w=1200&auto=format&fit=crop&q=80"  // Healthcare Professionals
];

const AYURVEDA_IMAGES = [
    "https://images.unsplash.com/photo-1512290923902-8a9f81dc236c?w=1200&auto=format&fit=crop&q=80", // Medicinal Herbal Plants (BAMS)
    "https://images.unsplash.com/photo-1615485290382-441e4d049cb5?w=1200&auto=format&fit=crop&q=80", // Herbal Medicines & Ayurveda
    "https://images.unsplash.com/photo-1540555700478-4be289fbecef?w=1200&auto=format&fit=crop&q=80", // Natural Wellness & Panchakarma
    "https://images.unsplash.com/photo-1563170351-be82bc888aa4?w=1200&auto=format&fit=crop&q=80"  // Botanical Research Lab
];

const DENTAL_IMAGES = [
    "https://images.unsplash.com/photo-1606811841689-23dfddce3e95?w=1200&auto=format&fit=crop&q=80", // Dental Chair & Equipment (BDS)
    "https://images.unsplash.com/photo-1588776814546-1ffcf47267a5?w=1200&auto=format&fit=crop&q=80", // Dental Operating Clinic
    "https://images.unsplash.com/photo-1629909615184-74f495363b67?w=1200&auto=format&fit=crop&q=80"  // Oral Surgery Room
];

const HOMOEOPATHY_IMAGES = [
    "https://images.unsplash.com/photo-1585435557343-3b092031a831?w=1200&auto=format&fit=crop&q=80", // Homoeopathic Pharmacy & Tinctures (BHMS)
    "https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=1200&auto=format&fit=crop&q=80", // Natural Pharmacy Lab
    "https://images.unsplash.com/photo-1471864190281-a93a3070b6de?w=1200&auto=format&fit=crop&q=80"  // Pharmaceutical Remedies
];

const PHYSIO_IMAGES = [
    "https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=1200&auto=format&fit=crop&q=80", // Rehabilitation & Physiotherapy Gym (BPT)
    "https://images.unsplash.com/photo-1598256989800-fe5f95da9787?w=1200&auto=format&fit=crop&q=80", // Physical Therapy Room
    "https://images.unsplash.com/photo-1518611012118-696072aa579a?w=1200&auto=format&fit=crop&q=80"  // Sports Rehab Facility
];

export const getCollegeBanner = (college) => {
    if (college?.bannerUrl && college.bannerUrl.trim() !== '') {
        return college.bannerUrl;
    }

    const name = (college?.name || '').toLowerCase();
    const desc = (college?.description || '').toLowerCase();
    const fullText = `${name} ${desc}`;

    if (fullText.includes('ayurved') || fullText.includes('bams')) {
        const index = (college?.id || 0) % AYURVEDA_IMAGES.length;
        return AYURVEDA_IMAGES[index];
    }
    if (fullText.includes('dental') || fullText.includes('bds') || fullText.includes('dentistry')) {
        const index = (college?.id || 0) % DENTAL_IMAGES.length;
        return DENTAL_IMAGES[index];
    }
    if (fullText.includes('homoeo') || fullText.includes('homeo') || fullText.includes('bhms')) {
        const index = (college?.id || 0) % HOMOEOPATHY_IMAGES.length;
        return HOMOEOPATHY_IMAGES[index];
    }
    if (fullText.includes('physio') || fullText.includes('bpt')) {
        const index = (college?.id || 0) % PHYSIO_IMAGES.length;
        return PHYSIO_IMAGES[index];
    }
    if (fullText.includes('medical') || fullText.includes('mbbs') || fullText.includes('hospital')) {
        const index = (college?.id || 0) % MEDICAL_IMAGES.length;
        return MEDICAL_IMAGES[index];
    }

    const index = (college?.id || 0) % CAMPUS_IMAGES.length;
    return CAMPUS_IMAGES[index];
};

export const getCollegeLogo = (college) => {
    if (college?.logoUrl && college.logoUrl.trim() !== '') {
        return college.logoUrl;
    }
    return getCollegeBanner(college);
};
