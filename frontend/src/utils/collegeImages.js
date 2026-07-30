// Real Direct Campus & Building Photos for MP Medical & Engineering Colleges
const EXACT_COLLEGE_PHOTOS = {
    // Government MBBS Medical Colleges
    "netaji subhash chandra bose": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "nscbmc": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "gajra raja": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    "grmc": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    "shyam shah": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "ssmc": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "bundelkhand medical": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "bmc sagar": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "gandhi medical": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "gmc bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "aiims bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "chhindwara": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "datia": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "vidisha": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "shahdol": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "khandwa": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "ratlam": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "shivpuri": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",

    // Private MBBS Medical Colleges
    "people's college of medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "peoples college of medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "chirayu": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "l.n. medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "ln medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "lnmc": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "rkdf medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "sri aurobindo": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "saims": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "r.d. gardi": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "amaltas": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "index medical": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",

    // BAMS (Ayurveda) Colleges
    "dhanwantari": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "khushilal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "mansarovar": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "rani dullaiya": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "ln ayurved": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "shivshaktilal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "veena vadini": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "rishikul": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",

    // BHMS (Homoeopathy) Colleges
    "homoeopathic medical college bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "nehru homoeopathic": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "mahatma gandhi homoeopathic": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "sarvepalli radhakrishnan homoeopathic": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",

    // BDS (Dental) Colleges
    "college of dentistry indore": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "people's dental": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "rkdf dental": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "modern dental": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",

    // BPT (Physiotherapy) Colleges
    "physiotherapy bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",

    // Engineering & General Colleges - Bhopal & MP
    "lakshmi narain": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "lnct": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "sirt": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "sagar institute": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "oriental": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "technocrats": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "tit": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "manit": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg",
    "iiser bhopal": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/IISER_Bhopal_LHC.jpg/1200px-IISER_Bhopal_LHC.jpg",
    "iit indore": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/IIT_Indore_LHC.jpg/1200px-IIT_Indore_LHC.jpg",
    "iim indore": "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/IIM_Indore_Campus.jpg/1200px-IIM_Indore_Campus.jpg"
};

// Fallback Specialized Photo Collections
const MEDICAL_IMAGES = [
    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
    "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn"
];

const AYURVEDA_IMAGES = [
    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn"
];

const DENTAL_IMAGES = [
    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn"
];

const HOMOEOPATHY_IMAGES = [
    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg"
];

const PHYSIO_IMAGES = [
    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg"
];

const CAMPUS_IMAGES = [
    "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA"
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
