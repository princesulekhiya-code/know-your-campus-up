import { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { FiPlus, FiEdit, FiTrash2, FiMapPin, FiGlobe, FiPhone, FiMail } from 'react-icons/fi';
import { toast } from 'react-hot-toast';
import collegeService from '../../services/collegeService';
import { useForm } from 'react-hook-form';

const ManageColleges = () => {
    const [colleges, setColleges] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [isEditing, setIsEditing] = useState(false);
    const [currentCollege, setCurrentCollege] = useState(null);

    const { register, handleSubmit, reset, setValue, formState: { errors } } = useForm();

    useEffect(() => {
        fetchColleges();
    }, []);

    const fetchColleges = async () => {
        try {
            const response = await collegeService.getAll();
            setColleges(response.data);
        } catch (error) {
            toast.error('Failed to fetch colleges');
        } finally {
            setIsLoading(false);
        }
    };

    const onSubmit = async (data) => {
        try {
            if (isEditing) {
                await collegeService.update(currentCollege.id, data);
                toast.success('College updated successfully');
            } else {
                await collegeService.create(data);
                toast.success('College created successfully');
            }
            fetchColleges();
            closeModal();
        } catch (error) {
            toast.error(isEditing ? 'Failed to update college' : 'Failed to create college');
        }
    };

    const handleDelete = async (id) => {
        if (window.confirm('Are you sure you want to delete this college?')) {
            try {
                await collegeService.delete(id);
                toast.success('College deleted successfully');
                fetchColleges();
            } catch (error) {
                toast.error('Failed to delete college');
            }
        }
    };

    const openModal = (college = null) => {
        if (college) {
            setIsEditing(true);
            setCurrentCollege(college);
            // Set form values
            Object.keys(college).forEach(key => setValue(key, college[key]));
        } else {
            setIsEditing(false);
            setCurrentCollege(null);
            reset();
        }
        setIsModalOpen(true);
    };

    const closeModal = () => {
        setIsModalOpen(false);
        setIsEditing(false);
        setCurrentCollege(null);
        reset();
    };

    return (
        <div className="space-y-6">
            <div className="flex justify-between items-center">
                <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Manage Colleges</h1>
                <button
                    onClick={() => openModal()}
                    className="flex items-center space-x-2 bg-primary-600 hover:bg-primary-700 text-white px-4 py-2 rounded-lg transition-colors"
                >
                    <FiPlus />
                    <span>Add College</span>
                </button>
            </div>

            {isLoading ? (
                <div className="flex justify-center py-8">
                    <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-primary-600"></div>
                </div>
            ) : (
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    {colleges.map((college) => (
                        <div key={college.id} className="bg-white dark:bg-gray-800 rounded-lg shadow p-6 border border-gray-200 dark:border-gray-700">
                            <div className="flex justify-between items-start mb-4">
                                <div className="flex items-center space-x-3">
                                    {college.logoUrl ? (
                                        <img
                                            src={college.logoUrl}
                                            alt={college.name}
                                            className="w-12 h-12 rounded object-cover"
                                        />
                                    ) : (
                                        <div className="w-12 h-12 rounded bg-gradient-to-br from-primary-500 to-secondary-500 flex items-center justify-center text-white font-bold">
                                            {college.name.charAt(0).toUpperCase()}
                                        </div>
                                    )}
                                    <div>
                                        <h3 className="font-bold text-gray-900 dark:text-white line-clamp-1">{college.name}</h3>
                                        <span className={`text-xs px-2 py-0.5 rounded ${college.type === 'Government'
                                                ? 'bg-green-100 text-green-800 dark:bg-green-900/30 dark:text-green-400'
                                                : 'bg-blue-100 text-blue-800 dark:bg-blue-900/30 dark:text-blue-400'
                                            }`}>
                                            {college.type}
                                        </span>
                                    </div>
                                </div>
                                <div className="flex space-x-2">
                                    <button
                                        onClick={() => openModal(college)}
                                        className="p-1 text-gray-500 hover:text-primary-600 dark:text-gray-400 dark:hover:text-primary-400"
                                    >
                                        <FiEdit />
                                    </button>
                                    <button
                                        onClick={() => handleDelete(college.id)}
                                        className="p-1 text-gray-500 hover:text-red-600 dark:text-gray-400 dark:hover:text-red-400"
                                    >
                                        <FiTrash2 />
                                    </button>
                                </div>
                            </div>

                            <div className="space-y-2 text-sm text-gray-600 dark:text-gray-300">
                                <div className="flex items-center space-x-2">
                                    <FiMapPin className="flex-shrink-0" />
                                    <span className="truncate">{college.city}, {college.state}</span>
                                </div>
                                <div className="flex items-center space-x-2">
                                    <FiPhone className="flex-shrink-0" />
                                    <span className="truncate">{college.phone}</span>
                                </div>
                                <div className="flex items-center space-x-2">
                                    <FiGlobe className="flex-shrink-0" />
                                    <a href={college.website} target="_blank" rel="noopener noreferrer" className="text-primary-600 hover:underline truncate">
                                        Website
                                    </a>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            )}

            {/* Add/Edit Modal */}
            {isModalOpen && (
                <div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50 p-4">
                    <motion.div
                        initial={{ opacity: 0, scale: 0.95 }}
                        animate={{ opacity: 1, scale: 1 }}
                        className="bg-white dark:bg-gray-800 rounded-lg shadow-xl w-full max-w-2xl max-h-[90vh] overflow-y-auto"
                    >
                        <div className="p-6 border-b border-gray-200 dark:border-gray-700 flex justify-between items-center">
                            <h2 className="text-xl font-bold text-gray-900 dark:text-white">
                                {isEditing ? 'Edit College' : 'Add New College'}
                            </h2>
                            <button onClick={closeModal} className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-200">
                                ✕
                            </button>
                        </div>

                        <form onSubmit={handleSubmit(onSubmit)} className="p-6 space-y-4">
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                                <div>
                                    <label className="label">College Name *</label>
                                    <input
                                        {...register('name', { required: 'Name is required' })}
                                        className="input-field w-full"
                                        placeholder="e.g. IIT Bombay"
                                    />
                                    {errors.name && <span className="text-red-500 text-xs">{errors.name.message}</span>}
                                </div>

                                <div>
                                    <label className="label">Type *</label>
                                    <select {...register('type')} className="input-field w-full">
                                        <option value="Government">Government</option>
                                        <option value="Private">Private</option>
                                        <option value="Deemed">Deemed</option>
                                    </select>
                                </div>

                                <div>
                                    <label className="label">City *</label>
                                    <input {...register('city', { required: true })} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">State *</label>
                                    <input {...register('state', { required: true })} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">Address</label>
                                    <input {...register('address')} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">Pincode</label>
                                    <input {...register('pincode')} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">Established Year</label>
                                    <input type="number" {...register('establishedYear')} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">NAAC Rating</label>
                                    <input {...register('naacRating')} className="input-field w-full" placeholder="e.g. A++" />
                                </div>

                                <div>
                                    <label className="label">Phone</label>
                                    <input {...register('phone')} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">Email</label>
                                    <input type="email" {...register('email')} className="input-field w-full" />
                                </div>

                                <div>
                                    <label className="label">Website URL</label>
                                    <input {...register('website')} className="input-field w-full" placeholder="https://" />
                                </div>

                                <div>
                                    <label className="label">Admission Open?</label>
                                    <div className="flex items-center space-x-2 mt-2">
                                        <input type="checkbox" {...register('admissionOpen')} className="w-4 h-4 text-primary-600 rounded" />
                                        <span className="text-sm text-gray-700 dark:text-gray-300">Yes, admissions are open</span>
                                    </div>
                                </div>
                            </div>

                            <div>
                                <label className="label">Logo URL</label>
                                <input {...register('logoUrl')} className="input-field w-full" placeholder="https://example.com/logo.png" />
                            </div>

                            <div>
                                <label className="label">Banner/Image URL</label>
                                <input {...register('bannerUrl')} className="input-field w-full" placeholder="https://example.com/banner.jpg" />
                            </div>

                            <div>
                                <label className="label">Description</label>
                                <textarea {...register('description')} rows="3" className="input-field w-full"></textarea>
                            </div>

                            <div>
                                <label className="label">Facilities (Comma separated)</label>
                                <textarea {...register('facilities')} rows="2" className="input-field w-full" placeholder="e.g. WiFi, Hostel, Library, Sports"></textarea>
                            </div>

                            <div className="flex justify-end space-x-3 pt-4">
                                <button type="button" onClick={closeModal} className="px-4 py-2 border border-gray-300 dark:border-gray-600 rounded-lg text-gray-700 dark:text-gray-300 hover:bg-gray-50 dark:hover:bg-gray-700">
                                    Cancel
                                </button>
                                <button type="submit" className="px-4 py-2 bg-primary-600 text-white rounded-lg hover:bg-primary-700">
                                    {isEditing ? 'Update College' : 'Create College'}
                                </button>
                            </div>
                        </form>
                    </motion.div>
                </div>
            )}
        </div>
    );
};

export default ManageColleges;
