import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { FiEdit2, FiTrash2, FiPlus, FiX, FiDollarSign, FiUsers, FiTrendingUp } from 'react-icons/fi';
import toast from 'react-hot-toast';
import { courseService, feeService, seatService, cutoffService } from '../../services/collegeService';
import collegeService from '../../services/collegeService';

const ManageCourses = () => {
    const [courses, setCourses] = useState([]);
    const [colleges, setColleges] = useState([]);
    const [selectedCourse, setSelectedCourse] = useState(null);
    const [showCourseModal, setShowCourseModal] = useState(false);
    const [showFeeModal, setShowFeeModal] = useState(false);
    const [showSeatModal, setShowSeatModal] = useState(false);
    const [showCutoffModal, setShowCutoffModal] = useState(false);
    const [loading, setLoading] = useState(true);
    const [selectedCollegeId, setSelectedCollegeId] = useState('');

    const { register: registerCourse, handleSubmit: handleSubmitCourse, reset: resetCourse, setValue: setValueCourse } = useForm();
    const { register: registerFee, handleSubmit: handleSubmitFee, reset: resetFee } = useForm();
    const { register: registerSeat, handleSubmit: handleSubmitSeat, reset: resetSeat } = useForm();
    const { register: registerCutoff, handleSubmit: handleSubmitCutoff, reset: resetCutoff } = useForm();

    useEffect(() => {
        fetchColleges();
    }, []);

    useEffect(() => {
        if (selectedCollegeId) {
            fetchCourses();
        }
    }, [selectedCollegeId]);

    const fetchColleges = async () => {
        try {
            const response = await collegeService.getAll();
            setColleges(response.data);
        } catch (error) {
            toast.error('Failed to fetch colleges');
        }
    };

    const fetchCourses = async () => {
        try {
            setLoading(true);
            const response = await courseService.getByCollegeId(selectedCollegeId);
            setCourses(response.data);
        } catch (error) {
            toast.error('Failed to fetch courses');
        } finally {
            setLoading(false);
        }
    };

    const handleAddCourse = () => {
        setSelectedCourse(null);
        resetCourse({
            name: '',
            specialization: '',
            degree: 'UG',
            durationYears: 4,
            description: '',
            eligibility: '',
            active: true
        });
        setShowCourseModal(true);
    };

    const handleEditCourse = (course) => {
        setSelectedCourse(course);
        setValueCourse('name', course.name);
        setValueCourse('specialization', course.specialization);
        setValueCourse('degree', course.degree);
        setValueCourse('durationYears', course.durationYears);
        setValueCourse('description', course.description);
        setValueCourse('eligibility', course.eligibility);
        setValueCourse('active', course.active);
        setShowCourseModal(true);
    };

    const handleSaveCourse = async (data) => {
        try {
            const courseData = {
                ...data,
                collegeId: selectedCollegeId
            };

            if (selectedCourse) {
                await courseService.update(selectedCourse.id, courseData);
                toast.success('Course updated successfully!');
            } else {
                await courseService.create(courseData);
                toast.success('Course created successfully!');
            }

            setShowCourseModal(false);
            fetchCourses();
        } catch (error) {
            toast.error(error.response?.data?.message || 'Failed to save course');
        }
    };

    const handleDeleteCourse = async (id) => {
        if (window.confirm('Are you sure you want to delete this course?')) {
            try {
                await courseService.delete(id);
                toast.success('Course deleted successfully!');
                fetchCourses();
            } catch (error) {
                toast.error('Failed to delete course');
            }
        }
    };

    const handleManageFees = (course) => {
        setSelectedCourse(course);
        resetFee({
            academicYear: '2024-2025',
            tuitionFee: 0,
            hostelFee: 0,
            transportFee: 0,
            libraryFee: 0,
            labFee: 0,
            otherFees: 0,
            feeType: 'PER_YEAR',
            remarks: ''
        });
        setShowFeeModal(true);
    };

    const handleSaveFee = async (data) => {
        try {
            const totalFee = parseFloat(data.tuitionFee || 0) +
                parseFloat(data.hostelFee || 0) +
                parseFloat(data.transportFee || 0) +
                parseFloat(data.libraryFee || 0) +
                parseFloat(data.labFee || 0) +
                parseFloat(data.otherFees || 0);

            const feeData = {
                ...data,
                courseId: selectedCourse.id,
                totalFee
            };

            await feeService.create(feeData);
            toast.success('Fee structure added successfully!');
            setShowFeeModal(false);
        } catch (error) {
            toast.error(error.response?.data?.message || 'Failed to add fee structure');
        }
    };

    const handleManageSeats = (course) => {
        setSelectedCourse(course);
        resetSeat({
            academicYear: '2024-2025',
            category: 'GENERAL',
            totalSeats: 0,
            availableSeats: 0
        });
        setShowSeatModal(true);
    };

    const handleSaveSeat = async (data) => {
        try {
            const seatData = {
                ...data,
                courseId: selectedCourse.id
            };

            await seatService.create(seatData);
            toast.success('Seat matrix added successfully!');
            setShowSeatModal(false);
        } catch (error) {
            toast.error(error.response?.data?.message || 'Failed to add seat matrix');
        }
    };

    const handleManageCutoffs = (course) => {
        setSelectedCourse(course);
        resetCutoff({
            academicYear: '2024-2025',
            category: 'GENERAL',
            round: 'Round 1',
            cutoffPercentage: 0,
            cutoffRank: 0,
            examType: 'JEE Main'
        });
        setShowCutoffModal(true);
    };

    const handleSaveCutoff = async (data) => {
        try {
            const cutoffData = {
                ...data,
                courseId: selectedCourse.id
            };

            await cutoffService.create(cutoffData);
            toast.success('Cutoff added successfully!');
            setShowCutoffModal(false);
        } catch (error) {
            toast.error(error.response?.data?.message || 'Failed to add cutoff');
        }
    };

    return (
        <div className="p-6">
            <div className="flex justify-between items-center mb-6">
                <h1 className="text-3xl font-bold text-gray-900 dark:text-white">Manage Courses</h1>
            </div>

            {/* College Selector */}
            <div className="card p-6 mb-6">
                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                    Select College
                </label>
                <select
                    value={selectedCollegeId}
                    onChange={(e) => setSelectedCollegeId(e.target.value)}
                    className="input-field w-full max-w-md"
                >
                    <option value="">-- Select a College --</option>
                    {colleges.map((college) => (
                        <option key={college.id} value={college.id}>
                            {college.name} ({college.city})
                        </option>
                    ))}
                </select>
            </div>

            {selectedCollegeId && (
                <>
                    <div className="flex justify-end mb-4">
                        <button onClick={handleAddCourse} className="btn-primary flex items-center space-x-2">
                            <FiPlus />
                            <span>Add New Course</span>
                        </button>
                    </div>

                    {/* Courses List */}
                    <div className="card p-6">
                        {loading ? (
                            <p className="text-center text-gray-500 dark:text-gray-400">Loading courses...</p>
                        ) : courses.length === 0 ? (
                            <p className="text-center text-gray-500 dark:text-gray-400">No courses found for this college.</p>
                        ) : (
                            <div className="overflow-x-auto">
                                <table className="w-full">
                                    <thead className="bg-gray-50 dark:bg-gray-800 border-b border-gray-200 dark:border-gray-700">
                                        <tr>
                                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                                Course
                                            </th>
                                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                                Degree
                                            </th>
                                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">
                                                Duration
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
                                        {courses.map((course) => (
                                            <tr key={course.id} className="hover:bg-gray-50 dark:hover:bg-gray-800">
                                                <td className="px-6 py-4">
                                                    <div>
                                                        <div className="text-sm font-medium text-gray-900 dark:text-white">
                                                            {course.name} - {course.specialization}
                                                        </div>
                                                        <div className="text-sm text-gray-500 dark:text-gray-400">
                                                            {course.eligibility?.substring(0, 50)}...
                                                        </div>
                                                    </div>
                                                </td>
                                                <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-white">
                                                    {course.degree}
                                                </td>
                                                <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-white">
                                                    {course.durationYears} Years
                                                </td>
                                                <td className="px-6 py-4 whitespace-nowrap">
                                                    <span className={`px-2 py-1 text-xs rounded-full ${course.active ? 'bg-green-100 text-green-800 dark:bg-green-900 dark:text-green-200' : 'bg-red-100 text-red-800 dark:bg-red-900 dark:text-red-200'}`}>
                                                        {course.active ? 'Active' : 'Inactive'}
                                                    </span>
                                                </td>
                                                <td className="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                                    <div className="flex justify-end space-x-2">
                                                        <button
                                                            onClick={() => handleManageFees(course)}
                                                            className="text-green-600 hover:text-green-900 dark:text-green-400 dark:hover:text-green-300"
                                                            title="Manage Fees"
                                                        >
                                                            <FiDollarSign size={18} />
                                                        </button>
                                                        <button
                                                            onClick={() => handleManageSeats(course)}
                                                            className="text-blue-600 hover:text-blue-900 dark:text-blue-400 dark:hover:text-blue-300"
                                                            title="Manage Seats"
                                                        >
                                                            <FiUsers size={18} />
                                                        </button>
                                                        <button
                                                            onClick={() => handleManageCutoffs(course)}
                                                            className="text-purple-600 hover:text-purple-900 dark:text-purple-400 dark:hover:text-purple-300"
                                                            title="Manage Cutoffs"
                                                        >
                                                            <FiTrendingUp size={18} />
                                                        </button>
                                                        <button
                                                            onClick={() => handleEditCourse(course)}
                                                            className="text-primary-600 hover:text-primary-900 dark:text-primary-400 dark:hover:text-primary-300"
                                                            title="Edit Course"
                                                        >
                                                            <FiEdit2 size={18} />
                                                        </button>
                                                        <button
                                                            onClick={() => handleDeleteCourse(course.id)}
                                                            className="text-red-600 hover:text-red-900 dark:text-red-400 dark:hover:text-red-300"
                                                            title="Delete Course"
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
                </>
            )}

            {/* Course Modal */}
            {showCourseModal && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
                    <div className="bg-white dark:bg-gray-800 rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto">
                        <div className="flex justify-between items-center p-6 border-b border-gray-200 dark:border-gray-700">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white">
                                {selectedCourse ? 'Edit Course' : 'Add New Course'}
                            </h2>
                            <button onClick={() => setShowCourseModal(false)} className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300">
                                <FiX size={24} />
                            </button>
                        </div>

                        <form onSubmit={handleSubmitCourse(handleSaveCourse)} className="p-6 space-y-4">
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Course Name *
                                    </label>
                                    <input type="text" {...registerCourse('name', { required: true })} className="input-field" placeholder="e.g., B.Tech, M.Tech, MBA" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Specialization *
                                    </label>
                                    <input type="text" {...registerCourse('specialization', { required: true })} className="input-field" placeholder="e.g., Computer Science" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Degree Type *
                                    </label>
                                    <select {...registerCourse('degree', { required: true })} className="input-field">
                                        <option value="UG">UG (Undergraduate)</option>
                                        <option value="PG">PG (Postgraduate)</option>
                                        <option value="Diploma">Diploma</option>
                                        <option value="Certificate">Certificate</option>
                                    </select>
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Duration (Years) *
                                    </label>
                                    <input type="number" {...registerCourse('durationYears', { required: true, min: 1 })} className="input-field" placeholder="e.g., 4" />
                                </div>
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Description
                                </label>
                                <textarea {...registerCourse('description')} rows="4" className="input-field" placeholder="Course description..."></textarea>
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Eligibility Criteria
                                </label>
                                <textarea {...registerCourse('eligibility')} rows="2" className="input-field" placeholder="e.g., 10+2 with PCM and minimum 60% marks"></textarea>
                            </div>

                            <div className="flex items-center">
                                <input type="checkbox" {...registerCourse('active')} className="mr-2" id="courseActive" />
                                <label htmlFor="courseActive" className="text-sm font-medium text-gray-700 dark:text-gray-300">
                                    Active
                                </label>
                            </div>

                            <div className="flex justify-end space-x-3 pt-4 border-t border-gray-200 dark:border-gray-700">
                                <button type="button" onClick={() => setShowCourseModal(false)} className="px-4 py-2 text-gray-700 dark:text-gray-300 hover:bg-gray-100 dark:hover:bg-gray-700 rounded-lg">
                                    Cancel
                                </button>
                                <button type="submit" className="btn-primary">
                                    {selectedCourse ? 'Update Course' : 'Create Course'}
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            )}

            {/* Fee Modal */}
            {showFeeModal && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
                    <div className="bg-white dark:bg-gray-800 rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto">
                        <div className="flex justify-between items-center p-6 border-b border-gray-200 dark:border-gray-700">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white">
                                Add Fee Structure - {selectedCourse?.name} ({selectedCourse?.specialization})
                            </h2>
                            <button onClick={() => setShowFeeModal(false)} className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300">
                                <FiX size={24} />
                            </button>
                        </div>

                        <form onSubmit={handleSubmitFee(handleSaveFee)} className="p-6 space-y-4">
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Academic Year *
                                    </label>
                                    <input type="text" {...registerFee('academicYear', { required: true })} className="input-field" placeholder="e.g., 2024-2025" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Fee Type *
                                    </label>
                                    <select {...registerFee('feeType', { required: true })} className="input-field">
                                        <option value="PER_YEAR">Per Year</option>
                                        <option value="PER_SEMESTER">Per Semester</option>
                                        <option value="ONE_TIME">One Time</option>
                                    </select>
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Tuition Fee (₹) *
                                    </label>
                                    <input type="number" step="0.01" {...registerFee('tuitionFee', { required: true })} className="input-field" placeholder="0.00" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Hostel Fee (₹)
                                    </label>
                                    <input type="number" step="0.01" {...registerFee('hostelFee')} className="input-field" placeholder="0.00" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Transport Fee (₹)
                                    </label>
                                    <input type="number" step="0.01" {...registerFee('transportFee')} className="input-field" placeholder="0.00" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Library Fee (₹)
                                    </label>
                                    <input type="number" step="0.01" {...registerFee('libraryFee')} className="input-field" placeholder="0.00" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Lab Fee (₹)
                                    </label>
                                    <input type="number" step="0.01" {...registerFee('labFee')} className="input-field" placeholder="0.00" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Other Fees (₹)
                                    </label>
                                    <input type="number" step="0.01" {...registerFee('otherFees')} className="input-field" placeholder="0.00" />
                                </div>
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Remarks
                                </label>
                                <textarea {...registerFee('remarks')} rows="2" className="input-field" placeholder="Any additional notes..."></textarea>
                            </div>

                            <div className="flex justify-end space-x-3 pt-4 border-t border-gray-200 dark:border-gray-700">
                                <button type="button" onClick={() => setShowFeeModal(false)} className="px-4 py-2 text-gray-700 dark:text-gray-300 hover:bg-gray-100 dark:hover:bg-gray-700 rounded-lg">
                                    Cancel
                                </button>
                                <button type="submit" className="btn-primary">
                                    Add Fee Structure
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            )}

            {/* Seat Matrix Modal */}
            {showSeatModal && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
                    <div className="bg-white dark:bg-gray-800 rounded-lg max-w-md w-full">
                        <div className="flex justify-between items-center p-6 border-b border-gray-200 dark:border-gray-700">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white">
                                Add Seat Matrix - {selectedCourse?.name}
                            </h2>
                            <button onClick={() => setShowSeatModal(false)} className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300">
                                <FiX size={24} />
                            </button>
                        </div>

                        <form onSubmit={handleSubmitSeat(handleSaveSeat)} className="p-6 space-y-4">
                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Academic Year *
                                </label>
                                <input type="text" {...registerSeat('academicYear', { required: true })} className="input-field" placeholder="e.g., 2024-2025" />
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Category *
                                </label>
                                <select {...registerSeat('category', { required: true })} className="input-field">
                                    <option value="GENERAL">GENERAL</option>
                                    <option value="OBC">OBC</option>
                                    <option value="SC">SC</option>
                                    <option value="ST">ST</option>
                                    <option value="EWS">EWS</option>
                                </select>
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Total Seats *
                                </label>
                                <input type="number" {...registerSeat('totalSeats', { required: true, min: 0 })} className="input-field" placeholder="0" />
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Available Seats *
                                </label>
                                <input type="number" {...registerSeat('availableSeats', { required: true, min: 0 })} className="input-field" placeholder="0" />
                            </div>

                            <div className="flex justify-end space-x-3 pt-4 border-t border-gray-200 dark:border-gray-700">
                                <button type="button" onClick={() => setShowSeatModal(false)} className="px-4 py-2 text-gray-700 dark:text-gray-300 hover:bg-gray-100 dark:hover:bg-gray-700 rounded-lg">
                                    Cancel
                                </button>
                                <button type="submit" className="btn-primary">
                                    Add Seat Matrix
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            )}

            {/* Cutoff Modal */}
            {showCutoffModal && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
                    <div className="bg-white dark:bg-gray-800 rounded-lg max-w-2xl w-full max-h-[90vh] overflow-y-auto">
                        <div className="flex justify-between items-center p-6 border-b border-gray-200 dark:border-gray-700">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white">
                                Add Cutoff - {selectedCourse?.name} ({selectedCourse?.specialization})
                            </h2>
                            <button onClick={() => setShowCutoffModal(false)} className="text-gray-500 hover:text-gray-700 dark:text-gray-400 dark:hover:text-gray-300">
                                <FiX size={24} />
                            </button>
                        </div>

                        <form onSubmit={handleSubmitCutoff(handleSaveCutoff)} className="p-6 space-y-4">
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Academic Year *
                                    </label>
                                    <input type="text" {...registerCutoff('academicYear', { required: true })} className="input-field" placeholder="e.g., 2024-2025" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Category *
                                    </label>
                                    <select {...registerCutoff('category', { required: true })} className="input-field">
                                        <option value="GENERAL">GENERAL</option>
                                        <option value="OBC">OBC</option>
                                        <option value="SC">SC</option>
                                        <option value="ST">ST</option>
                                        <option value="EWS">EWS</option>
                                    </select>
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Round *
                                    </label>
                                    <input type="text" {...registerCutoff('round', { required: true })} className="input-field" placeholder="e.g., Round 1, Round 2, Final" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Exam Type *
                                    </label>
                                    <select {...registerCutoff('examType', { required: true })} className="input-field">
                                        <option value="JEE Main">JEE Main</option>
                                        <option value="JEE Advanced">JEE Advanced</option>
                                        <option value="NEET">NEET</option>
                                        <option value="CAT">CAT</option>
                                        <option value="GATE">GATE</option>
                                        <option value="State Entrance">State Entrance</option>
                                        <option value="CUET">CUET</option>
                                        <option value="Other">Other</option>
                                    </select>
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Cutoff Percentage (%)
                                    </label>
                                    <input type="number" step="0.01" {...registerCutoff('cutoffPercentage')} className="input-field" placeholder="e.g., 85.5" />
                                </div>

                                <div>
                                    <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                        Cutoff Rank
                                    </label>
                                    <input type="number" {...registerCutoff('cutoffRank')} className="input-field" placeholder="e.g., 12500" />
                                </div>
                            </div>

                            <div className="bg-blue-50 dark:bg-blue-900/20 border border-blue-200 dark:border-blue-800 rounded-lg p-4">
                                <p className="text-sm text-blue-800 dark:text-blue-200">
                                    <strong>Note:</strong> Enter either Cutoff Percentage OR Cutoff Rank based on the exam type. For JEE/NEET, rank is more relevant. For 12th board-based admissions, percentage is used.
                                </p>
                            </div>

                            <div className="flex justify-end space-x-3 pt-4 border-t border-gray-200 dark:border-gray-700">
                                <button type="button" onClick={() => setShowCutoffModal(false)} className="px-4 py-2 text-gray-700 dark:text-gray-300 hover:bg-gray-100 dark:hover:bg-gray-700 rounded-lg">
                                    Cancel
                                </button>
                                <button type="submit" className="btn-primary">
                                    Add Cutoff
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            )}
        </div>
    );
};

export default ManageCourses;
