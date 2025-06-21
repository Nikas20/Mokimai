import { useState } from "react";
import { useNavigate } from "react-router";
import api from "../utils/api";

export const FeedbackForm = ({ tourId, userId, onSuccess }) => {
   const navigate = useNavigate();
  const [rating, setRating] = useState(5);
  const [comment, setComment] = useState("");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setSuccess("");

    if (!rating || rating < 1 || rating > 10) {
      setError("Rating must be between 1 and 10.");
      return;
    }

    try {
      await api.post("/feedback", {
        tourId,
        userId,
        rating,
        comment,
      });
      setSuccess("Feedback submitted!");
      setComment("");
      setRating(5);
      onSuccess?.();
      navigate("/tour");
    } catch (err) {
      setError("Error while submitting feedback.");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-4 mt-6">
      <h3 className="text-lg font-bold">Leave Feedback</h3>

      <div>
        <label className="block font-medium">Rating (1–5)</label>
        <input
          type="number"
          min="1"
          max="5"
          value={rating}
          onChange={(e) => setRating(Number(e.target.value))}
          className="input input-bordered w-full"
        />
      </div>

      <div>
        <label className="block font-medium">Comment (optional)</label>
        <textarea
          rows="3"
          value={comment}
          onChange={(e) => setComment(e.target.value)}
          className="input input-bordered w-full"
        />
      </div>

      <button type="submit" className="btn btn-primary">
        Submit Feedback
      </button>

      {error && <p className="text-red-500">{error}</p>}
      {success && <p className="text-green-600">{success}</p>}
    </form>
  );
};
