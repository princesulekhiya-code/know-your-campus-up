import { useEffect, useState } from 'react';
import { FiUsers, FiBook, FiTrendingUp, FiEye } from 'react-icons/fi';
import analyticsService from '../../services/analyticsService';
import leadService from '../../services/leadService';
import LoadingSpinner from '../../components/LoadingSpinner';

const AnalyticsDashboard = () => {
    const [dashboard, setDashboard] = useState(null);
    const [loading, setLoading] = useState(true);
    const [leads, setLeads] = useState([]);

    useEffect(() => {
        loadDashboardData();
    }, []);

    const loadDashboardData = async () => {
        try {
            const [dashboardRes, leadsRes] = await Promise.all([
                analyticsService.getDashboard(),
                leadService.getAll(),
            ]);
            setDashboard(dashboardRes.data);
            setLeads(leadsRes.data);
        } catch (error) {
            // Silently handle errors (403 when not authenticated, etc.)
            // Only log non-403 errors
            if (error.response?.status !== 403) {
                console.error('Failed to load dashboard:', error);
            }
            setDashboard({
                totalColleges: 0,
                totalCourses: 0,
                totalLeads: 0,
                newLeadsToday: 0,
                leadsByStatus: {},
                mostViewedColleges: {},
                totalPageViews: 0,
                pageViewsToday: 0
            });
        } finally {
            setLoading(false);
        }
    };

    if (loading) return <LoadingSpinner />;
    if (!dashboard) return <div>Failed to load dashboard</div>;

    return (
        <div className="space-y-8">
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Analytics Overview</h1>

            {/* Stats Grid */}
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
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

                {/* Page Views Logic was weird in original, simplified here */}
                <div className="card p-6">
                    <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-4">
                        Traffic Stats
                    </h3>
                    <div className="space-y-4">
                        <div className="flex justify-between items-center border-b border-gray-100 dark:border-gray-700 pb-2">
                            <span className="text-gray-600 dark:text-gray-400">Total Page Views</span>
                            <span className="font-bold text-2xl text-primary-600">{dashboard.totalPageViews}</span>
                        </div>
                        <div className="flex justify-between items-center">
                            <span className="text-gray-600 dark:text-gray-400">Views Today</span>
                            <span className="font-bold text-2xl text-green-600">{dashboard.pageViewsToday}</span>
                        </div>
                    </div>
                </div>
            </div>

            {/* Recent Leads Table (Simplified preview) */}
            <div className="card p-6">
                <h3 className="text-xl font-bold text-gray-900 dark:text-white mb-6">Recent Leads</h3>
                <div className="overflow-x-auto">
                    <table className="w-full">
                        <thead className="bg-gray-50 dark:bg-gray-700">
                            <tr>
                                <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">Name</th>
                                <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">Status</th>
                                <th className="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase">Date</th>
                            </tr>
                        </thead>
                        <tbody className="divide-y divide-gray-200 dark:divide-gray-700">
                            {leads.slice(0, 5).map((lead) => (
                                <tr key={lead.id}>
                                    <td className="px-4 py-4 text-sm text-gray-900 dark:text-white">{lead.studentName}</td>
                                    <td className="px-4 py-4"><span className={`badge ${getStatusColor(lead.status)}`}>{lead.status}</span></td>
                                    <td className="px-4 py-4 text-sm text-gray-600 dark:text-gray-400">{new Date(lead.createdAt).toLocaleDateString()}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
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
        case 'NEW': return 'badge-info';
        case 'CONTACTED': return 'badge-warning';
        case 'QUALIFIED':
        case 'CONVERTED': return 'badge-success';
        default: return 'bg-gray-100 text-gray-800 dark:bg-gray-700 dark:text-gray-300';
    }
};

export default AnalyticsDashboard;
