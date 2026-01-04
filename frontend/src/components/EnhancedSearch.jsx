import { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { FiSearch, FiMapPin, FiBook, FiTrendingUp, FiAward } from 'react-icons/fi';
import { motion, AnimatePresence } from 'framer-motion';

const EnhancedSearch = () => {
    const [query, setQuery] = useState('');
    const [showSuggestions, setShowSuggestions] = useState(false);
    const searchRef = useRef(null);
    const navigate = useNavigate();

    // Mock suggestions - in production this would come from API
    const suggestions = [
        { type: 'college', text: 'IIT Delhi', link: '/colleges?search=IIT Delhi' },
        { type: 'college', text: 'BITS Pilani', link: '/colleges?search=BITS Pilani' },
        { type: 'course', text: 'Computer Science', link: '/colleges?courses=CSE' },
        { type: 'course', text: 'MBA', link: '/colleges?courses=MBA' },
        { type: 'city', text: 'Colleges in Bangalore', link: '/colleges?city=Bangalore' },
        { type: 'trending', text: 'Top Engineering Colleges', link: '/colleges?type=top' },
    ];

    const filteredSuggestions = query
        ? suggestions.filter(s => s.text.toLowerCase().includes(query.toLowerCase()))
        : suggestions.slice(0, 5);

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
                        className="absolute top-full left-0 right-0 mt-2 bg-white rounded-2xl shadow-xl overflow-hidden border border-gray-100"
                    >
                        <div className="py-2">
                            {query === '' && (
                                <p className="px-5 py-2 text-xs font-semibold text-gray-500 uppercase tracking-wider">
                                    Trending Searches
                                </p>
                            )}

                            {filteredSuggestions.map((suggestion, index) => (
                                <button
                                    key={index}
                                    onClick={() => {
                                        setQuery(suggestion.text);
                                        navigate(suggestion.link);
                                        setShowSuggestions(false);
                                    }}
                                    className="w-full px-5 py-3 flex items-center space-x-3 hover:bg-gray-50 transition-colors text-left"
                                >
                                    <span className="p-2 bg-gray-100 rounded-lg text-gray-600">
                                        {suggestion.type === 'college' && <FiAward />}
                                        {suggestion.type === 'course' && <FiBook />}
                                        {suggestion.type === 'city' && <FiMapPin />}
                                        {suggestion.type === 'trending' && <FiTrendingUp />}
                                    </span>
                                    <div>
                                        <p className="font-medium text-gray-900">{suggestion.text}</p>
                                        <p className="text-xs text-gray-500 capitalize">{suggestion.type}</p>
                                    </div>
                                </button>
                            ))}

                            {filteredSuggestions.length === 0 && (
                                <div className="px-5 py-4 text-center text-gray-500">
                                    No results found for "{query}"
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
