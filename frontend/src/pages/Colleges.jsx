import SEO from '../components/SEO';
import { useEffect, useState, useCallback } from 'react';
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

    const stream = searchParams.get('stream') || searchParams.get('type') || '';

    const loadColleges = useCallback(async (filterParams = {}) => {
        setLoading(true);
        try {
            const response = await collegeService.getAll(filterParams);
            setColleges(response.data);
        } catch (error) {
            console.error('Failed to load colleges:', error);
        } finally {
            setLoading(false);
        }
    }, []);

    const handleSearch = useCallback(async (query) => {
        setLoading(true);
        try {
            const response = await collegeService.search(query);
            setColleges(response.data);
        } catch (error) {
            console.error('Search failed:', error);
        } finally {
            setLoading(false);
        }
    }, []);

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


    useEffect(() => {
        // Scroll to top smoothly when search params change
        window.scrollTo({ top: 0, behavior: 'smooth' });

        trackPageVisit('/colleges', 'Colleges Listing');

        // Check if there's a search query in URL
        const searchQuery = searchParams.get('search');
        const typeFilter = searchParams.get('type');
        const cityFilter = searchParams.get('city');
        const stateFilter = searchParams.get('state');
        const naacRating = searchParams.get('naacRating');

        if (searchQuery) {
            // If search query exists, perform search
            handleSearch(searchQuery);
        } else if (typeFilter || cityFilter || stateFilter || naacRating) {
            // If filters exist, load with filters
            const urlFilters = {};
            if (typeFilter) urlFilters.type = typeFilter;
            if (cityFilter) urlFilters.city = cityFilter;
            if (stateFilter) urlFilters.state = stateFilter;
            if (naacRating) urlFilters.naacRating = naacRating;
            loadColleges(urlFilters);
        } else {
            // Otherwise load all colleges
            loadColleges();
        }
    }, [searchParams, handleSearch, loadColleges]);

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 py-8">
            <SEO
                title={stream ? `Top ${stream} Colleges in Bhopal & MP 2026 | Fees, Cutoff, Admission` : "All Medical & Engineering Colleges in MP 2026 | MBBS, BAMS, BHMS, BDS, BPT, B.Tech"}
                description={`Complete list of ${stream || 'MBBS, BAMS, BHMS, BDS, BPT, B.Tech, MBA'} colleges in Bhopal, Indore, Jabalpur, Gwalior & all Madhya Pradesh cities. Compare fees, NEET/JEE cutoffs, seat matrix, hostel facilities & admission process. Government and private colleges.`}
                keywords={`top mbbs college bhopal, top bams college bhopal, best bhms college mp, bds college bhopal, bpt college bhopal, medical colleges in mp list, ayurvedic colleges mp, dental colleges mp, physiotherapy colleges mp, homeopathy colleges mp, peoples medical college fees, chirayu medical college, ln medical college fees, rkdf medical college, government medical college mp, private medical college fees mp, neet cutoff mp, top engineering colleges bhopal, best private college indore, college admission 2026 mp`}
            />
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
