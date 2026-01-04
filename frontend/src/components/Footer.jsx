import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { FiMail, FiPhone, FiMapPin, FiYoutube, FiTwitter, FiLinkedin, FiFacebook, FiInstagram, FiMessageCircle } from 'react-icons/fi';

const Footer = () => {
    const currentYear = new Date().getFullYear();

    const footerLinks = {
        'Quick Links': [
            { name: 'Home', path: '/' },
            { name: 'Browse Colleges', path: '/colleges' },
            { name: 'Compare Colleges', path: '/compare' },
            { name: 'Apply for Admission', path: '/admission' },
        ],
        'Popular Searches': [
            { name: 'Government Colleges', path: '/colleges?type=GOVERNMENT' },
            { name: 'Private Colleges', path: '/colleges?type=PRIVATE' },
            { name: 'Top Rated (A++)', path: '/colleges?naacRating=A%2B%2B' },
            { name: 'Engineering Colleges', path: '/colleges' },
        ],
    };

    return (
        <footer className="bg-white dark:bg-brand-900 border-t border-brand-200 dark:border-brand-800 mt-auto">
            <div className="container mx-auto px-4 py-12">
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8 mb-8">
                    {/* Brand Section */}
                    <motion.div
                        initial={{ opacity: 0, y: 20 }}
                        whileInView={{ opacity: 1, y: 0 }}
                        viewport={{ once: true }}
                        transition={{ duration: 0.5 }}
                    >
                        <div className="flex items-center space-x-3 mb-4">
                            <img
                                src="/logo.jpg"
                                alt="Know Your Campus Logo"
                                className="h-12 w-auto object-contain"
                            />
                            <span className="text-xl font-bold text-brand-900 dark:text-white">
                                Know Your Campus
                            </span>
                        </div>
                        <p className="text-sm text-brand-600 dark:text-brand-400 mb-4 leading-relaxed">
                            India's premier education discovery and admission platform. Find your dream college today.
                        </p>
                        <div className="mb-4 p-3 bg-brand-50 dark:bg-brand-800/50 rounded-lg border border-brand-200 dark:border-brand-700">
                            <p className="text-xs text-brand-500 dark:text-brand-400 mb-1">Managing Director</p>
                            <p className="text-sm font-semibold text-brand-900 dark:text-white">Mr Prince Sulekhiya</p>
                        </div>
                        <div className="flex flex-wrap gap-3">
                            <a href="https://youtube.com/@princesulekhiya" target="_blank" rel="noopener noreferrer"
                                className="p-2 bg-brand-100 dark:bg-brand-800 rounded-lg text-brand-600 dark:text-brand-400 hover:bg-red-50 dark:hover:bg-red-900/20 hover:text-red-600 dark:hover:text-red-400 transition-colors"
                                title="YouTube">
                                <FiYoutube className="w-5 h-5" />
                            </a>
                            <a href="https://www.linkedin.com/in/prince-sulekhiya" target="_blank" rel="noopener noreferrer"
                                className="p-2 bg-brand-100 dark:bg-brand-800 rounded-lg text-brand-600 dark:text-brand-400 hover:bg-blue-50 dark:hover:bg-blue-900/20 hover:text-blue-600 dark:hover:text-blue-400 transition-colors"
                                title="LinkedIn">
                                <FiLinkedin className="w-5 h-5" />
                            </a>
                            <a href="https://www.instagram.com/prince_sulekhiya" target="_blank" rel="noopener noreferrer"
                                className="p-2 bg-brand-100 dark:bg-brand-800 rounded-lg text-brand-600 dark:text-brand-400 hover:bg-pink-50 dark:hover:bg-pink-900/20 hover:text-pink-600 dark:hover:text-pink-400 transition-colors"
                                title="Instagram">
                                <FiInstagram className="w-5 h-5" />
                            </a>
                            <a href="https://www.facebook.com/share/1Br2huspNA/" target="_blank" rel="noopener noreferrer"
                                className="p-2 bg-brand-100 dark:bg-brand-800 rounded-lg text-brand-600 dark:text-brand-400 hover:bg-blue-50 dark:hover:bg-blue-900/20 hover:text-blue-700 dark:hover:text-blue-400 transition-colors"
                                title="Facebook">
                                <FiFacebook className="w-5 h-5" />
                            </a>
                            <a href="https://x.com/PrinceSulekhiya" target="_blank" rel="noopener noreferrer"
                                className="p-2 bg-brand-100 dark:bg-brand-800 rounded-lg text-brand-600 dark:text-brand-400 hover:bg-gray-50 dark:hover:bg-gray-900/20 hover:text-gray-900 dark:hover:text-gray-400 transition-colors"
                                title="X (Twitter)">
                                <FiTwitter className="w-5 h-5" />
                            </a>
                            <a href="https://www.threads.com/@prince_sulekhiya" target="_blank" rel="noopener noreferrer"
                                className="p-2 bg-brand-100 dark:bg-brand-800 rounded-lg text-brand-600 dark:text-brand-400 hover:bg-purple-50 dark:hover:bg-purple-900/20 hover:text-purple-600 dark:hover:text-purple-400 transition-colors"
                                title="Threads">
                                <FiMessageCircle className="w-5 h-5" />
                            </a>
                        </div>

                        {/* Contact Actions - Unified Professional Design */}
                        <div className="mt-4 p-5 bg-gradient-to-br from-brand-50 to-brand-100 dark:from-brand-800/50 dark:to-brand-900/50 rounded-2xl border border-brand-200 dark:border-brand-700 shadow-sm">
                            <p className="text-xs font-semibold text-brand-500 dark:text-brand-400 mb-3 uppercase tracking-wide">Quick Contact</p>
                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
                                {/* WhatsApp Group */}
                                <a href="https://chat.whatsapp.com/DR3H44TzFaeG68R8u12cOp" target="_blank" rel="noopener noreferrer"
                                    className="flex items-center space-x-3 p-3 bg-white dark:bg-brand-800 rounded-xl border border-green-200 dark:border-green-800/50 hover:border-green-400 dark:hover:border-green-600 hover:shadow-md transition-all duration-200 group">
                                    <div className="p-2.5 bg-green-500 rounded-lg group-hover:bg-green-600 transition-colors">
                                        <FiMessageCircle className="w-5 h-5 text-white" />
                                    </div>
                                    <div className="flex-1 min-w-0">
                                        <p className="text-sm font-semibold text-brand-900 dark:text-white">WhatsApp Group</p>
                                        <p className="text-xs text-brand-600 dark:text-brand-400 truncate">Join Community</p>
                                    </div>
                                </a>

                                {/* Call Now */}
                                <a href="tel:9009536046"
                                    className="flex items-center space-x-3 p-3 bg-white dark:bg-brand-800 rounded-xl border border-blue-200 dark:border-blue-800/50 hover:border-blue-400 dark:hover:border-blue-600 hover:shadow-md transition-all duration-200 group">
                                    <div className="p-2.5 bg-blue-500 rounded-lg group-hover:bg-blue-600 transition-colors">
                                        <FiPhone className="w-5 h-5 text-white" />
                                    </div>
                                    <div className="flex-1 min-w-0">
                                        <p className="text-sm font-semibold text-brand-900 dark:text-white">Call Now</p>
                                        <p className="text-xs text-brand-600 dark:text-brand-400 truncate">9009536046</p>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </motion.div>

                    {/* Links Sections */}
                    {Object.entries(footerLinks).map(([title, links], index) => (
                        <motion.div
                            key={title}
                            initial={{ opacity: 0, y: 20 }}
                            whileInView={{ opacity: 1, y: 0 }}
                            viewport={{ once: true }}
                            transition={{ duration: 0.5, delay: index * 0.1 }}
                        >
                            <h3 className="text-sm font-semibold text-brand-900 dark:text-white uppercase tracking-wider mb-4">
                                {title}
                            </h3>
                            <ul className="space-y-2">
                                {links.map((link) => (
                                    <li key={link.path}>
                                        <Link
                                            to={link.path}
                                            className="text-sm text-brand-600 dark:text-brand-400 hover:text-action-600 dark:hover:text-action-400 transition-colors inline-block"
                                        >
                                            {link.name}
                                        </Link>
                                    </li>
                                ))}
                            </ul>
                        </motion.div>
                    ))}

                    {/* Contact Section */}
                    <motion.div
                        initial={{ opacity: 0, y: 20 }}
                        whileInView={{ opacity: 1, y: 0 }}
                        viewport={{ once: true }}
                        transition={{ duration: 0.5, delay: 0.3 }}
                    >
                        <h3 className="text-sm font-semibold text-brand-900 dark:text-white uppercase tracking-wider mb-4">
                            Contact Us
                        </h3>
                        <p className="text-sm font-semibold text-brand-900 dark:text-white mb-3">Mr Prince Sulekhiya</p>
                        <ul className="space-y-3">
                            <li>
                                <a href="tel:9009536046" className="flex items-start space-x-2 text-sm text-brand-600 dark:text-brand-400 hover:text-action-600 dark:hover:text-action-400 transition-colors group">
                                    <FiPhone className="w-4 h-4 mt-0.5 flex-shrink-0 group-hover:scale-110 transition-transform" />
                                    <span className="font-medium">9009536046</span>
                                </a>
                            </li>
                            <li>
                                <a href="mailto:princesulekhiya2004@gmail.com" className="flex items-start space-x-2 text-sm text-brand-600 dark:text-brand-400 hover:text-action-600 dark:hover:text-action-400 transition-colors group">
                                    <FiMail className="w-4 h-4 mt-0.5 flex-shrink-0 group-hover:scale-110 transition-transform" />
                                    <span className="break-all">princesulekhiya2004@gmail.com</span>
                                </a>
                            </li>
                            <li className="flex items-start space-x-2 text-sm text-brand-600 dark:text-brand-400">
                                <FiMapPin className="w-4 h-4 mt-0.5 flex-shrink-0" />
                                <span>India</span>
                            </li>
                        </ul>
                    </motion.div>
                </div>

                {/* Bottom Bar */}
                <div className="pt-8 border-t border-brand-200 dark:border-brand-800">
                    <div className="flex flex-col md:flex-row justify-between items-center space-y-4 md:space-y-0">
                        <p className="text-sm text-brand-500 dark:text-brand-400">
                            © {currentYear} Know Your Campus. All rights reserved.
                        </p>
                        <div className="flex space-x-6">
                            <Link to="/contact" className="text-sm text-brand-500 dark:text-brand-400 hover:text-action-600 dark:hover:text-action-400 transition-colors">
                                Privacy Policy
                            </Link>
                            <Link to="/contact" className="text-sm text-brand-500 dark:text-brand-400 hover:text-action-600 dark:hover:text-action-400 transition-colors">
                                Terms of Service
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    );
};

export default Footer;
