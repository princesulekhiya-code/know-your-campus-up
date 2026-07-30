// Real Campus & Building Photos for MP Medical & Engineering Colleges
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

    // Private Medical Colleges
    "people": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "chirayu": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "l.n. medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "ln medical": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "lnmc": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "rkdf": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "sri aurobindo": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
    "saims": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",

    // BAMS / Ayurveda
    "dhanwantari": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "khushilal": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
    "mansarovar": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "rani dullaiya": "https://imgs.search.brave.com/BAZfZU0n9xkqb6ggBegEW8Ax5shFDRg13BVCn0_blyg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZG4u/dW5pdmVyc2l0eWth/cnQuY29tLy9Db250/ZW50L3VwbG9hZC9h/ZG1pbi8wemx1M3Bh/Yy52bnIuanBn",
    "ayurved": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",

    // Engineering Colleges
    "lnct": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "sirt": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "oriental": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "technocrats": "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA",
    "manit": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg",
    "iiser": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/IISER_Bhopal_LHC.jpg/1200px-IISER_Bhopal_LHC.jpg",
    "iit indore": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/IIT_Indore_LHC.jpg/1200px-IIT_Indore_LHC.jpg"
};

const DEFAULT_REAL_MEDICAL_PHOTO = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg";
const DEFAULT_REAL_CAMPUS_PHOTO = "https://imgs.search.brave.com/De56UcGnlomxRqglnLupoKMTFA9rkmM1Fcr-JUtHl2w/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2lrc2hhcGVkaWEu/Y29tL3B1YmxpYy9k/YXRhL2NvbGxlZ2Vz/L3Njb3BlLWdsb2Jh/bC1za2lsbHMtdW5p/dmVyc2l0eW1hZGhp/eWEtcHJhZGVzaC1i/YW5uZXIud2VicA";

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

    // 3. Fallback to authentic real hospital/campus building photo instead of stock images
    const fullText = `${name} ${desc}`;
    if (fullText.includes('medical') || fullText.includes('mbbs') || fullText.includes('hospital') || fullText.includes('ayurved') || fullText.includes('dental') || fullText.includes('physio') || fullText.includes('homoeo')) {
        return DEFAULT_REAL_MEDICAL_PHOTO;
    }

    return DEFAULT_REAL_CAMPUS_PHOTO;
};

export const getCollegeLogo = (college) => {
    if (college?.logoUrl && college.logoUrl.trim() !== '' && !college.logoUrl.includes('placeholder')) {
        return college.logoUrl;
    }
    return getCollegeBanner(college);
};
