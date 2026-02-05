import { useEffect, useState } from 'react';
import { FiStar, FiCheck, FiTrash2, FiEye, FiX } from 'react-icons/fi';
import toast from 'react-hot-toast';
import reviewService from '../../services/reviewService';

// StarRating Display Component
const StarRating = ({ rating }) => (
    <div className="flex space-x-1">
        {[1, 2, 3, 4, 5].map((star) => (
            <FiStar
                key={star}
                className={star <= rating ? 'text-yellow-400 fill-yellow-400' : 'text-gray-300'}
                size={16}
            />
        ))}
    </div>
);

const ManageReviews = () => {
    const [reviews, setReviews] = useState([]);
    const [loading, setLoading] = useState(true);
    const [activeTab, setActiveTab] = useState('all'); // 'all' | 'pending'
    const [selectedReview, setSelectedReview] = useState(null);
    const [showViewModal, setShowViewModal] = useState(false);

    useEffect(() => {
        fetchReviews();
    }, [activeTab]);

    const fetchReviews = async () => {
        try {
            setLoading(true);
            const response = activeTab === 'pending'
                ? await reviewService.getPendingReviews()
                : await reviewService.getAllReviews();
            setReviews(response.data);
        } catch (error) {
            toast.error('Failed to fetch reviews');
        } finally {
            setLoading(false);
        }
    };

    const handleApprove = async (reviewId) => {
        try {
            await reviewService.approveReview(reviewId);
            toast.success('Review approved successfully!');
            fetchReviews();
        } catch (error) {
            toast.error('Failed to approve review');
        }
    };

    const handleDelete = async (reviewId) => {
        if (window.confirm('Are you sure you want to delete this review?')) {
            try {
                await reviewService.deleteReview(reviewId);
                toast.success('Review deleted successfully!');
                fetchReviews();
            } catch (error) {
                toast.error('Failed to delete review');
            }
        }
    };

    const handleViewReview = (review) => {
        setSelectedReview(review);
        setShowViewModal(true);
    };

    return (
        <div className="p-6">
            <div className="flex justify-between items-center mb-6">
                <h1 className="text-3xl font-bold text-gray-900 dark:text-white">Manage Reviews</h1>
            </div>

            {/* Tabs */}
            <div className="flex space-x-4 mb-6 border-b border-gray-200 dark:border-gray-700">
                <button
                    onClick={() => setActiveTab('all')}
                    className={`px-4 py-2 font-medium transition ${activeTab === 'all'
                            ? 'text-primary-600 border-b-2 border-primary-600'
                            : 'text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300'
                        }`}
                >
                    All Reviews
                </button>
                <button
                    onClick={() => setActiveTab('pending')}
                    className={`px-4 py-2 font-medium flex items-center space-x-2 transition ${activeTab === 'pending'
                            ? 'text-primary-600 border-b-2 border-primary-600'
                            : 'text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300'
                        }`}
                >
                    <span>Pending Approval</span>
                    {reviews.filter(r => !r.approved).length > 0 && (
                        <span className="bg-red-500 text-white text-xs px-2 py-0.5 rounded-full">
                            {reviews.filter(r => !r.approved).length}
                        </span>
                    )}
                </button>
            </div>

            {/* Reviews Table */}
            <div className="card p-6">
                {loading ? (
                    <p className="text-center text-gray-500 dark:text-gray-400">Loading reviews...</p>
                ) : reviews.length === 0 ? (
                    <p className="text-center text-gray-500 dark:text-gray-400">No reviews found.</p>
                ) : (
                    <div className="overflow-x-auto">
                        <table className="w-full">
                            <thead className="bg-gray-50 dark:bg-gray-800 border-b border-gray-200 dark:border-gray-700">
                                <tr>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                        Student
                                    </th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                        College
                                    </th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                        Rating
                                    </th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                        Review
                                    </th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                        Status
                                    </th>
                                    <th className="px-6 py-3 text-right text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                        Actions
                                    </th>
                                </tr>
                            </thead>
                            <tbody className="bg-white dark:bg-gray-900 divide-y divide-gray-200 dark:divide-gray-700">
                                {reviews.map((review) => (
                                    <tr key={review.id} className="hover:bg-gray-50 dark:hover:bg-gray-800">
                                        <td className="px-6 py-4">
                                            <div>
                                                <div className="text-sm font-medium text-gray-900 dark:text-white">
                                                    {review.studentName}
                                                </div>
                                                <div className="text-sm text-gray-500 dark:text-gray-400">
                                                    {review.studentEmail}
                                                </div>
                                                {review.course && (
                                                    <div className="text-xs text-gray-400 dark:text-gray-500">
                                                        {review.course} • {review.batchYear}
                                                    </div>
                                                )}
                                            </div>
                                        </td>
                                        <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-white">
                                            College #{review.collegeId}
                                        </td>
                                        <td className="px-6 py-4 whitespace-nowrap">
                                            <StarRating rating={review.rating} />
                                        </td>
                                        <td className="px-6 py-4">
                                            <div className="text-sm">
                                                <div className="font-medium text-gray-900 dark:text-white">
                                                    {review.reviewTitle}
                                                </div>
                                                <div className="text-gray-500 dark:text-gray-400 line-clamp-2">
                                                    {review.reviewText}
                                                </div>
                                            </div>
                                        </td>
                                        <td className="px-6 py-4 whitespace-nowrap">
                                            <span className={`px-2 py-1 text-xs rounded-full ${review.approved
                                                    ? 'bg-green-100 text-green-800 dark:bg-green-900 dark:text-green-200'
                                                    : 'bg-yellow-100 text-yellow-800 dark:bg-yellow-900 dark:text-yellow-200'
                                                }`}>
                                                {review.approved ? 'Approved' : 'Pending'}
                                            </span>
                                            {review.verified && (
                                                <span className="ml-2 px-2 py-1 text-xs rounded-full bg-blue-100 text-blue-800 dark:bg-blue-900 dark:text-blue-200">
                                                    Verified
                                                </span>
                                            )}
                                        </td>
                                        <td className="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                            <div className="flex justify-end space-x-2">
                                                <button
                                                    onClick={() => handleViewReview(review)}
                                                    className="text-blue-600 hover:text-blue-900 dark:text-blue-400 dark:hover:text-blue-300"
                                                    title="View Full Review"
                                                >
                                                    <FiEye size={18} />
                                                </button>
                                                {!review.approved && (
                                                    <button
                                                        onClick={() => handleApprove(review.id)}
                                                        className="text-green-600 hover:text-green-900 dark:text-green-400 dark:hover:text-green-300"
                                                        title="Approve Review"
                                                    >
                                                        <FiCheck size={18} />
                                                    </button>
                                                )}
                                                <button
                                                    onClick={() => handleDelete(review.id)}
                                                    className="text-red-600 hover:text-red-900 dark:text-red-400 dark:hover:text-red-300"
                                                    title="Delete Review"
                                                >
                                                    <FiTrash2 size={18} />
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                )}
            </div>

            {/* View Review Modal */}
            {showViewModal && selectedReview && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
                    <div className="bg-white dark:bg-gray-800 rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto">
                        <div className="flex justify-between items-center p-6 border-b border-gray-200 dark:border-gray-700">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white">Review Details</h2>
                            <button onClick={() => setShowViewModal(false)} className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300">
                                <FiX size={24} />
                            </button>
                        </div>

                        <div className="p-6 space-y-4">
                            <div>
                                <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Student Name</label>
                                <p className="text-lg font-semibold text-gray-900 dark:text-white">{selectedReview.studentName}</p>
                            </div>

                            <div>
                                <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Email</label>
                                <p className="text-gray-900 dark:text-white">{selectedReview.studentEmail}</p>
                            </div>

                            {selectedReview.course && (
                                <div className="grid grid-cols-2 gap-4">
                                    <div>
                                        <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Course</label>
                                        <p className="text-gray-900 dark:text-white">{selectedReview.course}</p>
                                    </div>
                                    <div>
                                        <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Batch Year</label>
                                        <p className="text-gray-900 dark:text-white">{selectedReview.batchYear}</p>
                                    </div>
                                </div>
                            )}

                            <div>
                                <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Rating</label>
                                <div className="flex items-center space-x-2">
                                    <StarRating rating={selectedReview.rating} />
                                    <span className="text-lg font-semibold text-gray-900 dark:text-white">{selectedReview.rating}/5</span>
                                </div>
                            </div>

                            <div>
                                <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Review Title</label>
                                <p className="text-lg font-semibold text-gray-900 dark:text-white">{selectedReview.reviewTitle}</p>
                            </div>

                            <div>
                                <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Review Text</label>
                                <p className="text-gray-900 dark:text-white leading-relaxed">{selectedReview.reviewText}</p>
                            </div>

                            <div className="flex items-center space-x-4">
                                <div>
                                    <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Status</label>
                                    <p className={`inline-block px-3 py-1 rounded-full text-sm font-medium ${selectedReview.approved
                                            ? 'bg-green-100 text-green-800 dark:bg-green-900 dark:text-green-200'
                                            : 'bg-yellow-100 text-yellow-800 dark:bg-yellow-900 dark:text-yellow-200'
                                        }`}>
                                        {selectedReview.approved ? 'Approved' : 'Pending Approval'}
                                    </p>
                                </div>
                                {selectedReview.verified && (
                                    <div>
                                        <label className="text-sm font-medium text-gray-500 dark:text-gray-400">Verification</label>
                                        <p className="inline-block px-3 py-1 rounded-full text-sm font-medium bg-blue-100 text-blue-800 dark:bg-blue-900 dark:text-blue-200">
                                            Verified Student
                                        </p>
                                    </div>
                                )}
                            </div>

                            {!selectedReview.approved && (
                                <div className="flex justify-end space-x-3 pt-4 border-t border-gray-200 dark:border-gray-700">
                                    <button
                                        onClick={() => {
                                            handleApprove(selectedReview.id);
                                            setShowViewModal(false);
                                        }}
                                        className="btn-primary flex items-center space-x-2"
                                    >
                                        <FiCheck />
                                        <span>Approve Review</span>
                                    </button>
                                </div>
                            )}
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};

export default ManageReviews;
