import { useParams } from "react-router";
import { useEffect, useState } from "react";
import api from "../../utils/api";
import { Error } from "../../components/Error.jsx";
import { bookTour } from "../../utils/helper/Tourservices";
import { useAuth } from "../../context/AuthContext";
import { FeedbackForm } from "../../components/FeedbackForm.jsx";
import { useNavigate } from "react-router";

export const TourDetails = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [tour, setTour] = useState(null);
  const [dates, setDates] = useState([]);
  const [selectedDateId, setSelectedDateId] = useState("");
  const [error, setError] = useState(null);
  const [successMsg, setSuccessMsg] = useState("");
  const { account } = useAuth();
  const userId = account?.account_id;

  useEffect(() => {
    api.get(`/tour/${id}`)
      .then(res => setTour(res.data))
      .catch(err => setError(err.response?.data || err.message));
  }, [id]);

  useEffect(() => {
    api.get(`/tour/${id}/dates`)
      .then(res => setDates(res.data))
      .catch(err => setError(err.response?.data || err.message));
  }, [id]);

  const handleBooking = async () => {
    setError(null);
    setSuccessMsg("");

    try {
      await bookTour(userId, selectedDateId);
      setSuccessMsg("Sekmingai užsiregistravote į ekskursiją!");
      navigate("/tour");
    } catch (err) {
      setError(err.response?.data || err.message);
    }
  };

  if (error && !successMsg) return <Error error={error} isHidden={!error} />;
  if (!tour) return <p>Loading...</p>;

  const checkRoleUser = () => {
    return (
      account !== null &&
      account.scope !== null &&
      account.scope.includes("ROLE_USER")
    );
  };

  return (
    <div className="max-w-xl mx-auto p-4 bg-white rounded shadow text-black">
      <h1 className="text-2xl font-bold mb-4">{tour.title}</h1>

      {tour.photo_url && (
        <img
          src={tour.photo_url}
          alt={tour.title}
          className="rounded mb-4 max-h-60 object-cover w-full"
        />
      )}

      <p className="mb-2">{tour.description}</p>
      <p><strong>Duration:</strong> {tour.duration_minutes} min</p>
      <p><strong>Price:</strong> {tour.price} €</p>

      {tour.categories?.length > 0 && (
  <div className="mt-4">
    <p className="font-semibold">Categories:</p>
    <ul className="list-disc list-inside text-sm">
      {tour.categories.map((cat) => (
        <li key={cat.id}>
          {cat.categoryName.replace(/^CATEGORY_/, '')}
        </li>
      ))}
    </ul>
  </div>
)}

      <div className="mt-4">
        <label htmlFor="date" className="block font-medium mb-1">Pasirinkite datą:</label>
        <select
          id="date"
          className="input input-bordered w-full"
          value={selectedDateId}
          onChange={(e) => setSelectedDateId(e.target.value)}
        >
          <option value="" disabled hidden>-- pasirinkite datą --</option>
          {dates.map((d) => (
            <option key={d.id} value={d.id}>
              {new Date(d.date).toLocaleDateString("lt-LT")}
            </option>
          ))}
        </select>
      </div>

      {checkRoleUser() && (
        <button
          disabled={!selectedDateId}
          onClick={handleBooking}
          className="btn btn-primary mt-4"
        >
          Užsiregistruoti
        </button>
      )}

      {successMsg && (
        <p className="mt-4 text-green-600 font-semibold">{successMsg}</p>
      )}

      {account && (
        <div className="mt-8">
          <h3 className="text-lg font-bold mb-2">Palikite atsiliepimą:</h3>
          <FeedbackForm
            tourId={tour.id}
            userId={userId}
            onSuccess={() => console.log("Atsiliepimas pateiktas")}
          />
        </div>
      )}
    </div>
  );
};
