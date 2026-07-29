const CAMPUS_IMAGES = [
    "https://images.unsplash.com/photo-1562774053-701939374585?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1541339907198-e08756dedf3f?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1523050854058-8df90110c9f1?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1592280771190-3e2e4d571952?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1607237138186-7374c529a310?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1564981797816-1043664bf78d?w=1000&auto=format&fit=crop&q=80"
];

const MEDICAL_IMAGES = [
    "https://images.unsplash.com/photo-1586773860418-d37222d8fce3?w=1000&auto=format&fit=crop&q=80", // Hospital building
    "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=1000&auto=format&fit=crop&q=80", // Medical entrance
    "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=1000&auto=format&fit=crop&q=80", // Stethoscope / medical
    "https://images.unsplash.com/photo-1551076805-e1869033e561?w=1000&auto=format&fit=crop&q=80", // Doctors in hospital
    "https://images.unsplash.com/photo-1516549655169-df83a0774514?w=1000&auto=format&fit=crop&q=80", // Clinical lab
    "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1000&auto=format&fit=crop&q=80", // Modern hospital facility
    "https://images.unsplash.com/photo-1512290923902-8a9f81dc236c?w=1000&auto=format&fit=crop&q=80", // Herbal ayurvedic plant / BAMS
    "https://images.unsplash.com/photo-1606811841689-23dfddce3e95?w=1000&auto=format&fit=crop&q=80", // Dental clinic / BDS
    "https://images.unsplash.com/photo-1585435557343-3b092031a831?w=1000&auto=format&fit=crop&q=80"  // Homeopathy / Pharmacy
];

export const getCollegeBanner = (college) => {
    if (college?.bannerUrl && college.bannerUrl.trim() !== '') {
        return college.bannerUrl;
    }
    if (college?.logoUrl && college.logoUrl.trim() !== '') {
        return college.logoUrl;
    }

    const name = college?.name?.toLowerCase() || '';
    if (name.includes('medical') || name.includes('mbbs') || name.includes('bams') || name.includes('bds') || name.includes('bhms') || name.includes('bpt') || name.includes('ayurved') || name.includes('health') || name.includes('dental') || name.includes('physio') || name.includes('homoeo') || name.includes('nursing') || name.includes('hospital')) {
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
