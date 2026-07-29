import { Helmet } from 'react-helmet-async';
import PropTypes from 'prop-types';

const SEO = ({
    title = 'Top Medical & Engineering Colleges in MP 2026 | MBBS, BAMS, BHMS, BDS, BPT, B.Tech Admissions',
    description = 'Discover top MBBS, BAMS, BHMS, BDS, BPT & B.Tech colleges in Bhopal, Indore, Jabalpur & all MP cities. Compare fees, NEET cutoffs, seat matrix, student reviews & get admission support on Know Your Campus.',
    keywords = 'top mbbs private college bhopal, top bams college bhopal, top bhms college bhopal, top bds college bhopal, top bpt college bhopal, top btech private college bhopal, medical colleges in mp, ayurvedic colleges in mp, dental colleges in mp, physiotherapy colleges in mp, homeopathy colleges bhopal, peoples medical college bhopal fees, chirayu medical college admission, ln medical college bhopal, rkdf medical college bhopal mbbs, government medical college jabalpur, grmc gwalior admission, bams colleges in ujjain, neet ug cutoff mp, mp neet counselling, know your campus',
    ogImage = 'https://knowyourcampus.in/logo.jpg',
    url = 'https://knowyourcampus.in',
    type = 'website',
    schema = null,
    college = null
}) => {
    const fullTitle = title.includes('Know Your Campus') ? title : `${title} | Know Your Campus`;

    // Generate college-specific Schema.org structured data
    const generateCollegeSchema = () => {
        if (!college) return null;
        return {
            "@context": "https://schema.org",
            "@type": "CollegeOrUniversity",
            "name": college.name,
            "description": college.description || `${college.name} is a ${college.type?.toLowerCase()} college in ${college.city}, ${college.state}. Get details about admission, fees, courses, cutoffs and seat matrix.`,
            "url": college.website || `https://knowyourcampus.in/colleges/${college.id}`,
            "address": {
                "@type": "PostalAddress",
                "streetAddress": college.address,
                "addressLocality": college.city,
                "addressRegion": college.state,
                "postalCode": college.pincode,
                "addressCountry": "IN"
            },
            "telephone": "+91-9009536046",
            "email": college.email,
            "foundingDate": college.establishedYear ? `${college.establishedYear}` : undefined,
            "image": college.bannerUrl,
            "logo": college.logoUrl,
            "sameAs": college.website ? [college.website] : [],
            "aggregateRating": college.averageRating ? {
                "@type": "AggregateRating",
                "ratingValue": college.averageRating,
                "reviewCount": college.totalReviews || 1
            } : undefined
        };
    };

    // Default comprehensive FAQ schema for medical colleges
    const defaultFaqSchema = {
        "@context": "https://schema.org",
        "@type": "FAQPage",
        "mainEntity": [
            {
                "@type": "Question",
                "name": "Which are the top private MBBS colleges in Bhopal, MP?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top private MBBS colleges in Bhopal include People's College of Medical Sciences (PCMS), Chirayu Medical College, L.N. Medical College (LNMC), and RKDF Medical College. All offer NEET UG based admission with fees ranging from ₹9-12 lakhs per year. Compare detailed fees, seat matrix and cutoffs on Know Your Campus."
                }
            },
            {
                "@type": "Question",
                "name": "Which are the top BAMS (Ayurveda) colleges in Bhopal and MP?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top BAMS colleges in MP include Govt. Autonomous Dhanwantari Ayurved College Ujjain (oldest), Pt. Khushilal Sharma Govt. Ayurveda College Bhopal, Mansarovar Ayurvedic Medical College Bhopal, Rani Dullaiya Smriti Ayurveda College, and LN Ayurved College. Government BAMS fees are ₹22,000-32,000/year while private colleges charge ₹1.5-3 lakhs/year."
                }
            },
            {
                "@type": "Question",
                "name": "Which are the best BHMS (Homeopathy) colleges in MP?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top BHMS colleges in MP include Government Homoeopathic Medical College Bhopal (only government BHMS college), Nehru Homoeopathic Medical College Bhopal, Mahatma Gandhi Homoeopathic College Jabalpur, and Sarvepalli Radhakrishnan Homoeopathic College Indore. Govt. BHMS fees are ₹19,000/year."
                }
            },
            {
                "@type": "Question",
                "name": "Which are the top BDS (Dental) colleges in MP?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top BDS colleges in MP include Government College of Dentistry Indore (best government dental college), People's Dental Academy Bhopal, RKDF Dental College Bhopal, Sri Aurobindo College of Dentistry Indore, and Modern Dental College Indore. Govt. BDS fees are ₹52,000/year while private ranges ₹4-5.5 lakhs/year."
                }
            },
            {
                "@type": "Question",
                "name": "Which are the best BPT (Physiotherapy) colleges in MP?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top BPT colleges in MP include Government College of Physiotherapy Bhopal (only govt. BPT college), People's College of Physiotherapy Bhopal, Index College of Physiotherapy Indore, and Sri Aurobindo College of Physiotherapy Indore. Government BPT fees are ₹27,000/year."
                }
            },
            {
                "@type": "Question",
                "name": "What is the NEET UG cutoff for government medical colleges in MP?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "NEET UG cutoffs for government MBBS colleges in MP (2023-24): AIIMS Bhopal - 99.5+ percentile, Gandhi Medical College Bhopal - 98%, NSCBMC Jabalpur - 97.5%, GRMC Gwalior - 97.8%, SS Medical College Rewa - 96.5%. For BAMS colleges, cutoff ranges from 78-85 percentile. Check detailed cutoffs on Know Your Campus."
                }
            },
            {
                "@type": "Question",
                "name": "What is the fee structure of People's Medical College Bhopal?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "People's College of Medical Sciences (PCMS) Bhopal MBBS fees are approximately ₹12.4 lakhs per year (tuition ₹11 lakhs + hostel ₹80,000 + other charges). Total 5-year MBBS cost is around ₹62 lakhs. Check detailed fee breakup and compare with other colleges on Know Your Campus."
                }
            },
            {
                "@type": "Question",
                "name": "What is the RKDF Medical College Bhopal MBBS admission process?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "RKDF Medical College Bhopal MBBS admission is through NEET UG counselling conducted by DMER MP. The college has 100 MBBS seats with fees around ₹10 lakhs per year. NEET cutoff is approximately 85 percentile. The college has a 500-bed attached hospital for clinical training."
                }
            },
            {
                "@type": "Question",
                "name": "Which is the top private B.Tech college in Bhopal for direct admission?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top private engineering (B.Tech) colleges in Bhopal include LNCT Bhopal, SIRT Bhopal, Oriental Institute of Science & Technology, TIT Bhopal, and IES College of Technology. They offer JEE Main and DTE MP counselling based admissions with fees ranging from ₹60,000-1.5 lakhs per year."
                }
            }
        ]
    };

    // Generate BreadcrumbList schema for better Google navigation
    const breadcrumbSchema = {
        "@context": "https://schema.org",
        "@type": "BreadcrumbList",
        "itemListElement": [
            {
                "@type": "ListItem",
                "position": 1,
                "name": "Home",
                "item": "https://knowyourcampus.in"
            },
            {
                "@type": "ListItem",
                "position": 2,
                "name": "Colleges",
                "item": "https://knowyourcampus.in/colleges"
            }
        ]
    };

    // Combine schemas
    const collegeSchema = generateCollegeSchema();
    const allSchemas = [];
    if (schema) {
        allSchemas.push(schema);
    } else {
        allSchemas.push(defaultFaqSchema);
    }
    if (collegeSchema) {
        allSchemas.push(collegeSchema);
    }
    allSchemas.push(breadcrumbSchema);

    return (
        <Helmet>
            {/* Primary Meta Tags */}
            <title>{fullTitle}</title>
            <meta name="title" content={fullTitle} />
            <meta name="description" content={description} />
            <meta name="keywords" content={keywords} />
            <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1" />

            {/* Language Alternate for Hindi */}
            <meta name="language" content="English, Hindi" />
            <meta httpEquiv="content-language" content="en-IN, hi-IN" />

            {/* Canonical URL */}
            <link rel="canonical" href={url} />

            {/* Open Graph / Facebook */}
            <meta property="og:type" content={type} />
            <meta property="og:url" content={url} />
            <meta property="og:title" content={fullTitle} />
            <meta property="og:description" content={description} />
            <meta property="og:image" content={ogImage} />
            <meta property="og:site_name" content="Know Your Campus" />
            <meta property="og:locale" content="en_IN" />

            {/* Twitter */}
            <meta name="twitter:card" content="summary_large_image" />
            <meta name="twitter:url" content={url} />
            <meta name="twitter:title" content={fullTitle} />
            <meta name="twitter:description" content={description} />
            <meta name="twitter:image" content={ogImage} />

            {/* JSON-LD Structured Data Schemas */}
            {allSchemas.map((s, i) => (
                <script key={i} type="application/ld+json">
                    {JSON.stringify(s)}
                </script>
            ))}
        </Helmet>
    );
};

SEO.propTypes = {
    title: PropTypes.string,
    description: PropTypes.string,
    keywords: PropTypes.string,
    ogImage: PropTypes.string,
    url: PropTypes.string,
    type: PropTypes.string,
    schema: PropTypes.object,
    college: PropTypes.object
};

export default SEO;
