import { motion } from 'framer-motion';
import { FiCalendar, FiArrowRight, FiTrendingUp } from 'react-icons/fi';
import { Link, useNavigate } from 'react-router-dom';

const BlogPreview = () => {
    const navigate = useNavigate();

    const blogPosts = [
        {
            id: 1,
            title: "Top Private B.Tech Colleges in Bhopal 2026: Direct Admission, Fees & Placements",
            excerpt: "Explore best private engineering colleges in Bhopal like SIRT, LNCT, Oriental, and TIT with highest placement packages, fee structure, and direct admission guide...",
            category: "B.Tech 2026",
            date: "Feb 16, 2026",
            readTime: "7 min read",
            image: "https://images.unsplash.com/photo-1562774053-701939374585?w=800&auto=format&fit=crop&q=80",
            trending: true,
            targetCategory: "Engineering"
        },
        {
            id: 2,
            title: "Top MBBS Colleges in Bhopal 2026: Govt & Private Fees, Seats & NEET Cutoff",
            excerpt: "Complete guide to top medical colleges in Bhopal including AIIMS Bhopal, GMC Bhopal, LNMC, Peoples, and Chirayu with fee structure and seat matrix...",
            category: "MBBS",
            date: "Feb 15, 2026",
            readTime: "6 min read",
            image: "https://images.unsplash.com/photo-1551076805-e1869033e561?w=800&auto=format&fit=crop&q=80",
            trending: true,
            targetCategory: "Medical"
        },
        {
            id: 3,
            title: "Top Private BAMS Colleges in Bhopal 2026: Admission & Fees Guide",
            excerpt: "Discover best private BAMS (Ayurvedic) colleges in Bhopal with NCISM approval, fee details, hospital clinical exposure, and NEET cutoff ranks...",
            category: "BAMS",
            date: "Feb 14, 2026",
            readTime: "5 min read",
            image: "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800&auto=format&fit=crop&q=80",
            trending: true,
            targetCategory: "Medical"
        },
        {
            id: 4,
            title: "Best Private BDS (Dental) Colleges in Bhopal 2026: Seat Matrix & Placement",
            excerpt: "Explore top dental colleges in Bhopal for BDS degree including Peoples Dental Academy, Mansarovar Dental College with DCI recognition and fee structures...",
            category: "BDS",
            date: "Feb 12, 2026",
            readTime: "5 min read",
            image: "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=800&auto=format&fit=crop&q=80",
            trending: false,
            targetCategory: "Medical"
        },
        {
            id: 5,
            title: "MP DTE & DME Counselling 2026: B.Tech & NEET UG Choice Filling Guide",
            excerpt: "Step-by-step registration guide for MP DTE Engineering and MP DME NEET counselling for state quota seats in Govt and Private colleges in MP...",
            category: "Admissions 2026",
            date: "Feb 10, 2026",
            readTime: "7 min read",
            image: "https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=800&auto=format&fit=crop&q=80",
            trending: true,
            targetCategory: "General"
        },
        {
            id: 6,
            title: "Top Paramedical, Nursing & Pharmacy Colleges in Bhopal 2026",
            excerpt: "Comprehensive guide to B.Sc Nursing, B.Pharm, and Paramedical courses in Bhopal's top private colleges with eligibility, fees, and placement support...",
            category: "Nursing & Pharmacy",
            date: "Feb 6, 2026",
            readTime: "5 min read",
            image: "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=800&auto=format&fit=crop&q=80",
            trending: false,
            targetCategory: "Medical"
        }
    ];

    const defaultFallbackImage = "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=800&auto=format&fit=crop&q=80";

    const handleCardClick = () => {
        navigate('/admission');
    };

    return (
        <section className="py-20 bg-white dark:bg-brand-900">
            <div className="container mx-auto px-4">
                {/* Header */}
                <motion.div
                    initial={{ opacity: 0, y: 20 }}
                    whileInView={{ opacity: 1, y: 0 }}
                    viewport={{ once: true }}
                    className="text-center mb-12"
                >
                    <h2 className="text-4xl md:text-5xl font-bold text-brand-900 dark:text-white mb-4">
                        Latest Updates & Admissions 2026
                    </h2>
                    <p className="text-xl text-brand-600 dark:text-brand-400 max-w-2xl mx-auto">
                        Stay updated with MP DTE & DME Counselling, Top Private B.Tech, MBBS, BAMS & BDS Colleges in Bhopal with direct admission support
                    </p>
                </motion.div>

                {/* Blog Grid */}
                <div className="grid grid-cols-1 md:grid-cols-3 gap-8 mb-8">
                    {blogPosts.map((post, index) => (
                        <motion.article
                            key={post.id}
                            initial={{ opacity: 0, y: 30 }}
                            whileInView={{ opacity: 1, y: 0 }}
                            viewport={{ once: true }}
                            transition={{ duration: 0.5, delay: index * 0.1 }}
                            className="group cursor-pointer"
                            onClick={handleCardClick}
                        >
                            <div className="bg-white dark:bg-brand-800 rounded-2xl overflow-hidden shadow-soft hover:shadow-soft-lg transition-all duration-300 border border-brand-200 dark:border-brand-700 h-full flex flex-col justify-between">
                                <div>
                                    {/* Image */}
                                    <div className="relative overflow-hidden h-48 bg-brand-100 dark:bg-brand-800">
                                        <img
                                            src={post.image}
                                            alt={post.title}
                                            onError={(e) => {
                                                e.target.onerror = null;
                                                e.target.src = defaultFallbackImage;
                                            }}
                                            className="w-full h-full object-cover group-hover:scale-110 transition-transform duration-500"
                                        />
                                        {post.trending && (
                                            <div className="absolute top-4 right-4 px-3 py-1 bg-red-500 text-white text-xs font-bold rounded-full flex items-center space-x-1 shadow-md">
                                                <FiTrendingUp className="w-3 h-3" />
                                                <span>Trending</span>
                                            </div>
                                        )}
                                        <div className="absolute top-4 left-4 px-3 py-1 bg-action-600 text-white text-xs font-semibold rounded-full shadow-md">
                                            {post.category}
                                        </div>
                                    </div>

                                    {/* Content */}
                                    <div className="p-6">
                                        <div className="flex items-center space-x-4 text-xs text-brand-500 dark:text-brand-400 mb-3">
                                            <span className="flex items-center space-x-1">
                                                <FiCalendar className="w-3 h-3" />
                                                <span>{post.date}</span>
                                            </span>
                                            <span>•</span>
                                            <span>{post.readTime}</span>
                                        </div>

                                        <h3 className="text-lg font-bold text-brand-900 dark:text-white mb-2 group-hover:text-action-600 dark:group-hover:text-action-400 transition-colors line-clamp-2">
                                            {post.title}
                                        </h3>

                                        <p className="text-sm text-brand-600 dark:text-brand-400 mb-4 line-clamp-3">
                                            {post.excerpt}
                                        </p>
                                    </div>
                                </div>

                                <div className="px-6 pb-6 pt-0">
                                    <div className="flex items-center text-action-600 dark:text-action-400 font-semibold text-sm group-hover:translate-x-2 transition-transform">
                                        <span>Apply / Direct Contact Now</span>
                                        <FiArrowRight className="w-4 h-4 ml-2" />
                                    </div>
                                </div>
                            </div>
                        </motion.article>
                    ))}
                </div>

                {/* View All Button */}
                <motion.div
                    initial={{ opacity: 0 }}
                    whileInView={{ opacity: 1 }}
                    viewport={{ once: true }}
                    className="text-center mt-10"
                >
                    <Link to="/colleges" className="btn-primary inline-block">
                        Explore All Bhopal Private Colleges (B.Tech & Medical)
                    </Link>
                </motion.div>
            </div>
        </section>
    );
};

export default BlogPreview;


