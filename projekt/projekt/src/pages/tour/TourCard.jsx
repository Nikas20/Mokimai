import { useParams } from "react-router";
import { useState, useEffect } from "react";
import api from "../../utils/api.js";
import { Error } from "../../components/Error.jsx";

export const TourCard = () => {
  const { id } = useParams();
  const [tour, setTour] = useState();
  const [error, setError] = useState();
  const [loading, setLoading] = useState();

  useEffect(() => {
    const fetchTour = async () => {
      try {
        setLoading(true);
        const response = await api.get(`/tour/${id}`);
        console.log(await api.get(`/tour/${id}`));
        
        setTour(response.data);
      } catch (err) {
        setError(err.response?.data || err.message);
      } finally {
        setLoading(false);
      }
    };
    fetchTour();
  }, [id]);

  if (loading) return <p>Loading tour...</p>;
  if (error) return <Error message={error} />;
  if (!tour) return <p>Tour not found</p>;

  return (
    <div className="card card-side shadow-sm bg-[#6A7AFF] text-[#FFFFFF] p-4">
      <h2 className="card-title">{tour.title}</h2>
      <p>{tour.description}</p>
      <img src={tour.photo_url} alt={tour.title} />
      <p>Duration: {tour.duration_minutes} minutes</p>
      <p>Price: ${tour.price}</p>
      <p>Max Participants: {tour.max_participants}</p>
      <p>Average Rating: {tour.average_rating}</p>
      {/* Add more details as needed */}
    </div>
  );
};