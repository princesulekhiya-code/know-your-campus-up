import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { FiUsers, FiBook, FiTrendingUp, FiEye, FiLogOut } from 'react-icons/fi';
import { useAuth } from '../../context/AuthContext';
import analyticsService from '../../services/analyticsService';
import leadService from '../../services/leadService';
import LoadingSpinner from '../../components/LoadingSpinner';

const AdminDashboard = () => {
    const { isAuthenticated, logout, user } = useAuth();
    const navigate = useNavigate();
    const [dashboard, setDashboard] = useState(null);
    const [leads, setLeads] = useState([]);
    const [loading, setLoading] = useState(true);
    const [activeTab, setActiveTab] = useState('overview');

    useEffect(() => {
        if (!isAuthenticated) {
            navigate('/login');
            return;
        }
        loadDashboardData();
    }, [isAuthenticated, navigate]);

    const loadDashboardData = async () => {
        try {
            const [dashboardRes, leadsRes] = await Promise.all([
                analyticsService.getDashboard(),
                leadService.getAll(),
            ]);
            setDashboard(dashboardRes.data);
            setLeads(leadsRes.data);
        } catch (error) {
            console.error('Failed to load dashboard:', error);
        } finally {
            setLoading(false);
        }
    };

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    if (loading) return <LoadingSpinner />;
    if (!dashboard) return <div>Failed to load dashboard</div>;

    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900">
            {/* Header */}
            <div className="bg-white dark:bg-gray-800 shadow">
                <div className="container mx-auto px-4 py-4">
                    <div className="flex justify-between items-center">
                        <div>
                            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">
                                Admin Dashboard
                            </h1>
                            <p className="text-gray-600 dark:text-gray-400">
                                Welcome back, {user?.fullName}
                            </p>
                        </div>
                        <button onClick={handleLogout} className="btn-outline flex items-center space-x-2">
                            <FiLogOut className="w-5 h-5" />
                            <span>Logout</span>
                        </button>
                    </div>
                </div>
            </div>

            <div className="container mx-auto px-4 py-8">
                {/* Stats Grid */}
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
                    <StatCard
                        icon={FiBook}
                        title="Total Colleges"
                        value={dashboard.totalColleges}
                        color="from-blue-500 to-blue-600"
                    />
                    <StatCard
                        icon={FiBook}
                        title="Total Courses"
                        value={dashboard.totalCourses}
                        color="from-purple-500 to-purple-600"
                    />
                    <StatCard
                        icon={FiUsers}
                        title="Total Leads"
                        value={dashboard.totalLeads}
                        color="from-green-500 to-green-600"
                    />
                    <StatCard
                        icon={FiTrendingUp}
                        title="New Leads Today"
                        value={dashboard.newLeadsToday}
                        color="from-yellow-500 to-yellow-600"
                    />
                </div>

                {/* Tabs */}
                <div className="mb-6">
                    <div className="flex space-x-4 border-b border-gray-200 dark:border-gray-700">
                        <button
                            onClick={() => setActiveTab('overview')}
                            className={`px-4 py-2 font-medium transition ${activeTab === 'overview'
                                    ? 'text-primary-600 border-b-2 border-primary-600'
                                    : 'text-gray-600 dark:text-gray-400'
                                }`}
                        >
                            Overview
                        </button>
                        <button
                            onClick={() => setActiveTab('leads')}
                            className={`px-4 py-2 font-medium transition ${activeTab === 'leads'
                                    ? 'text-primary-600 border-b-2 border-primary-600'
                                    : 'text-gray-600 dark:text-gray-400'
                                }`}
                        >
                            Leads ({leads.length})
                        </button>
                    </div>
                </div>

                {/* Tab Content */}
                {activeTab === 'overview' && (
                    <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
                        {/* Leads by Status */}
                        <div className="card p-6">
                            <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-4">
                                Leads by Status
                            </h3>
                            <div className="space-y-3">
                                {Object.entries(dashboard.leadsByStatus || {}).map(([status, count]) => (
                                    <div key={status} className="flex justify-between items-center">
                                        <span className="text-gray-600 dark:text-gray-400">{status}</span>
                                        <span className="font-bold text-gray-900 dark:text-white">{count}</span>
                                    </div>
                                ))}
                            </div>
                        </div>

                        {/* Most Viewed Colleges */}
                        <div className="card p-6">
                            <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-4 flex items-center">
                                <FiEye className="w-5 h-5 mr-2" />
                                Most Viewed Colleges
                            </h3>
                            <div className="space-y-3">
                                {Object.entries(dashboard.mostViewedColleges || {}).slice(0, 5).map(([name, views]) => (
                                    <div key={name} className="flex justify-between items-center">
                                        <span className="text-gray-600 dark:text-gray-400 truncate flex-1 mr-4">
                                            {name}
                                        </span>
                                        <span className="font-bold text-gray-900 dark:text-white">{views} views</span>
                                    </div>
                                ))}
                            </div>
                        </div>

                        {/* Page Views */}
                        <div className="card p-6">
                            <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-4">
                                Page Views
                            </h3>
                            <div className="space-y-3">
                                <div className="flex justify-between items-center">
                                    <span className="text-gray-600 dark:text-gray-400">Total Views</span>
                                    <span className="font-bold text-gray-900 dark:text-white">
                                        {dashboard.totalPageViews}
                                    </span>
                                </div>
                                <div className="flex justify-between items-center">
                                    <span className="text-gray-600 dark:text-gray-400">Today's Views</span>
                                    <span className="font-bold text-gray-900 dark:text-white">
                                        {dashboard.pageViewsToday}
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                )}

                {activeTab === 'leads' && (
                    <div className="card p-6">
                        <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-6">
                            All Leads
                        </h3>
                        <div className="overflow-x-auto">
                            <table className="w-full">
                                <thead className="bg-gray-50 dark:bg-gray-700">
                                    <tr>
                                        <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">
                                            Name
                                        </th>
                                        <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">
                                            Contact
                                        </th>
                                        <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">
                                            Course
                                        </th>
                                        <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">
                                            College
                                        </th>
                                        <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">
                                            Status
                                        </th>
                                        <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">
                                            Date
                                        </th>
                                    </tr>
                                </thead>
                                <tbody className="divide-y divide-gray-200 dark:divide-gray-700">
                                    {leads.map((lead) => (
                                        <tr key={lead.id} className="hover:bg-gray-50 dark:hover:bg-gray-700">
                                            <td className="px-4 py-4 text-sm text-gray-900 dark:text-white">
                                                {lead.studentName}
                                            </td>
                                            <td className="px-4 py-4 text-sm text-gray-600 dark:text-gray-400">
                                                <div>{lead.mobile}</div>
                                                <div className="text-xs">{lead.email}</div>
                                            </td>
                                            <td className="px-4 py-4 text-sm text-gray-600 dark:text-gray-400">
                                                {lead.interestedCourse}
                                                {lead.interestedSpecialization && (
                                                    <div className="text-xs">({lead.interestedSpecialization})</div>
                                                )}
                                            </td>
                                            <td className="px-4 py-4 text-sm text-gray-600 dark:text-gray-400">
                                                {lead.collegeName || 'N/A'}
                                            </td>
                                            <td className="px-4 py-4">
                                                <span className={`badge ${getStatusColor(lead.status)}`}>
                                                    {lead.status}
                                                </span>
                                            </td>
                                            <td className="px-4 py-4 text-sm text-gray-600 dark:text-gray-400">
                                                {new Date(lead.createdAt).toLocaleDateString()}
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
};

const StatCard = ({ icon: Icon, title, value, color }) => (
    <div className="card p-6">
        <div className="flex items-center justify-between">
            <div>
                <p className="text-sm text-gray-600 dark:text-gray-400 mb-1">{title}</p>
                <p className="text-3xl font-bold text-gray-900 dark:text-white">{value}</p>
            </div>
            <div className={`w-16 h-16 bg-gradient-to-br ${color} rounded-full flex items-center justify-center`}>
                <Icon className="w-8 h-8 text-white" />
            </div>
        </div>
    </div>
);

const getStatusColor = (status) => {
    switch (status) {
        case 'NEW':
            return 'badge-info';
        case 'CONTACTED':
            return 'badge-warning';
        case 'QUALIFIED':
        case 'CONVERTED':
            return 'badge-success';
        default:
            return 'bg-gray-100 text-gray-800 dark:bg-gray-700 dark:text-gray-300';
    }
};

export default AdminDashboard;
