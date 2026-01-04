import { useState, useEffect } from 'react';
import { FiPhone, FiMail, FiMapPin, FiSend } from 'react-icons/fi';
import leadService from '../services/leadService';
import trackPageVisit from '../utils/tracking';

const Contact = () => {
    const [submitted, setSubmitted] = useState(false);
    const [loading, setLoading] = useState(false);
    const [formData, setFormData] = useState({
        studentName: '',
        mobile: '',
        email: '',
        interestedCourse: '',
        message: '',
        leadSource: 'CONTACT_FORM',
    });

    useEffect(() => {
        trackPageVisit('/contact', 'Contact');
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
            setFormData({
                studentName: '',
                mobile: '',
                email: '',
                interestedCourse: '',
                message: '',
                leadSource: 'CONTACT_FORM',
            });
        } catch (error) {
            console.error('Failed to submit:', error);
            alert('Failed to send message. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 py-12 px-4">
            <div className="max-w-6xl mx-auto">
                <div className="text-center mb-12">
                    <h1 className="text-4xl font-bold text-gray-900 dark:text-white mb-4">
                        Get In Touch
                    </h1>
                    <p className="text-xl text-gray-600 dark:text-gray-400">
                        We're here to help you find your dream college
                    </p>
                </div>

                <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
                    {/* Contact Information */}
                    <div className="space-y-6">
                        <div className="card p-8">
                            <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-6">
                                Contact Information
                            </h2>

                            <div className="space-y-6">
                                <div className="flex items-start space-x-4">
                                    <div className="w-12 h-12 bg-primary-100 dark:bg-primary-900 rounded-lg flex items-center justify-center flex-shrink-0">
                                        <FiPhone className="w-6 h-6 text-primary-600 dark:text-primary-400" />
                                    </div>
                                    <div>
                                        <h3 className="font-semibold text-gray-900 dark:text-white mb-1">Phone</h3>
                                        <a href="tel:9009536046" className="text-primary-600 hover:text-primary-700 text-lg">
                                            9009536046
                                        </a>
                                        <p className="text-sm text-gray-600 dark:text-gray-400 mt-1">
                                            Mon-Sat, 9:00 AM - 6:00 PM
                                        </p>
                                    </div>
                                </div>

                                <div className="flex items-start space-x-4">
                                    <div className="w-12 h-12 bg-secondary-100 dark:bg-secondary-900 rounded-lg flex items-center justify-center flex-shrink-0">
                                        <FiMail className="w-6 h-6 text-secondary-600 dark:text-secondary-400" />
                                    </div>
                                    <div>
                                        <h3 className="font-semibold text-gray-900 dark:text-white mb-1">Email</h3>
                                        <a href="mailto:princesulekhiya2004@gmail.com" className="text-primary-600 hover:text-primary-700 break-all">
                                            princesulekhiya2004@gmail.com
                                        </a>
                                        <p className="text-sm text-gray-600 dark:text-gray-400 mt-1">
                                            We'll respond within 24 hours
                                        </p>
                                    </div>
                                </div>

                                <div className="flex items-start space-x-4">
                                    <div className="w-12 h-12 bg-green-100 dark:bg-green-900 rounded-lg flex items-center justify-center flex-shrink-0">
                                        <FiMapPin className="w-6 h-6 text-green-600 dark:text-green-400" />
                                    </div>
                                    <div>
                                        <h3 className="font-semibold text-gray-900 dark:text-white mb-1">Office</h3>
                                        <p className="text-gray-600 dark:text-gray-400">
                                            India
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        {/* YouTube */}
                        <div className="card p-8 bg-gradient-to-br from-red-500 to-red-600 text-white">
                            <h3 className="text-2xl font-bold mb-4">Watch Our Videos</h3>
                            <p className="mb-6">
                                Subscribe to our YouTube channel for college reviews, admission tips, and career guidance
                            </p>
                            <a
                                href="https://youtube.com/@princesulekhiya"
                                target="_blank"
                                rel="noopener noreferrer"
                                className="btn-primary bg-white text-red-600 hover:bg-gray-100 inline-block"
                            >
                                Visit YouTube Channel
                            </a>
                        </div>
                    </div>

                    {/* Contact Form */}
                    <div className="card p-8">
                        <h2 className="text-2xl font-bold text-gray-900 dark:text-white mb-6">
                            Send Us a Message
                        </h2>

                        {submitted && (
                            <div className="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded mb-6">
                                Message sent successfully! We'll get back to you soon.
                            </div>
                        )}

                        <form onSubmit={handleSubmit} className="space-y-6">
                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                                    Your Name *
                                </label>
                                <input
                                    type="text"
                                    name="studentName"
                                    value={formData.studentName}
                                    onChange={handleChange}
                                    className="input-field"
                                    required
                                />
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                                    Mobile Number *
                                </label>
                                <input
                                    type="tel"
                                    name="mobile"
                                    value={formData.mobile}
                                    onChange={handleChange}
                                    className="input-field"
                                    pattern="[0-9]{10}"
                                    required
                                />
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                                    Email Address *
                                </label>
                                <input
                                    type="email"
                                    name="email"
                                    value={formData.email}
                                    onChange={handleChange}
                                    className="input-field"
                                    required
                                />
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                                    Interested Course
                                </label>
                                <select
                                    name="interestedCourse"
                                    value={formData.interestedCourse}
                                    onChange={handleChange}
                                    className="input-field"
                                >
                                    <option value="">Select Course</option>
                                    <option value="B.Tech">B.Tech</option>
                                    <option value="MBBS">MBBS</option>
                                    <option value="MBA">MBA</option>
                                    <option value="B.Com">B.Com</option>
                                    <option value="BBA">BBA</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>

                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                                    Message *
                                </label>
                                <textarea
                                    name="message"
                                    value={formData.message}
                                    onChange={handleChange}
                                    rows="5"
                                    className="input-field"
                                    required
                                ></textarea>
                            </div>

                            <button
                                type="submit"
                                disabled={loading}
                                className="btn-primary w-full flex items-center justify-center space-x-2"
                            >
                                <FiSend className="w-5 h-5" />
                                <span>{loading ? 'Sending...' : 'Send Message'}</span>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Contact;
