import { Link } from 'react-router-dom';
import { FiFileText, FiDollarSign, FiPhone } from 'react-icons/fi';

const AdmissionCTA = ({ collegeId, collegeName }) => {
    return (
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
            {/* Apply for Admission */}
            <Link
                to={`/admission?college=${collegeId}&name=${encodeURIComponent(collegeName)}`}
                className="card p-6 text-center hover:shadow-xl transition-all group"
            >
                <div className="w-16 h-16 bg-gradient-to-br from-primary-500 to-primary-600 rounded-full flex items-center justify-center mx-auto mb-4 group-hover:scale-110 transition-transform">
                    <FiFileText className="w-8 h-8 text-white" />
                </div>
                <h3 className="font-bold text-lg text-gray-900 dark:text-white mb-2">Apply for Admission</h3>
                <p className="text-sm text-gray-600 dark:text-gray-400">
                    Submit your application now
                </p>
            </Link>

            {/* Get Fees Details */}
            <a
                href="tel:9009536046"
                className="card p-6 text-center hover:shadow-xl transition-all group"
            >
                <div className="w-16 h-16 bg-gradient-to-br from-secondary-500 to-secondary-600 rounded-full flex items-center justify-center mx-auto mb-4 group-hover:scale-110 transition-transform">
                    <FiDollarSign className="w-8 h-8 text-white" />
                </div>
                <h3 className="font-bold text-lg text-gray-900 dark:text-white mb-2">Get Fees Details</h3>
                <p className="text-sm text-gray-600 dark:text-gray-400">
                    Call us for complete fee structure
                </p>
            </a>

            {/* Talk to Counsellor */}
            <a
                href="tel:9009536046"
                className="card p-6 text-center hover:shadow-xl transition-all group"
            >
                <div className="w-16 h-16 bg-gradient-to-br from-green-500 to-green-600 rounded-full flex items-center justify-center mx-auto mb-4 group-hover:scale-110 transition-transform">
                    <FiPhone className="w-8 h-8 text-white" />
                </div>
                <h3 className="font-bold text-lg text-gray-900 dark:text-white mb-2">Talk to Counsellor</h3>
                <p className="text-sm text-gray-600 dark:text-gray-400">
                    Get expert guidance: 9009536046
                </p>
            </a>
        </div>
    );
};

export default AdmissionCTA;
