import { motion } from 'framer-motion';
import { FiCalendar, FiArrowRight, FiTrendingUp } from 'react-icons/fi';
import { Link } from 'react-router-dom';

const BlogPreview = () => {
    const blogPosts = [
        {
            id: 1,
            title: "College Admissions 2026: Complete Guide & Important Dates",
            excerpt: "Everything you need to know about college admissions for 2026 including application deadlines, entrance exams, and admission process...",
            category: "Admissions",
            date: "Feb 11, 2026",
            readTime: "7 min read",
            image: "https://images.unsplash.com/photo-1523050854058-8df90110c9f1?w=400&h=250&fit=crop",
            trending: true
        },
        {
            id: 2,
            title: "Top Engineering Colleges in Madhya Pradesh 2026",
            excerpt: "Comprehensive list of best engineering colleges in MP including SIRT Bhopal, IIT Indore, NIT Bhopal with fees, placements, and cutoffs...",
            category: "Rankings",
            date: "Feb 10, 2026",
            readTime: "6 min read",
            image: "https://images.unsplash.com/photo-1541339907198-e08756dedf3f?w=400&h=250&fit=crop",
            trending: true
        },
        {
            id: 3,
            title: "How to Choose the Right College: Expert Tips 2026",
            excerpt: "Learn how to evaluate colleges based on placements, faculty, infrastructure, fees, and location. Make an informed decision for your future...",
            category: "Guides",
            date: "Feb 9, 2026",
            readTime: "5 min read",
            image: "https://images.unsplash.com/photo-1427504494785-3a9ca7044f45?w=400&h=250&fit=crop",
            trending: false
        },
        {
            id: 4,
            title: "JEE Main 2026: Preparation Strategy & Tips",
            excerpt: "Complete preparation guide for JEE Main 2026 including study plan, important topics, mock tests, and time management strategies...",
            category: "Exams",
            date: "Feb 8, 2026",
            readTime: "8 min read",
            image: "https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=400&h=250&fit=crop",
            trending: false
        },
        {
            id: 5,
            title: "Scholarship Opportunities for Students 2026",
            excerpt: "Explore government and private scholarships for engineering, medical, and MBA students in 2026. Learn eligibility criteria and application process...",
            category: "Scholarships",
            date: "Feb 7, 2026",
            readTime: "6 min read",
            image: "https://images.unsplash.com/photo-1532619675605-1ede6c2ed2b0?w=400&h=250&fit=crop",
            trending: false
        },
        {
            id: 6,
            title: "Campus Placement Trends 2026: What to Expect",
            excerpt: "Analysis of latest campus placement trends for 2026, top recruiting sectors, average packages, and career opportunities for graduates...",
            category: "Placements",
            date: "Feb 6, 2026",
            readTime: "7 min read",
            image: "https://images.unsplash.com/photo-1521737711867-e3b97375f902?w=400&h=250&fit=crop",
            trending: true
        }
    ];

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
                        Latest Updates & Guides
                    </h2>
                    <p className="text-xl text-brand-600 dark:text-brand-400 max-w-2xl mx-auto">
                        Stay updated with admission news, exam tips, and college guides
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
                        >
                            <div className="bg-white dark:bg-brand-800 rounded-2xl overflow-hidden shadow-soft hover:shadow-soft-lg transition-all duration-300 border border-brand-200 dark:border-brand-700">
                                {/* Image */}
                                <div className="relative overflow-hidden h-48">
                                    <img
                                        src={post.image}
                                        alt={post.title}
                                        className="w-full h-full object-cover group-hover:scale-110 transition-transform duration-500"
                                    />
                                    {post.trending && (
                                        <div className="absolute top-4 right-4 px-3 py-1 bg-red-500 text-white text-xs font-bold rounded-full flex items-center space-x-1">
                                            <FiTrendingUp className="w-3 h-3" />
                                            <span>Trending</span>
                                        </div>
                                    )}
                                    <div className="absolute top-4 left-4 px-3 py-1 bg-action-600 text-white text-xs font-semibold rounded-full">
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

                                    <p className="text-sm text-brand-600 dark:text-brand-400 mb-4 line-clamp-2">
                                        {post.excerpt}
                                    </p>

                                    <div className="flex items-center text-action-600 dark:text-action-400 font-semibold text-sm group-hover:translate-x-2 transition-transform">
                                        <span>Read More</span>
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
                    className="text-center"
                >
                    <Link to="/blog" className="btn-outline inline-block">
                        View All Articles
                    </Link>
                </motion.div>
            </div>
        </section>
    );
};

export default BlogPreview;
