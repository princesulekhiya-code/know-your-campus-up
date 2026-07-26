import SEO from '../components/SEO';

const PrivacyPolicy = () => {
    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 py-12 px-4">
            <SEO
                title="Privacy Policy | Know Your Campus"
                description="Official Privacy Policy for Know Your Campus educational discovery platform managed by Mr Prince Sulekhiya."
            />
            <div className="max-w-4xl mx-auto bg-white dark:bg-gray-800 rounded-2xl p-8 shadow-md border border-gray-200 dark:border-gray-700 text-gray-800 dark:text-gray-200">
                <h1 className="text-3xl md:text-4xl font-bold mb-6 text-brand-900 dark:text-white">Privacy Policy</h1>
                <p className="text-sm text-gray-500 mb-6">Last updated: July 2026</p>

                <div className="space-y-6 text-sm md:text-base leading-relaxed">
                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">1. Information We Collect</h2>
                        <p>Know Your Campus collects student details (name, email, phone number, state, interested courses) only when voluntarily submitted via admission inquiry forms to assist with college selection and counselling.</p>
                    </section>

                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">2. Use of Information</h2>
                        <p>Student information is strictly used to connect candidates with verified academic counsellors and participating educational institutions for admission guidance.</p>
                    </section>

                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">3. Brand & Data Security</h2>
                        <p>All user data is processed securely. We do not sell or lease student data to unauthorized third-party advertisers.</p>
                    </section>

                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">4. Contact Us</h2>
                        <p>For privacy queries, contact <strong>Mr Prince Sulekhiya</strong> via phone at <strong>+91-9009536046</strong> or via official contact channels.</p>
                    </section>
                </div>
            </div>
        </div>
    );
};

export default PrivacyPolicy;
