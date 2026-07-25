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
    "https://images.unsplash.com/photo-1551076805-e1869033e561?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=1000&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1000&auto=format&fit=crop&q=80"
];

export const getCollegeBanner = (college) => {
    if (college?.bannerUrl && college.bannerUrl.trim() !== '') {
        return college.bannerUrl;
    }
    if (college?.logoUrl && college.logoUrl.trim() !== '') {
        return college.logoUrl;
    }

    const name = college?.name?.toLowerCase() || '';
    if (name.includes('medical') || name.includes('mbbs') || name.includes('bams') || name.includes('bds') || name.includes('ayurved') || name.includes('health') || name.includes('dental') || name.includes('nursing') || name.includes('hospital')) {
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
