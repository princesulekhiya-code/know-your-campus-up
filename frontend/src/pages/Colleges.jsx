import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import SearchBar from '../components/SearchBar';
import FilterPanel from '../components/FilterPanel';
import CollegeCard from '../components/CollegeCard';
import LoadingSpinner from '../components/LoadingSpinner';
import collegeService from '../services/collegeService';
import trackPageVisit from '../utils/tracking';

const Colleges = () => {
    const [searchParams] = useSearchParams();
    const [colleges, setColleges] = useState([]);
    const [loading, setLoading] = useState(true);
    const [filters, setFilters] = useState({});

    useEffect(() => {
        trackPageVisit('/colleges', 'Colleges Listing');
        loadColleges();
    }, []);

    const loadColleges = async (filterParams = {}) => {
        setLoading(true);
        try {
            const response = await collegeService.getAll(filterParams);
            setColleges(response.data);
        } catch (error) {
            console.error('Failed to load colleges:', error);
        } finally {
            setLoading(false);
        }
    };

    const handleSearch = async (query) => {
        setLoading(true);
        try {
            const response = await collegeService.search(query);
            setColleges(response.data);
        } catch (error) {
            console.error('Search failed:', error);
        } finally {
            setLoading(false);
        }
    };

    const handleFilterChange = (newFilters) => {
        setFilters(newFilters);
        const cleanFilters = Object.fromEntries(
            Object.entries(newFilters).filter(([_, v]) => v !== '')
        );
        loadColleges(cleanFilters);
    };

    const handleReset = () => {
        setFilters({});
        loadColleges();
    };

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 py-8">
            <div className="container mx-auto px-4">
                {/* Header */}
                <div className="mb-8">
                    <h1 className="text-4xl font-bold text-gray-900 dark:text-white mb-4">
                        Explore Colleges
                    </h1>
                    <p className="text-xl text-gray-600 dark:text-gray-400">
                        Find the perfect college for your future
                    </p>
                </div>

                {/* Search */}
                <div className="mb-6">
                    <SearchBar onSearch={handleSearch} />
                </div>

                {/* Filters */}
                <FilterPanel onFilterChange={handleFilterChange} onReset={handleReset} />

                {/* Results */}
                <div className="mb-6">
                    <p className="text-gray-600 dark:text-gray-400">
                        {loading ? 'Loading...' : `Found ${colleges.length} colleges`}
                    </p>
                </div>

                {loading ? (
                    <LoadingSpinner />
                ) : colleges.length === 0 ? (
                    <div className="text-center py-12">
                        <p className="text-xl text-gray-600 dark:text-gray-400">No colleges found</p>
                    </div>
                ) : (
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                        {colleges.map((college) => (
                            <CollegeCard key={college.id} college={college} />
                        ))}
                    </div>
                )}
            </div>
        </div>
    );
};

export default Colleges;
