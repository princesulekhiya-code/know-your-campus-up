import { useState, useEffect } from 'react';
import { Link, useLocation } from 'react-router-dom';
import { FiSun, FiMoon, FiMenu, FiX, FiPhone, FiMail } from 'react-icons/fi';
import { motion, AnimatePresence } from 'framer-motion';
import { useTheme } from '../context/ThemeContext';
import { useAuth } from '../context/AuthContext';

const Navbar = () => {
    const [isScrolled, setIsScrolled] = useState(false);
    const [isMobileMenuOpen, setIsMobileMenuOpen] = useState(false);
    const { isDark, toggleTheme } = useTheme();
    const { isAuthenticated, logout } = useAuth();
    const location = useLocation();

    useEffect(() => {
        const handleScroll = () => {
            setIsScrolled(window.scrollY > 20);
        };
        window.addEventListener('scroll', handleScroll);
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);

    const navLinks = [
        { name: 'Home', path: '/' },
        { name: 'Colleges', path: '/colleges' },
        { name: 'Compare', path: '/compare' },
        { name: 'Admission', path: '/admission' },
        { name: 'Contact', path: '/contact' },
    ];

    const isActive = (path) => location.pathname === path;

    return (
        <motion.nav
            initial={{ y: -100 }}
            animate={{ y: 0 }}
            className={`sticky top-0 left-0 right-0 z-50 transition-all duration-300 ${isScrolled
                ? 'backdrop-glass shadow-soft-lg'
                : 'bg-transparent'
                }`}
        >
            <div className="container mx-auto px-4">
                <div className="flex items-center justify-between h-16">
                    {/* Logo */}
                    <Link to="/" className="flex items-center space-x-3 group">
                        <motion.img
                            src="/logo.jpg"
                            alt="Know Your Campus Logo"
                            className="h-12 w-auto object-contain"
                            whileHover={{ scale: 1.05 }}
                            whileTap={{ scale: 0.95 }}
                        />
                        <span className="text-xl font-bold text-brand-900 dark:text-white hidden sm:block">
                            Know Your Campus
                        </span>
                    </Link>

                    {/* Desktop Navigation */}
                    <div className="hidden lg:flex items-center space-x-1">
                        {navLinks.map((link) => (
                            <Link
                                key={link.path}
                                to={link.path}
                                className="relative px-4 py-2 group"
                            >
                                <span className={`text-sm font-medium transition-colors ${isActive(link.path)
                                    ? 'text-action-600 dark:text-action-400'
                                    : 'text-brand-700 dark:text-brand-300 hover:text-action-600 dark:hover:text-action-400'
                                    }`}>
                                    {link.name}
                                </span>
                                {isActive(link.path) && (
                                    <motion.div
                                        layoutId="navbar-indicator"
                                        className="absolute bottom-0 left-0 right-0 h-0.5 bg-action-600"
                                        transition={{ type: 'spring', stiffness: 380, damping: 30 }}
                                    />
                                )}
                            </Link>
                        ))}
                    </div>

                    {/* Contact Info */}
                    <div className="hidden xl:flex items-center space-x-4 text-sm">
                        <a href="tel:9009536046" className="flex items-center space-x-2 text-brand-600 dark:text-brand-400 hover:text-action-600 transition-colors">
                            <FiPhone className="w-4 h-4" />
                            <span className="font-medium">9009536046</span>
                        </a>
                        <a href="mailto:princesulekhiya2004@gmail.com" className="flex items-center space-x-2 text-brand-600 dark:text-brand-400 hover:text-action-600 transition-colors">
                            <FiMail className="w-4 h-4" />
                            <span className="font-medium">Contact</span>
                        </a>
                    </div>

                    {/* Actions */}
                    <div className="flex items-center space-x-3">
                        {/* Theme Toggle */}
                        <motion.button
                            whileHover={{ scale: 1.05 }}
                            whileTap={{ scale: 0.95 }}
                            onClick={toggleTheme}
                            className="p-2 rounded-lg bg-brand-100 dark:bg-brand-800 text-brand-700 dark:text-brand-300 hover:bg-brand-200 dark:hover:bg-brand-700 transition-colors"
                            aria-label="Toggle theme"
                        >
                            {isDark ? <FiSun className="w-5 h-5" /> : <FiMoon className="w-5 h-5" />}
                        </motion.button>

                        {/* Auth Button */}
                        {isAuthenticated ? (
                            <div className="hidden sm:flex items-center space-x-2">
                                <Link to="/admin/dashboard" className="btn-secondary text-sm py-2">
                                    Dashboard
                                </Link>
                                <button onClick={logout} className="btn-outline text-sm py-2">
                                    Logout
                                </button>
                            </div>
                        ) : (
                            <Link to="/login" className="hidden sm:block btn-primary text-sm py-2">
                                Admin Login
                            </Link>
                        )}

                        {/* Mobile Menu Toggle */}
                        <button
                            onClick={() => setIsMobileMenuOpen(!isMobileMenuOpen)}
                            className="lg:hidden p-2 rounded-lg bg-brand-100 dark:bg-brand-800 text-brand-700 dark:text-brand-300"
                            aria-label="Toggle menu"
                        >
                            {isMobileMenuOpen ? <FiX className="w-5 h-5" /> : <FiMenu className="w-5 h-5" />}
                        </button>
                    </div>
                </div>
            </div>

            {/* Mobile Menu */}
            <AnimatePresence>
                {isMobileMenuOpen && (
                    <motion.div
                        initial={{ opacity: 0, height: 0 }}
                        animate={{ opacity: 1, height: 'auto' }}
                        exit={{ opacity: 0, height: 0 }}
                        transition={{ duration: 0.2 }}
                        className="lg:hidden backdrop-glass border-t border-brand-200 dark:border-brand-700"
                    >
                        <div className="container mx-auto px-4 py-4 space-y-2">
                            {navLinks.map((link) => (
                                <Link
                                    key={link.path}
                                    to={link.path}
                                    onClick={() => setIsMobileMenuOpen(false)}
                                    className={`block px-4 py-3 rounded-lg font-medium transition-colors ${isActive(link.path)
                                        ? 'bg-action-50 dark:bg-action-900/20 text-action-600 dark:text-action-400'
                                        : 'text-brand-700 dark:text-brand-300 hover:bg-brand-100 dark:hover:bg-brand-800'
                                        }`}
                                >
                                    {link.name}
                                </Link>
                            ))}
                            <div className="pt-4 border-t border-brand-200 dark:border-brand-700 space-y-2">
                                <a href="tel:9009536046" className="flex items-center space-x-2 px-4 py-2 text-brand-600 dark:text-brand-400">
                                    <FiPhone className="w-4 h-4" />
                                    <span>9009536046</span>
                                </a>
                                {!isAuthenticated && (
                                    <Link to="/login" onClick={() => setIsMobileMenuOpen(false)} className="block btn-primary w-full text-center">
                                        Admin Login
                                    </Link>
                                )}
                            </div>
                        </div>
                    </motion.div>
                )}
            </AnimatePresence>
        </motion.nav>
    );
};

export default Navbar;
