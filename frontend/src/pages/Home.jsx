import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { FiSearch, FiAward, FiUsers, FiTrendingUp, FiCheckCircle } from 'react-icons/fi';
import CollegeCard from '../components/CollegeCard';
import AnimatedCounter from '../components/AnimatedCounter';
import LoadingSpinner from '../components/LoadingSpinner';
import EnhancedSearch from '../components/EnhancedSearch';
import TopRecruiters from '../components/TopRecruiters';
import Testimonials from '../components/Testimonials';
import BlogPreview from '../components/BlogPreview';
import Newsletter from '../components/Newsletter';
import StreamCategory from '../components/StreamCategory';
import StreamCategory from '../components/StreamCategory';
import HowItWorks from '../components/HowItWorks';
import collegeService from '../services/collegeService';
import trackPageVisit from '../utils/tracking';

const Home = () => {
    const [featuredColleges, setFeaturedColleges] = useState([]);
    const [loading, setLoading] = useState(true);
    const [stats] = useState({
        totalColleges: '500+',
        totalCourses: '2000+',
        students: '50,000+',
        successRate: '95%',
    });

    useEffect(() => {
        trackPageVisit('/', 'Home');

        const loadFeaturedColleges = async () => {
            try {
                const response = await collegeService.getAll({ admissionOpen: true });
                setFeaturedColleges(response.data.slice(0, 6));
            } catch (error) {
                console.error('Failed to load colleges:', error);
            } finally {
                setLoading(false);
            }
        };

        loadFeaturedColleges();
    }, []);

    return (
        <div className="animate-fade-in">
            {/* Hero Section */}
            <section className="relative bg-gradient-to-r from-action-600 via-action-700 to-action-800 text-white py-20">
                <div className="absolute inset-0 bg-black/20"></div>
                <div className="container mx-auto px-4 relative z-10">
                    <div className="max-w-4xl mx-auto text-center">
                        <h1 className="text-5xl md:text-6xl font-bold mb-6 animate-slide-up text-white">
                            Find Your Dream College
                        </h1>
                        <p className="text-xl md:text-2xl mb-8 text-white/95">
                            Discover, Compare, and Apply to India's Top Colleges
                        </p>

                        {/* Search Bar */}
                        <EnhancedSearch />

                        {/* Quick Links */}
                        <div className="flex flex-wrap justify-center gap-4">
                            <Link to="/colleges?type=GOVERNMENT" className="px-6 py-2 bg-white/20 hover:bg-white/30 rounded-full backdrop-blur-sm transition text-white font-medium">
                                Government Colleges
                            </Link>
                            <Link to="/colleges?type=PRIVATE" className="px-6 py-2 bg-white/20 hover:bg-white/30 rounded-full backdrop-blur-sm transition text-white font-medium">
                                Private Colleges
                            </Link>
                            <Link to="/colleges?naacRating=A%2B%2B" className="px-6 py-2 bg-white/20 hover:bg-white/30 rounded-full backdrop-blur-sm transition text-white font-medium">
                                Top Rated
                            </Link>
                        </div>
                    </div>
                </div>
            </section>

            {/* Stats Section - Animated */}
            <section className="py-16 bg-white dark:bg-brand-800 border-b border-brand-200 dark:border-brand-700">
                <div className="container mx-auto px-4">
                    <div className="grid grid-cols-2 md:grid-cols-4 gap-8">
                        {[
                            { icon: FiAward, value: stats.totalColleges, label: 'Colleges Listed', color: 'from-action-500 to-action-600', delay: 0 },
                            { icon: FiSearch, value: stats.totalCourses, label: 'Courses Available', color: 'from-action-500 to-action-600', delay: 0.1 },
                            { icon: FiUsers, value: stats.students, label: 'Students Helped', color: 'from-green-500 to-green-600', delay: 0.2 },
                            { icon: FiTrendingUp, value: stats.successRate, label: 'Success Rate', color: 'from-yellow-500 to-yellow-600', delay: 0.3, suffix: '%' }
                        ].map((stat, index) => (
                            <motion.div
                                key={index}
                                initial={{ opacity: 0, y: 30 }}
                                whileInView={{ opacity: 1, y: 0 }}
                                viewport={{ once: true }}
                                transition={{ duration: 0.5, delay: stat.delay }}
                                whileHover={{ y: -5 }}
                                className="text-center group cursor-pointer"
                            >
                                <motion.div
                                    className={`w-20 h-20 bg-gradient-to-br ${stat.color} rounded-full flex items-center justify-center mx-auto mb-4 shadow-lg group-hover:shadow-xl transition-shadow duration-300`}
                                    whileHover={{ scale: 1.1, rotate: 5 }}
                                    transition={{ type: 'spring', stiffness: 300 }}
                                >
                                    <stat.icon className="w-10 h-10 text-white" />
                                </motion.div>
                                <h3 className="text-4xl font-bold text-brand-900 dark:text-white mb-2">
                                    <AnimatedCounter end={parseInt(stat.value)} suffix={stat.suffix || '+'} />
                                </h3>
                                <p className="text-brand-600 dark:text-brand-400 font-medium">{stat.label}</p>
                            </motion.div>
                        ))}
                    </div>
                </div>
            </section>

            {/* Stream Categories */}
            <StreamCategory />

            {/* How It Works */}
            <HowItWorks />

            {/* Featured Colleges */}
            <section className="py-16 bg-brand-50 dark:bg-brand-900">
                <div className="container mx-auto px-4">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold text-brand-900 dark:text-white mb-4">
                            Featured Colleges
                        </h2>
                        <p className="text-xl text-brand-600 dark:text-brand-400">
                            Explore top colleges with admissions open
                        </p>
                    </div>

                    {loading ? (
                        <LoadingSpinner />
                    ) : (
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 mb-8">
                            {featuredColleges.map((college) => (
                                <CollegeCard key={college.id} college={college} />
                            ))}
                        </div>
                    )}

                    <div className="text-center">
                        <Link to="/colleges" className="btn-primary inline-block">
                            View All Colleges
                        </Link>
                    </div>
                </div>
            </section>

            {/* Top Recruiters Section */}
            <TopRecruiters />

            {/* Testimonials Section */}
            <Testimonials />

            {/* Blog Preview Section */}
            <BlogPreview />

            {/* Newsletter Section */}
            <Newsletter />

            {/* Why Choose Us */}
            <section className="py-16 bg-white dark:bg-gray-800">
                <div className="container mx-auto px-4">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold text-gray-900 dark:text-white mb-4">
                            Why Choose Know Your Campus?
                        </h2>
                    </div>

                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
                        {[
                            { icon: FiCheckCircle, title: 'Verified Information', desc: 'All college data is verified and up-to-date' },
                            { icon: FiSearch, title: 'Easy Search', desc: 'Find colleges by location, course, or fees' },
                            { icon: FiAward, title: 'Compare Colleges', desc: 'Side-by-side comparison of colleges' },
                            { icon: FiUsers, title: 'Expert Guidance', desc: 'Get personalized counselling support' },
                        ].map((feature, index) => (
                            <div key={index} className="text-center">
                                <div className="w-20 h-20 bg-gradient-to-br from-primary-500 to-secondary-500 rounded-full flex items-center justify-center mx-auto mb-4">
                                    <feature.icon className="w-10 h-10 text-white" />
                                </div>
                                <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-2">{feature.title}</h3>
                                <p className="text-gray-600 dark:text-gray-400">{feature.desc}</p>
                            </div>
                        ))}
                    </div>
                </div>
            </section>

            {/* YouTube Section */}
            <section className="py-16 bg-gray-50 dark:bg-gray-900">
                <div className="container mx-auto px-4">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold text-gray-900 dark:text-white mb-4">
                            Watch Our Latest Videos
                        </h2>
                        <p className="text-xl text-gray-600 dark:text-gray-400 mb-4">
                            Subscribe to our YouTube channel for college reviews and admission tips
                        </p>
                        <a
                            href="https://youtube.com/@princesulekhiya"
                            target="_blank"
                            rel="noopener noreferrer"
                            className="btn-secondary inline-block"
                        >
                            Visit Our YouTube Channel
                        </a>
                    </div>
                </div>
            </section>

            {/* CTA Section */}
            <section className="py-20 bg-gradient-to-r from-action-600 via-action-700 to-action-800 text-white relative overflow-hidden">
                <div className="absolute inset-0 bg-black/20"></div>
                <div className="container mx-auto px-4 text-center relative z-10">
                    <h2 className="text-5xl md:text-6xl font-bold mb-6 leading-tight text-white">
                        Ready to Start Your Journey?
                    </h2>
                    <p className="text-xl md:text-2xl mb-10 text-white/95 max-w-2xl mx-auto">
                        Join thousands of students who have found their perfect college on Know Your Campus!
                    </p>
                    <div className="flex flex-col sm:flex-row justify-center gap-6 max-w-2xl mx-auto">
                        <Link to="/admission" className="px-8 py-4 bg-white text-action-700 font-bold rounded-lg hover:bg-gray-100 shadow-lg hover:shadow-xl transition-all duration-300 transform hover:scale-105 text-lg">
                            Apply Now
                        </Link>
                        <Link to="/contact" className="px-8 py-4 bg-transparent border-2 border-white text-white font-bold rounded-lg hover:bg-white hover:text-action-700 transition-all duration-300 transform hover:scale-105 text-lg">
                            Contact Us
                        </Link>
                    </div>
                </div>
            </section>
        </div>
    );
};

export default Home;
