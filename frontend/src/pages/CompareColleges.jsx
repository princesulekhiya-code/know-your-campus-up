import { useState, useEffect } from 'react';
import { FiX } from 'react-icons/fi';
import collegeService from '../services/collegeService';
import LoadingSpinner from '../components/LoadingSpinner';
import trackPageVisit from '../utils/tracking';

const CompareColleges = () => {
    const [colleges, setColleges] = useState([]);
    const [selectedColleges, setSelectedColleges] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        trackPageVisit('/compare', 'Compare Colleges');
    }, []);


      //   search for  the  collage   to compare  and  show the result in the list and the user can click on  the collage   to  add  in the compare list  abd the  user con  add up to 
      //   collage and   the user can remove  the collage the   compare    list and the
       

    const handleSearch = async () => {
        if (!searchQuery.trim()) return;

        setLoading(true);
        try {
            const response = await collegeService.search(searchQuery);
            setColleges(response.data);
        } catch (error) {
            console.error('Search failed:', error);
        } finally {
            setLoading(false);
        }
    };



    const addCollege = (college) => {
        if (selectedColleges.length >= 3) {
            alert('You can compare up to 3 colleges');
            return;
        }
        if (selectedColleges.find(c => c.id === college.id)) {
            alert('College already added');
            return;
        }
        setSelectedColleges([...selectedColleges, college]);
    };

    const removeCollege = (id) => {
        setSelectedColleges(selectedColleges.filter(c => c.id !== id));
    };

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 py-12 px-4">
            <div className="container mx-auto">
                <div className="text-center mb-12">
                    <h1 className="text-4xl font-bold text-gray-900 dark:text-white mb-4">
                        Compare Colleges
                    </h1>
                    <p className="text-xl text-gray-600 dark:text-gray-400">
                        Compare up to 3 colleges side-by-side
                    </p>
                </div>





                {/* Search */}
                <div className="max-w-2xl mx-auto mb-8">
                    <div className="flex gap-2">
                        <input
                            type="text"
                            value={searchQuery}
                            onChange={(e) => setSearchQuery(e.target.value)}
                            onKeyPress={(e) => e.key === 'Enter' && handleSearch()}
                            placeholder="Search colleges to compare..."
                            className="input-field flex-1"
                        />
                        <button onClick={handleSearch} className="btn-primary">
                            Search
                        </button>
                    </div>
                </div>

                {/* Search Results */}
                {loading ? (
                    <LoadingSpinner />
                ) : colleges.length > 0 && (
                    <div className="mb-8">
                        <h3 className="text-lg font-semibold text-gray-900 dark:text-white mb-4">
                            Search Results (Click to add)
                        </h3>
                        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                            {colleges.map(college => (
                                <div
                                    key={college.id}
                                    onClick={() => addCollege(college)}
                                    className="card p-4 cursor-pointer hover:shadow-xl transition"
                                >
                                    <h4 className="font-semibold text-gray-900 dark:text-white mb-2">
                                        {college.name}
                                    </h4>
                                    <p className="text-sm text-gray-600 dark:text-gray-400">
                                        {college.city}, {college.state}
                                    </p>
                                </div>
                            ))}
                        </div>
                    </div>
                )}

                {/* Comparison Table */}
                {selectedColleges.length > 0 ? (
                    <div className="card p-6 overflow-x-auto">
                        <table className="w-full">
                            <thead>
                                <tr className="border-b border-gray-200 dark:border-gray-700">
                                    <th className="text-left py-4 px-4 font-semibold text-gray-900 dark:text-white">
                                        Parameter
                                    </th>
                                    {selectedColleges.map(college => (
                                        <th key={college.id} className="py-4 px-4">
                                            <div className="flex flex-col items-center">
                                                <button
                                                    onClick={() => removeCollege(college.id)}
                                                    className="mb-2 text-red-600 hover:text-red-700"
                                                >
                                                    <FiX className="w-5 h-5" />
                                                </button>
                                                <h4 className="font-semibold text-gray-900 dark:text-white text-center">
                                                    {college.name}
                                                </h4>
                                            </div>
                                        </th>
                                    ))}
                                </tr>
                            </thead>
                            <tbody>
                                <CompareRow label="Location" values={selectedColleges.map(c => `${c.city}, ${c.state}`)} />
                                <CompareRow label="Type" values={selectedColleges.map(c => c.type)} />
                                <CompareRow label="NAAC Rating" values={selectedColleges.map(c => c.naacRating || 'N/A')} />
                                <CompareRow label="Established" values={selectedColleges.map(c => c.establishedYear || 'N/A')} />
                                <CompareRow label="Affiliated To" values={selectedColleges.map(c => c.affiliatedTo)} />
                                <CompareRow label="Admission Status" values={selectedColleges.map(c => c.admissionOpen ? 'Open' : 'Closed')} />
                                <CompareRow label="Phone" values={selectedColleges.map(c => c.phone || 'N/A')} />
                                <CompareRow label="Email" values={selectedColleges.map(c => c.email || 'N/A')} />
                            </tbody>
                        </table>
                    </div>
                ) : (
                    <div className="text-center py-12 text-gray-600 dark:text-gray-400">
                        <p className="text-xl">Search and select colleges to compare</p>
                    </div>
                )}
            </div>
        </div>
    );
};

const CompareRow = ({ label, values }) => (
    <tr className="border-b border-gray-200 dark:border-gray-700">
        <td className="py-4 px-4 font-medium text-gray-900 dark:text-white">{label}</td>
        {values.map((value, index) => (
            <td key={index} className="py-4 px-4 text-center text-gray-600 dark:text-gray-400">
                {value}
            </td>
        ))}
    </tr>
);

export default CompareColleges;
