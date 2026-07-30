// Real Direct Building Image Links provided for Colleges

const REAL_COLLEGE_PHOTOS = {
    // Medical Colleges - Bhopal & MP
    "aiims bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "gandhi medical": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "gmc bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    
    // Iconic IITs & Engineering Institutes
    "manit": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg",
    "iit delhi": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/IIT_Delhi_Main_Building.jpg/1200px-IIT_Delhi_Main_Building.jpg",
    "iit bombay": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Main_Building_IIT_Bombay.jpg/1200px-Main_Building_IIT_Bombay.jpg",
    "iit madras": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/IIT_Madras_Main_Building.jpg/1200px-IIT_Madras_Main_Building.jpg",
    "bits pilani": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/BITS_Pilani_Clock_Tower_Building.jpg/1200px-BITS_Pilani_Clock_Tower_Building.jpg",
    "vit vellore": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/VIT_Vellore_Main_Building.jpg/1200px-VIT_Vellore_Main_Building.jpg",
    "vellore institute": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/VIT_Vellore_Main_Building.jpg/1200px-VIT_Vellore_Main_Building.jpg",

    // Default Real Building Backdrops
    DEFAULT_MEDICAL: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    DEFAULT_ENGINEERING: "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg"
};

export const getCollegeBanner = (college) => {
    // Custom Uploaded Images
    const rawBanner = (college?.bannerUrl || '').trim();
    if (
        rawBanner !== '' &&
        !rawBanner.includes('picsum') &&
        !rawBanner.includes('unsplash') &&
        !rawBanner.includes('pexels') &&
        !rawBanner.includes('pixabay') &&
        !rawBanner.includes('placeholder') &&
        !rawBanner.includes('shikshapedia') &&
        (rawBanner.includes('cloudinary') || rawBanner.includes('amazonaws') || rawBanner.includes('firebasestorage') || rawBanner.includes('/uploads/'))
    ) {
        return college.bannerUrl;
    }

    const name = (college?.name || '').toLowerCase();

    // Check exact matches in REAL_COLLEGE_PHOTOS dictionary
    for (const [key, photoUrl] of Object.entries(REAL_COLLEGE_PHOTOS)) {
        if (name.includes(key)) {
            return photoUrl;
        }
    }

    const desc = (college?.description || '').toLowerCase();
    const fullText = `${name} ${desc}`;

    if (fullText.includes('medical') || fullText.includes('mbbs') || fullText.includes('ayurved') || fullText.includes('bams') || fullText.includes('dental') || fullText.includes('bds') || fullText.includes('homoeo') || fullText.includes('bhms') || fullText.includes('physio') || fullText.includes('bpt')) {
        return REAL_COLLEGE_PHOTOS.DEFAULT_MEDICAL;
    }

    return REAL_COLLEGE_PHOTOS.DEFAULT_ENGINEERING;
};

export const getCollegeLogo = (college) => {
    const rawLogo = (college?.logoUrl || '').trim();
    if (
        rawLogo !== '' &&
        !rawLogo.includes('picsum') &&
        !rawLogo.includes('unsplash') &&
        !rawLogo.includes('pexels') &&
        !rawLogo.includes('pixabay') &&
        !rawLogo.includes('placeholder') &&
        (rawLogo.includes('cloudinary') || rawLogo.includes('amazonaws') || rawLogo.includes('firebasestorage') || rawLogo.includes('/uploads/'))
    ) {
        return college.logoUrl;
    }
    return getCollegeBanner(college);
};
