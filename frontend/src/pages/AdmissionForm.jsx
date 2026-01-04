import { useState, useEffect } from 'react';
import { useSearchParams } from 'react-router-dom';
import { FiUser, FiMail, FiPhone, FiMapPin, FiBook, FiCheckCircle } from 'react-icons/fi';
import leadService from '../services/leadService';
import trackPageVisit from '../utils/tracking';

const AdmissionForm = () => {
    const [searchParams] = useSearchParams();
    const [submitted, setSubmitted] = useState(false);
    const [loading, setLoading] = useState(false);
    const [formData, setFormData] = useState({
        studentName: '',
        mobile: '',
        email: '',
        city: '',
        state: '',
        interestedCourse: '',
        interestedSpecialization: '',
        message: '',
        collegeId: searchParams.get('college') || '',
        collegeName: searchParams.get('name') || '',
        leadSource: 'ADMISSION_FORM',
    });

    useEffect(() => {
        trackPageVisit('/admission', 'Admission Form');
    }, []);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);

        try {
            await leadService.submit(formData);
            setSubmitted(true);
        } catch (error) {
            console.error('Failed to submit form:', error);
            alert('Failed to submit form. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    if (submitted) {
        return (
            <div className="min-h-screen bg-gray-50 dark:bg-gray-900 flex items-center justify-center py-12 px-4">
                <div className="max-w-md w-full card p-8 text-center">
                    <div className="w-20 h-20 bg-green-100 dark:bg-green-900 rounded-full flex items-center justify-center mx-auto mb-6">
                        <FiCheckCircle className="w-12 h-12 text-green-600 dark:text-green-400" />
                    </div>
                    <h2 className="text-3xl font-bold text-gray-900 dark:text-white mb-4">
                        Application Submitted!
                    </h2>
                    <p className="text-gray-600 dark:text-gray-400 mb-6">
                        Thank you for your interest. Our counsellors will contact you within 24 hours.
                    </p>
                    <div className="space-y-2 text-sm text-gray-600 dark:text-gray-400">
                        <p>For immediate assistance, call us:</p>
                        <a href="tel:9009536046" className="text-2xl font-bold text-primary-600 hover:text-primary-700">
                            9009536046
                        </a>
                    </div>
                </div>
            </div>
        );
    }

    return (
        <div className="min-h-screen bg-white dark:bg-gray-950 py-12 px-4">
            <div className="max-w-3xl mx-auto">
                <div className="text-center mb-8">
                    <h1 className="text-4xl md:text-5xl font-bold text-gray-900 dark:text-white mb-4">
                        Admission Enquiry Form
                    </h1>
                    <p className="text-lg md:text-xl text-gray-700 dark:text-gray-300">
                        Fill in your details and we'll guide you through the admission process
                    </p>
                </div>

                <div className="bg-white dark:bg-gray-900 rounded-xl border border-gray-200 dark:border-gray-800 shadow-lg p-8">
                    <form onSubmit={handleSubmit} className="space-y-6">
                        {/* Personal Information */}
                        <div>
                            <h3 className="text-2xl font-bold text-gray-900 dark:text-white mb-6">Personal Information</h3>
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                                <div>
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        Full Name *
                                    </label>
                                    <div className="relative">
                                        <FiUser className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500 dark:text-gray-400" />
                                        <input
                                            type="text"
                                            name="studentName"
                                            value={formData.studentName}
                                            onChange={handleChange}
                                            className="w-full px-4 py-3 pl-10 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition"
                                            required
                                        />
                                    </div>
                                </div>

                                <div>
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        Mobile Number *
                                    </label>
                                    <div className="relative">
                                        <FiPhone className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500 dark:text-gray-400" />
                                        <input
                                            type="tel"
                                            name="mobile"
                                            value={formData.mobile}
                                            onChange={handleChange}
                                            className="w-full px-4 py-3 pl-10 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition"
                                            pattern="[0-9]{10}"
                                            required
                                        />
                                    </div>
                                </div>

                                <div>
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        Email Address *
                                    </label>
                                    <div className="relative">
                                        <FiMail className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500 dark:text-gray-400" />
                                        <input
                                            type="email"
                                            name="email"
                                            value={formData.email}
                                            onChange={handleChange}
                                            className="w-full px-4 py-3 pl-10 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition"
                                            required
                                        />
                                    </div>
                                </div>

                                <div>
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        City
                                    </label>
                                    <div className="relative">
                                        <FiMapPin className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500 dark:text-gray-400" />
                                        <input
                                            type="text"
                                            name="city"
                                            value={formData.city}
                                            onChange={handleChange}
                                            className="w-full px-4 py-3 pl-10 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition"
                                        />
                                    </div>
                                </div>

                                <div className="md:col-span-2">
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        State
                                    </label>
                                    <select
                                        name="state"
                                        value={formData.state}
                                        onChange={handleChange}
                                        className="w-full px-4 py-3 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition"
                                    >
                                        <option value="">Select State</option>
                                        <option value="Delhi">Delhi</option>
                                        <option value="Maharashtra">Maharashtra</option>
                                        <option value="Karnataka">Karnataka</option>
                                        <option value="Tamil Nadu">Tamil Nadu</option>
                                        <option value="Uttar Pradesh">Uttar Pradesh</option>
                                        <option value="West Bengal">West Bengal</option>
                                        <option value="Gujarat">Gujarat</option>
                                        <option value="Punjab">Punjab</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        {/* Course Information */}
                        <div>
                            <h3 className="text-2xl font-bold text-gray-900 dark:text-white mb-6">Course Interest</h3>
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                                <div>
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        Interested Course *
                                    </label>
                                    <div className="relative">
                                        <FiBook className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500 dark:text-gray-400" />
                                        <select
                                            name="interestedCourse"
                                            value={formData.interestedCourse}
                                            onChange={handleChange}
                                            className="w-full px-4 py-3 pl-10 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition"
                                            required
                                        >
                                            <option value="">Select Course</option>
                                            <option value="B.Tech">B.Tech</option>
                                            <option value="MBBS">MBBS</option>
                                            <option value="MBA">MBA</option>
                                            <option value="B.Com">B.Com</option>
                                            <option value="BBA">BBA</option>
                                            <option value="M.Tech">M.Tech</option>
                                            <option value="Other">Other</option>
                                        </select>
                                    </div>
                                </div>

                                <div>
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        Specialization
                                    </label>
                                    <input
                                        type="text"
                                        name="interestedSpecialization"
                                        value={formData.interestedSpecialization}
                                        onChange={handleChange}
                                        className="w-full px-4 py-3 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition placeholder-gray-500 dark:placeholder-gray-400"
                                        placeholder="e.g., Computer Science"
                                    />
                                </div>

                                {formData.collegeName && (
                                    <div className="md:col-span-2">
                                        <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                            Interested College
                                        </label>
                                        <input
                                            type="text"
                                            value={formData.collegeName}
                                            className="w-full px-4 py-3 bg-gray-100 dark:bg-gray-700 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-600 rounded-lg cursor-not-allowed"
                                            readOnly
                                        />
                                    </div>
                                )}

                                <div className="md:col-span-2">
                                    <label className="block text-sm font-semibold text-gray-800 dark:text-gray-200 mb-2">
                                        Additional Message
                                    </label>
                                    <textarea
                                        name="message"
                                        value={formData.message}
                                        onChange={handleChange}
                                        rows="4"
                                        className="w-full px-4 py-3 bg-gray-50 dark:bg-gray-800 text-gray-900 dark:text-white border border-gray-300 dark:border-gray-700 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 dark:focus:ring-blue-400 transition placeholder-gray-500 dark:placeholder-gray-400"
                                        placeholder="Any specific questions or requirements..."
                                    ></textarea>
                                </div>
                            </div>
                        </div>

                        {/* Submit Button */}
                        <div className="flex flex-col sm:flex-row gap-4 pt-4">
                            <button
                                type="submit"
                                disabled={loading}
                                className="flex-1 px-6 py-3 bg-blue-600 hover:bg-blue-700 disabled:bg-blue-400 text-white font-semibold rounded-lg shadow-md hover:shadow-lg transition-all duration-200 transform hover:scale-[1.02] disabled:cursor-not-allowed"
                            >
                                {loading ? 'Submitting...' : 'Submit Application'}
                            </button>
                            <a href="tel:9009536046" className="flex-1 px-6 py-3 bg-gray-200 dark:bg-gray-800 hover:bg-gray-300 dark:hover:bg-gray-700 text-gray-900 dark:text-white font-semibold rounded-lg border border-gray-300 dark:border-gray-600 shadow-md hover:shadow-lg transition-all duration-200 transform hover:scale-[1.02] text-center">
                                Call Us: 9009536046
                            </a>
                        </div>
                    </form>
                </div>

                {/* Contact Info */}
                <div className="mt-12 bg-gradient-to-r from-blue-50 to-indigo-50 dark:from-gray-800 dark:to-gray-900 rounded-xl p-8 border border-blue-200 dark:border-gray-700">
                    <div className="text-center">
                        <p className="text-gray-700 dark:text-gray-400 mb-4">Need help filling the form?</p>
                        <h3 className="text-2xl md:text-3xl font-bold text-gray-900 dark:text-white mb-4">Contact Mr Prince Sulekhiya</h3>
                        <div className="flex flex-col sm:flex-row items-center justify-center gap-6">
                            <div>
                                <p className="text-sm text-gray-600 dark:text-gray-400 mb-1">📧 Email</p>
                                <a href="mailto:princesulekhiya2004@gmail.com" className="text-lg font-semibold text-blue-600 dark:text-blue-400 hover:text-blue-700 dark:hover:text-blue-300">
                                    princesulekhiya2004@gmail.com
                                </a>
                            </div>
                            <div className="hidden sm:block text-gray-400">|</div>
                            <div>
                                <p className="text-sm text-gray-600 dark:text-gray-400 mb-1">📞 Phone</p>
                                <a href="tel:9009536046" className="text-lg font-semibold text-blue-600 dark:text-blue-400 hover:text-blue-700 dark:hover:text-blue-300">
                                    9009536046
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AdmissionForm;
