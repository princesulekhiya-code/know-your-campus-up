import { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { FiSearch, FiMapPin, FiBook, FiTrendingUp, FiAward } from 'react-icons/fi';
import { motion, AnimatePresence } from 'framer-motion';
import collegeService from '../services/collegeService';

const EnhancedSearch = () => {
    const [query, setQuery] = useState('');
    const [showSuggestions, setShowSuggestions] = useState(false);
    const [suggestions, setSuggestions] = useState([]);
    const [loading, setLoading] = useState(false);
    const searchRef = useRef(null);
    const navigate = useNavigate();
    const debounceTimer = useRef(null);

    // Fetch suggestions from backend
    const fetchSuggestions = async (searchQuery) => {
        if (!searchQuery.trim()) {
            // Show trending colleges when empty
            try {
                const response = await collegeService.getAll({ limit: 5 });
                const colleges = response.data.slice(0, 5);
                setSuggestions(colleges.map(college => ({
                    type: 'college',
                    text: college.name,
                    subtitle: `${college.city}, ${college.state}`,
                    link: `/colleges/${college.id}`,
                    searchLink: `/colleges?search=${encodeURIComponent(college.name)}`
                })));
            } catch (error) {
                console.error('Failed to fetch trending colleges:', error);
                setSuggestions([]);
            }
            return;
        }

        setLoading(true);
        try {
            const response = await collegeService.search(searchQuery);
            const colleges = response.data.slice(0, 8); // Show max 8 suggestions

            setSuggestions(colleges.map(college => ({
                type: 'college',
                text: college.name,
                subtitle: `${college.city}, ${college.state}`,
                link: `/colleges/${college.id}`,
                searchLink: `/colleges?search=${encodeURIComponent(college.name)}`
            })));
        } catch (error) {
            console.error('Failed to fetch suggestions:', error);
            setSuggestions([]);
        } finally {
            setLoading(false);
        }
    };

    // Debounced search
    useEffect(() => {
        if (debounceTimer.current) {
            clearTimeout(debounceTimer.current);
        }

        debounceTimer.current = setTimeout(() => {
            if (showSuggestions) {
                fetchSuggestions(query);
            }
        }, 300); // 300ms debounce

        return () => {
            if (debounceTimer.current) {
                clearTimeout(debounceTimer.current);
            }
        };
    }, [query, showSuggestions]);

    useEffect(() => {
        const handleClickOutside = (event) => {
            if (searchRef.current && !searchRef.current.contains(event.target)) {
                setShowSuggestions(false);
            }
        };
        document.addEventListener('mousedown', handleClickOutside);
        return () => document.removeEventListener('mousedown', handleClickOutside);
    }, []);

    const handleSearch = () => {
        if (query.trim()) {
            navigate(`/colleges?search=${encodeURIComponent(query)}`);
            setShowSuggestions(false);
        }
    };

    const handleKeyDown = (e) => {
        if (e.key === 'Enter') {
            handleSearch();
        }
    };

    const handleSuggestionClick = (suggestion) => {
        setQuery(suggestion.text);
        navigate(suggestion.searchLink);
        setShowSuggestions(false);
    };

    return (
        <div ref={searchRef} className="relative max-w-2xl mx-auto mb-8 z-50">
            <div className="relative group">
                <input
                    type="text"
                    value={query}
                    onChange={(e) => {
                        setQuery(e.target.value);
                        setShowSuggestions(true);
                    }}
                    onFocus={() => setShowSuggestions(true)}
                    onKeyDown={handleKeyDown}
                    placeholder="Search colleges, courses, or cities..."
                    className="w-full px-6 py-4 rounded-full text-gray-900 text-lg focus:outline-none focus:ring-4 focus:ring-white/30 bg-white shadow-lg group-hover:shadow-xl transition-all duration-300"
                />
                <button
                    onClick={handleSearch}
                    className="absolute right-2 top-1/2 transform -translate-y-1/2 bg-action-600 hover:bg-action-700 text-white px-8 py-3 rounded-full font-semibold transition-all duration-300 shadow-md hover:shadow-lg flex items-center"
                >
                    <FiSearch className="inline-block mr-2 w-5 h-5" />
                    Search
                </button>
            </div>

            <AnimatePresence>
                {showSuggestions && (
                    <motion.div
                        initial={{ opacity: 0, y: 10 }}
                        animate={{ opacity: 1, y: 0 }}
                        exit={{ opacity: 0, y: 10 }}
                        className="absolute top-full left-0 right-0 mt-2 bg-white rounded-2xl shadow-xl overflow-hidden border border-gray-100 max-h-96 overflow-y-auto"
                    >
                        <div className="py-2">
                            {query === '' && (
                                <p className="px-5 py-2 text-xs font-semibold text-gray-500 uppercase tracking-wider">
                                    Trending Colleges
                                </p>
                            )}

                            {loading && (
                                <div className="px-5 py-4 text-center text-gray-500">
                                    <div className="inline-block animate-spin rounded-full h-6 w-6 border-b-2 border-action-600"></div>
                                </div>
                            )}

                            {!loading && suggestions.map((suggestion, index) => (
                                <button
                                    key={index}
                                    onClick={() => handleSuggestionClick(suggestion)}
                                    className="w-full px-5 py-3 flex items-center space-x-3 hover:bg-gray-50 transition-colors text-left"
                                >
                                    <span className="p-2 bg-action-50 rounded-lg text-action-600">
                                        <FiAward />
                                    </span>
                                    <div className="flex-1">
                                        <p className="font-medium text-gray-900">{suggestion.text}</p>
                                        <p className="text-xs text-gray-500">{suggestion.subtitle}</p>
                                    </div>
                                    <FiSearch className="text-gray-400" />
                                </button>
                            ))}

                            {!loading && suggestions.length === 0 && query !== '' && (
                                <div className="px-5 py-4 text-center text-gray-500">
                                    <p className="font-medium">No colleges found for "{query}"</p>
                                    <p className="text-sm mt-1">Try searching with different keywords</p>
                                </div>
                            )}
                        </div>
                    </motion.div>
                )}
            </AnimatePresence>
        </div>
    );
};

export default EnhancedSearch;

