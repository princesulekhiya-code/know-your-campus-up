import { useState } from 'react';
import { FiStar } from 'react-icons/fi';

const StarRating = ({
    rating = 0,
    size = 20,
    editable = false,
    onChange = () => { },
    showLabel = false
}) => {
    const [hoverRating, setHoverRating] = useState(0);

    const handleClick = (star) => {
        if (editable) {
            onChange(star);
        }
    };

    const handleMouseEnter = (star) => {
        if (editable) {
            setHoverRating(star);
        }
    };

    const handleMouseLeave = () => {
        if (editable) {
            setHoverRating(0);
        }
    };

    const displayRating = editable ? (hoverRating || rating) : rating;

    return (
        <div className="flex items-center space-x-1">
            {[1, 2, 3, 4, 5].map((star) => (
                <FiStar
                    key={star}
                    size={size}
                    className={`transition-colors ${star <= displayRating
                            ? 'text-yellow-400 fill-yellow-400'
                            : 'text-gray-300 dark:text-gray-600'
                        } ${editable ? 'cursor-pointer hover:scale-110 transition-transform' : ''}`}
                    onClick={() => handleClick(star)}
                    onMouseEnter={() => handleMouseEnter(star)}
                    onMouseLeave={handleMouseLeave}
                />
            ))}
            {showLabel && (
                <span className="ml-2 text-sm font-medium text-gray-700 dark:text-gray-300">
                    {displayRating > 0 ? `${displayRating}/5` : 'Not rated'}
                </span>
            )}
        </div>
    );
};

export default StarRating;
