import { useState } from 'react';
import { FiSearch } from 'react-icons/fi';

const SearchBar = ({ onSearch, placeholder = 'Search colleges by name, city, or state...' }) => {
    const [query, setQuery] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (query.trim()) {
            onSearch(query.trim());
        }
    };

    return (
        <form onSubmit={handleSubmit} className="w-full">
            <div className="relative">
                <input
                    type="text"
                    value={query}
                    onChange={(e) => setQuery(e.target.value)}
                    placeholder={placeholder}
                    className="input-field pl-12 pr-4 w-full"
                />
                <FiSearch className="absolute left-4 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400" />
                <button
                    type="submit"
                    className="absolute right-2 top-1/2 transform -translate-y-1/2 btn-primary px-6 py-2"
                >
                    Search
                </button>
            </div>
        </form>
    );
};

export default SearchBar;
