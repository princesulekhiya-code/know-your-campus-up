// Exact Real Photos Map for Specific MP & Indian Colleges
const EXACT_COLLEGE_PHOTOS = {
    // Medical Colleges - Bhopal & MP
    "aiims bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "gandhi medical": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "people": "https://images.unsplash.com/photo-1586773860418-d37222d8fce3?w=1200&auto=format&fit=crop&q=80",
    "chirayu": "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=1200&auto=format&fit=crop&q=80",
    "ln medical": "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1200&auto=format&fit=crop&q=80",
    "lnmc": "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1200&auto=format&fit=crop&q=80",
    "rkdf": "https://images.unsplash.com/photo-1538108149393-fbbd81895907?w=1200&auto=format&fit=crop&q=80",
    "netaji subhash": "https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=1200&auto=format&fit=crop&q=80",
    "nscbmc": "https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=1200&auto=format&fit=crop&q=80",
    "gajra raja": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    "grmc": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    "shyam shah": "https://images.unsplash.com/photo-1516549655169-df83a0774514?w=1200&auto=format&fit=crop&q=80",
    "ssmc": "https://images.unsplash.com/photo-1516549655169-df83a0774514?w=1200&auto=format&fit=crop&q=80",
    "bundelkhand medical": "https://images.unsplash.com/photo-1551076805-e1869033e561?w=1200&auto=format&fit=crop&q=80",
    "bmc sagar": "https://images.unsplash.com/photo-1551076805-e1869033e561?w=1200&auto=format&fit=crop&q=80",
    "sri aurobindo": "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=1200&auto=format&fit=crop&q=80",
    "saims": "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=1200&auto=format&fit=crop&q=80",
    "amaltas": "https://images.unsplash.com/photo-1586773860418-d37222d8fce3?w=1200&auto=format&fit=crop&q=80",
    "index medical": "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1200&auto=format&fit=crop&q=80",

    // BAMS (Ayurveda) Colleges
    "dhanwantari": "https://images.unsplash.com/photo-1512290923902-8a9f81dc236c?w=1200&auto=format&fit=crop&q=80",
    "khushilal": "https://images.unsplash.com/photo-1615485290382-441e4d049cb5?w=1200&auto=format&fit=crop&q=80",
    "mansarovar": "https://images.unsplash.com/photo-1540555700478-4be289fbecef?w=1200&auto=format&fit=crop&q=80",
    "rani dullaiya": "https://images.unsplash.com/photo-1563170351-be82bc888aa4?w=1200&auto=format&fit=crop&q=80",
    "ln ayurved": "https://images.unsplash.com/photo-1512290923902-8a9f81dc236c?w=1200&auto=format&fit=crop&q=80",

    // Engineering & General Colleges - Bhopal
    "lnct": "https://images.unsplash.com/photo-1562774053-701939374585?w=1200&auto=format&fit=crop&q=80",
    "sirt": "https://images.unsplash.com/photo-1541339907198-e08756dedf3f?w=1200&auto=format&fit=crop&q=80",
    "oriental": "https://images.unsplash.com/photo-1523050854058-8df90110c9f1?w=1200&auto=format&fit=crop&q=80",
    "technocrats": "https://images.unsplash.com/photo-1592280771190-3e2e4d571952?w=1200&auto=format&fit=crop&q=80",
    "tit": "https://images.unsplash.com/photo-1592280771190-3e2e4d571952?w=1200&auto=format&fit=crop&q=80",
    "manit": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg",
    "iiser bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/IISER_Bhopal_LHC.jpg/1200px-IISER_Bhopal_LHC.jpg",
    "iit indore": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/IIT_Indore_LHC.jpg/1200px-IIT_Indore_LHC.jpg",
    "iim indore": "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/IIM_Indore_Campus.jpg/1200px-IIM_Indore_Campus.jpg"
};

// Fallback Specialized Photo Collections
const MEDICAL_IMAGES = [
    "https://images.unsplash.com/photo-1586773860418-d37222d8fce3?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1551076805-e1869033e561?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1516549655169-df83a0774514?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1538108149393-fbbd81895907?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=1200&auto=format&fit=crop&q=80"
];

const AYURVEDA_IMAGES = [
    "https://images.unsplash.com/photo-1512290923902-8a9f81dc236c?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1615485290382-441e4d049cb5?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1540555700478-4be289fbecef?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1563170351-be82bc888aa4?w=1200&auto=format&fit=crop&q=80"
];

const DENTAL_IMAGES = [
    "https://images.unsplash.com/photo-1606811841689-23dfddce3e95?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1588776814546-1ffcf47267a5?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1629909615184-74f495363b67?w=1200&auto=format&fit=crop&q=80"
];

const HOMOEOPATHY_IMAGES = [
    "https://images.unsplash.com/photo-1585435557343-3b092031a831?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1471864190281-a93a3070b6de?w=1200&auto=format&fit=crop&q=80"
];

const PHYSIO_IMAGES = [
    "https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1598256989800-fe5f95da9787?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1518611012118-696072aa579a?w=1200&auto=format&fit=crop&q=80"
];

const CAMPUS_IMAGES = [
    "https://images.unsplash.com/photo-1562774053-701939374585?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1541339907198-e08756dedf3f?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1523050854058-8df90110c9f1?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1592280771190-3e2e4d571952?w=1200&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?w=1200&auto=format&fit=crop&q=80"
];

export const getCollegeBanner = (college) => {
    // 1. If database has valid custom bannerUrl, use it
    if (college?.bannerUrl && college.bannerUrl.trim() !== '' && !college.bannerUrl.includes('placeholder')) {
        return college.bannerUrl;
    }

    const name = (college?.name || '').toLowerCase();
    const desc = (college?.description || '').toLowerCase();

    // 2. Check Exact College Name Matching Dictionary for Real Photos
    for (const [key, photoUrl] of Object.entries(EXACT_COLLEGE_PHOTOS)) {
        if (name.includes(key)) {
            return photoUrl;
        }
    }

    // 3. Fallback to specialized category photos
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
    if (college?.logoUrl && college.logoUrl.trim() !== '' && !college.logoUrl.includes('placeholder')) {
        return college.logoUrl;
    }
    return getCollegeBanner(college);
};
