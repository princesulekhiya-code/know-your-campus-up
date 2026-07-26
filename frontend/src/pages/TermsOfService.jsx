import SEO from '../components/SEO';

const TermsOfService = () => {
    return (
        <div className="min-h-screen bg-gray-50 dark:bg-gray-900 py-12 px-4">
            <SEO
                title="Terms of Service & Brand Ownership | Know Your Campus"
                description="Official Terms of Service and Intellectual Property Ownership for Know Your Campus by Mr Prince Sulekhiya."
            />
            <div className="max-w-4xl mx-auto bg-white dark:bg-gray-800 rounded-2xl p-8 shadow-md border border-gray-200 dark:border-gray-700 text-gray-800 dark:text-gray-200">
                <h1 className="text-3xl md:text-4xl font-bold mb-6 text-brand-900 dark:text-white">Terms of Service & Legal Notice</h1>
                <p className="text-sm text-gray-500 mb-6">Last updated: July 2026</p>

                <div className="space-y-6 text-sm md:text-base leading-relaxed">
                    <section className="bg-brand-50 dark:bg-brand-900/40 p-4 rounded-xl border border-brand-200 dark:border-brand-700">
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">1. Intellectual Property & Brand Ownership</h2>
                        <p>
                            <strong>"Know Your Campus"™</strong> and its associated logos, website designs, search algorithms, databases, and content are the sole intellectual property of <strong>Mr. Prince Sulekhiya</strong>.
                            Unauthorized reproduction, cloning, or commercial use of the brand name or assets is strictly illegal and subject to prosecution under Indian Intellectual Property & Copyright Laws.
                        </p>
                    </section>

                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">2. Use of Platform</h2>
                        <p>This platform provides educational information, admission guidance, seat matrices, and fee details to help students evaluate colleges in India.</p>
                    </section>

                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">3. Accuracy of Data</h2>
                        <p>While we strive to provide 100% accurate college admission, fee, and cutoff information, students are advised to confirm final fee structures and seat matrices during official state counselling (MP DTE / MP DME).</p>
                    </section>

                    <section>
                        <h2 className="text-xl font-bold text-gray-900 dark:text-white mb-2">4. Managing Director Contact</h2>
                        <p>Official Platform Owner: <strong>Mr Prince Sulekhiya</strong> (Contact: 9009536046).</p>
                    </section>
                </div>
            </div>
        </div>
    );
};

export default TermsOfService;
