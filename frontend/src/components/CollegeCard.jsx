import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import { FiMapPin, FiAward, FiCalendar, FiCheckCircle } from 'react-icons/fi';
import { getCollegeBanner } from '../utils/collegeImages';

const CollegeCard = ({ college }) => {
    const bannerImage = getCollegeBanner(college);

    return (
        <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            whileHover={{ y: -4 }}
            transition={{ duration: 0.3 }}
        >
            <Link to={`/colleges/${college.id}`} className="block group">
                <div className="card overflow-hidden h-full hover-lift">
                    {/* Banner Image */}
                    <div className="relative h-48 bg-gradient-to-br from-action-500 to-action-700 overflow-hidden">
                        <img
                            src={bannerImage}
                            alt={college.name}
                            className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500"
                            onError={(e) => {
                                e.target.onerror = null;
                                e.target.src = "https://images.unsplash.com/photo-1562774053-701939374585?w=1000&auto=format&fit=crop&q=80";
                            }}
                        />
                        {college.admissionOpen && (
                            <motion.div
                                initial={{ scale: 0 }}
                                animate={{ scale: 1 }}
                                className="absolute top-4 right-4"
                            >
                                <span className="badge badge-success shadow-lg">
                                    <FiCheckCircle className="w-3 h-3 mr-1" />
                                    Admission Open
                                </span>
                            </motion.div>
                        )}
                    </div>

                    {/* Content */}
                    <div className="p-6 space-y-4">
                        {/* College Name */}
                        <div>
                            <h3 className="text-h3 text-brand-900 dark:text-white font-semibold mb-2 group-hover:text-action-600 dark:group-hover:text-action-400 transition-colors line-clamp-2">
                                {college.name}
                            </h3>
                            <div className="flex items-center text-sm text-brand-600 dark:text-brand-400">
                                <FiMapPin className="w-4 h-4 mr-1 flex-shrink-0" />
                                <span className="line-clamp-1">{college.city}, {college.state}</span>
                            </div>
                        </div>

                        {/* Info Grid */}
                        <div className="grid grid-cols-2 gap-3">
                            <div className="flex items-center space-x-2">
                                <div className="p-2 bg-action-50 dark:bg-action-900/20 rounded-lg">
                                    <FiAward className="w-4 h-4 text-action-600 dark:text-action-400" />
                                </div>
                                <div>
                                    <p className="text-xs text-brand-500 dark:text-brand-400">NAAC</p>
                                    <p className="text-sm font-semibold text-brand-900 dark:text-white">
                                        {college.naacRating || 'N/A'}
                                    </p>
                                </div>
                            </div>

                            <div className="flex items-center space-x-2">
                                <div className="p-2 bg-action-50 dark:bg-action-900/20 rounded-lg">
                                    <FiCalendar className="w-4 h-4 text-action-600 dark:text-action-400" />
                                </div>
                                <div>
                                    <p className="text-xs text-brand-500 dark:text-brand-400">Est.</p>
                                    <p className="text-sm font-semibold text-brand-900 dark:text-white">
                                        {college.establishedYear || 'N/A'}
                                    </p>
                                </div>
                            </div>
                        </div>

                        {/* Type Badge */}
                        <div className="flex items-center justify-between pt-2 border-t border-brand-200 dark:border-brand-700">
                            <span className={`badge ${college.type === 'GOVERNMENT'
                                    ? 'badge-info'
                                    : 'bg-purple-100 dark:bg-purple-900/30 text-purple-700 dark:text-purple-300 border border-purple-200 dark:border-purple-800'
                                }`}>
                                {college.type}
                            </span>
                            <motion.span
                                className="text-action-600 dark:text-action-400 text-sm font-medium group-hover:translate-x-1 transition-transform inline-flex items-center"
                            >
                                View Details
                                <svg className="w-4 h-4 ml-1" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 5l7 7-7 7" />
                                </svg>
                            </motion.span>
                        </div>
                    </div>
                </div>
            </Link>
        </motion.div>
    );
};

export default CollegeCard;
