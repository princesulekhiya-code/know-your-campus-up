import { Helmet } from 'react-helmet-async';
import PropTypes from 'prop-types';

const SEO = ({
    title = 'Know Your Campus - Find Best Colleges in India',
    description = 'Discover 500+ top colleges in India. Compare fees, check cutoffs, read reviews, and apply for admissions. Find engineering, medical, MBA, and other courses.',
    keywords = 'colleges in India, engineering colleges, medical colleges, MBA colleges, college admission, college fees, cutoff marks',
    ogImage = 'https://knowyourcampus.com/og-image.jpg',
    url = 'https://knowyourcampus.com',
    type = 'website'
}) => {
    const fullTitle = title.includes('Know Your Campus') ? title : `${title} | Know Your Campus`;

    return (
        <Helmet>
            {/* Primary Meta Tags */}
            <title>{fullTitle}</title>
            <meta name="title" content={fullTitle} />
            <meta name="description" content={description} />
            <meta name="keywords" content={keywords} />

            {/* Canonical URL */}
            <link rel="canonical" href={url} />

            {/* Open Graph / Facebook */}
            <meta property="og:type" content={type} />
            <meta property="og:url" content={url} />
            <meta property="og:title" content={fullTitle} />
            <meta property="og:description" content={description} />
            <meta property="og:image" content={ogImage} />

            {/* Twitter */}
            <meta name="twitter:card" content="summary_large_image" />
            <meta name="twitter:url" content={url} />
            <meta name="twitter:title" content={fullTitle} />
            <meta name="twitter:description" content={description} />
            <meta name="twitter:image" content={ogImage} />
        </Helmet>
    );
};

SEO.propTypes = {
    title: PropTypes.string,
    description: PropTypes.string,
    keywords: PropTypes.string,
    ogImage: PropTypes.string,
    url: PropTypes.string,
    type: PropTypes.string
};

export default SEO;
