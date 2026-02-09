import { BrowserRouter as Router, Routes, Route, Outlet, Navigate } from 'react-router-dom';
import { HelmetProvider } from 'react-helmet-async';
import { AuthProvider } from './context/AuthContext';
import { ThemeProvider } from './context/ThemeContext';
import { Toaster } from 'react-hot-toast';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import WhatsAppButton from './components/WhatsAppButton';
import AnimatedBackground from './components/AnimatedBackground';
import ExamNotificationBar from './components/ExamNotificationBar';
import ProtectedRoute from './components/ProtectedRoute';
import ScrollToTop from './components/ScrollToTop';

// Pages
import Home from './pages/Home';
import Colleges from './pages/Colleges';
import CollegeDetails from './pages/CollegeDetails';
import CompareColleges from './pages/CompareColleges';
import AdmissionForm from './pages/AdmissionForm';
import Contact from './pages/Contact';
import Login from './pages/Login';

// Admin Pages
import AdminDashboard from './pages/admin/AdminDashboard';
import AnalyticsDashboard from './pages/admin/AnalyticsDashboard';
import ManageNotifications from './pages/admin/ManageNotifications';
import ManageColleges from './pages/admin/ManageColleges';
import ManageCourses from './pages/admin/ManageCourses';
import ManageReviews from './pages/admin/ManageReviews';

// Layout for Public Pages
const PublicLayout = () => (
    <div className="min-h-screen flex flex-col relative">
        <AnimatedBackground />
        <ExamNotificationBar />
        <Navbar />
        <main className="flex-grow">
            <Outlet />
        </main>
        <Footer />
        <WhatsAppButton />
    </div>
);

function App() {
    return (
        <HelmetProvider>
            <ThemeProvider>
                <AuthProvider>
                    <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>
                        <ScrollToTop />
                        <Toaster position="top-right" />
                        <Routes>
                            {/* Public Routes wrapped in PublicLayout */}
                            <Route element={<PublicLayout />}>
                                <Route path="/" element={<Home />} />
                                <Route path="/colleges" element={<Colleges />} />
                                <Route path="/colleges/:id" element={<CollegeDetails />} />
                                <Route path="/compare" element={<CompareColleges />} />
                                <Route path="/admission" element={<AdmissionForm />} />
                                <Route path="/contact" element={<Contact />} />
                                <Route path="/login" element={<Login />} />
                            </Route>

                            {/* Admin Routes - No Public Headers/Footers */}
                            <Route
                                path="/admin"
                                element={
                                    <ProtectedRoute role="ADMIN">
                                        <AdminDashboard />
                                    </ProtectedRoute>
                                }
                            >
                                <Route index element={<AnalyticsDashboard />} />
                                <Route path="dashboard" element={<Navigate to="/admin" replace />} />
                                <Route path="notifications" element={<ManageNotifications />} />
                                <Route path="colleges" element={<ManageColleges />} />
                                <Route path="courses" element={<ManageCourses />} />
                                <Route path="reviews" element={<ManageReviews />} />
                            </Route>
                        </Routes>
                    </Router>
                </AuthProvider>
            </ThemeProvider>
        </HelmetProvider>
    );
}

export default App;

