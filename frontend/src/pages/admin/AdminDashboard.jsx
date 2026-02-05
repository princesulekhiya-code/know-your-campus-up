import { useEffect } from 'react';
import { useNavigate, NavLink, Outlet, Link } from 'react-router-dom';
import { FiTrendingUp, FiLogOut, FiBell, FiServer, FiHome, FiBookOpen, FiMessageSquare } from 'react-icons/fi';
import { useAuth } from '../../context/AuthContext';

const AdminDashboard = () => {
    const { isAuthenticated, logout, user } = useAuth();
    const navigate = useNavigate();

    useEffect(() => {
        if (!isAuthenticated) {
            navigate('/login');
        }
    }, [isAuthenticated, navigate]);

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    if (!isAuthenticated) return null;

    return (
        <div className="flex h-screen bg-gray-50 dark:bg-gray-900 overflow-hidden">
            {/* Sidebar */}
            <div className="w-64 bg-white dark:bg-gray-800 border-r border-gray-200 dark:border-gray-700 flex flex-col hidden md:flex">
                <div className="p-6 border-b border-gray-200 dark:border-gray-700">
                    <h1 className="text-xl font-bold text-gray-900 dark:text-white">Admin Portal</h1>
                    <p className="text-xs text-gray-500 dark:text-gray-400 mt-1">
                        {user?.fullName}
                    </p>
                </div>
                <nav className="flex-1 p-4 space-y-2 overflow-y-auto">
                    <Link
                        to="/"
                        className="flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors text-gray-600 dark:text-gray-400 hover:bg-gray-50 dark:hover:bg-gray-800 border-b border-gray-200 dark:border-gray-700 mb-2"
                    >
                        <FiHome className="w-5 h-5" />
                        <span>Back to Home</span>
                    </Link>
                    <NavLink
                        to="/admin"
                        end
                        className={({ isActive }) =>
                            `flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${isActive
                                ? 'bg-primary-50 text-primary-600 dark:bg-primary-900/20 dark:text-primary-400 font-medium'
                                : 'text-gray-600 dark:text-gray-400 hover:bg-gray-50 dark:hover:bg-gray-800'
                            }`
                        }
                    >
                        <FiTrendingUp className="w-5 h-5" />
                        <span>Analytics</span>
                    </NavLink>
                    <NavLink
                        to="/admin/colleges"
                        className={({ isActive }) =>
                            `flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${isActive
                                ? 'bg-primary-50 text-primary-600 dark:bg-primary-900/20 dark:text-primary-400 font-medium'
                                : 'text-gray-600 dark:text-gray-400 hover:bg-gray-50 dark:hover:bg-gray-800'
                            }`
                        }
                    >
                        <FiServer className="w-5 h-5" />
                        <span>Manage Colleges</span>
                    </NavLink>
                    <NavLink
                        to="/admin/courses"
                        className={({ isActive }) =>
                            `flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${isActive
                                ? 'bg-primary-50 text-primary-600 dark:bg-primary-900/20 dark:text-primary-400 font-medium'
                                : 'text-gray-600 dark:text-gray-400 hover:bg-gray-50 dark:hover:bg-gray-800'
                            }`
                        }
                    >
                        <FiBookOpen className="w-5 h-5" />
                        <span>Manage Courses</span>
                    </NavLink>
                    <NavLink
                        to="/admin/reviews"
                        className={({ isActive }) =>
                            `flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${isActive
                                ? 'bg-primary-50 text-primary-600 dark:bg-primary-900/20 dark:text-primary-400 font-medium'
                                : 'text-gray-600 dark:text-gray-400 hover:bg-gray-50 dark:hover:bg-gray-800'
                            }`
                        }
                    >
                        <FiMessageSquare className="w-5 h-5" />
                        <span>Manage Reviews</span>
                    </NavLink>
                    <NavLink
                        to="/admin/notifications"
                        className={({ isActive }) =>
                            `flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${isActive
                                ? 'bg-primary-50 text-primary-600 dark:bg-primary-900/20 dark:text-primary-400 font-medium'
                                : 'text-gray-600 dark:text-gray-400 hover:bg-gray-50 dark:hover:bg-gray-800'
                            }`
                        }
                    >
                        <FiBell className="w-5 h-5" />
                        <span>Notifications</span>
                    </NavLink>
                </nav>
                <div className="p-4 border-t border-gray-200 dark:border-gray-700">
                    <button
                        onClick={handleLogout}
                        className="flex items-center space-x-3 px-4 py-2 w-full text-red-600 hover:bg-red-50 dark:hover:bg-red-900/20 rounded-lg transition-colors"
                    >
                        <FiLogOut className="w-5 h-5" />
                        <span>Logout</span>
                    </button>
                </div>
            </div>

            {/* Mobile Header */}
            <div className="md:hidden fixed top-0 left-0 right-0 bg-white dark:bg-gray-800 z-50 border-b border-gray-200 dark:border-gray-700 p-4 flex justify-between items-center">
                <h1 className="text-lg font-bold text-gray-900 dark:text-white">Admin Portal</h1>
                <button onClick={handleLogout} className="text-red-500"><FiLogOut /></button>
            </div>

            {/* Main Content Area */}
            <div className="flex-1 overflow-auto pt-16 md:pt-0">
                <div className="p-4 md:p-8">
                    <Outlet />
                </div>
            </div>
        </div>
    );
};

export default AdminDashboard;
