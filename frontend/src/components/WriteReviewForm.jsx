import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { FiX } from 'react-icons/fi';
import toast from 'react-hot-toast';
import reviewService from '../services/reviewService';
import StarRating from './StarRating';

const WriteReviewForm = ({ collegeId, collegeName, onClose, onSuccess }) => {
    const [selectedRating, setSelectedRating] = useState(0);
    const [isSubmitting, setIsSubmitting] = useState(false);
    const { register, handleSubmit, formState: { errors } } = useForm();

    const onSubmit = async (data) => {
        if (selectedRating === 0) {
            toast.error('Please select a rating');
            return;
        }

        try {
            setIsSubmitting(true);
            await reviewService.create({
                ...data,
                collegeId,
                rating: selectedRating
            });
            toast.success('Review submitted successfully! It will be published after admin approval.');
            onSuccess && onSuccess();
            onClose();
        } catch (error) {
            toast.error(error.response?.data?.message || 'Failed to submit review');
        } finally {
            setIsSubmitting(false);
        }
    };

    return (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
            <div className="bg-white dark:bg-gray-800 rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto">
                <div className="flex justify-between items-center p-6 border-b border-gray-200 dark:border-gray-700">
                    <h2 className="text-2xl font-bold text-gray-900 dark:text-white">
                        Write a Review - {collegeName}
                    </h2>
                    <button
                        onClick={onClose}
                        className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300 transition"
                    >
                        <FiX size={24} />
                    </button>
                </div>

                <form onSubmit={handleSubmit(onSubmit)} className="p-6 space-y-5">
                    {/* Rating */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                            Your Rating <span className="text-red-500">*</span>
                        </label>
                        <div className="flex items-center space-x-3">
                            <StarRating
                                rating={selectedRating}
                                size={36}
                                editable={true}
                                onChange={setSelectedRating}
                            />
                            {selectedRating > 0 && (
                                <span className="text-lg font-semibold text-gray-900 dark:text-white">
                                    {selectedRating}/5
                                </span>
                            )}
                        </div>
                        {selectedRating === 0 && (
                            <p className="text-sm text-gray-500 dark:text-gray-400 mt-1">
                                Click on stars to rate
                            </p>
                        )}
                    </div>

                    {/* Personal Details */}
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        <div>
                            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                Your Name <span className="text-red-500">*</span>
                            </label>
                            <input
                                type="text"
                                {...register('studentName', { required: 'Name is required' })}
                                className="input-field"
                                placeholder="Enter your full name"
                            />
                            {errors.studentName && (
                                <p className="text-red-500 text-xs mt-1">{errors.studentName.message}</p>
                            )}
                        </div>

                        <div>
                            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                Email <span className="text-red-500">*</span>
                            </label>
                            <input
                                type="email"
                                {...register('studentEmail', {
                                    required: 'Email is required',
                                    pattern: {
                                        value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                                        message: 'Invalid email address'
                                    }
                                })}
                                className="input-field"
                                placeholder="your.email@example.com"
                            />
                            {errors.studentEmail && (
                                <p className="text-red-500 text-xs mt-1">{errors.studentEmail.message}</p>
                            )}
                        </div>
                    </div>

                    {/* Course & Batch */}
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        <div>
                            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                Course Studied
                            </label>
                            <input
                                type="text"
                                {...register('course')}
                                className="input-field"
                                placeholder="e.g., B.Tech CSE, MBA"
                            />
                        </div>

                        <div>
                            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                Batch Year
                            </label>
                            <input
                                type="text"
                                {...register('batchYear')}
                                className="input-field"
                                placeholder="e.g., 2020-2024"
                            />
                        </div>
                    </div>

                    {/* Review Title */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                            Review Title <span className="text-red-500">*</span>
                        </label>
                        <input
                            type="text"
                            {...register('reviewTitle', { required: 'Review title is required' })}
                            className="input-field"
                            placeholder="Summarize your experience"
                            maxLength={100}
                        />
                        {errors.reviewTitle && (
                            <p className="text-red-500 text-xs mt-1">{errors.reviewTitle.message}</p>
                        )}
                    </div>

                    {/* Review Text */}
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                            Your Review <span className="text-red-500">*</span>
                        </label>
                        <textarea
                            {...register('reviewText', {
                                required: 'Review text is required',
                                minLength: {
                                    value: 50,
                                    message: 'Review must be at least 50 characters'
                                }
                            })}
                            rows="5"
                            className="input-field"
                            placeholder="Share your experience about the college, faculty, placements, infrastructure, etc. (Minimum 50 characters)"
                            maxLength={2000}
                        />
                        {errors.reviewText && (
                            <p className="text-red-500 text-xs mt-1">{errors.reviewText.message}</p>
                        )}
                    </div>

                    {/* Info Box */}
                    <div className="bg-blue-50 dark:bg-blue-900/20 border border-blue-200 dark:border-blue-800 rounded-lg p-4">
                        <p className="text-sm text-blue-800 dark:text-blue-200">
                            <strong>Note:</strong> Your review will be visible to everyone after admin approval.
                            Please be honest and respectful in your feedback.
                        </p>
                    </div>

                    {/* Action Buttons */}
                    <div className="flex justify-end space-x-3 pt-4 border-t border-gray-200 dark:border-gray-700">
                        <button
                            type="button"
                            onClick={onClose}
                            className="px-5 py-2.5 text-gray-700 dark:text-gray-300 hover:bg-gray-100 dark:hover:bg-gray-700 rounded-lg transition font-medium"
                            disabled={isSubmitting}
                        >
                            Cancel
                        </button>
                        <button
                            type="submit"
                            className="btn-primary px-5 py-2.5 disabled:opacity-50 disabled:cursor-not-allowed"
                            disabled={isSubmitting}
                        >
                            {isSubmitting ? 'Submitting...' : 'Submit Review'}
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default WriteReviewForm;
