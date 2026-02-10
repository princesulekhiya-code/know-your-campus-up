import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { FiMapPin, FiPhone, FiMail, FiGlobe, FiAward, FiCalendar, FiStar } from 'react-icons/fi';
import AdmissionCTA from '../components/AdmissionCTA';
import LoadingSpinner from '../components/LoadingSpinner';
import WriteReviewForm from '../components/WriteReviewForm';
import ReviewsList from '../components/ReviewsList';
import StarRating from '../components/StarRating';
import collegeService, { courseService, seatService, feeService, cutoffService } from '../services/collegeService';
import reviewService from '../services/reviewService';
import trackPageVisit from '../utils/tracking';

const CollegeDetails = () => {
    const { id } = useParams();
    const [college, setCollege] = useState(null);
    const [courses, setCourses] = useState([]);
    const [reviewStats, setReviewStats] = useState({ averageRating: 0, totalReviews: 0 });
    const [showReviewForm, setShowReviewForm] = useState(false);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const loadCollegeDetails = async () => {
            try {
                // Load college details (required)
                const collegeRes = await collegeService.getById(id);
                setCollege(collegeRes.data);
                trackPageVisit(`/colleges/${id}`, collegeRes.data.name, parseInt(id));

                // Load courses (optional)
                try {
                    const coursesRes = await courseService.getByCollegeId(id);
                    setCourses(coursesRes.data || []);
                } catch (error) {
                    console.error('Failed to load courses:', error);
                    setCourses([]);
                }

                // Load review stats (optional)
                try {
                    const reviewStatsRes = await reviewService.getCollegeStats(id);
                    setReviewStats(reviewStatsRes.data);
                } catch (error) {
                    console.error('Failed to load review stats:', error);
                    setReviewStats({ averageRating: 0, totalReviews: 0 });
                }
            } catch (error) {
                console.error('Failed to load college details:', error);
                setCollege(null);
            } finally {
                setLoading(false);
            }
        };

        loadCollegeDetails();
    }, [id]);

    if (loading) return <LoadingSpinner />;

    if (!college) {
        return (
            <div className="min-h-screen bg-gray-50 dark:bg-gray-900 flex items-center justify-center p-4">
                <div className="text-center max-w-md">
                    <div className="mb-8">
                        <h1 className="text-6xl font-bold text-gray-300 dark:text-gray-700 mb-4">404</h1>
                        <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-2">College Not Found</h2>
                        <p className="text-gray-600 dark:text-gray-400">
                            The college you're looking for doesn't exist or has been removed.
                        </p>
                    </div>
                    <div className="space-y-3">
                        <a href="/colleges" className="btn-primary inline-block">
                            Browse All Colleges
                        </a>
                        <br />
                        <a href="/" className="text-primary-600 hover:text-primary-700 dark:text-primary-400">
                            ← Back to Home
                        </a>
                    </div>
                </div>
            </div>
        );
    }

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900">
            {/* Banner */}
            <div className="h-64 bg-gradient-to-r from-primary-600 to-secondary-600 relative">
                {college.bannerUrl && (
                    <img src={college.bannerUrl} alt={college.name} className="w-full h-full object-cover" />
                )}
                <div className="absolute inset-0 bg-black/40"></div>
            </div>

            <div className="container mx-auto px-4 -mt-32 relative z-10">
                {/* College Header Card */}
                <div className="card p-8 mb-8">
                    <div className="flex flex-col md:flex-row items-start md:items-center space-y-4 md:space-y-0 md:space-x-6">
                        {college.logoUrl && (
                            <img src={college.logoUrl} alt={college.name} className="w-24 h-24 rounded-lg shadow-lg" />
                        )}
                        <div className="flex-1">
                            <h1 className="text-3xl md:text-4xl font-bold text-gray-900 dark:text-white mb-2">
                                {college.name}
                            </h1>
                            <div className="flex flex-wrap gap-4 text-gray-600 dark:text-gray-400">
                                <div className="flex items-center">
                                    <FiMapPin className="w-5 h-5 mr-2" />
                                    <span>{college.address}</span>
                                </div>
                                <div className="flex items-center">
                                    <FiAward className="w-5 h-5 mr-2" />
                                    <span>NAAC: {college.naacRating}</span>
                                </div>
                                <div className="flex items-center">
                                    <FiCalendar className="w-5 h-5 mr-2" />
                                    <span>Est. {college.establishedYear}</span>
                                </div>
                                {reviewStats.totalReviews > 0 && (
                                    <div className="flex items-center">
                                        <FiStar className="w-5 h-5 mr-2 text-yellow-400 fill-yellow-400" />
                                        <span className="font-semibold">{reviewStats.averageRating.toFixed(1)}</span>
                                        <span className="ml-1">({reviewStats.totalReviews} {reviewStats.totalReviews === 1 ? 'review' : 'reviews'})</span>
                                    </div>
                                )}
                            </div>
                        </div>
                        {college.admissionOpen && (
                            <div className="badge badge-success text-lg px-6 py-2">
                                Admission Open
                            </div>
                        )}
                    </div>
                </div>

                {/* Admission CTAs */}
                <div className="mb-8">
                    <AdmissionCTA collegeId={college.id} collegeName={college.name} />
                </div>

                {/* Main Content */}
                <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
                    {/* Left Column - Details */}
                    <div className="lg:col-span-2 space-y-8">
                        {/* About */}
                        <div className="card p-6">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-4">About</h2>
                            <p className="text-gray-600 dark:text-gray-400 leading-relaxed">
                                {college.description}
                            </p>
                        </div>

                        {/* Courses */}
                        <div className="card p-6">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-4">Courses Offered</h2>
                            <div className="space-y-4">
                                {courses.map((course) => (
                                    <CourseCard key={course.id} course={course} />
                                ))}
                            </div>
                        </div>

                        {/* Facilities */}
                        {college.facilities && (
                            <div className="card p-6">
                                <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-4">Facilities</h2>
                                <div className="flex flex-wrap gap-2">
                                    {college.facilities.split(',').map((facility, index) => (
                                        <span key={index} className="badge badge-info">
                                            {facility.trim()}
                                        </span>
                                    ))}
                                </div>
                            </div>
                        )}
                    </div>

                    {/* Right Column - Contact & Info */}
                    <div className="space-y-6">
                        {/* Contact Info */}
                        <div className="card p-6">
                            <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-4">Contact Information</h3>
                            <div className="space-y-4">
                                {college.phone && (
                                    <div className="flex items-start space-x-3">
                                        <FiPhone className="w-5 h-5 text-primary-600 mt-1" />
                                        <div>
                                            <p className="font-semibold text-gray-900 dark:text-white">Phone</p>
                                            <a href={`tel:${college.phone}`} className="text-primary-600 hover:underline">
                                                {college.phone}
                                            </a>
                                        </div>
                                    </div>
                                )}
                                {college.email && (
                                    <div className="flex items-start space-x-3">
                                        <FiMail className="w-5 h-5 text-primary-600 mt-1" />
                                        <div>
                                            <p className="font-semibold text-gray-900 dark:text-white">Email</p>
                                            <a href={`mailto:${college.email}`} className="text-primary-600 hover:underline break-all">
                                                {college.email}
                                            </a>
                                        </div>
                                    </div>
                                )}
                                {college.website && (
                                    <div className="flex items-start space-x-3">
                                        <FiGlobe className="w-5 h-5 text-primary-600 mt-1" />
                                        <div>
                                            <p className="font-semibold text-gray-900 dark:text-white">Website</p>
                                            <a href={college.website} target="_blank" rel="noopener noreferrer" className="text-primary-600 hover:underline break-all">
                                                {college.website}
                                            </a>
                                        </div>
                                    </div>
                                )}
                            </div>
                        </div>

                        {/* Quick Info */}
                        <div className="card p-6">
                            <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-4">Quick Info</h3>
                            <div className="space-y-3">
                                <div>
                                    <p className="text-sm text-gray-500 dark:text-gray-400">Type</p>
                                    <p className="font-semibold text-gray-900 dark:text-white">{college.type}</p>
                                </div>
                                <div>
                                    <p className="text-sm text-gray-500 dark:text-gray-400">Affiliated To</p>
                                    <p className="font-semibold text-gray-900 dark:text-white">{college.affiliatedTo}</p>
                                </div>
                                <div>
                                    <p className="text-sm text-gray-500 dark:text-gray-400">Location</p>
                                    <p className="font-semibold text-gray-900 dark:text-white">{college.city}, {college.state}</p>
                                </div>
                            </div>
                        </div>

                        {/* Contact CTA */}
                        <div className="card p-6 bg-gradient-to-br from-primary-600 to-secondary-600 text-white">
                            <h3 className="text-xl font-bold mb-2">Need Help?</h3>
                            <p className="mb-4 opacity-90">Talk to our counsellors</p>
                            <a
                                href="tel:9009536046"
                                className="inline-block w-full text-center px-6 py-3 bg-white text-primary-700 font-semibold rounded-lg shadow-md hover:bg-gray-100 hover:shadow-lg transition-all duration-200"
                            >
                                📞 Call 9009536046
                            </a>
                        </div>
                    </div>
                </div>

                {/* Reviews Section */}
                <div className="card p-6 mb-8">
                    <div className="flex justify-between items-center mb-6">
                        <div>
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-2">Student Reviews</h2>
                            {reviewStats.totalReviews > 0 && (
                                <div className="flex items-center space-x-3">
                                    <StarRating rating={Math.round(reviewStats.averageRating)} size={24} />
                                    <span className="text-2xl font-bold text-gray-900 dark:text-white">
                                        {reviewStats.averageRating.toFixed(1)}
                                    </span>
                                    <span className="text-gray-500 dark:text-gray-400">
                                        Based on {reviewStats.totalReviews} {reviewStats.totalReviews === 1 ? 'review' : 'reviews'}
                                    </span>
                                </div>
                            )}
                        </div>
                        <button
                            onClick={() => setShowReviewForm(true)}
                            className="btn-primary flex items-center space-x-2"
                        >
                            <FiStar size={18} />
                            <span>Write a Review</span>
                        </button>
                    </div>

                    <ReviewsList collegeId={id} />
                </div>
            </div>

            {/* Write Review Modal */}
            {showReviewForm && (
                <WriteReviewForm
                    collegeId={parseInt(id)}
                    collegeName={college.name}
                    onClose={() => setShowReviewForm(false)}
                    onSuccess={() => {
                        // Refresh review stats after submission
                        reviewService.getCollegeStats(id).then(res => {
                            setReviewStats(res.data);
                        });
                    }}
                />
            )}
        </div>
    );
};

const CourseCard = ({ course }) => {
    const [expanded, setExpanded] = useState(false);

    return (
        <div className="border border-gray-200 dark:border-gray-700 rounded-lg p-4 hover:shadow-md transition">
            <div className="flex justify-between items-start mb-2">
                <div>
                    <h3 className="font-bold text-lg text-gray-900 dark:text-white">
                        {course.name} - {course.specialization}
                    </h3>
                    <p className="text-sm text-gray-600 dark:text-gray-400">
                        {course.degree} • {course.durationYears} Years
                    </p>
                </div>
                <button
                    onClick={() => setExpanded(!expanded)}
                    className="text-primary-600 hover:text-primary-700 font-medium text-sm"
                >
                    {expanded ? 'Less' : 'More'}
                </button>
            </div>

            {expanded && (
                <div className="mt-4 pt-4 border-t border-gray-200 dark:border-gray-700 space-y-2">
                    <p className="text-sm text-gray-600 dark:text-gray-400">{course.description}</p>
                    <p className="text-sm"><span className="font-semibold">Eligibility:</span> {course.eligibility}</p>
                </div>
            )}
        </div>
    );
};

export default CollegeDetails;
