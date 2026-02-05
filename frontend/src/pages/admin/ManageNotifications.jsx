import { useState, useEffect } from 'react';
import { FiBell, FiPlus, FiTrash, FiToggleLeft, FiToggleRight, FiLink } from 'react-icons/fi';
import notificationService from '../../services/notificationService';
import LoadingSpinner from '../../components/LoadingSpinner';

const ManageNotifications = () => {
    const [notifications, setNotifications] = useState([]);
    const [loading, setLoading] = useState(true);
    const [submitting, setSubmitting] = useState(false);
    const [formData, setFormData] = useState({
        text: '',
        link: '',
        isUrgent: false,
    });
    const [showForm, setShowForm] = useState(false);

    useEffect(() => {
        loadNotifications();
    }, []);

    const loadNotifications = async () => {
        try {
            const response = await notificationService.getAll();
            setNotifications(response.data);
        } catch (error) {
            // Silently handle 403 (not authenticated) errors
            if (error.response?.status !== 403) {
                console.error('Failed to load notifications:', error);
            }
        } finally {
            setLoading(false);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setSubmitting(true);
        try {
            await notificationService.create(formData);
            setFormData({ text: '', link: '', isUrgent: false });
            setShowForm(false);
            loadNotifications();
        } catch (error) {
            console.error('Failed to create notification:', error);
            alert('Failed to create notification');
        } finally {
            setSubmitting(false);
        }
    };

    const handleToggle = async (id) => {
        try {
            await notificationService.toggleStatus(id);
            loadNotifications();
        } catch (error) {
            console.error('Failed to toggle status:', error);
        }
    };

    const handleDelete = async (id) => {
        if (!window.confirm('Are you sure you want to delete this notification?')) return;
        try {
            await notificationService.delete(id);
            setNotifications(notifications.filter(n => n.id !== id));
        } catch (error) {
            console.error('Failed to delete notification:', error);
        }
    };

    if (loading) return <LoadingSpinner />;

    return (
        <div className="space-y-6">
            <div className="flex justify-between items-center">
                <h2 className="text-2xl font-bold text-gray-900 dark:text-white flex items-center">
                    <FiBell className="mr-2" /> Manage Notifications
                </h2>
                <button
                    onClick={() => setShowForm(!showForm)}
                    className="btn-primary flex items-center space-x-2"
                >
                    <FiPlus />
                    <span>{showForm ? 'Cancel' : 'Add Notification'}</span>
                </button>
            </div>

            {/* Add Notification Form */}
            {showForm && (
                <div className="card p-6 border-l-4 border-primary-500 animate-fade-in">
                    <h3 className="text-lg font-bold text-gray-900 dark:text-white mb-4">New Notification</h3>
                    <form onSubmit={handleSubmit} className="space-y-4">
                        <div>
                            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                Notification Text *
                            </label>
                            <input
                                type="text"
                                value={formData.text}
                                onChange={(e) => setFormData({ ...formData, text: e.target.value })}
                                className="input-field w-full"
                                placeholder="e.g., JEE Main 2024 Registration Extended!"
                                required
                            />
                        </div>
                        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Event/Start Date (Optional)
                                </label>
                                <input
                                    type="text"
                                    value={formData.eventDate || ''}
                                    onChange={(e) => setFormData({ ...formData, eventDate: e.target.value })}
                                    className="input-field w-full"
                                    placeholder="e.g., 25th Jan 2024"
                                />
                            </div>
                            <div>
                                <label className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
                                    Link (Optional)
                                </label>
                                <div className="relative">
                                    <FiLink className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" />
                                    <input
                                        type="url"
                                        value={formData.link}
                                        onChange={(e) => setFormData({ ...formData, link: e.target.value })}
                                        className="input-field w-full pl-10"
                                        placeholder="https://example.com"
                                    />
                                </div>
                            </div>
                            <div className="flex items-center pt-6">
                                <label className="flex items-center space-x-3 cursor-pointer">
                                    <input
                                        type="checkbox"
                                        checked={formData.isUrgent}
                                        onChange={(e) => setFormData({ ...formData, isUrgent: e.target.checked })}
                                        className="form-checkbox h-5 w-5 text-primary-600 rounded bg-gray-100 dark:bg-gray-800 border-gray-300 dark:border-gray-600"
                                    />
                                    <span className="text-gray-700 dark:text-gray-300 font-medium">Mark as Urgent/Important</span>
                                </label>
                            </div>
                        </div>
                        <button
                            type="submit"
                            disabled={submitting}
                            className="bg-primary-600 hover:bg-primary-700 text-white px-6 py-2 rounded-lg font-medium transition disabled:bg-gray-400"
                        >
                            {submitting ? 'Adding...' : 'Add Notification'}
                        </button>
                    </form>
                </div>
            )}

            {/* Notifications List */}
            <div className="card p-0 overflow-hidden">
                <table className="w-full">
                    <thead className="bg-gray-50 dark:bg-gray-700">
                        <tr>
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">
                                Notification
                            </th>
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">
                                Status
                            </th>
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">
                                Created At
                            </th>
                            <th className="px-6 py-3 text-right text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">
                                Actions
                            </th>
                        </tr>
                    </thead>
                    <tbody className="bg-white dark:bg-gray-800 divide-y divide-gray-200 dark:divide-gray-700">
                        {notifications.length === 0 ? (
                            <tr>
                                <td colSpan="4" className="px-6 py-8 text-center text-gray-500 dark:text-gray-400">
                                    No notifications found. Create one to get started!
                                </td>
                            </tr>
                        ) : (
                            notifications.map((note) => (
                                <tr key={note.id} className="hover:bg-gray-50 dark:hover:bg-gray-750 transition">
                                    <td className="px-6 py-4">
                                        <div className="flex items-center">
                                            {note.isUrgent && (
                                                <span className="bg-red-100 text-red-800 text-xs px-2 py-0.5 rounded mr-2 font-bold animate-pulse">
                                                    URGENT
                                                </span>
                                            )}
                                            <div className="text-sm font-medium text-gray-900 dark:text-white">
                                                {note.text}
                                            </div>
                                        </div>

                                        <div className="flex items-center space-x-4 mt-1">
                                            {note.eventDate && (
                                                <span className="text-xs font-semibold text-primary-600 dark:text-primary-400 bg-primary-50 dark:bg-primary-900/30 px-2 py-0.5 rounded">
                                                    📅 {note.eventDate}
                                                </span>
                                            )}
                                            {note.link && (
                                                <a href={note.link} target="_blank" rel="noopener noreferrer" className="text-xs text-primary-500 hover:text-primary-600 flex items-center">
                                                    <FiLink className="w-3 h-3 mr-1" /> {note.link}
                                                </a>
                                            )}
                                        </div>
                                    </td>
                                    <td className="px-6 py-4 whitespace-nowrap">
                                        <button
                                            onClick={() => handleToggle(note.id)}
                                            className={`flex items-center space-x-2 text-sm focus:outline-none ${note.active ? 'text-green-600 dark:text-green-400' : 'text-gray-400'
                                                }`}
                                        >
                                            {note.active ? (
                                                <>
                                                    <FiToggleRight className="w-6 h-6" />
                                                    <span>Active</span>
                                                </>
                                            ) : (
                                                <>
                                                    <FiToggleLeft className="w-6 h-6" />
                                                    <span>Inactive</span>
                                                </>
                                            )}
                                        </button>
                                    </td>
                                    <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500 dark:text-gray-400">
                                        {new Date(note.createdAt).toLocaleDateString()}
                                    </td>
                                    <td className="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                        <button
                                            onClick={() => handleDelete(note.id)}
                                            className="text-red-600 hover:text-red-900 dark:hover:text-red-400 p-2 hover:bg-red-50 dark:hover:bg-red-900/20 rounded-full"
                                            title="Delete"
                                        >
                                            <FiTrash className="w-5 h-5" />
                                        </button>
                                    </td>
                                </tr>
                            ))
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default ManageNotifications;
