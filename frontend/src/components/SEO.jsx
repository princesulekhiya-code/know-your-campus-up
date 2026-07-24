import { Helmet } from 'react-helmet-async';
import PropTypes from 'prop-types';

const SEO = ({
    title = 'Top Private Colleges in MP & Bhopal 2026 | BAMS, MBBS, BDS, B.Tech Admissions',
    description = 'Discover top private BAMS, MBBS, BDS & B.Tech colleges in Bhopal & MP. Compare fees, NEET cutoffs, seat matrix, student reviews & get direct admission support on Know Your Campus.',
    keywords = 'top bams private college bhopal, top mbbs private college bhopal, top bds private college bhopal, top btech private college bhopal, top private college mp, best private medical colleges in bhopal, top engineering colleges in bhopal, neet ug cutoff bhopal, mp dte counselling, direct admission btech bhopal, private ayurvedic colleges in mp, lnct bhopal, sirt bhopal, peoples medical college bhopal, chirayu medical college, know your campus',
    ogImage = 'https://knowyourcampus.in/logo.jpg',
    url = 'https://knowyourcampus.in',
    type = 'website',
    schema = null
}) => {
    const fullTitle = title.includes('Know Your Campus') ? title : `${title} | Know Your Campus`;

    const defaultFaqSchema = {
        "@context": "https://schema.org",
        "@type": "FAQPage",
        "mainEntity": [
            {
                "@type": "Question",
                "name": "Which is the top private BAMS college in Bhopal?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top private BAMS (Ayurvedic) colleges in Bhopal include Pandit Shivshaktilal Ayurvedic College, LN Ayurved College, and Peoples College of Ayurvedic Studies offering NCISM approved BAMS degree."
                }
            },
            {
                "@type": "Question",
                "name": "Which is the top private MBBS college in Bhopal?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top private MBBS colleges in Bhopal include LN Medical College (LNMC), Peoples College of Medical Sciences (PCMS), and Chirayu Medical College with recognized seat matrix and attached multi-specialty teaching hospitals."
                }
            },
            {
                "@type": "Question",
                "name": "Which is the top private B.Tech college in Bhopal for direct admission?",
                "acceptedAnswer": {
                    "@type": "Answer",
                    "text": "Top private engineering (B.Tech) colleges in Bhopal include LNCT Bhopal, SIRT Bhopal, Oriental Institute of Science & Technology, and TIT Bhopal with high placement packages and DTE MP counselling support."
                }
            }
        ]
    };

    return (
        <Helmet>
            {/* Primary Meta Tags */}
            <title>{fullTitle}</title>
            <meta name="title" content={fullTitle} />
            <meta name="description" content={description} />
            <meta name="keywords" content={keywords} />
            <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1" />

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

            {/* JSON-LD FAQ / Structured Data Schema */}
            <script type="application/ld+json">
                {JSON.stringify(schema || defaultFaqSchema)}
            </script>
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
    schema: PropTypes.object
};

export default SEO;

