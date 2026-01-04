import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import { ThemeProvider } from './context/ThemeContext';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import WhatsAppButton from './components/WhatsAppButton';
import AnimatedBackground from './components/AnimatedBackground';
import ExamNotificationBar from './components/ExamNotificationBar';
import Home from './pages/Home';
import Colleges from './pages/Colleges';
import CollegeDetails from './pages/CollegeDetails';
import CompareColleges from './pages/CompareColleges';
import AdmissionForm from './pages/AdmissionForm';
import Contact from './pages/Contact';
import Login from './pages/Login';
import AdminDashboard from './pages/admin/AdminDashboard';

function App() {
    return (
        <ThemeProvider>
            <AuthProvider>
                <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>
                    <div className="min-h-screen flex flex-col relative">
                        <AnimatedBackground />
                        <ExamNotificationBar />
                        <Navbar />
                        <main className="flex-grow">
                            <Routes>
                                <Route path="/" element={<Home />} />
                                <Route path="/colleges" element={<Colleges />} />
                                <Route path="/colleges/:id" element={<CollegeDetails />} />
                                <Route path="/compare" element={<CompareColleges />} />
                                <Route path="/admission" element={<AdmissionForm />} />
                                <Route path="/contact" element={<Contact />} />
                                <Route path="/login" element={<Login />} />
                                <Route path="/admin/dashboard" element={<AdminDashboard />} />
                            </Routes>
                        </main>
                        <Footer />
                        <WhatsAppButton />
                    </div>
                </Router>
            </AuthProvider>
        </ThemeProvider>
    );
}

export default App;

