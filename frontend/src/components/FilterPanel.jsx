import { useState } from 'react';
import { FiFilter, FiX } from 'react-icons/fi';

const FilterPanel = ({ onFilterChange, onReset }) => {
    const [filters, setFilters] = useState({
        type: '',
        city: '',
        state: '',
        naacRating: '',
        admissionOpen: '',
    });

    const [isOpen, setIsOpen] = useState(false);

    const handleChange = (field, value) => {
        const newFilters = { ...filters, [field]: value };
        setFilters(newFilters);
        onFilterChange(newFilters);
    };

    const handleReset = () => {
        const emptyFilters = {
            type: '',
            city: '',
            state: '',
            naacRating: '',
            admissionOpen: '',
        };
        setFilters(emptyFilters);
        onReset();
    };

    return (
        <div className="mb-6">
            {/* Mobile Toggle */}
            <button
                onClick={() => setIsOpen(!isOpen)}
                className="md:hidden w-full btn-outline flex items-center justify-center space-x-2 mb-4"
            >
                <FiFilter className="w-5 h-5" />
                <span>Filters</span>
            </button>

            {/* Filter Panel */}
            <div className={`${isOpen ? 'block' : 'hidden'} md:block card p-6`}>
                <div className="flex items-center justify-between mb-4">
                    <h3 className="text-lg font-bold text-gray-900 dark:text-white flex items-center">
                        <FiFilter className="w-5 h-5 mr-2" />
                        Filters
                    </h3>
                    <button onClick={handleReset} className="text-sm text-primary-600 hover:text-primary-700 font-medium">
                        Reset All
                    </button>
                </div>

                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-4">
                    {/* College Type */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                            College Type
                        </label>
                        <select
                            value={filters.type}
                            onChange={(e) => handleChange('type', e.target.value)}
                            className="input-field"
                        >
                            <option value="">All Types</option>
                            <option value="GOVERNMENT">Government</option>
                            <option value="PRIVATE">Private</option>
                        </select>
                    </div>

                    {/* State */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                            State
                        </label>
                        <select
                            value={filters.state}
                            onChange={(e) => handleChange('state', e.target.value)}
                            className="input-field"
                        >
                            <option value="">All States</option>
                            <option value="Delhi">Delhi</option>
                            <option value="Maharashtra">Maharashtra</option>
                            <option value="Karnataka">Karnataka</option>
                            <option value="Tamil Nadu">Tamil Nadu</option>
                            <option value="Uttar Pradesh">Uttar Pradesh</option>
                            <option value="West Bengal">West Bengal</option>
                            <option value="Gujarat">Gujarat</option>
                            <option value="Punjab">Punjab</option>
                        </select>
                    </div>

                    {/* NAAC Rating */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                            NAAC Rating
                        </label>
                        <select
                            value={filters.naacRating}
                            onChange={(e) => handleChange('naacRating', e.target.value)}
                            className="input-field"
                        >
                            <option value="">All Ratings</option>
                            <option value="A++">A++</option>
                            <option value="A+">A+</option>
                            <option value="A">A</option>
                            <option value="B++">B++</option>
                            <option value="B+">B+</option>
                            <option value="B">B</option>
                        </select>
                    </div>

                    {/* Admission Status */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                            Admission Status
                        </label>
                        <select
                            value={filters.admissionOpen}
                            onChange={(e) => handleChange('admissionOpen', e.target.value)}
                            className="input-field"
                        >
                            <option value="">All</option>
                            <option value="true">Open</option>
                            <option value="false">Closed</option>
                        </select>
                    </div>

                    {/* City */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                            City
                        </label>
                        <input
                            type="text"
                            value={filters.city}
                            onChange={(e) => handleChange('city', e.target.value)}
                            placeholder="Enter city"
                            className="input-field"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default FilterPanel;
