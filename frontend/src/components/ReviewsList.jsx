import { useEffect, useState } from 'react';
import { FiUser, FiCalendar } from 'react-icons/fi';
import reviewService from '../services/reviewService';
import StarRating from './StarRating';

const ReviewsList = ({ collegeId }) => {
    const [reviews, setReviews] = useState([]);
    const [loading, setLoading] = useState(true);
    const [sortBy, setSortBy] = useState('newest'); // newest, highest, lowest

    useEffect(() => {
        fetchReviews();
    }, [collegeId]);

    const fetchReviews = async () => {
        try {
            setLoading(true);
            const response = await reviewService.getByCollegeId(collegeId);
            setReviews(response.data);
        } catch (error) {
            console.error('Failed to fetch reviews', error);
        } finally {
            setLoading(false);
        }
    };

    const getSortedReviews = () => {
        const sorted = [...reviews];
        switch (sortBy) {
            case 'highest':
                return sorted.sort((a, b) => b.rating - a.rating);
            case 'lowest':
                return sorted.sort((a, b) => a.rating - b.rating);
            case 'newest':
            default:
                return sorted.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));
        }
    };

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        const options = { year: 'numeric', month: 'short', day: 'numeric' };
        return date.toLocaleDateString('en-US', options);
    };

    if (loading) {
        return (
            <div className="text-center py-8">
                <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-primary-600 mx-auto"></div>
                <p className="text-gray-500 dark:text-gray-400 mt-4">Loading reviews...</p>
            </div>
        );
    }

    if (reviews.length === 0) {
        return (
            <div className="text-center py-12 bg-gray-50 dark:bg-gray-800/50 rounded-lg">
                <p className="text-gray-500 dark:text-gray-400 text-lg">
                    No reviews yet. Be the first to review this college!
                </p>
            </div>
        );
    }

    const sortedReviews = getSortedReviews();

    return (
        <div className="space-y-4">
            {/* Sort Controls */}
            <div className="flex items-center justify-between border-b border-gray-200 dark:border-gray-700 pb-4">
                <p className="text-sm text-gray-600 dark:text-gray-400">
                    Showing {reviews.length} {reviews.length === 1 ? 'review' : 'reviews'}
                </p>
                <div className="flex items-center space-x-2">
                    <label className="text-sm font-medium text-gray-700 dark:text-gray-300">
                        Sort by:
                    </label>
                    <select
                        value={sortBy}
                        onChange={(e) => setSortBy(e.target.value)}
                        className="input-field py-1.5 px-3 text-sm"
                    >
                        <option value="newest">Newest First</option>
                        <option value="highest">Highest Rating</option>
                        <option value="lowest">Lowest Rating</option>
                    </select>
                </div>
            </div>

            {/* Reviews List */}
            <div className="space-y-4">
                {sortedReviews.map((review) => (
                    <div
                        key={review.id}
                        className="bg-white dark:bg-gray-800 rounded-lg p-6 border border-gray-200 dark:border-gray-700 hover:shadow-md transition"
                    >
                        {/* Header */}
                        <div className="flex items-start justify-between mb-3">
                            <div className="flex items-center space-x-3">
                                <div className="w-12 h-12 bg-primary-100 dark:bg-primary-900/30 rounded-full flex items-center justify-center">
                                    <FiUser className="text-primary-600 dark:text-primary-400" size={24} />
                                </div>
                                <div>
                                    <div className="flex items-center space-x-2">
                                        <h4 className="font-semibold text-gray-900 dark:text-white">
                                            {review.studentName}
                                        </h4>
                                        {review.verified && (
                                            <span className="px-2 py-0.5 text-xs font-medium bg-blue-100 text-blue-800 dark:bg-blue-900 dark:text-blue-200 rounded-full">
                                                Verified
                                            </span>
                                        )}
                                    </div>
                                    {(review.course || review.batchYear) && (
                                        <p className="text-sm text-gray-500 dark:text-gray-400">
                                            {review.course}{review.course && review.batchYear && ' • '}
                                            {review.batchYear}
                                        </p>
                                    )}
                                </div>
                            </div>

                            <div className="flex items-center space-x-2 text-sm text-gray-500 dark:text-gray-400">
                                <FiCalendar size={14} />
                                <span>{formatDate(review.createdAt)}</span>
                            </div>
                        </div>

                        {/* Rating & Title */}
                        <div className="mb-3">
                            <StarRating rating={review.rating} size={18} />
                            <h3 className="text-lg font-semibold text-gray-900 dark:text-white mt-2">
                                {review.reviewTitle}
                            </h3>
                        </div>

                        {/* Review Text */}
                        <p className="text-gray-700 dark:text-gray-300 leading-relaxed">
                            {review.reviewText}
                        </p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default ReviewsList;
