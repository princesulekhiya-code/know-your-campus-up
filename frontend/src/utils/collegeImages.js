// Real Direct Building Photos for MP Medical & Engineering Colleges

const REAL_COLLEGE_BUILDINGS = {
    AIIMS: "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    GMC: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    GRMC: "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    GOVT_MEDICAL: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    PRIVATE_MEDICAL: "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    AYURVEDA: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    DENTAL: "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    HOMOEOPATHY: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    MANIT: "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg",
    IISER: "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/IISER_Bhopal_LHC.jpg/1200px-IISER_Bhopal_LHC.jpg",
    ENGINEERING: "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg"
};

export const getCollegeBanner = (college) => {
    // IGNORE any database url if it contains unsplash, placeholder, sample, or generic photo terms
    const rawBanner = (college?.bannerUrl || '').trim();
    if (
        rawBanner !== '' &&
        !rawBanner.includes('unsplash') &&
        !rawBanner.includes('placeholder') &&
        !rawBanner.includes('sample') &&
        (rawBanner.startsWith('http://') || rawBanner.startsWith('https://'))
    ) {
        return rawBanner;
    }

    const name = (college?.name || '').toLowerCase();
    const desc = (college?.description || '').toLowerCase();
    const fullText = `${name} ${desc}`;

    // Specific match checks for Real Campus Buildings
    if (fullText.includes('gajra raja') || fullText.includes('grmc')) {
        return REAL_COLLEGE_BUILDINGS.GRMC;
    }
    if (fullText.includes('aiims')) {
        return REAL_COLLEGE_BUILDINGS.AIIMS;
    }
    if (fullText.includes('gandhi medical') || fullText.includes('gmc bhopal')) {
        return REAL_COLLEGE_BUILDINGS.GMC;
    }
    if (fullText.includes('manit')) {
        return REAL_COLLEGE_BUILDINGS.MANIT;
    }
    if (fullText.includes('iiser')) {
        return REAL_COLLEGE_BUILDINGS.IISER;
    }

    // Category fallback strictly using real hospital/college building photos
    if (fullText.includes('ayurved') || fullText.includes('bams')) {
        return REAL_COLLEGE_BUILDINGS.AYURVEDA;
    }
    if (fullText.includes('dental') || fullText.includes('bds')) {
        return REAL_COLLEGE_BUILDINGS.DENTAL;
    }
    if (fullText.includes('homoeo') || fullText.includes('homeo') || fullText.includes('bhms')) {
        return REAL_COLLEGE_BUILDINGS.HOMOEOPATHY;
    }
    if (fullText.includes('government') && (fullText.includes('medical') || fullText.includes('mbbs'))) {
        return REAL_COLLEGE_BUILDINGS.GOVT_MEDICAL;
    }
    if (fullText.includes('medical') || fullText.includes('mbbs') || fullText.includes('hospital') || fullText.includes('physio') || fullText.includes('bpt')) {
        return REAL_COLLEGE_BUILDINGS.PRIVATE_MEDICAL;
    }

    return REAL_COLLEGE_BUILDINGS.ENGINEERING;
};

export const getCollegeLogo = (college) => {
    const rawLogo = (college?.logoUrl || '').trim();
    if (
        rawLogo !== '' &&
        !rawLogo.includes('unsplash') &&
        !rawLogo.includes('placeholder') &&
        !rawLogo.includes('sample') &&
        (rawLogo.startsWith('http://') || rawLogo.startsWith('https://'))
    ) {
        return rawLogo;
    }
    return getCollegeBanner(college);
};
